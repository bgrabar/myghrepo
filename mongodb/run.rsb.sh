#!/bin/bash

/Users/bob/mongo/mongod --port 34011 --replSet rsb --dbpath /data/rsb1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb1.log --fork --nojournal

/Users/bob/mongo/mongod --port 34012 --replSet rsb --dbpath /data/rsb2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb2.log --fork --nojournal

/Users/bob/mongo/mongod --port 34013 --replSet rsb --dbpath /data/rsb3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb3.log --fork --nojournal


