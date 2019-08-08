FROM openjdk:8-jre-slim

WORKDIR /usr/share/tag

ADD target/pwneddocker.jar pwneddocker.jar
ADD target/pwneddocker-tests.jar pwneddocker-tests.jar
ADD target/libs libs
ADD src/main/resources/app.properties src/main/resources/app.properties
ADD testng.xml testng.xml

#Entry Point running testng.xml
ENTRYPOINT java -cp pwneddocker.jar:pwneddocker-tests.jar:libs/* -DseleniumHubHost=$SELENIUM_HUB org.testng.TestNG testng.xml