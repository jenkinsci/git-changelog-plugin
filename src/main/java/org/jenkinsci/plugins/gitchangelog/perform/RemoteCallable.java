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

public class RemoteCallable extends MasterToSlaveCallable<RemoteResult, IOException>
    implements Serializable {

  private static final long serialVersionUID = -2489061314794088231L;
  private final GitChangelogConfig config;
  private String path = "";

  private final String workspacePath;

  public RemoteCallable(String workspacePath, GitChangelogConfig config) {

    this.workspacePath = workspacePath;
    this.config = config;
  }

  @Override
  public RemoteResult call() throws IOException {
    final RemoteResult remoteResult = new RemoteResult();
    final StringBuilder logString = new StringBuilder();
    this.path = this.workspacePath;

    if (this.config.isUseSubDirectory()) {
      this.path = this.workspacePath + "/" + this.config.getSubDirectory();
    }

    try {
      final GitChangelogApi gitChangelogApiBuilder =
          gitChangelogApiBuilder() //
              .withFromRepo(this.path);

      if (this.config.isUseConfigFile() && !isNullOrEmpty(this.config.getConfigFile())) {
        try {
          gitChangelogApiBuilder.withSettings(
              getResource(this.workspacePath + "/" + this.config.getConfigFile()).toURI().toURL());
        } catch (final URISyntaxException e) {
          propagate(e);
        }
      }

      gitChangelogApiBuilder //
          .withDateFormat(this.config.getDateFormat()) //
          .withIgnoreCommitsWithMessage(this.config.getIgnoreCommitsIfMessageMatches()) //
          .withNoIssueName(this.config.getNoIssueName()) //
          .withIgnoreCommitsWithoutIssue(this.config.isIgnoreCommitsWithoutIssue()) //
          .withTimeZone(this.config.getTimeZone()) //
          .withUntaggedName(this.config.getUntaggedName());

      if (this.config.isUseJira()) {
        gitChangelogApiBuilder //
            .withJiraServer(this.config.getJiraServer()) //
            .withJiraIssuePattern(this.config.getJiraIssuePattern()) //
            .withJiraUsername(this.config.getJiraUsername()) //
            .withJiraPassword(this.config.getJiraPassword());
      }

      if (this.config.isUseGitHub()) {
        gitChangelogApiBuilder //
            .withGitHubApi(this.config.getGitHubApi()) //
            .withGitHubIssuePattern(this.config.getGitHubIssuePattern()) //
            .withGitHubToken(this.config.getGitHubToken());
      }

      if (this.config.isUseGitLab()) {
        gitChangelogApiBuilder //
            .withGitLabServer(this.config.getGitLabServer()) //
            .withGitLabProjectName(this.config.getGitLabProjectName()) //
            .withGitLabToken(this.config.getGitLabToken());
      }

      if (this.config.isUseReadableTagName() && !isNullOrEmpty(this.config.getReadableTagName())) {
        gitChangelogApiBuilder.withReadableTagName(this.config.getReadableTagName());
      }

      if (this.config.isUseIgnoreTagsIfNameMatches()
          && !isNullOrEmpty(this.config.getIgnoreTagsIfNameMatches())) {
        gitChangelogApiBuilder.withIgnoreTagsIfNameMatches(
            this.config.getIgnoreTagsIfNameMatches());
      }

      if (isNullOrEmpty(this.config.getFromType())
          || FROMTYPE.valueOf(this.config.getFromType()) == firstCommit) {
        gitChangelogApiBuilder.withFromCommit(firstCommit.getReference());
      } else if (FROMTYPE.valueOf(this.config.getFromType()) == ref
          && !isNullOrEmpty(this.config.getFromReference())) {
        gitChangelogApiBuilder.withFromRef(this.config.getFromReference());
      } else if (FROMTYPE.valueOf(this.config.getFromType()) == commit
          && !isNullOrEmpty(this.config.getFromReference())) {
        gitChangelogApiBuilder.withFromCommit(this.config.getFromReference());
      } else {
        gitChangelogApiBuilder.withFromRef(firstCommit.getReference());
      }

      if (isNullOrEmpty(this.config.getToType())
          || FROMTYPE.valueOf(this.config.getToType()) == master) {
        gitChangelogApiBuilder.withToRef(master.getReference());
      } else if (FROMTYPE.valueOf(this.config.getToType()) == ref
          && !isNullOrEmpty(this.config.getToReference())) {
        gitChangelogApiBuilder.withToRef(this.config.getToReference());
      } else if (FROMTYPE.valueOf(this.config.getToType()) == commit
          && !isNullOrEmpty(this.config.getToReference())) {
        gitChangelogApiBuilder.withToCommit(this.config.getToReference());
      } else {
        gitChangelogApiBuilder.withToRef(firstCommit.getReference());
      }

      for (final CustomIssue ci : this.config.getCustomIssues()) {
        if (!isNullOrEmpty(ci.getName()) && !isNullOrEmpty(ci.getPattern())) {
          gitChangelogApiBuilder.withCustomIssue(
              ci.getName(), ci.getPattern(), ci.getLink(), ci.getTitle());
        }
      }

      if (this.config.showSummary()) {
        if (this.config.isShowSummaryUseTemplateFile()
            && !isNullOrEmpty(this.config.getShowSummaryTemplateFile())) {
          gitChangelogApiBuilder.withTemplatePath(
              this.workspacePath + "/" + this.config.getShowSummaryTemplateFile());
        }
        if (this.config.isShowSummaryUseTemplateContent()
            && !isNullOrEmpty(this.config.getShowSummaryTemplateContent())) {
          gitChangelogApiBuilder.withTemplateContent(this.config.getShowSummaryTemplateContent());
        }
        remoteResult.setSummary(gitChangelogApiBuilder.render());
      }

      if (this.config.isUseMediaWiki()) {
        if (this.config.isMediaWikiUseTemplateFile()
            && !isNullOrEmpty(this.config.getMediaWikiTemplateFile())) {
          gitChangelogApiBuilder.withTemplatePath(
              this.workspacePath + "/" + this.config.getMediaWikiTemplateFile());
        }
        if (this.config.isMediaWikiUseTemplateContent()
            && !isNullOrEmpty(this.config.getMediaWikiTemplateContent())) {
          gitChangelogApiBuilder.withTemplateContent(this.config.getMediaWikiTemplateContent());
        }
        final String mediaWikiFullUrl =
            this.config.getMediaWikiUrl() + "/index.php/" + this.config.getMediaWikiTitle();
        logString.append("Posting changelog to " + mediaWikiFullUrl);
        gitChangelogApiBuilder.toMediaWiki( //
            this.config.getMediaWikiUsername(), //
            this.config.getMediaWikiPassword(), //
            this.config.getMediaWikiUrl(), //
            this.config.getMediaWikiTitle());
        remoteResult.setLeftSide(this.config.getMediaWikiTitle(), mediaWikiFullUrl);
      }

      if (this.config.isUseFile()) {
        if (this.config.isCreateFileUseTemplateFile()
            && !isNullOrEmpty(this.config.getCreateFileTemplateFile())) {
          gitChangelogApiBuilder.withTemplatePath(
              this.workspacePath + "/" + this.config.getCreateFileTemplateFile());
        }
        if (this.config.isCreateFileUseTemplateContent()
            && !isNullOrEmpty(this.config.getCreateFileTemplateContent())) {
          gitChangelogApiBuilder.withTemplateContent(this.config.getCreateFileTemplateContent());
        }
        logString.append("Creating changelog " + this.config.toFile());

        final File toFile = new File(this.workspacePath + "/" + this.config.toFile());
        final boolean created = new File(toFile.getParent()).mkdirs();
        if (!created) {
          throw new IOException("Could not make dirs " + toFile.getParent());
        }
        write(gitChangelogApiBuilder.render(), toFile, UTF_8);
      }
    } catch (final Throwable e) {
      logString.append(ExceptionUtils.getStackTrace(e));
    }
    remoteResult.setLog(logString.toString());
    return remoteResult;
  }

  @Override
  public void checkRoles(RoleChecker checker) throws SecurityException {}
}
