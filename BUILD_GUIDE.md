# Modern Java Lab: Build and Setup Guide

This guide provides step-by-step instructions for setting up your environment and building the Modern Java Lab project using various methods.

---

## 1. Environment Setup

### Using SDKMAN! (Recommended for Linux/macOS)
SDKMAN! is a tool for managing parallel versions of multiple Software Development Kits on most Unix-based systems.

1.  **Install SDKMAN!**:
    ```bash
    curl -s "https://get.sdkman.io" | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    ```
2.  **Install Java 21**:
    ```bash
    sdk install java 21.0.2-tem
    ```
3.  **Verify**:
    ```bash
    java --version
    ```

### Using Dev Containers & GitHub Codespaces
This project includes a `.devcontainer` configuration, allowing you to develop in a consistent, pre-configured environment.

1.  **GitHub Codespaces**: Click the **Code** button on your repository and select **Create codespace on main**.
2.  **Local VS Code**: If you have the "Dev Containers" extension installed, VS Code will prompt you to **Reopen in Container** when you open the project folder.

---

## 2. Manual Build & Execution (The Foundation)

The project is structured to be built manually using the standard JDK tools. This ensures you understand the core Java compilation process.

### Compilation: `javac`
The `javac` command compiles Java source files into bytecode (`.class` files).

**Command Template:**
```bash
javac -d <output-directory> <source-file-path>
```

**Example (Step 1):**
```bash
javac -d bin 01-virtual-threads/src/Step1Basic.java
```

**Key Variables:**
-   `-d bin`: Specifies the **destination** directory for the compiled classes. This keeps your source tree clean.
-   `01-virtual-threads/src/Step1Basic.java`: The path to the source file.

### Execution: `java`
The `java` command launches the Java Runtime Environment (JRE) and executes your program.

**Command Template:**
```bash
java -cp <classpath> <ClassName>
```

**Example (Step 1):**
```bash
java -cp bin Step1Basic
```

**Key Variables:**
-   `-cp bin`: Specifies the **classpath**, telling Java where to look for the compiled `.class` files.
-   `Step1Basic`: The name of the class containing the `main` method. Note that we do not use the file extension here.

---

## 3. Maven Guide

Maven is a powerful build automation tool. While this project is designed for manual builds, you can use Maven by creating a `pom.xml` at the root.

### Sample `pom.xml`
Because this project uses a non-standard source layout (modular folders without packages), we must explicitly define the source directory.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>modern-java-lab</artifactId>
  <version>1.0-SNAPSHOT</version>

  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
  </properties>

  <build>
    <!-- Configure source directory for a specific module -->
    <sourceDirectory>01-virtual-threads/src</sourceDirectory>
    <directory>bin</directory>
  </build>
</project>
```

### Mapping to Manual Steps
-   **Manual Compile** (`javac -d bin ...`) $\approx$ `mvn compile`
-   **Manual Run** (`java -cp bin ...`) $\approx$ `mvn exec:java -Dexec.mainClass="Step1Basic"`

### Creating a Project from Scratch
To create a new Maven-based console application from your terminal:

1.  **Generate the project**:
    ```bash
    mvn archetype:generate \
      -DgroupId=com.example \
      -DartifactId=my-app \
      -DarchetypeArtifactId=maven-archetype-quickstart \
      -DarchetypeVersion=1.4 \
      -DinteractiveMode=false
    ```
2.  **Navigate to the folder**: `cd my-app`
3.  **Build**: `mvn package`
4.  **Run**: `java -cp target/my-app-1.0-SNAPSHOT.jar com.example.App`

---

## 4. Gradle Guide

Gradle is a flexible build system commonly used in modern Java development.

### Sample `build.gradle`
Similar to Maven, we must tell Gradle where our source files are located.

```gradle
plugins {
    id 'java'
    id 'application'
}

group = 'com.example'
version = '1.0-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

sourceSets {
    main {
        java {
            // Include all module source directories
            srcDirs = ['01-virtual-threads/src']
        }
    }
}

// Map the output to the project 'bin' directory
layout.buildDirectory = file('bin')

application {
    mainClass = 'Step1Basic'
}
```

### Mapping to Manual Steps
-   **Manual Compile** (`javac -d bin ...`) $\approx$ `./gradlew classes`
-   **Manual Run** (`java -cp bin ...`) $\approx$ `./gradlew run`

### Creating a Project from Scratch
To create a new Gradle-based console application:

1.  **Create a directory**: `mkdir my-gradle-app && cd my-gradle-app`
2.  **Initialize the project**:
    ```bash
    gradle init --type java-application
    ```
    *Note: Follow the interactive prompts to choose the build script DSL (Groovy/Kotlin), test framework (JUnit), and project name.*
3.  **Build and Run**: `./gradlew run`

---

## Summary of Compilation Variables

| Variable | Description | Manual Flag | Maven/Gradle equivalent |
| :--- | :--- | :--- | :--- |
| **Output Directory** | Where the `.class` files are saved. | `-d` | `<directory>` / `layout.buildDirectory` |
| **Classpath** | Where Java looks for dependencies and classes. | `-cp` | Automated by the build tool. |
| **Source Path** | The location of your `.java` files. | (Positional) | `<sourceDirectory>` / `srcDirs` |
| **Main Class** | The entry point for execution. | (Positional) | `exec.mainClass` / `application.mainClass` |
