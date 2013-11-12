#!/bin/bash

# !!! THIS SCRIPT USES A CP INSTEAD OF A MV


# This script grabs every nth file and moves it into the nth bucket.
# This script creates 10 buckets, numbered from 0 to 9.

# TO RUN THIS SCRIPT:
# 1. Perform a find operation to create a text file that lists all the
#    files in the library. Name it all.files.<lib>.txt
#    NOTE: V.1 (makeBuckets1.sh) was based on an all.files.<lib>.txt file that contained
#    paths like the following, and that required lopping off first two places:
#    ./chi/pairtree_root/19/32/52/03/19325203/19325203.zip.txt
#    This version is based on using the following command to build the
#    all.files.<lib>.txt file and does not need to lop off two places:
#    find chi -type f > all.files.chi.txt
# 2. In this script, change the file names and file paths as needed. Make
#    sure the input file at the end of the while loop is correct.
# 3. Run this script from the directory that also contains the library dir (e.g., chi).



x=0   # used as a counter and to determine bucket names

while read line; do

    mkdir -p /gds_02/data/bucketed.split-uc1/bucket$x/${line}/

    cp $line /gds_02/data/bucketed.split-uc1/bucket$x/${line}/

    x=`expr $x + 1`;

    if [ $x = 10 ]; then

        x=0

    fi

done < all.files-split.of.uc1.txt