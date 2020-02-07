#!/usr/bin/env bash
nohup java -jar -XX:metaspaceSize=128m -XX:MaxMetaspaceSize=56m -Xms128m -Xms128m -Xmn32m -Xss256k -XX:SurvivorRatio=8 --XX:+UseConcMarkSweepGC short-url.jar --spring.profiles.active=prod &
