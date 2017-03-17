package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;

public class GitLogGenericPostPublishPerformerBuilder {
  private ChangelogProcessor changelogProcessor;
  private String outputfile = null;
  private String fromRev = null;
  private String toRev = null;

  public GitLogGenericPostPublishPerformerBuilder setChangelogProcessor(
      final ChangelogProcessor changelogProcessor) {
    this.changelogProcessor = changelogProcessor;
    return this;
  }

  public GitLogGenericPostPublishPerformerBuilder writeTofile(final String outputfile) {
    this.outputfile = outputfile;
    return this;
  }

  public GitLogGenericPostPublishPerformerBuilder withFromRev(final String fromRev) {
    this.fromRev = fromRev;
    return this;
  }

  public GitLogGenericPostPublishPerformerBuilder withToRev(final String toRev) {
    this.toRev = toRev;
    return this;
  }

  public GitLogGenericPostPublishPerformer build() {
    return new GitLogGenericPostPublishPerformer(changelogProcessor, outputfile, fromRev, toRev);
  }
}
