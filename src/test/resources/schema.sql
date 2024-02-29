drop table if exists Software;

create table if not exists Software(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    employee VARCHAR (30),
    software VARCHAR (50),
    availability VARCHAR (3),
    renewal VARCHAR (10)
);

drop table if exists Hardware;

create table if not exists Hardware(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    employee VARCHAR (30),
    hardware VARCHAR (50),
    availability VARCHAR (3),
    checkin VARCHAR (10)
);

DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    userNumber INT NOT NULL,
    accountType VARCHAR (30) NOT NULL,
    gender VARCHAR (30) NOT NULL,
    contactNumber INT NOT NULL,
    address VARCHAR (30) NOT NULL,
    email VARCHAR (30) NOT NULL,
    birthday DATE DEFAULT NULL
);