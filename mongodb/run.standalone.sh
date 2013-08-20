#!/bin/bash

mongod --port 34024 --config /etc/mongodb/mongodb2.4.conf --fork

# --dbpath /data/db2.4 --logpath /var/log/mongodb/db2.4.log --nojournal
