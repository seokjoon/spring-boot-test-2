FROM openjdk:17-alpine
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]


# gradle > tasks > build > bootJar
# docker build -t sp-boot/test:1 .
# docker run -d --name sp-boot-test -p 8600:8500 sp-boot/test:1