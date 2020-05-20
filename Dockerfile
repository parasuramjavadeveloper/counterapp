FROM openjdk:8
EXPOSE 8054
ADD target/apipoc-0.0.1-SNAPSHOT.jar  apipoc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/apipoc-0.0.1-SNAPSHOT.jar"]
