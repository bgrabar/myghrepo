#!/bin/bash

/Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019 --logpath /var/log/mongodb/mongos26.log --chunkSize 1 --fork

# --configdb gromit:27019

