#!/bin/bash

kill $(ps aux | grep 'RunnableNumberConverterApi' | awk '{print $2}')