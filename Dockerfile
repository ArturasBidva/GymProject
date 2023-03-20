FROM openjdk:11-jre-slim

WORKDIR /app

COPY GymProject.jar /app/GymProject.jar

CMD ["java", "-jar", "GymProject.jar"]