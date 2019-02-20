FROM maven:3.6.0-jdk-11-slim
COPY ./ /opt/config-service
WORKDIR /opt/config-service/
RUN mvn package
EXPOSE 8080
ENTRYPOINT [ "java" , "-jar", "./target/config-service-0.0.1-SNAPSHOT.jar" ]