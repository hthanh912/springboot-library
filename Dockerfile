# Start with the base image
FROM openjdk:17-jdk-alpine

# Install Redis
RUN apk update && apk add redis

# Expose Redis port
EXPOSE 6379

# Expose the application port
EXPOSE 8080

# ARG and COPY for the Spring Boot application
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar

# Start Redis in the background and the Spring app
CMD ["sh", "-c", "redis-server --daemonize yes && java -jar application.jar"]