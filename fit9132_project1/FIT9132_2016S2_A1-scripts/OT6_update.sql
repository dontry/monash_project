-- OT6_update.sql
-- Student ID: 
-- Student Name:


set echo on;
-- Write your code below
UPDATE  TRIP  
SET TRIP_START_ACTUAL = to_date('8-August-2016 8:00', 'dd-Mon-yyyy hh12:mi'), 
    TRIP_END_ACTUAL = to_date('8-August-2016 9:00', 'dd-Mon-yyyy hh12:mi'), 
    TRIP_START_KM = 9880, TRIP_END_KM = 10000
WHERE VEH_VIN = 
    (SELECT VEH_VIN
     FROM VEHICLE
     WHERE VEH_REGONUMBER = 'LL50JMB'
    );

rem check whether the trip table is updated
SELECT TRIP_ID, to_char(TRIP_START_ACTUAL, 'dd-Mon-yyyy hh12:mi'),
      to_char(TRIP_END_ACTUAL, 'dd-Mon-yyyy hh12:mi')
FROM TRIP
WHERE  VEH_VIN = 
    (SELECT VEH_VIN
     FROM VEHICLE
     WHERE VEH_REGONUMBER = 'LL50JMB'
    );

set echo off;
