FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

CMD ["/bin/bash", "-c", "/wait-for-it.sh selenoid:4444 --timeout=60 -- mvn test"]