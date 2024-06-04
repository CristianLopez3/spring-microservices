FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8888

CMD ["java", "-jar", "app.jar"]