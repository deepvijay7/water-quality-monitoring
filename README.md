
---

# Water Quality Monitoring Chatbot

## Overview

This project implements a water quality monitoring system for a village, featuring a REST API for data ingestion and retrieval, and a chatbot for user interaction. The solution is designed to be scalable for national deployment.

## Technologies Used

- **Backend**: Java 17, Spring Boot
- **Database**: H2 (in-memory)
- **Frontend**: Thymeleaf for rendering the chatbot interface
- **JSON Processing**: Jackson
- **Testing**: JUnit, Mockito

## API Endpoints

### 1. Ingest Water Quality Data

- **Endpoint**: `POST /api/water-quality`
- **Description**: Ingest water quality data.
- **Request Body**:
  ```json
  {
      "villageId": "village1",
      "parameters": "{\"pH\": 7.0, \"chlorine\": 0.5, \"colour\": \"clear\"}"
  }
  ```
- **Response**:
  - Status: `201 Created`
  - Body: Confirmation message

### 2. Get Water Quality Data

- **Endpoint**: `GET /api/water-quality`
- **Description**: Retrieve water quality data for a specific village.
- **Query Parameter**:
  - `villageId`: The ID of the village
- **Response**:
  - Status: `200 OK`
  - Body: List of water quality records

### 3. Chatbot Query

- **Endpoint**: `GET /api/chatbot`
- **Description**: Interact with the chatbot to retrieve water quality information.
- **Query Parameter**:
  - `query`: The user's question (e.g., "What is the pH value of water in village1?")
- **Response**:
  - Status: `200 OK`
  - Body: Chatbot response with requested data

## Chatbot URL

- **Chatbot Interface**: `http://localhost:8080/chatbot`

## Build Instructions

### Prerequisites

- **Java JDK 17**: Make sure Java 17 is installed and configured on your machine.
- **Maven**: Install Maven for dependency management.

### Steps to Build and Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/water-quality-monitoring.git
   cd water-quality-monitoring
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the chatbot**:
   Open your web browser and navigate to `http://localhost:8080/chatbot`.

## Testing

Unit tests can be executed using the following command:

```bash
mvn test
```

## Future Enhancements

- Integration with external water quality data sources.
- User authentication and role management.
- Advanced natural language processing for improved chatbot interactions.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

---

Feel free to customize any sections according to your specific implementation details or any additional features you've added! If you need further modifications or additional sections, let me know!