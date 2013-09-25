#!/bin/bash

/Users/bob/mongo/mongod --port 27019 --configsvr --dbpath /data/configsvr --logpath /var/log/mongodb/configsvr26.log --nojournal --config /etc/mongodb/null --fork
