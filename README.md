# Solar Energy Management

A full-stack student-friendly portfolio project for managing solar-energy
clients, employees, inventory, delivery notes, dossiers, invoices, payments,
and dashboard metrics.

## Features

- React interface for the main business workflows
- Spring Boot GraphQL API for the main resources
- PostgreSQL persistence with Spring Data JPA
- Dashboard metrics for stock, employees, invoices, and dossiers
- Data seeding for local development
- Docker build and environment-based database configuration
- Validation and centralized exception handling

## Technologies

- React 18
- Vite
- Tailwind CSS
- Java 17
- Spring Boot 3
- Spring GraphQL
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## Project structure

```text
backend/   Spring Boot GraphQL API
frontend/  React and Vite dashboard
```

## Run the backend

```bash
cd backend
mvn spring-boot:run
```

Set the database environment variables in `backend/.env`:

```bash
DB_URL="jdbc:postgresql://localhost:5432/solar_management"
DB_USER="postgres"
DB_PASSWORD="your-password"
```

The GraphQL endpoint is available at `http://localhost:9090/graphql`.
GraphiQL is available at `http://localhost:9090/graphiql`.

## Run the frontend

```bash
cd frontend
npm install
npm run dev
```

The dashboard is available at `http://localhost:5173`.

## Run the backend with Docker

```bash
cd backend
docker build -t solar-energy-management .
docker run --rm -p 9090:9090 `
  -e DB_URL="jdbc:postgresql://host.docker.internal:5432/solar_management" `
  -e DB_USER="postgres" `
  -e DB_PASSWORD="your-password" `
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
