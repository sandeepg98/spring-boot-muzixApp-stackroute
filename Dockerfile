FROM openjdk:11
ADD target/muzixapp-0.0.1-SNAPSHOT.jar muzixapp.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","muzixapp.jar"]