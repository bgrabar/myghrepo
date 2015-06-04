
import pymongo
import sys

# establish a connection to the database
connection = pymongo.MongoClient("mongodb://localhost")
# connection = pymongo.MongoClient("mongodb://localhost:34021")

# get a handle to the school database
db=connection.reddit
scores = db.stories


def find():

    print "\nfind, reporting for duty"

    query = {'title':{'$regex':'the'}}
    projection = {'title':1, '_id':0}

    try:
        cursor = scores.find(query, projection)

    except:
        print "Unexpected error:", sys.exc_info()[0]

    print '\n'
    sanity = 0
    for doc in cursor:
        print doc
        print '\n'
        sanity += 1
        if (sanity > 10):
            break
        

find()

