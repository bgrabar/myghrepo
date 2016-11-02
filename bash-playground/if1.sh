#!/bin/bash

echo -n "Enter a word: "
read word1
echo -n "Enter another word: "
read word2

if [ -z "$word2" ]; then
    echo "You did not a second word."
elif [ "$word1" = "$word2" ]; then
    echo strings are equal
else
    echo strings are not equal
fi

#####################################
echo -n "Enter \"y\""
read reply
if [[ $reply = "y" ]]; then
    echo true
else
    echo false
fi

#####################################

echo "Enter an unreadable file"
read filename
if [ ! -r "$filename" ]
    then
        echo "File is not read-able"
fi

#####################################

echo "Enter an existing file"
read entry
if test -w "$entry"; then
    echo "file $entry exists"
fi

