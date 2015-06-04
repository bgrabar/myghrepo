
import pymongo

# gets the next number in a sequence
def get_next_sequence_number(name):
    connection = pymongo.MongoClient("mongodb://localhost")
    # connection = pymongo.MongoClient("mongodb://localhost:34021")
    db = connection.test
    counters = db.counters

    # let's get ourselves a sequence number

    counter = counters.find_and_modify(query={'type':name}, 
                                       update={'$inc':{'value':1}}, 
                                       upsert=True, new=True)
    counter_value = counter['value']
    return counter_value

print get_next_sequence_number('uid')
print get_next_sequence_number('uid')
print get_next_sequence_number('uid')
