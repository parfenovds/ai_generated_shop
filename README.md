# ai_generated_shop
# E-commerce Application using Spring Boot

This project represents an e-commerce platform developed using Spring Boot and REST services. The application allows users to to browse products, add items to their cart, and place orders using integration with a payment gateway (Stripe).

## Setup and Usage

### Database Setup

The application uses a PostgreSQL database named `shop_db`. Follow the steps below to set up and run the application:

1. **Start a PostgreSQL Database:**
   - Ensure you have PostgreSQL installed or use a PostgreSQL Docker container.
   - Run the following command to start a PostgreSQL container:
     ```bash
     docker run --name ecommerce-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=shop_db -p 5432:5432 -d postgres
     ```
     Replace `password` with your desired password.

2. **Create a Database:**
   - Access the PostgreSQL database:
     ```bash
      docker run --name shop-postgres -e POSTGRES_PASSWORD=mysecretpassword POSTGRES_DB=shop-db -p 5432:5432 -d postgres
     ```

3. **Add a User to the Database:**
   - Manually add a user to the `shop_db` database with appropriate permissions.

4. **Run the Application:**
   - Clone the repository:
     ```bash
     git clone https://github.com/parfenovds/ai_generated_shop
     cd ai_generated_shop
     ```

   - Build and run the Spring Boot application using Maven:
     ```bash
     mvn spring-boot:run
     ```

5. Answers:

    Was it easy to complete the task using AI? - Not at all, I had to put a lot of efforts in it, and chatgpt was not a good helper.
    How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics) - Around 8 hours, and I have no more time to make a good SpringSecurity part.
    Was the code ready to run after generation? What did you have to change to make it usable? - I've had to make a lot of improvements, completely understand the field of the app, and chatgpt was not a good helper (reading guides and API description was more helpful).
    Which specific prompts you learned as a good practice to complete the task? - There were a lot of specific prompts: simple questions in my native language with a lot of context, tricky paraphrases, a lot of copy and pasting methods.

## Endpoints

### CartController

#### Add Item to Cart
- **URL:** `/cart/user/{userId}/product/{productId}`
- **Method:** `POST`
- **Request Body:** None
- **Response:** No content

#### Get User Cart
- **URL:** `/cart/{userId}`
- **Method:** `GET`
- **Response Body Example:**
   ```json
   {
     "id": 1,
     "userId": 123,
     "totalAmount": 100.0,
     "cartItems": [
       {
         "id": 1,
         "productId": 456,
         "quantity": 2,
         "price": 50.0
       }
     ]
   }

OrderController
Create Order

    URL: /orders/user/{userId}
    Method: POST
    Request Body: None
    Response Body Example:

    json

    {
      "id": 1,
      "userId": 123,
      "totalAmount": 100.0,
      "items": [
        {
          "id": 1,
          "productId": 456,
          "quantity": 2,
          "price": 50.0
        }
      ],
      "status": "CREATED"
    }

Get User Orders

    URL: /orders/user/{userId}
    Method: GET
    Response Body Example:

    json

    [
      {
        "id": 1,
        "userId": 123,
        "totalAmount": 100.0,
        "items": [
          {
            "id": 1,
            "productId": 456,
            "quantity": 2,
            "price": 50.0
          }
        ],
        "status": "CREATED"
      }
    ]

Cancel Order

    URL: /orders/cancel/{orderId}
    Method: PUT
    Request Body: None
    Response: No content

ProductController
Get All Products

    URL: /products
    Method: GET
    Response Body Example:

    json

    [
      {
        "id": 1,
        "name": "Product Name",
        "description": "Product Description",
        "price": 25.0
      }
    ]

Get Product by ID

    URL: /products/{productId}
    Method: GET
    Response Body Example:

    json

    {
      "id": 1,
      "name": "Product Name",
      "description": "Product Description",
      "price": 25.0
    }

Add Product

    URL: /products
    Method: POST
    Request Body Example:

    json

{
  "name": "New Product",
  "description": "New Product Description",
  "price": 30.0
}

Response Body Example:

json

    {
      "id": 2,
      "name": "New Product",
      "description": "New Product Description",
      "price": 30.0
    }

Update Product

    URL: /products/{productId}
    Method: PUT
    Request Body Example:

    json

{
  "name": "Updated Product",
  "description": "Updated Product Description",
  "price": 35.0
}

Response Body Example:

json

    {
      "id": 2,
      "name": "Updated Product",
      "description": "Updated Product Description",
      "price": 35.0
    }

Delete Product

    URL: /products/{productId}
    Method: DELETE
    Response: No content



