# Learning Java Virtual Threads

This project is a step-by-step guide to understanding Java Virtual Threads (introduced as a preview in Java 19 and finalized in Java 21). 

Virtual Threads are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications.

## Prerequisites

- **Java 21 or higher**: Virtual threads are fully supported in JDK 21.
- **Terminal/Shell**: We will use manual compilation (`javac`) and execution (`java`) to keep things simple and transparent.

## Curriculum

### Step 1: The Basics
**File**: `src/Step1Basic.java`
Learn how to create and start a virtual thread using the new `Thread.Builder` API.
- **Compile**: `javac -d bin src/Step1Basic.java`
- **Run**: `java -cp bin Step1Basic`

### Step 2: Scalability
**File**: `src/Step2Scalability.java`
See why virtual threads are "lightweight" by spawning 100,000 of them and comparing the behavior to traditional platform threads.
- **Compile**: `javac -d bin src/Step2Scalability.java`
- **Run**: `java -cp bin Step2Scalability`

### Step 3: Using an Executor
**File**: `src/Step3Executor.java`
Learn the preferred way to use virtual threads in real applications using `Executors.newVirtualThreadPerTaskExecutor()`.
- **Compile**: `javac -d bin src/Step3Executor.java`
- **Run**: `java -cp bin Step3Executor`

### Step 4: Blocking Code
**File**: `src/Step4Blocking.java`
Understand how virtual threads handle blocking operations (like I/O or sleeping) without tying up expensive OS threads.
- **Compile**: `javac -d bin src/Step4Blocking.java`
- **Run**: `java -cp bin Step4Blocking`

---

## Instructions for the Student

1. Read the code in each file.
2. Follow the compilation and run instructions provided for each step.
3. Observe the output and try to understand *why* it behaves that way.
4. Experiment! Modify the code and see what happens.
