FROM maven:3.6.0-jdk-11-slim
COPY ./ /opt/users-microservice
WORKDIR /opt/users-microservice/
RUN mvn package
EXPOSE 8080
ENTRYPOINT [ "java" , "-jar", "./target/users-microservice-0.0.1-SNAPSHOT.jar" ]