package org.jenkinsci.plugins.gitchangelog.steps.config;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.umd.cs.findbugs.annotations.NonNull;

public class GitLabConfig extends AbstractDescribableImpl<GitLabConfig> implements Serializable {
  private static final long serialVersionUID = -8851592658630679192L;
  private final String server;
  private final String token;
  private final String issuePattern;
  private final String projectName;

  @Extension
  public static class DescriptorImpl extends Descriptor<GitLabConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "GitLab";
    }
  }

  @DataBoundConstructor
  public GitLabConfig(
      final String server,
      final String token,
      final String issuePattern,
      final String projectName) {
    this.server = server;
    this.token = token;
    this.issuePattern = issuePattern;
    this.projectName = projectName;
  }

  public String getServer() {
    return server;
  }

  public String getToken() {
    return token;
  }

  public String getIssuePattern() {
    return issuePattern;
  }

  public String getProjectName() {
    return projectName;
  }
}
