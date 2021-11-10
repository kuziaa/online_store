CREATE DATABASE  my_db;
USE my_db;

CREATE TABLE categories (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL unique,
  PRIMARY KEY (id)
);

CREATE TABLE products (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL unique,
  rate decimal(6, 2),
  price decimal(6, 2),
  category_id int,
  PRIMARY KEY (id),
  foreign key (category_id) references my_db.categories(id)
);

CREATE TABLE users (
  username varchar(15),
  password varchar(100),
  enabled tinyint(1),
  PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25),
  FOREIGN KEY (username) references users(username)
) ;

CREATE TABLE carts (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(15),
  PRIMARY KEY (id)
);

CREATE TABLE cart_product (
  id int NOT NULL AUTO_INCREMENT,
  cart_id int,
  product_id int,
  PRIMARY KEY (id),
  foreign key (cart_id) references my_db.carts(id),
  foreign key (product_id) references my_db.products(id)
);
    
insert into my_db.users(username, password, enabled) 
values
	("anton", "{bcrypt}$2a$12$hPEVyjACot6eulgGiYbtmu028FYJsIy.RFhqXyEBiMMb6YNX/DmCS", 1),
	("ivan", "{bcrypt}$2a$12$Cpn5x2TmLZCNIi5y0z4oW.TPiUri9Bl8DIKylC/f3vuvXpCW8s/UW", 1),
    ("sasha", "{bcrypt}$2a$12$3hVrDHnEFMjnd.1GmNnaA.QUnV3XiVQPklg8KYtMYgaUpzmJqJcYW", 1);
    
insert into my_db.authorities (username, authority) 
values
	("anton", "ROLE_ADMIN"),
	("ivan", "ROLE_ADMIN"),
	("sasha", "ROLE_ADMIN");
    
insert into my_db.carts(username)
values
	("anton"),
    ("ivan"),
    ("sasha");
