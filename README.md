# Solar Energy Management

A Spring Boot backend for managing solar-energy clients, employees, inventory,
delivery notes, STEG dossiers, invoices, payments, and dashboard metrics.

## Features

- GraphQL API for all main business resources
- PostgreSQL persistence with Spring Data JPA
- Dashboard metrics for stock, employees, invoices, and dossiers
- Data seeding for local development
- Docker build and environment-based database configuration
- Validation and centralized exception handling

## Technologies

- Java 17
- Spring Boot 3
- Spring GraphQL
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## Run locally

Set the database environment variables:

```bash
DB_URL="jdbc:postgresql://localhost:5432/solar_management"
DB_USER="postgres"
DB_PASSWORD="your-password"
```

Start the application:

```bash
mvn spring-boot:run
```

The GraphQL endpoint is available at `http://localhost:9090/graphql`.
GraphiQL is available at `http://localhost:9090/graphiql`.

For Docker:

```bash
docker build -t solar-energy-management .
docker run --rm -p 9090:9090 \
  -e DB_URL="jdbc:postgresql://host.docker.internal:5432/solar_management" \
  -e DB_USER="postgres" \
  -e DB_PASSWORD="your-password" \
  solar-energy-management
```

## Main GraphQL operations

The schema under `src/main/resources/graphql` exposes queries and mutations for:

- Employees
- Stock items
- Clients
- Delivery notes
- STEG dossiers
- Invoices and payments
- Dashboard metrics

## Configuration

| Variable | Purpose |
|---|---|
| `DB_URL` | PostgreSQL JDBC URL |
| `DB_USER` | PostgreSQL username |
| `DB_PASSWORD` | PostgreSQL password |
| `PORT` | HTTP port, default: `9090` |

## Project context

This backend is based on an existing solar-business implementation and was
reorganized and renamed as a portfolio project. It demonstrates a practical
Spring Boot architecture with domain entities, repositories, services,
GraphQL controllers, validation, and PostgreSQL persistence.
