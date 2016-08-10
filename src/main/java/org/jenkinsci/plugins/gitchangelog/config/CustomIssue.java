package org.jenkinsci.plugins.gitchangelog.config;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;

public class CustomIssue implements Serializable {
 private static final long serialVersionUID = -6202256680695752956L;
 private String link;
 private String name;
 private String pattern;
 private final String title;

 @DataBoundConstructor
 public CustomIssue(String name, String pattern, String link, String title) {
  this.name = name;
  this.pattern = pattern;
  this.link = link;
  this.title = title;
 }

 public String getLink() {
  return this.link;
 }

 public String getName() {
  return this.name;
 }

 public String getPattern() {
  return this.pattern;
 }

 public String getTitle() {
  return this.title;
 }

 public void setLink(String link) {
  this.link = link;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setPattern(String pattern) {
  this.pattern = pattern;
 }
}
