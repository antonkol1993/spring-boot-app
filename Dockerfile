FROM eclipse-temurin:21

ARG VERSION

WORKDIR opt/app
COPY target/spring-boot-app-${VERSION}.jar /opt/app/app.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]