# Use OpenJDK 21 slim as base image
FROM openjdk:21-slim

# Set working directory
WORKDIR /app

# Install JavaFX dependencies
RUN apt-get update && apt-get install -y \
    libgl1-mesa-glx \
    libgtk-3-0 \
    libcanberra-gtk-module \
    libasound2 \
    && rm -rf /var/lib/apt/lists/*

# Copy the JavaFX application JAR file
COPY LibraryManagementSystem.jar .

# Command to run the application
CMD ["java", "-jar", "LibraryManagementSystem.jar"]
