FROM maven:3.8.1-openjdk-17-slim

COPY target/*.jar customer.jar

EXPOSE 9087

ENTRYPOINT ["java", "-jar", "customer.jar"]