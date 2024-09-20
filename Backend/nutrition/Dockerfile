FROM openjdk:21-jdk
WORKDIR /app

# WAIT DATABASE OPEN
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# RUN SPRING BOOT
COPY target/nutrition_application.jar /app
CMD ["/wait-for-it.sh", "db:3306", "--", "java", "-jar", "nutrition_application.jar"]
