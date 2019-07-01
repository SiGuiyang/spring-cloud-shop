#!/usr/bin/env bash

BASEDIR=$(dirname $0)

echo $BASEDIR
cd vue-shop-admin
sh deploy-ui.sh
mvn clean resources:resources -f ${BASEDIR}/pom.xml
mvn package -f ${BASEDIR}/pom.xml
