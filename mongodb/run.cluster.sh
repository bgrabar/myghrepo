#!/bin/bash

# To run from compiled mongo code, use "/Users/bob/mongo/mongod" instead of "mongod" and
# "/Users/bob/mongo/mongos" instead of "mongos".

# Why does adding the keyFile to each line fail?: --keyFile /Users/bob/keyfile


# Run shard 1, rsa.

mongod --port 34001 --config /etc/mongodb/config-files/rsa1.conf
mongod --port 34002 --config /etc/mongodb/config-files/rsa2.conf
# mongod --port 34003 --config /etc/mongodb/config-files/rsa3.conf
# mongod --port 34004 --config /etc/mongodb/config-files/rsa4.conf
mongod --port 34005 --config /etc/mongodb/config-files/rsa5.conf

# Run shard 2, rsb.

mongod --port 34011 --config /etc/mongodb/config-files/rsb1.conf
mongod --port 34012 --config /etc/mongodb/config-files/rsb2.conf
# mongod --port 34013 --config /etc/mongodb/config-files/rsb3.conf
# mongod --port 34014 --config /etc/mongodb/config-files/rsb4.conf
mongod --port 34015 --config /etc/mongodb/config-files/rsb5.conf

# Run config servers.

mongod --configsvr --port 27019 --config /etc/mongodb/config-files/cs1.conf
mongod --configsvr --port 27020 --config /etc/mongodb/config-files/cs2.conf
mongod --configsvr --port 27021 --config /etc/mongodb/config-files/cs3.conf

# Run router.

mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --config /etc/mongodb/config-files/mongos.conf


