#!/bin/bash

mongod --port 34024 --config /etc/mongodb/mongodb2.4.conf --fork --dbpath /data/standalone2.4 --logpath /var/log/mongodb/standalone2.4.log --nojournal
