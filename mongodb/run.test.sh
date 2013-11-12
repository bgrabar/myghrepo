#!/bin/bash

/Users/bob/mongo/mongod --port 34021 --replSet test --dbpath /data/test1 --config /etc/mongodb/null --logpath /var/log/mongodb/test1.log --fork --nojournal

/Users/bob/mongo/mongod --port 34022 --replSet test --dbpath /data/test2 --config /etc/mongodb/null --logpath /var/log/mongodb/test2.log --fork --nojournal

/Users/bob/mongo/mongod --port 34023 --replSet test --dbpath /data/test3 --config /etc/mongodb/null --logpath /var/log/mongodb/test3.log --fork --nojournal
