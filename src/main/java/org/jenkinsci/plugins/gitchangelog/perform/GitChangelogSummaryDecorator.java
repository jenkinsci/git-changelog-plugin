package org.jenkinsci.plugins.gitchangelog.perform;

import hudson.model.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = 2)
public class GitChangelogSummaryDecorator implements Action {
  private static Logger LOG = Logger.getLogger(GitChangelogSummaryDecorator.class.getSimpleName());

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
    try {
      return Jenkins.get().getMarkupFormatter().translate(this.text);
    } catch (IOException e) {
      LOG.log(Level.SEVERE, e.getMessage(), e);
      return "";
    }
  }

  @Override
  public String getUrlName() {
    return null;
  }
}
