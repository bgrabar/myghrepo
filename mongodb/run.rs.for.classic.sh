#!/bin/bash


mongod --port 34001 --config /etc/mongodb/config-files/rsa1.conf
mongod --port 34002 --config /etc/mongodb/config-files/rsa2.conf
# mongod --port 34003 --config /etc/mongodb/config-files/rsa3.conf
# mongod --port 34004 --config /etc/mongodb/config-files/rsa4.conf
mongod --port 34005 --config /etc/mongodb/config-files/rsa5.conf

