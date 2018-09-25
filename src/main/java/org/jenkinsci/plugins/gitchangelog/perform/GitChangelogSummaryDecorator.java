package org.jenkinsci.plugins.gitchangelog.perform;

import hudson.markup.MarkupFormatter;
import hudson.markup.RawHtmlMarkupFormatter;
import hudson.model.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = 2)
public class GitChangelogSummaryDecorator implements Action {
  private static final MarkupFormatter sanitizer = new RawHtmlMarkupFormatter(true);
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
      return sanitizer.translate(this.text);
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
