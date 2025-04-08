# Start from a base Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file
COPY target/*.jar app.jar

# Run the jar file
CMD ["java", "-jar", "app.jar"]
