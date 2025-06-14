show databases;
create database ODO;
use ODO;

-- Table: Area
CREATE TABLE Area (
    areaId CHAR(36) PRIMARY KEY,
    areaName VARCHAR(100) NOT NULL
);

-- Table: Admin
CREATE TABLE Admin (
    adminId CHAR(36) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    type VARCHAR(50),
    areaId CHAR(36),
    FOREIGN KEY (areaId) REFERENCES Area(areaId)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

INSERT INTO Area (areaId, areaName) VALUES (UUID(), 'bulandshehar');

select * from area;

INSERT INTO Admin (adminId, username, password, type, areaId)
VALUES (UUID(), 'gandharvch', 'odo@admin', 'Sub', 'c85c45aa-4888-11f0-8029-19ac1666c193');

SELECT a.adminId, a.username, a.password, a.type,ar.areaName FROM admin a LEFT JOIN area ar ON a.areaId = ar.areaId;