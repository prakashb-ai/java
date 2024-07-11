# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Debug step to list the contents of /app/target
RUN ls -l /app/target

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
# Correct the path to the generated JAR file
COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot application when the container starts
ENTRYPOINT ["java","-jar","/app/app.jar"]
