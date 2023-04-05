FROM adoptopenjdk:17-jdk-hotspot

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]