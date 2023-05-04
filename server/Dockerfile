FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /app
WORKDIR /app
COPY . /app
EXPOSE 5000
CMD ["java", "-jar", "target/MonopolyBankServer-1.0.0.jar"]