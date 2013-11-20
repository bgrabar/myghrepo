#!/bin/bash

/Users/bob/mongo/mongod --port 34005 --replSet rsa --dbpath /data/rsa5 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa5.log --fork --nojournal
