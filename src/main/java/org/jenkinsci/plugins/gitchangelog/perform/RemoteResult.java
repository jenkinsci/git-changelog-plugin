package org.jenkinsci.plugins.gitchangelog.perform;

import java.io.Serializable;

public class RemoteResult implements Serializable {

  private static final long serialVersionUID = 8363216067945804103L;
  private String leftSideTitle;
  private String leftSideUrl;
  private String log;
  private String summary;

  public String getLeftSideTitle() {
    return this.leftSideTitle;
  }

  public String getLeftSideUrl() {
    return this.leftSideUrl;
  }

  public String getLog() {
    return this.log;
  }

  public String getSummary() {
    return this.summary;
  }

  public void setLeftSide(String leftSideTitle, String leftSideUrl) {
    this.leftSideTitle = leftSideTitle;
    this.leftSideUrl = leftSideUrl;
  }

  public void setLog(String log) {
    this.log = log;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
}
