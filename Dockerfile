FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Allure output сохранится в volume
VOLUME /app/allure-results

CMD ["mvn", "clean", "test"]