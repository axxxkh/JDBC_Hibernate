CREATE DATABASE SkyLine;

USE SkyLine;

CREATE TABLE PLANES
(
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
MANUFACTURER VARCHAR(30),
MODEL VARCHAR(30),
ManufactureYear INT,
fuelConsumptionByMile DOUBLE,
fuelTankCapacity DOUBLE);

CREATE TABLE CARGOPLANES
(
ID INT NOT NULL,
loadCapacity double,
FOREIGN KEY(ID) REFERENCES PLANES(ID)
);

CREATE TABLE passengersPlanes
(
ID INT NOT NULL,
passengerCapacity INT,
FOREIGN KEY(ID) REFERENCES PLANES(ID)
);


DELIMITER //
CREATE PROCEDURE addCargoPlane(IN MANUFACTURER VARCHAR(30), IN MODEL VARCHAR(30), IN ManufactureYear int,
IN fuelConsumptionByMile double, IN fuelTankCapacity double, loadCapacity double)
BEGIN
DECLARE id int;
START TRANSACTION;

INSERT PLANES
(manufacturer, model, ManufactureYear, fuelConsumptionByMile, fuelTankCapacity )
VALUES (manufacturer, model, ManufactureYear, fuelConsumptionByMile, fuelTankCapacity );
SET id=@@IDENTITY;

INSERT CargoPlanes
(id, loadCapacity)
VALUES (id, loadCapacity);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE addPassengerPlane(IN MANUFACTURER VARCHAR(30), IN MODEL VARCHAR(30), IN ManufactureYear int,
IN fuelConsumptionByMile double, IN fuelTankCapacity double, passengerCapacity INT)
BEGIN
DECLARE id int;
START TRANSACTION;

INSERT PLANES
(manufacturer, model, ManufactureYear, fuelConsumptionByMile, fuelTankCapacity )
VALUES (manufacturer, model, ManufactureYear, fuelConsumptionByMile, fuelTankCapacity );
SET id=@@IDENTITY;

INSERT PassengersPlanes
(id, passengerCapacity)
VALUES (id, PassengerCapacity);
END //
DELIMITER ;

call addCargoPlane("C-130", "747", 1999, 13.5, 50000.0, 300.9);
call addCargoPlane("Cessna", "787", 1999, 13.5, 1000000.0, 150);

call addPassengerPlane("Boeing", "777", 2009, 10.5, 40000.0, 378);

SELECT * FROM CargoPlanes;

SELECT * FROM PassengersPlanes as p
JOIN Planes
on p.id=Planes.id;

SELECT * FROM CargoPlanes as p
JOIN Planes
on p.id=Planes.id;
