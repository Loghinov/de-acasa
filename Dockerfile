FROM openjdk:21-jdk
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} de-acasa-0.1.jar
ENTRYPOINT ["java", "-jar", "de-acasa-0.1.jar"]