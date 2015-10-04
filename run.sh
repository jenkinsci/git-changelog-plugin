#!/bin/sh
rm -rf work/plugins
MAVEN_OPTS="$MAVEN_OPTS -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
mvn -Dmaven.test.skip=true -DskipTests=true -Djetty.port=9191 clean compile org.jenkins-ci.tools:maven-hpi-plugin:run -Pjenkins,with-email-ext
