/*
CREATE DATABASE GrosseryStore;
USE GrosseryStore;
*/

-- DROP DATABASE GrosseryStore

--------------------------------------------

CREATE TABLE Products (
    Id INT PRIMARY KEY IDENTITY,
    [Name] VARCHAR(50) NOT NULL UNIQUE,
    Price INT NOT NULL DEFAULT(0),

    CONSTRAINT CK_Products_Name CHECK ([Name] != ''),
    CONSTRAINT CK_Products_Price CHECK (Price > 0)
);

INSERT INTO Products([Name], Price)
VALUES
('Bread', 50),
('Butter', 150),
('Milk', 100);

-- DROP TABLE Products
-- SELECT * FROM Products