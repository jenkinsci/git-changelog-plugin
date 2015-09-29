package de.wellnerbou.jenkins.gitchangelog.tokenmacro;

import de.wellnerbou.gitchangelog.app.AppArgs;
import de.wellnerbou.gitchangelog.app.GitChangelog;
import de.wellnerbou.gitchangelog.model.Changelog;
import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.jira.JiraFilterChangelogProcessor;
import hudson.AbortException;
import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.tokenmacro.DataBoundTokenMacro;
import org.jenkinsci.plugins.tokenmacro.MacroEvaluationException;

import java.io.IOException;

public abstract class GitLogTokenMacro extends DataBoundTokenMacro {

	@Override
	public String evaluate(final AbstractBuild<?, ?> build, final TaskListener taskListener, final String macroName) throws MacroEvaluationException, IOException, InterruptedException {
		final FilePath workspace = build.getWorkspace();
		if (workspace == null) {
			throw new AbortException("no workspace for " + build);
		}

		final AppArgs appArgs = new AppArgs();
		final ChangelogProcessor changelogProcessor = createChangelogProcessor();
		appArgs.setChangelogProcessor(changelogProcessor);
		appArgs.setRepo(workspace.getRemote());

		final GitChangelog gitChangelog = new GitChangelog(appArgs, taskListener.getLogger());
		final Changelog changelog = gitChangelog.changelog();
		return gitChangelog.print(changelog);
	}

	protected abstract ChangelogProcessor createChangelogProcessor();
}
