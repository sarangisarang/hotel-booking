FROM openjdk:17-jdk-alpine
MAINTAINER hotels.com
COPY target/hotel-0.0.1-SNAPSHOT.jar hotel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hotel-0.0.1-SNAPSHOT.jar"]
