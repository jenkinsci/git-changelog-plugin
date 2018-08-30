package de.wellnerbou.jenkins.gitchangelog.tokenmacro;

import de.wellnerbou.gitchangelog.app.GitChangelogArgs;
import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.jenkins.gitchangelog.callable.GitChangelogMasterToSlaveCallable;
import hudson.AbortException;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.TaskListener;
import java.io.IOException;
import org.jenkinsci.plugins.tokenmacro.DataBoundTokenMacro;
import org.jenkinsci.plugins.tokenmacro.MacroEvaluationException;

public abstract class GitLogTokenMacro extends DataBoundTokenMacro {

  @Override
  public String evaluate(
      final AbstractBuild<?, ?> build, final TaskListener taskListener, final String macroName)
      throws MacroEvaluationException, IOException, InterruptedException {
    final FilePath workspace = build.getWorkspace();
    if (workspace == null) {
      throw new AbortException("no workspace for " + build);
    }

    final GitChangelogArgs gitChangelogArgs = new GitChangelogArgs();
    final ChangelogProcessor changelogProcessor = createChangelogProcessor();
    gitChangelogArgs.setChangelogProcessor(changelogProcessor);
    gitChangelogArgs.setRepo(workspace.getRemote());

    final GitChangelogMasterToSlaveCallable task =
        new GitChangelogMasterToSlaveCallable(gitChangelogArgs);
    return build.getWorkspace().act(task);
  }

  protected abstract ChangelogProcessor createChangelogProcessor();
}
