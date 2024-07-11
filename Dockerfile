# Stage 1: Build the application with Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# Debugging: Show Maven version and project structure
RUN mvn --version
RUN ls -la

# Run Maven build with verbose output (-X) for debugging
RUN mvn clean package -DskipTests -X

# Stage 2: Package the application in a clean Java runtime environment
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
