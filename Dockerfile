FROM openjdk:8
EXPOSE 8089
ADD http://192.168.1.8:8081/repository/maven-releases/com/esprit/examen/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]