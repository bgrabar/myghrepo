#!/bin/bash

# This script grabs every nth file and moves it into the nth bucket. 
# This script creates 10 buckets, numbered from 0 to 9.
 
# TO RUN THIS SCRIPT:
# 1. Perform a find operation to create a text file that lists all the 
#    files in the library. Name it all.files.<lib>.txt
# 2. In this script, change the file names and file paths as needed. Make
#    sure the input file at the end of the while loop is correct.
# 3. Run this script from the directory that also contains the library dir (e.g., chi).

# NOTE ON relPath:
# The following is a sample relPath value, before lopping off first two places:
# ./chi/pairtree_root/19/32/52/03/19325203/19325203.zip.txt


x=0   # used as a counter and to determine bucket names

while read line; do

    relPath=${line:2}

    mkdir -p /gds_02/data/buckets-chi/bucket$x/${relPath}/
    
    mv $relPath /gds_02/data/buckets-chi/bucket$x/${relPath}/

    x=`expr $x + 1`;

    if [ $x = 10 ]; then

        x=0

    fi

done < all.files.chi.txt
