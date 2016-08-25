## IG Web API Java Sample
[![Build Status](https://travis-ci.org/IG-Group/ig-webapi-java-sample.svg?branch=master)](https://travis-ci.org/IG-Group/ig-webapi-java-sample)

### Overview
This repository contains two simple Java console sample applications which access the IG REST and Streaming APIs.

### Getting started
1) Set the destination IG environment in **environment.properties**.

2) Open a command line / shell prompt and run **mvn clean** to install the Lighstreamer client in ig-webapi-java-client/lib to your local maven repository.

3) Run **mvn clean install** to build the project.

4.a) Run basic console app:
```
    cd ig-webapi-java-sample-console
    java -jar target\ig-webapi-java-sample-console-<project version>.jar <username> <password> <api key>
```

4.b) Run UI based console app (increase window size to prevent scrolling)
```
    cd ig-webapi-java-sample-console-ui
    java -jar target\ig-webapi-java-sample-console-ui-<project version>.jar <username> <password> <api key> [<optional epic>]
```

