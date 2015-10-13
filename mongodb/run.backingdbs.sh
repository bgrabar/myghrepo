#!/bin/bash

mongod --port 27017 --dbpath /data/backingdb1 --logpath /var/log/mongodb/backingdb1.log --fork --nojournal

mongod --port 27018 --dbpath /data/backingdb2 --logpath /var/log/mongodb/backingdb2.log --fork --nojournal
