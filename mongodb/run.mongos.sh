#!/bin/bash

/Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --fork



# ???:

# /Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --fork --keyFile /Users/bob/Desktop/keyfile.txt

# /Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --fork --keyFile jstests/libs/key1

# /Users/bob/mongo/mongos --port 27017 --configdb gromit.local:27019,gromit.local:27020,gromit.local:27021 --logpath /var/log/mongodb/mongos.log --chunkSize 1 --keyFile jstests/libs/key1

# /Users/bob/mongo/mongos --port 27017 --configdb localhost:30000 --keyFile jstests/libs/key1 --chunkSize 50 --setParameter enableTestCommands=1




# --configdb gromit:27019


#  ./mongo -u "recordsUserAdmin" -p "password" --authenticationDatabase "mydb"



