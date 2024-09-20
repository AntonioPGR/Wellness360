FROM openjdk:21-jdk
WORKDIR /app

# WAIT DATABASE OPEN
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# RUN SPRING BOOT
ARG JAR_FILE=nutrition_application.jar
COPY target/${JAR_FILE} /app
CMD ["/wait-for-it.sh", "db:3306", "--", "java", "-jar", "${JAR_FILE}"]
