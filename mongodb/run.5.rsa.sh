#!/bin/bash

/Users/bob/mongo/mongod --port 34001 --replSet rsa --dbpath /data/rsa1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa1.26.log --fork --nojournal

/Users/bob/mongo/mongod --port 34002 --replSet rsa --dbpath /data/rsa2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa2.26.log --fork --nojournal

/Users/bob/mongo/mongod --port 34003 --replSet rsa --dbpath /data/rsa3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa3.26.log --fork --nojournal

/Users/bob/mongo/mongod --port 34004 --replSet rsa --dbpath /data/rsa4 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa4.26.log --fork --nojournal

