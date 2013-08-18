#!/bin/bash

EXPANDED_DIR=/gds_02/test1/
ZIP_RELATIVE_PATH=${1:2}
# Copy directory structure
# find . -type d -exec mkdir ../copy/{} \;

# Run this script
# find . -type f -name "*.gz" -exec concat.sh {} \;

unzip -p $ZIP_RELATIVE_PATH > ${EXPANDED_DIR}${ZIP_RELATIVE_PATH}.txt 
