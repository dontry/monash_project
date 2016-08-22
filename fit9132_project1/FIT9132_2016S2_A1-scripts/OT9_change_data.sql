-- OT9_change_data.sql
-- Student ID: 
-- Student Name:

set echo on;

-- Write your code below
UPDATE LOCATION
SET   DISABILITY_ACCESS = 'Available'
WHERE LOCATION_ID = 34 OR LOCATION_ID = 36;

UPDATE LOCATION
SET DISABILITY_ACCESS = 'Not Available'
WHERE LOCATION_ID = 40;
set echo off;