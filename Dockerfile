FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR or classes
COPY build/libs/cdl-1.0-SNAPSHOT.jar /app/cdl.jar
# Or copy classes
# COPY build/classes/java/main /app/classes

# For simplicity, assume JAR, but since no JAR, use classes
COPY build/classes/java/main /app/classes
COPY antlr-4.13.1-complete.jar /app/antlr.jar

ENTRYPOINT ["java", "-cp", "/app/classes:/app/antlr.jar", "com.cdl.CDLCLI"]
