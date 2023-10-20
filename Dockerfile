FROM openjdk:17-alpine
MAINTAINER NICO
EXPOSE 8080
COPY target/alertsn7_backend-0.0.1-SNAPSHOT.jar  alertsn7_backend-app.jar
ENTRYPOINT ["java","-jar","/alertsn7_backend-app.jar"]