## IG Web API Java Sample
[![Build Status](https://travis-ci.org/IG-Group/ig-webapi-java-sample.svg?branch=master)](https://travis-ci.org/IG-Group/ig-webapi-java-sample)

### Overview
This repository contains a Java sample application to access the IG REST and Streaming APIs.

### Getting started
1) Set the destination IG environment in **environment.properties**.

2) Open a command line / shell prompt and run **mvn clean** to install the Lighstreamer client in ig-webapi-java-client/lib to your local maven repository.

3) Run **mvn clean install** to build the project.

4) Run the executable jar file:
```
    cd ig-webapi-java-sample-springboot
    java -jar target\ig-webapi-java-sample-springboot-<project version>.jar <username> <password> <api key>
```
