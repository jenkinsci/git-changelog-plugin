package org.jenkinsci.plugins.gitchangelog.perform;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Files.write;
import static com.google.common.io.Resources.getResource;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static org.jenkinsci.plugins.gitchangelog.GitChangelogLogger.doLog;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.commit;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.firstCommit;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.master;
import static org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE.ref;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;
import hudson.EnvVars;
import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.remoting.VirtualChannel;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.jenkinsci.plugins.gitchangelog.config.CustomIssue;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfig;
import org.jenkinsci.plugins.gitchangelog.config.GitChangelogConfigHelper.FROMTYPE;
import org.jenkinsci.remoting.RoleChecker;

import se.bjurr.gitchangelog.api.GitChangelogApi;

public class GitChangelogPerformer {

 public static void performerPerform(final GitChangelogConfig configUnexpanded, final AbstractBuild<?, ?> build,
   final BuildListener listener) {
  try {
   EnvVars env = build.getEnvironment(listener);
   final GitChangelogConfig config = expand(configUnexpanded, env);
   listener.getLogger().println("---");
   listener.getLogger().println("--- Git Changelog ---");
   listener.getLogger().println("---");

   File workspace = new File(build.getExecutor().getCurrentWorkspace().toURI());
   FilePath fp = new FilePath(workspace);
   fp.act(new FileCallable<Void>() {

    private static final long serialVersionUID = -9134176734041293984L;

    @Override
    public void checkRoles(RoleChecker arg0) throws SecurityException {

    }

    @Override
    public Void invoke(File workspace, VirtualChannel channel) throws IOException, InterruptedException {
     doPerform(build, listener, config, workspace);
     return null;
    }

    private void doPerform(final AbstractBuild<?, ?> build, final BuildListener listener,
      final GitChangelogConfig config, File workspace) throws MalformedURLException, IOException {
     String workspacePath = workspace.getAbsolutePath();

     GitChangelogApi gitChangelogApiBuilder = gitChangelogApiBuilder()//
       .withFromRepo(workspacePath);

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
        .withGitHubIssuePattern(config.getGitHubIssuePattern());
     }

     if (config.isUseReadableTagName() && !isNullOrEmpty(config.getReadableTagName())) {
      gitChangelogApiBuilder.withReadableTagName(config.getReadableTagName());
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
       gitChangelogApiBuilder.withCustomIssue(ci.getName(), ci.getPattern(), ci.getLink());
      }
     }

     if (config.showSummary()) {
      if (config.isShowSummaryUseTemplateFile() && !isNullOrEmpty(config.getShowSummaryTemplateFile())) {
       gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getShowSummaryTemplateFile());
      }
      if (config.isShowSummaryUseTemplateContent() && !isNullOrEmpty(config.getShowSummaryTemplateContent())) {
       gitChangelogApiBuilder.withTemplateContent(config.getShowSummaryTemplateContent());
      }
      build.addAction(new GitChangelogSummaryDecorator(gitChangelogApiBuilder.render()));
     }

     if (config.isUseMediaWiki()) {
      if (config.isMediaWikiUseTemplateFile() && !isNullOrEmpty(config.getMediaWikiTemplateFile())) {
       gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getMediaWikiTemplateFile());
      }
      if (config.isMediaWikiUseTemplateContent() && !isNullOrEmpty(config.getMediaWikiTemplateContent())) {
       gitChangelogApiBuilder.withTemplateContent(config.getMediaWikiTemplateContent());
      }
      String mediaWikiFullUrl = config.getMediaWikiUrl() + "/index.php/" + config.getMediaWikiTitle();
      doLog(listener, INFO, "Posting changelog to " + mediaWikiFullUrl);
      gitChangelogApiBuilder.toMediaWiki(//
        config.getMediaWikiUsername(), //
        config.getMediaWikiPassword(),//
        config.getMediaWikiUrl(), //
        config.getMediaWikiTitle());

      build.addAction(new GitChangelogLeftsideBuildDecorator(config.getMediaWikiTitle(), mediaWikiFullUrl));
     }

     if (config.isUseFile()) {
      if (config.isCreateFileUseTemplateFile() && !isNullOrEmpty(config.getCreateFileTemplateFile())) {
       gitChangelogApiBuilder.withTemplatePath(workspacePath + "/" + config.getCreateFileTemplateFile());
      }
      if (config.isCreateFileUseTemplateContent() && !isNullOrEmpty(config.getCreateFileTemplateContent())) {
       gitChangelogApiBuilder.withTemplateContent(config.getCreateFileTemplateContent());
      }
      doLog(listener, INFO, "Creating changelog " + config.toFile());
      File toFile = new File(workspacePath + "/" + config.toFile());
      new File(toFile.getParent()).mkdirs();
      write(gitChangelogApiBuilder.render(), toFile, UTF_8);
     }
    }
   });

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

  c.setNoIssueName(environment.expand(config.getNoIssueName()));
  c.setUntaggedName(environment.expand(config.getUntaggedName()));
  c.setUseReadableTagName(config.isUseReadableTagName());
  c.setReadableTagName(environment.expand(config.getReadableTagName()));

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
     environment.expand(ci.getLink())));
  }
  c.setCustomIssues(expandedCi);
  return c;
 }
}
