#!/bin/bash

# PRACTICE SCRIPT

globVar="global"

function aFunc 
 {
   localVar="local"
   echo $localVar
   localVar="changed"
   echo $localVar
   globVar="global is changed"
 }

echo $globVar

aFunc

echo $globVar

