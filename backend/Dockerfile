# define base/parent docker image
FROM openjdk:17
LABEL maintainer="javaguides.net"
ADD target/backend-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]