package org.jenkinsci.plugins.gitchangelog.perform;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static org.jenkinsci.plugins.gitchangelog.GitChangelogLogger.doLog;
import hudson.EnvVars;
import hudson.FilePath;
import hudson.model.TaskListener;
import hudson.model.Run;

import java.util.List;

import org.jenkinsci.plugins.gitchangelog.config.CustomIssue;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;

public class GitChangelogPerformer {

 public static void performerPerform(final GitChangelogConfig configUnexpanded, final Run<?, ?> build,
   final TaskListener listener, FilePath workspace) {
  try {
   EnvVars env = build.getEnvironment(listener);
   final GitChangelogConfig config = expand(configUnexpanded, env);
   listener.getLogger().println("---");
   listener.getLogger().println("--- Git Changelog ---");
   listener.getLogger().println("---");
   RemoteCallable remoteTask = new RemoteCallable(workspace.getRemote(), config);
   RemoteResult remoteResult = workspace.act(remoteTask);
   if (!isNullOrEmpty(remoteResult.getLeftSideTitle())) {
    build.addAction(new GitChangelogLeftsideBuildDecorator(remoteResult.getLeftSideTitle(), remoteResult
      .getLeftSideUrl()));
   }
   if (!isNullOrEmpty(remoteResult.getSummary())) {
    build.addAction(new GitChangelogSummaryDecorator(remoteResult.getSummary()));
   }
   doLog(listener, INFO, remoteResult.getLog());
  } catch (Exception e) {
   doLog(listener, SEVERE, e.getMessage(), e);
   return;
  }

 }

 /**
  * Makes sure any Jenkins variable, used in the configuration fields, are
  * evaluated.
  */
 private static GitChangelogConfig expand(GitChangelogConfig config, EnvVars environment) {
  GitChangelogConfig c = new GitChangelogConfig();

  c.setUseConfigFile(config.isUseConfigFile());
  c.setConfigFile(environment.expand(config.getConfigFile()));
  c.setFromType(environment.expand(config.getFromType()));
  c.setFromReference(environment.expand(config.getFromReference()));
  c.setToType(environment.expand(config.getToType()));
  c.setToReference(environment.expand(config.getToReference()));
  c.setUseSubDirectory(config.isUseSubDirectory());
  c.setSubDirectory(environment.expand(config.getSubDirectory()));
  c.setDateFormat(environment.expand(config.getDateFormat()));
  c.setTimeZone(environment.expand(config.getTimeZone()));
  c.setIgnoreCommitsIfMessageMatches(environment.expand(config.getIgnoreCommitsIfMessageMatches()));

  c.setUseJira(config.isUseJira());
  c.setJiraServer(environment.expand(config.getJiraServer()));
  c.setJiraIssuePattern(environment.expand(config.getJiraIssuePattern()));
  c.setJiraUsername(environment.expand(config.getJiraUsername()));
  c.setJiraPassword(environment.expand(config.getJiraPassword()));

  c.setUseGitHub(config.isUseGitHub());
  c.setGitHubApi(environment.expand(config.getGitHubApi()));
  c.setGitHubIssuePattern(environment.expand(config.getGitHubIssuePattern()));
  c.setGitHubToken(environment.expand(config.getGitHubToken()));

  c.setNoIssueName(environment.expand(config.getNoIssueName()));
  c.setIgnoreCommitsWithoutIssue(config.isIgnoreCommitsWithoutIssue());
  c.setUntaggedName(environment.expand(config.getUntaggedName()));
  c.setUseReadableTagName(config.isUseReadableTagName());
  c.setReadableTagName(environment.expand(config.getReadableTagName()));

  c.setUseIgnoreTagsIfNameMatches(config.isUseIgnoreTagsIfNameMatches());
  c.setIgnoreTagsIfNameMatches(environment.expand(config.getIgnoreTagsIfNameMatches()));

  c.setUseMediaWiki(config.isUseMediaWiki());
  c.setMediaWikiUsername(environment.expand(config.getMediaWikiUsername()));
  c.setMediaWikiPassword(environment.expand(config.getMediaWikiPassword()));
  c.setMediaWikiTitle(environment.expand(config.getMediaWikiTitle()));
  c.setMediaWikiUrl(environment.expand(config.getMediaWikiUrl()));
  c.setMediaWikiUseTemplateFile(config.isMediaWikiUseTemplateFile());
  c.setMediaWikiTemplateFile(environment.expand(config.getMediaWikiTemplateFile()));
  c.setMediaWikiUseTemplateContent(config.isMediaWikiUseTemplateContent());
  c.setMediaWikiTemplateContent(environment.expand(config.getMediaWikiTemplateContent()));

  c.setUseFile(config.isUseFile());
  c.setFile(environment.expand(config.getFile()));
  c.setCreateFileUseTemplateFile(config.isCreateFileUseTemplateFile());
  c.setCreateFileTemplateFile(environment.expand(config.getCreateFileTemplateFile()));
  c.setCreateFileUseTemplateContent(config.isCreateFileUseTemplateContent());
  c.setCreateFileTemplateContent(environment.expand(config.getCreateFileTemplateContent()));

  c.setShowSummary(config.showSummary());
  c.setShowSummaryUseTemplateFile(config.isShowSummaryUseTemplateFile());
  c.setShowSummaryTemplateFile(environment.expand(config.getShowSummaryTemplateFile()));
  c.setShowSummaryUseTemplateContent(config.isShowSummaryUseTemplateContent());
  c.setShowSummaryTemplateContent(environment.expand(config.getShowSummaryTemplateContent()));

  List<CustomIssue> expandedCi = newArrayList();
  for (CustomIssue ci : config.getCustomIssues()) {
   expandedCi.add(new CustomIssue(//
     environment.expand(ci.getName()),//
     environment.expand(ci.getPattern()),//
     environment.expand(ci.getLink()),//
     environment.expand(ci.getTitle())));
  }
  c.setCustomIssues(expandedCi);
  return c;
 }
}
