-- Creating Schemas
CREATE SCHEMA users;
CREATE SCHEMA cards;
-- Creating users
CREATE USER 'dbusers'@'%' IDENTIFIED BY 'dbuserspassword';
CREATE USER 'dbcards'@'%' IDENTIFIED BY 'dbcardspassword';
-- Giving appropriate access
GRANT ALL PRIVILEGES ON users.* TO 'dbusers'@'%';
GRANT ALL PRIVILEGES ON cards.* TO 'dbcards'@'%';
-- REFRESH
FLUSH PRIVILEGES;

