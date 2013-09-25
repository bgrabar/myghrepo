#!/bin/bash

mongod --port 34041 --replSet rsa --dbpath /data/rsa1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa1.24.log --fork --nojournal

mongod --port 34042 --replSet rsa --dbpath /data/rsa2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa2.24.log --fork --nojournal

mongod --port 34043 --replSet rsa --dbpath /data/rsa3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa3.24.log --fork --nojournal

mongod --port 34044 --replSet rsa --dbpath /data/rsa4 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa4.24.log --fork --nojournal
