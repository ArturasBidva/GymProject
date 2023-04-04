FROM ubuntu:20.04

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y gnupg2 wget

RUN curl -sSL https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | apt-key add - && echo "deb https://adoptopenjdk.jfrog.io/adoptopenjdk/deb focal main" | tee /etc/apt/sources.list.d/adoptopenjdk.list

RUN apt-get update && apt-get install -y adoptopenjdk-17-hotspot

RUN update-alternatives --set java /usr/lib/jvm/adoptopenjdk-17-hotspot-amd64/bin/java
RUN update-alternatives --set javac /usr/lib/jvm/adoptopenjdk-17-hotspot-amd64/bin/javac

WORKDIR /app

COPY demo.jar .

CMD ["java", "-jar", "demo.jar"]