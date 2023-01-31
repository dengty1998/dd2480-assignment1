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


## Running the Executable

You can execute generated jar by:

```
java -jar ./target/assignment-1.0-SNAPSHOT.jar
```

It will load input data from file at path `./input.json`. `input.json` in the repository contains sample input.


## Documentation

The documentation is [available](https://dd2480-group14.github.io/Assignment-1/) online. It is generated via Javadoc from comments in the source code and deployed automatically after pull request merges into main branch.


## Code Style

The code style is enforced by the build system. The file describing the formatting rules is `format.xml`, it is in the Eclipse file-format. The code style is based on [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) with indentation by 4 spaces instead of 2. You can use Maven to automatically apply the code style by running:

```
mvn spotless:apply
```


## Contributing

You can choose any open task on the project's GitHub Issues [page](https://github.com/DD2480-group14/Assignment-1/issues) and create a branch named `issues/#` where # is the number of the issue you want to work on. After committing to the branch to the point where you feel like the work is done, you can create a pull request. All pull requests need to pass all existing project tests, as well as comply to the project's code style. Additionally, before being merged a pull request needs to be reviewed by someone else.


## Statement of Contributions

We think we have done something remarkable. We have established a clear structure of work, for example there was an instance of attempt to directly push a commit to main while it was not working so it was rejected. Otherwise this would have disrupted the work for the rest of the team. We implemented automatic documentation generation and deployment to github pages. Github actions was used to check the code and documentation comments automatically. 

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
- Implemented HelperFunction
- Implemented LIC 0-3
- Provided tests for LIC 0-3

### Christoffer Lundholm

- Implemented LIC 4-7 
- Provided tests for LIC 4-7
- Implemented PUM

### Tianyu Deng

- Implemented FUV
- Implemented LIC 8-11
- Provided tests for LIC 8-11


## Way of Working

We estimate our way of working to be at "In Place" level.

### Principles Established

We decided on a system where we could work independently on issues.

### Foundations Established

We used slack for general communication purposes and we used github issues for keeping track of tasks. We agreed on that the main branch should be in a working state so everyone can easily start working on new tasks. To ensure this we utilized github actions to check the code and apply tests on it before a pull request can be merged into main. We prohibited direct pushes to main and required at least one approval on pull requests before it could be merged.

### In Use

The practices and tools were indeed being used to do real work.

### In Place

All of the team members used the aforementioned process. 

### Working Well

There were sometimes issues for example merge conflicts.
