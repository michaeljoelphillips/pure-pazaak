#!/bin/sh

BASE=./target/pure-pazaak-0.1-release/pure-pazaak-0.1/
java -jar -Djava.library.path="$BASE/lib/" "$BASE/pure-pazaak-0.1.jar"
