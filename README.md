# Spring Boot PostgreSQL Partitioning Demo

A hands-on **Spring Boot + PostgreSQL** demo using **table partitioning** with **Flyway migrations** and **Docker**.
Learn how to organize time-based sales data into range partitions and query them seamlessly via JPA.

---

## 🚀 Features

* **PostgreSQL Range Partitioning** for `sales` table
* **Flyway** for automatic schema migration on app startup
* **Spring Data JPA** for persistence
* **Docker Compose** to run PostgreSQL and pgAdmin locally
* Example API for inserting and listing sales

---

## 🛠 Tech Stack

* Java 21
* Spring Boot 3.5.x
* PostgreSQL 16 (Docker)
* Flyway Database Migration
* Spring Data JPA
* pgAdmin for DB inspection

---

## 📂 Project Structure

```
src/main/java/com/example/partitioning
  ├── controller      # REST endpoints
  ├── entity          # JPA entities
  ├── repository      # Spring Data repositories
  ├── service         # Business logic
src/main/resources
  └── db/migration    # Flyway SQL scripts (V1__create_sales_partitioned_table.sql)
```

---

## 🐳 Running with Docker

### 1. Start PostgreSQL & pgAdmin

```bash
docker-compose up -d
```

PostgreSQL will be available at `localhost:5433`
pgAdmin will be available at [http://localhost:5050](http://localhost:5050) (user: `admin@admin.com`, pass: `admin`)

---

## ▶ Running the App

```bash
./mvnw spring-boot:run
```

Flyway will automatically run `V1__create.sql` to create the partitioned tables.

---

## 📜 API Endpoints

### Insert a Sale

```http
POST /api/v1/sales
Content-Type: application/json

{
  "saleDate": "2024-03-15",
  "amount": 250.00
}
```

### List All Sales

```http
GET /api/v1/sales
```

---

## 🔍 Checking Data in Partitions

You can verify which partition holds a record:

```sql
SELECT tableoid::regclass AS partition, * FROM sales;
```

Example output:

```
  partition   | id | sale_date  | amount
--------------+----+------------+--------
 sales_2023   |  1 | 2023-02-15 | 150.75
 sales_2024   |  2 | 2024-03-15 | 250.00
```