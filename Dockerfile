FROM eclipse-temurin:17-alpine
WORKDIR .
COPY target/Card-service-0.0.1-SNAPSHOT.jar Card-service.jar
ENTRYPOINT ["java","-jar","Card-service.jar"]