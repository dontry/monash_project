-- OT8_change_structure.sql
-- Student ID: 
-- Student Name:

set echo on;

-- Write your code below
ALTER TABLE LOCATION
    ADD (
    DISABILITY_ACCESS VARCHAR(20) DEFAULT 'Unknown' NOT NULL 
                      CHECK(DISABILITY_ACCESS IN ('Y', 'N', 'UNKNOWN'))
    );

COMMIT;
set echo off;

