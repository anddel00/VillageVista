FROM tomcat:9.0-jdk11-temurin
COPY VillageVista-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/VillageVista.war
EXPOSE 8080