package org.jenkinsci.plugins.gitchangelog.perform;

import hudson.model.Action;

import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = 2)
public class GitChangelogSummaryDecorator implements Action {
  private final String text;

  public GitChangelogSummaryDecorator(String text) {
    this.text = text;
  }

  @Override
  public String getDisplayName() {
    return null;
  }

  @Override
  public String getIconFileName() {
    return null;
  }

  @Exported
  public String getText() {
    return this.text;
  }

  @Override
  public String getUrlName() {
    return null;
  }
}
