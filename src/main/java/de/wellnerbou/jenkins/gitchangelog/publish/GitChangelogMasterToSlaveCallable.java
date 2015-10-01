package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.app.AppArgs;
import de.wellnerbou.gitchangelog.app.GitChangelog;
import de.wellnerbou.gitchangelog.model.Changelog;
import jenkins.security.MasterToSlaveCallable;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

public class GitChangelogMasterToSlaveCallable extends MasterToSlaveCallable<String, IOException> implements Serializable {
	private final AppArgs appArgs;
	private final PrintStream printStream;

	public GitChangelogMasterToSlaveCallable(final AppArgs appArgs, final PrintStream printStream) {
		this.appArgs = appArgs;
		this.printStream = printStream;
	}

	public String call() throws IOException {
		final GitChangelog gitChangelog = new GitChangelog(appArgs, printStream);
		final Changelog changelog = gitChangelog.changelog();
		return gitChangelog.print(changelog);
	}
}
