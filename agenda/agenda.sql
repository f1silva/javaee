create database agenda;
use agenda;

CREATE TABLE contato	(
	id				int IDENTITY(1,1) PRIMARY KEY,
	nome			varchar(50) not null,
	telefone		int			not null,
	email			varchar(50) not null
	);
CREATE TABLE contato	(
	id				int IDENTITY(1,1) PRIMARY KEY,
	nome			varchar(255) not null,
	telefone		varchar(100) not null,
	email			varchar(100)
	);

	use agenda;
select * from contato order by 'id';

insert into contato (nome, telefone, email)
			VALUES ('Fernando Jose', '999999999', 'fernando@fernando');