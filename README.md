# CiDemo

[![Build Status](http://dev.imjac.in/travis/FRC-1294/CiDemo)](https://travis-ci.org/FRC-1294/CiDemo)

[![Download](https://api.bintray.com/packages/johnrudolflewis/FRC-1294/CiDemo/images/download.svg) ](https://bintray.com/johnrudolflewis/FRC-1294/CiDemo/_latestVersion)
 
The purpose of this repo is to test Travis Ci in preparation for this years FRC season

# Continuous Integration Builds
Every time a commit is pushed to GitHub, a travis-ci build is started. At the end of every build, the jar file is uploaded to Bintray.

You can view the output of the latest build and view the build history [here](https://travis-ci.org/FRC-1294/CiDemo).

You can view the list of preserved jar files [here](https://bintray.com/johnrudolflewis/FRC-1294/CiDemo/view).

# Deployments

### To deploy a pre-built version of the code to the robot
This is the recommended way to deploy code.

While connected to the Internet, from the command line: `gradlew downloadReleases`
Then while connected to the robot, from the command line: `gradlew deployRelease`

### To build and deploy the code to the robot
This method is useful when you have a minor change you want to test on the robot before committing your code to GitHub. The drawback is that your code is not on GitHub. And there is no history of this build preserved on Bintray. You work could easily be lost.

While connected to the robot, from the command line: `gradlew deploy`

# Releases
This project uses a release plugin that formats its versions semantically as follows:

`<major>.<minor>.<patch>[.<pre-release>][+<build-metadata>]`

To make a new patch release, from the command line: `gradlew release`

To make a new minor release, from the command line: `gradlew release -Prelease.scope=minor -Prelease.stage=final`
