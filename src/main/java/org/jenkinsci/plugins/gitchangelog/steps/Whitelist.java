package org.jenkinsci.plugins.gitchangelog.steps;

import hudson.Extension;
import java.io.IOException;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.ProxyWhitelist;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.StaticWhitelist;

/**
 * So that the user don't have to approve all these manually when fiddling with pipeline scripts.
 */
@Extension
public class Whitelist extends ProxyWhitelist {
  public Whitelist() throws IOException {
    super(
        new StaticWhitelist(
            "method se.bjurr.gitchangelog.api.model.Changelog getIssues",
            "method se.bjurr.gitchangelog.api.model.Changelog getAuthors",
            "method se.bjurr.gitchangelog.api.model.Changelog getCommits",
            "method se.bjurr.gitchangelog.api.model.Changelog getOwnerName",
            "method se.bjurr.gitchangelog.api.model.Changelog getRepoName",
            "method se.bjurr.gitchangelog.api.model.Changelog getTags",
            "method se.bjurr.gitchangelog.api.model.Changelog getIssueTypes",
            "method se.bjurr.gitchangelog.api.model.Author getAuthorEmail",
            "method se.bjurr.gitchangelog.api.model.Author getAuthorName",
            "method se.bjurr.gitchangelog.api.model.Author getCommits",
            "method se.bjurr.gitchangelog.api.model.Commit getAuthorEmailAddress",
            "method se.bjurr.gitchangelog.api.model.Commit getAuthorName",
            "method se.bjurr.gitchangelog.api.model.Commit getCommitTime",
            "method se.bjurr.gitchangelog.api.model.Commit getCommitTimeLong",
            "method se.bjurr.gitchangelog.api.model.Commit getHash",
            "method se.bjurr.gitchangelog.api.model.Commit getHashFull",
            "method se.bjurr.gitchangelog.api.model.Commit getMessage",
            "method se.bjurr.gitchangelog.api.model.Commit getMessageBody",
            "method se.bjurr.gitchangelog.api.model.Commit getMessageBodyItems",
            "method se.bjurr.gitchangelog.api.model.Commit getMessageTitle",
            "method se.bjurr.gitchangelog.api.model.Commit isMerge",
            "method se.bjurr.gitchangelog.api.model.Issue getTitle",
            "method se.bjurr.gitchangelog.api.model.Issue hasTitle",
            "method se.bjurr.gitchangelog.api.model.Issue hasIssue",
            "method se.bjurr.gitchangelog.api.model.Issue hasLabels",
            "method se.bjurr.gitchangelog.api.model.Issue hasType",
            "method se.bjurr.gitchangelog.api.model.Issue hasLink",
            "method se.bjurr.gitchangelog.api.model.Issue getIssue",
            "method se.bjurr.gitchangelog.api.model.Issue getLink",
            "method se.bjurr.gitchangelog.api.model.Issue getName",
            "method se.bjurr.gitchangelog.api.model.Issue getType",
            "method se.bjurr.gitchangelog.api.model.Issue hasDescription",
            "method se.bjurr.gitchangelog.api.model.Issue getDescription",
            "method se.bjurr.gitchangelog.api.model.Issue getAuthors",
            "method se.bjurr.gitchangelog.api.model.Issue getCommits",
            "method se.bjurr.gitchangelog.api.model.Issue getLabels",
            "method se.bjurr.gitchangelog.api.model.IssueType getName",
            "method se.bjurr.gitchangelog.api.model.IssueType getIssues",
            "method se.bjurr.gitchangelog.api.model.Tag getAnnotation",
            "method se.bjurr.gitchangelog.api.model.Tag getAuthors",
            "method se.bjurr.gitchangelog.api.model.Tag getCommit",
            "method se.bjurr.gitchangelog.api.model.Tag getCommits",
            "method se.bjurr.gitchangelog.api.model.Tag getIssues",
            "method se.bjurr.gitchangelog.api.model.Tag getIssueTypes",
            "method se.bjurr.gitchangelog.api.model.Tag getName",
            "method se.bjurr.gitchangelog.api.model.Tag getTagTime",
            "method se.bjurr.gitchangelog.api.model.Tag getTagTimeLong",
            "method se.bjurr.gitchangelog.api.model.Tag isHasTagTime",
            "method se.bjurr.gitchangelog.api.model.interfaces.IAuthors getAuthors",
            "method se.bjurr.gitchangelog.api.model.interfaces.ICommits getCommits",
            "method se.bjurr.gitchangelog.api.model.interfaces.IIssues getIssues",
            "method se.bjurr.gitchangelog.internal.semantic.SemanticVersion getMajor",
            "method se.bjurr.gitchangelog.internal.semantic.SemanticVersion getMinor",
            "method se.bjurr.gitchangelog.internal.semantic.SemanticVersion getPatch",
            "method se.bjurr.gitchangelog.internal.semantic.SemanticVersion toString"));
  }
}
