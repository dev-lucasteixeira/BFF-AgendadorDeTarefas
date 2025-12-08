FROM maven:3.9.11-eclipse-temurin-17-alpine AS BUILD
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=BUILD /app/target/*.jar app.jar
EXPOSE 8084
CMD ["java", "-jar", "/app/app.jar"]