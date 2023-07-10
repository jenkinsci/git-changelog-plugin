#!/bin/sh
./mvnw versions:update-properties
./mvnw hpi:run -Djava.util.logging.config.file=logging.properties -Djenkins.version=2.401.2 -Denforcer.skip=true
