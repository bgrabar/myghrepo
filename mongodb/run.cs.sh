#!/bin/bash

/Users/bob/mongo/mongod --configsvr --port 27019 --dbpath /data/cs1 --config /etc/mongodb/cs1.conf --logpath /var/log/mongodb/cs1.log --nojournal --fork

/Users/bob/mongo/mongod --configsvr --port 27020 --dbpath /data/cs2 --config /etc/mongodb/cs2.conf --logpath /var/log/mongodb/cs2.log --nojournal --fork

/Users/bob/mongo/mongod --configsvr --port 27021 --dbpath /data/cs3 --config /etc/mongodb/cs3.conf --logpath /var/log/mongodb/cs3.log --nojournal --fork





