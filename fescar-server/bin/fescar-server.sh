#!/bin/sh
# ----------------------------------------------------------------------------
#  Copyright 2001-2006 The Apache Software Foundation.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
# ----------------------------------------------------------------------------
#
#   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
#   reserved.


# resolve links - $0 may be a softlink
PRG="$0"

while [ -h "$PRG" ]; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done

PRGDIR=`dirname "$PRG"`
BASEDIR=`cd "$PRGDIR/.." >/dev/null; pwd`

# Reset the REPO variable. If you need to influence this use the environment setup file.
REPO=


# OS specific support.  $var _must_ be set to either true or false.
cygwin=false;
darwin=false;
case "`uname`" in
  CYGWIN*) cygwin=true ;;
  Darwin*) darwin=true
           if [ -z "$JAVA_VERSION" ] ; then
             JAVA_VERSION="CurrentJDK"
           else
             echo "Using Java version: $JAVA_VERSION"
           fi
		   if [ -z "$JAVA_HOME" ]; then
		      if [ -x "/usr/libexec/java_home" ]; then
			      JAVA_HOME=`/usr/libexec/java_home`
			  else
			      JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/${JAVA_VERSION}/Home
			  fi
           fi       
           ;;
esac

if [ -z "$JAVA_HOME" ] ; then
  if [ -r /etc/gentoo-release ] ; then
    JAVA_HOME=`java-config --jre-home`
  fi
fi

# For Cygwin, ensure paths are in UNIX format before anything is touched
if $cygwin ; then
  [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
  [ -n "$CLASSPATH" ] && CLASSPATH=`cygpath --path --unix "$CLASSPATH"`
fi

# If a specific java binary isn't specified search for the standard 'java' binary
if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD=`which java`
  fi
fi

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly." 1>&2
  echo "  We cannot execute $JAVACMD" 1>&2
  exit 1
fi

if [ -z "$REPO" ]
then
  REPO="$BASEDIR"/lib
fi

CLASSPATH="$BASEDIR"/conf:"$REPO"/fescar-core-0.4.1.jar:"$REPO"/fastjson-1.2.48.jar:"$REPO"/netty-all-4.1.24.Final.jar:"$REPO"/fescar-discovery-0.4.1.jar:"$REPO"/fescar-config-0.4.1.jar:"$REPO"/config-1.2.1.jar:"$REPO"/fescar-common-0.4.1.jar:"$REPO"/nacos-client-0.8.0.jar:"$REPO"/nacos-common-0.8.0.jar:"$REPO"/commons-io-2.2.jar:"$REPO"/commons-lang3-3.4.jar:"$REPO"/nacos-api-0.8.0.jar:"$REPO"/commons-codec-1.11.jar:"$REPO"/jackson-mapper-lgpl-1.9.6.jar:"$REPO"/jackson-core-lgpl-1.9.6.jar:"$REPO"/micrometer-core-1.1.1.jar:"$REPO"/HdrHistogram-2.1.9.jar:"$REPO"/LatencyUtils-2.0.3.jar:"$REPO"/apollo-client-1.1.0.jar:"$REPO"/apollo-core-1.1.0.jar:"$REPO"/gson-2.8.0.jar:"$REPO"/zkclient-0.10.jar:"$REPO"/zookeeper-3.4.8.jar:"$REPO"/log4j-1.2.16.jar:"$REPO"/jline-0.9.94.jar:"$REPO"/netty-3.7.0.Final.jar:"$REPO"/jedis-2.9.0.jar:"$REPO"/eureka-client-1.9.5.jar:"$REPO"/jettison-1.3.7.jar:"$REPO"/stax-api-1.0.1.jar:"$REPO"/netflix-eventbus-0.3.0.jar:"$REPO"/netflix-infix-0.3.0.jar:"$REPO"/commons-jxpath-1.3.jar:"$REPO"/joda-time-2.3.jar:"$REPO"/servlet-api-2.5.jar:"$REPO"/antlr-runtime-3.4.jar:"$REPO"/stringtemplate-3.2.1.jar:"$REPO"/antlr-2.7.7.jar:"$REPO"/commons-math-2.2.jar:"$REPO"/xstream-1.4.10.jar:"$REPO"/xmlpull-1.1.3.1.jar:"$REPO"/xpp3_min-1.1.4c.jar:"$REPO"/jsr311-api-1.1.1.jar:"$REPO"/servo-core-0.12.21.jar:"$REPO"/jersey-core-1.19.1.jar:"$REPO"/jersey-client-1.19.1.jar:"$REPO"/jersey-apache-client4-1.19.1.jar:"$REPO"/httpclient-4.5.3.jar:"$REPO"/httpcore-4.4.6.jar:"$REPO"/commons-logging-1.2.jar:"$REPO"/guice-4.1.0.jar:"$REPO"/aopalliance-1.0.jar:"$REPO"/compactmap-1.2.1.jar:"$REPO"/dexx-collections-0.2.jar:"$REPO"/jackson-annotations-2.9.4.jar:"$REPO"/jackson-core-2.9.4.jar:"$REPO"/jackson-databind-2.9.4.jar:"$REPO"/javax.inject-1.jar:"$REPO"/archaius-core-0.7.6.jar:"$REPO"/jsr305-3.0.1.jar:"$REPO"/commons-configuration-1.8.jar:"$REPO"/guava-16.0.jar:"$REPO"/commons-pool2-2.4.2.jar:"$REPO"/commons-pool-1.6.jar:"$REPO"/commons-lang-2.6.jar:"$REPO"/logback-classic-1.2.0.jar:"$REPO"/logback-core-1.2.0.jar:"$REPO"/slf4j-api-1.7.22.jar:"$REPO"/fescar-server-0.4.1.jar

ENDORSED_DIR=
if [ -n "$ENDORSED_DIR" ] ; then
  CLASSPATH=$BASEDIR/$ENDORSED_DIR/*:$CLASSPATH
fi

if [ -n "$CLASSPATH_PREFIX" ] ; then
  CLASSPATH=$CLASSPATH_PREFIX:$CLASSPATH
fi

# For Cygwin, switch paths to Windows format before running java
if $cygwin; then
  [ -n "$CLASSPATH" ] && CLASSPATH=`cygpath --path --windows "$CLASSPATH"`
  [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --path --windows "$JAVA_HOME"`
  [ -n "$HOME" ] && HOME=`cygpath --path --windows "$HOME"`
  [ -n "$BASEDIR" ] && BASEDIR=`cygpath --path --windows "$BASEDIR"`
  [ -n "$REPO" ] && REPO=`cygpath --path --windows "$REPO"`
fi

exec "$JAVACMD" $JAVA_OPTS -server -XX:MaxDirectMemorySize=1024M \
  -classpath "$CLASSPATH" \
  -Dapp.name="fescar-server" \
  -Dapp.pid="$$" \
  -Dapp.repo="$REPO" \
  -Dapp.home="$BASEDIR" \
  -Dbasedir="$BASEDIR" \
  com.alibaba.fescar.server.Server \
  "$@"
