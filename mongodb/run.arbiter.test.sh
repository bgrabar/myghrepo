#!/bin/bash

/Users/bob/mongo/mongod --port 34024 --replSet test --dbpath /data/test4 --config /etc/mongodb/null --logpath /var/log/mongodb/test4.log --fork --nojournal
