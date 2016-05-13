package org.jenkinsci.plugins.gitchangelog.config;

import java.io.Serializable;
import java.util.List;

public class GitChangelogConfig implements Serializable {

 private static final long serialVersionUID = -6715117454282183132L;
 private boolean useConfigFile;
 private String configFile;

 private boolean createFileUseTemplateFile;
 private String createFileTemplateFile;
 private boolean createFileUseTemplateContent;
 private String createFileTemplateContent;

 private boolean mediaWikiUseTemplateFile;
 private String mediaWikiTemplateFile;
 private boolean mediaWikiUseTemplateContent;
 private String mediaWikiTemplateContent;

 private boolean showSummaryUseTemplateFile;
 private String showSummaryTemplateFile;
 private boolean showSummaryUseTemplateContent;
 private String showSummaryTemplateContent;
 
 private String subDirectory;
 private boolean useSubDirectory;
 private String fromType;
 private String fromReference;
 private String toType;
 private String toReference;
 private String dateFormat;
 private String timeZone;
 private String ignoreCommitsIfMessageMatches;
 private boolean useJira;
 private String jiraServer;
 private String jiraIssuePattern;
 private String jiraUsername;
 private String jiraPassword;
 private boolean useGitHub;
 private String gitHubApi;
 private String gitHubIssuePattern;
 private String gitHubToken;
 private String noIssueName;
 private String untaggedName;
 private boolean useReadableTagName;
 private String readableTagName;
 private boolean useMediaWiki;
 private String mediaWikiUsername;
 private String mediaWikiPassword;
 private String mediaWikiTitle;
 private String mediaWikiUrl;
 private boolean useFile;
 private String file;
 private List<CustomIssue> customIssues;
 private boolean showSummary;
 private boolean ignoreCommitsWithoutIssue;
 private boolean useIgnoreTagsIfNameMatches;
 private String ignoreTagsIfNameMatches;
 

 public String getCreateFileTemplateContent() {
  return createFileTemplateContent;
 }

 public void setGitHubToken(String gitHubToken) {
  this.gitHubToken = gitHubToken;
 }

 public String getGitHubToken() {
  return gitHubToken;
 }

 public String getCreateFileTemplateFile() {
  return createFileTemplateFile;
 }

 public String getShowSummaryTemplateContent() {
  return showSummaryTemplateContent;
 }

 public String getShowSummaryTemplateFile() {
  return showSummaryTemplateFile;
 }

 public boolean isCreateFileUseTemplateContent() {
  return createFileUseTemplateContent;
 }

 
 public boolean isCreateFileUseTemplateFile() {
  return createFileUseTemplateFile;
 }

 public boolean isShowSummary() {
  return showSummary;
 }

 public boolean isShowSummaryUseTemplateContent() {
  return showSummaryUseTemplateContent;
 }

 public boolean isShowSummaryUseTemplateFile() {
  return showSummaryUseTemplateFile;
 }

 public void setCreateFileTemplateContent(String createFileTemplateContent) {
  this.createFileTemplateContent = createFileTemplateContent;
 }

 public void setCreateFileTemplateFile(String createFileTemplateFile) {
  this.createFileTemplateFile = createFileTemplateFile;
 }

 public void setCreateFileUseTemplateContent(boolean createFileUseTemplateContent) {
  this.createFileUseTemplateContent = createFileUseTemplateContent;
 }

 public void setCreateFileUseTemplateFile(boolean createFileUseTemplateFile) {
  this.createFileUseTemplateFile = createFileUseTemplateFile;
 }

 public void setShowSummaryTemplateContent(String showSummaryTemplateContent) {
  this.showSummaryTemplateContent = showSummaryTemplateContent;
 }

 public void setShowSummaryTemplateFile(String showSummaryTemplateFile) {
  this.showSummaryTemplateFile = showSummaryTemplateFile;
 }

 public void setShowSummaryUseTemplateContent(boolean showSummaryUseTemplateContent) {
  this.showSummaryUseTemplateContent = showSummaryUseTemplateContent;
 }

 public void setShowSummaryUseTemplateFile(boolean showSummaryUseTemplateFile) {
  this.showSummaryUseTemplateFile = showSummaryUseTemplateFile;
 }

 public String getMediaWikiTemplateContent() {
  return mediaWikiTemplateContent;
 }

 public String getMediaWikiTemplateFile() {
  return mediaWikiTemplateFile;
 }

 public boolean isMediaWikiUseTemplateContent() {
  return mediaWikiUseTemplateContent;
 }

 public boolean isMediaWikiUseTemplateFile() {
  return mediaWikiUseTemplateFile;
 }

 public void setMediaWikiTemplateContent(String mediaWikiTemplateContent) {
  this.mediaWikiTemplateContent = mediaWikiTemplateContent;
 }

 public void setMediaWikiTemplateFile(String mediaWikiTemplateFile) {
  this.mediaWikiTemplateFile = mediaWikiTemplateFile;
 }

 public void setMediaWikiUseTemplateContent(boolean mediaWikiUseTemplateContent) {
  this.mediaWikiUseTemplateContent = mediaWikiUseTemplateContent;
 }

 public void setMediaWikiUseTemplateFile(boolean mediaWikiUseTemplateFile) {
  this.mediaWikiUseTemplateFile = mediaWikiUseTemplateFile;
 }

 public void setShowSummary(boolean showSummary) {
  this.showSummary = showSummary;
 }

 public String getJiraPassword() {
  return jiraPassword;
 }

 public String getJiraUsername() {
  return jiraUsername;
 }

 public boolean isUseGitHub() {
  return useGitHub;
 }

 public boolean isUseJira() {
  return useJira;
 }

 public String getGitHubApi() {
  return gitHubApi;
 }

 public void setGitHubApi(String gitHubApi) {
  this.gitHubApi = gitHubApi;
 }

 public void setJiraPassword(String jiraPassword) {
  this.jiraPassword = jiraPassword;
 }

 public void setJiraUsername(String jiraUsername) {
  this.jiraUsername = jiraUsername;
 }

 public void setUseGitHub(boolean useGithub) {
  this.useGitHub = useGithub;
 }

  public boolean isUseFile() {
  return useFile;
 }

 public void setUseFile(boolean useFile) {
  this.useFile = useFile;
 }

 public void setFile(String file) {
  this.file = file;
 }

 public String toFile() {
  return file;
 }
 
 public boolean isUseSubDirectory() {
  return useSubDirectory;
 }
 
 public void setUseSubDirectory(boolean useSubDirectory) {
  this.useSubDirectory = useSubDirectory;
 } 
 
 public String getSubDirectory() {
  return subDirectory;
 }
 
 public void setSubDirectory(String subDirectory) {
  this.subDirectory = subDirectory;
 }

 public void setUseJira(boolean useJira) {
  this.useJira = useJira;
 }

 public String getFile() {
  return file;
 }

 public void setMediaWikiPassword(String mediaWikiPassword) {
  this.mediaWikiPassword = mediaWikiPassword;
 }

 public void setMediaWikiTitle(String mediaWikiTitle) {
  this.mediaWikiTitle = mediaWikiTitle;
 }

 public void setMediaWikiUrl(String mediaWikiUrl) {
  this.mediaWikiUrl = mediaWikiUrl;
 }

 public void setMediaWikiUsername(String mediaWikiUsername) {
  this.mediaWikiUsername = mediaWikiUsername;
 }

 public void setUseMediaWiki(boolean useMediaWiki) {
  this.useMediaWiki = useMediaWiki;
 }

 public String getMediaWikiPassword() {
  return mediaWikiPassword;
 }

 public String getMediaWikiTitle() {
  return mediaWikiTitle;
 }

 public String getMediaWikiUrl() {
  return mediaWikiUrl;
 }

 public String getMediaWikiUsername() {
  return mediaWikiUsername;
 }

 public boolean isUseMediaWiki() {
  return useMediaWiki;
 }

 public boolean isUseConfigFile() {
  return useConfigFile;
 }

 public void setUseConfigFile(boolean useConfigFile) {
  this.useConfigFile = useConfigFile;
 }

 public String getConfigFile() {
  return configFile;
 }

 public void setConfigFile(String configFile) {
  this.configFile = configFile;
 }

 public String getFromType() {
  return fromType;
 }

 public void setFromType(String fromType) {
  this.fromType = fromType;
 }

 public String getFromReference() {
  return fromReference;
 }

 public void setFromReference(String fromReference) {
  this.fromReference = fromReference;
 }
 
 public String getToType() {
  return toType;
 }

 public void setToType(String toType) {
  this.toType = toType;
 }

 public String getToReference() {
  return toReference;
 }

 public void setToReference(String toReference) {
  this.toReference = toReference;
 }

 public String getDateFormat() {
  return dateFormat;
 }

 public void setDateFormat(String dateFormat) {
  this.dateFormat = dateFormat;
 }

 public String getTimeZone() {
  return timeZone;
 }

 public void setTimeZone(String timeZone) {
  this.timeZone = timeZone;
 }

 public String getIgnoreCommitsIfMessageMatches() {
  return ignoreCommitsIfMessageMatches;
 }

 public void setIgnoreCommitsIfMessageMatches(String ignoreCommitsIfMessageMatches) {
  this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
 }

 public String getJiraServer() {
  return jiraServer;
 }

 public void setJiraServer(String jiraServer) {
  this.jiraServer = jiraServer;
 }

 public String getJiraIssuePattern() {
  return jiraIssuePattern;
 }

 public void setJiraIssuePattern(String jiraIssuePattern) {
  this.jiraIssuePattern = jiraIssuePattern;
 }

 public String getNoIssueName() {
  return noIssueName;
 }

 public void setNoIssueName(String noIssueName) {
  this.noIssueName = noIssueName;
 }

 public String getUntaggedName() {
  return untaggedName;
 }

 public void setUntaggedName(String untaggedName) {
  this.untaggedName = untaggedName;
 }

 public boolean isUseReadableTagName() {
  return useReadableTagName;
 }

 public void setUseReadableTagName(boolean useReadableTagName) {
  this.useReadableTagName = useReadableTagName;
 }

 public String getReadableTagName() {
  return readableTagName;
 }

 public void setReadableTagName(String readableTagName) {
  this.readableTagName = readableTagName;
 }

 public List<CustomIssue> getCustomIssues() {
  return customIssues;
 }

 public void setCustomIssues(List<CustomIssue> customIssues) {
  this.customIssues = customIssues;
 }
 
 public void setGitHubIssuePattern(String gitHubIssuePattern) {
  this.gitHubIssuePattern = gitHubIssuePattern;
 }

 public String getGitHubIssuePattern() {
  return gitHubIssuePattern;
 }

 public boolean showSummary() {
  return showSummary;
 }

 public void setIgnoreCommitsWithoutIssue(boolean ignoreCommitsWithoutIssue) {
  this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
 }

 public boolean isIgnoreCommitsWithoutIssue() {
  return ignoreCommitsWithoutIssue;
 }

 public void setIgnoreTagsIfNameMatches(String ignoreTagsIfNameMatches) {
  this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
 }

 public String getIgnoreTagsIfNameMatches() {
  return ignoreTagsIfNameMatches;
 }

 public void setUseIgnoreTagsIfNameMatches(boolean useIgnoreTagsIfNameMatches) {
  this.useIgnoreTagsIfNameMatches = useIgnoreTagsIfNameMatches;
 }

 public boolean isUseIgnoreTagsIfNameMatches() {
  return useIgnoreTagsIfNameMatches;
 }

 @Override
 public String toString() {
  return "GitChangelogConfig [useConfigFile=" + useConfigFile + ", configFile=" + configFile
    + ", createFileUseTemplateFile=" + createFileUseTemplateFile + ", createFileTemplateFile=" + createFileTemplateFile
    + ", createFileUseTemplateContent=" + createFileUseTemplateContent + ", createFileTemplateContent="
    + createFileTemplateContent + ", mediaWikiUseTemplateFile=" + mediaWikiUseTemplateFile + ", mediaWikiTemplateFile="
    + mediaWikiTemplateFile + ", mediaWikiUseTemplateContent=" + mediaWikiUseTemplateContent
    + ", mediaWikiTemplateContent=" + mediaWikiTemplateContent + ", showSummaryUseTemplateFile="
    + showSummaryUseTemplateFile + ", showSummaryTemplateFile=" + showSummaryTemplateFile
    + ", showSummaryUseTemplateContent=" + showSummaryUseTemplateContent + ", showSummaryTemplateContent="
    + showSummaryTemplateContent + ", fromType=" + fromType + ", fromReference=" + fromReference + ", toType=" + toType
    + ", toReference=" + toReference + ", isSubDirectory=" + useSubDirectory + ", subDirectory=" + subDirectory + ", dateFormat=" + dateFormat + ", timeZone=" + timeZone
    + ", ignoreCommitsIfMessageMatches=" + ignoreCommitsIfMessageMatches + ", useJira=" + useJira + ", jiraServer="
    + jiraServer + ", jiraIssuePattern=" + jiraIssuePattern + ", jiraUsername=" + jiraUsername
    + ", jiraPassword=****, useGitHub=" + useGitHub + ", gitHubApi=" + gitHubApi + ", gitHubIssuePattern="
    + gitHubIssuePattern + ", noIssueName=" + noIssueName + ", untaggedName=" + untaggedName + ", useReadableTagName="
    + useReadableTagName + ", readableTagName=" + readableTagName + ", useMediaWiki=" + useMediaWiki
    + ", mediaWikiUsername=" + mediaWikiUsername + ", mediaWikiPassword=***, mediaWikiTitle=" + mediaWikiTitle
    + ", mediaWikiUrl=" + mediaWikiUrl + ", useFile=" + useFile + ", file=" + file + ", customIssues=" + customIssues
    + ", showSummary=" + showSummary + "]";
 }

}
