FROM openjdk:11-jdk-slim
WORKDIR /app
COPY VillageVista-1.0-SNAPSHOT.war /app/app.war
EXPOSE 8080
CMD ["java", "-jar", "/app/app.war"]