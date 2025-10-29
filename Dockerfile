FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/cdl-1.0-SNAPSHOT.jar /app/cdl.jar

ENTRYPOINT ["java", "-jar", "/app/cdl.jar"]
