#!/bin/bash

mongod --port 54001 --config /etc/mongodb/config-files/rsa-qa-1.conf
mongod --port 54002 --config /etc/mongodb/config-files/rsa-qa-2.conf

mongod --port 54006 --config /etc/mongodb/config-files/rsb-qa-1.conf
mongod --port 54007 --config /etc/mongodb/config-files/rsb-qa-2.conf

mongod --configsvr --port 54019 --config /etc/mongodb/config-files/cs-qa-1.conf

mongos --port 54017 --configdb gromit.local:54019 --config /etc/mongodb/config-files/mongos-qa.conf



