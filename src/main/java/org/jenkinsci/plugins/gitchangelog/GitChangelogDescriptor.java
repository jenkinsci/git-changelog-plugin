package org.jenkinsci.plugins.gitchangelog;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.createNewConfig;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.jenkinsci.plugins.gitchangelog.config.CustomIssue;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;
import org.kohsuke.stapler.StaplerRequest;

public final class GitChangelogDescriptor extends BuildStepDescriptor<Publisher> {
 private GitChangelogConfig config;

 public GitChangelogDescriptor() {
  super(GitChangelogRecorder.class);
  load();
  if (config == null) {
   this.config = createNewConfig();
  }
 }

 @Override
 public String getDisplayName() {
  return "Git Changelog";
 }

 @Override
 public String getHelpFile() {
  return super.getHelpFile();
 }

 @Override
 public Publisher newInstance(StaplerRequest req, JSONObject formData) throws hudson.model.Descriptor.FormException {
  GitChangelogConfig c = new GitChangelogConfig();
  c.setUseConfigFile(formData.getBoolean("useConfigFile"));
  c.setConfigFile(formData.getString("configFile"));
  c.setFromType(formData.getString("fromType"));
  c.setFromReference(formData.getString("fromReference"));
  c.setToType(formData.getString("toType"));
  c.setToReference(formData.getString("toReference"));
  c.setDateFormat(formData.getString("dateFormat"));
  c.setTimeZone(formData.getString("timeZone"));
  c.setIgnoreCommitsIfMessageMatches(formData.getString("ignoreCommitsIfMessageMatches"));

  c.setUseJira(formData.getBoolean("useJira"));
  c.setJiraServer(formData.getString("jiraServer"));
  c.setJiraIssuePattern(formData.getString("jiraIssuePattern"));
  c.setJiraUsername(formData.getString("jiraUsername"));
  c.setJiraPassword(formData.getString("jiraPassword"));

  c.setUseGitHub(formData.getBoolean("useGitHub"));
  c.setGitHubApi(formData.getString("gitHubApi"));
  c.setGitHubIssuePattern(formData.getString("gitHubIssuePattern"));
  c.setGitHubToken(formData.getString("gitHubToken"));

  c.setNoIssueName(formData.getString("noIssueName"));
  c.setIgnoreCommitsWithoutIssue(formData.getBoolean("ignoreCommitsWithoutIssue"));
  c.setUntaggedName(formData.getString("untaggedName"));
  c.setUseReadableTagName(formData.getBoolean("useReadableTagName"));
  c.setReadableTagName(formData.getString("readableTagName"));
  c.setUseMediaWiki(formData.getBoolean("useMediaWiki"));
  c.setMediaWikiUsername(formData.getString("mediaWikiUsername"));
  c.setMediaWikiPassword(formData.getString("mediaWikiPassword"));
  c.setMediaWikiTitle(formData.getString("mediaWikiTitle"));
  c.setMediaWikiUrl(formData.getString("mediaWikiUrl"));
  c.setUseFile(formData.getBoolean("useFile"));
  c.setFile(formData.getString("file"));
  c.setShowSummary(formData.getBoolean("showSummary"));

  c.setMediaWikiUseTemplateFile(formData.getBoolean("mediaWikiUseTemplateFile"));
  c.setMediaWikiTemplateFile(formData.getString("mediaWikiTemplateFile"));
  c.setMediaWikiUseTemplateContent(formData.getBoolean("mediaWikiUseTemplateContent"));
  c.setMediaWikiTemplateContent(formData.getString("mediaWikiTemplateContent"));

  c.setCreateFileUseTemplateFile(formData.getBoolean("createFileUseTemplateFile"));
  c.setCreateFileTemplateFile(formData.getString("createFileTemplateFile"));
  c.setCreateFileUseTemplateContent(formData.getBoolean("createFileUseTemplateContent"));
  c.setCreateFileTemplateContent(formData.getString("createFileTemplateContent"));

  c.setShowSummaryUseTemplateFile(formData.getBoolean("showSummaryUseTemplateFile"));
  c.setShowSummaryTemplateFile(formData.getString("showSummaryTemplateFile"));
  c.setShowSummaryUseTemplateContent(formData.getBoolean("showSummaryUseTemplateContent"));
  c.setShowSummaryTemplateContent(formData.getString("showSummaryTemplateContent"));

  c.setCustomIssues(new ArrayList<CustomIssue>());
  for (int i = 0; i < formData.getJSONArray("name").size(); i++) {
   String name = (String) formData.getJSONArray("name").get(i);
   String pattern = (String) formData.getJSONArray("pattern").get(i);
   String link = (String) formData.getJSONArray("link").get(i);
   String title = (String) formData.getJSONArray("title").get(i);
   if (!isNullOrEmpty(name) && !isNullOrEmpty(pattern)) {
    c.getCustomIssues().add(new CustomIssue(name, pattern, link, title));
   }
  }
  c.getCustomIssues().add(new CustomIssue("", "", "", ""));
  c.getCustomIssues().add(new CustomIssue("", "", "", ""));

  GitChangelogRecorder publisher = new GitChangelogRecorder();
  publisher.setConfig(c);
  return publisher;
 }

 @Override
 public boolean isApplicable(@SuppressWarnings("rawtypes") final Class<? extends AbstractProject> jobType) {
  return true;
 }

 /**
  * Create new blank configuration. Used when job is created.
  */
 public GitChangelogConfig getNewConfig() {
  return createNewConfig();
 }
}
