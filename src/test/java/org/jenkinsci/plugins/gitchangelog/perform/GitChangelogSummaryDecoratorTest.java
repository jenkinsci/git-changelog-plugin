package org.jenkinsci.plugins.gitchangelog.perform;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.markup.MarkupFormatter;
import hudson.markup.RawHtmlMarkupFormatter;
import java.io.IOException;
import java.io.Writer;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
class GitChangelogSummaryDecoratorTest {

  @Test
  void text(@SuppressWarnings("unused") JenkinsRule r) {
    // save text
    GitChangelogSummaryDecorator saveText = new GitChangelogSummaryDecorator("Save text");
    assertEquals("Save text", saveText.getText());

    // dangerous text with global formatter
    GitChangelogSummaryDecorator dangerousText =
        new GitChangelogSummaryDecorator("<script>alert('PWND!')</script>");
    assertEquals("&lt;script&gt;alert(&#039;PWND!&#039;)&lt;/script&gt;", dangerousText.getText());

    // dangerous text with OWASP formatter
    r.jenkins.setMarkupFormatter(RawHtmlMarkupFormatter.INSTANCE);
    assertEquals("", dangerousText.getText());

    // save text with broken formatter
    MarkupFormatter formatter =
        new MarkupFormatter() {
          @Override
          public void translate(String markup, @NonNull Writer output) throws IOException {
            throw new IOException("Oh no!");
          }
        };
    r.jenkins.setMarkupFormatter(formatter);
    assertEquals("", saveText.getText());
  }
}
