USE kosadb;

create table users (
	userid   		varchar(50)	  	primary key, 
	username		varchar(50)	  	not null,
	userpassword	varchar(50)	  	not null,
	userage			numeric(3)		not null,
	useremail		varchar(50)	  	not null
);
create table boards (
    bno             int             primary key AUTO_INCREMENT, /*AUTO_INCREMENT : 자동증가값*/
    btitle          varchar(100)    not null,
    bcontent        longtext        not null,
    bwriter         varchar(50)     not null,
    bdate           datetime        default now(),/*now() : 오라클에서 sysdate*/
    bfilename       varchar(50)     null,
    bfiledata		longblob		null
);
create table accounts (
  ano       varchar(20)   primary key,
  owner     varchar(20)   not null,
  balance   numeric       not null
);

insert into accounts (ano, owner, balance) 
values ('111-111-1111', '하여름', 1000000);

insert into accounts (ano, owner, balance) 
values ('222-222-2222', '한겨울', 0);itworld