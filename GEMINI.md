# Modern Java Lab - Project Context

This file provides context and instructions for the **Modern Java Lab** repository, a collection of hands-on experiments for learning Java 21+ features.

## Project Overview

*   **Purpose:** A step-by-step learning laboratory for modern Java features.
*   **Target Version:** Java 21 (LTS) or higher.
*   **Architecture:** Modular directory structure organized by topic (e.g., `01-virtual-threads`). Each module is self-contained with its own documentation and source code.
*   **Project Type:** Java Code Project (Manual, Maven, and Gradle support).

## Development Environment

The project supports several ways to set up a consistent development environment:

*   **SDKMAN!:** Recommended for local Linux/macOS setups to manage JDK versions.
*   **Dev Containers:** A pre-configured environment for local development using Docker.
*   **GitHub Codespaces:** A cloud-hosted version of the Dev Container setup.

Refer to `BUILD_GUIDE.md` for specific setup instructions.

## Repository Structure

*   `0X-topic-name/`: A module directory.
    *   `src/`: Contains the Java source files (`.java`).
    *   `README.md`: Specific instructions and learning objectives for the module.
    *   `DIAGRAMS.md`: Architectural and conceptual diagrams (where available).
*   `bin/`: Ignored by Git; used as the output directory for compiled class files.
*   `README.md`: Global index of modules and general project information.
*   `BUILD_GUIDE.md`: Comprehensive guide for environment setup and build options.

## Building and Running

While the project emphasizes manual compilation to maintain transparency and focus on core Java APIs, it also provides sample configurations for automated tools.

### Standard Workflow (Manual)

1.  **Compile:** From the project root, compile a specific file into the `bin` directory:
    ```bash
    javac -d bin <module-dir>/src/<FileName>.java
    ```
2.  **Run:** Execute the compiled class from the root:
    ```bash
    java -cp bin <FileName>
    ```

For instructions on using **Maven** or **Gradle**, please refer to the **[Build & Setup Guide](./BUILD_GUIDE.md)**.

## Development Conventions

*   **No Packages:** Source files currently do not use `package` declarations to simplify manual compilation and execution.
*   **Class Naming:** Classes are named sequentially (e.g., `Step1Basic`, `Step2Scalability`) to guide the student through a curriculum.
*   **Main Methods:** Each "Step" file contains a `public static void main` method and is intended to be run as a standalone entry point.
*   **Documentation:** Every source file should include a header comment explaining the concept being demonstrated.

## Current Modules

1.  **01-virtual-threads:** A deep dive into Java Virtual Threads.
    *   **Step 1: The Basics** - Learning the `Thread.Builder` API.
    *   **Step 2: Scalability** - Spawning 100,000 threads to demonstrate lightweight concurrency.
    *   **Step 3: Executor Service** - Production-ready task management with `Executors.newVirtualThreadPerTaskExecutor()`.
    *   **Step 4: Blocking Code** - Understanding how virtual threads handle I/O and sleep without blocking OS threads.
    *   **Step 5: Testing & Debugging** - Using assertions for manual testing and introducing `jdb` for manual debugging.
    *   **Visual Learning:** See `01-virtual-threads/DIAGRAMS.md` for Mermaid diagrams of each step.

2.  **02-nio (Planned):** asynchronous I/O and file system operations.
3.  **03-functional-java (Planned):** Lambdas, Streams, and Functional Interfaces.
