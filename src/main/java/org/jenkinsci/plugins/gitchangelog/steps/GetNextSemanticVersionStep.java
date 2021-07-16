package org.jenkinsci.plugins.gitchangelog.steps;

import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Strings.nullToEmpty;
import static org.jenkinsci.plugins.gitchangelog.steps.config.REF_TYPE.COMMIT;
import static org.jenkinsci.plugins.gitchangelog.steps.config.REF_TYPE.REF;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import hudson.Extension;
import hudson.FilePath;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import jenkins.security.MasterToSlaveCallable;
import org.jenkinsci.plugins.gitchangelog.steps.config.RefConfig;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.api.exceptions.GitChangelogRepositoryException;

public class GetNextSemanticVersionStep extends Step implements Serializable {

  private static final long serialVersionUID = 795555442767777209L;
  private String repo;

  private RefConfig from;

  private RefConfig to;

  private String majorPattern;
  private String minorPattern;

  public String getRepo() {
    return this.repo;
  }

  public RefConfig getFrom() {
    return this.from;
  }

  public RefConfig getTo() {
    return this.to;
  }

  @DataBoundSetter
  public void setFrom(final RefConfig from) {
    if (from == null || isNullOrEmpty(from.getValue())) {
      this.from = null;
    } else {
      this.from = from;
    }
  }

  @DataBoundSetter
  public void setTo(final RefConfig to) {
    if (to == null || isNullOrEmpty(to.getValue())) {
      this.to = null;
    } else {
      this.to = to;
    }
  }

  @DataBoundSetter
  public void setRepo(final String repo) {
    this.repo = emptyToNull(repo);
  }

  public String getMajorPattern() {
    return this.majorPattern;
  }

  @DataBoundSetter
  public void setMajorPattern(final String majorPattern) {
    this.majorPattern = emptyToNull(majorPattern);
  }

  public String getMinorPattern() {
    return this.minorPattern;
  }

  @DataBoundSetter
  public void setMinorPattern(final String minorPattern) {
    this.minorPattern = emptyToNull(minorPattern);
  }

  @DataBoundConstructor
  public GetNextSemanticVersionStep() {}

  @Extension
  public static class DescriptorImpl extends GitChangelogStepDescriptor {
    public DescriptorImpl() {
      super(
          "getNextSemanticVersion",
          "Next semantic version based on tags and conventional commits in Git repository");
    }
  }

  @Override
  public StepExecution start(final StepContext context) {
    return new SynchronousNonBlockingStepExecution<Object>(context) {

      private static final long serialVersionUID = 1L;

      @Override
      protected Object run() throws Exception {
        final FilePath workspace = context.get(FilePath.class);

        final MasterToSlaveCallable<Object, Exception> callable =
            new MasterToSlaveCallable<Object, Exception>() {
              private static final long serialVersionUID = 1L;

              @Override
              public Object call() throws Exception {
                return GetNextSemanticVersionStep.this.perform(workspace);
              }
            };

        return workspace.act(callable);
      }
    };
  }

  private Object perform(final FilePath workspace)
      throws ParseException, GitChangelogRepositoryException, IOException {
    final String remoteRepo = workspace.getRemote() + "/" + nullToEmpty(this.repo);
    final GitChangelogApi b =
        gitChangelogApiBuilder() //
            .withFromRepo(remoteRepo);
    if (emptyToNull(this.majorPattern) != null) {
      b.withSemanticMajorVersionPattern(this.majorPattern);
    }
    if (emptyToNull(this.minorPattern) != null) {
      b.withSemanticMinorVersionPattern(this.minorPattern);
    }
    if (this.from != null && this.from.getType() == COMMIT) {
      b.withFromCommit(this.from.getValue());
    }
    if (this.from != null && this.from.getType() == REF) {
      b.withFromRef(this.from.getValue());
    }
    if (this.to != null && this.to.getType() == COMMIT) {
      b.withToCommit(this.to.getValue());
    }
    if (this.to != null && this.to.getType() == REF) {
      b.withToRef(this.to.getValue());
    }
    return b.getNextSemanticVersion();
  }
}
