FROM maven:3.6.0-jdk-11-slim
COPY ./ /opt/api-gateway
WORKDIR /opt/api-gateway/
RUN mvn package
EXPOSE 80 80
ENTRYPOINT [ "java" , "-jar", "./target/api-gateway-0.0.1-SNAPSHOT.jar" ]