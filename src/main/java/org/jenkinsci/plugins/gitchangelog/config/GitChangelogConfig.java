package org.jenkinsci.plugins.gitchangelog.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class GitChangelogConfig implements Serializable {

  private static final long serialVersionUID = -6715117454282183133L;
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
  private transient String gitHubToken;
  private String gitLabServer;
  private String gitLabProjectName;
  private transient String gitLabToken;
  private boolean useGitLab;
  private String ignoreCommitsIfMessageMatches;
  private boolean ignoreCommitsWithoutIssue;
  private String ignoreTagsIfNameMatches;
  private String jiraIssuePattern;
  private transient String jiraPassword;
  private String jiraServer;
  private transient String jiraUsername;
  private String jiraUsernamePasswordCredentialsId;
  private String jiraBasicAuthStringCredentialsId;
  private transient String jiraBasicAuthString;
  private String jiraBearerCredentialsId;
  private transient String jiraBearer;
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
  private boolean useReadableTagName;
  private boolean useSubDirectory;
  private String gitHubApiTokenCredentialsId;
  private String gitLabApiTokenCredentialsId;

  @DataBoundConstructor
  public GitChangelogConfig() {
    this.customIssues = new ArrayList<>();
  }

  public GitChangelogConfig(
      final String configFile,
      final String createFileTemplateContent,
      final String createFileTemplateFile,
      final boolean createFileUseTemplateContent,
      final boolean createFileUseTemplateFile,
      final List<CustomIssue> customIssues,
      final String dateFormat,
      final String file,
      final String fromReference,
      final String fromType,
      final String gitHubApi,
      final String gitHubIssuePattern,
      final boolean useGitLab,
      final String gitLabServer,
      final String gitLabProjectName,
      final String ignoreCommitsIfMessageMatches,
      final boolean ignoreCommitsWithoutIssue,
      final String ignoreTagsIfNameMatches,
      final String jiraIssuePattern,
      final String jiraPassword,
      final String basicAuthString,
      final String jiraServer,
      final String jiraUsername,
      final String jiraUsernamePasswordCredentialsId,
      final String jiraBasicAuthStringCredentialsId,
      final String jiraBearerCredentialsId,
      final String noIssueName,
      final String readableTagName,
      final boolean showSummary,
      final String showSummaryTemplateContent,
      final String showSummaryTemplateFile,
      final boolean showSummaryUseTemplateContent,
      final boolean showSummaryUseTemplateFile,
      final String subDirectory,
      final String timeZone,
      final String toReference,
      final String toType,
      final String untaggedName,
      final boolean useConfigFile,
      final boolean useFile,
      final boolean useGitHub,
      final boolean useIgnoreTagsIfNameMatches,
      final boolean useJira,
      final boolean useReadableTagName,
      final boolean useSubDirectory,
      final String gitHubApiTokenCredentialsId,
      final String gitLabApiTokenCredentialsId) {
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
    this.useGitLab = useGitLab;
    this.gitLabProjectName = gitLabProjectName;
    this.gitLabServer = gitLabServer;
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
    this.jiraIssuePattern = jiraIssuePattern;
    this.jiraServer = jiraServer;
    this.jiraUsernamePasswordCredentialsId = jiraUsernamePasswordCredentialsId;
    this.jiraBasicAuthStringCredentialsId = jiraBasicAuthStringCredentialsId;
    this.jiraBearerCredentialsId = jiraBearerCredentialsId;
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
    this.useReadableTagName = useReadableTagName;
    this.useSubDirectory = useSubDirectory;
    this.gitHubApiTokenCredentialsId = gitHubApiTokenCredentialsId;
    this.gitLabApiTokenCredentialsId = gitLabApiTokenCredentialsId;
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

  public String getJiraBasicAuthStringCredentialsId() {
    return this.jiraBasicAuthStringCredentialsId;
  }

  public String getJiraBearerCredentialsId() {
    return this.jiraBearerCredentialsId;
  }

  public String getJiraServer() {
    return this.jiraServer;
  }

  public String getJiraUsername() {
    return this.jiraUsername;
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

  public boolean isUseReadableTagName() {
    return this.useReadableTagName;
  }

  public boolean isUseSubDirectory() {
    return this.useSubDirectory;
  }

  @DataBoundSetter
  public void setConfigFile(final String configFile) {
    this.configFile = configFile;
  }

  @DataBoundSetter
  public void setCreateFileTemplateContent(final String createFileTemplateContent) {
    this.createFileTemplateContent = createFileTemplateContent;
  }

  @DataBoundSetter
  public void setCreateFileTemplateFile(final String createFileTemplateFile) {
    this.createFileTemplateFile = createFileTemplateFile;
  }

  @DataBoundSetter
  public void setCreateFileUseTemplateContent(final boolean createFileUseTemplateContent) {
    this.createFileUseTemplateContent = createFileUseTemplateContent;
  }

  @DataBoundSetter
  public void setCreateFileUseTemplateFile(final boolean createFileUseTemplateFile) {
    this.createFileUseTemplateFile = createFileUseTemplateFile;
  }

  @DataBoundSetter
  public void setCustomIssues(final List<CustomIssue> customIssues) {
    this.customIssues = customIssues;
  }

  @DataBoundSetter
  public void setDateFormat(final String dateFormat) {
    this.dateFormat = dateFormat;
  }

  @DataBoundSetter
  public void setFile(final String file) {
    this.file = file;
  }

  @DataBoundSetter
  public void setFromReference(final String fromReference) {
    this.fromReference = fromReference;
  }

  @DataBoundSetter
  public void setFromType(final String fromType) {
    this.fromType = fromType;
  }

  @DataBoundSetter
  public void setGitHubApi(final String gitHubApi) {
    this.gitHubApi = gitHubApi;
  }

  @DataBoundSetter
  public void setGitHubIssuePattern(final String gitHubIssuePattern) {
    this.gitHubIssuePattern = gitHubIssuePattern;
  }

  @DataBoundSetter
  public void setGitHubToken(final String gitHubToken) {
    this.gitHubToken = gitHubToken;
  }

  @DataBoundSetter
  public void setGitLabProjectName(final String gitLabProjectName) {
    this.gitLabProjectName = gitLabProjectName;
  }

  @DataBoundSetter
  public void setGitLabServer(final String gitLabServer) {
    this.gitLabServer = gitLabServer;
  }

  @DataBoundSetter
  public void setGitLabToken(final String gitLabToken) {
    this.gitLabToken = gitLabToken;
  }

  public boolean isUseGitLab() {
    return this.useGitLab;
  }

  public String getGitLabProjectName() {
    return this.gitLabProjectName;
  }

  public String getGitLabServer() {
    return this.gitLabServer;
  }

  public String getGitLabToken() {
    return this.gitLabToken;
  }

  @DataBoundSetter
  public void setUseGitLab(final boolean useGitLab) {
    this.useGitLab = useGitLab;
  }

  @DataBoundSetter
  public void setIgnoreCommitsIfMessageMatches(final String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
  }

  @DataBoundSetter
  public void setIgnoreCommitsWithoutIssue(final boolean ignoreCommitsWithoutIssue) {
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
  }

  @DataBoundSetter
  public void setIgnoreTagsIfNameMatches(final String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
  }

  @DataBoundSetter
  public void setJiraIssuePattern(final String jiraIssuePattern) {
    this.jiraIssuePattern = jiraIssuePattern;
  }

  @DataBoundSetter
  public void setJiraPassword(final String jiraPassword) {
    this.jiraPassword = jiraPassword;
  }

  @DataBoundSetter
  public void setJiraBasicAuthStringCredentialsId(final String jiraBasicAuthStringCredentialsId) {
    this.jiraBasicAuthStringCredentialsId = jiraBasicAuthStringCredentialsId;
  }

  @DataBoundSetter
  public void setJiraBearerCredentialsId(final String jiraBearerCredentialsId) {
    this.jiraBearerCredentialsId = jiraBearerCredentialsId;
  }

  @DataBoundSetter
  public void setJiraServer(final String jiraServer) {
    this.jiraServer = jiraServer;
  }

  @DataBoundSetter
  public void setJiraUsername(final String jiraUsername) {
    this.jiraUsername = jiraUsername;
  }

  @DataBoundSetter
  public void setJiraBasicAuthString(final String jiraBasicAuthString) {
    this.jiraBasicAuthString = jiraBasicAuthString;
  }

  public String getJiraBasicAuthString() {
    return this.jiraBasicAuthString;
  }

  @DataBoundSetter
  public void setJiraBearer(final String jiraBearer) {
    this.jiraBearer = jiraBearer;
  }

  public String getJiraBearer() {
    return this.jiraBearer;
  }

  @DataBoundSetter
  public void setNoIssueName(final String noIssueName) {
    this.noIssueName = noIssueName;
  }

  @DataBoundSetter
  public void setReadableTagName(final String readableTagName) {
    this.readableTagName = readableTagName;
  }

  @DataBoundSetter
  public void setShowSummary(final boolean showSummary) {
    this.showSummary = showSummary;
  }

  @DataBoundSetter
  public void setShowSummaryTemplateContent(final String showSummaryTemplateContent) {
    this.showSummaryTemplateContent = showSummaryTemplateContent;
  }

  @DataBoundSetter
  public void setShowSummaryTemplateFile(final String showSummaryTemplateFile) {
    this.showSummaryTemplateFile = showSummaryTemplateFile;
  }

  @DataBoundSetter
  public void setShowSummaryUseTemplateContent(final boolean showSummaryUseTemplateContent) {
    this.showSummaryUseTemplateContent = showSummaryUseTemplateContent;
  }

  @DataBoundSetter
  public void setShowSummaryUseTemplateFile(final boolean showSummaryUseTemplateFile) {
    this.showSummaryUseTemplateFile = showSummaryUseTemplateFile;
  }

  @DataBoundSetter
  public void setSubDirectory(final String subDirectory) {
    this.subDirectory = subDirectory;
  }

  @DataBoundSetter
  public void setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
  }

  @DataBoundSetter
  public void setToReference(final String toReference) {
    this.toReference = toReference;
  }

  @DataBoundSetter
  public void setToType(final String toType) {
    this.toType = toType;
  }

  @DataBoundSetter
  public void setUntaggedName(final String untaggedName) {
    this.untaggedName = untaggedName;
  }

  @DataBoundSetter
  public void setUseConfigFile(final boolean useConfigFile) {
    this.useConfigFile = useConfigFile;
  }

  @DataBoundSetter
  public void setUseFile(final boolean useFile) {
    this.useFile = useFile;
  }

  @DataBoundSetter
  public void setUseGitHub(final boolean useGithub) {
    this.useGitHub = useGithub;
  }

  @DataBoundSetter
  public void setUseIgnoreTagsIfNameMatches(final boolean useIgnoreTagsIfNameMatches) {
    this.useIgnoreTagsIfNameMatches = useIgnoreTagsIfNameMatches;
  }

  @DataBoundSetter
  public void setUseJira(final boolean useJira) {
    this.useJira = useJira;
  }

  @DataBoundSetter
  public void setUseReadableTagName(final boolean useReadableTagName) {
    this.useReadableTagName = useReadableTagName;
  }

  @DataBoundSetter
  public void setUseSubDirectory(final boolean useSubDirectory) {
    this.useSubDirectory = useSubDirectory;
  }

  public boolean showSummary() {
    return this.showSummary;
  }

  public String toFile() {
    return this.file;
  }

  public String getGitHubApiTokenCredentialsId() {
    return this.gitHubApiTokenCredentialsId;
  }

  public String getGitLabApiTokenCredentialsId() {
    return this.gitLabApiTokenCredentialsId;
  }

  @DataBoundSetter
  public void setGitHubApiTokenCredentialsId(final String gitHubApiTokenCredentialsId) {
    this.gitHubApiTokenCredentialsId = gitHubApiTokenCredentialsId;
  }

  @DataBoundSetter
  public void setGitLabApiTokenCredentialsId(final String gitLabApiTokenCredentialsId) {
    this.gitLabApiTokenCredentialsId = gitLabApiTokenCredentialsId;
  }

  @DataBoundSetter
  public void setJiraUsernamePasswordCredentialsId(final String jiraUsernamePasswordCredentialsId) {
    this.jiraUsernamePasswordCredentialsId = jiraUsernamePasswordCredentialsId;
  }

  public String getJiraUsernamePasswordCredentialsId() {
    return this.jiraUsernamePasswordCredentialsId;
  }

  @Override
  public String toString() {
    return "GitChangelogConfig [configFile="
        + this.configFile
        + ", createFileTemplateContent="
        + this.createFileTemplateContent
        + ", createFileTemplateFile="
        + this.createFileTemplateFile
        + ", createFileUseTemplateContent="
        + this.createFileUseTemplateContent
        + ", createFileUseTemplateFile="
        + this.createFileUseTemplateFile
        + ", customIssues="
        + this.customIssues
        + ", dateFormat="
        + this.dateFormat
        + ", file="
        + this.file
        + ", fromReference="
        + this.fromReference
        + ", fromType="
        + this.fromType
        + ", gitHubApi="
        + this.gitHubApi
        + ", gitHubIssuePattern="
        + this.gitHubIssuePattern
        + ", gitHubToken="
        + this.gitHubToken
        + ", gitLabServer="
        + this.gitLabServer
        + ", gitLabProjectName="
        + this.gitLabProjectName
        + ", gitLabToken="
        + this.gitLabToken
        + ", useGitLab="
        + this.useGitLab
        + ", ignoreCommitsIfMessageMatches="
        + this.ignoreCommitsIfMessageMatches
        + ", ignoreCommitsWithoutIssue="
        + this.ignoreCommitsWithoutIssue
        + ", ignoreTagsIfNameMatches="
        + this.ignoreTagsIfNameMatches
        + ", jiraIssuePattern="
        + this.jiraIssuePattern
        + ", jiraPassword="
        + this.jiraPassword
        + ", jiraBasicAuthStringCredentialsId="
        + this.jiraBasicAuthStringCredentialsId
        + ", jiraBearerCredentialsId="
        + this.jiraBearerCredentialsId
        + ", jiraServer="
        + this.jiraServer
        + ", jiraUsername="
        + this.jiraUsername
        + ", jiraUsernamePasswordCredentialsId="
        + this.jiraUsernamePasswordCredentialsId
        + ", noIssueName="
        + this.noIssueName
        + ", readableTagName="
        + this.readableTagName
        + ", showSummary="
        + this.showSummary
        + ", showSummaryTemplateContent="
        + this.showSummaryTemplateContent
        + ", showSummaryTemplateFile="
        + this.showSummaryTemplateFile
        + ", showSummaryUseTemplateContent="
        + this.showSummaryUseTemplateContent
        + ", showSummaryUseTemplateFile="
        + this.showSummaryUseTemplateFile
        + ", subDirectory="
        + this.subDirectory
        + ", timeZone="
        + this.timeZone
        + ", toReference="
        + this.toReference
        + ", toType="
        + this.toType
        + ", untaggedName="
        + this.untaggedName
        + ", useConfigFile="
        + this.useConfigFile
        + ", useFile="
        + this.useFile
        + ", useGitHub="
        + this.useGitHub
        + ", useIgnoreTagsIfNameMatches="
        + this.useIgnoreTagsIfNameMatches
        + ", useJira="
        + this.useJira
        + ", useReadableTagName="
        + this.useReadableTagName
        + ", useSubDirectory="
        + this.useSubDirectory
        + ", gitHubApiTokenCredentialsId="
        + this.gitHubApiTokenCredentialsId
        + ", gitLabApiTokenCredentialsId="
        + this.gitLabApiTokenCredentialsId
        + "]";
  }
}
