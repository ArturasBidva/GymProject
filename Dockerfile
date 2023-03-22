FROM adoptopenjdk:17.0.2_12-jre-hotspot

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]