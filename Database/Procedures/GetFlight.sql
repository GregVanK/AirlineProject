CREATE DEFINER=`root`@`localhost` PROCEDURE `GetFlight`(IN FlightNo_param INT)
BEGIN
SELECT * FROM flights
WHERE flights.FlightNo = FlightNo_param ;
END