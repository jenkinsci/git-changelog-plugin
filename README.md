# Git Changelog Jenkins Plugin

[![Build Status](https://ci.jenkins.io/job/Plugins/job/git-changelog-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/git-changelog-plugin)

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

The plugin is compatible with the [pipeline plugin](https://jenkins.io/doc/book/pipeline/getting-started/) and can be configured to support many use cases. You probably want to adjust it using the [Snippet Generator](https://jenkins.io/doc/book/pipeline/getting-started/#snippet-generator).

The `gitChangelog` step can return:

 * **Context** - An object that contains all the information needed to create a changelog. Can be used to gather information from Git like committers, emails, issues and much more.
 * **String** - A string that is a rendered changelog, ready to be published. Can be used to publish on build summary page, on a wiki, emailed and much more.

The template and context is [documented here](https://github.com/tomasbjerre/git-changelog-lib).

It can integrate with issue management systems to get titles of issues and links.

 * GitLab
 * GitHub
 * Jira

You can [create a file](https://jenkins.io/doc/pipeline/examples/) or maby publish the changelog with:

 * [HTML Publisher Plugin](https://plugins.jenkins.io/htmlpublisher)
 * [Confluence Publisher Plugin](https://plugins.jenkins.io/confluence-publisher)
 * [Email Extension](https://plugins.jenkins.io/email-ext)

You can:

 * Specify specific from/to references/commits to only inlcude a subset of all commits.
 * Filter out commits:
  * Based on message.
  * Based on commit time.
 * Filter out tags based on tag name.
 * Transform tag name to something more readable.
 * And much more...

Check the [Snippet Generator](https://jenkins.io/doc/book/pipeline/getting-started/#snippet-generator) to see all features!

## Pipeline with context

Here is an example that clones a repo and prints commit titles in the build log. The context is [documented here](https://github.com/tomasbjerre/git-changelog-lib).

```
node {
 sh """
 git clone git@github.com:jenkinsci/git-changelog-plugin.git .
 """
    
 def changelogContext = gitChangelog returnType: 'CONTEXT'

 changelogContext.tags.each { tag ->
  println "Tag: ${tag}"
  tag.commits.each {commit ->
   println "Commit: ${commit.messageTitle}"
  }
 }
}
```

## Pipeline with string

Here is an example that clones a repo and publishes the changelog on job page. The template and context is [documented here](https://github.com/tomasbjerre/git-changelog-lib).

```
node {
 sh """
 git clone git@github.com:jenkinsci/git-changelog-plugin.git .
 """
    
 def changelogString = gitChangelog returnType: 'STRING'
  template: """
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
  """

 currentBuild.description = changelogString
}
```

# Using a Post-build Action

When the plugin is installed, it will add some new post build actions in Jenkins job configuration.

## Jira Filter
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

# Using as Token Macro Replacement Provider

Having installed the [Token Macro Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Token+Macro+Plugin) plugin (which will be the case, as it is a dependency of this plugin), following macros for replacement are provided: <code>GITCHANGELOGJIRA</code> and <code>GITCHANGELOG</code>.

If you use these macros in any plugin supporting token macro replacements, this will be replaced with either the Jira URL or the changelog.

The [Email-ext plugin](https://wiki.jenkins-ci.org/display/JENKINS/Email-ext+plugin) supports token macros, so you can include this URL
in an automatically sent email.

# Development

This plugin can be built and started with maven and Jenkins' hpi plugin:

```
./run.sh
```

The functionality is implemented in [git-changelog](https://github.com/paulwellnerbou/git-changelog) and [git-changelog-lib](https://github.com/tomasbjerre/git-changelog-lib). Pull requests are welcome!


