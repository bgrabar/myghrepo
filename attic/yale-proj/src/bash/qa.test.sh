#!/bin/bash

# To run, run this command:   find -type d -exec ../qa.test.sh {} \;

EXPANDED_DIR=/gds_02/data/buckets-uc1/
RELATIVE_DIR=${1}

#echo -e "\nFIND passed this dir to qa.test.sh: ${RELATIVE_DIR}"
#echo -e "IF will test this dir: ${EXPANDED_DIR}${RELATIVE_DIR:2}"

if [ -e ${EXPANDED_DIR}${RELATIVE_DIR:2}/*.txt ]; then
    #echo -e "\nentered the first if statement"

    if [ -d ${EXPANDED_DIR}${RELATIVE_DIR:2}/*.txt ]; then
        #echo -e "\nEntered the 2nd if statment at ${EXPANDED_DIR}${RELATIVE_DIR:2}"

        cd `find ${EXPANDED_DIR}${RELATIVE_DIR:2} -type d -name *.zip.txt`

        WC1=`wc --w *.txt`
        #echo "WC1 is $WC1"

        WC1=${WC1%% *}
        #echo "WC1 is $WC1"

        #change dir to the split files

        cd /gds_02/data/split.of.uc1/pairtree_root/${RELATIVE_DIR:28}
        #echo "The dir was changed to `pwd`"

        WC2=0
        #echo "WC2 is $WC2"

        for i in `ls`; do
           #echo "Entered the for statements."

           WC2_TEMP=`wc --w $i`
           WC2=$((${WC2_TEMP%% *} + $WC2))
           #echo "WC2 now equals $WC2"
    
        done


        if [[ $WC1 -eq $WC2 ]]; then
           echo -e "all is good \n"
        fi


        if [[ $WC1 -ne $WC2 ]]; then
           echo -e "wc does not match at ${RELATIVE_DIR:2} \n"
        fi
    
    fi
    
fi
