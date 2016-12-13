#!/bin/bash

sudo apt-get update 
sudo apt-get --assume-yes install g++  

sudo apt-get --assume-yes install openjdk-7-jdk
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin

#Install the puppet modules and dependencies.
wget http://apt.puppetlabs.com/puppetlabs-release-trusty.deb
sudo dpkg -i puppetlabs-release-trusty.deb 
sudo apt-get --assume-yes install python-software-properties
sudo apt-get --assume-yes install scala

apt-cache search maven
sudo apt-get --assume-yes install maven

sudo apt-get --assume-yes install puppet
puppet module install puppetlabs-mysql
puppet module install puppetlabs-mongodb

