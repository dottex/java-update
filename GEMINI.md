# Modern Java Lab - Project Context

This file provides context and instructions for the **Modern Java Lab** repository, a collection of hands-on experiments for learning Java 21+ features.

## Project Overview

*   **Purpose:** A step-by-step learning laboratory for modern Java features.
*   **Target Version:** Java 21 (LTS) or higher.
*   **Architecture:** Modular directory structure organized by topic (e.g., `01-virtual-threads`). Each module is self-contained with its own documentation and source code.
*   **Project Type:** Java Code Project (Manual Build).

## Repository Structure

*   `0X-topic-name/`: A module directory.
    *   `src/`: Contains the Java source files (`.java`).
    *   `README.md`: Specific instructions and learning objectives for the module.
*   `bin/`: Ignored by Git; used as the output directory for compiled class files.
*   `README.md`: Global index of modules and general project information.

## Building and Running

The project intentionally avoids build tools like Maven or Gradle to maintain transparency and focus on core Java APIs.

### Standard Workflow

1.  **Compile:** From the project root, compile a specific file into the `bin` directory:
    ```bash
    javac -d bin <module-dir>/src/<FileName>.java
    ```
2.  **Run:** Execute the compiled class from the root:
    ```bash
    java -cp bin <FileName>
    ```

## Development Conventions

*   **No Packages:** Source files currently do not use `package` declarations to simplify manual compilation and execution.
*   **Class Naming:** Classes are named sequentially (e.g., `Step1Basic`, `Step2Scalability`) to guide the student through a curriculum.
*   **Main Methods:** Each "Step" file contains a `public static void main` method and is intended to be run as a standalone entry point.
*   **Documentation:** Every source file should include a header comment explaining the concept being demonstrated.

## Current Modules

1.  **01-virtual-threads:** Covers the Basics, Scalability, `ExecutorService` integration, and Blocking behavior of Java Virtual Threads.
2.  **02-nio (Planned):** asynchronous I/O and file system operations.
3.  **03-functional-java (Planned):** Lambdas, Streams, and Functional Interfaces.
