FROM openjdk

WORKDIR /app
COPY target/MyBatis-0.0.1-SNAPSHOT.jar /app
CMD ["java","-jar","/app/MyBatis-0.0.1-SNAPSHOT.jar"]