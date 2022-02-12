package org.jenkinsci.plugins.gitchangelog.steps;

import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.base.Strings.nullToEmpty;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import hudson.Extension;
import hudson.FilePath;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import jenkins.security.MasterToSlaveCallable;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.api.exceptions.GitChangelogRepositoryException;

public class GetHighestSemanticVersionStep extends Step implements Serializable {

  private static final long serialVersionUID = 795555442767777209L;
  private String repo;

  public String getRepo() {
    return this.repo;
  }

  @DataBoundSetter
  public void setRepo(final String repo) {
    this.repo = emptyToNull(repo);
  }

  @DataBoundConstructor
  public GetHighestSemanticVersionStep() {}

  @Extension
  public static class DescriptorImpl extends GitChangelogStepDescriptor {
    public DescriptorImpl() {
      super(
          "getHighestSemanticVersion",
          "Get the highest version, determined by tags in repo. Also tag available as '.findTag().orElse(\"\")'.");
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
                return GetHighestSemanticVersionStep.this.perform(workspace);
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
    return b.getHighestSemanticVersion();
  }
}
