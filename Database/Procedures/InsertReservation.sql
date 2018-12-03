CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertReservation`(	IN Status_param ENUM('Active','Canceled'),
										StartDate_param DateTime,
                                        EndDate_param DateTime,
                                        PassengerNo_param INT,
                                        TicketType_param ENUM('Adult','Child','Senior'),
                                        NonStopFlight_param BOOL,
                                        FlightClass_param ENUM('First','Economy','Business'),
                                        CreditType_param VARCHAR(128),
                                        CreditNo_param INT,
                                        CreditHolder_param VARCHAR(128),
                                        CreditExpDate_param DATE,
                                        CreditId_param INT(3),
                                        Address1_param VARCHAR(1024),
                                        Address2_param VARCHAR(1024),
                                        PostalCode_param VARCHAR(128),
                                        Country_param VARCHAR(128),
                                        TotalCost_param FLOAT,
                                        AirportTransportationCosts_param FLOAT,
                                        ExternalCosts_param FLOAT,
                                        OUT Id_out INT)
BEGIN
INSERT INTO `reservations`(Status,StartDate,EndDate,PassengerNo,TicketType,NonStopFlight,FlightClass,CreditType,CreditNo,CreditHolder,CreditExpDate,CreditId,Address1,Address2,PostalCode,Country,TotalCost,TransportationCosts,OtherFees)
VALUES(Status_param,StartDate_param,EndDate_param,PassengerNo_param,TicketType_param,NonStopFlight_param,FlightClass_param,CreditType_param,CreditNo_param,CreditHolder_param,CreditExpDate_param,CreditId_param,Address1_param,Address2_param,PostalCode_param,Country,TotalCost_param,AirportTransportationCosts_param,ExternalCosts_param);
SET Id_out = LAST_INSERT_ID();
    SELECT Id_out;
END