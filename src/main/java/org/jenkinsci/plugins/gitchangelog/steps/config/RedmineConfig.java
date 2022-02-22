package org.jenkinsci.plugins.gitchangelog.steps.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.io.Serializable;
import org.kohsuke.stapler.DataBoundConstructor;

public class RedmineConfig extends AbstractDescribableImpl<RedmineConfig> implements Serializable {
  private static final long serialVersionUID = 1038551646703386319L;
  private final String server;
  private final String issuePattern;
  private final String username;
  private final String password;
  private final String token;

  @Extension
  public static class DescriptorImpl extends Descriptor<RedmineConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "Redmine";
    }
  }

  @DataBoundConstructor
  public RedmineConfig(
      final String server,
      final String issuePattern,
      final String username,
      final String password,
      final String token) {
    this.server = server;
    this.issuePattern = issuePattern;
    this.username = username;
    this.password = password;
    this.token = token;
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

  public String getToken() {
    return token;
  }
}
