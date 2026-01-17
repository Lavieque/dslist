# dslist

Backend REST API for the dslist project — a Java Spring Boot service that provides game listings and lists. The codebase includes domain entities, DTOs, controllers, repositories and a PostgreSQL data seed.

---

## Table of Contents

- About
- Features
- Tech Stack
- Prerequisites
- Running (development)
- Build and Run (jar)
- Configuration
- Database seed
- API Endpoints
- Project Structure
- Testing
- Contributing
- License
- Contact

## About

This is the backend service for the dslist application. It exposes REST endpoints to list games and game lists and is implemented with Spring Boot, Spring Data JPA and PostgreSQL. The repository contains DTOs, controllers, repositories and an `import.sql` with example data.

## Features

- List all games 
- Get game details by id
- Repository layer with a custom belonging-position update
- PostgreSQL persistence with optional SQL seed

## Tech Stack

- Java 17+ (verify with project configuration)
- Spring Boot (Web, Data JPA)
- PostgreSQL
- Maven (mvn or included mvnw wrapper)

## Prerequisites

- Java 17+ JDK
- Maven (optional, you can use the included mvnw wrapper)
- PostgreSQL
- Git

## Running (development)

1. Clone the repo:
```bash
git clone https://github.com/Lavieque/dslist.git
cd dslist
```

2. Create a PostgreSQL database. The development properties (src/main/resources/application-dev.properties) are configured with the following defaults:
- JDBC URL: `jdbc:postgresql://localhost:5433/dslist`
- Username: `postgres`
- Password: `1234567`

Adjust your local database or the properties file if needed.

3. Start the application with the Maven wrapper:
```bash
# macOS / Linux
./mvnw spring-boot:run

# Windows (PowerShell)
mvnw.cmd spring-boot:run
```
The app starts on port 8080 by default.

## Build and Run (jar)

```bash
./mvnw package
java -jar target/*.jar
```

## Configuration

- Development: `src/main/resources/application-dev.properties`
- Production: `src/main/resources/application-prod.properties` — reads DB connection from environment variables: `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`

Note: `application-dev.properties` currently sets `spring.jpa.hibernate.ddl-auto=none`. If you want Hibernate to create the schema locally and load `import.sql`, change it to `create` (only for local dev) or run the SQL manually.

## Database seed

`src/main/resources/import.sql` contains INSERT statements for `tb_game_list` and `tb_game` with example data.

Options to apply the seed:
- Run the SQL manually against your database (recommended if `ddl-auto` is `none`).
- Temporarily set `spring.jpa.hibernate.ddl-auto=create` to let Hibernate create schema and execute `import.sql` (use only for local development).

## API Endpoints

Provided by `com.cursos.dslist.controllers.GameController`:

- GET /games
  - Returns a list of games using a lightweight projection
- GET /games/{id}
  - Returns full game details for the given id

Examples:
```bash
# List games
curl http://localhost:8080/games

# Get a specific game by id
curl http://localhost:8080/games/1
```

## Project Structure (selected)

- `src/main/java/com/cursos/dslist/controllers/` — REST controllers (e.g., GameController)
- `src/main/java/com/cursos/dslist/services/` — service classes
- `src/main/java/com/cursos/dslist/repositories/` — Spring Data JPA repositories
- `src/main/java/com/cursos/dslist/dto/` — DTOs used by controllers
- `src/main/java/com/cursos/dslist/entities/` — JPA entities
- `src/main/resources/` — application properties and `import.sql`

## Testing

If tests are present, run:
```bash
./mvnw test
```
