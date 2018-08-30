package org.jenkinsci.plugins.gitchangelog.config;

import static com.cloudbees.plugins.credentials.CredentialsMatchers.allOf;
import static com.cloudbees.plugins.credentials.CredentialsMatchers.firstOrNull;
import static com.cloudbees.plugins.credentials.CredentialsMatchers.withId;
import static com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials;
import static com.google.common.base.Optional.absent;
import static com.google.common.base.Optional.fromNullable;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static hudson.security.ACL.SYSTEM;

import com.cloudbees.plugins.credentials.Credentials;
import com.cloudbees.plugins.credentials.common.StandardListBoxModel;
import com.cloudbees.plugins.credentials.common.StandardUsernameListBoxModel;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.domains.DomainRequirement;
import com.google.common.base.Optional;
import hudson.model.ItemGroup;
import hudson.util.ListBoxModel;
import java.util.List;
import org.acegisecurity.Authentication;
import org.jenkinsci.plugins.plaincredentials.StringCredentials;

public class CredentialsHelper {
  public static Optional<String> findSecretString(String credentialsId) {
    Optional<String> token = Optional.absent();
    if (!isNullOrEmpty(credentialsId)) {
      final Optional<StringCredentials> credentials =
          CredentialsHelper.findCredentials(credentialsId);
      if (credentials.isPresent()) {
        final StringCredentials stringCredential =
            checkNotNull(credentials.get(), "Credentials selected but not set!");
        token = Optional.of(stringCredential.getSecret().getPlainText());
      }
    }
    return token;
  }

  public static Optional<StandardUsernamePasswordCredentials> findSecretUsernamePassword(
      String credentialsId) {
    Optional<StandardUsernamePasswordCredentials> token = Optional.absent();
    if (!isNullOrEmpty(credentialsId)) {
      final Optional<StandardUsernamePasswordCredentials> credentials =
          CredentialsHelper.findUserCredentials(credentialsId);
      if (credentials.isPresent()) {
        checkNotNull(credentials.get(), "Credentials selected but not set!");
        return credentials;
      }
    }
    return token;
  }

  public static ListBoxModel doFillUserNamePasswordCredentialsIdItems() {
    List<StandardUsernamePasswordCredentials> credentials =
        getAllCredentials(StandardUsernamePasswordCredentials.class);
    ListBoxModel listBoxModel =
        new StandardUsernameListBoxModel() //
            .includeEmptyValue() //
            .withAll(credentials);
    return listBoxModel;
  }

  public static ListBoxModel doFillApiTokenCredentialsIdItems() {
    List<StringCredentials> credentials = getAllCredentials(StringCredentials.class);
    ListBoxModel listBoxModel =
        new StandardListBoxModel() //
            .includeEmptyValue() //
            .withAll(credentials);
    return listBoxModel;
  }

  public static Optional<StringCredentials> findCredentials(String apiTokenCredentialsId) {
    if (isNullOrEmpty(apiTokenCredentialsId)) {
      return absent();
    }

    return fromNullable(
        firstOrNull(
            getAllCredentials(StringCredentials.class), allOf(withId(apiTokenCredentialsId))));
  }

  public static Optional<StandardUsernamePasswordCredentials> findUserCredentials(
      String apiTokenCredentialsId) {
    if (isNullOrEmpty(apiTokenCredentialsId)) {
      return absent();
    }

    return fromNullable(
        firstOrNull(
            getAllCredentials(StandardUsernamePasswordCredentials.class),
            allOf(withId(apiTokenCredentialsId))));
  }

  private static <C extends Credentials> List<C> getAllCredentials(Class<C> type) {
    ItemGroup<?> itemGroup = null;
    Authentication authentication = SYSTEM;
    DomainRequirement domainRequirement = null;

    return lookupCredentials(type, itemGroup, authentication, domainRequirement);
  }
}
