#!/bin/bash

mongod --port 34045 --replSet rsb --dbpath /data/rsb1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb1.24.log --fork --nojournal

mongod --port 34046 --replSet rsb --dbpath /data/rsb2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb2.24.log --fork --nojournal

mongod --port 34047 --replSet rsb --dbpath /data/rsb3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb3.24.log --fork --nojournal

mongod --port 34048 --replSet rsb --dbpath /data/rsb4 --config /etc/mongodb/null --logpath /var/log/mongodb/rsb4.24.log --fork --nojournal
