package org.jenkinsci.plugins.gitchangelog.perform;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Throwables.propagate;
import static com.google.common.io.Files.write;
import static com.google.common.io.Resources.getResource;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.commit;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.firstCommit;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.master;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.ref;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import jenkins.security.MasterToSlaveCallable;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.jenkinsci.plugins.gitchangelog.config.CustomIssue;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE;
import org.jenkinsci.remoting.RoleChecker;

import se.bjurr.gitchangelog.api.GitChangelogApi;

public class RemoteCallable extends MasterToSlaveCallable<RemoteResult, IOException> implements Serializable {

 private static final long serialVersionUID = -2489061314794088231L;
 private final String workspacePath;
 private String path = new String();


 private final GitChangelogConfig config;

 public RemoteCallable(String workspacePath, GitChangelogConfig config) {
  
  this.workspacePath = workspacePath;
  this.config = config;
 }

 @Override
 public void checkRoles(RoleChecker checker) throws SecurityException {

 }

 @Override
 public RemoteResult call() throws IOException {
  RemoteResult remoteResult = new RemoteResult();
  StringBuilder logString = new StringBuilder();
   path = workspacePath;
   
   if (config.isUseSubDirectory()){
      path = workspacePath + "/" + config.getSubDirectory();
  } 
     
 
  try {
   GitChangelogApi gitChangelogApiBuilder = gitChangelogApiBuilder()//      
     .withFromRepo(path);

   if (config.isUseConfigFile() && !isNullOrEmpty(config.getConfigFile())) {
    try {
     gitChangelogApiBuilder.withSettings(getResource(workspacePath + "/" + config.getConfigFile()).toURI().toURL());
    } catch (URISyntaxException e) {
     propagate(e);
    }
   }

   gitChangelogApiBuilder //
     .withDateFormat(config.getDateFormat()) //
     .withIgnoreCommitsWithMesssage(config.getIgnoreCommitsIfMessageMatches()) //
     .withNoIssueName(config.getNoIssueName()) //
     .withIgnoreCommitsWithoutIssue(config.isIgnoreCommitsWithoutIssue())//
     .withTimeZone(config.getTimeZone()) //
     .withUntaggedName(config.getUntaggedName());

   if (config.isUseJira()) {
    gitChangelogApiBuilder //
      .withJiraServer(config.getJiraServer()) //
      .withJiraIssuePattern(config.getJiraIssuePattern()) //
      .withJiraUsername(config.getJiraUsername()) //
      .withJiraPassword(config.getJiraPassword());
   }

   if (config.isUseGitHub()) {
    gitChangelogApiBuilder //
      .withGitHubApi(config.getGitHubApi()) //
      .withGitHubIssuePattern(config.getGitHubIssuePattern()) //
      .withGitHubToken(config.getGitHubToken());
   }

   if (config.isUseReadableTagName() && !isNullOrEmpty(config.getReadableTagName())) {
    gitChangelogApiBuilder.withReadableTagName(config.getReadableTagName());
   }

   if (config.isUseIgnoreTagsIfNameMatches() && !isNullOrEmpty(config.getIgnoreTagsIfNameMatches())) {
    gitChangelogApiBuilder.withIgnoreTagsIfNameMatches(config.getIgnoreTagsIfNameMatches());
   }

   if (isNullOrEmpty(config.getFromType()) || FROMTYPE.valueOf(config.getFromType()) == firstCommit) {
    gitChangelogApiBuilder.withFromCommit(firstCommit.getReference());
   } else if (FROMTYPE.valueOf(config.getFromType()) == ref && !isNullOrEmpty(config.getFromReference())) {
    gitChangelogApiBuilder.withFromRef(config.getFromReference());
   } else if (FROMTYPE.valueOf(config.getFromType()) == commit && !isNullOrEmpty(config.getFromReference())) {
    gitChangelogApiBuilder.withFromCommit(config.getFromReference());
   } else {
    gitChangelogApiBuilder.withFromRef(firstCommit.getReference());
   }

   if (isNullOrEmpty(config.getToType()) || FROMTYPE.valueOf(config.getToType()) == master) {
    gitChangelogApiBuilder.withToRef(master.getReference());
   } else if (FROMTYPE.valueOf(config.getToType()) == ref && !isNullOrEmpty(config.getToReference())) {
    gitChangelogApiBuilder.withToRef(config.getToReference());
   } else if (FROMTYPE.valueOf(config.getToType()) == commit && !isNullOrEmpty(config.getToReference())) {
    gitChangelogApiBuilder.withToCommit(config.getToReference());
   } else {
    gitChangelogApiBuilder.withToRef(firstCommit.getReference());
   }

   for (CustomIssue ci : config.getCustomIssues()) {
    if (!isNullOrEmpty(ci.getName()) && !isNullOrEmpty(ci.getPattern())) {
     gitChangelogApiBuilder.withCustomIssue(ci.getName(), ci.getPattern(), ci.getLink(), ci.getTitle());
    }
   }

   if (config.showSummary()) {
    if (config.isShowSummaryUseTemplateFile() && !isNullOrEmpty(config.getShowSummaryTemplateFile())) {
     gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getShowSummaryTemplateFile());
    }
    if (config.isShowSummaryUseTemplateContent() && !isNullOrEmpty(config.getShowSummaryTemplateContent())) {
     gitChangelogApiBuilder.withTemplateContent(config.getShowSummaryTemplateContent());
    }
    remoteResult.setSummary(gitChangelogApiBuilder.render());
   }

   if (config.isUseMediaWiki()) {
    if (config.isMediaWikiUseTemplateFile() && !isNullOrEmpty(config.getMediaWikiTemplateFile())) {
     gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getMediaWikiTemplateFile());
    }
    if (config.isMediaWikiUseTemplateContent() && !isNullOrEmpty(config.getMediaWikiTemplateContent())) {
     gitChangelogApiBuilder.withTemplateContent(config.getMediaWikiTemplateContent());
    }
    String mediaWikiFullUrl = config.getMediaWikiUrl() + "/index.php/" + config.getMediaWikiTitle();
    logString.append("Posting changelog to " + mediaWikiFullUrl);
    gitChangelogApiBuilder.toMediaWiki(//
      config.getMediaWikiUsername(), //
      config.getMediaWikiPassword(),//
      config.getMediaWikiUrl(), //
      config.getMediaWikiTitle());
    remoteResult.setLeftSide(config.getMediaWikiTitle(), mediaWikiFullUrl);
   }

   if (config.isUseFile()) {
    if (config.isCreateFileUseTemplateFile() && !isNullOrEmpty(config.getCreateFileTemplateFile())) {
     gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getCreateFileTemplateFile());
    }
    if (config.isCreateFileUseTemplateContent() && !isNullOrEmpty(config.getCreateFileTemplateContent())) {
     gitChangelogApiBuilder.withTemplateContent(config.getCreateFileTemplateContent());
    }
    logString.append("Creating changelog " + config.toFile());

        File toFile = new File(workspacePath + "/" + config.toFile());
        new File(toFile.getParent()).mkdirs();
        write(gitChangelogApiBuilder.render(), toFile, UTF_8);    
    
   }
  } catch (Exception e) {
   logString.append(ExceptionUtils.getStackTrace(e));
  }
  remoteResult.setLog(logString.toString());
  return remoteResult;
 }
}
