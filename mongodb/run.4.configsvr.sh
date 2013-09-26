#!/bin/bash

mongod --configsvr --port 27049 --dbpath /data/24/configsvr --logpath /var/log/mongodb/configsvr24.log --nojournal --config /etc/mongodb/null --fork
