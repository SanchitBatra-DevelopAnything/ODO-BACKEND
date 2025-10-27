create database ODO;
use ODO;

-- Table: Area
CREATE TABLE area (
    areaId CHAR(36) PRIMARY KEY,
    areaName VARCHAR(100) NOT NULL
);

-- Table: Admin
CREATE TABLE admin (
    adminId CHAR(36) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    type VARCHAR(50),
    areaId CHAR(36),
    FOREIGN KEY (areaId) REFERENCES area(areaId)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

insert into admin values('-OIRma3hOoRVvv_Ymnbb' , 'odo-admin' , 'odo@admin@123' , 'Super' , NULL);

CREATE TABLE orders (
    orderId CHAR(36) PRIMARY KEY, -- UUID
    gst VARCHAR(50),
    area VARCHAR(100),
    contact VARCHAR(15),
    deliveryLatitude VARCHAR(100),
    deliveryLongitude VARCHAR(100),
    deviceToken TEXT,
    items JSON,
    orderDate DATE,
    orderTime VARCHAR(1000),
    orderedBy VARCHAR(500),
    shop VARCHAR(500),
    shopAddress TEXT,
    totalPrice DECIMAL(10, 2),
    totalPriceAfterDiscount DECIMAL(10, 2),
    statusCode CHAR(1) CHECK (statusCode IN ('A', 'P'))
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
    FOREIGN KEY (areaId) REFERENCES area(areaId)
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

CREATE TABLE area_slab_item (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- UUID format

    itemId CHAR(36) NOT NULL,
    areaId CHAR(36),          -- Nullable, keep value even if area is deleted

    slab1Start DOUBLE,
    slab1End DOUBLE,
    slab1Discount DOUBLE,

    slab2Start DOUBLE,
    slab2End DOUBLE,
    slab2Discount DOUBLE,

    slab3Start DOUBLE,
    slab3End DOUBLE,
    slab3Discount DOUBLE,

    -- Ensure 1 slab entry per item-area pair
    UNIQUE (itemId, areaId),

    -- Foreign key to item table with cascade delete
    CONSTRAINT fk_areaSlabItem_item
        FOREIGN KEY (itemId) REFERENCES item(itemId)
        ON DELETE CASCADE,

    -- Foreign key to area table, nullify areaId if area is deleted
    CONSTRAINT fk_areaSlabItem_area
        FOREIGN KEY (areaId) REFERENCES area(areaId)
        ON DELETE SET NULL
);

CREATE TABLE cart (
    cartId CHAR(36) PRIMARY KEY,
    memberId CHAR(36) UNIQUE,
    cartItems JSON,
    CONSTRAINT fk_member_cart FOREIGN KEY (memberId) REFERENCES member(memberId) ON DELETE CASCADE
);

CREATE TABLE B2BBanners (
    bannerId CHAR(36) NOT NULL PRIMARY KEY,
    bannerName VARCHAR(255) NOT NULL,
    imageUrl TEXT
);

ALTER TABLE item
ADD COLUMN ItemDetails VARCHAR(5000);




