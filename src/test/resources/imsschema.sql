CREATE DATABASE testdb;
use imsdb;

CREATE TABLE customers (
	CustomerID int NOT NULL auto_increment PRIMARY KEY,
    LastName varchar(250) NOT NULL,
    FirstName varchar(250) NOT NULL,
    Address varchar(250)
);

CREATE TABLE items (
	ItemID int NOT NULL auto_increment PRIMARY KEY,
    ItemName varchar(250) NOT NULL,
    Price dec(7,2) NOT NULL,
    QuantityOrdered int NOT NULL
);

CREATE TABLE orders (
	OrderID int NOT NULL auto_increment PRIMARY KEY,
    fk_CustomerID int NOT NULL,
    DatePlaced DATE NOT NULL,
    OrderTotal dec(7,2) NOT NULL,
    FOREIGN KEY (fk_customerID) REFERENCES customers(CustomerID)
);

CREATE TABLE orderline (
	orderline_ID int NOT NULL auto_increment PRIMARY KEY,
    fk_OrderId int NOT NULL,
    fk_ItemId int NOT NULL,
    QuantityOrdered int,
    FOREIGN KEY (fk_OrderID) REFERENCES orders (OrderID),
    FOREIGN KEY (fk_ItemID) REFERENCES items (ItemID)
);


Insert into customers (LastName, FirstName, Address)
values ("Smith", "John", "45 Lombard Street, London, NW5 3JK");
Insert into customers (LastName, FirstName, Address)
values ("Perrins", "Chris", "243 Regent Street, Manchester, M34 2N5");
Insert into customers (LastName, FirstName, Address)
values ("Barber", "Piers", "34 Coding Lane, Manchester, M34 3J5");

Select * FROM customers;

Insert into items (ItemName, Price, QuantityOrdered)
values ("Sriracha", 3.00, 1);
Insert into items (ItemName, Price, QuantityOrdered)
values ("Eggs", 1.50, 2);
Insert into items (ItemName, Price, QuantityOrdered) 
values ("Soy Sauce", 2.30, 1);
Insert into items (ItemName, Price, QuantityOrdered)
values ("Bread", 5.50, 3);
Insert into items (ItemName, Price, QuantityOrdered)
values ("Sausages", 2.60, 2);
Insert into items (ItemName, Price, QuantityOrdered)
values ("Flour", 3.00, 2);

select * from items;

Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (1,"2020-02-14", 3.00);
Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (2,"2020-03-15", 3.80);
Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (3,"2020-04-04", 5.60);

select * from orders;

Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (1, 1, 1);
Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (2, 2, 1);
Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (2, 3, 1);
Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (3, 5, 1);
Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (3, 6, 1);

select * from orderline;

