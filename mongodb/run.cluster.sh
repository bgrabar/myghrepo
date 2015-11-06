#!/bin/bash

# To run from **compiled** mongo code, use "/Users/bob/mongo/mongod" instead of "mongod" and use
# "/Users/bob/mongo/mongos" instead of "mongos".

# Why does adding the keyFile to each line fail?: --keyFile /Users/bob/keyfile



# SHARD 1

mongod --port 34001 --config /etc/mongodb/config-files/rsa1.conf
mongod --port 34002 --config /etc/mongodb/config-files/rsa2.conf
mongod --port 34003 --config /etc/mongodb/config-files/rsa3.conf
# mongod --port 34004 --config /etc/mongodb/config-files/rsa4.



# SHARD 2

mongod --port 34011 --config /etc/mongodb/config-files/rsb1.conf
mongod --port 34012 --config /etc/mongodb/config-files/rsb2.conf
mongod --port 34013 --config /etc/mongodb/config-files/rsb3.conf
# mongod --port 34014 --config /etc/mongodb/config-files/rsb4.conf



# CONFIG SERVERS

mongod --configsvr --port 34019 --config /etc/mongodb/config-files/cs1.conf
mongod --configsvr --port 34020 --config /etc/mongodb/config-files/cs2.conf
mongod --configsvr --port 34021 --config /etc/mongodb/config-files/cs3.conf



# ROUTER

mongos --port 34017 --configdb gromit.local:34019,gromit.local:34020,gromit.local:34021 --config /etc/mongodb/config-files/mongos.conf

