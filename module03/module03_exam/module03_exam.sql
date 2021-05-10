create database module03_exam;
use module03_exam;

create table product(
	product_id int(5) auto_increment,
    product_name varchar(50) not null, 
    product_price int(5) not null,
    product_discount int(5) not null,
    product_exist int(5) not null,
    constraint pk_product primary key product(product_id)
);

insert into product(product_name, product_price, product_discount, product_exist) values("iPhone 6", 1000, 10, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("iPhone 7", 2000, 5, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("iPhone 8", 3000, 15, 25);
insert into product(product_name, product_price, product_discount, product_exist) values("iPhone X", 10000, 10, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("iPhone XS", 1000, 10, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("Samsung A71", 1000, 10, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("Samsung M51", 2000, 20, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("Samsung S21", 1000, 10, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("Oppo F10", 2500, 20, 20);
insert into product(product_name, product_price, product_discount, product_exist) values("Oppo F7", 7000, 10, 20);

create table employee(
	employee_id int(5) auto_increment,
    employee_name varchar(50) not null,
    employee_birthday date not null,
    employee_address varchar(50) not null,
    constraint pk_employee primary key employee(employee_id)
);

insert into employee(employee_name, employee_birthday, employee_address) values("Anh","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Minh","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Duc","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Quang","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Ha","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Tam","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Thanh","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Tuan","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Lan","2000-12-20", "Da Nang");
insert into employee(employee_name,employee_birthday, employee_address) values("Binh","2000-12-20", "Da Nang");

create table customer(
	customer_id int(5) auto_increment,
    customer_name varchar(50) not null,
    customer_birthday date not null,
    customer_phone varchar(50) not null,
    customer_address varchar(50) not null,
    customer_email varchar(50) not null,
    constraint pk_customer primary key customer(customer_id)
);

insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Tu", "1999-02-02", "0123465789", "Hue", "tu@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Tung", "1999-02-02", "0123465789", "Hue", "tung@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Van", "1999-02-02", "0123465789", "Hue", "van@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Anh", "1999-02-02", "0123465789", "Hue", "anh@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Hue", "1999-02-02", "0123465789", "Hue", "hue@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Tri", "1999-02-02", "0123465789", "Hue", "tri@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Viet", "1999-02-02", "0123465789", "Hue", "viet@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Hoang", "1999-02-02", "0123465789", "Hue", "hoang@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Vinh", "1999-02-02", "0123465789", "Hue", "Vinh@gmail.com");
insert into customer(customer_name, customer_birthday, customer_phone, customer_address, customer_email) values ("Vu", "1999-02-02", "0123465789", "Hue", "Vu@gmail.com");

create table manage_order(
	manage_order_id int(5) auto_increment,
    payment varchar(50) not null,
    customer_id int(5) not null,
    employee_id int(5) not null,
    product_id int(5) not null,
    order_date date not null,
    diliver_date date not null,
    diliver_address varchar(50) not null,
    constraint pk_manage_order primary key manage_order(manage_order_id),
    constraint fk_manage_order_customer foreign key(customer_id) references customer(customer_id),
    constraint fk_manage_order_employee foreign key(employee_id) references employee(employee_id),
    constraint fk_manage_order_product foreign key(product_id) references product(product_id)
);

insert into manage_order(payment, customer_id, employee_id, product_id, order_date, diliver_date, diliver_address) values("Cash", 1, 1,1, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Credit", 2, 2,1, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Cash", 3, 3,1, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id, product_id,order_date, diliver_date, diliver_address) values("Credit", 4, 4,2, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id,order_date, diliver_date, diliver_address) values("Cash", 5, 5,2, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Credit", 6, 6,3, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id, product_id,order_date, diliver_date, diliver_address) values("Cash", 7, 7,3, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Credit", 8, 8,4, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Cash", 9, 9,5, "2020-03-03", "2020-04-04", "Da Nang");
insert into manage_order(payment, customer_id, employee_id,product_id, order_date, diliver_date, diliver_address) values("Credit", 10, 10,6, "2020-03-03", "2020-04-04", "Da Nang");

ALTER TABLE manage_order DROP FOREIGN KEY fk_manage_order_employee;
ALTER TABLE manage_order DROP FOREIGN KEY fk_manage_order_customer;
ALTER TABLE manage_order ADD CONSTRAINT fk_manage_order_employee FOREIGN KEY(employee_id) REFERENCES employee(employee_id);