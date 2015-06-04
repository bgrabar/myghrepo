import pymongo
import sys

# establish a connection to the database
connection = pymongo.MongoClient("mongodb://localhost")
# connection = pymongo.MongoClient("mongodb://localhost:34021")

db=connection.students
grades=db.grades

def remove_lowest_hw():

# select type = homework

    a = -1

    try:
        cursor = grades.find({'type':'homework'})
        cursor = cursor.sort([('student_id',pymongo.ASCENDING),('score',pymongo.ASCENDING)])

    except:
        print "Unexpected error:", sys.exc_info()[0]

    for doc in cursor:

        next_id = doc['student_id']

        if a == next_id:
            continue
        else:
            a = next_id
            grades.remove(doc)

remove_lowest_hw()
