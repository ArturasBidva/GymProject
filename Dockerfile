FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]