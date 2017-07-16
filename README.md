Git Changelog Jenkins Plugin [![Build Status](https://jenkins.ci.cloudbees.com/job/plugins/job/git-changelog-plugin/badge/icon)](https://jenkins.ci.cloudbees.com/job/plugins/job/git-changelog-plugin/)
===========================

Jenkins plugin to extract a changelog out of commit messages between two GIT revisions. This changelog can be postprocessed and converted
to either an human readable git changelog listing all commits, or a JIRA filter URL.

It implements basically the features of [git-changelog](https://github.com/paulwellnerbou/git-changelog) and [git-changelog-lib](https://github.com/tomasbjerre/git-changelog-lib).

The plugin is also documented in the [Jenkins wiki](https://wiki.jenkins-ci.org/display/JENKINS/Git+Changelog+Plugin).

## Usage

You can use this plugin either
* As a post-build action
 * To crate a summary on Jenkins job containing changelog or releasenotes.
 * To create a file in workspace containing changelog or releasenotes.
 * To create a MediaWiki page containing changelog or releasenotes.
 * To produce a file containing the jira filter and some informative lines.
* To provide replacement text for the [Token Macro Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Token+Macro+Plugin), to send
emails, for example.

This is also documented in [Jenkins wiki](https://wiki.jenkins-ci.org/display/JENKINS/Git+Changelog+Plugin).

### Job DSL

The `fromType` and `toType` can be:
 * commit, in combination with the actual commit hash.
 * firstCommit, will refer to the first commit in repo.
 * ref, in combination with a branch, or tag.
 * master, will refer to the master branch.

Here is a sample job DSL.

```
job('example') {
 scm {
  git('https://github.com/tomasbjerre/pull-request-notifier-for-stash.git')
 }
 publishers {
  gitChangelogRecorder {
   config {
    configFile("")
    createFileTemplateContent("")
    createFileTemplateFile("")
    createFileUseTemplateContent(false)
    createFileUseTemplateFile(false)
    customIssues {
     customIssue {
      name("")
      pattern("")
      link("")
      title("")
     }
    }
    dateFormat("")
    file("")
    fromReference("252fc9355a0fd19e06f04ec21446a0afa070d80b")
    fromType("commit")
    gitHubApi("")
    gitHubIssuePattern("")
    gitHubToken("")
    ignoreCommitsIfMessageMatches("")
    ignoreCommitsWithoutIssue(false)
    ignoreTagsIfNameMatches("")
    jiraIssuePattern("")
    jiraPassword("")
    jiraServer("")
    jiraUsername("")
    mediaWikiPassword("")
    mediaWikiTemplateContent("")
    mediaWikiTemplateFile("")
    mediaWikiTitle("")
    mediaWikiUrl("")
    mediaWikiUsername("")
    mediaWikiUseTemplateContent(false)
    mediaWikiUseTemplateFile(false)
    noIssueName("")
    readableTagName("")
    showSummary(true)
    showSummaryTemplateContent("template here")
    showSummaryTemplateFile("")
    showSummaryUseTemplateContent(true)
    showSummaryUseTemplateFile(false)
    subDirectory("")
    timeZone("")
    toReference("250ec4d56be6f3a5e9bda9f24b540479dd7cec47")
    toType("commit")
    untaggedName("")
    useConfigFile(false)
    useFile(false)
    useGitHub(false)
    useIgnoreTagsIfNameMatches(false)
    useJira(false)
    useMediaWiki(false)
    useReadableTagName(false)
    useSubDirectory(false)
   }
  }
 }
}
```

### Using a Post-build Action

When the plugin is installed, it will add some new post build actions in Jenkins job configuration.

#### Jira Filter
The following documentation explains to set up the JIRA Filter post-build action. Using the basic changelog post-build action
is even easier, as it does not need any further configuration.

On any jenkins project using Git as Source Code Management, add "Publish JIRA Filter" Post-build Action. A form with a few
input fields appears where you can configure the behaviour. Just below the input fields their meaning and default behaviour is
explained.

![](/doc/imgs/git-jira-log-post-build-action.png)

If you leave the file input empty, the information will be logged into the jenkins console.

![](/doc/imgs/git-jira-log-post-build-action-console.png)

If you specify a filename, you can use other plugins like [HTML Publisher Plugin](https://wiki.jenkins-ci.org/display/JENKINS/HTML+Publisher+Plugin)
to save the files as jenkins report.

### Using as Token Macro Replacement Provider

Having installed the [Token Macro Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Token+Macro+Plugin) plugin (which will be the case, as it is a dependency of this plugin), following macros for replacement are provided: <code>GITCHANGELOGJIRA</code> and <code>GITCHANGELOG</code>.

If you use these macros in any plugin supporting token macro replacements, this will be replaced with either the Jira URL or the changelog.

The [Email-ext plugin](https://wiki.jenkins-ci.org/display/JENKINS/Email-ext+plugin) supports token macros, so you can include this URL
in an automatically sent email.

## Development

This plugin can be built and started with maven and Jenkins' hpi plugin:

```
./run.sh
```

The functionality is implemented in [git-changelog](https://github.com/paulwellnerbou/git-changelog) and [git-changelog-lib](https://github.com/tomasbjerre/git-changelog-lib). Pull requests are welcome!


