# capitole-consulting-price-service
This project consists of the development of a technical test for the company Capitole Consulting by [Jonathan Giovanni Hernández](https://www.linkedin.com/in/jonathan-giovanni-hern%C3%A1ndez-v%C3%A1squez/). The objective of the test is the creation of a microservice in Java using the Spring Boot framework.

The main function of the microservice is to return the information of the price data of a product, evaluating the application date, the product identifier and the brand identifier.

For this, it must evaluate that the application date is within the price start-end time range, and if two or more prices agree with this requirement, the priority level with higher precedence must be evaluated.

To meet this goal, certain requirements were established, such as the need to decouple each domain and application layer in infrastructure. For this, i was decided to use the hexagonal architecture.


# Used technology
- Java 17
- Spring Boot 3
- Maven
- H2 in memory database
- Jpa to handle database persistence
- Documentation by Swagger3
- Hexagonal architecture

# How to run the microservice
To run the microservice, you need to have Java 17 and Maven installed on your local machine. Then just clone the repository and run the following command in terminal:

```
mvn spring-boot:run
```

This will start the local server, and you will be able to access the documentation microservice via the [http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html)

# Test cases

You can run the tests, for the application and infrastructure layer.

For the application layer tests, the response expected by the adapter implementation is being mocked.

For the infrastructure layer tests, the entire spring context is raised which has a bootstrap configuration that reads the CSV file with the data, then inserts it.

so each test case will make use of the data previously saved in the in-memory database.
