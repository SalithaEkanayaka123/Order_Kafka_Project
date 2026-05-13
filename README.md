# Kafka Order Service

A hands-on Event-Driven Microservice project built using Spring Boot, Apache Kafka, PostgreSQL, Docker, and Schema Registry to learn distributed system fundamentals and asynchronous communication patterns.

This project demonstrates how REST APIs, Kafka Producers, Consumers, Schema Registry, and databases work together in a scalable microservice architecture.

---

# 🚀 Tech Stack

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 4.x |
| Apache Kafka | 3.x |
| PostgreSQL | 16 |
| Confluent Schema Registry | 7.x |
| Docker & Docker Compose | Latest |
| Maven | Latest |
| Spring Data JPA | Latest |
| Hibernate | Latest |

---

# 📚 Architecture Overview

```text
Client
   ↓
REST API
   ↓
Kafka Producer
   ↓
Schema Registry
   ↓
Kafka Topic
   ↓
Kafka Consumer
   ↓
PostgreSQL Database
```

---

# 📦 Project Structure

```text
src/main/java/com/example/kafka_order_service

├── consumer
│   └── OrderConsumer.java
│
├── controller
│   └── OrderController.java
│
├── dto
│   └── OrderRequest.java
│
├── entity
│   └── OrderEntity.java
│
├── event
│   └── OrderCreatedEvent.java
│
├── repository
│   └── OrderRepository.java
│
├── service
│   └── OrderService.java
│
└── KafkaOrderServiceApplication.java
```

---

# ⚙️ Local Development Setup

## 1. Clone Repository

```bash
git clone <your-repository-url>
```

```bash
cd kafka-order-service
```

---

## 2. Start Infrastructure

```bash
docker compose up -d
```

This starts:

- Apache Kafka
- PostgreSQL
- Confluent Schema Registry

Verify running containers:

```bash
docker ps
```

---

# ▶️ Run Spring Boot Application

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

Schema Registry URL:

```text
http://localhost:8081
```

---

# 🧪 API Testing

## Create Order

### Endpoint

```http
POST /api/orders
```

### Request Body

```json
{
  "customerName": "John",
  "productName": "Laptop",
  "amount": 250000
}
```

### CURL Example

```bash
curl -X POST http://localhost:8080/api/orders \
-H "Content-Type: application/json" \
-d '{
  "customerName":"John",
  "productName":"Laptop",
  "amount":250000
}'
```

---

# 🔥 Event Processing Flow

## Producer Workflow

1. REST API receives order request
2. `OrderService` creates event payload
3. Kafka Producer publishes message to topic
4. Schema Registry validates and registers schema

Kafka Topic:

```text
order-created-topic
```

---

## Consumer Workflow

1. Kafka Consumer listens to topic
2. Event is consumed asynchronously
3. Data is transformed into entity object
4. Order is persisted into PostgreSQL

---

# 🧠 Kafka Concepts Implemented

## Kafka Producer
Publishes events/messages into Kafka topics.

## Kafka Consumer
Consumes events asynchronously from Kafka topics.

## Kafka Topic
Logical channel used to store and stream events.

## Kafka Broker
Kafka server responsible for managing topics and partitions.

## Consumer Group
Allows multiple consumers to share processing workload.

## Offset
Unique identifier representing message position inside a partition.

## Event-Driven Architecture
Microservices communicate through asynchronous events instead of direct service-to-service calls.

## Schema Registry
Centralized schema validation and schema evolution management for Kafka events.

## JSON Schema Serialization
Ensures message structures remain consistent between Producers and Consumers.

---

# 🗄 Database Integration

- PostgreSQL used for persistent storage
- Spring Data JPA + Hibernate for ORM
- Automatic schema/table generation using Hibernate

Example Table:

```text
orders
```

---

# 🐳 Docker Infrastructure

Docker Compose is used to provision:

- Kafka Broker
- PostgreSQL Database
- Schema Registry

Benefits:
- Easy local setup
- Consistent development environment
- Simplified distributed system testing

---

# 📈 Future Improvements

- Retry mechanism
- Dead Letter Queue (DLQ)
- Multiple Kafka partitions
- Multiple consumer instances
- Avro serialization
- Kafka Streams
- Dockerized Spring Boot deployment
- Kubernetes deployment
- Monitoring with Grafana & Prometheus
- Distributed tracing
- Idempotent consumer handling
- Exactly-once processing

---

# 📖 Learning Outcomes

This project helps understand:

- Distributed systems fundamentals
- Kafka event streaming
- Asynchronous communication
- Event-driven microservices
- Producer/Consumer architecture
- Schema Registry integration
- Spring Boot + Kafka integration
- Database persistence workflows
- Docker-based local infrastructure

---

# 👨‍💻 Author

Salitha Ekanayaka

Java | Spring Boot | Apache Kafka | Microservices | Distributed Systems
