FROM maven:3.6.0-jdk-11-slim
COPY ./ /opt/registration-and-discovery-service
WORKDIR /opt/registration-and-discovery-service/
RUN mvn package
EXPOSE 8761
ENTRYPOINT [ "java" , "-jar", "./target/registration-and-discovery-service-0.0.1-SNAPSHOT.jar" ]