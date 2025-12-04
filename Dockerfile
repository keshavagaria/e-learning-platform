FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
ADD target/e-learning-app.jar e-learning-app.jar
ENTRYPOINT [ "java","-jar","/e-learning-app.jar" ]
