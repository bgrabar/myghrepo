#!/bin/bash

/Users/bob/mongo/mongod --configsvr --port 27019 --dbpath /data/cs1 --logpath /var/log/mongodb/cs1.log --nojournal --config /etc/mongodb/null --fork

#
/Users/bob/mongo/mongod --configsvr --port 27020 --dbpath /data/cs2 --logpath /var/log/mongodb/cs2.log --nojournal --config /etc/mongodb/null --fork

#
/Users/bob/mongo/mongod --configsvr --port 27021 --dbpath /data/cs3 --logpath /var/log/mongodb/cs3.log --nojournal --config /etc/mongodb/null --fork

