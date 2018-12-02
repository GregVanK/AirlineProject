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
`DepartureDate` DATETIME NOT NULL,
`ArrivalDate` DATETIME NOT NULL,
`FlightTime` TIME NOT NULL,
`Status` VARCHAR(128) NOT NULL,
`Seats` INT NOT NULL,
`AvailableSeats` INT NOT NULL,
`Price` FLOAT NOT NULL,
PRIMARY KEY(`FlightNo`)
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
`Email` VARCHAR(128) NOT NULL
);

CREATE TABLE `Reservations`(
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Status` ENUM('Active', 'Canceled') NOT NULL,
`StartDate` DateTime NOT NULL,
`EndDate` DateTime NOT NULL,
`PassengerNo` INT NOT NULL,
`TicketType` ENUM('Adult', 'Child', 'Senior'),
`NonStopFlight` boolean,
`FlightClass` ENUM('First', 'Economy','Business'),
`CreditType` VARCHAR(128) NOT NULL,
`CreditNo` INT NOT NULL,
`CreditHolder` VARCHAR(128) NOT NULL,
`CreditExpDate` DATE NOT NULL,
`CreditId` INT(3) NOT NULL,
`Address1` VARCHAR(1024) NOT NULL,
`Address2` VARCHAR(1024),
`PostalCode` VARCHAR(128) NOT NULL,
`Country` VARCHAR(128) NOT NULL,
`TotalCost` FLOAT NOT NULL,
`AirportTransportationCosts` FLOAT NOT NULL,
`AdditionalCosts` FLOAT NOT NULL
);
CREATE TABLE `ReservationFlights`(
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE `ReservationTravelers`(
`Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

