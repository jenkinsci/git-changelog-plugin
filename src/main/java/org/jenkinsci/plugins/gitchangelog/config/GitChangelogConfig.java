package org.jenkinsci.plugins.gitchangelog.config;

import java.io.Serializable;
import java.util.List;

import org.kohsuke.stapler.DataBoundConstructor;

public class GitChangelogConfig implements Serializable {

  private static final long serialVersionUID = -6715117454282183132L;
  private String configFile;
  private String createFileTemplateContent;
  private String createFileTemplateFile;
  private boolean createFileUseTemplateContent;
  private boolean createFileUseTemplateFile;
  private List<CustomIssue> customIssues;
  private String dateFormat;
  private String file;
  private String fromReference;
  private String fromType;
  private String gitHubApi;
  private String gitHubIssuePattern;
  private String gitHubToken;
  private String gitLabServer;
  private String gitLabProjectName;
  private String gitLabToken;
  private boolean useGitLab;
  private String ignoreCommitsIfMessageMatches;
  private boolean ignoreCommitsWithoutIssue;
  private String ignoreTagsIfNameMatches;
  private String jiraIssuePattern;
  private String jiraPassword;
  private String jiraServer;
  private String jiraUsername;
  private String mediaWikiPassword;
  private String mediaWikiTemplateContent;
  private String mediaWikiTemplateFile;
  private String mediaWikiTitle;
  private String mediaWikiUrl;
  private String mediaWikiUsername;
  private boolean mediaWikiUseTemplateContent;
  private boolean mediaWikiUseTemplateFile;
  private String noIssueName;
  private String readableTagName;
  private boolean showSummary;
  private String showSummaryTemplateContent;
  private String showSummaryTemplateFile;
  private boolean showSummaryUseTemplateContent;
  private boolean showSummaryUseTemplateFile;
  private String subDirectory;
  private String timeZone;
  private String toReference;
  private String toType;
  private String untaggedName;
  private boolean useConfigFile;
  private boolean useFile;
  private boolean useGitHub;
  private boolean useIgnoreTagsIfNameMatches;
  private boolean useJira;
  private boolean useMediaWiki;
  private boolean useReadableTagName;
  private boolean useSubDirectory;

  public GitChangelogConfig() {}

  @DataBoundConstructor
  public GitChangelogConfig(
      String configFile,
      String createFileTemplateContent,
      String createFileTemplateFile,
      boolean createFileUseTemplateContent,
      boolean createFileUseTemplateFile,
      List<CustomIssue> customIssues,
      String dateFormat,
      String file,
      String fromReference,
      String fromType,
      String gitHubApi,
      String gitHubIssuePattern,
      String gitHubToken,
      boolean useGitLab,
      String gitLabServer,
      String gitLabProjectName,
      String gitLabToken,
      String ignoreCommitsIfMessageMatches,
      boolean ignoreCommitsWithoutIssue,
      String ignoreTagsIfNameMatches,
      String jiraIssuePattern,
      String jiraPassword,
      String jiraServer,
      String jiraUsername,
      String mediaWikiPassword,
      String mediaWikiTemplateContent,
      String mediaWikiTemplateFile,
      String mediaWikiTitle,
      String mediaWikiUrl,
      String mediaWikiUsername,
      boolean mediaWikiUseTemplateContent,
      boolean mediaWikiUseTemplateFile,
      String noIssueName,
      String readableTagName,
      boolean showSummary,
      String showSummaryTemplateContent,
      String showSummaryTemplateFile,
      boolean showSummaryUseTemplateContent,
      boolean showSummaryUseTemplateFile,
      String subDirectory,
      String timeZone,
      String toReference,
      String toType,
      String untaggedName,
      boolean useConfigFile,
      boolean useFile,
      boolean useGitHub,
      boolean useIgnoreTagsIfNameMatches,
      boolean useJira,
      boolean useMediaWiki,
      boolean useReadableTagName,
      boolean useSubDirectory) {
    this.configFile = configFile;
    this.createFileTemplateContent = createFileTemplateContent;
    this.createFileTemplateFile = createFileTemplateFile;
    this.createFileUseTemplateContent = createFileUseTemplateContent;
    this.createFileUseTemplateFile = createFileUseTemplateFile;
    this.customIssues = customIssues;
    this.dateFormat = dateFormat;
    this.file = file;
    this.fromReference = fromReference;
    this.fromType = fromType;
    this.gitHubApi = gitHubApi;
    this.gitHubIssuePattern = gitHubIssuePattern;
    this.gitHubToken = gitHubToken;
    this.useGitLab = useGitLab;
    this.gitLabProjectName = gitLabProjectName;
    this.gitLabServer = gitLabServer;
    this.gitLabToken = gitLabToken;
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
    this.jiraIssuePattern = jiraIssuePattern;
    this.jiraPassword = jiraPassword;
    this.jiraServer = jiraServer;
    this.jiraUsername = jiraUsername;
    this.mediaWikiPassword = mediaWikiPassword;
    this.mediaWikiTemplateContent = mediaWikiTemplateContent;
    this.mediaWikiTemplateFile = mediaWikiTemplateFile;
    this.mediaWikiTitle = mediaWikiTitle;
    this.mediaWikiUrl = mediaWikiUrl;
    this.mediaWikiUsername = mediaWikiUsername;
    this.mediaWikiUseTemplateContent = mediaWikiUseTemplateContent;
    this.mediaWikiUseTemplateFile = mediaWikiUseTemplateFile;
    this.noIssueName = noIssueName;
    this.readableTagName = readableTagName;
    this.showSummary = showSummary;
    this.showSummaryTemplateContent = showSummaryTemplateContent;
    this.showSummaryTemplateFile = showSummaryTemplateFile;
    this.showSummaryUseTemplateContent = showSummaryUseTemplateContent;
    this.showSummaryUseTemplateFile = showSummaryUseTemplateFile;
    this.subDirectory = subDirectory;
    this.timeZone = timeZone;
    this.toReference = toReference;
    this.toType = toType;
    this.untaggedName = untaggedName;
    this.useConfigFile = useConfigFile;
    this.useFile = useFile;
    this.useGitHub = useGitHub;
    this.useIgnoreTagsIfNameMatches = useIgnoreTagsIfNameMatches;
    this.useJira = useJira;
    this.useMediaWiki = useMediaWiki;
    this.useReadableTagName = useReadableTagName;
    this.useSubDirectory = useSubDirectory;
  }

  public String getConfigFile() {
    return this.configFile;
  }

  public String getCreateFileTemplateContent() {
    return this.createFileTemplateContent;
  }

  public String getCreateFileTemplateFile() {
    return this.createFileTemplateFile;
  }

  public List<CustomIssue> getCustomIssues() {
    return this.customIssues;
  }

  public String getDateFormat() {
    return this.dateFormat;
  }

  public String getFile() {
    return this.file;
  }

  public String getFromReference() {
    return this.fromReference;
  }

  public String getFromType() {
    return this.fromType;
  }

  public String getGitHubApi() {
    return this.gitHubApi;
  }

  public String getGitHubIssuePattern() {
    return this.gitHubIssuePattern;
  }

  public String getGitHubToken() {
    return this.gitHubToken;
  }

  public String getIgnoreCommitsIfMessageMatches() {
    return this.ignoreCommitsIfMessageMatches;
  }

  public String getIgnoreTagsIfNameMatches() {
    return this.ignoreTagsIfNameMatches;
  }

  public String getJiraIssuePattern() {
    return this.jiraIssuePattern;
  }

  public String getJiraPassword() {
    return this.jiraPassword;
  }

  public String getJiraServer() {
    return this.jiraServer;
  }

  public String getJiraUsername() {
    return this.jiraUsername;
  }

  public String getMediaWikiPassword() {
    return this.mediaWikiPassword;
  }

  public String getMediaWikiTemplateContent() {
    return this.mediaWikiTemplateContent;
  }

  public String getMediaWikiTemplateFile() {
    return this.mediaWikiTemplateFile;
  }

  public String getMediaWikiTitle() {
    return this.mediaWikiTitle;
  }

  public String getMediaWikiUrl() {
    return this.mediaWikiUrl;
  }

  public String getMediaWikiUsername() {
    return this.mediaWikiUsername;
  }

  public String getNoIssueName() {
    return this.noIssueName;
  }

  public String getReadableTagName() {
    return this.readableTagName;
  }

  public String getShowSummaryTemplateContent() {
    return this.showSummaryTemplateContent;
  }

  public String getShowSummaryTemplateFile() {
    return this.showSummaryTemplateFile;
  }

  public String getSubDirectory() {
    return this.subDirectory;
  }

  public String getTimeZone() {
    return this.timeZone;
  }

  public String getToReference() {
    return this.toReference;
  }

  public String getToType() {
    return this.toType;
  }

  public String getUntaggedName() {
    return this.untaggedName;
  }

  public boolean isCreateFileUseTemplateContent() {
    return this.createFileUseTemplateContent;
  }

  public boolean isCreateFileUseTemplateFile() {
    return this.createFileUseTemplateFile;
  }

  public boolean isIgnoreCommitsWithoutIssue() {
    return this.ignoreCommitsWithoutIssue;
  }

  public boolean isMediaWikiUseTemplateContent() {
    return this.mediaWikiUseTemplateContent;
  }

  public boolean isMediaWikiUseTemplateFile() {
    return this.mediaWikiUseTemplateFile;
  }

  public boolean isShowSummary() {
    return this.showSummary;
  }

  public boolean isShowSummaryUseTemplateContent() {
    return this.showSummaryUseTemplateContent;
  }

  public boolean isShowSummaryUseTemplateFile() {
    return this.showSummaryUseTemplateFile;
  }

  public boolean isUseConfigFile() {
    return this.useConfigFile;
  }

  public boolean isUseFile() {
    return this.useFile;
  }

  public boolean isUseGitHub() {
    return this.useGitHub;
  }

  public boolean isUseIgnoreTagsIfNameMatches() {
    return this.useIgnoreTagsIfNameMatches;
  }

  public boolean isUseJira() {
    return this.useJira;
  }

  public boolean isUseMediaWiki() {
    return this.useMediaWiki;
  }

  public boolean isUseReadableTagName() {
    return this.useReadableTagName;
  }

  public boolean isUseSubDirectory() {
    return this.useSubDirectory;
  }

  public void setConfigFile(String configFile) {
    this.configFile = configFile;
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

  public void setCustomIssues(List<CustomIssue> customIssues) {
    this.customIssues = customIssues;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public void setFromReference(String fromReference) {
    this.fromReference = fromReference;
  }

  public void setFromType(String fromType) {
    this.fromType = fromType;
  }

  public void setGitHubApi(String gitHubApi) {
    this.gitHubApi = gitHubApi;
  }

  public void setGitHubIssuePattern(String gitHubIssuePattern) {
    this.gitHubIssuePattern = gitHubIssuePattern;
  }

  public void setGitHubToken(String gitHubToken) {
    this.gitHubToken = gitHubToken;
  }

  public void setGitLabProjectName(String gitLabProjectName) {
    this.gitLabProjectName = gitLabProjectName;
  }

  public void setGitLabServer(String gitLabServer) {
    this.gitLabServer = gitLabServer;
  }

  public void setGitLabToken(String gitLabToken) {
    this.gitLabToken = gitLabToken;
  }

  public boolean isUseGitLab() {
    return useGitLab;
  }

  public String getGitLabProjectName() {
    return gitLabProjectName;
  }

  public String getGitLabServer() {
    return gitLabServer;
  }

  public String getGitLabToken() {
    return gitLabToken;
  }

  public void setUseGitLab(boolean useGitLab) {
    this.useGitLab = useGitLab;
  }

  public void setIgnoreCommitsIfMessageMatches(String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
  }

  public void setIgnoreCommitsWithoutIssue(boolean ignoreCommitsWithoutIssue) {
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
  }

  public void setIgnoreTagsIfNameMatches(String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
  }

  public void setJiraIssuePattern(String jiraIssuePattern) {
    this.jiraIssuePattern = jiraIssuePattern;
  }

  public void setJiraPassword(String jiraPassword) {
    this.jiraPassword = jiraPassword;
  }

  public void setJiraServer(String jiraServer) {
    this.jiraServer = jiraServer;
  }

  public void setJiraUsername(String jiraUsername) {
    this.jiraUsername = jiraUsername;
  }

  public void setMediaWikiPassword(String mediaWikiPassword) {
    this.mediaWikiPassword = mediaWikiPassword;
  }

  public void setMediaWikiTemplateContent(String mediaWikiTemplateContent) {
    this.mediaWikiTemplateContent = mediaWikiTemplateContent;
  }

  public void setMediaWikiTemplateFile(String mediaWikiTemplateFile) {
    this.mediaWikiTemplateFile = mediaWikiTemplateFile;
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

  public void setMediaWikiUseTemplateContent(boolean mediaWikiUseTemplateContent) {
    this.mediaWikiUseTemplateContent = mediaWikiUseTemplateContent;
  }

  public void setMediaWikiUseTemplateFile(boolean mediaWikiUseTemplateFile) {
    this.mediaWikiUseTemplateFile = mediaWikiUseTemplateFile;
  }

  public void setNoIssueName(String noIssueName) {
    this.noIssueName = noIssueName;
  }

  public void setReadableTagName(String readableTagName) {
    this.readableTagName = readableTagName;
  }

  public void setShowSummary(boolean showSummary) {
    this.showSummary = showSummary;
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

  public void setSubDirectory(String subDirectory) {
    this.subDirectory = subDirectory;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public void setToReference(String toReference) {
    this.toReference = toReference;
  }

  public void setToType(String toType) {
    this.toType = toType;
  }

  public void setUntaggedName(String untaggedName) {
    this.untaggedName = untaggedName;
  }

  public void setUseConfigFile(boolean useConfigFile) {
    this.useConfigFile = useConfigFile;
  }

  public void setUseFile(boolean useFile) {
    this.useFile = useFile;
  }

  public void setUseGitHub(boolean useGithub) {
    this.useGitHub = useGithub;
  }

  public void setUseIgnoreTagsIfNameMatches(boolean useIgnoreTagsIfNameMatches) {
    this.useIgnoreTagsIfNameMatches = useIgnoreTagsIfNameMatches;
  }

  public void setUseJira(boolean useJira) {
    this.useJira = useJira;
  }

  public void setUseMediaWiki(boolean useMediaWiki) {
    this.useMediaWiki = useMediaWiki;
  }

  public void setUseReadableTagName(boolean useReadableTagName) {
    this.useReadableTagName = useReadableTagName;
  }

  public void setUseSubDirectory(boolean useSubDirectory) {
    this.useSubDirectory = useSubDirectory;
  }

  public boolean showSummary() {
    return this.showSummary;
  }

  public String toFile() {
    return this.file;
  }

  @Override
  public String toString() {
    return "GitChangelogConfig [configFile="
        + configFile
        + ", createFileTemplateContent="
        + createFileTemplateContent
        + ", createFileTemplateFile="
        + createFileTemplateFile
        + ", createFileUseTemplateContent="
        + createFileUseTemplateContent
        + ", createFileUseTemplateFile="
        + createFileUseTemplateFile
        + ", customIssues="
        + customIssues
        + ", dateFormat="
        + dateFormat
        + ", file="
        + file
        + ", fromReference="
        + fromReference
        + ", fromType="
        + fromType
        + ", gitHubApi="
        + gitHubApi
        + ", gitHubIssuePattern="
        + gitHubIssuePattern
        + ", gitHubToken="
        + gitHubToken
        + ", gitLabServer="
        + gitLabServer
        + ", gitLabProjectName="
        + gitLabProjectName
        + ", gitLabToken="
        + gitLabToken
        + ", ignoreCommitsIfMessageMatches="
        + ignoreCommitsIfMessageMatches
        + ", ignoreCommitsWithoutIssue="
        + ignoreCommitsWithoutIssue
        + ", ignoreTagsIfNameMatches="
        + ignoreTagsIfNameMatches
        + ", jiraIssuePattern="
        + jiraIssuePattern
        + ", jiraPassword="
        + jiraPassword
        + ", jiraServer="
        + jiraServer
        + ", jiraUsername="
        + jiraUsername
        + ", mediaWikiPassword="
        + mediaWikiPassword
        + ", mediaWikiTemplateContent="
        + mediaWikiTemplateContent
        + ", mediaWikiTemplateFile="
        + mediaWikiTemplateFile
        + ", mediaWikiTitle="
        + mediaWikiTitle
        + ", mediaWikiUrl="
        + mediaWikiUrl
        + ", mediaWikiUsername="
        + mediaWikiUsername
        + ", mediaWikiUseTemplateContent="
        + mediaWikiUseTemplateContent
        + ", mediaWikiUseTemplateFile="
        + mediaWikiUseTemplateFile
        + ", noIssueName="
        + noIssueName
        + ", readableTagName="
        + readableTagName
        + ", showSummary="
        + showSummary
        + ", showSummaryTemplateContent="
        + showSummaryTemplateContent
        + ", showSummaryTemplateFile="
        + showSummaryTemplateFile
        + ", showSummaryUseTemplateContent="
        + showSummaryUseTemplateContent
        + ", showSummaryUseTemplateFile="
        + showSummaryUseTemplateFile
        + ", subDirectory="
        + subDirectory
        + ", timeZone="
        + timeZone
        + ", toReference="
        + toReference
        + ", toType="
        + toType
        + ", untaggedName="
        + untaggedName
        + ", useConfigFile="
        + useConfigFile
        + ", useFile="
        + useFile
        + ", useGitHub="
        + useGitHub
        + ", useIgnoreTagsIfNameMatches="
        + useIgnoreTagsIfNameMatches
        + ", useJira="
        + useJira
        + ", useMediaWiki="
        + useMediaWiki
        + ", useReadableTagName="
        + useReadableTagName
        + ", useSubDirectory="
        + useSubDirectory
        + "]";
  }
}
