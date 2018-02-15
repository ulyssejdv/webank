#!/usr/bin/env bash


docker pull ulyssejdv/webank-front-android:${TAG}

docker pull ulyssejdv/webank-webapp:${TAG}

docker pull ulyssejdv/data-access-service:${TAG}

docker pull ulyssejdv/postgresql:${TAG}

docker pull ulyssejdv/webank-hdfs-service:${TAG}

docker pull ulyssejdv/data-access-service-2:${TAG}

docker pull ulyssejdv/fail-over-soa:${TAG}
