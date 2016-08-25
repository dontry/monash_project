-- OT10_delete.sql
-- Student ID: 
-- Student Name:

set echo on;

-- Write your code below

rem Because TABLE VEHICLE has dependencies(foreign keys) with 
rem TABLE VEHICLE_FEATURE, TRIP, MAINT_REP,
rem so we need to delete those dependent entries  first.

DELETE FROM  VEHICLE_FEATURE
WHERE VEH_VIN = 
    (SELECT VEH_VIN
     FROM VEHICLE 
     WHERE VEH_REGONUMBER = 'LL50JMB'
     );

DELETE FROM TRIP
WHERE VEH_VIN = 
    (SELECT VEH_VIN
     FROM VEHICLE
     WHERE VEH_REGONUMBER = 'LL50JMB'
    );

DELETE FROM MAINT_REP
WHERE VEH_VIN =
    (SELECT VEH_VIN
     FROM VEHICLE
     WHERE VEH_REGONUMBER = 'LL50JMB'
    );

DELETE FROM VEHICLE 
WHERE VEH_REGONUMBER = 'LL50JMB';

set echo off;