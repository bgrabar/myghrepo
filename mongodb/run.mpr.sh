#!/bin/bash

mongod --port 44001 --config /etc/mongodb/config-files/rsa-mpr-1.conf
mongod --port 44002 --config /etc/mongodb/config-files/rsa-mpr-2.conf

mongod --port 44006 --config /etc/mongodb/config-files/rsb-mpr-1.conf
mongod --port 44007 --config /etc/mongodb/config-files/rsb-mpr-2.conf

mongod --configsvr --port 44019 --config /etc/mongodb/config-files/cs-mpr-1.conf

mongos --port 44017 --configdb gromit.local:44019 --config /etc/mongodb/config-files/mongos-mpr.conf



