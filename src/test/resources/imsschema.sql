drop database if exists testdb;
CREATE DATABASE IF NOT EXISTS testdb;
use testdb;
CREATE TABLE if not exists items (ItemID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ItemName VARCHAR(250) NOT NULL, Price DEC(7, 2) NOT NULL, QuantityOrdered int NOT NULL);
CREATE TABLE customers (CustomerID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, LastName VARCHAR(250) NOT NULL, FirstName VARCHAR(250) NOT NULL, Address VARCHAR(250) NOT NULL);
CREATE TABLE orders (OrderID int NOT NULL auto_increment PRIMARY KEY, fk_CustomerID int NOT NULL, DatePlaced DATE NOT NULL, OrderTotal dec(7,2) NOT NULL,FOREIGN KEY (fk_customerID) REFERENCES customers(CustomerID));
CREATE TABLE orderline (orderline_ID int NOT NULL auto_increment PRIMARY KEY, fk_OrderId int NOT NULL, fk_ItemId int NOT NULL, QuantityOrdered int, FOREIGN KEY (fk_OrderID) REFERENCES orders (OrderID), FOREIGN KEY (fk_ItemID) REFERENCES items (ItemID));