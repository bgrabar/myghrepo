#!/bin/bash

mongos --port 27047 --configdb gromit.local:27049 --logpath /var/log/mongodb/mongos24.log --chunkSize 1 --fork

# --configdb gromit:27049

