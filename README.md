# Sakila API Repository
This Git repository contains the source code and database diagram for the Sakila API REST and Soap API, both implemented in Java using Maven and Tomcat.

##  Table of contents
* [Requirements](#Requirements)
* [Installation](#Installation)
* [REST_API](#REST_API)
* [SOAP_API](#SOAP_API)
* [Database](#database)
* [Technologies](#technologies)

### Requirements:
- JDK 11 or higher
- Apache Tomcat 9 or higher
- Maven 3 or higher
- Sakila database

### 🔧 Installation and Setup

To run this project locally, you will need to have Maven and Tomcat installed on your machine.

1. Clone the repository to your local machine.
2. Set up the database by running the `sakila-db.sql` script in your MySQL database.
3. Update the `db.properties` file with your MySQL database connection details.
4. Navigate to the project directory and run the command `mvn clean package` to build the project.
5. Deploy the `war` file to your Tomcat server.


## REST_API

The Sakila REST API provides access to the data in the Sakila database using a REST API interface. Developers can use common HTTP methods such as GET, PUT, POST, and DELETE to retrieve, create, update, and delete data in the database.
each table contains a request for getting a specific element by id, the response will return the Location of a newly created element at the Header of the Response, and the List of Links that can be used in that table in the Response Body.
### Endpoints
The following endpoints are available for the REST API:
- `GET /films/getAllFilms`: Returns a list of all films in the Sakila database.
- `GET /films/{id}`:  Returns details for a specific film identified by its ID.
- `GET /films/getFilmName` :  Returns details for a specific film identified by Part from its name.
- `GET /films/{id}/getFilmRenter`:Return List of Rent Transaction created on this film.
- `GET /films/{id}/checkExistence`: Return Boolean message based on the existence of this film .
- `POST /films/newFilm`:  Return Boolean message .
- `POST /films/rentFilm`:Return Boolean message based on the uniqueness of all entered and their existence.
- `POST /films/returnFilm`:Return Boolean message based on the correctness of all entered.
- `GET /films/{id}/getQuantity` : Return the quantity of entered film is in the stock.
- `GET /customers/{id}`:Returns details for a specific customer identified by its ID.
- `GET /customers/getBalanceInDate`: Return the amount of money that that customer needs to pay before trying to make any new rent process.
- `GET /customers/{id}/getRentalHistory`:Return List of all rents that this customer  made before.
- `GET /customers/{id}/getPaymentHistory`: Return List of all payments that this customer  made before.
- `GET /customers/newCustomer`: Return Boolean message .
- `DELETE /customers/{id}`:Return  Boolean message.
- `GET /staffs/{id}:`Returns details for a specific staff member identified by its ID.
- `DELETE /staffs/{id}`:Return  Boolean message.
- `GET /staffs/{id}/getRental`:Return List of all rents that this staff created before .
- `GET /staffs/getALlStaff?start=&limit=`: Return List of staff members starting from a specific page and limited by the number of members.
- `POST /staffs/newStaff`:Return  Boolean message.
- `GET /actors/{id}`: Returns details for a specific actor identified by its ID.
- `GET /actors/{id}/getCategories` :return the categories that this actor acts in films under this categorization.
- `GET /actors/{id}/getFilms`:Return List of all films  that this actor acts in before.
- `PUT /actors`:return Boolean message.
- `POST /actors`:this use to add actor to actor table returns boolean.
- `GET /categories/{id}/films`:Return List of Films under this category.
- `GET /categories/{id}`:Returns details for a specific category identified by its ID.
- `POST /categories`: Return List of all categories.
- `PUT /categories`:update category name with specific ID.
- `GEt /stores/{id}/address`:Return the Address of specific store.
- `GET /stores/{id}/manager`:Return Specific Store Manager.
- `PUT /stores`:update specific store Manager.
### Usage
To use the Sakila REST API, you can send HTTP requests to the endpoints using a tool such as `curl`, or you can use a client library for your preferred programming language.

## SOAP_API

The Sakila SOAP API provides access to the Sakila database using a SOAP-based web service. This API supports CRUD operations on films, staff, customer, actor, store and categories in the Sakila database.

### Endpoints

The following endpoints are available for the SOAP API:
- `/ws/films`: Provides CRUD operations for films in the Sakila database and other operations.
- `/ws/categories`: Provides CRUD operations for categories in the Sakila database and other operations.
- `/ws/staffs`: Provides CRUD operations for staffs in the Sakila database and other operations.
- `/ws/stores`: Provides CRUD operations for stores in the Sakila database and other operations.
- `/ws/customers`: Provides CRUD operations for customers in the Sakila database and other operations.
- `/ws/actors`: Provides CRUD operations for actors in the Sakila database and other operations.
### Usage
To use the Sakila SOAP API, you can generate client code for your preferred programming language using a tool such as `wsdl2java` (for Java), or you can use a SOAP client library for your preferred programming language.

### Database Diagram
Below is the database diagram for the Sakila sample database, which this project is built upon:
![Sakila database diagram](https://drive.google.com/uc?id=1n2PXMFmjFlleXRTx6GKl1ijwBsgQ5vqY)

This diagram shows the schema of the Sakila DVD Rental database. The database contains tables for customers, films, rentals, and other related information.
## ⚙ Technologies
* Maven
* Tomcat
* MySql
* Jersey
* Lombok
* Jakarta XML Web Services API
* Hibernate Core
* Jakarta Servlet API
* MapStruct
* Validation API
* Hibernate Validator

## 📖 Resources

- [Sakila database documentation](https://dev.mysql.com/doc/sakila/en/)
- [Sakila REST API documentation](https://documenter.getpostman.com/view/26734941/2s93Y3tfXU)
- [Sakila SOAP API documentation](https://documenter.getpostman.com/view/26734941/2s93Y2TN25)
