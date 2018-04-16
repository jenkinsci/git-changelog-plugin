package org.jenkinsci.plugins.gitchangelog.steps;

import hudson.model.TaskListener;

import java.util.Collections;
import java.util.Set;

import javax.annotation.Nonnull;

import org.jenkinsci.plugins.workflow.steps.StepDescriptor;

public class GitChangelogStepDescriptor extends StepDescriptor {

  private final String functionName;
  private final String displayName;

  public GitChangelogStepDescriptor(final String functionName, final String displayName) {
    this.functionName = functionName;
    this.displayName = displayName;
  }

  @Override
  public String getFunctionName() {
    return functionName;
  }

  @Override
  @Nonnull
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public Set<? extends Class<?>> getRequiredContext() {
    return Collections.singleton(TaskListener.class);
  }
}
