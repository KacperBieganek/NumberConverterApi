#!/bin/bash

if [ ! -f target/RunnableNumberConverterApi.jar ]; then
    mvn clean install
fi

java -jar target/RunnableNumberConverterApi.jar &