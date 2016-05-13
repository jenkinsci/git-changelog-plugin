package org.jenkinsci.plugins.gitchangelog;

import static hudson.tasks.BuildStepMonitor.NONE;
import static java.lang.Boolean.TRUE;
import static org.jenkinsci.plugins.gitchangelog.perform.GitChangelogPerformer.performerPerform;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;

import java.io.IOException;

import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;

public class GitChangelogRecorder extends Recorder {
 @Extension
 public static final BuildStepDescriptor<Publisher> DESCRIPTOR = new GitChangelogDescriptor();
 private GitChangelogConfig config;

 public GitChangelogRecorder() {
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
 public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
   throws InterruptedException, IOException {
  performerPerform(this.config, build, listener);
  return TRUE;
 }

 public void setConfig(GitChangelogConfig config) {
  this.config = config;
 }
}
