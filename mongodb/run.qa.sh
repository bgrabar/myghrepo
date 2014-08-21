#!/bin/bash

mongod --port 54001 --config /etc/mongodb/config-files/qa-rsa-1.conf
mongod --port 54002 --config /etc/mongodb/config-files/qa-rsa-2.conf

mongod --port 54006 --config /etc/mongodb/config-files/qa-rsb-1.conf
mongod --port 54007 --config /etc/mongodb/config-files/qa-rsb-2.conf

mongod --configsvr --port 54019 --config /etc/mongodb/config-files/qa-cs-1.conf

mongos --port 54017 --configdb gromit.local:54019 --config /etc/mongodb/config-files/mongos-qa.conf



