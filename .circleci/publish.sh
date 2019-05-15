#!/usr/bin/env bash

set -e

if [[ -n $CIRCLE_TAG ]]
then
    echo "### publishing release to BinTray"
    ./gradlew bintrayUpload --no-daemon
else
  echo "Not a Tag, not publishing"
  echo "BRANCH: $CIRCLE_BRANCH"
  echo "PULL_REQUEST: $CIRCLE_PULL_REQUEST"
fi