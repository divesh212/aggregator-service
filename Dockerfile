FROM openjdk:8

ADD target/aggregator-service.jar aggregator-service.jar

EXPOSE 8093

ENTRYPOINT ["java","-jar","aggregator-service.jar"]