CREATE DATABASE DBSales;
USE DBSales;

CREATE TABLE Productos(
	Clave INT NOT NULL PRIMARY KEY,
	Descripcion VARCHAR(100),
	Precio DECIMAL(8,2),
	Cantidad INT
);

CREATE TABLE Usuarios(
	Clave INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	Usuario VARCHAR(20),
	ClaveUser VARCHAR(20),
	Rol INT,
	Salario DECIMAL(8,2),
	Comision DECIMAL(8,2)
);

CREATE TABLE Ventas(
	Clave INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	Fecha DATETIME,
	Vendedor INT NOT NULL FOREIGN KEY REFERENCES Usuarios(Clave)
);

CREATE TABLE DetalleVenta(
	Clave INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	ClaveProducto INT NOT NULL FOREIGN KEY REFERENCES Productos(Clave),
	ClaveVenta INT NOT NULL FOREIGN KEY REFERENCES Ventas(Clave),
	Cantidad INT
);

CREATE TABLE DetallePaquete(
	Clave INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	ClaveProducto INT NOT NULL FOREIGN KEY REFERENCES Productos(Clave),
	ProductoPaquete INT NOT NULL FOREIGN KEY REFERENCES Productos(Clave),
	Cantidad INT
);

ALTER TABLE Productos ADD Tipo INT;
UPDATE Productos SET Tipo = 0;

INSERT INTO Usuarios VALUES('Admon1', '12345', 0, 2000, 0);
Select * From Usuarios
DELETE FROM Usuarios

DROP DATABASE DBSales;

drop TABLE DetalleVenta;
drop table Ventas;
drop table Usuarios;
drop table Productos;