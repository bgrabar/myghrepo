#!/bin/bash

mongod --port 34011 --config /etc/mongodb/shard1.conf --fork

mongod --port 34012 --config /etc/mongodb/shard2.conf --fork

mongod --port 34013 --config /etc/mongodb/shard3.conf --fork

# --dbpath /data/shard1 --logpath /var/log/mongodb/shard1.log --nojournal 
# --dbpath /data/shard2 --logpath /var/log/mongodb/shard2.log --nojournal
# --dbpath /data/shard3 --logpath /var/log/mongodb/shard3.log --nojournal
