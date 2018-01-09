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

# Pipeline

The plugin is compatible with the [pipeline plugin](https://jenkins.io/doc/book/pipeline/getting-started/) and can be configured to support many use cases. Here is a very simple one. You probably want to adjust it using the [Snippet Generator](https://jenkins.io/doc/book/pipeline/getting-started/#snippet-generator).

![Snippet Generator](/doc/imgs/snippet-generator.png)

```
node {
 deleteDir()

 stage('Clone repo') {
  sh "git clone https://github.com/tomasbjerre/git-changelog-lib.git ."
 }
 
 step([$class: 'GitChangelogRecorder',
 config: [
 untaggedName: 'Unreleased',
 noIssueName: 'No issue',
 useReadableTagName: true,
 readableTagName: '/([^/]+?)$',
 
 useGitHub: true,
 gitHubApi: 'https://api.github.com/repos/tomasbjerre/git-changelog-lib',
 
 useJira: true,
 jiraIssuePattern: '\\bJENKINS-([0-9]+)\\b',
 
 fromReference: '',
 fromType: 'firstCommit',
 toReference: '',
 toType: 'master',
 
 showSummary: true,
 showSummaryUseTemplateContent: true,
 showSummaryTemplateContent: '''<h1> Git Changelog Lib changelog </h1>

<p>
Changelog of Git Changelog Lib.
</p>

{{#tags}}
<h2> {{name}} </h2>
 {{#issues}}
  {{#hasIssue}}
   {{#hasLink}}
<h2> {{name}} <a href="{{link}}">{{issue}}</a> {{title}} </h2>
   {{/hasLink}}
   {{^hasLink}}
<h2> {{name}} {{issue}} {{title}} </h2>
   {{/hasLink}}
  {{/hasIssue}}
  {{^hasIssue}}
<h2> {{name}} </h2>
  {{/hasIssue}}


   {{#commits}}
<a href="https://github.com/tomasbjerre/git-changelog-lib/commit/{{hash}}">{{hash}}</a> {{authorName}} <i>{{commitTime}}</i>
<p>
<h3>{{{messageTitle}}}</h3>

{{#messageBodyItems}}
 <li> {{.}}</li> 
{{/messageBodyItems}}
</p>


  {{/commits}}

 {{/issues}}
 <hr/>
{{/tags}}
'''
]])
}
```


### Job DSL

Here is a sample job DSL.

```
freeStyleJob('Git Changelog Job') {
  scm {
    git {
      remote {
        name('origin')
        url('https://github.com/tomasbjerre/git-changelog-lib.git')
      }
    }
  }
  publishers {
    gitChangelogRecorder {
      config {
        fromType("commit")
        fromReference("20aca44")
        toType("ref")
        toReference("master")

        showSummary(true)
        showSummaryUseTemplateContent(true)
        showSummaryTemplateContent("""
<h1> Git Changelog changelog </h1>

<p>
Changelog of Git Changelog.
</p>

{{#tags}}
<h2> {{name}} </h2>
 {{#issues}}
  {{#hasIssue}}
   {{#hasLink}}
<h2> {{name}} <a href="{{link}}">{{issue}}</a> {{title}} </h2>
   {{/hasLink}}
   {{^hasLink}}
<h2> {{name}} {{issue}} {{title}} </h2>
   {{/hasLink}}
  {{/hasIssue}}
  {{^hasIssue}}
<h2> {{name}} </h2>
  {{/hasIssue}}


   {{#commits}}
<a href="https://github.com/tomasbjerre/git-changelog-lib/commit/{{hash}}">{{hash}}</a> {{authorName}} <i>{{commitTime}}</i>
<p>
<h3>{{{messageTitle}}}</h3>

{{#messageBodyItems}}
 <li> {{.}}</li> 
{{/messageBodyItems}}
</p>


  {{/commits}}

 {{/issues}}
{{/tags}}
        """)


        useMediaWiki(true)
        mediaWikiUseTemplateContent(true)
        mediaWikiTemplateContent("""
__NOTOC__

= Git Changelog changelog =
Changelog of Git Changelog.

{{#tags}}
== {{name}} ==
 {{#issues}}
  {{#hasIssue}}
   {{#hasLink}}
=== {{name}} [{{link}} {{issue}}] {{title}} ===
   {{/hasLink}}
   {{^hasLink}}
=== {{name}} {{issue}} {{title}} ===
   {{/hasLink}}
  {{/hasIssue}}
  {{^hasIssue}}
=== {{name}} ===
  {{/hasIssue}}

   {{#commits}}
[https://github.com/tomasbjerre/git-changelog-lib/commit/{{hash}} {{hash}}] {{authorName}} {{commitTime}}

'''{{{messageTitle}}}'''

{{#messageBodyItems}}
 * {{.}} 
{{/messageBodyItems}}

  {{/commits}}

 {{/issues}}
{{/tags}}
        """)
        mediaWikiTitle("PRNFB Changelog")
        mediaWikiUrl("http://web:80/w")
        mediaWikiUsername(null)
        mediaWikiPassword(null)
        mediaWikiUseTemplateFile(false)
        mediaWikiTemplateFile(null)
        
        useGitHub(true)
        gitHubApi("https://api.github.com/repos/tomasbjerre/git-changelog-lib")
        gitHubIssuePattern(null)
        gitHubToken(null)
        gitHubApiTokenCredentialsId(null)
        useGitHubApiTokenCredentials(false)

        useReadableTagName(true)
        readableTagName("/([^/]+?)\$")

        configFile(null)
        createFileTemplateContent(null)
        createFileTemplateFile(null)
        createFileUseTemplateContent(false)
        createFileUseTemplateFile(false)
        customIssues {}
        dateFormat(null)
        file(null)
        useGitLab(false)
        gitLabServer(null)
        gitLabProjectName(null)
        gitLabToken(null)
        ignoreCommitsIfMessageMatches(null)
        ignoreCommitsWithoutIssue(false)
        ignoreTagsIfNameMatches(null)
        jiraIssuePattern(null)
        jiraPassword(null)
        jiraServer(null)
        jiraUsername(null)
        jiraUsernamePasswordCredentialsId(null)
        useJiraUsernamePasswordCredentialsId(false)
        noIssueName(null)
        showSummaryTemplateFile(null)
        showSummaryUseTemplateFile(false)
        subDirectory(null)
        timeZone(null)
        untaggedName(null)
        useConfigFile(false)
        useFile(false)
        useIgnoreTagsIfNameMatches(false)
        useJira(false)
        useSubDirectory(false)
        gitLabApiTokenCredentialsId(null)
        useGitLabApiTokenCredentials(false)
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


