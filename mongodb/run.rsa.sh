#!/bin/bash

/Users/bob/mongo/mongod --port 34001 --config /etc/mongodb/config-files/rsa1.conf

/Users/bob/mongo/mongod --port 34002 --config /etc/mongodb/config-files/rsa2.conf

/Users/bob/mongo/mongod --port 34003 --config /etc/mongodb/config-files/rsa3.conf



# Does not use config file:

# /Users/bob/mongo/mongod --port 34001 --replSet rsa --dbpath /data/rsa1 --config /etc/mongodb/config-files/null --logpath /var/log/mongodb/rsa1.log

# /Users/bob/mongo/mongod --port 34002 --replSet rsa --dbpath /data/rsa2 --config /etc/mongodb/config-files/null --logpath /var/log/mongodb/rsa2.log

# /Users/bob/mongo/mongod --port 34003 --replSet rsa --dbpath /data/rsa3 --config /etc/mongodb/config-files/null --logpath /var/log/mongodb/rsa3.log




