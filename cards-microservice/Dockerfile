FROM maven:3.6.0-jdk-11-slim
COPY ./ /opt/cards-microservice
WORKDIR /opt/cards-microservice/
RUN mvn package
EXPOSE 8080
ENTRYPOINT [ "java" , "-jar", "./target/cards-microservice-0.0.1-SNAPSHOT.jar" ]