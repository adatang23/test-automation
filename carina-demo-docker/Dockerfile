# Use OpenJDK 11 as the base image
FROM openjdk:11

# Set working directory inside the container
WORKDIR /app

# Copy the carina-demo project files into the container
COPY . /app

# Install Maven
RUN apt-get update && \
    apt-get install -y maven



# Set the command to run tests automatically once the container starts \
CMD ["mvn", "clean", "test", "-Dsuite=api"]