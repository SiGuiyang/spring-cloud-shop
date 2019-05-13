@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\lib

set CLASSPATH="%BASEDIR%"\conf;"%REPO%"\fescar-core-0.4.1.jar;"%REPO%"\fastjson-1.2.48.jar;"%REPO%"\netty-all-4.1.24.Final.jar;"%REPO%"\fescar-discovery-0.4.1.jar;"%REPO%"\fescar-config-0.4.1.jar;"%REPO%"\config-1.2.1.jar;"%REPO%"\fescar-common-0.4.1.jar;"%REPO%"\nacos-client-0.8.0.jar;"%REPO%"\nacos-common-0.8.0.jar;"%REPO%"\commons-io-2.2.jar;"%REPO%"\commons-lang3-3.4.jar;"%REPO%"\nacos-api-0.8.0.jar;"%REPO%"\commons-codec-1.11.jar;"%REPO%"\jackson-mapper-lgpl-1.9.6.jar;"%REPO%"\jackson-core-lgpl-1.9.6.jar;"%REPO%"\micrometer-core-1.1.1.jar;"%REPO%"\HdrHistogram-2.1.9.jar;"%REPO%"\LatencyUtils-2.0.3.jar;"%REPO%"\apollo-client-1.1.0.jar;"%REPO%"\apollo-core-1.1.0.jar;"%REPO%"\gson-2.8.0.jar;"%REPO%"\zkclient-0.10.jar;"%REPO%"\zookeeper-3.4.8.jar;"%REPO%"\log4j-1.2.16.jar;"%REPO%"\jline-0.9.94.jar;"%REPO%"\netty-3.7.0.Final.jar;"%REPO%"\jedis-2.9.0.jar;"%REPO%"\eureka-client-1.9.5.jar;"%REPO%"\jettison-1.3.7.jar;"%REPO%"\stax-api-1.0.1.jar;"%REPO%"\netflix-eventbus-0.3.0.jar;"%REPO%"\netflix-infix-0.3.0.jar;"%REPO%"\commons-jxpath-1.3.jar;"%REPO%"\joda-time-2.3.jar;"%REPO%"\servlet-api-2.5.jar;"%REPO%"\antlr-runtime-3.4.jar;"%REPO%"\stringtemplate-3.2.1.jar;"%REPO%"\antlr-2.7.7.jar;"%REPO%"\commons-math-2.2.jar;"%REPO%"\xstream-1.4.10.jar;"%REPO%"\xmlpull-1.1.3.1.jar;"%REPO%"\xpp3_min-1.1.4c.jar;"%REPO%"\jsr311-api-1.1.1.jar;"%REPO%"\servo-core-0.12.21.jar;"%REPO%"\jersey-core-1.19.1.jar;"%REPO%"\jersey-client-1.19.1.jar;"%REPO%"\jersey-apache-client4-1.19.1.jar;"%REPO%"\httpclient-4.5.3.jar;"%REPO%"\httpcore-4.4.6.jar;"%REPO%"\commons-logging-1.2.jar;"%REPO%"\guice-4.1.0.jar;"%REPO%"\aopalliance-1.0.jar;"%REPO%"\compactmap-1.2.1.jar;"%REPO%"\dexx-collections-0.2.jar;"%REPO%"\jackson-annotations-2.9.4.jar;"%REPO%"\jackson-core-2.9.4.jar;"%REPO%"\jackson-databind-2.9.4.jar;"%REPO%"\javax.inject-1.jar;"%REPO%"\archaius-core-0.7.6.jar;"%REPO%"\jsr305-3.0.1.jar;"%REPO%"\commons-configuration-1.8.jar;"%REPO%"\guava-16.0.jar;"%REPO%"\commons-pool2-2.4.2.jar;"%REPO%"\commons-pool-1.6.jar;"%REPO%"\commons-lang-2.6.jar;"%REPO%"\logback-classic-1.2.0.jar;"%REPO%"\logback-core-1.2.0.jar;"%REPO%"\slf4j-api-1.7.22.jar;"%REPO%"\fescar-server-0.4.1.jar

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% -server -XX:MaxDirectMemorySize=1024M -classpath %CLASSPATH% -Dapp.name="fescar-server" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" com.alibaba.fescar.server.Server %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
