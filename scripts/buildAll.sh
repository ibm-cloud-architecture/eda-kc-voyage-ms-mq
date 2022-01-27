#!/bin/bash
scriptDir=$(dirname $0)

IMAGE_NAME=quay.io/ibmcase/eda-kc-voyage-ms-mq
./mvnw clean package -DskipTests -Dquarkus.container-image.build=false -Dquarkus.container-image.deploy=false
docker build -f ${scriptDir}/../src/main/docker/Dockerfile.jvm -t ${IMAGE_NAME} .
docker push ${IMAGE_NAME}
