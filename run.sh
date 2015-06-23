#! /bin/sh
rm -rf work/plugins
mvn -Dmaven.test.skip=true -DskipTests=true -Djetty.port=9191 clean org.jenkins-ci.tools:maven-hpi-plugin:run -Pjenkins
