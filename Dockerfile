# -----------
# Build stage
FROM maven:3.6.3-jdk-8 as build

WORKDIR /app

# Prepare maven
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src

# Package the application
RUN mvn package -DskipTests

# ---------
# Run stage
FROM openjdk:8-jre-alpine
COPY --from=build /app/target/UgaBot-1.0-SNAPSHOT.jar /app/UgaBot.jar

ENTRYPOINT ["java", "-jar", "/app/UgaBot.jar"]