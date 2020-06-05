use imsdb;

Insert into customers (LastName, FirstName, Address)
values ("Smith", "John", "45 Lombard Street, London, NW5 3JK");
Insert into customers (LastName, FirstName, Address)
values ("Perrins", "Chris", "243 Regent Street, Manchester, M34 2N5");
Insert into customers (LastName, FirstName, Address)
values ("Barber", "Piers", "34 Coding Lane, Manchester, M34 3J5");

-- Create Customer
Insert into customers (LastName, FirstName, Address)
values ("Smith", "John", "80 Downing Street");

-- Read Customer
select * from customers where LastName = "Smith";

-- Update Customer
update customers set address = "Manchester" where customerid = 2;

-- Delete Customer
delete from customers where FirstName = "Cindy";

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

-- Create Items
Insert into items (ItemName, Price, QuantityOrdered)
values ("Chicken", 5.60, 1);

-- Read Items
select * from items where ItemName = "Sriracha";

-- Update Items
update items set QuantityOrdered = 10 where customerid= 3;

-- Delete Items
delete from items where ItemName = "Tiramisu";

Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (1,"2020-02-14", 3.00);
Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (2,"2020-03-15", 3.80);
Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (3,"2020-04-04", 5.60);

-- Create Orders
Insert into orders (fk_CustomerID, DatePlaced, OrderTotal)
values (1, "04-08-2019", 5.00);

-- Read Orders
select * from orders where DatePlaced = "08-09-2019";

-- Update Orders
update orders set fk_CustomerID = 3 where customerid = 2;

-- Delete Orders
delete from orders where OrderID = 2;

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


-- Create Orderline
Insert into orderline (fk_OrderID, fk_ItemID, QuantityOrdered)
values (2, 1, 3);

-- Read Orderline
select * from orderline where fk_OrderID = 2;

-- Update Orderline
update orderline set QuantityOrdered = 10 where fk_OrderId = 2;

-- Delete Orderline
delete from orderline where fk_OrderID = 2;