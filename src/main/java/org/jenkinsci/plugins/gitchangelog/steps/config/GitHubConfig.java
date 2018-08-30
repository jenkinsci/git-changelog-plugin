package org.jenkinsci.plugins.gitchangelog.steps.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.io.Serializable;
import org.kohsuke.stapler.DataBoundConstructor;

public class GitHubConfig extends AbstractDescribableImpl<GitHubConfig> implements Serializable {

  private static final long serialVersionUID = 6697975254396703929L;
  private final String api;
  private final String token;
  private final String issuePattern;

  @Extension
  public static class DescriptorImpl extends Descriptor<GitHubConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "GitHub";
    }
  }

  @DataBoundConstructor
  public GitHubConfig(final String api, final String token, final String issuePattern) {
    this.api = api;
    this.token = token;
    this.issuePattern = issuePattern;
  }

  public String getApi() {
    return api;
  }

  public String getToken() {
    return token;
  }

  public String getIssuePattern() {
    return issuePattern;
  }
}
