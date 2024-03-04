FROM openjdk:17-jdk

WORKDIR /app

COPY event-paiger-gw-0.0.1-SNAPSHOT.jar /app/event-paiger-gw-0.0.1-SNAPSHOT.jar

EXPOSE 8222

CMD ["java", "-jar", "event-paiger-gw-0.0.1-SNAPSHOT.jar"]
