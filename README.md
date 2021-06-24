# Football ticket application(Project in development)
A simple REST application representing the sale of football tickets.

![img](football_tickets.jpg)

At this stage of development, the application has such functionality:</br>
We can send HTTP GET, POST, PUT, DELETE requests

Game Session
- */game-sessions* [POST] - Add new game session.
- */game-sessions/available* [GET] - Find available game session.
- */game-sessions/{id}* [PUT] - Update game session.
- */game-sessions/{id}* [DELETE] - Delete game session.

Game
- */games* [GET] - Get all games.
- */games* [POST] - Add new game.

Authentication
- */register* [POST] - Register new user.

Order
- */orders* [GET] - Get order history.
- */orders/complete* [POST] - complete order.

Shopping card
- */shopping-cards/by-user* [GET] - Get shopping card by user.
- */shopping-cards/game-sessions* [POST] - add ticket to shopping card.

Stadium
- */stadiums* [GET] - Get all stadiums.
- */stadiums* [POST] - Add new stadium.

User
- */users/by-email* [GET] - Get user by email.

## Technologies used
- Spring - Core / MVC / Web / Security
- Hibernate
- DataBase - MySQL
- Packaging - Apache Maven
- Tomcat

## Configuration:
- Сlone this project into your local folder and open the project in an IDE.
- Setup new connection in *"src/main/resources/db.properties"* and set your: "DRIVER", "URL", "USERNAME" and "PASSWORD"
- Configure Tomcat (Local) with : Deployment - war_exploded, context address - "/"
- Run a project
- For sending HTTP requests you can use Postman.
