FROM openjdk:8-jdk-alpine
ADD target/binarycalculator-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
RUN chmod +x /wait
CMD /wait && java -jar binarycalculator-0.0.1-SNAPSHOT.jar