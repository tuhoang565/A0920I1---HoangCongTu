drop database if exists cars;
create database cars;
create table cars.customers(
	customerNumber int unique not null,
    customerCompanyName varchar(50) not null,
    customerLastName varchar(50) not null,
    customerFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    postCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit double,
    constraint pk_customerNumber primary key customers(customerNumber)
);

create table cars.orders(
	orderNumber int unique not null,
    orderDate date not null,
    requiedDate date not null,
    shippedDate date not null,
    statusOrder varchar(15) not null,
    comments varchar(255),
    quantityOrder int not null,
    priceEach double not null,
    customerNumber int not null,
    constraint pk_orderNumber primary key orders(orderNumber),
    constraint fk_customerNumber foreign key(customerNumber) references customers(customerNumber)
);

create table cars.payments(
	customerNumber int not null,
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount double not null,
    constraint fk_customerNumber_payments foreign key(customerNumber) references customers(customerNumber)   
);

create table cars.productlines(
	productLine varchar(50) unique not null,
    textDescription text,
    image text,
    constraint pk_productLine primary key productlines(productLine)
);

create table cars.products(
	productCode varchar(15) unique not null,
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice double not null,
    MSRP double not null,
    productLine varchar(50) not null, 
    constraint pk_productCode primary key products(productCode),
    constraint fk_productLine foreign key(productLine) references productlines(productLine) 
);

create table cars.orderDetails(
	productCode varchar(15) not null,
    orderNumber int not null,
    constraint fk_productCode foreign key(productCode) references products(productCode),
    constraint fk_orderNumber foreign key(orderNumber) references orders(orderNumber)
);



create table cars.offices(
	officeCode varchar(10) unique not null,
    city varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),
    country varchar(50),
    postalCode varchar(15) not null,
    constraint pk_officeCode primary key offices(officeCode)
);

create table cars.employees(
	employeeNumber int unique not null,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null,
    salesRepEmployeeNumber int unique not null,
    reportTo int,
    officeCode  varchar(10) not null, 
    constraint pk_employeeNumber primary key employees(employeeNumber),
    constraint fk_salesRepEmployeeNumber foreign key(salesRepEmployeeNumber) references customers(customerNumber), 
    constraint fk_reportTo foreign key(reportTo) references employees(employeeNumber),
    constraint fk_officeCode foreign key(officeCode) references offices(officeCode)
);



