package org.jenkinsci.plugins.gitchangelog;

import static hudson.tasks.BuildStepMonitor.NONE;
import static org.jenkinsci.plugins.gitchangelog.perform.GitChangelogPerformer.performerPerform;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import java.io.IOException;
import jenkins.tasks.SimpleBuildStep;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;
import org.kohsuke.stapler.DataBoundConstructor;

public class GitChangelogRecorder extends Recorder implements SimpleBuildStep {
  @Extension
  public static final BuildStepDescriptor<Publisher> DESCRIPTOR = new GitChangelogDescriptor();

  private GitChangelogConfig config;

  public GitChangelogRecorder() {}

  @DataBoundConstructor
  public GitChangelogRecorder(GitChangelogConfig config) {
    this.config = config;
  }

  public GitChangelogConfig getConfig() {
    return this.config;
  }

  @Override
  public BuildStepDescriptor<Publisher> getDescriptor() {
    return DESCRIPTOR;
  }

  @Override
  public BuildStepMonitor getRequiredMonitorService() {
    return NONE;
  }

  @Override
  public void perform(Run<?, ?> build, FilePath workspace, Launcher launcher, TaskListener listener)
      throws InterruptedException, IOException {
    performerPerform(this.config, build, listener, workspace);
  }

  public void setConfig(GitChangelogConfig config) {
    this.config = config;
  }
}
