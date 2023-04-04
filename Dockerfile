FROM ubuntu:20.04

# Install dependencies
RUN apt-get update && \
    apt-get install -y wget gnupg2 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Add AdoptOpenJDK signing key
RUN wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | apt-key add -

# Add AdoptOpenJDK repository
RUN echo "deb https://adoptopenjdk.jfrog.io/adoptopenjdk/deb focal main" > /etc/apt/sources.list.d/adoptopenjdk.list && \
    apt-get update

# Install JDK 17.0.2
RUN apt-get install -y adoptopenjdk-17-hotspot

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/adoptopenjdk-17-hotspot-amd64

WORKDIR /app

COPY GymProject.jar .

CMD ["java", "-jar", "GymProject.jar"]