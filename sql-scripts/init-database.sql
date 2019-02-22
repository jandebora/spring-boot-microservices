-- Creating Schemas
CREATE SCHEMA users;
CREATE SCHEMA cards;
-- Creating users
CREATE USER 'dbusers'@'localhost' IDENTIFIED BY 'dbuserspassword';
CREATE USER 'dbcards'@'localhost' IDENTIFIED BY 'dbcardspassword';
-- Giving appropriate access
GRANT ALL PRIVILEGES ON users. * TO 'dbusers'@'localhost';
GRANT ALL PRIVILEGES ON cards. * TO 'dbcards'@'localhost';

