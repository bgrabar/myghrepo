#!/bin/bash

/Users/bob/mongo/mongod --port 34005 --replSet rsb --dbpath /data/rsb1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb1.26.log --fork --nojournal

/Users/bob/mongo/mongod --port 34006 --replSet rsb --dbpath /data/rsb2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb2.26.log --fork --nojournal

/Users/bob/mongo/mongod --port 34007 --replSet rsb --dbpath /data/rsb3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb3.26.log --fork --nojournal

# /Users/bob/mongo/mongod --port 34008 --replSet rsb --dbpath /data/rsb4 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb4.26.log --fork --nojournal

