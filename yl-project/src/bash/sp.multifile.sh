#!/bin/bash

# This script splits existing books into smaller files. 

# !!!IMPORTANT:  Change FILENAMES and FILEPATHS as needed

# To run, run this command:   find pairtree_root -type d -exec ../sp.??????????????????????.sh {} \;




EXPANDED_DIR=/gds_02/data/split.tests/????????????????????????/
RELATIVE_DIR=${1}

NAME=placeholder

# This function is called if the directory contains files
function setName()
{
    NAME={1:2}
}

# This function is called if the directory contains files
function splitFile()
{

    # Change the directory. This does not affect the directory used by the command line.
    cd ${EXPANDED_DIR}${RELATIVE_DIR}
    
    # Split the original file into sections and give them the name of the original file appended with ".section.xxxxx"
    split -l 500 -a 5 ${NAME} ${NAME}-section_
    
    # Remove the original file
    rm ${NAME}

}

# The if statement runs if the directory contains a .txt file. Ultimately we need an if statement that tests
# whether the directory contains ANY file. The if statement also assumes one file per directory.
if [ -e ${EXPANDED_DIR}${RELATIVE_DIR}/*.txt ]; then

    find -type f -exec setName {} \; -exec splitFile \;

fi
