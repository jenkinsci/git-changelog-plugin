# Git Changelog Plugin Changelog
Changelog of Git Changelog Plugin.
## 1.57
### No issue
**Removing faulty error check from file creation**
 * mkdirs will return false if the dir already exists. So false here is not an error! 

[1a46e41f521dbc3](https://github.com/jenkinsci/git-changelog-plugin/commit/1a46e41f521dbc3) Tomas Bjerre *2018-01-09 21:37:25*

## 1.56
### No issue
**Removing state from GitHub Client**
 * The client was created once, with one API, and kept for all future invcations. So that if a changelog was created for one repo (A) and then for a repo (B), then B would use the API from A. Resulting in wrong issue information in B. 

[25770b069f3f93a](https://github.com/jenkinsci/git-changelog-plugin/commit/25770b069f3f93a) Tomas Bjerre *2018-01-09 21:02:28*

## 1.55
### No issue
**Making config attributes optional**
 * This enables smaller pipeline scripts. 

[9de7b11bd949ebe](https://github.com/jenkinsci/git-changelog-plugin/commit/9de7b11bd949ebe) Tomas Bjerre *2018-01-07 09:29:25*

**Doc**

[b4d7ca00198a193](https://github.com/jenkinsci/git-changelog-plugin/commit/b4d7ca00198a193) Tomas Bjerre *2018-01-05 10:31:48*

## 1.54
### GitHub [#15](https://github.com/jenkinsci/git-changelog-plugin/issues/15) Plugin holding open files? Unable to delete windows workspace due to busy git pack file
**Closing RevWalk JENKINS-19994 #15**

[4dd0b1c8a82edeb](https://github.com/jenkinsci/git-changelog-plugin/commit/4dd0b1c8a82edeb) Tomas Bjerre *2017-12-30 20:49:37*

### Jira JENKINS-19994 
**Closing RevWalk JENKINS-19994 #15**

[4dd0b1c8a82edeb](https://github.com/jenkinsci/git-changelog-plugin/commit/4dd0b1c8a82edeb) Tomas Bjerre *2017-12-30 20:49:37*

### No issue
**Violations Maven Plugin**

[a7baaeeac3b76fb](https://github.com/jenkinsci/git-changelog-plugin/commit/a7baaeeac3b76fb) Tomas Bjerre *2017-12-25 19:31:55*

**Doc**

[d55e599e6056ec5](https://github.com/jenkinsci/git-changelog-plugin/commit/d55e599e6056ec5) Tomas Bjerre *2017-12-19 12:39:52*

## 1.53
### No issue
**Updating lib from 1.72 to 1.76**
 * Adding support for Jira Issue Description 
 * Avoid fetching from integrations if not used 
 * Avoiding usage of Guava Objects 
 * https://github.com/tomasbjerre/git-changelog-lib/blob/master/CHANGELOG.md 

[46b94f93fbde081](https://github.com/jenkinsci/git-changelog-plugin/commit/46b94f93fbde081) Tomas Bjerre *2017-12-19 12:34:23*

## 1.52
### No issue
**Allowing edit config after created by DSL**
 * Config page crashed on save after created by Job DSL. 
 * Updating readme with new DSL. 
 * Also changing MediaWiki integration to, hopefully, allow login. 

[ad8ca1e5149708c](https://github.com/jenkinsci/git-changelog-plugin/commit/ad8ca1e5149708c) Tomas Bjerre *2017-09-03 09:27:30*

## 1.51
### No issue
**Lib 1.71**

[efc14adca3665f6](https://github.com/jenkinsci/git-changelog-plugin/commit/efc14adca3665f6) Tomas Bjerre *2017-07-25 18:32:35*

**doc**

[f64f2fc00946994](https://github.com/jenkinsci/git-changelog-plugin/commit/f64f2fc00946994) Tomas Bjerre *2017-07-24 20:09:17*

## 1.50
### No issue
**Lib 1.70**

[9354d5ce2f8e6d4](https://github.com/jenkinsci/git-changelog-plugin/commit/9354d5ce2f8e6d4) Tomas Bjerre *2017-07-24 20:04:15*

**Cleaning**

[d894006b748fd76](https://github.com/jenkinsci/git-changelog-plugin/commit/d894006b748fd76) Tomas Bjerre *2017-07-16 05:08:19*

**git-changelog-lib 1.69**

[00112d32b80626e](https://github.com/jenkinsci/git-changelog-plugin/commit/00112d32b80626e) Tomas Bjerre *2017-07-08 08:06:15*

**doc**

[916703810a8e6fb](https://github.com/jenkinsci/git-changelog-plugin/commit/916703810a8e6fb) Tomas Bjerre *2017-04-14 09:28:13*

## 1.49
### No issue
**tag time added to tag model**

[c4d45a1b4b4d3a6](https://github.com/jenkinsci/git-changelog-plugin/commit/c4d45a1b4b4d3a6) Tomas Bjerre *2017-04-14 09:25:24*

## 1.48
### GitHub [#11](https://github.com/jenkinsci/git-changelog-plugin/issues/11) Html incorrectly rendered in summary on job page
**Not escaping HTML in symmary #11**

[aa01ee84af485a7](https://github.com/jenkinsci/git-changelog-plugin/commit/aa01ee84af485a7) Tomas Bjerre *2017-03-29 15:15:21*

### No issue
**doc**

[a2c4e7b2e984cef](https://github.com/jenkinsci/git-changelog-plugin/commit/a2c4e7b2e984cef) Tomas Bjerre *2017-03-26 10:11:32*

## 1.47
### No issue
**Using Credentials for Jira, GitHub and GitLab**

[41f0c725b8360dc](https://github.com/jenkinsci/git-changelog-plugin/commit/41f0c725b8360dc) Tomas Bjerre *2017-03-26 10:08:53*

## 1.46
### No issue
**GitLab integration**

[f796401c6db7e54](https://github.com/jenkinsci/git-changelog-plugin/commit/f796401c6db7e54) Tomas Bjerre *2017-03-26 06:24:32*

## 1.43
### No issue
**Fix Jira labels**

[c279a303781cfb6](https://github.com/jenkinsci/git-changelog-plugin/commit/c279a303781cfb6) Tomas Bjerre *2017-03-20 18:21:47*

## 1.42
### No issue
**Git Changelog Lib 1.58 -> 1.64**
 * Jira issueType and labels 
 * GitHub labels 
 * 10 seconds timeout to GitHub 

[e6208cf70e5dffa](https://github.com/jenkinsci/git-changelog-plugin/commit/e6208cf70e5dffa) Tomas Bjerre *2017-03-18 09:26:26*

**Google java code standard**

[3aae4ffc9df122a](https://github.com/jenkinsci/git-changelog-plugin/commit/3aae4ffc9df122a) Tomas Bjerre *2017-03-17 16:24:33*

**Jenkinsfile and building with new plugin parent**

[3c3c013b8806032](https://github.com/jenkinsci/git-changelog-plugin/commit/3c3c013b8806032) Tomas Bjerre *2017-03-08 05:28:14*

**Adding changelog**

[74b7f34abf558e1](https://github.com/jenkinsci/git-changelog-plugin/commit/74b7f34abf558e1) Tomas Bjerre *2017-02-02 06:08:22*

**Adding example job DSL**

[54b06967637a1a3](https://github.com/jenkinsci/git-changelog-plugin/commit/54b06967637a1a3) Tomas Bjerre *2016-11-02 20:00:07*

## 1.41
### No issue
**Fix bug that prevents you from setting up 'Choose from reference' and 'Choose to reference' through job DSL.**

[1a6d53f2a0cd74d](https://github.com/jenkinsci/git-changelog-plugin/commit/1a6d53f2a0cd74d) jbe30 *2016-11-01 15:11:21*

## 1.40
### No issue
**Adding annotation to context of tag**

[6f9fdbb0b3e6cfb](https://github.com/jenkinsci/git-changelog-plugin/commit/6f9fdbb0b3e6cfb) Tomas Bjerre *2016-10-22 10:39:49*

## 1.39
### No issue
**Distribution management in pom**

[ce534819908bea1](https://github.com/jenkinsci/git-changelog-plugin/commit/ce534819908bea1) Tomas Bjerre *2016-10-05 19:23:25*

## 1.38
### No issue
**Adding merge boolean to commits**

[aa1d9ebf2955ec0](https://github.com/jenkinsci/git-changelog-plugin/commit/aa1d9ebf2955ec0) Tomas Bjerre *2016-10-05 18:46:09*

## 1.37
### No issue
**Lib 1.56 correcting link to Jira**

[5db1d44bb651f44](https://github.com/jenkinsci/git-changelog-plugin/commit/5db1d44bb651f44) Tomas Bjerre *2016-08-11 15:01:50*

## 1.34
### GitHub [#7](https://github.com/jenkinsci/git-changelog-plugin/issues/7) Pipeline and job-dsl compatibility
**Making it compatible with Job DSL and Pipeline Plugins #7**

[769c5291571bb48](https://github.com/jenkinsci/git-changelog-plugin/commit/769c5291571bb48) Tomas Bjerre *2016-08-10 18:13:14*

## 1.33
### No issue
**Using git-changelog-lib 1.55**
 * Adds support for {{hashFull}} variable. 

[61b475a89eb6449](https://github.com/jenkinsci/git-changelog-plugin/commit/61b475a89eb6449) Tomas Bjerre *2016-08-02 18:15:56*

## 1.32
### No issue
**Faster**

[010aaf5f2185e6f](https://github.com/jenkinsci/git-changelog-plugin/commit/010aaf5f2185e6f) Tomas Bjerre *2016-06-25 00:10:02*

## 1.31
### No issue
**Fixing merge commits... again...**

[46097569efa4d34](https://github.com/jenkinsci/git-changelog-plugin/commit/46097569efa4d34) Tomas Bjerre *2016-06-24 21:06:11*

## 1.30
### No issue
**Better error message if ref not found**

[2f39f9c9b3c01c0](https://github.com/jenkinsci/git-changelog-plugin/commit/2f39f9c9b3c01c0) Tomas Bjerre *2016-06-24 12:59:45*

## 1.29
### No issue
**Including commits from merges lib issue 49**

[05705717d88a8e2](https://github.com/jenkinsci/git-changelog-plugin/commit/05705717d88a8e2) Tomas Bjerre *2016-06-24 09:24:38*

**Add idea files to gitignore**

[e6e1294680c8152](https://github.com/jenkinsci/git-changelog-plugin/commit/e6e1294680c8152) Paul Wellner Bou *2016-06-09 08:55:43*

## 1.28
### No issue
**Bump git-changelog version to 2.3**

[0452fb51452fc45](https://github.com/jenkinsci/git-changelog-plugin/commit/0452fb51452fc45) Paul Wellner Bou *2016-06-09 06:24:35*

## 1.27
### No issue
**Lib 1.49, finding first commit as parents from HEAD**

[24e53fa9da1cb9c](https://github.com/jenkinsci/git-changelog-plugin/commit/24e53fa9da1cb9c) Tomas Bjerre *2016-06-02 18:37:09*

## 1.24
### No issue
**Ignoring trailing slash in JIRA URL**

[1365da5ddff99c3](https://github.com/jenkinsci/git-changelog-plugin/commit/1365da5ddff99c3) Tomas Bjerre *2016-05-20 19:19:29*

## 1.23
### No issue
**Formatting code after merge of PR**

[03f05466c0c5912](https://github.com/jenkinsci/git-changelog-plugin/commit/03f05466c0c5912) Tomas Bjerre *2016-05-13 20:55:46*

**add the ability to do a changelog in a subdirectory of the workspace**

[b89f83a2c18c91a](https://github.com/jenkinsci/git-changelog-plugin/commit/b89f83a2c18c91a) marrein *2016-05-13 18:00:56*

## 1.22
### Jira JENKINS-34156 
**Including correct commits + performance JENKINS-34156**
 * Found major performance problem when sorting tags by commit time, fixed. 
 * Now not following parents, unless *from* is merged into them. 

[10ebd79f8643079](https://github.com/jenkinsci/git-changelog-plugin/commit/10ebd79f8643079) Tomas Bjerre *2016-04-13 18:48:14*

## 1.21
### No issue
**Improving default templates**

[b8610618439988f](https://github.com/jenkinsci/git-changelog-plugin/commit/b8610618439988f) Tomas Bjerre *2016-04-12 18:40:09*

## 1.20
### No issue
**Adding default values for templates**

[b22d45e1c84bc63](https://github.com/jenkinsci/git-changelog-plugin/commit/b22d45e1c84bc63) Tomas Bjerre *2016-04-12 18:04:34*

**Better exception logging**

[63b1c5c437e7199](https://github.com/jenkinsci/git-changelog-plugin/commit/63b1c5c437e7199) Tomas Bjerre *2016-04-12 17:38:18*

## 1.19
### Jira JENKINS-34155 
**JENKINS-34155 Support short SHA**

[49a392944c93766](https://github.com/jenkinsci/git-changelog-plugin/commit/49a392944c93766) Tomas Bjerre *2016-04-12 17:06:29*

## 1.18
### No issue
**Triggering build**

[d5b769b283d849d](https://github.com/jenkinsci/git-changelog-plugin/commit/d5b769b283d849d) Tomas Bjerre *2016-04-10 17:41:13*

## 1.17
### No issue
**Lib 1.43, Parsing commits, oldest first**

[cbc4f860b960018](https://github.com/jenkinsci/git-changelog-plugin/commit/cbc4f860b960018) Tomas Bjerre *2016-04-10 09:17:53*

## 1.16
### No issue
**Lib 1.42, Parsing commits, oldest first**

[22d54d23a397e6f](https://github.com/jenkinsci/git-changelog-plugin/commit/22d54d23a397e6f) Tomas Bjerre *2016-04-10 08:58:59*

## 1.15
### No issue
**Lib 1.41, Commits added to correct tags**

[e2ccc5c0700a1fd](https://github.com/jenkinsci/git-changelog-plugin/commit/e2ccc5c0700a1fd) Tomas Bjerre *2016-04-09 20:32:07*

## 1.14
### No issue
**Lib 1.40 can ignore tags by regexp**

[636e93b1ecaab69](https://github.com/jenkinsci/git-changelog-plugin/commit/636e93b1ecaab69) Tomas Bjerre *2016-04-07 19:41:48*

## 1.13
### No issue
**Allowing commits to be ignored if no issue**
 * If a commit is not included in any issue, it can now be ignored. 
 * Adding title config to custom issues. 
 * Using Lib 1.39. 

[1f59b904a3160ff](https://github.com/jenkinsci/git-changelog-plugin/commit/1f59b904a3160ff) Tomas Bjerre *2016-03-20 10:32:26*

## 1.12
### No issue
**Release 1.11 did not show up in update sites, trying again**

[15d98b42f410aa2](https://github.com/jenkinsci/git-changelog-plugin/commit/15d98b42f410aa2) Tomas Bjerre *2016-03-16 19:35:04*

## 1.11
### No issue
**Supporting GitHub OAuth2 token**

[e62d39dc6b706eb](https://github.com/jenkinsci/git-changelog-plugin/commit/e62d39dc6b706eb) Tomas Bjerre *2016-03-16 16:45:37*

## 1.10
### No issue
**Removing password from toString**

[af6ccce44589fe3](https://github.com/jenkinsci/git-changelog-plugin/commit/af6ccce44589fe3) Tomas Bjerre *2016-03-11 18:31:54*

## 1.9
### No issue
**Making it work with slaves setup**

[d7a5fc7b0af73ea](https://github.com/jenkinsci/git-changelog-plugin/commit/d7a5fc7b0af73ea) Tomas Bjerre *2016-03-11 18:11:23*

## 1.8
### No issue
**Trying to support slaves setup**

[f849ae0afae2831](https://github.com/jenkinsci/git-changelog-plugin/commit/f849ae0afae2831) Tomas Bjerre *2016-03-10 18:03:23*

## 1.7
### No issue
**Supplying commit in each issue mentioned in message**

[affc742f9339397](https://github.com/jenkinsci/git-changelog-plugin/commit/affc742f9339397) Tomas Bjerre *2016-02-20 08:57:44*

## 1.6
### No issue
**Git Changelog Lib 1.30, supporting multiple tags on same commit**

[530b93f070c497d](https://github.com/jenkinsci/git-changelog-plugin/commit/530b93f070c497d) Tomas Bjerre *2016-02-15 18:24:16*

**Git changelog lib 1.29**

[653a04fd6bbbc4f](https://github.com/jenkinsci/git-changelog-plugin/commit/653a04fd6bbbc4f) Tomas Bjerre *2016-02-14 18:07:28*

## 1.5
### No issue
**Significant performance improvements**
 * Using lib 1.27. 

[2de19d474fdd4b4](https://github.com/jenkinsci/git-changelog-plugin/commit/2de19d474fdd4b4) Tomas Bjerre *2016-02-13 09:02:51*

**Git changelog lib 1.25**

[bf4f5291fcf678b](https://github.com/jenkinsci/git-changelog-plugin/commit/bf4f5291fcf678b) Tomas Bjerre *2016-02-10 18:08:19*

## 1.4
### GitHub [#5](https://github.com/jenkinsci/git-changelog-plugin/issues/5) Add support for getting changelog between two commit ids
**Added variables: messageTitle, messageBody, messageItems #5**

[a58a8dbff6c9dc9](https://github.com/jenkinsci/git-changelog-plugin/commit/a58a8dbff6c9dc9) Tomas Bjerre *2016-02-09 20:02:35*

### No issue
**Using lib 1.23**

[d295d2ed60ff19c](https://github.com/jenkinsci/git-changelog-plugin/commit/d295d2ed60ff19c) Tomas Bjerre *2016-01-31 11:23:49*

## 1.3
### Jira JENKINS-32111 
**JENKINS-32111 Making changelog task applicable for all project types**
 * Was only applicable to free-style 

[2f61838bf15ff1f](https://github.com/jenkinsci/git-changelog-plugin/commit/2f61838bf15ff1f) Tomas Bjerre *2015-12-17 07:47:43*

### No issue
**Adding CloudBees badge to readme**

[146ed97fa4f8d8c](https://github.com/jenkinsci/git-changelog-plugin/commit/146ed97fa4f8d8c) Tomas Bjerre *2015-12-12 19:02:00*

**Updating readme**
 * To make the new features introduced in 1.2, git-changelog-lib, clearer. 

[b35a5ca95eb2400](https://github.com/jenkinsci/git-changelog-plugin/commit/b35a5ca95eb2400) Tomas Bjerre *2015-12-12 18:35:00*

## 1.2
### No issue
**Git Changelog Lib 1.18**

[b9340a7819a5e6e](https://github.com/jenkinsci/git-changelog-plugin/commit/b9340a7819a5e6e) Tomas Bjerre *2015-12-09 15:27:12*

**Fix typo in pom**

[7b8c07f862fd6be](https://github.com/jenkinsci/git-changelog-plugin/commit/7b8c07f862fd6be) Paul Wellner Bou *2015-10-05 12:54:10*

**Add ci and issue mgmt information**

[7aede0bfe6e31ba](https://github.com/jenkinsci/git-changelog-plugin/commit/7aede0bfe6e31ba) Paul Wellner Bou *2015-10-05 12:50:47*

**Fix typo**

[95717851d565ca0](https://github.com/jenkinsci/git-changelog-plugin/commit/95717851d565ca0) Paul Wellner Bou *2015-10-05 12:37:35*

## 1.1
### GitHub [#1](https://github.com/jenkinsci/git-changelog-plugin/pull/1) Git Changelog Lib 1.18
**Refactoring and fixing for issue #1**

[be5de060191fa73](https://github.com/jenkinsci/git-changelog-plugin/commit/be5de060191fa73) Paul Wellner Bou *2015-10-02 20:35:55*

**Make task serializable (#1)**

[22b91f5f4737ff2](https://github.com/jenkinsci/git-changelog-plugin/commit/22b91f5f4737ff2) Paul Wellner Bou *2015-10-01 11:12:01*

**Add slave/master sensitive task to publisher (#1)**

[735fac36b0871ef](https://github.com/jenkinsci/git-changelog-plugin/commit/735fac36b0871ef) Paul Wellner Bou *2015-10-01 10:56:19*

### No issue
**set https github connections**

[85f2a8f9f6da75e](https://github.com/jenkinsci/git-changelog-plugin/commit/85f2a8f9f6da75e) Paul Wellner Bou *2015-10-05 12:16:20*

**Preparation for jenkins hosting**

[fdd32995769414f](https://github.com/jenkinsci/git-changelog-plugin/commit/fdd32995769414f) Paul Wellner Bou *2015-10-05 11:18:00*

**Adjust pom for jenkins github fork**

[cc73800269c3c65](https://github.com/jenkinsci/git-changelog-plugin/commit/cc73800269c3c65) Paul Wellner Bou *2015-10-05 10:23:23*

**Add email-ext plugin only when running with hpi:run**

[04f8313ad94ff65](https://github.com/jenkinsci/git-changelog-plugin/commit/04f8313ad94ff65) Paul Wellner Bou *2015-10-04 13:03:48*

**Pin git-changelog version to 2.2**

[41c26fdf3095151](https://github.com/jenkinsci/git-changelog-plugin/commit/41c26fdf3095151) Paul Wellner Bou *2015-10-02 20:36:22*

**Add logging**

[5b1ef7e52e7960f](https://github.com/jenkinsci/git-changelog-plugin/commit/5b1ef7e52e7960f) Paul Wellner Bou *2015-10-01 05:42:08*

**Add logging**

[ffb0cdcc4170288](https://github.com/jenkinsci/git-changelog-plugin/commit/ffb0cdcc4170288) Paul Wellner Bou *2015-10-01 05:12:11*

**refactor and rename: Generify changelog generation, jira filter is just one possibility for output**

[a66056892f01f00](https://github.com/jenkinsci/git-changelog-plugin/commit/a66056892f01f00) Paul Wellner Bou *2015-09-29 22:10:45*

**refactor and rename: Generify changelog generation, jira filter is just one possibility for output**

[1774baa5dcd6b67](https://github.com/jenkinsci/git-changelog-plugin/commit/1774baa5dcd6b67) Paul Wellner Bou *2015-09-29 22:10:35*

**Adjust documentation headings**

[3ff9d2d9beb8054](https://github.com/jenkinsci/git-changelog-plugin/commit/3ff9d2d9beb8054) Paul Wellner Bou *2015-09-25 11:50:30*

**Extend documentation**

[c95361447452b74](https://github.com/jenkinsci/git-changelog-plugin/commit/c95361447452b74) Paul Wellner Bou *2015-09-25 11:49:12*

**downscale images**

[84bf5f374c3931d](https://github.com/jenkinsci/git-changelog-plugin/commit/84bf5f374c3931d) Paul Wellner Bou *2015-09-25 11:40:32*

**Add README**

[ac5b8c3d84b4cb7](https://github.com/jenkinsci/git-changelog-plugin/commit/ac5b8c3d84b4cb7) Paul Wellner Bou *2015-09-25 11:38:48*

**Adjust pom and run script, set jenkins parent to latest LTS version**

[5d53ac3daa31622](https://github.com/jenkinsci/git-changelog-plugin/commit/5d53ac3daa31622) Paul Wellner Bou *2015-09-25 10:17:24*

**Delete non project file**

[47bb6c03dc670d9](https://github.com/jenkinsci/git-changelog-plugin/commit/47bb6c03dc670d9) Paul Wellner Bou *2015-09-25 10:16:36*

**Prepare pom for Jenkins hosting**

[48ae18dddbfffb7](https://github.com/jenkinsci/git-changelog-plugin/commit/48ae18dddbfffb7) Paul Wellner Bou *2015-07-13 15:31:52*

## refs/tags/1.0
### No issue
**Set version to 1.0**

[fa32544f0e59c05](https://github.com/jenkinsci/git-changelog-plugin/commit/fa32544f0e59c05) Paul Wellner Bou *2015-06-24 10:17:26*

**Fix bugs, add a bit of documentation and index.jelly, add torev/fromrev fields for publisher**

[4c7a170c490e78a](https://github.com/jenkinsci/git-changelog-plugin/commit/4c7a170c490e78a) Paul Wellner Bou *2015-06-23 22:48:01*

**Fix developer/scm connection in pom**

[c5fd431d01bda14](https://github.com/jenkinsci/git-changelog-plugin/commit/c5fd431d01bda14) Paul Wellner Bou *2015-06-23 14:44:05*

**Inital commit**

[333eccf5a64ff86](https://github.com/jenkinsci/git-changelog-plugin/commit/333eccf5a64ff86) Paul Wellner Bou *2015-06-23 14:38:30*

