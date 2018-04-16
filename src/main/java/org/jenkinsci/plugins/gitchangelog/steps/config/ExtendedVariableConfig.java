package org.jenkinsci.plugins.gitchangelog.steps.config;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.umd.cs.findbugs.annotations.NonNull;

public class ExtendedVariableConfig extends AbstractDescribableImpl<ExtendedVariableConfig>
    implements Serializable {
  private static final long serialVersionUID = 8842918044772949798L;
  private final String name;
  private final String value;

  @Extension
  public static class DescriptorImpl extends Descriptor<ExtendedVariableConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "Extended Variable";
    }
  }

  @DataBoundConstructor
  public ExtendedVariableConfig(final String name, final String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}
