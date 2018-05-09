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

import org.jenkinsci.plugins.gitchangelog.steps.config.RETURN_TYPE;
import org.jenkinsci.plugins.gitchangelog.steps.config.CustomIssueConfig;
import org.jenkinsci.plugins.gitchangelog.steps.config.ExtendedVariableConfig;
import org.jenkinsci.plugins.gitchangelog.steps.config.GitHubConfig;
import org.jenkinsci.plugins.gitchangelog.steps.config.GitLabConfig;
import org.jenkinsci.plugins.gitchangelog.steps.config.JiraConfig;
import org.jenkinsci.plugins.gitchangelog.steps.config.RefConfig;
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

  private GitLabConfig gitLab;

  private List<CustomIssueConfig> customIssues = new ArrayList<>();

  private List<ExtendedVariableConfig> extendedVariables = new ArrayList<>();

  public List<ExtendedVariableConfig> getExtendedVariables() {
    return extendedVariables;
  }

  public String getRepo() {
    return repo;
  }

  public RefConfig getFrom() {
    return from;
  }

  public RefConfig getTo() {
    return to;
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
    return gitLab;
  }

  @DataBoundSetter
  public void setRepo(final String repo) {
    this.repo = emptyToNull(repo);
  }

  public String getIgnoreTagsIfNameMatches() {
    return ignoreTagsIfNameMatches;
  }

  @DataBoundSetter
  public void setIgnoreTagsIfNameMatches(final String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = emptyToNull(ignoreTagsIfNameMatches);
  }

  public String getIgnoreCommitsIfMessageMatches() {
    return ignoreCommitsIfMessageMatches;
  }

  @DataBoundSetter
  public void setIgnoreCommitsIfMessageMatches(final String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = emptyToNull(ignoreCommitsIfMessageMatches);
  }

  public String getIgnoreCommitsIfOlderThan() {
    return ignoreCommitsIfOlderThan;
  }

  @DataBoundSetter
  public void setIgnoreCommitsIfOlderThan(final String ignoreCommitsIfOlderThan) {
    this.ignoreCommitsIfOlderThan = emptyToNull(ignoreCommitsIfOlderThan);
  }

  public String getUntaggedName() {
    return untaggedName;
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
    return template;
  }

  public String getReadableTagName() {
    return readableTagName;
  }

  @DataBoundSetter
  public void setReadableTagName(final String readableTagName) {
    this.readableTagName = emptyToNull(readableTagName);
  }

  public String getDateFormat() {
    return dateFormat;
  }

  @DataBoundSetter
  public void setDateFormat(final String dateFormat) {
    this.dateFormat = emptyToNull(dateFormat);
  }

  public String getNoIssueName() {
    return noIssueName;
  }

  @DataBoundSetter
  public void setNoIssueName(final String noIssueName) {
    this.noIssueName = emptyToNull(noIssueName);
  }

  public String getTimeZone() {
    return timeZone;
  }

  @DataBoundSetter
  public void setTimeZone(final String timeZone) {
    this.timeZone = emptyToNull(timeZone);
  }

  public boolean isRemoveIssueFromMessage() {
    return removeIssueFromMessage != null && removeIssueFromMessage;
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
    return jira;
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
    return gitHub;
  }

  @DataBoundSetter
  public void setReturnType(final RETURN_TYPE returnType) {
    this.returnType = returnType;
  }

  public RETURN_TYPE getReturnType() {
    return returnType;
  }

  public List<CustomIssueConfig> getCustomIssues() {
    return customIssues;
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
    return ignoreCommitsWithoutIssue != null && ignoreCommitsWithoutIssue;
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
                return perform(workspace);
              }
            };

        return workspace.act(callable);
      }
    };
  }

  private Object perform(final FilePath workspace)
      throws ParseException, GitChangelogRepositoryException {
    Date ignoreCommitsIfOlderThanDate = null;
    if (!isNullOrEmpty(ignoreCommitsIfOlderThan)) {
      final DateFormat format = new SimpleDateFormat(DEFAULT_DATEFORMAT, ENGLISH);
      ignoreCommitsIfOlderThanDate = format.parse(ignoreCommitsIfOlderThan);
    }
    final String remoteRepo = workspace.getRemote() + "/" + nullToEmpty(repo);
    final GitChangelogApi b =
        gitChangelogApiBuilder() //
            .withFromRepo(remoteRepo) //
            .withDateFormat(dateFormat) //
            .withIgnoreCommitsOlderThan(ignoreCommitsIfOlderThanDate) //
            .withIgnoreCommitsWithMessage(nullToEmpty(ignoreCommitsIfMessageMatches)) //
            .withIgnoreCommitsWithoutIssue(
                ignoreCommitsWithoutIssue != null && ignoreCommitsWithoutIssue) //
            .withIgnoreTagsIfNameMatches(ignoreTagsIfNameMatches) //
            .withNoIssueName(noIssueName) //
            .withReadableTagName(readableTagName) //
            .withRemoveIssueFromMessageArgument(
                removeIssueFromMessage != null && removeIssueFromMessage) //
            .withTimeZone(timeZone) //
            .withUntaggedName(untaggedName);
    if (extendedVariables != null) {
      final Map<String, Object> extendedVariablesMap = new HashMap<>();
      for (final ExtendedVariableConfig e : extendedVariables) {
        extendedVariablesMap.put(e.getName(), e.getValue());
      }
      b.withExtendedVariables(extendedVariablesMap);
    }
    if (from != null && from.getType() == COMMIT) {
      b.withFromCommit(from.getValue());
    }
    if (from != null && from.getType() == REF) {
      b.withFromRef(from.getValue());
    }
    if (to != null && to.getType() == COMMIT) {
      b.withToCommit(to.getValue());
    }
    if (to != null && to.getType() == REF) {
      b.withToRef(to.getValue());
    }
    for (final CustomIssueConfig issue : customIssues) {
      b.withCustomIssue(
          issue.getName(), issue.getIssuePattern(), issue.getLink(), issue.getTitle());
    }
    if (gitHub != null) {
      b //
          .withGitHubApi(gitHub.getApi()) //
          .withGitHubIssuePattern(gitHub.getIssuePattern()) //
          .withGitHubToken(gitHub.getToken());
    }
    if (gitLab != null) {
      b //
          .withGitLabIssuePattern(gitLab.getIssuePattern()) //
          .withGitLabProjectName(gitLab.getProjectName()) //
          .withGitLabServer(gitLab.getServer()) //
          .withGitLabToken(gitLab.getToken());
    }
    if (jira != null) {
      b //
          .withJiraIssuePattern(jira.getIssuePattern()) //
          .withJiraServer(jira.getServer()) //
          .withJiraUsername(jira.getUsername()) //
          .withJiraPassword(jira.getPassword());
    }
    if (returnType == CONTEXT) {
      return b.getChangelog(true);
    } else {
      if (isNullOrEmpty(template)) {
        throw new RuntimeException("No template specified");
      }
      return b.withTemplateContent(template) //
          .render();
    }
  }
}
