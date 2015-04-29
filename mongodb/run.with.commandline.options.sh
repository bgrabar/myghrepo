# run a replica set with commandline options:

mongod --port 34071 --dbpath /data/rsz-71 --logpath /var/log/mongodb/rsz-71.log --fork --nojournal --replSet rsz

mongod --port 34072 --dbpath /data/rsz-72 --logpath /var/log/mongodb/rsz-72.log --fork --nojournal --replSet rsz

mongod --port 34073 --dbpath /data/rsz-73 --logpath /var/log/mongodb/rsz-73.log --fork --nojournal --replSet rsz

mongod --port 34074 --dbpath /data/rsz-74 --logpath /var/log/mongodb/rsz-74.log --fork --nojournal --replSet rsz




