#!/bin/sh
mvn hpi:run -Djava.util.logging.config.file=logging.properties -Djenkins.version=2.118 -Denforcer.skip=true
