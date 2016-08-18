-- OT3_insert.sql
-- DO NOT CHANGE ANYTHING IN THIS SCRIPT

set echo on;


-- =======================================
-- COUNTRY 
-- =======================================
INSERT INTO COUNTRY VALUES ('ARG','Argentina');
INSERT INTO COUNTRY VALUES ('AUS','Australia');
INSERT INTO COUNTRY VALUES ('BEL','Belgium');
INSERT INTO COUNTRY VALUES ('BLR','Belarus');
INSERT INTO COUNTRY VALUES ('BRA','Brazil');
INSERT INTO COUNTRY VALUES ('CAN','Canada');
INSERT INTO COUNTRY VALUES ('CHN','China');
INSERT INTO COUNTRY VALUES ('DEN','Denmark');
INSERT INTO COUNTRY VALUES ('EGY','Egypt');
INSERT INTO COUNTRY VALUES ('ESP','Spain');
INSERT INTO COUNTRY VALUES ('FRA','France');
INSERT INTO COUNTRY VALUES ('GBR','Great Britain');
INSERT INTO COUNTRY VALUES ('GER','Germany');
INSERT INTO COUNTRY VALUES ('INA','Indonesia');
INSERT INTO COUNTRY VALUES ('IND','India');
INSERT INTO COUNTRY VALUES ('IRI','Iran');
INSERT INTO COUNTRY VALUES ('ITA','Italy');
INSERT INTO COUNTRY VALUES ('JPN','Japan');
INSERT INTO COUNTRY VALUES ('KSA','Saudi Arabia');
INSERT INTO COUNTRY VALUES ('MAS','Malaysia');
INSERT INTO COUNTRY VALUES ('NED','Netherlands');
INSERT INTO COUNTRY VALUES ('NZL','New Zealands');
INSERT INTO COUNTRY VALUES ('POR','Portugal');
INSERT INTO COUNTRY VALUES ('QAT','Qatar');
INSERT INTO COUNTRY VALUES ('RSA','South Africa');
INSERT INTO COUNTRY VALUES ('RUS','Rusia');
INSERT INTO COUNTRY VALUES ('SRI','Sri Lanka');
INSERT INTO COUNTRY VALUES ('TUR','Turkey');
INSERT INTO COUNTRY VALUES ('URU','Uruguay');
INSERT INTO COUNTRY VALUES ('USA','United States');
INSERT INTO COUNTRY VALUES ('VEN','Venezuela');

-- =======================================
-- IOC ROLE 
-- =======================================
INSERT INTO IOC_ROLE VALUES ('HC','Head Coach');
INSERT INTO IOC_ROLE VALUES ('JD','Judge');
INSERT INTO IOC_ROLE VALUES ('PS','Physician');
INSERT INTO IOC_ROLE VALUES ('MD','Media Communicator');
INSERT INTO IOC_ROLE VALUES ('LG','Logistic');

-- =======================================
-- LANGUAGE 
-- =======================================
INSERT INTO LANGUAGE VALUES ('AR','Arabic');
INSERT INTO LANGUAGE VALUES ('BE','Belarusian');
INSERT INTO LANGUAGE VALUES ('ZH','Chinese');
INSERT INTO LANGUAGE VALUES ('DA','Danish');
INSERT INTO LANGUAGE VALUES ('DE','German');
INSERT INTO LANGUAGE VALUES ('NL','Dutch');
INSERT INTO LANGUAGE VALUES ('EN','English');
INSERT INTO LANGUAGE VALUES ('FA','Persian');
INSERT INTO LANGUAGE VALUES ('FR','France');
INSERT INTO LANGUAGE VALUES ('HI','Hindi');
INSERT INTO LANGUAGE VALUES ('IT','Italian');
INSERT INTO LANGUAGE VALUES ('JA','Japanese');
INSERT INTO LANGUAGE VALUES ('MS','Malay');
INSERT INTO LANGUAGE VALUES ('RU','Russian');
INSERT INTO LANGUAGE VALUES ('ES','Spanish');
INSERT INTO LANGUAGE VALUES ('PT','Portuguese');


-- =======================================
-- OFFICIAL 
-- =======================================
INSERT INTO OFFICIAL VALUES ('AUS00101', 'Simon','Nathan','HC','AUS','EN');
INSERT INTO OFFICIAL VALUES ('AUS00102', 'William','Leung','HC','AUS','EN');
INSERT INTO OFFICIAL VALUES ('AUS00103', 'David','Hughes','PS','AUS','EN');
INSERT INTO OFFICIAL VALUES ('AUS00104', 'Mike','Tancred','MD','AUS','EN');
INSERT INTO OFFICIAL VALUES ('AUS00105', 'Lauren','Fitzgerald','LG','AUS','EN');
INSERT INTO OFFICIAL VALUES ('AUS00106', 'Andrew','Gaze','HC','AUS','EN');

INSERT INTO OFFICIAL VALUES ('JPN00101', 'Yamaguchi','Akibahara','HC','JPN','JA');
INSERT INTO OFFICIAL VALUES ('JPN00102', 'Nori','Yoshida','JD','JPN','JA');

INSERT INTO OFFICIAL VALUES ('CHN00101', 'Xi','Zhang','HC','CHN','ZH');
INSERT INTO OFFICIAL VALUES ('CHN00102', 'Cheng','Li','MD','CHN','ZH');


-- =======================================
-- DRIVER_AVAILABILITY
-- =======================================

INSERT INTO DRIVER_AVAILABILITY VALUES ('A','Available');
INSERT INTO DRIVER_AVAILABILITY VALUES ('S','Suspended');

-- =======================================
-- DRIVER
-- =======================================
INSERT INTO DRIVER VALUES (0021,'Peter','Lawrence','K11223344556677SWL',3,2,'A');
INSERT INTO DRIVER VALUES (0022,'Masimo','Catalan','C11223344556677SQW',3,1,'A');
INSERT INTO DRIVER VALUES (0023,'Mary','Choong','A11223344556677JQR',4,4,'A');
INSERT INTO DRIVER VALUES (0024,'Gabriel','Oliviera','G11223344556677OFB',4,1,'A');
INSERT INTO DRIVER VALUES (0025,'Joao','Silva','J11223344556677NMB',3,1,'A');
INSERT INTO DRIVER VALUES (0026,'Erick','Yuan','Y11223344556677JAR',2,1,'A');
INSERT INTO DRIVER VALUES (0027,'Miki','Cataldo','M11223344556677CTL',2,1,'A');
INSERT INTO DRIVER VALUES (0028,'Emily','Suzuki','E11223344556677SJQ',3,1,'A');


-- =======================================
-- DRIVER_LANGUAGE
-- =======================================

INSERT INTO DRIVER_LANGUAGE VALUES (0021,'EN');
INSERT INTO DRIVER_LANGUAGE VALUES (0021,'FR');

INSERT INTO DRIVER_LANGUAGE VALUES (0022,'IT');
INSERT INTO DRIVER_LANGUAGE VALUES (0022,'ES');

INSERT INTO DRIVER_LANGUAGE VALUES (0023,'EN');

INSERT INTO DRIVER_LANGUAGE VALUES (0024,'ES');

INSERT INTO DRIVER_LANGUAGE VALUES (0025,'ES');
INSERT INTO DRIVER_LANGUAGE VALUES (0025,'EN');

INSERT INTO DRIVER_LANGUAGE VALUES (0026,'ZH');
INSERT INTO DRIVER_LANGUAGE VALUES (0026,'EN');

INSERT INTO DRIVER_LANGUAGE VALUES (0027,'IT');
INSERT INTO DRIVER_LANGUAGE VALUES (0027,'ES');

INSERT INTO DRIVER_LANGUAGE VALUES (0028,'EN');
INSERT INTO DRIVER_LANGUAGE VALUES (0028,'JA');


-- =======================================
-- LOCATION_TYPE
-- =======================================
INSERT INTO LOCATION_TYPE VALUES (001,'Hotel');
INSERT INTO LOCATION_TYPE VALUES (002,'Olympic Venue');
INSERT INTO LOCATION_TYPE VALUES (003,'Airport');
INSERT INTO LOCATION_TYPE VALUES (004,'Restaurant');
INSERT INTO LOCATION_TYPE VALUES (005,'Private Address');
INSERT INTO LOCATION_TYPE VALUES (006,'Unspecified');

-- =======================================
-- LOCATION
-- =======================================
INSERT INTO LOCATION VALUES (34,'Condominio Reserva Jardim','Av. Vice Pres. Jose Alencar, 1500-Jacarepague', 'Rio de Janeiro', 001);
INSERT INTO LOCATION VALUES (35,'Belmond Copacabana Palace','Av. Atlantica,1702-Copacabana', 'Rio de Janeiro', 001);
INSERT INTO LOCATION VALUES (36,'Casa Amarelo','R. Joaquim Murtinho,569-Santa Teresa', 'Rio de Janeiro', 001);

INSERT INTO LOCATION VALUES (39,'Maria Lenk Aquatics Centre','Av. Embaixador Abelardo Bueno,3401-Barra da Tijuca', 'Rio de Janeiro', 002);
INSERT INTO LOCATION VALUES (40,'Olympic Stadium','Rua Arquias Cordeiro,1100-Engenho de Dentro', 'Rio de Janeiro', 002);
INSERT INTO LOCATION VALUES (41,'Whitewater Stadium','E. Marechal Alencastro,1357-Ricardo de Albuquerque', 'Rio de Janeiro', 002);

INSERT INTO LOCATION VALUES (1,'Galeao International Airport','Av. Vinte de Janeiro, s/n - Ilha do Governador', 'Rio de Janeiro', 003);


-- =======================================
-- VEH_AVAILABILITY
-- =======================================

INSERT INTO VEH_AVAILABILITY VALUES ('A','Available');
INSERT INTO VEH_AVAILABILITY VALUES ('R','Rented');
INSERT INTO VEH_AVAILABILITY VALUES ('M','Under Maintenace');

-- =======================================
-- VEHICLE
-- =======================================
INSERT INTO VEHICLE VALUES ('SANFDAE11U1286116','LA51ABC','Volvo','XC90 Momentum','White',589,4,'A');
INSERT INTO VEHICLE VALUES ('SB2252300ADT00644','LL50JMB','Audi','A1','Silver',3500,3,'A');
INSERT INTO VEHICLE VALUES ('SD2252300BDU00040','LC68RAF','Citreon','DS3','White',2789,5,'A');
INSERT INTO VEHICLE VALUES ('SK30URHHAAS217472','YK02OML','Peugeot','3008','Black',1258,7,'A');
INSERT INTO VEHICLE VALUES ('SMNFDAE11U1286256','LM10KLI','Ford','Transit 470E','White',12309,2,'A');
INSERT INTO VEHICLE VALUES ('SM30URHHAAS153052','LL67DEG','Ford','Transit 350L','White',3481,2,'A');
INSERT INTO VEHICLE VALUES ('SB2252300ADT01359','LL51KNC','Audi','A1','Silver',4600,3,'A');

-- =======================================
-- TRIP
-- =======================================

INSERT INTO TRIP VALUES (001234,to_date ('07-08-2016 13:00','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 13:30','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 13:05','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 13:43','dd-mm-yyyy hh24:mi'),1305,1326,4,'SK30URHHAAS217472',34,39,'AUS00102',0023);
INSERT INTO TRIP VALUES (001235,to_date ('07-08-2016 20:00','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 21:30','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 20:12','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 21:57','dd-mm-yyyy hh24:mi'),2794,2864,5,'SD2252300BDU00040',1,36,'CHN00101',0026);
INSERT INTO TRIP VALUES (001236,to_date ('08-08-2016 08:00','dd-mm-yyyy hh24:mi'),to_date ('08-08-2016 08:45','dd-mm-yyyy hh24:mi'),to_date ('08-08-2016 08:00','dd-mm-yyyy hh24:mi'),null,9880,null,2,'SB2252300ADT00644',35,41,'JPN00102',0028);
INSERT INTO TRIP VALUES (001237,to_date ('08-08-2016 08:30','dd-mm-yyyy hh24:mi'),to_date ('08-08-2016 09:15','dd-mm-yyyy hh24:mi'),null,null,null,null,2,'SB2252300ADT01359',41,39,'AUS00103',0023);
INSERT INTO TRIP VALUES (001238,to_date ('08-08-2016 15:00','dd-mm-yyyy hh24:mi'),to_date ('07-08-2016 15:10','dd-mm-yyyy hh24:mi'),null,null,null,null,1,'SM30URHHAAS153052',40,34,'AUS00105',0021);
INSERT INTO TRIP VALUES (001239,to_date ('09-08-2016 07:00','dd-mm-yyyy hh24:mi'),to_date ('09-08-2016 07:40','dd-mm-yyyy hh24:mi'),null,null,null,null,6,'SK30URHHAAS217472',34,40,'AUS00101',0023);
INSERT INTO TRIP VALUES (001240,to_date ('09-08-2016 07:00','dd-mm-yyyy hh24:mi'),to_date ('09-08-2016 07:50','dd-mm-yyyy hh24:mi'),null,null,null,null,2,'SMNFDAE11U1286256',36,39,'CHN00101',0026);
INSERT INTO TRIP VALUES (001241,to_date ('09-08-2016 15:45','dd-mm-yyyy hh24:mi'),to_date ('09-08-2016 17:00','dd-mm-yyyy hh24:mi'),null,null,null,null,2,'SMNFDAE11U1286256',39,36,'CHN00102',0026);
INSERT INTO TRIP VALUES (001242,to_date ('09-08-2016 16:00','dd-mm-yyyy hh24:mi'),to_date ('09-08-2016 17:00','dd-mm-yyyy hh24:mi'),null,null,null,null,4,'SK30URHHAAS217472',40,34,'AUS00101',0023);
INSERT INTO TRIP VALUES (001243,to_date ('09-08-2016 16:00','dd-mm-yyyy hh24:mi'),to_date ('09-08-2016 16:45','dd-mm-yyyy hh24:mi'),null,null,null,null,4,'SD2252300BDU00040',41,35,'JPN00101',0028);

-- =======================================
-- FEATURE
-- =======================================

INSERT INTO FEATURE VALUES ('BS', 'Large Boot Space');
INSERT INTO FEATURE VALUES ('AP', 'Armour Plating');
INSERT INTO FEATURE VALUES ('TB', 'Total Blackout');
INSERT INTO FEATURE VALUES ('WF', 'Mobile WiFi');
INSERT INTO FEATURE VALUES ('ET', 'Electric Tail Lift');
INSERT INTO FEATURE VALUES ('CO', 'Carry Long Objects');
INSERT INTO FEATURE VALUES ('GT', 'GPS Tracking');

-- =======================================
-- VEHICLE_FEATURE
-- =======================================

INSERT INTO VEHICLE_FEATURE VALUES ('SANFDAE11U1286116','BS');
INSERT INTO VEHICLE_FEATURE VALUES ('SANFDAE11U1286116','AP');
INSERT INTO VEHICLE_FEATURE VALUES ('SANFDAE11U1286116','TB');

INSERT INTO VEHICLE_FEATURE VALUES ('SD2252300BDU00040','WF');
INSERT INTO VEHICLE_FEATURE VALUES ('SD2252300BDU00040','TB');

INSERT INTO VEHICLE_FEATURE VALUES ('SK30URHHAAS217472','BS');


INSERT INTO VEHICLE_FEATURE VALUES ('SMNFDAE11U1286256','ET');
INSERT INTO VEHICLE_FEATURE VALUES ('SMNFDAE11U1286256','CO');
INSERT INTO VEHICLE_FEATURE VALUES ('SMNFDAE11U1286256','GT');

INSERT INTO VEHICLE_FEATURE VALUES ('SM30URHHAAS153052','ET');
INSERT INTO VEHICLE_FEATURE VALUES ('SM30URHHAAS153052','CO');

INSERT INTO VEHICLE_FEATURE VALUES ('SB2252300ADT01359','AP');
INSERT INTO VEHICLE_FEATURE VALUES ('SB2252300ADT01359','TB');
INSERT INTO VEHICLE_FEATURE VALUES ('SB2252300ADT01359','GT');


-- =======================================
-- MAINT_REP
-- =======================================

INSERT INTO MAINT_REP VALUES (1,to_date('27-APR-2016','dd-mon-yyyy'),3501,310.00,'Seat Belt Inspection','SB2252300ADT01359');

INSERT INTO MAINT_REP VALUES (2,to_date('10-OCT-2015','dd-mon-yyyy'),5030,795.50,'Regular Maintenance','SMNFDAE11U1286256');
INSERT INTO MAINT_REP VALUES (3,to_date('21-MAY-2016','dd-mon-yyyy'),10245,600.00,'Regular Maintenance','SMNFDAE11U1286256');
INSERT INTO MAINT_REP VALUES (4,to_date('26-JUN-2016','dd-mon-yyyy'),11230,825.00,'Brake Pad Replacement','SMNFDAE11U1286256');

-- =======================================
-- TRAINING
-- =======================================

INSERT INTO TRAINING VALUES ('VIP','Transport of VIPs');
INSERT INTO TRAINING VALUES ('AID','First Aid Training');
INSERT INTO TRAINING VALUES ('SEC','Security Training');


-- =======================================
-- DRIVER_TRAINING
-- =======================================
INSERT INTO DRIVER_TRAINING VALUES (0021,'VIP',to_date('03-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0022,'VIP',to_date('03-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0023,'VIP',to_date('03-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0024,'VIP',to_date('10-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0025,'VIP',to_date('10-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0026,'VIP',to_date('10-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0027,'VIP',to_date('19-JAN-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0028,'VIP',to_date('28-APR-2016','dd-mon-yyyy'));

INSERT INTO DRIVER_TRAINING VALUES (0021,'AID',to_date('20-JAN-2016','dd-mon-yyyy'));

INSERT INTO DRIVER_TRAINING VALUES (0023,'SEC',to_date('03-FEB-2014','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0023,'SEC',to_date('28-MAR-2016','dd-mon-yyyy'));
INSERT INTO DRIVER_TRAINING VALUES (0023,'AID',to_date('20-JAN-2016','dd-mon-yyyy'));

COMMIT;

set echo off;