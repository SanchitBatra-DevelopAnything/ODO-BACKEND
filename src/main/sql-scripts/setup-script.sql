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

-- Table 2: member_notification
CREATE TABLE member_notification (
    notificationId CHAR(36) PRIMARY KEY,
    GST VARCHAR(255),
    areaId CHAR(36),
    contact VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    shop VARCHAR(100) NOT NULL,
    shopAddress VARCHAR(255) NOT NULL,
    deviceToken TEXT,
    latitude VARCHAR(50),
    longitude VARCHAR(50),
    FOREIGN KEY (areaId) REFERENCES Area(areaId)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE member (
    memberId CHAR(36) PRIMARY KEY,
    GST VARCHAR(255),
    areaId CHAR(36),
    contact VARCHAR(50),
    name VARCHAR(100),
    shop VARCHAR(100),
    shopAddress VARCHAR(255),
    deviceToken TEXT,
    latitude VARCHAR(50),
    longitude VARCHAR(50),
    FOREIGN KEY (areaId) REFERENCES area(areaId)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);