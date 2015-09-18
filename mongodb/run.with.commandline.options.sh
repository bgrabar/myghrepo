# run a replica set with command-line options

mongod --port 34051 --dbpath /data/rsz-51 --logpath /var/log/mongodb/rsz-51.log --fork --nojournal --replSet rsz

mongod --port 34052 --dbpath /data/rsz-52 --logpath /var/log/mongodb/rsz-52.log --fork --nojournal --replSet rsz

mongod --port 34053 --dbpath /data/rsz-53 --logpath /var/log/mongodb/rsz-53.log --fork --nojournal --replSet rsz

