# EquipRental Application

EquipRental is a web application that allows users to rent equipment for various categories such as rackets, bicycles, cricket equipment, and swimsuits.

## Technologies Used

- Java
- Spring Boot
- MySQL
- Postman

## Getting Started

To run the EquipRental application locally, follow these steps:


1. Clone the repository:

       git clone <repository-url> 

2. Install the necessary dependencies.

3. Configure the database connection in the application.properties file.

4. Set up the Google Cloud Storage credentials for image storage.

5. Build and run the application.

   mvn spring-boot:run

   Access the application locally at http://localhost:8080.

## API Endpoints
### Product Endpoints

- **Add Product**
    - URL: `/products/addProduct`
    - Method: `POST`
    - Request Body:

  ```
   {
   "name": "Product Name",
   "image": "Image URL",
   "category": "Product Category",
   "price": 0.0
  }
  ```
    - Response: 201 Created


- **Add Image**
    - URL: `/products/addImage`
    - Method: `POST`
    - Form Data:
        - `image`: Image file
    - Response: 201 Created


- **Get Products by Category and Duration**

    -   URL: `/products/getByCateAndDura`
    -   Method: `GET`
    -   Query Parameters:
        -   `category`: Product Category
        -   `duration`: Rental Duration
    -   Response: List of products matching the category and duration

### Booking Endpoints

- **Create Booking**
    -   URL: `/booking/CreateBooking`
    -   Method: `POST`
    -   Request Body:
   ```
    {
        "productName": "Product Name",
        "date": "Booking Date",
        "time": "Booking Time",
        "reqDateTime": "Requested Date and Time",
        "duration": 0.0
    }
   ```
    - Response: 201 Created


- **Get All Bookings**

    -   URL: `/booking/get_all`
    -   Method: `GET`
    -   Response: List of all bookings
## Development Workflow

1. Create the necessary database schema and tables.

2. Implement the product-related functionality:
    -   Create the product model and repository.
    -   Implement the product service to handle product operations.
    -   Create the product controller to define the product endpoints.

3. Implement the booking-related functionality:
    -   Create the booking model and repository.
    -   Implement the booking service to handle booking operations.
    -   Create the booking controller to define the booking endpoints.

4. Implement the necessary DTOs and converters for data transfer and conversion.

5. Test the API endpoints using Postman.

6. Store product images in the `static/img` directory of the Spring Boot application. Save the image filenames in the database along with the product information.
7. Test the application and fix any issues or bugs.

## Future Enhancements

-  Implement user authentication and authorization.
-  Implement user interface for better user experience.
-  Add more features and functionalities based on requirement
