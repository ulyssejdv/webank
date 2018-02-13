# data-access-service

FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

EXPOSE 25010

ENTRYPOINT ["java","-Dserver.port=25010","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]