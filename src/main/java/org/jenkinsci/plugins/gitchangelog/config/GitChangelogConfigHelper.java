package org.jenkinsci.plugins.gitchangelog.config;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.logging.Level.SEVERE;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_DATEFORMAT;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_FILE;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_GITHUB_ISSUE_PATTERN;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_IGNORE_COMMITS_REGEXP;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_JIRA_ISSUE_PATTEN;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_NO_ISSUE_NAME;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_READABLE_TAG_NAME;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_TIMEZONE;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_UNTAGGED_NAME;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.ZERO_COMMIT;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GitChangelogConfigHelper {
  public enum FROMTYPE {
    commit("commit"),
    firstCommit(ZERO_COMMIT),
    master("master"),
    ref("ref");
    private final String reference;

    FROMTYPE(final String ref) {
      this.reference = ref;
    }

    public String getReference() {
      return this.reference;
    }
  }

  private static Logger logger = Logger.getLogger(GitChangelogConfigHelper.class.getName());

  public static GitChangelogConfig createNewConfig() {
    final GitChangelogConfig config = new GitChangelogConfig();
    config.setConfigFile(DEFAULT_FILE);
    config.setDateFormat(DEFAULT_DATEFORMAT);
    config.setSubDirectory("");
    config.setFile("CHANGELOG.html");
    config.setIgnoreCommitsIfMessageMatches(DEFAULT_IGNORE_COMMITS_REGEXP);
    config.setJiraIssuePattern(DEFAULT_JIRA_ISSUE_PATTEN);
    config.setGitHubIssuePattern(DEFAULT_GITHUB_ISSUE_PATTERN);
    config.setNoIssueName(DEFAULT_NO_ISSUE_NAME);
    config.setReadableTagName(DEFAULT_READABLE_TAG_NAME);
    config.setTimeZone(DEFAULT_TIMEZONE);
    config.setUntaggedName(DEFAULT_UNTAGGED_NAME);
    config.setCreateFileTemplateContent(getResourceAsString("fileTemplateDefault.mustache"));
    config.setShowSummaryTemplateContent(getResourceAsString("summaryTemplateDefault.mustache"));

    final List<CustomIssue> customIssues = new ArrayList<>();
    customIssues.add(new CustomIssue("", "", "", ""));
    customIssues.add(new CustomIssue("", "", "", ""));
    config.setCustomIssues(customIssues);

    return config;
  }

  private static String getResourceAsString(final String filename) {
    try {
      return CharStreams.toString(
          new InputStreamReader(
              GitChangelogConfigHelper.class.getResourceAsStream(filename), UTF_8));
    } catch (final IOException e) {
      logger.log(SEVERE, "", e);
      return "";
    }
  }
}
