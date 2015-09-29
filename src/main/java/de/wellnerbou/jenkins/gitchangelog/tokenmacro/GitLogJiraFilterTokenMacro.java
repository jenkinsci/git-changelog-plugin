package de.wellnerbou.jenkins.gitchangelog.tokenmacro;

import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.jira.JiraFilterChangelogProcessor;
import hudson.Extension;

@Extension
public class GitLogJiraFilterTokenMacro extends GitLogTokenMacro {

	public static final String GITLOGJIRAFILTER = "GITCHANGELOGJIRA";

	@Parameter
	public String jirabaseurl;

	@Parameter
	public String projects;

	@Override
	protected ChangelogProcessor createChangelogProcessor() {
		JiraFilterChangelogProcessor jiraFilterChangelogProcessor = new JiraFilterChangelogProcessor();
		jiraFilterChangelogProcessor.setJiraBaseUrl(jirabaseurl);
		jiraFilterChangelogProcessor.setJiraProjectPrefixes(projects);
		return jiraFilterChangelogProcessor;
	}

	@Override
	public boolean acceptsMacroName(final String macroName) {
		return GITLOGJIRAFILTER.equals(macroName);
	}
}
