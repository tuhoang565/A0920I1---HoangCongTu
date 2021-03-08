drop database if exists libraryManager;
create database libraryManager;
use libraryManager;

create table libraryCards(
	idLibraryCard int unique not null,
    nameStudent varchar(100) not null,
    birthday date not null,
    address varchar(100) not null,
    email varchar(100) not null,
    phoneNumber varchar(20) not null,
    image varchar(50) not null,
    constraint pk_idLibraryCard primary key libraryCard(idLibraryCard)
);
create table books(
	isbn int unique not null,
    nameBook varchar(255) not null,
    publisher varchar(100) not null,
    author varchar(100) not null,
    publishcationDate date not null,
    timesPulish int not null,
    price double not null,
    image varchar(50) not null,    
    idLibraryCard int unique not null,
    constraint pk_isbn primary key books(isbn),
    constraint fk_idLibraryCard foreign key(idLibraryCard) references libraryCards(idLibraryCard)
);

create table catelogies(
	idCategory int unique not null,
    nameCategory varchar(100) not null,
    constraint pk_idCategory primary key categories(idCategory)
);

create table bookCategory(
	isbn int unique not null,
    idCategory int unique not null,
    constraint fk_isbn foreign key(isbn) references books(isbn),
    constraint fk_idCategory foreign key(idCategory) references catelogies(idCategory)
);
create table students(
	studentNumber varchar(15) unique not null,
    studentName varchar(50) not null,
    addressStudent varchar(500) not null,
    email varchar(50) not null,
    image varchar(50) not null,
    idLibraryCard int unique not null,
    constraint pk_studentNumber primary key students(studentNumber),
    constraint fk_idLibraryCard_student foreign key(idLibraryCard) references libraryCards(idLibraryCard)
);

create table borrowOrders(
	idBorrowOrder int unique not null,
    dateBorrow date not null,
    datePay date not null,
    outOfDate varchar(50) not null,
    expense double,
    studentNumber varchar(15) unique not null,
    isbn int unique not null,
    constraint pk_idBorrowOrder primary key borrowOrders(idBorrowOrder),
    constraint fk_studentNumber foreign key(studentNumber) references students(studentNumber),
    constraint fk_isbn_borrowOrders foreign key(isbn) references books(isbn)
);
