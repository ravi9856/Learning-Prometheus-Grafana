FROM openjdk:17-jdk-alpine
MAINTAINER Ravindra
COPY target/Learning-Springboot-0.0.1-SNAPSHOT.jar Learning-Springboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Learning-Springboot-0.0.1-SNAPSHOT.jar"]