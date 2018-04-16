package org.jenkinsci.plugins.gitchangelog.steps.config;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.util.ListBoxModel;

import java.io.Serializable;

import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;

import edu.umd.cs.findbugs.annotations.NonNull;

public class RefConfig extends AbstractDescribableImpl<RefConfig> implements Serializable {
  private static final long serialVersionUID = -7003493790467059304L;
  private final REF_TYPE type;
  private final String value;

  @DataBoundConstructor
  public RefConfig(final REF_TYPE type, final String value) {
    this.type = type;
    this.value = value;
  }

  public REF_TYPE getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  @Extension
  public static class DescriptorImpl extends Descriptor<RefConfig> {
    @NonNull
    @Override
    public String getDisplayName() {
      return "Reference";
    }

    @Restricted(NoExternalUse.class)
    public ListBoxModel doFillTypeItems() {
      final ListBoxModel items = new ListBoxModel();
      items.add(REF_TYPE.REF.name());
      items.add(REF_TYPE.COMMIT.name());
      return items;
    }
  }
}
