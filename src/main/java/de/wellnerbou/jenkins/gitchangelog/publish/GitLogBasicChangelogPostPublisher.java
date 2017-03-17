package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.basic.BasicChangelogProcessor;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

public class GitLogBasicChangelogPostPublisher extends Publisher {

  public final String outputfile;
  public final String toRev;
  public final String fromRev;

  @DataBoundConstructor
  public GitLogBasicChangelogPostPublisher(
      final String outputfile, final String fromRev, final String toRev) {
    this.outputfile = outputfile;
    this.fromRev = fromRev;
    this.toRev = toRev;
  }

  @Override
  public BuildStepMonitor getRequiredMonitorService() {
    return BuildStepMonitor.NONE;
  }

  @Override
  public boolean perform(
      final AbstractBuild<?, ?> build, final Launcher launcher, final BuildListener listener)
      throws InterruptedException, IOException {
    final GitLogGenericPostPublishPerformer performer =
        new GitLogGenericPostPublishPerformerBuilder()
            .setChangelogProcessor(createChangelogProcessor())
            .withFromRev(fromRev)
            .withToRev(toRev)
            .writeTofile(outputfile)
            .build();
    performer.perform(build, listener);
    return true;
  }

  private ChangelogProcessor createChangelogProcessor() {
    return new BasicChangelogProcessor();
  }

  @Extension
  public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

    @Override
    public String getDisplayName() {
      return "Publish Git changelog";
    }

    @Override
    public boolean isApplicable(Class<? extends AbstractProject> jobType) {
      return true;
    }
  }
}
