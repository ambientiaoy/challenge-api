# id-challenge

Application requirements:
- Java 11

## Description

This is a example application made with Spring boot to simulate simple API application.
Application has data stored in in-memory DB H2. Data will reset itself at every application restart.

To test interface you can run 

```
# Read all added Challenges
curl http://localhost:8080/challenges

# Get a single Challenge
curl http://localhost:8080/challenges/1

# Add new Challenge
curl -X POST -d '{"name": "challenge 3"}' -H 'Content-type:application/json' http://localhost:8080/challenges

# Edit a Challenge
curl -X PUT -d '{"name": "challenge 3, edited"}' -H 'Content-type:application/json' http://localhost:8080/challenges/3

# Delte a challenge
curl -X PUT -d '{"name": "challenge 3, edited"}' -H 'Content-type:application/json' http://localhost:8080/challenges/3
```

## Development

Development:
```
mvn clean spring-boot:run
```

## Production:
Application needs at least 128M memory to run possibly more in the future. 

Application is pre compiled and repository contains latest jar file to run in target directory.

Run application by taking target/challenge-api-***.jar to a desired location and run it

Command in QA environment
```
java $JAVA_OPTS -jar /path/to/challenge-api-xxxx.jar
```