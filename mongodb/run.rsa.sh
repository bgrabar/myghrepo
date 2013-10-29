#!/bin/bash

/Users/bob/mongo/mongod --port 34001 --replSet rsa --dbpath /data/rsa1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa1.log --fork --nojournal

/Users/bob/mongo/mongod --port 34002 --replSet rsa --dbpath /data/rsa2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa2.log --fork --nojournal

/Users/bob/mongo/mongod --port 34003 --replSet rsa --dbpath /data/rsa3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa3.log --fork --nojournal


