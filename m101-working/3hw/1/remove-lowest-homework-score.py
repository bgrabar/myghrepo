import pymongo
import sys

connection = pymongo.MongoClient("mongodb://localhost")
db=connection.school
students=db.students

def remove_lowest_homework_score():

    try:
        cursor = students.find()

    except:
        print "Unexpected error:", sys.exc_info()[0]

    for doc in cursor:

        low = 101.0
        lowest = {}
        for elem in doc['scores']:
            if elem['type'] == 'homework':
                value = elem['score']
                if value < low:
                    low = value
                    lowest=elem
                    #print value
                    #print lowest

        doc['scores'].remove(lowest)

        id = doc['_id']

        students.update({'_id':id}, {'$set':{'scores':doc['scores']}})

remove_lowest_homework_score()
