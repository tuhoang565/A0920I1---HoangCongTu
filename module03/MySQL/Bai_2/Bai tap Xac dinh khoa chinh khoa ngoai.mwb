drop database if exists pratice_pk_fk;
create database pratice_pk_fk;
create table pratice_pk_fk.customers(
	customer_number int unique not null, 
    fullname varchar(255),
    address varchar(255),
    email varchar(255),
    phone varchar(255),    
    constraint pk_customernumber primary key(customer_number)
);

create table pratice_pk_fk.accounts(
	account_number int unique not null,
    account_type varchar(50),
    date_create date,
    balance double,
    customer_number int unique,
    constraint fk_customer_number foreign key (customer_number)  references customers(customer_number),
    constraint pk_account_number primary key(account_number)   
);

create table pratice_pk_fk.transactions(
	tran_number int unique not null,
    account_number int,
    date_transaction date,
    amounts double,
    descriptions varchar(100),
    constraint pk_tran_number primary key(tran_number),
    foreign key (account_number) references accounts(account_number)
);