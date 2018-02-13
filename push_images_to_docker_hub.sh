#!/usr/bin/env bash

echo $(TAG)

docker push ulyssejdv/webank-front-android:${TAG}

docker push ulyssejdv/webank-webapp:1.0:${TAG}

docker push ulyssejdv/data-access-service:${TAG}

docker push ulyssejdv/postgresql:${TAG}

docker push ulyssejdv/webank-hdfs-service:${TAG}

docker push ulyssejdv/data-access-service-2:${TAG}

docker push ulyssejdv/fail-over-soa:${TAG}