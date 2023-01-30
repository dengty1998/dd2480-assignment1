# DECIDE

**Warning: This is a university project of no use.**

This is an implementation of DECIDE function, described in [the specification](https://canvas.kth.se/courses/37918/files/6157550/download).


## Installing Prerequisites

To build this program you need to have [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) (or later) and [Maven 3.6](https://maven.apache.org/download.cgi) (or later).

### Linux

If you are using system with `apt` package manager (e.g. Ubuntu, Debian), you can install JDK and Maven using:

```
apt install default-jdk maven
```

If you are using `pacman` (e.g. Arch), you can install the prerequisites by:

```
pacman -S jdk-openjdk maven
```

### Windows

On Windows you can download [JDK](https://www.oracle.com/java/technologies/downloads/#java8-windows) and [Maven](https://dlcdn.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.zip) installers from the official websites. Once they are installed, you will need to add corresponding `\bin` folders to your PATH: more detailed instruction is [available](https://maven.apache.org/install.html#windows-tips) on Maven's site.


## Building

The used Maven configuration can be found in `pom.xml`. JUnit is used for testing. To create an executable in `target/assignment-1.0-SNAPSHOT.jar` you can run:

```
mvn clean verify
```

This command also runs all the tests and checks configured for the code.


## Code Style

The code style is enforced by the build system. The file describing the formatting rules is `format.xml`, it is in the Eclipse file-format. The code style is based on [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) with indentation by 4 spaces instead of 2. You can use Maven to automatically apply the code style by running:

```
mvn spotless:apply
```


## Contributing

You can choose any open task on the project's GitHub Issues [page](https://github.com/DD2480-group14/Assignment-1/issues) and create a branch named `issues/#` where # is the number of the issue you want to work on. After committing to the branch to the point where you feel like the work is done, you can create a pull request. All pull requests need to pass all existing project tests, as well as comply to the project's code style. Additionally, before being merged a pull request needs to be reviewed by someone else.


## Statement of Contributions

### Aleksey Veresov

- Set up Maven
- Refactored HelperFunction into Point
- Refactored Parameters and Input
- Implemented CMV and moved LICs into array of lambdas
- Implemented LIC 12-14
- Provided tests for LIC 12-14

### Jonas Hulthén

- Created initial file structure
- Created LIC file with initial template functions
- Implemented LIC 0-3
- Provided tests for LIC 0-3

### Chris Lundholm

- Implemented LIC 4-7 
- Provided tests for LIC 4-7

### Tianyu Deng

- Implemented FUV
- Implemented LIC 8-11
- Provided tests for LIC 8-11