import pymongo

from pymongo import MongoClient

# connect to database
connection = MongoClient('localhost', 34021)

db = connection.test

# handle to names collection
n = db.names

item = n.find_one()

print item['name']

