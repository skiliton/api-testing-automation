# API Testing
API tests for Dropbox endpoints

## Technologies
Project is created with:
* Java SE 8

Project is tested with:
* JUnit 5
* REST-assured

## Requirements
To run this project, you need to install the folowing packages on your machine:
* Apache Maven version 3.3.9 or higher
* Java SE 8

## Setup & Running
```
$ cd ../api-testing-automation
$ mvn test -Dapi-test.dropbox.accessToken=<dropbox OAUTH access token>
```

## Invocation Example
```
$ cd ../api-testing-automation
$ mvn test -Dapi-test.dropbox.accessToken=iju6589jfdj982njsuhdfusdfe4$E32
```
