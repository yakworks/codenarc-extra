#!/usr/bin/env bash

set -e

if [[ -n $TRAVIS_TAG ]] || [[ $TRAVIS_BRANCH == 'master' && $TRAVIS_REPO_SLUG == "yakworks/codenarc-extra" && $TRAVIS_PULL_REQUEST == 'false' ]]; then

    if [[ -n $TRAVIS_TAG ]]
    then
        echo "### publishing release to BinTray"
        ./gradlew bintrayUpload --no-daemon
    fi

else
  echo "Not a Tag, not publishing"
  echo "TRAVIS_BRANCH: $TRAVIS_BRANCH"
  echo "TRAVIS_TAG: $TRAVIS_TAG"
  echo "TRAVIS_REPO_SLUG: $TRAVIS_REPO_SLUG"
  echo "TRAVIS_PULL_REQUEST: $TRAVIS_PULL_REQUEST"
fi
