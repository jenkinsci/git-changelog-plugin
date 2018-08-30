package org.jenkinsci.plugins.gitchangelog.steps.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.io.Serializable;
import org.kohsuke.stapler.DataBoundConstructor;

public class JiraConfig extends AbstractDescribableImpl<JiraConfig> implements Serializable {
  private static final long serialVersionUID = -2407705524441526456L;
  private final String server;
  private final String issuePattern;
  private final String username;
  private final String password;

  @Extension
  public static class DescriptorImpl extends Descriptor<JiraConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "Jira";
    }
  }

  @DataBoundConstructor
  public JiraConfig(
      final String server,
      final String issuePattern,
      final String username,
      final String password) {
    this.server = server;
    this.issuePattern = issuePattern;
    this.username = username;
    this.password = password;
  }

  public String getServer() {
    return server;
  }

  public String getIssuePattern() {
    return issuePattern;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
