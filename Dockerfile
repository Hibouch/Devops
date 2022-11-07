FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD ADD http://192.168.2.138:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]