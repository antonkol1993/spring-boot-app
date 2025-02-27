
# Используем официальный образ OpenJDK 17
FROM openjdk:21-jdk

ARG VERSION
# Указываем рабочую директорию
WORKDIR opt/app

# Копируем JAR-файл (замени `your-app.jar` на реальное имя)
COPY target/spring-boot-app-${VERSION}.jar /opt/app/app.jar

# Указываем переменные окружения для конфигурации
ENV SERVER_PORT=8080
ENV MYSQL_HOST=mysql

# Открываем порт для приложения
EXPOSE 8080

# Команда для запуска Spring Boot приложения
ENTRYPOINT ["java", "-jar", "app.jar"]