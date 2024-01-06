# SQL源码

```sql
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/20 20:14:50                          */
/*==============================================================*/


drop table if exists Comment;

drop table if exists Customer;

drop table if exists DeliveryStaff;

drop table if exists Dish;

drop table if exists Merchant;

drop table if exists Orders;

drop table if exists delivery_record;

/*==============================================================*/
/* Table: Comment                                               */
/*==============================================================*/
create table Comment
(
   CommentID            int not null,
   DeliveryStaffID      int not null,
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
   OrderID              varchar(50) not null,
   CommentID            int not null,
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
   DishID               int,
   CommentID            int not null,
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
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   OrderID              varchar(50) not null,
   CustomerID           int not null,
   DishID               int not null,
   OrderDate            date,
   Quantity             int,
   TotalPrice           float,
   delivery_image_url   varchar(1024),
   OrderIsDeleat        boolean,
   primary key (OrderID)
);

/*==============================================================*/
/* Table: delivery_record                                       */
/*==============================================================*/
create table delivery_record
(
   OrderID              varchar(50) not null,
   DeliveryStaffID      int not null,
   DeliveryTime         date,
   DeliveryStatus       varchar(50),
   primary key (OrderID, DeliveryStaffID)
);

alter table Comment add constraint FK_DS_comment foreign key (DeliveryStaffID)
references DeliveryStaff (DeliveryStaffID) on delete restrict on update restrict;
alter table Customer add constraint FK_Customer_comment foreign key (CommentID)
references Comment (CommentID) on delete restrict on update restrict;
alter table Customer add constraint FK_custimer_orders foreign key (OrderID)
references Orders (OrderID) on delete restrict on update restrict;
alter table Dish add constraint FK_Order_dish foreign key (OrderID)
references Orders (OrderID) on delete restrict on update restrict;
alter table Merchant add constraint FK_Merchant_comment foreign key (CommentID)
references Comment (CommentID) on delete restrict on update restrict;
alter table Merchant add constraint FK_Merchant_dish foreign key (DishID)
references Dish (DishID) on delete restrict on update restrict;
alter table Orders add constraint FK_Order_dish2 foreign key (DishID)
references Dish (DishID) on delete restrict on update restrict;
alter table Orders add constraint FK_custimer_orders2 foreign key (CustomerID)
references Customer (CustomerID) on delete restrict on update restrict;
alter table delivery_record add constraint FK_delivery_record foreign key (OrderID)
references Orders (OrderID) on delete restrict on update restrict;
alter table delivery_record add constraint FK_delivery_record2 foreign key (DeliveryStaffID)
references DeliveryStaff (DeliveryStaffID) on delete restrict on update restrict;
```

# 测试数据

**图片地址请自行修改**

```sql
/* 插入Comment表数据 */
INSERT INTO Comment (CommentID, DeliveryStaffID, Content, CreateTime, CommentIsDeleted)
VALUES
(1, 101, 'Good service!', '2023-12-20', false),
(2, 102, 'Prompt delivery!', '2023-12-20', false),
(3, 103, 'Nice food!', '2023-12-20', false);

/* 插入Customer表数据 */
INSERT INTO Customer (CustomerID, OrderID, CommentID, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url)
VALUES
(201, 'ORD001', 1, 'JohnDoe', 'John Doe', 'password123', '1990-01-01', 'Male', '1234567890', 'john.doe@example.com', true, 'profile.jpg'),
(202, 'ORD002', 2, 'JaneSmith', 'Jane Smith', 'pass321', '1985-05-15', 'Female', '9876543210', 'jane.smith@example.com', true, 'jane.jpg'),
(203, 'ORD003', 3, 'BobJohnson', 'Bob Johnson', 'secure456', '1995-08-20', 'Male', '5556667777', 'bob.johnson@example.com', true, 'bob.jpg');

/* 插入DeliveryStaff表数据 */
INSERT INTO DeliveryStaff (DeliveryStaffID, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail)
VALUES
(101, 'DavidDriver', 'driverpass', '1988-03-10', 'Male', '1112223333', 123, 'City Center', true, 'david.driver@example.com'),
(102, 'EmilyCourier', 'courierpass', '1992-06-25', 'Female', '4445556666', 456, 'Suburb Area', true, 'emily.courier@example.com'),
(103, 'MichaelDeliverer', 'deliverpass', '1995-11-15', 'Male', '7778889999', 789, 'Downtown', true, 'michael.deliverer@example.com');

/* 插入Dish表数据 */
INSERT INTO Dish (DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url)
VALUES
(301, 'ORD001', 'Spaghetti Bolognese', 'Classic Italian dish with meat sauce', 12.99, true, 'spaghetti.jpg'),
(302, 'ORD002', 'Chicken Curry', 'Spicy chicken curry with rice', 15.99, true, 'curry.jpg'),
(303, 'ORD003', 'Vegetarian Pizza', 'Pizza with assorted vegetables', 10.99, true, 'pizza.jpg');

/* 插入Merchant表数据 */
INSERT INTO Merchant (MerchantID, DishID, CommentID, MerchantName, AirlineName, MerchantLocation, MerchantEmail, MerchantStatus, logo_image_url, MerchantTelephone)
VALUES
('MID001', 301, 1, 'Italian Delight', 'Airline A', '123 Main Street', 'italian.delight@example.com', true, 'italian_logo.jpg', '111-222-3333'),
('MID002', 302, 2, 'Spice Kingdom', 'Airline B', '456 Spice Avenue', 'spice.kingdom@example.com', true, 'spice_logo.jpg', '444-555-6666'),
('MID003', 303, 3, 'Veggie Haven', 'Airline C', '789 Veggie Lane', 'veggie.haven@example.com', true, 'veggie_logo.jpg', '777-888-9999');

/* 插入Orders表数据 */
INSERT INTO Orders (OrderID, CustomerID, DishID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat)
VALUES
('ORD001', 201, 301, '2023-12-20', 2, 25.98, 'delivery1.jpg', false),
('ORD002', 202, 302, '2023-12-20', 1, 15.99, 'delivery2.jpg', false),
('ORD003', 203, 303, '2023-12-20', 3, 32.97, 'delivery3.jpg', false);

/* 插入delivery_record表数据 */
INSERT INTO delivery_record (OrderID, DeliveryStaffID, DeliveryTime, DeliveryStatus)
VALUES
('ORD001', 101, '2023-12-20', 'Delivered'),
('ORD002', 102, '2023-12-20', 'Delivered'),
('ORD003', 103, '2023-12-20', 'Delivered');

```

