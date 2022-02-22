package org.jenkinsci.plugins.gitchangelog.steps;

import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Strings.nullToEmpty;
import static java.util.Locale.ENGLISH;
import static org.jenkinsci.plugins.gitchangelog.steps.config.REF_TYPE.COMMIT;
import static org.jenkinsci.plugins.gitchangelog.steps.config.REF_TYPE.REF;
import static org.jenkinsci.plugins.gitchangelog.steps.config.RETURN_TYPE.CONTEXT;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;
import static se.bjurr.gitchangelog.api.GitChangelogApiConstants.DEFAULT_DATEFORMAT;

import hudson.Extension;
import hudson.FilePath;
import hudson.util.ListBoxModel;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jenkins.security.MasterToSlaveCallable;
import org.jenkinsci.plugins.gitchangelog.steps.config.*;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.api.exceptions.GitChangelogRepositoryException;

public class GitChangelogStep extends Step implements Serializable {

  private static final long serialVersionUID = 795555442767777209L;
  private RETURN_TYPE returnType;
  private String template;

  private String repo;

  private RefConfig from;

  private RefConfig to;

  private String ignoreTagsIfNameMatches;
  private String ignoreCommitsIfMessageMatches;
  private String ignoreCommitsIfOlderThan;
  private String untaggedName;
  private String readableTagName;
  private String dateFormat;
  private String noIssueName;
  private String timeZone;
  private Boolean removeIssueFromMessage;
  private Boolean ignoreCommitsWithoutIssue;

  private JiraConfig jira;

  private GitHubConfig gitHub;

  private RedmineConfig redmine;

  private GitLabConfig gitLab;

  private List<CustomIssueConfig> customIssues = new ArrayList<>();

  private List<ExtendedVariableConfig> extendedVariables = new ArrayList<>();

  private String javascriptHelper;

  public List<ExtendedVariableConfig> getExtendedVariables() {
    return this.extendedVariables;
  }

  public String getRepo() {
    return this.repo;
  }

  public RefConfig getFrom() {
    return this.from;
  }

  public RefConfig getTo() {
    return this.to;
  }

  @DataBoundSetter
  public void setFrom(final RefConfig from) {
    if (from == null || isNullOrEmpty(from.getValue())) {
      this.from = null;
    } else {
      this.from = from;
    }
  }

  @DataBoundSetter
  public void setTo(final RefConfig to) {
    if (to == null || isNullOrEmpty(to.getValue())) {
      this.to = null;
    } else {
      this.to = to;
    }
  }

  @DataBoundSetter
  public void setGitLab(final GitLabConfig gitLab) {
    if (gitLab == null
        || isNullOrEmpty(gitLab.getIssuePattern())
            && isNullOrEmpty(gitLab.getProjectName())
            && isNullOrEmpty(gitLab.getServer())
            && isNullOrEmpty(gitLab.getToken())) {
      this.gitLab = null;
    } else {
      this.gitLab = gitLab;
    }
  }

  public GitLabConfig getGitLab() {
    return this.gitLab;
  }

  @DataBoundSetter
  public void setRepo(final String repo) {
    this.repo = emptyToNull(repo);
  }

  public String getIgnoreTagsIfNameMatches() {
    return this.ignoreTagsIfNameMatches;
  }

  @DataBoundSetter
  public void setIgnoreTagsIfNameMatches(final String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = emptyToNull(ignoreTagsIfNameMatches);
  }

  public String getIgnoreCommitsIfMessageMatches() {
    return this.ignoreCommitsIfMessageMatches;
  }

  @DataBoundSetter
  public void setIgnoreCommitsIfMessageMatches(final String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = emptyToNull(ignoreCommitsIfMessageMatches);
  }

  public String getIgnoreCommitsIfOlderThan() {
    return this.ignoreCommitsIfOlderThan;
  }

  @DataBoundSetter
  public void setIgnoreCommitsIfOlderThan(final String ignoreCommitsIfOlderThan) {
    this.ignoreCommitsIfOlderThan = emptyToNull(ignoreCommitsIfOlderThan);
  }

  public String getUntaggedName() {
    return this.untaggedName;
  }

  @DataBoundSetter
  public void setUntaggedName(final String untaggedName) {
    this.untaggedName = emptyToNull(untaggedName);
  }

  @DataBoundSetter
  public void setTemplate(final String template) {
    this.template = emptyToNull(template);
  }

  public String getTemplate() {
    return this.template;
  }

  public String getReadableTagName() {
    return this.readableTagName;
  }

  @DataBoundSetter
  public void setReadableTagName(final String readableTagName) {
    this.readableTagName = emptyToNull(readableTagName);
  }

  public String getDateFormat() {
    return this.dateFormat;
  }

  @DataBoundSetter
  public void setDateFormat(final String dateFormat) {
    this.dateFormat = emptyToNull(dateFormat);
  }

  public String getNoIssueName() {
    return this.noIssueName;
  }

  @DataBoundSetter
  public void setNoIssueName(final String noIssueName) {
    this.noIssueName = emptyToNull(noIssueName);
  }

  public String getTimeZone() {
    return this.timeZone;
  }

  @DataBoundSetter
  public void setTimeZone(final String timeZone) {
    this.timeZone = emptyToNull(timeZone);
  }

  public String getJavascriptHelper() {
    return this.javascriptHelper;
  }

  @DataBoundSetter
  public void setJavascriptHelper(final String javascriptHelper) {
    this.javascriptHelper = emptyToNull(javascriptHelper);
  }

  public boolean isRemoveIssueFromMessage() {
    return this.removeIssueFromMessage != null && this.removeIssueFromMessage;
  }

  @DataBoundSetter
  public void setRemoveIssueFromMessage(final Boolean removeIssueFromMessage) {
    this.removeIssueFromMessage = removeIssueFromMessage;
  }

  @DataBoundSetter
  public void setJira(final JiraConfig jira) {
    if (jira == null
        || isNullOrEmpty(jira.getIssuePattern())
            && isNullOrEmpty(jira.getPassword())
            && isNullOrEmpty(jira.getServer())
            && isNullOrEmpty(jira.getUsername())) {
      this.jira = null;
    } else {
      this.jira = jira;
    }
  }

  public JiraConfig getJira() {
    return this.jira;
  }

  public RedmineConfig getRedmine() {
    return redmine;
  }

  @DataBoundSetter
  public void setRedmine(RedmineConfig redmine) {
    if (redmine == null
        || isNullOrEmpty(redmine.getIssuePattern())
            && isNullOrEmpty(redmine.getServer())
            && isNullOrEmpty(redmine.getToken())) {
      this.redmine = null;
    } else {
      this.redmine = redmine;
    }
  }

  @DataBoundSetter
  public void setGitHub(final GitHubConfig gitHub) {
    if (gitHub == null
        || isNullOrEmpty(gitHub.getApi())
            && isNullOrEmpty(gitHub.getIssuePattern())
            && isNullOrEmpty(gitHub.getToken())) {
      this.gitHub = null;
    } else {
      this.gitHub = gitHub;
    }
  }

  public GitHubConfig getGitHub() {
    return this.gitHub;
  }

  @DataBoundSetter
  public void setReturnType(final RETURN_TYPE returnType) {
    this.returnType = returnType;
  }

  public RETURN_TYPE getReturnType() {
    return this.returnType;
  }

  public List<CustomIssueConfig> getCustomIssues() {
    return this.customIssues;
  }

  @DataBoundSetter
  public void setCustomIssues(final List<CustomIssueConfig> customIssues) {
    this.customIssues = customIssues;
  }

  @DataBoundSetter
  public void setExtendedVariables(final List<ExtendedVariableConfig> extendedVariables) {
    this.extendedVariables = extendedVariables;
  }

  public boolean isIgnoreCommitsWithoutIssue() {
    return this.ignoreCommitsWithoutIssue != null && this.ignoreCommitsWithoutIssue;
  }

  @DataBoundSetter
  public void setIgnoreCommitsWithoutIssue(final Boolean ignoreCommitsWithoutIssue) {
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
  }

  @DataBoundConstructor
  public GitChangelogStep() {}

  @Extension
  public static class DescriptorImpl extends GitChangelogStepDescriptor {
    public DescriptorImpl() {
      super("gitChangelog", "Changelog from Git repository");
    }

    @Restricted(NoExternalUse.class)
    public ListBoxModel doFillReturnTypeItems() {
      final ListBoxModel items = new ListBoxModel();
      items.add(RETURN_TYPE.STRING.name());
      items.add(RETURN_TYPE.CONTEXT.name());
      return items;
    }
  }

  @Override
  public StepExecution start(final StepContext context) {
    return new SynchronousNonBlockingStepExecution<Object>(context) {

      private static final long serialVersionUID = 1L;

      @Override
      protected Object run() throws Exception {
        final FilePath workspace = context.get(FilePath.class);

        final MasterToSlaveCallable<Object, Exception> callable =
            new MasterToSlaveCallable<Object, Exception>() {
              private static final long serialVersionUID = 1L;

              @Override
              public Object call() throws Exception {
                return GitChangelogStep.this.perform(workspace);
              }
            };

        return workspace.act(callable);
      }
    };
  }

  private Object perform(final FilePath workspace)
      throws ParseException, GitChangelogRepositoryException, IOException {
    Date ignoreCommitsIfOlderThanDate = null;
    if (!isNullOrEmpty(this.ignoreCommitsIfOlderThan)) {
      final DateFormat format = new SimpleDateFormat(DEFAULT_DATEFORMAT, ENGLISH);
      ignoreCommitsIfOlderThanDate = format.parse(this.ignoreCommitsIfOlderThan);
    }
    final String remoteRepo = workspace.getRemote() + "/" + nullToEmpty(this.repo);
    final GitChangelogApi b =
        gitChangelogApiBuilder() //
            .withFromRepo(remoteRepo) //
            .withDateFormat(this.dateFormat) //
            .withIgnoreCommitsOlderThan(ignoreCommitsIfOlderThanDate) //
            .withIgnoreCommitsWithMessage(nullToEmpty(this.ignoreCommitsIfMessageMatches)) //
            .withIgnoreCommitsWithoutIssue(
                this.ignoreCommitsWithoutIssue != null && this.ignoreCommitsWithoutIssue) //
            .withIgnoreTagsIfNameMatches(this.ignoreTagsIfNameMatches) //
            .withNoIssueName(this.noIssueName) //
            .withReadableTagName(this.readableTagName) //
            .withRemoveIssueFromMessageArgument(
                this.removeIssueFromMessage != null && this.removeIssueFromMessage) //
            .withTimeZone(this.timeZone) //
            .withUntaggedName(this.untaggedName);
    if (this.javascriptHelper != null) {
      b.withHandlebarsHelper(this.javascriptHelper);
    }
    if (this.extendedVariables != null) {
      final Map<String, Object> extendedVariablesMap = new HashMap<>();
      for (final ExtendedVariableConfig e : this.extendedVariables) {
        extendedVariablesMap.put(e.getName(), e.getValue());
      }
      b.withExtendedVariables(extendedVariablesMap);
    }
    if (this.from != null && this.from.getType() == COMMIT) {
      b.withFromCommit(this.from.getValue());
    }
    if (this.from != null && this.from.getType() == REF) {
      b.withFromRef(this.from.getValue());
    }
    if (this.to != null && this.to.getType() == COMMIT) {
      b.withToCommit(this.to.getValue());
    }
    if (this.to != null && this.to.getType() == REF) {
      b.withToRef(this.to.getValue());
    }
    for (final CustomIssueConfig issue : this.customIssues) {
      b.withCustomIssue(
          issue.getName(), issue.getIssuePattern(), issue.getLink(), issue.getTitle());
    }
    if (this.gitHub != null) {
      b //
          .withGitHubEnabled(true)
          .withGitHubApi(this.gitHub.getApi()) //
          .withGitHubIssuePattern(this.gitHub.getIssuePattern()) //
          .withGitHubToken(this.gitHub.getToken());
    }
    if (this.gitLab != null) {
      b //
          .withGitLabEnabled(true)
          .withGitLabIssuePattern(this.gitLab.getIssuePattern()) //
          .withGitLabProjectName(this.gitLab.getProjectName()) //
          .withGitLabServer(this.gitLab.getServer()) //
          .withGitLabToken(this.gitLab.getToken());
    }

    if (this.jira != null) {
      b //
          .withJiraEnabled(true)
          .withJiraIssuePattern(this.jira.getIssuePattern()) //
          .withJiraServer(this.jira.getServer()) //
          .withJiraUsername(this.jira.getUsername()) //
          .withJiraPassword(this.jira.getPassword())
          .withJiraBasicAuthString(this.jira.getBasicAuthString())
          .withJiraBearer(this.jira.getBearer());
    }
    if (this.redmine != null) {
      b //
          .withRedmineEnabled(true)
          .withUseIntegrations(true)
          .withRedmineIssuePattern(this.redmine.getIssuePattern()) //
          .withRedmineServer(this.redmine.getServer()) //
          .withRedmineUsername(this.redmine.getUsername()) //
          .withRedminePassword(this.redmine.getPassword())
          .withRedmineToken(this.redmine.getToken());
    }
    if (this.returnType == CONTEXT) {
      return b.getChangelog();
    } else {
      if (isNullOrEmpty(this.template)) {
        throw new RuntimeException("No template specified");
      }
      return b.withTemplateContent(this.template) //
          .render();
    }
  }
}
