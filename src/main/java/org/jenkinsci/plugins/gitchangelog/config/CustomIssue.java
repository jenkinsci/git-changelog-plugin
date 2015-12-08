package org.jenkinsci.plugins.gitchangelog.config;

public class CustomIssue {
 private String name;
 private String pattern;
 private String link;

 public CustomIssue(String name, String pattern, String link) {
  this.name = name;
  this.pattern = pattern;
  this.link = link;
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

 public String getLink() {
  return link;
 }

 public String getName() {
  return name;
 }

 public String getPattern() {
  return pattern;
 }
}
