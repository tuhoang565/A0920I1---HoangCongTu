create database module03_furama;
use module03_furama;

create table positionn(
	position_id int(10) auto_increment,
    position_name varchar(45),
    constraint pk_positionn primary key positionn(position_id)
);

create table education_degree(
	education_degree_id int(10) auto_increment,
    education_degree_name varchar(45),
    constraint pk_education primary key education_degree(education_degree_id)
);

create table division(
	division_id int(10) auto_increment,
    division_name varchar(45),
    constraint pk_division primary key division(division_id)
);

create table rolee(
	role_id int(10) auto_increment,
    role_name varchar(255),
    constraint pk_rolee primary key rolee(role_id)
);

create table userr(
	username varchar(255),
    password varchar(255),
    constraint pk_userr primary key userr(username)
);

create table user_role(
	role_id int(10) auto_increment,
    username varchar(255),
    constraint fk_role_id_user_role foreign key(role_id) references rolee(role_id),
    constraint fk_username_user_role foreign key(username) references userr(username)
);

create table attach_service(
	attach_service_id int(10) auto_increment,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int(10),
    constraint pk_attach_service primary key attach_service(attach_service_id)
);

create table rent_type(
	rent_type_id int(10) auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double,
    constraint pk_rent_type primary key rent_type(rent_type_id)
);

create table service_type(
	service_type_id int(10) auto_increment,
    service_type_name varchar(45),
    constraint pk_service_type primary key service_type(service_type_id)
);

create table customer_type(
	customer_type_id int(10) auto_increment,
    customer_type_name varchar(45),
    constraint pk_customer_type primary key customer_type(customer_type_id)
);

create table customer(
	customer_id int(10) auto_increment,
    customer_type_id int(10),
    customer_name varchar(45),
    customer_birthday date,
    customer_gender varchar(10),
    customer_id_card varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    constraint pk_customer primary key customer(customer_id),
    constraint fk_customer_type_id_customer foreign key(customer_type_id) references customer_type(customer_type_id)
);

ALTER TABLE customer DROP FOREIGN KEY fk_customer_type_id_customer;
ALTER TABLE customer DROP primary key;

create table employee(
	employee_id int(10) auto_increment,
    employee_name varchar(45),
    employee_birthday date,
    employee_id_card varchar(45),
    employee_salary double, 
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int(10),
    education_degree_id int(10),
    division_id int(10),
    username varchar(255),
    constraint pk_employee primary key employee(employee_id),
    constraint fk_position_id_employee foreign key(position_id) references positionn(position_id),
    constraint fk_education_degree_id_employee foreign key(education_degree_id) references education_degree(education_degree_id),
    constraint fk_division_id_employee foreign key(division_id) references division(division_id),
    constraint fk_user_employee foreign key(username) references userr(username)
);

create table service(
	service_id int(10),
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    constraint pk_service primary key service(service_id),
    constraint fk_rent_type_id_service foreign key(rent_type_id) references rent_type(rent_type_id),
    constraint fk_service_type_id foreign key(service_type_id) references service_type(service_type_id)
);
create table contract(
	contract_id int(10),
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int(10),
    customer_id int(10),
    service_id int(10),
    constraint pk_contract primary key contract(contract_id),
    constraint fk_emloyee_id_contract foreign key(employee_id) references employee(employee_id),
    constraint fk_customer_id_contract foreign key(customer_id) references customer(customer_id),
    constraint fk_service_id_contract foreign key(service_id) references service(service_id)
);
ALTER TABLE contract DROP FOREIGN KEY fk_customer_id_contract;
ALTER TABLE contract ADD FOREIGN KEY(customer_id) REFERENCES customer(customer_id);


create table contract_detail(
	contract_detail_id int(10),
    contract_id int(10),
    attach_service_id int(10),
    quantity int(10),
    constraint pk_contract_detail primary key contract_detail(contract_detail_id),
    constraint fk_contract_id_contract_detail foreign key(contract_id) references contract(contract_id),
    constraint fk_attach_service_id_contract_detail foreign key(attach_service_id) references attach_service(attach_service_id)
);

insert into customer_type(customer_type_id, customer_type_name) values (1, "Diamond");
insert into customer_type(customer_type_id, customer_type_name) values (2, "Platinum");
insert into customer_type(customer_type_id, customer_type_name) values (3, "Gold");
insert into customer_type(customer_type_id, customer_type_name) values (4, "Silver");
insert into customer_type(customer_type_id, customer_type_name) values (5, "Member");


insert into customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values(1, "Tu", "1990-02-20", "Male", "123456789", "0905050505", "tu@gmail.com", "Hue");













































