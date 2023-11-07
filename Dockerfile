FROM openjdk:17-alpine
MAINTAINER NICO
COPY target/alertsn7_backend-0.0.1-SNAPSHOT.jar  alertsn7_backend-app.jar
ENTRYPOINT ["java","-jar","/alertsn7_backend-app.jar"]
EXPOSE 8080