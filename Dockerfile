FROM openjdk:17

COPY build/libs/demo2-0.0.1-SNAPSHOT.jar demo2-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","demo2-0.0.1-SNAPSHOT.jar"]
