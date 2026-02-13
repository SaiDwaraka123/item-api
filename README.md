# 🛒 E-Commerce Item Management API

**Spring Boot RESTful API for managing products/items (like Flipkart/Netflix)**

## ✨ **Features**
- ✅ **RESTful API** - POST/GET endpoints
- ✅ **Input Validation** - `@NotBlank`, `@Positive`, `@Size`
- ✅ **In-Memory Storage** - `ArrayList<Item>`
- ✅ **Auto ID Generation** - `AtomicLong`
- ✅ **CORS Enabled** - Frontend friendly

## 📱 **API Endpoints**

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `GET` | `/api/items` | Get all items | `200` |
| `GET` | `/api/items/{id}` | Get item by ID | `200` / `404` |
| `POST` | `/api/items` | Create new item | `201` |

## 🚀 **Quick Start**

### **Prerequisites**
```bash
Java 17+ | Maven 3.6+ | VS Code (Spring Boot Extension)
Run Locally
bash
# VS Code: Ctrl+Shift+P → "Spring Boot: Run"
# Or Terminal:
mvn spring-boot:run
API Live: http://localhost:8080

🧪 Test with Postman
1. Get All Items (Empty)
text
GET http://localhost:8080/api/items
Response: []

2. Add iPhone
text
POST http://localhost:8080/api/items
Content-Type: application/json

{
  "name": "iPhone 15 Pro",
  "description": "Latest Apple flagship with A17 Pro chip",
  "price": 1199.99,
  "category": "Electronics"
}
Response: 201 Created

3. Get All Items (With Data)
text
GET http://localhost:8080/api/items
Response:

json
[
  {
    "id": 1,
    "name": "iPhone 15 Pro",
    "description": "Latest Apple flagship with A17 Pro chip",
    "price": 1199.99,
    "category": "Electronics"
  }
]
4. Get Single Item
text
GET http://localhost:8080/api/items/1
📋 Item Model
java
public class Item {
    @Positive Long id;
    @NotBlank @Size(min=2,max=100) String name;
    @NotBlank @Size(min=10,max=500) String description;
    @NotNull @Positive Double price;
    String category;
}
🛡️ Input Validation Rules
name: 2-100 chars, required

description: 10-500 chars, required

price: Must be positive number

id: Auto-generated, positive

🏗️ Project Structure
text
item-api/
├── pom.xml                 # Maven dependencies
├── src/main/java/...       # Spring Boot code
│   ├── Item.java          # Model + Validation
│   ├── ItemRepository.java # In-memory ArrayList
│   ├── ItemController.java # REST endpoints
│   └── ItemApiApplication.java # Main class
└── README.md              # This file
🔧 Tech Stack
text
✅ Spring Boot 3.2.0
✅ Java 17
✅ Maven
✅ Jakarta Validation
✅ Embedded Tomcat
✅ RESTful JSON API
📁 File Structure
text
item-api/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── itemapi/
                        ├── Item.java
                        ├── ItemApiApplication.java
                        ├── ItemController.java
                        └── ItemRepository.java
