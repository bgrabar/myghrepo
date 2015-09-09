import urllib

def read_text():
    quotes = open("/Users/bob/myrepo/python/udacity_course_36/lesson_3/quotes.txt")
    contents_of_file = quotes.read()
    # print(contents_of_file)
    quotes.close()
    check(contents_of_file)

def check(text_to_check):
    connection = urllib.urlopen("http://www.wdyl.com/profanity?q="+text_to_check)
    output = connection.read()
    print(output)
    connection.close()

    if "true" in output:
        print("Alert.")
    elif "false" in output:
        print("All good.")
    else:
        print("Could not get info.")

read_text()
