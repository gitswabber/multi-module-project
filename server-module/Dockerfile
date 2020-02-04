FROM openjdk:8-alpine
LABEL maintainer=doutorking@gmail.com
ADD /build/libs/server-module.jar app.jar

RUN ls -al

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]

#WORKDIR /app
#COPY build/libs libs/
#COPY src/main/resources resources/
#COPY build/classes classes/
#ENTRYPOINT ["java", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.swabber.api.ApiApplication"]
