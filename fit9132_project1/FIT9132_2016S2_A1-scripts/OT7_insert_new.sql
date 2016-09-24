-- OT7_new_insert.sql
-- Student ID: 
-- Student Name:

set echo on;

-- Write your code below
INSERT INTO LOCATION VALUES(
  LOCATION_SEQ.NEXTVAL, 
  'Athletes Village', 'Barra da Tijuca',
  'Rio de Janeiro',
  (SELECT LOCTYPE_ID
  FROM LOCATION_TYPE
  WHERE LOCTYPE_DESC = 'Olympic Venue')
  );
  
INSERT INTO LOCATION VALUES(
  LOCATION_SEQ.NEXTVAL,  
  'Rio16 Headquarters', 
  'Ave Pras Vargas, Cidade Nova', 'Rio de Janeiro', 
  (SELECT LOCTYPE_ID
  FROM LOCATION_TYPE
  WHERE LOCTYPE_DESC = 'Olympic Venue')
  );

COMMIT;




INSERT INTO TRIP VALUES (
  TRIP_SEQ.NEXTVAL,
  to_date ('09-08-2016 13:00','dd-mm-yyyy hh24:mi'),
  to_date ('09-08-2016 14:00','dd-mm-yyyy hh24:mi'),
  null,
  null,
  10000,
  10025,
  1,
  (SELECT VEH_VIN
   FROM VEHICLE
   WHERE VEH_REGONUMBER = 'LL50JMB'),
  (SELECT LOCATION_ID
   FROM LOCATION
   WHERE LOCATION_NAME = 'Galeao International Airport'),
  (SELECT LOCATION_ID
   FROM LOCATION
   WHERE LOCATION_NAME = 'Athletes Village'),
  (SELECT OFF_OLYMPIC_ID
   FROM OFFICIAL
   WHERE OFF_GIVENNAME = 'Andrew' AND OFF_FAMILYNAME = 'Gaze'),
   0023);
   
   
INSERT INTO TRIP VALUES (
    TRIP_SEQ.NEXTVAL,
    to_date ('08-08-2016 15:00','dd-mm-yyyy hh24:mi'),
    to_date ('08-08-2016 15:30','dd-mm-yyyy hh24:mi'),
    null,
    null,
    10025,
    10040,
    1,
    (SELECT VEH_VIN
     FROM VEHICLE
     WHERE VEH_REGONUMBER = 'LL50JMB'),
    (SELECT LOCATION_ID
     FROM LOCATION
     WHERE LOCATION_NAME = 'Galeao International Airport'),
    (SELECT LOCATION_ID
     FROM LOCATION
     WHERE LOCATION_NAME = 'Athletes Village'),
    (SELECT OFF_OLYMPIC_ID
     FROM OFFICIAL
     WHERE OFF_GIVENNAME = 'Andrew' AND OFF_FAMILYNAME = 'Gaze'),
    0023);

COMMIT;

set echo off;