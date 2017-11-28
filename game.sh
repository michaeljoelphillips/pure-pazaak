#!/bin/sh

BASE=`dirname $0`
java -jar -Djava.library.path="$BASE/lib/" "$BASE/pure-pazaak-0.1.jar" &
