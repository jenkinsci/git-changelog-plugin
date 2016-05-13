package org.jenkinsci.plugins.gitchangelog.perform;

import hudson.model.BuildBadgeAction;

import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = 2)
public class GitChangelogLeftsideBuildDecorator implements BuildBadgeAction {
 private final String text;
 private final String url;

 public GitChangelogLeftsideBuildDecorator(String text, String url) {
  this.text = text;
  this.url = url;
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

 @Exported
 public String getUrl() {
  return this.url;
 }

 @Override
 public String getUrlName() {
  return null;
 }

}
