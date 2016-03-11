package org.jenkinsci.plugins.gitchangelog.perform;

import java.io.Serializable;

public class RemoteResult implements Serializable {

 private static final long serialVersionUID = 8363216067945804103L;
 private String log;
 private String leftSideTitle;
 private String leftSideUrl;
 private String summary;

 public void setLog(String log) {
  this.log = log;
 }

 public String getLog() {
  return log;
 }

 public void setLeftSide(String leftSideTitle, String leftSideUrl) {
  this.leftSideTitle = leftSideTitle;
  this.leftSideUrl = leftSideUrl;
 }

 public String getLeftSideTitle() {
  return leftSideTitle;
 }

 public String getLeftSideUrl() {
  return leftSideUrl;
 }

 public void setSummary(String summary) {
  this.summary = summary;
 }

 public String getSummary() {
  return summary;
 }
}
