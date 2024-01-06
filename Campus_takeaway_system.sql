/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/16 22:54:25                          */
/*==============================================================*/


drop table if exists Comment CASCADE;

drop table if exists Customer CASCADE;

drop table if exists DeliveryStaff CASCADE;

drop table if exists Dish CASCADE;

drop table if exists Merchant CASCADE;

drop table if exists Merchant_dish CASCADE;

drop table if exists Orders CASCADE;

/*==============================================================*/
/* Table: Comment                                               */
/*==============================================================*/
create table Comment
(
   CommentID            int not null,
   DeliveryStaffID      int not null,
   CustomerID           int not null,
   MerchantID           varchar(50) not null,
   Content              varchar(1024),
   CreateTime           date,
   CommentIsDeleted     boolean,
   primary key (CommentID)
);

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table Customer
(
   CustomerID           int not null,
   CustomerIName        varchar(50),
   RealName             varchar(50),
   CustomerPassword     varchar(50),
   CustomerBirthday     date,
   CustomerSex          varchar(7),
   CustomerTelephone    varchar(20),
   CustomerEmail        varchar(128),
   CustomerStatus       boolean,
   profile_image_url    varchar(1024),
   primary key (CustomerID)
);

/*==============================================================*/
/* Table: DeliveryStaff                                         */
/*==============================================================*/
create table DeliveryStaff
(
   DeliveryStaffID      int not null,
   DeliveryStaffName    varchar(50),
   DeliveryStaffPassword varchar(50),
   DeliveryStaffBirthday date,
   DeliveryStaffSex     varchar(7),
   DeliveryStaffTelephone varchar(20),
   VehicleNumber        int,
   CurrentLocation      varchar(50),
   DeliveryStaffStatus  boolean,
   DeliveryStaffEmail   varchar(50),
   primary key (DeliveryStaffID)
);

/*==============================================================*/
/* Table: Dish                                                  */
/*==============================================================*/
create table Dish
(
   DishID               int not null,
   OrderID              varchar(50) not null,
   DishName             varchar(50),
   DishDescription      varchar(1024),
   Price                float,
   DishStatus           boolean,
   image_url            varchar(1024),
   primary key (DishID)
);

/*==============================================================*/
/* Table: Merchant                                              */
/*==============================================================*/
create table Merchant
(
   MerchantID           varchar(50) not null,
   MerchantName         varchar(50),
   AirlineName          varchar(50),
   MerchantLocation     varchar(50),
   MerchantEmail        varchar(50),
   MerchantStatus       boolean,
   logo_image_url       varchar(1024),
   MerchantTelephone    varchar(20),
   primary key (MerchantID)
);

/*==============================================================*/
/* Table: Merchant_dish                                         */
/*==============================================================*/
create table Merchant_dish
(
   DishID               int not null,
   MerchantID           varchar(50) not null,
   primary key (DishID, MerchantID)
);

/*==============================================================*/
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   OrderID              varchar(50) not null,
   CustomerID           int not null,
   DeliveryStaffID      int not null,
   OrderDate            date,
   Quantity             int,
   TotalPrice           float,
   delivery_image_url   varchar(1024),
   OrderIsDeleat        boolean,
   primary key (OrderID)
);

-- 删除 Orders 表中 CustomerID 列的非空约束
ALTER TABLE Orders
ALTER COLUMN CustomerID DROP NOT NULL;

-- 删除 Orders 表中 CustomerID 列的非空约束
ALTER TABLE Orders
ALTER COLUMN DeliveryStaffID DROP NOT NULL;

alter table Comment add constraint FK_Customer_comment foreign key (CustomerID)
      references Customer (CustomerID) on delete restrict on update restrict;

alter table Comment add constraint FK_DS_comment foreign key (DeliveryStaffID)
      references DeliveryStaff (DeliveryStaffID) on delete restrict on update restrict;

alter table Comment add constraint FK_Merchant_comment foreign key (MerchantID)
      references Merchant (MerchantID) on delete restrict on update restrict;

alter table Dish add constraint FK_Order_dish foreign key (OrderID)
      references Orders (OrderID) on delete restrict on update restrict;

alter table Merchant_dish add constraint FK_Merchant_dish foreign key (DishID)
      references Dish (DishID) on delete restrict on update restrict;

alter table Merchant_dish add constraint FK_Merchant_dish2 foreign key (MerchantID)
      references Merchant (MerchantID) on delete restrict on update restrict;

alter table Orders add constraint FK_customer_orders foreign key (CustomerID)
      references Customer (CustomerID) on delete restrict on update restrict;

alter table Orders add constraint FK_delivery_record foreign key (DeliveryStaffID)
      references DeliveryStaff (DeliveryStaffID) on delete restrict on update restrict;





/*==============================================================*/
/* INSERT INTO TEST DATA                                        */
/*==============================================================*/
/* 图片具体地址信息自行修改 */
/* 插入 Comment 表测试数据 */
INSERT INTO Comment (CommentID, DeliveryStaffID, CustomerID, MerchantID, Content, CreateTime, CommentIsDeleted)
VALUES
(1, 101, 1, 'M1', 'Good service!', '2023-12-20', false),
(2, 102, 2, 'M2', 'Prompt delivery!', '2023-12-20', false),
(3, 103, 3, 'M3', 'Nice food!', '2023-12-20', false);

/* 插入 Customer 表测试数据 */
INSERT INTO Customer (CustomerID, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url)
VALUES
(1, 'Customer1', 'RealName1', 'password1', '1990-01-01', 'Male', '1234567890', 'customer1@example.com', true, 'profile_image_url1'),
(2, 'Customer2', 'RealName2', 'password2', '1995-02-02', 'Female', '9876543210', 'customer2@example.com', true, 'profile_image_url2'),
(3, 'Customer3', 'RealName3', 'password3', '2000-03-03', 'Male', '11122334455', 'customer3@example.com', true, 'profile_image_url3');

/* 插入 DeliveryStaff 表测试数据 */
INSERT INTO DeliveryStaff (DeliveryStaffID, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail)
VALUES
(101, 'Staff1', 'password1', '1985-04-04', 'Male', '5556667777', 101, 'Location1', true, 'staff1@example.com'),
(102, 'Staff2', 'password2', '1990-05-05', 'Female', '8889990000', 102, 'Location2', true, 'staff2@example.com'),
(103, 'Staff3', 'password3', '1995-06-06', 'Male', '9990001111', 103, 'Location3', true, 'staff3@example.com');

/* 插入 Dish 表测试数据 */
INSERT INTO Dish (DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url)
VALUES
(1, '01', 'Dish1', 'Description1', 10.99, true, 'image_url1'),
(2, '02', 'Dish2', 'Description2', 15.99, true, 'image_url2'),
(3, '03', 'Dish3', 'Description3', 8.99, true, 'image_url3');

/* 插入 Merchant 表测试数据 */
INSERT INTO Merchant (MerchantID, MerchantName, AirlineName, MerchantLocation, MerchantEmail, MerchantStatus, logo_image_url, MerchantTelephone)
VALUES
('M1', 'Merchant1', 'Airline1', 'Location1', 'merchant1@example.com', true, 'logo_image_url1', '111-111-1111'),
('M2', 'Merchant2', 'Airline2', 'Location2', 'merchant2@example.com', true, 'logo_image_url2', '222-222-2222'),
('M3', 'Merchant3', 'Airline3', 'Location3', 'merchant3@example.com', true, 'logo_image_url3', '333-333-3333');

/* 插入 Merchant_dish 表测试数据 */
INSERT INTO Merchant_dish (DishID, MerchantID)
VALUES
(1, 'M1'),
(2, 'M2'),
(3, 'M3');

/* 插入 Orders 表测试数据 */
INSERT INTO Orders (OrderID, CustomerID, DeliveryStaffID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat)
VALUES
('01', 1, 101, '2023-12-20', 2, 21.98, 'delivery_image_url1', false),
('02', 2, 102, '2023-12-20', 3, 47.97, 'delivery_image_url2', false),
('03', 3, 103, '2023-12-20', 1, 8.99, 'delivery_image_url3', false);



/*==============================================================*/
/* INSERT INTO TEST DATA TWO                                    */
/*==============================================================*/
/* 图片具体地址信息自行修改 */
INSERT INTO Comment (CommentID, DeliveryStaffID, CustomerID, MerchantID, Content, CreateTime, CommentIsDeleted)
VALUES
(4, 104, 4, 'M4', 'Good service!', '2023-12-20', false),
(5, 105, 5, 'M5', 'Prompt delivery!', '2023-12-20', false),
(6, 106, 6, 'M6', 'Prompt delivery!', '2023-12-20', false),
(7, 107, 7, 'M7', 'Nice food!', '2023-12-20', false);

/* 插入 Merchant 表测试数据 */
INSERT INTO Merchant (MerchantID, MerchantName, AirlineName, MerchantLocation, MerchantEmail, MerchantStatus, logo_image_url, MerchantTelephone)
VALUES
('M4', 'Merchant4', 'Airline1', 'Location1', 'merchant1@example.com', true, 'logo_image_url1', '111-111-1111'),
('M5', 'Merchant5', 'Airline2', 'Location2', 'merchant2@example.com', true, 'logo_image_url2', '222-222-2222'),
('M6', 'Merchant6', 'Airline2', 'Location2', 'merchant2@example.com', true, 'logo_image_url2', '222-222-2222'),
('M7', 'Merchant7', 'Airline3', 'Location3', 'merchant3@example.com', true, 'logo_image_url3', '333-333-3333');

/* 插入 Merchant_dish 表测试数据 */
INSERT INTO Merchant_dish (DishID, MerchantID)
VALUES
(4, 'M4'),
(5, 'M5'),
(6, 'M6'),
(7, 'M7');

/* 插入 Customer 表测试数据 */
INSERT INTO Customer (CustomerID, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url)
VALUES
(4, 'Customer1', 'RealName1', 'password1', '1990-01-01', 'Male', '1234567890', 'customer1@example.com', true, 'profile_image_url1'),
(5, 'Customer2', 'RealName2', 'password2', '1995-02-02', 'Female', '9876543210', 'customer2@example.com', true, 'profile_image_url2'),
(6, 'Customer2', 'RealName2', 'password2', '1995-02-02', 'Female', '9876543210', 'customer2@example.com', true, 'profile_image_url2'),
(7, 'Customer3', 'RealName3', 'password3', '2000-03-03', 'Male', '11122334455', 'customer3@example.com', true, 'profile_image_url3');

/* 插入 DeliveryStaff 表测试数据 */
INSERT INTO DeliveryStaff (DeliveryStaffID, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail)
VALUES
(104, 'Staff1', 'password1', '1985-04-04', 'Male', '5556667777', 104, 'Location1', true, 'staff1@example.com'),
(105, 'Staff2', 'password2', '1990-05-05', 'Female', '8889990000', 105, 'Location2', true, 'staff2@example.com'),
(106, 'Staff2', 'password2', '1990-05-05', 'Female', '8889990000', 106, 'Location2', true, 'staff2@example.com'),
(107, 'Staff3', 'password3', '1995-06-06', 'Male', '9990001111', 107, 'Location3', true, 'staff3@example.com');

/* 插入 Orders 表测试数据 */
INSERT INTO Orders (OrderID, CustomerID, DeliveryStaffID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat)
VALUES
('04', 4, 104, '2023-12-20', 2, 21.98, '../img/yingmei.jpg', false),
('05', 5, 105, '2023-12-20', 3, 47.97, '../img/hutao.png', false),
('06', 6, 106, '2023-12-20', 3, 47.97, '../img/qtm.jpg', false),
('07', 7, 107, '2023-12-20', 1, 8.99, '../img/shengmu.jpg', false);

INSERT INTO Dish (DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url)
VALUES
(4, '04', 'Dish1', 'Description1', 10.99, true, '../img/yingmei.jpg'),
(5, '05', 'Dish1', 'Description1', 10.99, true, '../img/hutao.png'),
(6, '06', 'Dish1', 'Description1', 10.99, true, '../img/qtm.jpg'),
(7, '07', 'Dish1', 'Description1', 10.99, true, '../img/shengmu.jpg');
