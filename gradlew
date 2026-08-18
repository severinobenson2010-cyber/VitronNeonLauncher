#!/bin/sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}	# leaves a trailing /; empty if no leading path
    [ -h "$app_path" ]
do
    ls=$( ls -ld "$app_path" )
    link=${ls#*' -> '}
    case $link in             #(
      /*)   app_path=$link ;; #(
      *)    app_path=$APP_HOME$link ;;
    esac
done

APP_HOME=$( cd "${APP_HOME:-.}" && pwd -P ) || exit

APP_NAME="Gradle"
APP_BASE_NAME=${0##*/}
export APP_HOME
export APP_BASE_NAME

# Add a user-defined _JAVA_OPTIONS to the JVM arguments
# JVM_OPTS is not a public API so we do not document it, but we're not going to remove it
# because it was in the original wrapper script
if [ -n "$_JAVA_OPTIONS" ] ; then
    JVM_OPTS="$JVM_OPTS $_JAVA_OPTIONS"
fi

exec "$JAVACMD" $JVM_OPTS \
	-classpath "$CLASSPATH" \
	org.gradle.wrapper.GradleWrapperMain \
	"$@"
