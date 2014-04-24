#!/bin/bash



mongod --port 34001 --config /etc/mongodb/config-files/rsa1.conf
mongod --port 34002 --config /etc/mongodb/config-files/rsa2.conf
mongod --port 34005 --config /etc/mongodb/config-files/rsa5.conf

mongod --port 34011 --config /etc/mongodb/config-files/rsb1.conf
mongod --port 34012 --config /etc/mongodb/config-files/rsb2.conf
mongod --port 34013 --config /etc/mongodb/config-files/rsb3.conf

mongod --configsvr --port 27019 --config /etc/mongodb/config-files/cs1.conf
mongod --configsvr --port 27020 --config /etc/mongodb/config-files/cs2.conf
mongod --configsvr --port 27021 --config /etc/mongodb/config-files/cs3.conf

mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --fork

