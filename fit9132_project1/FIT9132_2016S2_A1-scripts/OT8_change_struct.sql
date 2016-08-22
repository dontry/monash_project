-- OT8_change_structure.sql
-- Student ID: 
-- Student Name:

set echo on;

-- Write your code below
ALTER TABLE LOCATION
    ADD (
    DISABILITY_ACCESS VARCHAR(20) DEFAULT 'Unknown' NOT NULL
    );


set echo off;

