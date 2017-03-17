package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.jira.JiraFilterChangelogProcessor;
import hudson.EnvVars;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

public class GitLogJiraFilterPostPublisher extends Recorder {

  public final String jirabaseurl;
  public final String jiraprefix;
  public final String outputfile;
  public final String toRev;
  public final String fromRev;

  @DataBoundConstructor
  public GitLogJiraFilterPostPublisher(
      final String jirabaseurl,
      final String jiraprefix,
      final String outputfile,
      final String fromRev,
      final String toRev) {
    this.jirabaseurl = jirabaseurl;
    this.jiraprefix = jiraprefix;
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
            .setChangelogProcessor(createChangelogProcessor(build.getEnvironment(listener)))
            .withFromRev(fromRev)
            .withToRev(toRev)
            .writeTofile(outputfile)
            .build();
    performer.perform(build, listener);
    return true;
  }

  private ChangelogProcessor createChangelogProcessor(final EnvVars env) {
    final JiraFilterChangelogProcessor jiraFilterChangelogProcessor =
        new JiraFilterChangelogProcessor();
    jiraFilterChangelogProcessor.setJiraBaseUrl(env.expand(jirabaseurl));
    jiraFilterChangelogProcessor.setJiraProjectPrefixes(env.expand(jiraprefix));
    return jiraFilterChangelogProcessor;
  }

  @Extension
  public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

    @Override
    public String getDisplayName() {
      return "Publish JIRA Filter";
    }

    @Override
    public boolean isApplicable(Class<? extends AbstractProject> jobType) {
      return true;
    }
  }
}
