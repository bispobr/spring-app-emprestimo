FROM openjdk:21-ea-1-jdk-slim

WORKDIR /app

COPY target/emprestimo-0.0.1-SNAPSHOT.jar /app/emprestimo.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/emprestimo.jar"]