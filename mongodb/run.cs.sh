#!/bin/bash

/Users/bob/mongo/mongod --configsvr --port 27019 --config /etc/mongodb/cs1.conf

/Users/bob/mongo/mongod --configsvr --port 27020 --config /etc/mongodb/cs2.conf

/Users/bob/mongo/mongod --configsvr --port 27021 --config /etc/mongodb/cs3.conf




