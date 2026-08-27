# Pattern Matching & Records (Java 21)

This module explores the shift towards data-oriented programming in Java. You will learn how to use Records to carry data and Pattern Matching to query it safely and concisely.

## Prerequisites

- **Java 21 or higher**: These features (specifically Record Patterns) were finalized in Java 21.

## Curriculum

### Step 1: Records
**File**: `02-pattern-matching/src/Step1Records.java`
Learn the concise syntax for data carriers that replaces verbose POJOs.
- **Compile**: `javac -d bin 02-pattern-matching/src/Step1Records.java`
- **Run**: `java -cp bin Step1Records`

### Step 2: Type Patterns
**File**: `02-pattern-matching/src/Step2TypePatterns.java`
Simplify `instanceof` checks with automatic casting (Pattern Variables).
- **Compile**: `javac -d bin 02-pattern-matching/src/Step2TypePatterns.java`
- **Run**: `java -cp bin Step2TypePatterns`

### Step 3: Record Patterns
**File**: `02-pattern-matching/src/Step3RecordPatterns.java`
Deconstruct records directly in `instanceof` or `switch` to access their components.
- **Compile**: `javac -d bin 02-pattern-matching/src/Step3RecordPatterns.java`
- **Run**: `java -cp bin Step3RecordPatterns`

### Step 4: Switch Expressions & Patterns
**File**: `02-pattern-matching/src/Step4SwitchPatterns.java`
Use `switch` as an expression and match against types and record structures.
- **Compile**: `javac -d bin 02-pattern-matching/src/Step4SwitchPatterns.java`
- **Run**: `java -cp bin Step4SwitchPatterns`

### Step 5: Sealed Classes & Exhaustiveness
**File**: `02-pattern-matching/src/Step5SealedClasses.java`
Learn how `sealed` hierarchies enable the compiler to check for exhaustive `switch` cases.
- **Compile**: `javac -d bin 02-pattern-matching/src/Step5SealedClasses.java`
- **Run**: `java -cp bin Step5SealedClasses`
