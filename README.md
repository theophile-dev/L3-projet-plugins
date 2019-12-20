# Project Courrier

Authors : Théophile COSSE and Florian COVEY

## The Project 
Plugins is a simple text editor software written in JAVA that allow user to install plugin at runtime.

### UML Diagram
![Image](PLUGINS/uml.jpg)

## How To
### Installation
1. Install maven, the method will depend on your distribution

For Debian/Ubuntu

```
# apt install maven
```

2. Get the project

```
$ git clone git@gitlab-etu.fil.univ-lille1.fr:cosse/covey-cosse-coo-projet-plugins.git
```

3. Make the executable

```
$ mvn package
```
4. Execute the jar file

```
$ java -jar ./plugins/target/*.jar
```

### Generate Javadoc
```
$ mvn javadoc:javadoc
```
The Javadoc generated can be found in /plugins/target/docs/index.html

### Key aspect of the project

The test of the file checker are done using FILE form java util to create and deletes file, then we use a class that will listen to the file checker and count the number of file

