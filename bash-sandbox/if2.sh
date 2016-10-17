#!/bin/bash

x=top
y=hat

if [ -z "$2" ]; then
    echo "You did not enter a second word."
elif [ "$1" = "$2" ]; then
    echo strings are equal
else
    echo strings are not equal
fi

echo "$x"
echo $y
