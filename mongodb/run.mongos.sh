#!/bin/bash

/Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --fork


# --configdb gromit:27019


