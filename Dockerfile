FROM adoptopenjdk:17.0.6_10-jre-hotspot

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]