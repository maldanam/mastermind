# mastermind

OVERVIEW
--------
This repository has two implemented microservices:
* **Codemaker Service** accepts Mastermind game creation and game guesses.
* **Board Service** shows Mastermind game boards current status.

REQUIREMENTS
------------
* Java 8
* Docker 18

BUILD
-----
To build all projects: 
* On **mastermind** directory execute **./mvnw install**

To build each project individually and create docker images:
* On **codemaker** directory execute **./mvnw install dockerfile:build**
* On **board** directory execute **./mvnw install dockerfile:build**

RUN
---
On **mastermind** directory execute **docker-compose up** to run all containers at the same time.

STOP RUN
--------
On **mastermind** directory execute **docker-compose down** to stop all container instances.

TEST
----
From your browser:
* Go to http://localhost:8080/swagger-ui.html to test **Codemaker Service**.
* Go to http://localhost:8081/swagger-ui.html to test **Board Service**.

with all containers running.
