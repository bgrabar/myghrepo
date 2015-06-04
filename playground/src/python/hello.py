import bottle
import pymongo

# this is the handler for the default path of the web server

@bottle.route('/')
def index():

    # connect to mongoDB
    connection = pymongo.MongoClient('localhost', 34021)

    # attach to test database
    db = connection.sandbox


    # get handle for names collection
    n = db.names

    # find a single document
    item = n.find_one()

    return '<b>Hello %s!</b>' % item['name']


bottle.run(host='localhost', port=8082)
