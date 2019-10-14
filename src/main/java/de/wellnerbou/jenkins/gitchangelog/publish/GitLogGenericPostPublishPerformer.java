package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.app.GitChangelogArgs;
import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.jenkins.gitchangelog.callable.GitChangelogMasterToSlaveCallable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.AbortException;
import hudson.EnvVars;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.remoting.Callable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class GitLogGenericPostPublishPerformer {

  private final ChangelogProcessor changelogProcessor;
  private final String outputfile;
  private final String fromRev;
  private final String toRev;

  public GitLogGenericPostPublishPerformer(
      final ChangelogProcessor changelogProcessor,
      final String outputfile,
      final String fromRev,
      final String toRev) {
    this.changelogProcessor = changelogProcessor;
    this.outputfile = outputfile;
    this.fromRev = fromRev;
    this.toRev = toRev;
  }

  @SuppressFBWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
  public boolean perform(final AbstractBuild<?, ?> build, final BuildListener listener)
      throws InterruptedException, IOException {
    final EnvVars env = build.getEnvironment(listener);
    final GitChangelogArgs gitChangelogArgs =
        createGitChangelogArgs(
            build.getWorkspace(),
            resolveAndExpandIfNotNull(fromRev, env),
            resolveAndExpandIfNotNull(toRev, env));
    final PrintStream printStream = decideForPrintStream(listener);
    final Callable<String, IOException> task =
        new GitChangelogMasterToSlaveCallable(gitChangelogArgs);
    final String result = build.getWorkspace().act(task);
    printStream.println(result);
    closePrintStreamIfWrittenToFile(printStream);
    return true;
  }

  private void closePrintStreamIfWrittenToFile(final PrintStream printStream) {
    if (shouldWriteToFile()) {
      printStream.close();
    }
  }

  private boolean shouldWriteToFile() {
    return outputfile != null && outputfile.length() > 0;
  }

  private PrintStream decideForPrintStream(final BuildListener listener)
      throws FileNotFoundException {
    PrintStream printStream = listener.getLogger();
    if (shouldWriteToFile()) {
      final File file = new File(outputfile);
      listener
          .getLogger()
          .println("Saving processed git changelog to file " + file.getAbsolutePath() + ".");
      try {
        printStream = new PrintStream(file, StandardCharsets.UTF_8.name());
      } catch (final UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
    }
    return printStream;
  }

  private GitChangelogArgs createGitChangelogArgs(
      final FilePath workspace, final String fromRev, final String toRev) throws AbortException {
    if (workspace == null) {
      throw new AbortException("no workspace");
    }
    final GitChangelogArgs gitChangelogArgs = new GitChangelogArgs();
    gitChangelogArgs.setChangelogProcessor(changelogProcessor);
    gitChangelogArgs.setRepo(workspace.getRemote());
    gitChangelogArgs.setToRev(toRev);
    gitChangelogArgs.setFromRev(fromRev);
    return gitChangelogArgs;
  }

  private String resolveAndExpandIfNotNull(final String value, final EnvVars env) {
    return value != null ? env.expand(value) : value;
  }
}
