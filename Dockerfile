# ---- builder ----
FROM gradle:8.10.2-jdk21 AS builder
WORKDIR /app
COPY gradlew ./
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
RUN chmod +x gradlew
RUN ./gradlew --no-daemon dependencies || true
COPY src src
RUN ./gradlew --no-daemon clean bootJar -x test

# ---- runtime ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport"
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
