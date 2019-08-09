# PwnedTest
Simple test to verify if the email ID is pwned or not

## Tech/framework used
Project is created with:
- Java 1.8
- Maven     					
- Selenium 3.141.59
- TestNG 6.14.3
- ReportNG 1.1.4
- Docker

## Pre-requisite
As a pre-requisite, please install the following:
- Java 1.8 or higher
- Maven
- Docker

## Setup
#### There are two ways in which we can run the project as described below
Method 1: Creating Docker image using Maven
  1. Download or clone this project in your machine
  2. Run the maven command to build the docker image as given below using Maven CLI
  ```maven
  $ mvn clean package -DskipTests
  ```
  3. Execute the docker-compose.yml file using the below docker command using Docker CLI
  ```docker
  $ docker-compose up -d
  ```
  4. Above command will setup all the necessary items requried for our selenium test
  5. Run the docker run command to execute our project
   ```docker
  $ docker run -e SELENIUM_HUB=<Host IP> vidhyaseethapathy/pwnedtest:test
  ```
  6. The Selenium program runs in the docker selenium grid and the output is displayed in the docker console

Method 2: Using Docker image from Docker Hub
The respective docker image is hosted in Docker Hub server. 
  1. Just by running the docker-composer.yml file, it sets up the infrastructure for the Test suite to run successfully.
  2. Run the following commands using Docker CLI
  ```docker
  $ docker-compose up -d
  $ docker run -e SELENIUM_HUB=<Host IP> vidhyaseethapathy/pwnedtest:test
  ```
  ## Sample output
  ```docker
$ docker run -e SELENIUM_HUB=192.168.99.100 vidhyaseethapathy/pwnedtest:test
Aug 09, 2019 9:11:02 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
Email ID test@something.com is pwned!!
Email ID yyy1234@something.com is not pwned!!

===============================================
Pwned Application Test Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
 ```
