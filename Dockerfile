FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD http://192.168.56.5:8081/repository/mavenreleases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
#ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]