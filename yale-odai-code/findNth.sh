#!/bin/bash

# script to grab every nth file and move into into the number n bucket
# buckets are numbered from 0 to 9

# IMPORTANT: change file names and file paths as needed

# the following is a sample relPath value, before lopping off first two places:
# ./chi/pairtree_root/19/32/52/03/19325203/19325203.zip.txt


x=0   # used as a counter and determines buckets

while read line; do

    relPath=${line:2}

    mkdir -p /gds_02/data/buckets-chi/bucket$x/${relPath}/
    
    mv $relPath /gds_02/data/buckets-chi/bucket$x/${relPath}/

    x=`expr $x + 1`;

    if [ $x = 10 ]; then

        x=0

    fi

done < all.files.chi.txt
