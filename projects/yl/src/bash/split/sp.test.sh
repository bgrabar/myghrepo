#!/bin/bash

# This script splits existing books into smaller files. 

# !!!IMPORTANT:  Change FILENAMES and FILEPATHS as needed

# To run, run this command:
# find test_folder -type d -exec ../sp.test.sh {} \;


EXPANDED_DIR=/gds_02/data/split.tests/test/
RELATIVE_DIR=${1}

# The if statement runs if the directory contains a .txt file. 
# The if statement assumes one file per directory.
if [ -e ${EXPANDED_DIR}${RELATIVE_DIR}/*.txt ]; then

    # Change the directory. This does not affect the directory used by the command line.
    cd ${EXPANDED_DIR}${RELATIVE_DIR}
    
    # Store the name of the original file
    name=`find -type f`
    
    # Split the original file into sections. Give each section the name of the original file, appended with ".section.xxxxx"
    split -l 500 -a 5 ${name:2} ${name:2}-section_
    
    # Remove the original file
    rm ${name:2}

fi
