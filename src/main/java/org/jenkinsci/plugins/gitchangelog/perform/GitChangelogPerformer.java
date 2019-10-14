package org.jenkinsci.plugins.gitchangelog.perform;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static org.jenkinsci.plugins.gitchangelog.GitChangelogLogger.doLog;
import static org.jenkinsci.plugins.gitchangelog.config.CredentialsHelper.findSecretString;
import static org.jenkinsci.plugins.gitchangelog.config.CredentialsHelper.findSecretUsernamePassword;

import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import hudson.EnvVars;
import hudson.FilePath;
import hudson.model.Run;
import hudson.model.TaskListener;
import java.util.ArrayList;
import java.util.List;
import org.jenkinsci.plugins.gitchangelog.config.CustomIssue;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;

public class GitChangelogPerformer {

  public static void performerPerform(
      final GitChangelogConfig configUnexpanded,
      final Run<?, ?> build,
      final TaskListener listener,
      final FilePath workspace) {
    try {
      final EnvVars env = build.getEnvironment(listener);
      final GitChangelogConfig config = expand(configUnexpanded, env);
      listener.getLogger().println("---");
      listener.getLogger().println("--- Git Changelog ---");
      listener.getLogger().println("---");

      setApiTokenCredentials(config, listener);

      final RemoteCallable remoteTask = new RemoteCallable(workspace.getRemote(), config);
      final RemoteResult remoteResult = workspace.act(remoteTask);
      if (!isNullOrEmpty(remoteResult.getLeftSideTitle())) {
        build.addAction(
            new GitChangelogLeftsideBuildDecorator(
                remoteResult.getLeftSideTitle(), remoteResult.getLeftSideUrl()));
      }
      if (!isNullOrEmpty(remoteResult.getSummary())) {
        build.addAction(new GitChangelogSummaryDecorator(remoteResult.getSummary()));
      }
      doLog(listener, INFO, remoteResult.getLog());
    } catch (final Exception e) {
      doLog(listener, SEVERE, e.getMessage(), e);
    }
  }

  private static void setApiTokenCredentials(
      final GitChangelogConfig configExpanded, final TaskListener listener) {
    if (configExpanded.isUseGitHub()) {
      final String getApiTokenCredentialsId = configExpanded.getGitHubApiTokenCredentialsId();
      final String token = findSecretString(getApiTokenCredentialsId).orElse(null);
      configExpanded.setGitHubToken(token);
    }
    if (configExpanded.isUseGitLab()) {
      final String getApiTokenCredentialsId = configExpanded.getGitLabApiTokenCredentialsId();
      final String token = findSecretString(getApiTokenCredentialsId).orElse(null);
      configExpanded.setGitLabToken(token);
    }
    if (configExpanded.isUseJira()) {
      listener.getLogger().println("Using jira");
      final String getApiTokenCredentialsId = configExpanded.getJiraUsernamePasswordCredentialsId();
      final StandardUsernamePasswordCredentials token =
          findSecretUsernamePassword(getApiTokenCredentialsId).orElse(null);
      configExpanded.setJiraUsername(token.getUsername());
      configExpanded.setJiraPassword(token.getPassword().getPlainText());
      listener
          .getLogger()
          .println(configExpanded.getJiraUsername() + " " + configExpanded.getJiraPassword());
    }
  }
  /** Makes sure any Jenkins variable, used in the configuration fields, are evaluated. */
  private static GitChangelogConfig expand(
      final GitChangelogConfig config, final EnvVars environment) {
    final GitChangelogConfig c = new GitChangelogConfig();

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
    c.setIgnoreCommitsIfMessageMatches(
        environment.expand(config.getIgnoreCommitsIfMessageMatches()));

    c.setUseJira(config.isUseJira());
    c.setJiraServer(environment.expand(config.getJiraServer()));
    c.setJiraIssuePattern(environment.expand(config.getJiraIssuePattern()));
    c.setJiraUsername(environment.expand(config.getJiraUsername()));
    c.setJiraPassword(environment.expand(config.getJiraPassword()));
    c.setJiraUsernamePasswordCredentialsId(
        environment.expand(config.getJiraUsernamePasswordCredentialsId()));

    c.setUseGitHub(config.isUseGitHub());
    c.setGitHubApi(environment.expand(config.getGitHubApi()));
    c.setGitHubIssuePattern(environment.expand(config.getGitHubIssuePattern()));
    c.setGitHubToken(environment.expand(config.getGitHubToken()));
    c.setGitHubApiTokenCredentialsId(environment.expand(config.getGitHubApiTokenCredentialsId()));

    c.setUseGitLab(config.isUseGitLab());
    c.setGitLabServer(environment.expand(config.getGitLabServer()));
    c.setGitLabProjectName(environment.expand(config.getGitLabProjectName()));
    c.setGitLabToken(environment.expand(config.getGitLabToken()));
    c.setGitLabApiTokenCredentialsId(environment.expand(config.getGitLabApiTokenCredentialsId()));

    c.setNoIssueName(environment.expand(config.getNoIssueName()));
    c.setIgnoreCommitsWithoutIssue(config.isIgnoreCommitsWithoutIssue());
    c.setUntaggedName(environment.expand(config.getUntaggedName()));
    c.setUseReadableTagName(config.isUseReadableTagName());
    c.setReadableTagName(environment.expand(config.getReadableTagName()));

    c.setUseIgnoreTagsIfNameMatches(config.isUseIgnoreTagsIfNameMatches());
    c.setIgnoreTagsIfNameMatches(environment.expand(config.getIgnoreTagsIfNameMatches()));

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

    final List<CustomIssue> expandedCi = new ArrayList<>();
    for (final CustomIssue ci : config.getCustomIssues()) {
      expandedCi.add(
          new CustomIssue( //
              environment.expand(ci.getName()), //
              environment.expand(ci.getPattern()), //
              environment.expand(ci.getLink()), //
              environment.expand(ci.getTitle())));
    }
    c.setCustomIssues(expandedCi);
    return c;
  }
}
