import pymongo

from pymongo import MongoClient

# connect to database
connection = MongoClient('localhost', 34021)

db = connection.test

# create handle to names collection
names = db.names

item = names.find_one()

print item['name']

