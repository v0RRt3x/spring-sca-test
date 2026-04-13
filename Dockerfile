# ---- Stage 1: Build ----
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
# Cache dependencies in a separate layer
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

# ---- Stage 2: Runtime ----
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app
COPY --from=build /app/target/spring-sca-test-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
