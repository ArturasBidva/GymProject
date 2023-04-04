FROM adoptopenjdk:17-jre-hotspot

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]