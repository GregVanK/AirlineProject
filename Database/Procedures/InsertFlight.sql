CREATE PROCEDURE `InsertFlight` (	IN FlightNo_param INT,
									AirlineName_param VARCHAR(128),
                                    DepartureAirport_param VARCHAR(3),
                                    ArrivalAirport_param VARCHAR(3),
                                    DepartureDate_param DATETIME,
                                    ArrivalDate_param DATETIME,
                                    FlightTime_param TIME,
                                    Status_param VARCHAR(128),
                                    Seats_param INT(11),
                                    AvailableSeats_param INT(11),
                                    Price_param FLOAT
                                    )
BEGIN
INSERT INTO `flights`(	`FlightNo`,
						`AirlineName`,
                        `DepartureAirport`,
                        `ArrivalAirport`,
                        `DepartureDate`,
                        `ArrivalDate`,
                        `FlightTime`,
                        `Status`,
                        `Seats`,
                        `AvailableSeats`,
                        `Price`)
VALUES(	FlightNo_param,
		AirlineName_param,
        DepartureAirport_param,
        ArrivalAirport_param,
        DepartureDate_param,
        ArrivalDate_param,
        FlightTime_param,
        Status_param,
        Seats_param,
        AvailableSeats_param,
        Price_param);
END