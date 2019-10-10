#!/bin/sh

cd "$(dirname "$0")"

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'

alias run="java -cp bin:lib/json.jar unsw.venues.VenueHireSystem"

test() {
  echo Testing "$1" - "$2"
  RESULT=$(run < tests/$1 | diff - tests/$2)
  if [ $? -ne 0 ]
  then
    echo ${RED}'  "'$1'" did not match "'$2'"'${NC}
    # echo "$RESULT" # | head -n 10
  else
    echo ${GREEN}'  Success'${NC}
  fi
}

##### GOOOOOOO ######

echo Building files...
./build.sh
echo

test ../sample_input.json ../sample_output.json

test input1.commented.json output1.json
test input2.commented.json output2.json
test input3.commented.json output3.json
test input4.commented.json output4.json
test input5.commented.json output5.json
test input6.commented.json output6.json

echo
tests/decommentify.sh
echo

test input1.json output1.json
test input2.json output2.json
test input3.json output3.json
test input4.json output4.json
test input5.json output5.json
test input6.json output6.json

echo "\nAll tests completed!"

