create table POSITIONS (
ID int primary key not null,
POSITION_NAME text);

create table EMPLOYEE (
ID int primary key not null,
SURNAME varchar(20) not null,
NAME varchar(20) not null,
BIRTH_DATE date,
TELEPHONE varchar(20),
POSITION_ID int references POSITIONS,
SALARY real

);

create table INGREDIENTS (
ID int primary key not null,
NAME varchar(20)
);

create table STOCK (
INGREDIENT_ID int references INGREDIENTS,
QUANTITY int
);


create table DISHES (
ID int primary key not null,
CATEGORY varchar(20),
COST real,
WEIGHT int
);

create table DISH_INGREDIENTS (
DISH_ID int references DISHES,
INGREDIENT_ID int references INGREDIENTS,
QUANTITY real
);

create table ORDERS (
ID int primary key not null,
EMLOYEE_ID int references EMPLOYEE,
TABLE_NUMBER int
);

create table ORDERED_DISHES (
ORDER_ID int references ORDERS,
DISH_ID int references DISHES,
QUANTITY int
);



create table MENU (
ID int primary key not null,
MENU_NAME text
);

create table DISHES_IN_MENU (
DISH_ID int references DISHES,
MENU_ID int references MENU
);


create table PREPARED_DISHES (
ID int primary key not null,
DISHES_ID int references DISHES,
EMPLOYEE_ID int references EMPLOYEE,
ORDERS_ID int references ORDERS,
DATE date

);



INSERT INTO POSITIONS VALUES (1,'Manager'),(2,'Waiter'),(3,'Cook'),(4,'Dishwasher'),(5,'Cleaner');
INSERT INTO EMPLOYEE VALUES (1,'Ostapenko','Oksana','1985-05-13','+380442222222',1,20000.00),(2,'Svidersky','Leonid','1973-08-01','+380441111111',3,25000.00),(3,'Azimov','Anvar','1983-12-05','+380443333333',2,18000.00);
INSERT INTO INGREDIENTS VALUES (1,'Egg'),(2,'Milk'),(3,'Salt'),(4,'Pepper'),(5,'Olive oil');
INSERT INTO STOCK VALUES (1,30),(2,5),(3,1),(4,1),(5,4);
INSERT INTO DISHES VALUES (1,'Breakfast',40.00,250);
INSERT INTO DISH_INGREDIENTS VALUES (1,1,2),(1,2,50),(1,3,4),(1,4,2),(1,5,10);
INSERT INTO ORDERS VALUES (1,3,2),(2,3,1);
INSERT INTO ORDERED_DISHES VALUES (1,1,2),(2,1,1);
INSERT INTO MENU VALUES (1,'Breakfast Menu');
INSERT INTO DISHES_IN_MENU VALUES (1,1);
INSERT INTO PREPARED_DISHES VALUES (1,1,2,1,'2016-05-20'),(2,1,2,1,'2016-05-20');



