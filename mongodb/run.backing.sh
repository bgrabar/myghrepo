#!/bin/bash

mongod --port 27017 --dbpath /Users/bob/mms/data/db/standalone/27017 --logpath /Users/bob/mms/data/db/standalone/27017/mongodb.log --logappend --oplogSize=100 --nohttpinterface --setParameter enableTestCommands=1 --storageEngine mmapv1 --smallfiles --noprealloc --fork
