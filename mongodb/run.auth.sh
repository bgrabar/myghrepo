#!/bin/bash

/Users/bob/mongo/mongod --port 34021 --auth --dbpath /data/auth --config /etc/mongodb/auth.conf --logpath /var/log/mongodb/auth.log --fork --nojournal




# to authenticate:
#
# ./mongo --port 34021 --username "admin" --password "pass" --authenticationDatabase "admin"





