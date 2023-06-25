FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY GymProject.jar .

CMD ["java", "-jar", "GymProject.jar"]