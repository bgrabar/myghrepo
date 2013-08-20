#!/bin/bash

mongod --port 27019 --configsvr --dbpath /data/configsvr --logpath /var/log/mongodb/configsvr.log --nojournal --config /etc/mongodb/null --fork
