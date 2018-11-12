# mastermind

OVERVIEW
--------
This repository has one implemented microservice:
* **Codemaker Service** accepts Mastermind game creation and game guesses.

REQUIREMENTS
------------
* Java 8
* Docker 18

BUILD
-----
To build all projects: 
* On **codemaker** directory execute **./mvnw install**

To build each project individually and create docker images:
* On **codemaker** directory execute **./mvnw install dockerfile:build**

RUN
---
On **codemaker** directory execute **docker-compose up** to run all containers at the same time.

STOP RUN
--------
On **codemaker** directory execute **docker-compose down** to stop all container instances.

TEST
----
From your browser:
* Go to http://localhost:8080/swagger-ui.html to test **Codemaker Service**.

with all containers running.
