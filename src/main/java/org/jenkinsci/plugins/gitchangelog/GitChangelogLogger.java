package org.jenkinsci.plugins.gitchangelog;

import hudson.model.TaskListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GitChangelogLogger {
 private static Logger logger = Logger.getLogger(GitChangelogLogger.class.getName());

 public static void doLog(Level level, String string) {
  doLog(level, string, null);
 }

 public static void doLog(Level level, String string, Throwable t) {
  logger.log(level, string, t);
 }

 public static void doLog(TaskListener listener, Level level, String string) {
  doLog(listener, level, string, null);
 }

 public static void doLog(TaskListener listener, Level level, String string, Throwable t) {
  listener.getLogger().println(string);
  doLog(level, string, t);
 }

 private GitChangelogLogger() {
 }
}
