package de.wellnerbou.jenkins.gitchangelog.callable;

import de.wellnerbou.gitchangelog.app.GitChangelog;
import de.wellnerbou.gitchangelog.app.GitChangelogArgs;
import de.wellnerbou.gitchangelog.model.Changelog;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import jenkins.security.MasterToSlaveCallable;
import org.apache.commons.lang.CharEncoding;

public class GitChangelogMasterToSlaveCallable extends MasterToSlaveCallable<String, IOException>
    implements Serializable {
  private final GitChangelogArgs gitChangelogArgs;

  public GitChangelogMasterToSlaveCallable(final GitChangelogArgs gitChangelogArgs) {
    this.gitChangelogArgs = gitChangelogArgs;
  }

  @Override
  @SuppressFBWarnings("DM_DEFAULT_ENCODING")
  public String call() throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos)) {
      final GitChangelog gitChangelog = new GitChangelog(gitChangelogArgs, ps);
      final Changelog changelog = gitChangelog.changelog();
      gitChangelog.print(changelog);
      return baos.toString(CharEncoding.UTF_8);
    }
  }
}
