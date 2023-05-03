FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /app
WORKDIR /app
COPY . /app
EXPOSE 5000
CMD ["java", "-jar", "target/MonopolyBankAppServer-0.0.1-SNAPSHOT.jar"]