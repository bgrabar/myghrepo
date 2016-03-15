#!/bin/bash



# Runs the compiled 'mongod' in
# /Users/bob/mongo
# instead of the installed 'mongod' in
# /usr/local/bin/mongo

/Users/bob/mongo/mongod --port 35017 --config /Users/bob/myrepo/mongodb/config-files/standalone.conf
