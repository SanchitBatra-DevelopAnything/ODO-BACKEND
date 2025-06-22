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

CREATE TABLE cart (
    cartId CHAR(36) PRIMARY KEY,
    memberId CHAR(36) NOT NULL,

    CONSTRAINT fk_member
        FOREIGN KEY (memberId)
        REFERENCES member(memberId)
        ON DELETE CASCADE
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




CREATE TABLE brand (
    brandId CHAR(36) PRIMARY KEY,
    brandName VARCHAR(255),
    imageUrl TEXT,
    sortOrder INT
);

CREATE TABLE category (
    categoryId CHAR(36) PRIMARY KEY,
    categoryName VARCHAR(255),
    imageUrl TEXT
);

CREATE TABLE item (
    itemId CHAR(36) PRIMARY KEY,
    imgUrl TEXT NOT NULL,
    itemName VARCHAR(255) NOT NULL,
    itemPrice DOUBLE NOT NULL,
    itemPriceGST DOUBLE NOT NULL,

    slab1Discount DOUBLE,
    slab1Start DOUBLE,
    slab1End DOUBLE,

    slab2Discount DOUBLE,
    slab2Start DOUBLE,
    slab2End DOUBLE,

    slab3Discount DOUBLE,
    slab3Start DOUBLE,
    slab3End DOUBLE,

    brandId CHAR(36),
    categoryId CHAR(36),
    CONSTRAINT fk_brand FOREIGN KEY (brandId) REFERENCES brand(brandId) ON DELETE SET NULL,
    CONSTRAINT fk_category FOREIGN KEY (categoryId) REFERENCES category(categoryId) ON DELETE SET NULL
);


