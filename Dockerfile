# Stage 1: Build the application using Maven
FROM maven:3.6.3 AS maven
LABEL MAINTAINER="jayantakarmakar998@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app

# Stage 2: Run the application using Amazon Corretto 17
FROM amazoncorretto:17 AS runtime

ARG JAR_FILE=dealer-evaluation-backend-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the JAR file from the maven stage
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","dealer-evaluation-backend-0.0.1-SNAPSHOT.jar"]
