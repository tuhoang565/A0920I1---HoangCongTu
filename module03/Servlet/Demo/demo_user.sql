create database demo_user;
use demo_user;

create table users(
	id int(3) not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    country varchar(50),
    primary key (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');