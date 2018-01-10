#!/usr/bin/env bash
docker stop docker_app_1 && mvn clean install && docker start docker_app_1
