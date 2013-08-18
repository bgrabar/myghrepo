#!/bin/bash

# This script searches a library's metada to find the book title that goes with each .txt file
#
# To run this script, run the following from a high level in a library's directory structure:
# find . -type f -name "*.xml" -exec /gds_02/data/findTitle.sh {} \;

echo $1;

grep -C 1 "tag=\"245" $1 | grep "subfield";