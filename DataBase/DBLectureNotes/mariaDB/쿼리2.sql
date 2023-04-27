create schema kosakosa;
create user 'KOSA'@'%' identified by '1004';
grant all privileges on kosakosa.* to 'KOSA'@'%';
flush privileges;
show grants for 'KOSA'@'%';

use kosakosa;
deptcreate table dept (
	deptno int,
    dname varchar(14),
    loc varchar(13)
);

deptInsert into DEPT (DEPTNO,DNAME,LOC) values (10,'ACCOUNTING','NEW YORK');
Insert into DEPT (DEPTNO,DNAME,LOC) values (20,'RESEARCH','DALLAS');
Insert into DEPT (DEPTNO,DNAME,LOC) values (30,'SALES','CHICAGO');
Insert into DEPT (DEPTNO,DNAME,LOC) values (40,'OPERATIONS','BOSTON');kosakosakosakosakosadb