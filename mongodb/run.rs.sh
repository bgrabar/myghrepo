#!/bin/bash

mongod --port 34001 --replSet rs --dbpath /data/rs1 --logpath /var/log/mongodb/rs1.log --nojournal --config /etc/mongodb/null --fork

mongod --port 34002 --replSet rs --dbpath /data/rs2 --logpath /var/log/mongodb/rs2.log --nojournal --config /etc/mongodb/null --fork

mongod --port 34003 --replSet rs --dbpath /data/rs3 --logpath /var/log/mongodb/rs3.log --nojournal --config /etc/mongodb/null --fork

mongod --port 34004 --replSet rs --dbpath /data/rs4 --logpath /var/log/mongodb/rs4.log --nojournal --config /etc/mongodb/null --fork

