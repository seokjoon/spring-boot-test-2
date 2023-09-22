#FROM openjdk:17
#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-alpine
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]


# gradle > tasks > build > bootJar
# docker build -t sp-boot/test:1 ./doc/docker
# docker run -d --name sp-boot-test -p 8600:8500 sp-boot/test:1