#!/bin/sh
mvn versions:update-properties
mvnDebug hpi:run -Djava.util.logging.config.file=logging.properties -Djenkins.version=2.479.3 -Denforcer.skip=true
