package de.wellnerbou.jenkins.gitchangelog.tokenmacro;

import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.basic.BasicChangelogProcessor;
import hudson.Extension;

@Extension
public class GitLogBasicChangelogTokenMacro extends GitLogTokenMacro {

	public static final String GITCHANGELOG = "GITCHANGELOG";

	@Override
	protected ChangelogProcessor createChangelogProcessor() {
		return new BasicChangelogProcessor();
	}

	@Override
	public boolean acceptsMacroName(final String macroName) {
		return GITCHANGELOG.equals(macroName);
	}
}
