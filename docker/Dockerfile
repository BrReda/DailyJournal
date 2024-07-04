# Stage 1: Build the application
FROM gradle:8.8.0-jdk17-alpine AS build

# Set the working directory inside the container
WORKDIR /home/gradle/project

# Copy the Gradle wrapper and build files
COPY build.gradle settings.gradle gradlew* ./
COPY gradle ./gradle

# Download Gradle dependencies
RUN chmod +x ./gradlew

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN ./gradlew build --no-daemon

# Stage 2: Create a lightweight image for running the application
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /home/gradle/project/build/libs/*.jar /app/daily-journal.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/daily-journal.jar"]
