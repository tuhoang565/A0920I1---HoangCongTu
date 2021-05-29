
delimiter  //
create procedure insert_customer(
	firstName varchar(255),
    lastName varchar(255),
    address varchar(255)
) 
begin
	insert into customers(id, firstName, lastName, address)
	select next_val, firstName, lastName, address from hibernate_sequence;
	update hibernate_sequence set next_val = next_val + 1;
end//

delimiter ;