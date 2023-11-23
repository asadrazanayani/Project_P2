FROM openjdk:17.0.2-jdk
VOLUME /tmp
COPY target/*.jar pokepal.jar
ENTRYPOINT ["java","-jar","/pokepal.jar"]
