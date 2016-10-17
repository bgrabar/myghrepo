#!/bin/bash


# PRACTICE SCRIPT

VAR="global variable"

function myFunc {

local VAR="local variable"
echo $VAR
}

echo $VAR

myFunc

echo $VAR
