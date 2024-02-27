# Simple kafka app with Spring Boot

## Description

- Send data to Kafka topic from REST API
- Consume the data from the Kafka topic and print it to the console.
- The project is a Spring Boot application that uses Kafka to send and receive messages.
- The project uses Docker to run Kafka and Zookeeper.
- The project uses Docker Compose to run Kafka and Zookeeper.
- The project uses Lombok to reduce boilerplate code.

## For testing locally
- Install Docker if you don't have it
- Run the Kafka and Zookeeper using Docker Compose
  ```docker-compose up -d```
- Run the Spring Boot application
- Send a POST ``` localhost:8080/message ``` with the following body

```json
{
  "id": 1,
  "firstName": "Test_FirstName",
  "lastName": "Test_LastNAme"
}
```
### Next option
Send a GET ``` localhost:8080/message ```