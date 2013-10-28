#!/bin/bash

# script to grab every nth file and move into into the number n bucket
# buckets are numbered from 0 to 9

# IMPORTANT: change file names and file paths as needed

# note: Version 1 of findNth.sh was based on an all.files.<lib>.txt file that contained
# paths like the following, and that required lopping off first two places:
# ./chi/pairtree_root/19/32/52/03/19325203/19325203.zip.txt
# This version 2 of findNth.sh is based on using the following command to build the 
# all.files.<lib>.txt file and does not need to lop off two places: 
# find chi -type f > all.files.chi.txt


x=0   # used as a counter and determines buckets

while read line; do

    mkdir -p /data/buckets-chi/bucket$x/${line}/

    mv $line /data/buckets-chi/bucket$x/${line}/

    x=`expr $x + 1`;

    if [ $x = 10 ]; then

        x=0

    fi

done < all.files.chi.txt
