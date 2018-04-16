package org.jenkinsci.plugins.gitchangelog.steps.config;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import edu.umd.cs.findbugs.annotations.NonNull;

public class CustomIssueConfig extends AbstractDescribableImpl<CustomIssueConfig>
    implements Serializable {
  private static final long serialVersionUID = 8842918044772949798L;
  private final String name;
  private final String issuePattern;
  private String title;
  private String link;

  @Extension
  public static class DescriptorImpl extends Descriptor<CustomIssueConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "Custom Issue";
    }
  }

  @DataBoundConstructor
  public CustomIssueConfig(final String name, final String issuePattern) {
    this.name = name;
    this.issuePattern = issuePattern;
  }

  @DataBoundSetter
  public void setTitle(final String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @DataBoundSetter
  public void setLink(final String link) {
    this.link = link;
  }

  public String getLink() {
    return link;
  }

  public String getName() {
    return name;
  }

  public String getIssuePattern() {
    return issuePattern;
  }
}
