## How to Test API with Postman or VS Code Thunder Client extension

#### Create new account

POST Request at /api/auth/signup

Json Content (Body) = {"username":"must be email adress", role:["NAME"], "password":"password, will get encrypted by Spring Security"}

Id gets automatically generated

#### Login

POST Request at /api/auth/signin

Json Content (Body) = {"username":"email adress","password":"the password"}

Copy Bearer Access Token to send in future requests

#### Categories: create [admin only]

POST Request at /api/categories with bearer token

Json Content (Body) = 
{
"categoryName":"Fruits and vegetables"  
}

Category Id is automatically generated

#### Products: create [admin only]

You must have created a category and an admin user in order to create a product item

POST Request at /api/products with bearer token

Json Content (Body) = 
{
"productName":"Bananas",
"productDescription":"sold by kg. Imported from Ecuador",
"productQuantity":20,
"productUnitPrice":150,
"categories":1,
"user":1
}

Product Id is automatically generated

#### Users: update user information [admin only]

PUT Request at /user/{id} with bearer token. Replace {id} with id number of desired user

Json Content (Body) = 
{
"firstName":"John",
"lastNameP":"Doe"
}