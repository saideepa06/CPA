# CPA

## Credit card processing Application

Its a full stack application for a credit card provider. It allows you to add new valid credit card accounts and enable us to view the all the valid credit cards.

## Description

### Rest Endpoints
*	"Add" will create a new credit card for a given name, card number, and limit
*	Card numbers is validated using Luhn 10
*	New cards start with a £0 balance
*	Cards not compatible with Luhn 10, return an error
*	"Get all" returns all cards in the system

## Validation Rules

*	All input and output will be JSON
*	Credit card numbers may vary in length, up to 19 characters
*	Credit card numbers will always be numeric

## Technical specs

*	RESTful API using Spring Boot and Maven for dependency management
*	Endpoints use appropriate HTTP Methods and defined payloads with return codes and response structures
*	Junit test cases are written with Mockito
*	In-memory DB h2 to store the information while the API is running, so that it can store the credit card information

## API Swagger Documentation

*  http://localhost:8080/swagger-ui.html

## Postman requests and examples provided(Test API's)

* Location: ProjectDir\src\main\resources\CPA.postman_collection.json

## Getting Started

To install CPA application, run the following commands:

```bash
git clone https://github.com/saideepa06/CPA.git cpa
cd cpa
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server, run:

```bash
./mvn spring-boot:run
```

To run the client, cd into the `app` folder and run:

```bash
npm && npm start
```
Client Home Page: http://localhost:3000/



