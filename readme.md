### Event Paiger Gateway

#### Description
Event Paiger Gateway is a gateway service built using Spring Cloud Gateway.

#### Prerequisites
- Java 17
- Maven

#### Dependencies
- [Spring Boot Starter Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Spring Cloud Config Starter](https://spring.io/projects/spring-cloud)
- [Spring Cloud Gateway Starter](https://spring.io/guides/gs/gateway/)
- [Spring Cloud Netflix Eureka Client Starter](https://spring.io/guides/gs/service-registration-and-discovery/)
- [Spring Boot Starter Test](https://spring.io/guides/gs/testing-web/)

#### Usage
1. Clone the repository.
2. Build the project using Maven.
3. Run the application.

#### Configuration
- Java version: 17
- Spring Cloud version: 2023.0.0

#### Build
This project is built using Maven. To build the project, run the following command:
```shell
mvn clean install
```

#### Dockerize application

To create an image of the application, navigate to the project directory containing the Dockerfile and use the following command:
```shell
docker build -t event-paiger-gateway-image .
```
Then you can run the container from this image using command:
```shell
docker compose up
```
