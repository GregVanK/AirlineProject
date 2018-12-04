CREATE PROCEDURE `UpdateFlight` (IN FlightNo_param INT, DepartureDate_param VARCHAR(128),ArrivalDate_param VARCHAR(128), Status_param ENUM('Open','Completed','Canceled','In Transit','Delayed'), Seats_param INT, AvailableSeats_param INT, Price_param FLOAT)
BEGIN
UPDATE flights
Set DepartureDate = DepartureDate_param, ArrivalDate = ArrivalDate_param, flights.`Status` = Status_param, Seats = Seats_param, AvailableSeats = AvailableSeats_param, Price = Price_param
WHERE FlightNo = FlightNo_param;
END