#!/bin/bash

mongod --port 27049 --configsvr --dbpath /data/24/configsvr --logpath /var/log/mongodb/configsvr24.log --nojournal --config /etc/mongodb/null --fork
