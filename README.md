# Matricula Web Service (JAX-WS)

Lightweight SOAP web service example (JAX-WS) for managing student enrollments.

## Como funciona

- **Publicador:** o arquivo `Publicador.java` publica o endpoint JAX-WS em `http://localhost:8080/matricula` (WSDL em `?wsdl`) usando `Endpoint.publish()`.
- **Contrato (interface):** `MatriculaService` define os métodos expostos pelo serviço SOAP: `cadastrarAluno`, `buscarPorMatricula`, `calcularMedia`, `verificarSituacao` e `listarTodos`.
- **Implementação:** `MatriculaServiceImpl` implementa a lógica de negócio e mantém um armazenamento em memória (`HashMap`) onde a chave é a `matricula` do `Aluno`.
- **Modelo:** `Aluno` contém `matricula`, `nome`, `nota1` e `nota2`. As operações usam esses campos para cadastrar, recuperar e calcular médias.
- **Fluxo de requisição:** um cliente SOAP envia uma requisição ao endpoint (por exemplo, `cadastrarAluno` com um objeto `Aluno`); o runtime JAX-WS roteia a chamada para `MatriculaServiceImpl`, que executa a operação e retorna a resposta.
- **Regras de negócio importantes:** média = `(nota1 + nota2) / 2.0`; situação = "APROVADO" se média >= 6.0, caso contrário "REPROVADO".


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
