FROM openjdk:8-jre-alpine
ADD ./target/Family-0.0.1-SNAPSHOT.jar Family-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "Family-0.0.1-SNAPSHOT.jar"]