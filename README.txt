- How to compile and run the application with an example for each call?

You may compile the project running the command "mvn compile" form project base dir.

In order to run the application, execute the following command: "mvn spring-boot:run"

To change the port in which to run the provided endpoints bellow, edit the property in the file application.properties:
server.port=27001
Changing the value to the one desired.

Endpoints provided:

1) Create, update and delete prodcuts

[HTTP-GET]      http://<host>:<port>/product/<id>
[HTTP-POST]     http://<host>:<port>/product (send image in HTTP body, in JSON format)
[HTTP-DELETE]   http://<host>:<port>/product/<id>


Example UPDATE:

{
  "name": "Python 2.7",
  "description": "DESCRICAO",
  "parentProductId": null
}

2) Create, update and delete images

[HTTP-GET]      http://<host>:<port>/image/<id>
[HTTP-POST]     http://<host>:<port>/image (send image in HTTP body, in JSON format)
[HTTP-DELETE]   http://<host>:<port>/image/<id>

Example UPDATE:

{
  "type": "Funny",
  "productId": 2
}

3) Get all products excluding relationships (child products, images)

[HTTP-GET]      http://<host>:<port>/products

4) Get all products including specified relationships (child product and/or images)

[HTTP-GET]      http://<host>:<port>/products/all

5) Same as 3 using specific product identity

[HTTP-GET]      http://<host>:<port>/product/<id>

6) Same as 4 using specific product identity

[HTTP-GET]      http://<host>:<port>/product/<id>/all

7) Get set of child products for specific product

[HTTP-GET]      http://<host>:<port>/product/<id>/children

8) Get set of images for specific product

[HTTP-GET]      http://<host>:<port>/product/<id>/images

9) (extra) Get all images excluding relationships

[HTTP-GET]      http://<host>:<port>/images


- How to run the suite of automated tests?

In order to run the tests, execute in project base directory the follwing command: "mvn test"

- Mention anything that was asked but not delivered and why, and any additional comments.

Except for TDD and other kind of testes, due to time constraints, I believe everything else requested was fully delivered.
Thanks for the opportunity!

All endpoints were tested according to the checklist:

( ok ) [HTTP-GET]      http://localhost:27001/product/<id>
( ok ) [HTTP-POST]     http://localhost:27001/product (send image in HTTP body, in JSON format)
( ok ) [HTTP-DELETE]   http://localhost:27001/product/<id>
( ok ) [HTTP-GET]      http://localhost:27001/image/<id>
( ok ) [HTTP-POST]     http://localhost:27001/image (send image in HTTP body, in JSON format)
( ok ) [HTTP-DELETE]   http://localhost:27001/image/<id>
( ok ) [HTTP-GET]      http://localhost:27001/products
( ok ) [HTTP-GET]      http://localhost:27001/products/all
( ok ) [HTTP-GET]      http://localhost:27001/product/<id>
( ok ) [HTTP-GET]      http://localhost:27001/product/<id>/all
( ok ) [HTTP-GET]      http://localhost:27001/product/<id>/children
( ok ) [HTTP-GET]      http://localhost:27001/product/<id>/images
( ok ) [HTTP-GET]      http://localhost:27001/images