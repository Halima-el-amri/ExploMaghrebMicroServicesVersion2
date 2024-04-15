FROM maven:3.8.1-openjdk-17-slim

COPY target/*.jar booking.jar

EXPOSE 9088

ENTRYPOINT ["java", "-jar", "booking.jar"]