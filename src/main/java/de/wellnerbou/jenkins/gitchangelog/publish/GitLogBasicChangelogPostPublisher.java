package de.wellnerbou.jenkins.gitchangelog.publish;

import de.wellnerbou.gitchangelog.app.AppArgs;
import de.wellnerbou.gitchangelog.app.GitChangelog;
import de.wellnerbou.gitchangelog.model.Changelog;
import de.wellnerbou.gitchangelog.processors.ChangelogProcessor;
import de.wellnerbou.gitchangelog.processors.basic.BasicChangelogProcessor;
import hudson.AbortException;
import hudson.EnvVars;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class GitLogBasicChangelogPostPublisher extends Publisher {

	public final String outputfile;
	public final String toRev;
	public final String fromRev;

	@DataBoundConstructor
	public GitLogBasicChangelogPostPublisher(final String outputfile, final String fromRev, final String toRev) {
		this.outputfile = outputfile;
		this.fromRev = fromRev;
		this.toRev = toRev;
	}

	@Override
	public BuildStepMonitor getRequiredMonitorService() {
		return BuildStepMonitor.NONE;
	}

	@Override
	public boolean perform(final AbstractBuild<?, ?> build, final Launcher launcher, final BuildListener listener) throws InterruptedException, IOException {
		final FilePath workspace = build.getWorkspace();
		if (workspace == null) {
			throw new AbortException("no workspace for " + build);
		}

		final EnvVars env = build.getEnvironment(listener);
		AppArgs appArgs = new AppArgs();
		final ChangelogProcessor changelogProcessor = new BasicChangelogProcessor();
		appArgs.setChangelogProcessor(changelogProcessor);
		appArgs.setRepo(workspace.getRemote());

		if(fromRev != null && fromRev.length() > 0) {
			appArgs.setFromRev(env.expand(fromRev));
		}
		if(toRev != null && toRev.length() > 0) {
			appArgs.setToRev(env.expand(toRev));
		}

		PrintStream printStream = listener.getLogger();
		if(outputfile != null && outputfile.length() > 0) {
			final File file = new File(outputfile);
			listener.getLogger().println("Saving git changelog output to file "+file.getAbsolutePath()+".");
			printStream = new PrintStream(file);
		}

		GitChangelog gitChangelog = new GitChangelog(appArgs, printStream);
		final Changelog changelog = gitChangelog.changelog();
		gitChangelog.print(changelog);

		if(outputfile != null && outputfile.length() > 0) {
			printStream.close();
		}
		return true;
	}

	@Extension
	public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

		@Override
		public String getDisplayName() {
			return "Publish Git changelog";
		}

		@Override
		public boolean isApplicable(Class<? extends AbstractProject> jobType) {
			return true;
		}
	}
}
