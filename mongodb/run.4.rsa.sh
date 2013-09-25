#!/bin/bash

mongod --port 34041 --replSet rsa --dbpath /data/24/rsa1 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa1.24.log --fork --nojournal

mongod --port 34042 --replSet rsa --dbpath /data/24/rsa2 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa2.24.log --fork --nojournal

mongod --port 34043 --replSet rsa --dbpath /data/24/rsa3 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa3.24.log --fork --nojournal

mongod --port 34044 --replSet rsa --dbpath /data/24/rsa4 --config /etc/mongodb/null --logpath /var/log/mongodb/rsa4.24.log --fork --nojournal
