# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "org.example.SomeTestClass"

# Run a single test method
./gradlew test --tests "org.example.SomeTestClass.methodName"

# Clean build outputs
./gradlew clean
```

On Windows use `gradlew.bat` instead of `./gradlew`.

## Tech Stack

- **Language**: Java (Azul JDK 25)
- **Build**: Gradle 9.2.0 with Kotlin DSL (`build.gradle.kts`)
- **Testing**: JUnit 5 (Jupiter 5.10.0)
- **Package**: `org.example`

## Architecture

The project is in early development. The entry point is `src/main/java/org/example/Main.java`. Source code goes under `src/main/java/org/example/` and tests under `src/test/java/org/example/`.

Dependencies are managed in `build.gradle.kts` using Maven Central.