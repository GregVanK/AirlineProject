CREATE PROCEDURE `InsertTraveler` (	IN FName_param VARCHAR(128),
									MName_param VARCHAR(128),
                                    LName_param VARCHAR(128),
                                    Gender_param VARCHAR(128),
                                    PhoneNo_param INT,
                                    Passport_param VARCHAR(128),
                                    Birthday_param DATE,
                                    Email_param VARCHAR(128),
                                    OUT Id_out INT)
BEGIN
INSERT INTO `travelers` (FName,MName,Lname,Gender,PhoneNo,Passport,Birthday,Email)
VALUES (FName_param,MName_param,LName_param,Gender_param,PhoneNo_param,Passport_param,Birthday_param,Email_param);
SET Id_out = LAST_INSERT_ID();
    SELECT Id_out;
END