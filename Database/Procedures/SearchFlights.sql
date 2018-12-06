CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchFlights`(IN 	DepartureAirport_param VARCHAR(3),
										ArrivalAirport_param VARCHAR(3),
                                        DepatureDate_param DATETIME,
                                        ArrivalDate_param DATETIME,
                                        AvailableSeats_param INT)
BEGIN
SELECT * 
FROM Flights
WHERE (DepartureAirport_param IS NULL OR DepartureAirport = DepartureAirport_param) AND
		(ArrivalAirport_param IS NULL OR ArrivalAirport = ArrivalAirport_param) AND
        (DepatureDate_param IS NULL OR  CAST(DepartureDate AS DATE) = DepatureDate_param) AND
        (ArrivalDate_param IS NULL OR CAST(ArrivalDate AS DATE) = ArrivalDate_param) AND
        (AvailableSeats_param IS NULL OR AvailableSeats >= AvailableSeats_param);
END