Git JIRA Log Jenkins Plugin
===========================

Jenkins plugin creating automatically the JIRA filter URL based on the tickets found in the git log

## Usage

You can use this plugin either as a post-build action which will produce a file containing the jira filter and some informative lines,
or you can use it providing replacement text for the [Token Macro Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Token+Macro+Plugin), to send
emails, for example.

### Using a Post-build Action

On any jenkins project using Git as Source Code Management, add "Publish JIRA Filter" Post-build Action. A form with a few
input fields appears where you can configure the behaviour. Just below the input fields their meaning and default behaviour is
explained.

![](/doc/imgs/git-jira-log-post-build-action.png)

If you leave the file input empty, the information will be logged into the jenkins console.

![](/doc/imgs/git-jira-log-post-build-action-console.png)

If you specify a filename, you can use other plugins like [HTML Publisher Plugin](https://wiki.jenkins-ci.org/display/JENKINS/HTML+Publisher+Plugin)
to save the files as jenkins report.

### Using as Token Macro Replacement Provider

Having installed this plugin, automatically following macro for replacement is provided: <code>$GITLOGJIRAFILTER</code>. If you use
this macro in any plugin supporting token macro replacements, this will be replaced with the URL to your JIRA installation.

The [Email-ext plugin](https://wiki.jenkins-ci.org/display/JENKINS/Email-ext+plugin) supports token macros, so you can include this URL
in an automatically sent email.

## Development

This plugin can be built and started with maven and Jenkins' hpi plugin:

```
mvn clean install
./run.sh
```

The run scripts opens a debug port on 8000.

The functionality is implemented in [git-jira-log](https://github.com/paulwellnerbou/git-jira-log). Pull requests are welcome!
