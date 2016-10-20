#!/bin/bash

# Before runnining this script, copy the directory structure for a given 
# library collection using the following command. Change the directory
# paths where appropriate. Run the command from /gds_01/<library>:
# find . -type d -exec mkdir /gds_02/data/texts/uc1/{} \;

# To run this script, use the following command, changing the directory 
# paths and file extension where appropriate. Run from /gds_01/<library>:
# find . -type f -name "*.zip" -exec /gds_02/data/concat2.sh {} \;

EXPANDED_DIR=/gds_02/data/texts/uc1/
# should above be:
# EXPANDED_DIR=/gds_02/data/uc1/

ZIP_RELATIVE_PATH=${1:2}
# note: {1:2} above means take the first input and start with position 2.
# note: {1:2:7} above means take the first input, start with position 2, and go 7 characters.
# note: {1:2:1} above means take the first input, start with position 2, and go 1 character.


unzip -p $ZIP_RELATIVE_PATH > ${EXPANDED_DIR}${ZIP_RELATIVE_PATH}.txt
# note: the -p option extracts files to stdout
