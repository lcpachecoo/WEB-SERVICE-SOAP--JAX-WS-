# Matricula Web Service (JAX-WS)

Lightweight SOAP web service example (JAX-WS) for managing student enrollments.

## Project layout
- `JAX/` — Maven module containing the web service
  - `pom.xml` — build file (currently configured for Java 11)
  - `src/main/java/br/com/escola/` — service implementation and model

## Prerequisites
- Java JDK (current project uses Java 11). Recommended upgrade: Java 21 (LTS).
- Apache Maven 3.6+ (or use the project's wrapper if available)

## Build
From the workspace root run:

```bash
mvn -f JAX/pom.xml clean package
```

## Run
If the build produces an executable JAR, run with:

```bash
java -jar JAX/target/matricula-ws-1.0-SNAPSHOT.jar
```

If this is packaged as a library or WAR, deploy according to your container.

## Notes about Java upgrade
- The `maven-compiler-plugin` in `JAX/pom.xml` currently targets Java 11 (`<source>11</source>` / `<target>11</target>`).
- To upgrade the project runtime to an LTS Java (for example Java 21), update the `maven-compiler-plugin` `source` and `target` to `21` and ensure the build tool and dependencies are compatible.

## Project contacts
- Maintainer: local developer

## License
MIT-style for examples and learning.
