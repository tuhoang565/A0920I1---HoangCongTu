delimiter $$
create procedure getAllStudent()
begin
	select * from student;
end$$
delimiter ;

delimiter $$
create procedure getStudentById(in student_id varchar(50))
begin
	select * from student
    where student.id = student_id;
end$$
delimiter ;



delimiter $$
create procedure insertStudent(
	in student_id varchar(50),
    in student_name varchar(50),
    in student_age int, 
    in student_address varchar(50)
)
begin
	insert into student(id, name, age, address) values(student_id, student_name, student_age, student_address);
end$$
delimiter ;

delimiter $$
create procedure showStudent()
begin
	select * from student;
end$$
delimiter ;

delimiter $$
create procedure deleteStudent(in student_id varchar(50))
begin
	delete from student where student.id = student_id;
end$$
delimiter ;


delimiter $$
create procedure editStudent(
	in student_id varchar(50),
	in student_name varchar(50),
    in student_age int,
    in student_address varchar(50)
)
begin
	update student_table 
    set student.name = student_name,
    student.age = student_age,
    student.address = student_address
    where student.id = student_id;
end$$
delimiter ;