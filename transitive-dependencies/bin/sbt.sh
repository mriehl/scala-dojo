#!/bin/bash

script=$(readlink -f "$0")

scriptdir=$(dirname "$script")

sbt_opts="${sbt_opts}\
  -Xms512M -Xmx1024M -Xss1M \
  -XX:+CMSClassUnloadingEnabled \
  -Dsbt.override.build.repos=true \
  -Dsbt.repository.config=$scriptdir/launcher.conf \
  -Dhttp.proxyHost=proxy.rz.is24.loc \
  -Dhttp.proxyPort=3128"

java $sbt_opts -jar $scriptdir/sbt-launch-0.13.8.jar "$@"
