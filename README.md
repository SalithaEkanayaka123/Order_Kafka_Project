# Kafka Order Service

A beginner-friendly Kafka + Spring Boot microservice project built to learn:

- Apache Kafka fundamentals
- Event-driven architecture
- Kafka Producer & Consumer
- Spring Boot integration with Kafka
- PostgreSQL integration
- Docker Compose setup
- REST API communication

---

# 🚀 Tech Stack

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 4.x |
| Apache Kafka | 3.x |
| PostgreSQL | 16 |
| Docker | Latest |
| Maven | Latest |

---

# 📚 Project Architecture

```text
Client
   ↓
REST API
   ↓
Kafka Producer
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

# ⚙️ Local Setup

## 1. Clone Project

```bash
git clone <your-repository-url>
```

```bash
cd kafka-order-service
```

---

## 2. Start Docker Containers

```bash
docker compose up -d
```

This starts:
- Kafka
- PostgreSQL

Check running containers:

```bash
docker ps
```

---

# ▶️ Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

# 🧪 Test API

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

# 🔥 Kafka Flow

## Producer Flow

1. REST API receives request
2. `OrderService` creates Kafka event
3. Event published to Kafka topic

```text
order-created-topic
```

---

## Consumer Flow

1. Kafka Consumer listens to topic
2. Event consumed
3. Order saved into PostgreSQL database

---

# 🧠 Kafka Concepts Learned

## Producer
Application that sends messages to Kafka.

## Consumer
Application that reads messages from Kafka.

## Topic
Category/channel where messages are stored.

## Broker
Kafka server instance.

## Offset
Unique position of message inside partition.

## Consumer Group
Multiple consumers sharing workload.

## Event-Driven Architecture
Services communicate using events/messages instead of direct calls.

---

# 🛠 Future Improvements

- Retry mechanism
- Dead Letter Queue (DLQ)
- Kafka partitions
- Multiple consumers
- Schema Registry
- Avro serialization
- Dockerized Spring Boot app
- Kubernetes deployment
- Monitoring with Grafana
- Distributed tracing

---

# 📖 Learning Goals

This project helps understand:

- Real-world Kafka workflow
- Asynchronous communication
- Decoupled microservices
- Event publishing & consumption
- Kafka with Spring Boot
- Database persistence after event processing

---

# 👨‍💻 Author

Java | Spring Boot | Kafka | Microservices
