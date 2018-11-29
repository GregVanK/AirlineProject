use airplaneticketdb;
DROP TABLE IF EXISTS `Travelers`;
DROP TABLE IF EXISTS `Flights`;
DROP TABLE IF EXISTS `Airports`;
CREATE TABLE `Airports`(
`Name` VARCHAR(128) NOT NULL,
`IATA` VARCHAR(3) PRIMARY KEY
);
INSERT INTO `airports`(`Name`,`IATA`)
VALUES('Adamsville Airport', 'AAP'),
('Freedom Flight', 'FFL'),
('Terrys Terminal', 'TTE');


CREATE TABLE `Flights`(
`FlightNo` INT NOT NULL,
`AirlineName` VARCHAR(128) NOT NULL,
`DepartureAirport` VARCHAR(3),
`ArrivalAirport` VARCHAR(3),
`DepartureDate` DATE NOT NULL,
`DepartureTime` TIME NOT NULL,
`ArrivalDate` DATE NOT NULL,
`ArrivalTime` TIME NOT NULL,
`FlightTime` TIME NOT NULL,
`Status` VARCHAR(128) NOT NULL,
`Seats` INT NOT NULL,
`AvailableSeats` INT NOT NULL,
`Price` FLOAT NOT NULL,
PRIMARY KEY(`FlightNo`),
CONSTRAINT `fk_flight_airport_iata_depart` FOREIGN KEY (`DepartureAirport`) REFERENCES `airports` (`IATA`),
CONSTRAINT `fk_flight_airport_iata_arrive` FOREIGN KEY (`ArrivalAirport`) REFERENCES `airports` (`IATA`)
);

CREATE TABLE `Travelers`(
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`FName` VARCHAR(128) NOT NULL,
`MName` VARCHAR(128) NOT NULL,
`Lname` VARCHAR(128) NOT NULL,
`Gender` VARCHAR(128) NOT NULL,
`PhoneNo` INT NOT NULL,
`Passport` VARCHAR(128) NOT NULL,
`Birthday` DATE NOT NULL,
`CreditType` VARCHAR(128) NOT NULL,
`CreditNo` INT NOT NULL,
`CreditHolder` VARCHAR(128) NOT NULL,
`CreditExpDate` DATE NOT NULL,
`CreditId` INT(3) NOT NULL,
`Address1` VARCHAR(1024) NOT NULL,
`Address2` VARCHAR(1024)NOT NULL,
`PostalCode` VARCHAR(128) NOT NULL,
`Country` VARCHAR(128) NOT NULL,
`Email` VARCHAR(128) NOT NULL
);