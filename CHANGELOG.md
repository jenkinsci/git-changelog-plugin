# git-changelog-plugin changelog

Changelog of git-changelog-plugin.

## 3.31 (2023-07-09)

### Features

-  add from/to config to getHighestSemanticVersion step ([72399](https://github.com/jenkinsci/git-changelog-plugin/commit/7239986985ae081) Tomas Bjerre)  [#84](https://github.com/jenkinsci/git-changelog-plugin/issues/84)  

## 3.30 (2023-04-22)

### Features

-  stringHelpers ([3d022](https://github.com/jenkinsci/git-changelog-plugin/commit/3d022cd87060e6b) Tomas Bjerre)  

## 3.29 (2023-03-12)

### Bug Fixes

-  avoiding stuck execution ([2df00](https://github.com/jenkinsci/git-changelog-plugin/commit/2df003d69c3c90e) Tomas Bjerre)  

## 3.28 (2023-02-16)

### Bug Fixes

-  parsing newest commits first ([82871](https://github.com/jenkinsci/git-changelog-plugin/commit/828719d28173877) Tomas Bjerre)  

## 3.27 (2023-01-04)

### Bug Fixes

-  allow space before : in commit message ([0bd57](https://github.com/jenkinsci/git-changelog-plugin/commit/0bd578b18b5d4db) Tomas Bjerre)  

## 3.26 (2022-12-20)

### Bug Fixes

-  making semantic version match not greedy ([1ee1e](https://github.com/jenkinsci/git-changelog-plugin/commit/1ee1ef53865e8ea) Tomas Bjerre)  

## 3.25 (2022-11-13)

### Bug Fixes

-  issue integrations not working ([96975](https://github.com/jenkinsci/git-changelog-plugin/commit/96975f15ec5d322) Tomas Bjerre)  [#72](https://github.com/jenkinsci/git-changelog-plugin/issues/72)  

## 3.24 (2022-10-24)

### Bug Fixes

-  stepping dependencies to fix CVE-2022-42889 ([a7cc0](https://github.com/jenkinsci/git-changelog-plugin/commit/a7cc063f7f5b555) Tomas Bjerre)  

## 3.23 (2022-03-17)

### Bug Fixes

-  avoid looking for master if HEAD found ([ddda8](https://github.com/jenkinsci/git-changelog-plugin/commit/ddda80c49116c6b) Tomas Bjerre)  

## 3.22 (2022-03-17)

### Features

-  fall back on HEAD and MASTER if no toRef is given ([68ab7](https://github.com/jenkinsci/git-changelog-plugin/commit/68ab71f3446fbd9) Tomas Bjerre)  

## 3.21 (2022-02-22)

### Other changes

**Merge pull request #69 from MaartenDCrius/feature/add-redmine-integration**

* Feature/add redmine integration 

[85956](https://github.com/jenkinsci/git-changelog-plugin/commit/8595614873eaf99) Tomas Bjerre *2022-02-22 17:06:06*

**Fix for SpotBugs**


[d3c14](https://github.com/jenkinsci/git-changelog-plugin/commit/d3c1493d38985f5) Maarten *2022-02-22 13:41:14*

**Added Redmine integration**


[0a9cb](https://github.com/jenkinsci/git-changelog-plugin/commit/0a9cbd36518b387) Maarten *2022-02-22 11:53:53*

**Added Redmine integration**


[88d23](https://github.com/jenkinsci/git-changelog-plugin/commit/88d232345a0038d) Maarten *2022-02-19 11:18:02*


## 3.20 (2022-02-15)

### Bug Fixes

-  include tag on first commit ([5f8e8](https://github.com/jenkinsci/git-changelog-plugin/commit/5f8e833d2979540) Tomas Bjerre)  

## 3.19 (2022-02-12)

### Features

-  getHighestSemanticVersion ([e876d](https://github.com/jenkinsci/git-changelog-plugin/commit/e876d7748dbd25d) Tomas Bjerre)  [#66](https://github.com/jenkinsci/git-changelog-plugin/issues/66)  

## 3.18 (2022-01-20)

### Bug Fixes

-  parsing scopes ([935bf](https://github.com/jenkinsci/git-changelog-plugin/commit/935bfff78608ac7) Tomas Bjerre)  

## 3.16 (2022-01-17)

### Bug Fixes

-  match first semantic combination ([9c039](https://github.com/jenkinsci/git-changelog-plugin/commit/9c03990b336f99a) Tomas Bjerre)  

## 3.15 (2022-01-05)

### Bug Fixes

-  only parse enabled issues ([6bf43](https://github.com/jenkinsci/git-changelog-plugin/commit/6bf43275ae2285a) Tomas Bjerre)  [#65](https://github.com/jenkinsci/git-changelog-plugin/issues/65)  

## 3.14 (2021-12-03)

### Features

-  Support bearer authorization to Jira ([65aea](https://github.com/jenkinsci/git-changelog-plugin/commit/65aeab5eb2526ca) Lumír Návrat)  
-  Support bearer authorization to Jira ([72de2](https://github.com/jenkinsci/git-changelog-plugin/commit/72de260b3f68850) Lumír Návrat)  

### Other changes

**stepping lib version**


[66585](https://github.com/jenkinsci/git-changelog-plugin/commit/665850a85c3a0e8) Tomas Bjerre *2021-12-03 17:34:43*

**Merge pull request #64 from rimuln/feature/13**

* feat: Support bearer authorization to Jira 

[834de](https://github.com/jenkinsci/git-changelog-plugin/commit/834defbcaec2582) Tomas Bjerre *2021-12-03 17:31:02*


## 3.13 (2021-10-17)

### Features

-  only step patch if matching pattern ([a78a0](https://github.com/jenkinsci/git-changelog-plugin/commit/a78a06f23bf6b44) Tomas Bjerre)  

## 3.12 (2021-10-06)

### Bug Fixes

-  NotSerializableException ([c59b6](https://github.com/jenkinsci/git-changelog-plugin/commit/c59b6cc1cbd3fc3) Tomas Bjerre)  

## 3.11 (2021-07-16)

### Features

-  getNextSemanticVersionStep ([f7bd0](https://github.com/jenkinsci/git-changelog-plugin/commit/f7bd0dbd91d669f) Tomas Bjerre)  

## 3.10 (2021-06-17)

### Bug Fixes

-  read template from file ([b115c](https://github.com/jenkinsci/git-changelog-plugin/commit/b115c8e51bb7cd5) Tomas Bjerre)  

## 3.9 (2021-06-16)

## 3.8 (2021-06-11)

### Bug Fixes

-  adding default changelog template jenkinsci/git-changelog-plugin#58 ([b0caf](https://github.com/jenkinsci/git-changelog-plugin/commit/b0caf1bbdda6135) Tomas Bjerre)  

## 3.7 (2021-06-09)

### Bug Fixes

-  semantic version stepping ([13b94](https://github.com/jenkinsci/git-changelog-plugin/commit/13b944095404eb3) Tomas Bjerre)  
-  semantic version stepping ([bc327](https://github.com/jenkinsci/git-changelog-plugin/commit/bc327d46c5511c2) Tomas Bjerre)  

## 3.6 (2021-06-09)

### Bug Fixes

-  NPE when given file has no parent ([de484](https://github.com/jenkinsci/git-changelog-plugin/commit/de484ffbcfb0614) Tomas Bjerre)  
-  NPE when given file has no parent ([38cce](https://github.com/jenkinsci/git-changelog-plugin/commit/38cce00da0b8104) Tomas Bjerre)  
-  when file was in a new folder, it created folder ([80f92](https://github.com/jenkinsci/git-changelog-plugin/commit/80f92d95bbc25b8) Tomas Bjerre)  

## 3.5 (2021-06-05)

### Features

-  more helpers ([11949](https://github.com/jenkinsci/git-changelog-plugin/commit/11949614b228831) Tomas Bjerre)  

## 3.3 (2021-05-27)

### Features

-  support conventional commits ([a90ee](https://github.com/jenkinsci/git-changelog-plugin/commit/a90ee202c98da56) Tomas Bjerre)  

## 3.2 (2021-03-29)

### Other changes

**pretty printing output JENKINS-65252**

* Avoiding additional linebreaks and whitepsaces: 
* https://github.com/tomasbjerre/git-changelog-lib/commit/bea18ab90db148c 

[ca122](https://github.com/jenkinsci/git-changelog-plugin/commit/ca1221a23a65946) Tomas Bjerre *2021-03-29 15:52:06*


## 3.1 (2021-01-18)

### Other changes

**Removing default ignore filter on message**


[2a318](https://github.com/jenkinsci/git-changelog-plugin/commit/2a318eb88506081) Tomas Bjerre *2021-01-18 17:35:02*

**Cleanup**


[9833c](https://github.com/jenkinsci/git-changelog-plugin/commit/9833cb3d18e12b7) Tomas Bjerre *2020-10-28 18:45:10*

**Merge pull request #52 from nwton/fixup_docker_images**

* Hacktoberfest - Rename jenkins/jnlp-slave -&gt; jenkins/inbound-agent 

[f3927](https://github.com/jenkinsci/git-changelog-plugin/commit/f3927c052f021e3) Tomas Bjerre *2020-10-18 04:00:29*

**Rename jenkins/jnlp-slave -> jenkins/inbound-agent**


[46182](https://github.com/jenkinsci/git-changelog-plugin/commit/4618258d114168c) Sergey Slabnov *2020-10-17 20:44:56*


## 3.0 (2020-05-29)

### Other changes

**Merge pull request #47 from jenkinsci/feature/removing-git-changelog**

* Removing git changelog 

[16269](https://github.com/jenkinsci/git-changelog-plugin/commit/16269efb76a8fb5) Tomas Bjerre *2020-05-29 05:05:32*

**removing git-changelog #41**


[19adf](https://github.com/jenkinsci/git-changelog-plugin/commit/19adf92d004aa3b) Tomas Bjerre *2020-05-27 14:33:14*


## 2.23 (2020-04-21)

### Other changes

**Correcting regression from #42 reported in #44**


[45a54](https://github.com/jenkinsci/git-changelog-plugin/commit/45a547887c386f8) Tomas Bjerre *2020-04-21 17:09:55*


## 2.22 (2020-04-16)

### Other changes

**doc**


[f6bdd](https://github.com/jenkinsci/git-changelog-plugin/commit/f6bdde07d13c32d) Tomas Bjerre *2020-04-16 15:01:21*

**Merge pull request #42 from nemui/JiraApiToken**

* add support for jira api token 

[4c823](https://github.com/jenkinsci/git-changelog-plugin/commit/4c8235db8f6fe3c) Tomas Bjerre *2020-04-16 14:36:23*

**update changelog-lib version**


[42df3](https://github.com/jenkinsci/git-changelog-plugin/commit/42df33ba6bc2d71) Dmitry Mamchur *2020-04-14 07:55:20*

**add support for jira api token**


[a97bd](https://github.com/jenkinsci/git-changelog-plugin/commit/a97bdf3e006485c) Dmitry Mamchur *2020-04-10 10:57:42*


## 2.21 (2019-11-08)

### Other changes

**Removing Jira credentials from log #38**


[c1a95](https://github.com/jenkinsci/git-changelog-plugin/commit/c1a9528c07bd369) Tomas Bjerre *2019-11-08 14:37:42*


## 2.20 (2019-10-24)

### Other changes

**Setting URL to README.md to update plugins.jenkins.io**


[9644e](https://github.com/jenkinsci/git-changelog-plugin/commit/9644e04038d0234) Tomas Bjerre *2019-10-24 18:34:53*

**Merge pull request #36 from jenkinsci/feature/taking-care-of-some-sca**

* Taking care of some SCA findings 

[1f015](https://github.com/jenkinsci/git-changelog-plugin/commit/1f015dea56ac35d) Tomas Bjerre *2019-10-14 16:32:27*

**Taking care of some SCA findings**


[7cbd2](https://github.com/jenkinsci/git-changelog-plugin/commit/7cbd27ba3fd5300) Tomas Bjerre *2019-10-14 16:29:15*

**Create FUNDING.yml**


[a66ed](https://github.com/jenkinsci/git-changelog-plugin/commit/a66ed818f4aa726) Tomas Bjerre *2019-09-28 06:51:47*


## 2.19 (2019-09-14)

### Other changes

**Removing raw GitLab/GitHub tokens and forcing credentials**

* SECURITY-1574 

[305e8](https://github.com/jenkinsci/git-changelog-plugin/commit/305e80d8b0eb972) Tomas Bjerre *2019-09-14 05:41:26*


## 2.18 (2019-09-13)

### Other changes

**Remving raw Jira username/password and forcing credentials**

* Also removing MediaWiki support. Because of security reasons in combination with, probably, few users. There should probably be another MediaWiki publisher plugin to do that. 
* SECURITY-1574 

[35624](https://github.com/jenkinsci/git-changelog-plugin/commit/356243aa6d3f6ad) Tomas Bjerre *2019-09-13 18:24:36*

**doc**


[3ac4b](https://github.com/jenkinsci/git-changelog-plugin/commit/3ac4b9b7b25e2d5) Tomas Bjerre *2019-06-15 12:36:10*


## 2.17 (2019-06-11)

### Other changes

**Removing dependency on javax.xml #34**


[f5932](https://github.com/jenkinsci/git-changelog-plugin/commit/f59327b9ff09fa2) Tomas Bjerre *2019-06-11 17:08:11*


## 2.16 (2019-02-16)

### Other changes

**Allowing JSONArray #32**


[57c7c](https://github.com/jenkinsci/git-changelog-plugin/commit/57c7c06db0c06c2) Tomas Bjerre *2019-02-16 17:17:03*

**Doc**


[82bc9](https://github.com/jenkinsci/git-changelog-plugin/commit/82bc9553431df8f) Tomas Bjerre *2019-02-08 19:00:56*


## 2.15 (2019-01-08)

### Other changes

**Jira linked issues**


[770e2](https://github.com/jenkinsci/git-changelog-plugin/commit/770e243895faa98) Tomas Bjerre *2019-01-08 18:34:01*

**Merge pull request #30 from darxriggs/code-cleanup**

* Code Improvements 

[3eddc](https://github.com/jenkinsci/git-changelog-plugin/commit/3eddc7a1764f3a7) Tomas Bjerre *2018-10-30 05:01:32*

**Upgrade to latest parent pom**


[ea316](https://github.com/jenkinsci/git-changelog-plugin/commit/ea316d3edb5978d) René Scheibe *2018-10-29 22:03:24*

**Replace Guava with JDK functionality**


[e06ec](https://github.com/jenkinsci/git-changelog-plugin/commit/e06ec581cc16774) René Scheibe *2018-10-29 22:03:24*

**Inline redundant variables**


[de51c](https://github.com/jenkinsci/git-changelog-plugin/commit/de51cbdf5b2b76d) René Scheibe *2018-10-29 22:03:24*

**Fix dangling JavaDoc**


[9e933](https://github.com/jenkinsci/git-changelog-plugin/commit/9e933e5f332e006) René Scheibe *2018-10-29 22:03:24*

**Use HTTPS for Jenkins repository**


[92bce](https://github.com/jenkinsci/git-changelog-plugin/commit/92bceb1c6a2107e) René Scheibe *2018-10-29 22:03:24*

**Remove unnecessary return statement**

* That&#x27;s anyway the last statement in the method. 

[556ac](https://github.com/jenkinsci/git-changelog-plugin/commit/556ac7358c15aec) René Scheibe *2018-10-29 22:03:24*

**Use diamond operator to reduce type duplication**


[4e0e0](https://github.com/jenkinsci/git-changelog-plugin/commit/4e0e074ee78acd7) René Scheibe *2018-10-29 22:03:24*

**Use the StringBuilder properly**


[4b515](https://github.com/jenkinsci/git-changelog-plugin/commit/4b515b89105cd59) René Scheibe *2018-10-29 22:03:24*

**Fix typos**


[aeed8](https://github.com/jenkinsci/git-changelog-plugin/commit/aeed80ce46e3da1) René Scheibe *2018-10-29 22:03:23*


## 2.14 (2018-10-27)

### Other changes

**Correcting GitLab integration after upgrade**


[19855](https://github.com/jenkinsci/git-changelog-plugin/commit/19855ff830a92c1) Tomas Bjerre *2018-10-27 17:54:09*


## 2.13 (2018-10-27)

### Other changes

**GitLab API v4**


[07b66](https://github.com/jenkinsci/git-changelog-plugin/commit/07b66942922a16c) Tomas Bjerre *2018-10-27 16:36:26*


## 2.12 (2018-10-27)

### Other changes

**isJira, isGitHub...**


[2c4ec](https://github.com/jenkinsci/git-changelog-plugin/commit/2c4ec6476c77cd9) Tomas Bjerre *2018-10-27 06:11:34*

**Using escape-by-default true and out to indicate it is intended and safe**


[32a61](https://github.com/jenkinsci/git-changelog-plugin/commit/32a61fb9a7cf741) Tomas Bjerre *2018-09-25 17:48:19*


## 2.11 (2018-09-25)

### Other changes

**Adding release script**


[2d98c](https://github.com/jenkinsci/git-changelog-plugin/commit/2d98c6729136d18) Tomas Bjerre *2018-09-25 15:29:16*

**Re-enabling HTML on summary page #29**


[7dd2e](https://github.com/jenkinsci/git-changelog-plugin/commit/7dd2e78895f7102) Tomas Bjerre *2018-09-25 15:24:40*

**Cleaning pom**


[5593c](https://github.com/jenkinsci/git-changelog-plugin/commit/5593c2ecac6826b) Tomas Bjerre *2018-09-25 15:23:30*

**Automatically stepping dependencies**


[1690b](https://github.com/jenkinsci/git-changelog-plugin/commit/1690bdbe6e74b22) Tomas Bjerre *2018-09-23 18:59:07*


## 2.10 (2018-09-13)

### Other changes

**Whitelisting context methods #27**


[cc77a](https://github.com/jenkinsci/git-changelog-plugin/commit/cc77add3abbf6ab) Tomas Bjerre *2018-09-13 19:07:40*

**doc**


[fea28](https://github.com/jenkinsci/git-changelog-plugin/commit/fea28267aa2e871) Tomas Bjerre *2018-09-13 15:47:05*


## 2.9 (2018-09-13)

### Other changes

**git-changelog-lib 1.82**


[bda19](https://github.com/jenkinsci/git-changelog-plugin/commit/bda19353f67c2c1) Tomas Bjerre *2018-09-13 07:23:10*


## 2.8 (2018-09-12)

### Other changes

**Correcting ownerName when dot in repo name #24**


[19cbb](https://github.com/jenkinsci/git-changelog-plugin/commit/19cbbc18b0ee958) Tomas Bjerre *2018-09-12 15:20:49*

**Updating fmt-maven-plugin**


[74790](https://github.com/jenkinsci/git-changelog-plugin/commit/74790d757ca6edd) Tomas Bjerre *2018-08-30 17:55:32*


## 2.7 (2018-08-22)

### Other changes

**Escaping HTML to avoid XSS**

* This reverts the change from #11 and will no longer allow HTML on summary page. 

[a078e](https://github.com/jenkinsci/git-changelog-plugin/commit/a078e105107afe4) Tomas Bjerre *2018-08-22 07:34:30*

**Correcting license**


[ac4d8](https://github.com/jenkinsci/git-changelog-plugin/commit/ac4d87b241e836f) Tomas Bjerre *2018-06-21 17:20:08*


## 2.6 (2018-05-09)

### Other changes

**Not ignoring commits, unless pattern supplied #22**


[7f0c1](https://github.com/jenkinsci/git-changelog-plugin/commit/7f0c10b9fe43049) Tomas Bjerre *2018-05-09 14:14:25*


## 2.5 (2018-05-05)

### Other changes

**Closing connection to Jira**


[ff1a3](https://github.com/jenkinsci/git-changelog-plugin/commit/ff1a38d1e518756) Tomas Bjerre *2018-05-05 07:47:37*


## 2.4 (2018-05-02)

### Other changes

**Correcting snippet generator for custom issues #21**


[fb94b](https://github.com/jenkinsci/git-changelog-plugin/commit/fb94b6dc7cbb71e) Tomas Bjerre *2018-05-02 15:35:48*


## 2.3 (2018-04-26)

### Other changes

**JENKINS-50990 Adding ClassFilter for changelog**


[ce8bc](https://github.com/jenkinsci/git-changelog-plugin/commit/ce8bc9268fe79dc) Tomas Bjerre *2018-04-26 03:48:28*


## 2.2 (2018-04-23)

### Other changes

**Second correction file path on remote agents #20**


[9fef4](https://github.com/jenkinsci/git-changelog-plugin/commit/9fef4f13ba59f15) Tomas Bjerre *2018-04-23 18:12:17*


## 2.1 (2018-04-23)

### Other changes

**Correct file path on remote agents #20**


[a8981](https://github.com/jenkinsci/git-changelog-plugin/commit/a8981abb64c1762) Tomas Bjerre *2018-04-23 14:02:08*


## 2.0 (2018-04-19)

### Other changes

**Adding steps #18**


[62f0e](https://github.com/jenkinsci/git-changelog-plugin/commit/62f0e8639e8913a) Tomas Bjerre *2018-04-19 18:26:18*

**Cleaning pom**


[38fcc](https://github.com/jenkinsci/git-changelog-plugin/commit/38fcc24e0bb0834) Tomas Bjerre *2018-01-28 16:50:58*

**Doc**


[bdf9b](https://github.com/jenkinsci/git-changelog-plugin/commit/bdf9bd0eb52798c) Tomas Bjerre *2018-01-13 21:09:09*


## 1.57 (2018-01-09)

### Other changes

**Removing faulty error check from file creation**

* mkdirs will return false if the dir already exists. So false here is not an error! 

[1a46e](https://github.com/jenkinsci/git-changelog-plugin/commit/1a46e41f521dbc3) Tomas Bjerre *2018-01-09 21:37:25*


## 1.56 (2018-01-09)

### Other changes

**Removing state from GitHub Client**

* The client was created once, with one API, and kept for all future invcations. So that if a changelog was created for one repo (A) and then for a repo (B), then B would use the API from A. Resulting in wrong issue information in B. 

[25770](https://github.com/jenkinsci/git-changelog-plugin/commit/25770b069f3f93a) Tomas Bjerre *2018-01-09 21:02:28*


## 1.55 (2018-01-07)

### Other changes

**Making config attributes optional**

* This enables smaller pipeline scripts. 

[9de7b](https://github.com/jenkinsci/git-changelog-plugin/commit/9de7b11bd949ebe) Tomas Bjerre *2018-01-07 09:29:25*

**Doc**


[b4d7c](https://github.com/jenkinsci/git-changelog-plugin/commit/b4d7ca00198a193) Tomas Bjerre *2018-01-05 10:31:48*


## 1.54 (2017-12-30)

### Other changes

**Closing RevWalk JENKINS-19994 #15**


[4dd0b](https://github.com/jenkinsci/git-changelog-plugin/commit/4dd0b1c8a82edeb) Tomas Bjerre *2017-12-30 20:49:37*

**Violations Maven Plugin**


[a7baa](https://github.com/jenkinsci/git-changelog-plugin/commit/a7baaeeac3b76fb) Tomas Bjerre *2017-12-25 19:31:55*

**Doc**


[d55e5](https://github.com/jenkinsci/git-changelog-plugin/commit/d55e599e6056ec5) Tomas Bjerre *2017-12-19 12:39:52*


## 1.53 (2017-12-19)

### Other changes

**Updating lib from 1.72 to 1.76**

* Adding support for Jira Issue Description 
* Avoid fetching from integrations if not used 
* Avoiding usage of Guava Objects 
* https://github.com/tomasbjerre/git-changelog-lib/blob/master/CHANGELOG.md 

[46b94](https://github.com/jenkinsci/git-changelog-plugin/commit/46b94f93fbde081) Tomas Bjerre *2017-12-19 12:34:23*


## 1.52 (2017-09-03)

### Other changes

**Allowing edit config after created by DSL**

* Config page crashed on save after created by Job DSL. 
* Updating readme with new DSL. 
* Also changing MediaWiki integration to, hopefully, allow login. 

[ad8ca](https://github.com/jenkinsci/git-changelog-plugin/commit/ad8ca1e5149708c) Tomas Bjerre *2017-09-03 09:27:30*


## 1.51 (2017-07-25)

### Other changes

**Lib 1.71**


[efc14](https://github.com/jenkinsci/git-changelog-plugin/commit/efc14adca3665f6) Tomas Bjerre *2017-07-25 18:32:35*

**doc**


[f64f2](https://github.com/jenkinsci/git-changelog-plugin/commit/f64f2fc00946994) Tomas Bjerre *2017-07-24 20:09:17*


## 1.50 (2017-07-24)

### Other changes

**Lib 1.70**


[9354d](https://github.com/jenkinsci/git-changelog-plugin/commit/9354d5ce2f8e6d4) Tomas Bjerre *2017-07-24 20:04:15*

**Cleaning**


[d8940](https://github.com/jenkinsci/git-changelog-plugin/commit/d894006b748fd76) Tomas Bjerre *2017-07-16 05:08:19*

**git-changelog-lib 1.69**


[00112](https://github.com/jenkinsci/git-changelog-plugin/commit/00112d32b80626e) Tomas Bjerre *2017-07-08 08:06:15*

**doc**


[91670](https://github.com/jenkinsci/git-changelog-plugin/commit/916703810a8e6fb) Tomas Bjerre *2017-04-14 09:28:13*


## 1.49 (2017-04-14)

### Other changes

**tag time added to tag model**


[c4d45](https://github.com/jenkinsci/git-changelog-plugin/commit/c4d45a1b4b4d3a6) Tomas Bjerre *2017-04-14 09:25:24*


## 1.48 (2017-03-29)

### Other changes

**Not escaping HTML in symmary #11**


[aa01e](https://github.com/jenkinsci/git-changelog-plugin/commit/aa01ee84af485a7) Tomas Bjerre *2017-03-29 15:15:21*

**doc**


[a2c4e](https://github.com/jenkinsci/git-changelog-plugin/commit/a2c4e7b2e984cef) Tomas Bjerre *2017-03-26 10:11:32*


## 1.47 (2017-03-26)

### Other changes

**Using Credentials for Jira, GitHub and GitLab**


[41f0c](https://github.com/jenkinsci/git-changelog-plugin/commit/41f0c725b8360dc) Tomas Bjerre *2017-03-26 10:08:53*


## 1.46 (2017-03-26)

### Other changes

**GitLab integration**


[f7964](https://github.com/jenkinsci/git-changelog-plugin/commit/f796401c6db7e54) Tomas Bjerre *2017-03-26 06:24:32*


## 1.43 (2017-03-20)

### Other changes

**Fix Jira labels**


[c279a](https://github.com/jenkinsci/git-changelog-plugin/commit/c279a303781cfb6) Tomas Bjerre *2017-03-20 18:21:47*


## 1.42 (2017-03-18)

### Other changes

**Git Changelog Lib 1.58 -> 1.64**

* Jira issueType and labels 
* GitHub labels 
* 10 seconds timeout to GitHub 

[e6208](https://github.com/jenkinsci/git-changelog-plugin/commit/e6208cf70e5dffa) Tomas Bjerre *2017-03-18 09:26:26*

**Google java code standard**


[3aae4](https://github.com/jenkinsci/git-changelog-plugin/commit/3aae4ffc9df122a) Tomas Bjerre *2017-03-17 16:24:33*

**Jenkinsfile and building with new plugin parent**


[3c3c0](https://github.com/jenkinsci/git-changelog-plugin/commit/3c3c013b8806032) Tomas Bjerre *2017-03-08 05:28:14*

**Adding changelog**


[74b7f](https://github.com/jenkinsci/git-changelog-plugin/commit/74b7f34abf558e1) Tomas Bjerre *2017-02-02 06:08:22*

**Adding example job DSL**


[54b06](https://github.com/jenkinsci/git-changelog-plugin/commit/54b06967637a1a3) Tomas Bjerre *2016-11-02 20:00:07*


## 1.41 (2016-11-01)

### Other changes

**Merge pull request #9 from Jerbell/bugfix/chooseFromReferenceAndToReference**

* Choose git ref or commit using job DSL 

[59395](https://github.com/jenkinsci/git-changelog-plugin/commit/5939531ecb7d512) Tomas Bjerre *2016-11-01 19:31:43*

**Fix bug that prevents you from setting up 'Choose from reference' and 'Choose to reference' through job DSL.**


[1a6d5](https://github.com/jenkinsci/git-changelog-plugin/commit/1a6d53f2a0cd74d) jbe30 *2016-11-01 15:11:21*


## 1.40 (2016-10-22)

### Other changes

**Adding annotation to context of tag**


[6f9fd](https://github.com/jenkinsci/git-changelog-plugin/commit/6f9fdbb0b3e6cfb) Tomas Bjerre *2016-10-22 10:39:49*


## 1.39 (2016-10-05)

### Other changes

**Distribution management in pom**


[ce534](https://github.com/jenkinsci/git-changelog-plugin/commit/ce534819908bea1) Tomas Bjerre *2016-10-05 19:23:25*


## 1.38 (2016-10-05)

### Other changes

**Adding merge boolean to commits**


[aa1d9](https://github.com/jenkinsci/git-changelog-plugin/commit/aa1d9ebf2955ec0) Tomas Bjerre *2016-10-05 18:46:09*


## 1.37 (2016-08-11)

### Other changes

**Lib 1.56 correcting link to Jira**


[5db1d](https://github.com/jenkinsci/git-changelog-plugin/commit/5db1d44bb651f44) Tomas Bjerre *2016-08-11 15:01:50*


## 1.34 (2016-08-10)

### Other changes

**Making it compatible with Job DSL and Pipeline Plugins #7**


[769c5](https://github.com/jenkinsci/git-changelog-plugin/commit/769c5291571bb48) Tomas Bjerre *2016-08-10 18:13:14*


## 1.33 (2016-08-02)

### Other changes

**Using git-changelog-lib 1.55**

* Adds support for {{hashFull}} variable. 

[61b47](https://github.com/jenkinsci/git-changelog-plugin/commit/61b475a89eb6449) Tomas Bjerre *2016-08-02 18:15:56*


## 1.32 (2016-06-25)

### Other changes

**Faster**


[010aa](https://github.com/jenkinsci/git-changelog-plugin/commit/010aaf5f2185e6f) Tomas Bjerre *2016-06-25 00:10:02*


## 1.31 (2016-06-24)

### Other changes

**Fixing merge commits... again...**


[46097](https://github.com/jenkinsci/git-changelog-plugin/commit/46097569efa4d34) Tomas Bjerre *2016-06-24 21:06:11*


## 1.30 (2016-06-24)

### Other changes

**Better error message if ref not found**


[2f39f](https://github.com/jenkinsci/git-changelog-plugin/commit/2f39f9c9b3c01c0) Tomas Bjerre *2016-06-24 12:59:45*


## 1.29 (2016-06-24)

### Other changes

**Including commits from merges lib issue 49**


[05705](https://github.com/jenkinsci/git-changelog-plugin/commit/05705717d88a8e2) Tomas Bjerre *2016-06-24 09:24:38*

**Add idea files to gitignore**


[e6e12](https://github.com/jenkinsci/git-changelog-plugin/commit/e6e1294680c8152) Paul Wellner Bou *2016-06-09 08:55:43*


## 1.28 (2016-06-09)

### Other changes

**Bump git-changelog version to 2.3**


[0452f](https://github.com/jenkinsci/git-changelog-plugin/commit/0452fb51452fc45) Paul Wellner Bou *2016-06-09 06:24:35*


## 1.27 (2016-06-02)

### Other changes

**Lib 1.49, finding first commit as parents from HEAD**


[24e53](https://github.com/jenkinsci/git-changelog-plugin/commit/24e53fa9da1cb9c) Tomas Bjerre *2016-06-02 18:37:09*


## 1.24 (2016-05-20)

### Other changes

**Ignoring trailing slash in JIRA URL**


[1365d](https://github.com/jenkinsci/git-changelog-plugin/commit/1365da5ddff99c3) Tomas Bjerre *2016-05-20 19:19:29*


## 1.23 (2016-05-13)

### Other changes

**Formatting code after merge of PR**


[03f05](https://github.com/jenkinsci/git-changelog-plugin/commit/03f05466c0c5912) Tomas Bjerre *2016-05-13 20:55:46*

**Merge pull request #4 from s3r3n3-1/master**

* add the ability to do a changelog in a subdirectory of the workspace 

[3d3b4](https://github.com/jenkinsci/git-changelog-plugin/commit/3d3b4763057a661) Tomas Bjerre *2016-05-13 20:38:22*

**add the ability to do a changelog in a subdirectory of the workspace**


[b89f8](https://github.com/jenkinsci/git-changelog-plugin/commit/b89f83a2c18c91a) marrein *2016-05-13 18:00:56*


## 1.22 (2016-04-13)

### Other changes

**Including correct commits + performance JENKINS-34156**

* Found major performance problem when sorting tags by commit time, fixed. 
* Now not following parents, unless *from* is merged into them. 

[10ebd](https://github.com/jenkinsci/git-changelog-plugin/commit/10ebd79f8643079) Tomas Bjerre *2016-04-13 18:48:14*


## 1.21 (2016-04-12)

### Other changes

**Improving default templates**


[b8610](https://github.com/jenkinsci/git-changelog-plugin/commit/b8610618439988f) Tomas Bjerre *2016-04-12 18:40:09*


## 1.20 (2016-04-12)

### Other changes

**Adding default values for templates**


[b22d4](https://github.com/jenkinsci/git-changelog-plugin/commit/b22d45e1c84bc63) Tomas Bjerre *2016-04-12 18:04:34*

**Better exception logging**


[63b1c](https://github.com/jenkinsci/git-changelog-plugin/commit/63b1c5c437e7199) Tomas Bjerre *2016-04-12 17:38:18*


## 1.19 (2016-04-12)

### Other changes

**JENKINS-34155 Support short SHA**


[49a39](https://github.com/jenkinsci/git-changelog-plugin/commit/49a392944c93766) Tomas Bjerre *2016-04-12 17:06:29*


## 1.18 (2016-04-10)

### Other changes

**Triggering build**


[d5b76](https://github.com/jenkinsci/git-changelog-plugin/commit/d5b769b283d849d) Tomas Bjerre *2016-04-10 17:41:13*


## 1.17 (2016-04-10)

### Other changes

**Lib 1.43, Parsing commits, oldest first**


[cbc4f](https://github.com/jenkinsci/git-changelog-plugin/commit/cbc4f860b960018) Tomas Bjerre *2016-04-10 09:17:53*


## 1.16 (2016-04-10)

### Other changes

**Lib 1.42, Parsing commits, oldest first**


[22d54](https://github.com/jenkinsci/git-changelog-plugin/commit/22d54d23a397e6f) Tomas Bjerre *2016-04-10 08:58:59*


## 1.15 (2016-04-09)

### Other changes

**Lib 1.41, Commits added to correct tags**


[e2ccc](https://github.com/jenkinsci/git-changelog-plugin/commit/e2ccc5c0700a1fd) Tomas Bjerre *2016-04-09 20:32:07*


## 1.14 (2016-04-07)

### Other changes

**Lib 1.40 can ignore tags by regexp**


[636e9](https://github.com/jenkinsci/git-changelog-plugin/commit/636e93b1ecaab69) Tomas Bjerre *2016-04-07 19:41:48*


## 1.13 (2016-03-20)

### Other changes

**Allowing commits to be ignored if no issue**

* If a commit is not included in any issue, it can now be ignored. 
* Adding title config to custom issues. 
* Using Lib 1.39. 

[1f59b](https://github.com/jenkinsci/git-changelog-plugin/commit/1f59b904a3160ff) Tomas Bjerre *2016-03-20 10:32:26*


## 1.12 (2016-03-16)

### Other changes

**Release 1.11 did not show up in update sites, trying again**


[15d98](https://github.com/jenkinsci/git-changelog-plugin/commit/15d98b42f410aa2) Tomas Bjerre *2016-03-16 19:35:04*


## 1.11 (2016-03-16)

### Other changes

**Supporting GitHub OAuth2 token**


[e62d3](https://github.com/jenkinsci/git-changelog-plugin/commit/e62d39dc6b706eb) Tomas Bjerre *2016-03-16 16:45:37*


## 1.10 (2016-03-12)

### Other changes

**Removing password from toString**


[af6cc](https://github.com/jenkinsci/git-changelog-plugin/commit/af6ccce44589fe3) Tomas Bjerre *2016-03-11 18:31:54*


## 1.9 (2016-03-11)

### Other changes

**Making it work with slaves setup**


[d7a5f](https://github.com/jenkinsci/git-changelog-plugin/commit/d7a5fc7b0af73ea) Tomas Bjerre *2016-03-11 18:11:23*


## 1.8 (2016-03-10)

### Other changes

**Trying to support slaves setup**


[f849a](https://github.com/jenkinsci/git-changelog-plugin/commit/f849ae0afae2831) Tomas Bjerre *2016-03-10 18:03:23*


## 1.7 (2016-02-20)

### Other changes

**Supplying commit in each issue mentioned in message**


[affc7](https://github.com/jenkinsci/git-changelog-plugin/commit/affc742f9339397) Tomas Bjerre *2016-02-20 08:57:44*


## 1.6 (2016-02-15)

### Other changes

**Git Changelog Lib 1.30, supporting multiple tags on same commit**


[530b9](https://github.com/jenkinsci/git-changelog-plugin/commit/530b93f070c497d) Tomas Bjerre *2016-02-15 18:24:16*

**Git changelog lib 1.29**


[653a0](https://github.com/jenkinsci/git-changelog-plugin/commit/653a04fd6bbbc4f) Tomas Bjerre *2016-02-14 18:07:28*


## 1.5 (2016-02-13)

### Other changes

**Significant performance improvements**

* Using lib 1.27. 

[2de19](https://github.com/jenkinsci/git-changelog-plugin/commit/2de19d474fdd4b4) Tomas Bjerre *2016-02-13 09:02:51*

**Git changelog lib 1.25**


[bf4f5](https://github.com/jenkinsci/git-changelog-plugin/commit/bf4f5291fcf678b) Tomas Bjerre *2016-02-10 18:08:19*


## 1.4 (2016-02-09)

### Other changes

**Added variables: messageTitle, messageBody, messageItems #5**


[a58a8](https://github.com/jenkinsci/git-changelog-plugin/commit/a58a8dbff6c9dc9) Tomas Bjerre *2016-02-09 20:02:35*

**Using lib 1.23**


[d295d](https://github.com/jenkinsci/git-changelog-plugin/commit/d295d2ed60ff19c) Tomas Bjerre *2016-01-31 11:23:49*


## 1.3 (2015-12-17)

### Other changes

**Merge pull request #2 from tomasbjerre/master**

* JENKINS-32111 Making changelog task applicable for all project types 

[30da4](https://github.com/jenkinsci/git-changelog-plugin/commit/30da408348b6532) Tomas Bjerre *2015-12-17 07:58:10*

**JENKINS-32111 Making changelog task applicable for all project types**

* Was only applicable to free-style 

[2f618](https://github.com/jenkinsci/git-changelog-plugin/commit/2f61838bf15ff1f) Tomas Bjerre *2015-12-17 07:47:43*

**Adding CloudBees badge to readme**


[146ed](https://github.com/jenkinsci/git-changelog-plugin/commit/146ed97fa4f8d8c) Tomas Bjerre *2015-12-12 19:02:00*

**Updating readme**

* To make the new features introduced in 1.2, git-changelog-lib, clearer. 

[b35a5](https://github.com/jenkinsci/git-changelog-plugin/commit/b35a5ca95eb2400) Tomas Bjerre *2015-12-12 18:35:00*


## 1.2 (2015-12-10)

### Other changes

**Merge pull request #1 from tomasbjerre/master**

* Git Changelog Lib 1.18 

[e5cb2](https://github.com/jenkinsci/git-changelog-plugin/commit/e5cb209387a26e5) Paul Wellner Bou *2015-12-10 17:52:26*

**Git Changelog Lib 1.18**


[b9340](https://github.com/jenkinsci/git-changelog-plugin/commit/b9340a7819a5e6e) Tomas Bjerre *2015-12-09 15:27:12*

**Fix typo in pom**


[7b8c0](https://github.com/jenkinsci/git-changelog-plugin/commit/7b8c07f862fd6be) Paul Wellner Bou *2015-10-05 12:54:10*

**Add ci and issue mgmt information**


[7aede](https://github.com/jenkinsci/git-changelog-plugin/commit/7aede0bfe6e31ba) Paul Wellner Bou *2015-10-05 12:50:47*

**Fix typo**


[95717](https://github.com/jenkinsci/git-changelog-plugin/commit/95717851d565ca0) Paul Wellner Bou *2015-10-05 12:37:35*


## 1.1 (2015-10-05)

### Other changes

**set https github connections**


[85f2a](https://github.com/jenkinsci/git-changelog-plugin/commit/85f2a8f9f6da75e) Paul Wellner Bou *2015-10-05 12:16:20*

**Preparation for jenkins hosting**


[fdd32](https://github.com/jenkinsci/git-changelog-plugin/commit/fdd32995769414f) Paul Wellner Bou *2015-10-05 11:18:00*

**Adjust pom for jenkins github fork**


[cc738](https://github.com/jenkinsci/git-changelog-plugin/commit/cc73800269c3c65) Paul Wellner Bou *2015-10-05 10:23:23*

**Add email-ext plugin only when running with hpi:run**


[04f83](https://github.com/jenkinsci/git-changelog-plugin/commit/04f8313ad94ff65) Paul Wellner Bou *2015-10-04 13:03:48*

**Merge pull request #2 from paulwellnerbou/bugfix-jenkins-slave**

* Fixing #1: jenkins slave 

[7d661](https://github.com/jenkinsci/git-changelog-plugin/commit/7d661cf3526577e) Paul Wellner Bou *2015-10-02 20:37:34*

**Pin git-changelog version to 2.2**


[41c26](https://github.com/jenkinsci/git-changelog-plugin/commit/41c26fdf3095151) Paul Wellner Bou *2015-10-02 20:36:22*

**Refactoring and fixing for issue #1**


[be5de](https://github.com/jenkinsci/git-changelog-plugin/commit/be5de060191fa73) Paul Wellner Bou *2015-10-02 20:35:55*

**Make task serializable (#1)**


[22b91](https://github.com/jenkinsci/git-changelog-plugin/commit/22b91f5f4737ff2) Paul Wellner Bou *2015-10-01 11:12:01*

**Add slave/master sensitive task to publisher (#1)**


[735fa](https://github.com/jenkinsci/git-changelog-plugin/commit/735fac36b0871ef) Paul Wellner Bou *2015-10-01 10:56:19*

**Add logging**


[5b1ef](https://github.com/jenkinsci/git-changelog-plugin/commit/5b1ef7e52e7960f) Paul Wellner Bou *2015-10-01 05:42:08*

**Add logging**


[ffb0c](https://github.com/jenkinsci/git-changelog-plugin/commit/ffb0cdcc4170288) Paul Wellner Bou *2015-10-01 05:12:11*

**refactor and rename: Generify changelog generation, jira filter is just one possibility for output**


[a6605](https://github.com/jenkinsci/git-changelog-plugin/commit/a66056892f01f00) Paul Wellner Bou *2015-09-29 22:10:45*

**refactor and rename: Generify changelog generation, jira filter is just one possibility for output**


[1774b](https://github.com/jenkinsci/git-changelog-plugin/commit/1774baa5dcd6b67) Paul Wellner Bou *2015-09-29 22:10:35*

**Adjust documentation headings**


[3ff9d](https://github.com/jenkinsci/git-changelog-plugin/commit/3ff9d2d9beb8054) Paul Wellner Bou *2015-09-25 11:50:30*

**Extend documentation**


[c9536](https://github.com/jenkinsci/git-changelog-plugin/commit/c95361447452b74) Paul Wellner Bou *2015-09-25 11:49:12*

**downscale images**


[84bf5](https://github.com/jenkinsci/git-changelog-plugin/commit/84bf5f374c3931d) Paul Wellner Bou *2015-09-25 11:40:32*

**Add README**


[ac5b8](https://github.com/jenkinsci/git-changelog-plugin/commit/ac5b8c3d84b4cb7) Paul Wellner Bou *2015-09-25 11:38:48*

**Adjust pom and run script, set jenkins parent to latest LTS version**


[5d53a](https://github.com/jenkinsci/git-changelog-plugin/commit/5d53ac3daa31622) Paul Wellner Bou *2015-09-25 10:17:24*

**Delete non project file**


[47bb6](https://github.com/jenkinsci/git-changelog-plugin/commit/47bb6c03dc670d9) Paul Wellner Bou *2015-09-25 10:16:36*

**Prepare pom for Jenkins hosting**


[48ae1](https://github.com/jenkinsci/git-changelog-plugin/commit/48ae18dddbfffb7) Paul Wellner Bou *2015-07-13 15:31:52*


## refs/tags/1.0 (2015-06-24)

### Other changes

**Set version to 1.0**


[fa325](https://github.com/jenkinsci/git-changelog-plugin/commit/fa32544f0e59c05) Paul Wellner Bou *2015-06-24 10:17:26*

**Fix bugs, add a bit of documentation and index.jelly, add torev/fromrev fields for publisher**


[4c7a1](https://github.com/jenkinsci/git-changelog-plugin/commit/4c7a170c490e78a) Paul Wellner Bou *2015-06-23 22:48:01*

**Fix developer/scm connection in pom**


[c5fd4](https://github.com/jenkinsci/git-changelog-plugin/commit/c5fd431d01bda14) Paul Wellner Bou *2015-06-23 14:44:05*

**Inital commit**


[333ec](https://github.com/jenkinsci/git-changelog-plugin/commit/333eccf5a64ff86) Paul Wellner Bou *2015-06-23 14:38:30*

**Initial commit**


[44c98](https://github.com/jenkinsci/git-changelog-plugin/commit/44c98a744c23437) Paul Wellner Bou *2015-06-23 14:36:40*


