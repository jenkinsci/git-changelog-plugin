package de.wellnerbou.jenkins.gitjira;

import de.wellnerbou.gitjira.app.AppArgs;
import de.wellnerbou.gitjira.app.GitJira;
import de.wellnerbou.gitjira.model.Changelog;
import hudson.AbortException;
import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.tokenmacro.DataBoundTokenMacro;
import org.jenkinsci.plugins.tokenmacro.MacroEvaluationException;

import java.io.IOException;

@Extension
public class GitLogJiraFilterTokenMacro extends DataBoundTokenMacro {

	public static final String GITLOGJIRAFILTER = "GITLOGJIRAFILTER";

	@Parameter
	public String jirabaseurl;

	@Parameter
	public String projects;

	@Override
	public String evaluate(final AbstractBuild<?, ?> build, final TaskListener taskListener, final String macroName) throws MacroEvaluationException, IOException, InterruptedException {
		final FilePath workspace = build.getWorkspace();
		if (workspace == null) {
			throw new AbortException("no workspace for " + build);
		}

		final AppArgs appArgs = new AppArgs();
		appArgs.setJiraBaseUrl(jirabaseurl);
		appArgs.setJiraProjectPrefixes(projects);
		appArgs.setRepo(workspace.getRemote());

		final GitJira gitJira = new GitJira(appArgs, taskListener.getLogger());
		final Changelog changelog = gitJira.changelog();
		return gitJira.jiraFilterUrl(changelog.getTickets());
	}

	@Override
	public boolean acceptsMacroName(final String macroName) {
		return GITLOGJIRAFILTER.equals(macroName);
	}
}
