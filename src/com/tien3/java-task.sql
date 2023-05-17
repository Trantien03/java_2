create table Type (
id int primary key identity(1,1),
name varchar(255)
);


create table Task (
id int primary key identity(1,1), 
name varchar(255) not null,
type int not null foreign key references Type(id),
date date not null check( date <= getdate() ),
time float not null,
assignee varchar(100) not null,
reviewer varchar(100) not null
);

create procedure addType
	@name varchar(255)
as
	insert into Type(name)
	values (@name);

exec AddType 'code'

select * from Type

create procedure deleteType
	@id int
as
	delete from Type where id = @id 

exec deleteType 1

create procedure displayType
as 
	select * from Type 

create procedure addTask
	@name varchar(255),
	@type int,
	@date date,
	@time float,
	@assignee varchar(100),
	@reviewer varchar(100)
as
	insert into Task( name, type, date, time, assignee, reviewer )
	values ( @name, @type, @date, @time, @assignee, @reviewer);
exec addTask 'Dev Program', 2, '2015-08-28', '8.0', 'Dev', 'Lead'


create procedure deleteTask
	@id int
as
	delete from Task where id = @id 
exec deleteTask 2 

create procedure displayTask 
as
	select * from Task