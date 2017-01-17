## IG Web API Java Sample
[![Build Status](https://travis-ci.org/IG-Group/ig-webapi-java-sample.svg?branch=master)](https://travis-ci.org/IG-Group/ig-webapi-java-sample)

### Overview
This repository contains two simple Java console sample applications which access the IG REST and Streaming APIs:

1) **ig-webapi-java-sample-console**: A basic console based application which logs in via /session V2, retrieves a list of position, watchlist, subscribes to lightstreamer and create a position.

2) **ig-webapi-java-sample-console-ui**: A UI based console application (please increase the windows size to prevent scrolling) which shows a graph with the current market price and allows user to place a trade. Authentication is via /session V3.

### Getting started
1) Set the destination IG environment in **environment.properties**.

2) Open a command line / shell prompt and run **mvn clean** to install the Lighstreamer client in ig-webapi-java-client/lib to your local maven repository.

3) Run **mvn clean install** to build the project.

4.a) Run basic console app:
```
    cd ig-webapi-java-sample-console
    java -jar target\ig-webapi-java-sample-console-<project version>.jar <username> <password> <api key>
```

4.b) Run UI based console app
```
    cd ig-webapi-java-sample-console-ui
    java -jar target\ig-webapi-java-sample-console-ui-<project version>.jar <username> <password> <api key> [<optional epic>]
```

To attach a remote debugger:
    java -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y -jar target\ig-webapi-java-sample-console...
