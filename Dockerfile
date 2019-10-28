FROM openjdk:8-jdk-alpine
EXPOSE 80
ADD /build/libs/kotlin-clean-sample-1.0-SNAPSHOT.jar kotlin-clean-sample.jar
ENTRYPOINT ["java", "-jar", "kotlin-clean-sample.jar"]