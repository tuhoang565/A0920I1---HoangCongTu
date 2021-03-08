use new_schema;
create table newTable(
	id int not null,
    nameStudent varchar(50) not null,
    age int not null,
    course varchar(10) not null,
    fee double not null
);

insert into newTable(id, nameStudent, age, course, fee) values(1, "Hoang", 21, "CNTT", 400000);
insert into newTable(id, nameStudent, age, course, fee) values(2, "Viet", 19, "DTVT", 500000);
insert into newTable(id, nameStudent, age, course, fee) values(3, "Thanh", 18, "KTDN", 600000);
insert into newTable(id, nameStudent, age, course, fee) values(4, "Nhan", 18, "CK", 700000);
insert into newTable(id, nameStudent, age, course, fee) values(5, "Huong", 19, "TCNH", 800000);
insert into newTable(id, nameStudent, age, course, fee) values(5, "Huong", 19, "TCNH", 900000);

select * from newTable
where nameStudent = "Huong";

select sum(fee) as TotalFee from newTable
where nameStudent = "Huong";

select distinct nameStudent from newTable;

