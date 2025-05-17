# 📬 Notification Service

A Spring Boot-based microservice for sending and retrieving user notifications.  
Built with RabbitMQ integration for message queuing and asynchronous processing.  
Provides RESTful GET and POST endpoints to interact via tools like Postman.

---

## 🚀 Features

- Send notifications via POST request
- Retrieve notifications by user ID
- Queue integration using RabbitMQ
- Dockerized setup for easy local development

---

## 🐳 Running the Project with Docker

### 1. Start RabbitMQ using Docker

```bash
docker run -d --hostname rabbit-host --name rabbitmq \
  -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```


RabbitMQ Management UI: http://localhost:15672

Username: guest

Password: guest

### 2. Start Spring Boot Application
Make sure you have Maven and Java 17+ installed.

```bash
Copy
Edit
./mvnw clean install
./mvnw spring-boot:run
Or if using regular Maven:
```

```bash
Copy
Edit
mvn clean install
mvn spring-boot:run
The application will start on: http://localhost:8080
```
## 🔁 REST API Endpoints
### ✅ POST /notifications
Send a notification.

URL: http://localhost:8080/notifications

Method: POST

Headers: Content-Type: application/json

Body Example:

``` json
Copy
Edit
{
  "userId": 101,
  "type": "EMAIL",
  "message": "Welcome to My Notification_server System through email!"
}
```
<img width="957" alt="p_email" src="https://github.com/user-attachments/assets/1a55c650-9aa6-417f-8d45-cc476e43c4cb" />



``` json
Copy
Edit
{
  "userId": 102,
  "type": "SMS",
  "message": "Welcome to My Notification_server System through sms!"
}
```
<img width="958" alt="p_sms" src="https://github.com/user-attachments/assets/6fe2ab1a-13c3-4d4e-a255-c79baa139d26" />


``` json
Copy
Edit
{
  "userId": 103,
  "type": "In_APP",
  "message": "Welcome to My Notification_server System through IN_App!"
}
```

<img width="957" alt="p_inapp" src="https://github.com/user-attachments/assets/fd17c823-e152-4ce6-a64f-f382ba9f9f93" />





### 📩 GET /users/{userId}/notifications
Fetch all notifications for a specific user.

URL: http://localhost:8080/users/{userId}/notifications



Method: GET
URL: http://localhost:8080/users/101/notifications

<img width="958" alt="g_email" src="https://github.com/user-attachments/assets/5dc6d922-fa31-4c00-a0ab-6cdcff2063b9" />


URL: http://localhost:8080/users/102/notifications

<img width="956" alt="g_sms" src="https://github.com/user-attachments/assets/a624ef55-7637-41ae-8405-9ff3d661e721" />

URL: http://localhost:8080/users/103/notifications

<img width="959" alt="g_inapp" src="https://github.com/user-attachments/assets/7ab64269-84b4-443c-850b-6b1a5ab0e6cd" />



## 🔁 RabbitMQ Integration
Spring Boot connects to RabbitMQ using spring.rabbitmq.host=localhost

Queue name should be defined consistently in RabbitMQConfig.java

Messages sent through /notifications are pushed to the queue

Consumers can listen to the same queue and process them asynchronously

##📬 Postman Testing
You can test both APIs using Postman:

POST http://localhost:8080/notifications

Send JSON body with userId, type (EMAIL, SMS, IN_APP), and message.

GET http://localhost:8080/users/{userId}/notifications

Replace {userId} with a valid ID (e.g., 123).

### 🛠 Tech Stack
Java 17+

Spring Boot 3.x

RabbitMQ -- 

WE firstly set up a run RabbitMq as-

<img width="950" alt="run_n_queue" src="https://github.com/user-attachments/assets/fee0faaa-3768-48c2-9c51-7db04089e630" />




You should see the following queues listed (or similar, based on your configuration):

emailQueue:

<img width="950" alt="rabbitmq_email" src="https://github.com/user-attachments/assets/8b284dfc-78bd-4186-b694-cbc5ef322d05" />


smsQueue:

<img width="947" alt="rabbitmq_sms" src="https://github.com/user-attachments/assets/c645bcd2-4c2e-4417-aa45-4a5840ca016c" />


inAppQueue:

<img width="959" alt="rabbitmq_inapp" src="https://github.com/user-attachments/assets/febb3cca-2476-4a1c-aee6-02115ffb68c4" />

FINAL OVERVIEW: 

<img width="949" alt="rabbitmq_overview" src="https://github.com/user-attachments/assets/bd782fe3-7f4d-4a01-8bca-b1e246e2bdef" />


Maven

Docker START:

<img width="951" alt="docker" src="https://github.com/user-attachments/assets/bb88b5ed-c407-455f-9ec6-99744bc2d8dc" />


```bash
sudo systemctl start docker
docker start rabbitmq
```

Postman

🧼 Stopping Docker RabbitMQ
To stop and remove the RabbitMQ container:

```bash
Copy
Edit
docker stop rabbitmq
docker rm rabbitmq
```

