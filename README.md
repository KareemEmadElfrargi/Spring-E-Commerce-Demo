
# Spring E-Commerce Demo (Training)

This is a basic **Spring Boot REST API** for an E-Commerce application. It allows you to manage products including creation, updating, deletion, searching, and image upload functionality.

---

##  Features

- Add a new product with an image
- Get all products
- Get a single product by ID
- Update a product (with image)
- Delete a product
- Search products by keyword
- Get product image by product ID

---

##  Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Postgres , this is your choice**
- **Lombok**
- **Multipart File Upload**

---


---


   ```


##  API Endpoints

| Method | Endpoint                         | Description                |
|--------|----------------------------------|----------------------------|
| GET    | `/api/products`                  | Get all products           |
| GET    | `/api/product/{id}`              | Get product by ID          |
| GET    | `/api/products/search?keyword=shoes` | Search products by keyword |
| POST   | `/api/product`                   | Add new product (with image) |
| PUT    | `/api/product/{id}`              | Update product             |
| DELETE | `/api/product/{id}`              | Delete product             |
| GET    | `/api/product/{id}/image`        | Get product image          |

---

##  Example Add Product (using Postman)

**POST `/api/product`**

Example `form-data`:

| Key        | Value (example) |
|------------|-----------------|
| product    | `{ "name": "Shirt", "description": "Cotton shirt", "price": 99.99 }` |
| ImageFile  | `shirt.jpg`     |

---

## Notes

- Images are uploaded as part of the request (you can store them in DB or filesystem).

---

##  To Do

- ✅ Add category support
- ⏳ Add user authentication
- ⏳ Shopping cart feature
- ⏳ Order management

---


## 📄 License

[Telusko](Navin Reddy)
