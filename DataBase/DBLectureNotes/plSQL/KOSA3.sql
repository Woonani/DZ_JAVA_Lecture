/* ������ (SQL) 
1. CRUD (create > insert, read > select, update, delete)
2. APP(JAVA) - ǥ��(JDBC API) - Oracle
3. insert, update, delete, select (70%)

�ϳ��� ���̺� ���ؼ� �۾�����
JAVA���� EMP ���̺� ����(CRUD)
APP(JAVA)
MVC(����) >> Model(DTO,DAO,SERVICE) - View(html, jsp) - Controller(Servlet) �ϰ� ���ϴ� �͸� �� 
                        dao : data access object                                    -- Servlet : ���� �ڹ��ڵ�
DB �۾� (DAO) >>  EmpDao.java >> DB���� (CRUD)
�⺻������ 5���� �Լ� ���� .....
1. ��ü��ȸ (�Լ�) : select * from emp ó�� �Լ�
>> ������ ������
>> public List<Emp> getEmpList() { select * from emp return null; }

2. ������ȸ (�Լ�) : select * from emp where empno = ?
>> ������ �Ѱ�
>> public Emp getEmpListByEmpno (int empno) { select * from emp where empno =? return null; }

3. ���� (�Լ�)    : insert into emp(...)  values (...)
>> public int insertEmp (Emp emp) { insert ... return row; }

4. ���� (�Լ�)    : update emp(...) set .... where ...
5. ���� (�Լ�)    : delete emp where ....

*/

--9�� ���̺� �����ϱ� 
--page 138

-- DDL (create, alter, drop, rename) ���̺�(��ü) ����, ����, ����
-- �ڵ� ���� .. TOOL ���콺 ... �ڵ� ��

select * from tab; --���� ������ ����ڰ� �� �� �ִ� ��� ���̺� �̸�

select * from tab where tname = lower ('board'); -- board��� �̸��� ���̺��� �ִ��� Ȯ��

create table board(
    boardid number,
    title nvarchar2(50), -- ������ Ư�� ���� ������� 50��
    CONTENT NVARCHAR2(2000), -- 2000�� (4000byte)
    regdate date
);

desc board; --���� �⺻���� ����
-- TIP)
select * from user_tables where lower (table_name) = 'board';
select * from col where lower(tname) = 'board';
-- �������� Ȯ���ϱ� (�ݵ��)
select * from user_constraints where lower (table_name) = 'board';
select * from user_constraints where lower (table_name) = 'emp';
 
--oracle llg >> �ǹ� >> �����÷�(�����÷�)
-- �л� ���� ���̺� (����, ����, ����)
-- �հ�, ��� ....
-- �л� ���� ���̺� (����, ����, ����, ���) -- �����ʴ� but ������ȭ ����..
-- ������ ���� ��ȭ >> ��հ��� ��ȭ ���� >> ���Ἲ integrity

create table vtable(
    no1 number,
    no2 number,
    no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL
);

select * from col where lower (tname) = 'vtable';

insert into vtable(no1, no2) values(100, 50);
select * from vtable;

-- insert into vtable(no1, no2, no3) values(100, 50,30); (x)
-- �ǹ����� Ȱ��Ǵ� �ڵ�
-- ��ǰ���� (�԰�) : �б⺰ ������ ����(4�б�)
create table vtable2(
    no number, --����
    p_code char(4), -- ��ǰ�ڵ� (A001, B003)
    p_date char(8), -- �԰��� (20230101)
    p_qty number, -- ����
    p_bunfi number(1) GENERATED ALWAYS as (
                                            case when substr(p_date, 5, 2) in ('01', '02', '03') then 1
                                                when substr(p_date, 5, 2) in ('04', '05', '06') then 2
                                                when substr(p_date, 5, 2) in ('07', '08', '09') then 3
                                                else 4
                                            end
                                            ) VIRTUAL
    
);

select * from col where lower(tname)= 'vtable2';

insert into vtable2(p_date) values('20220101');
insert into vtable2(p_date) values('20220522');
insert into vtable2(p_date) values('20220601');
insert into vtable2(p_date) values('20221101');
insert into vtable2(p_date) values('20221201');
commit;

select * from vtable2;

--------------------------------------------------------------------------------------------------
--���̺� ����� ���� ����
-- 1. ���̺� �����ϱ�
create table temp6 (id number);

desc temp6;

--2. ���̺� ���� �Ŀ� �÷� �߰��ϱ�
alter table temp6
add ename varchar2(20); -- ���� ���̺� ���ο� �÷� �߰�

desc temp6;

--3. ���� ���̺� �ִ� �÷��̸� �߸� ǥ�� (ename -> username)
-- ���� ���̺��ִ� ���� �÷� �̸� �ٲٱ� (rename)
alter table temp6
rename column ename to username;

desc temp6;

-- 4. ���� ���̺� �ִ� ���� �÷��� Ÿ���� ũ�� ���� (���) modify
alter table temp6
modify (username varchar2(2000));

desc temp6;

-- 5. ���� ���̺� ���� �÷� ����
alter table temp6
drop column username;

desc temp6;
--��� �۾��� TOOL���� ���� ...!

--6. ���̺� ��ü�� �ʿ� �����
-- 6.1 delete �����͸� ����
-- ���̺� ó�� ����� ó�� ũ�� ���� >> ������ ������ >> ������ ũ�⸸ŭ ���̺� ũ�� ����
-- ó�� 1M >> ������ 10���� (insert) >> 100M >> delete 10���� ���� >> ���̺� ũ��100M

-- ���̺� (������) ���� (������ ũ�⵵ ���� �� ������)
-- truncate ( ���� : where�� ��� ����)
-- ó�� 1M >> ������ 10���� (insert) >> 100M >> truncate 10���� ���� >> ���̺� ũ��100M
-- truncate table emp --DBA (������)

-- ���̺� ����
drop table temp6;
desc temp6; --����:ORA-04043: temp6 ��ü�� �������� �ʽ��ϴ�.

-------------------------------------------------------------------------------------------------
-- ���̺� ���� �����ϱ�
-- page 144
/*
������ ���Ἲ ���� ������ ���� 
�� �� �� �� �� ��
PRIMARY KEY(PK)    : �����ϰ� ���̺��� ������ �ĺ�(NOT NULL �� UNIQUE ������ ����)
FOREIGN KEY(FK)    : ���� ������ �� ������ �ܷ�Ű ���踦 �����ϰ� �����մϴ�.
UNIQUE key(UK)     : ���̺��� ��� ���� �����ϰ� �ϴ� ���� ���� ��(NULL �� ���)
NOT NULL(NN)       : ���� NULL ���� ������ �� �����ϴ�.
CHECK(CK)          : ���̾�� �ϴ� ������ ������(��κ� ���� ��Ģ�� ����


������ �ƴ����� default sysdate ....
*/
-- PRIMARY KEY(PK) : NOT NULL ��  UNIQUE ���� >> null �����Ϳ� �ߺ��� �ȵǿ�
-- ���� (���ϰ�)
-- empno primary key >> where empno=7788 >> ������ 1�� ����
-- PK (�ֹι�ȣ, ȸ�� ID, ��ǰID )
-- ���� (PK�ڵ����� index ....) >> ��ȸ empno >> ���� >> index >> �ڵ�����

--���̺�� 1���� ���� ( 1���� �ǹ̴� (���))  >> ����Ű 
-- ����
--1. create table  ������ ���� ����
--2. create table �����Ŀ� �ʿ信 ���� �߰� (alter table emp add constraint ... )

-- ����Ȯ��
select * from user_constraints where table_name = 'EMP';

create table temp7(
--    id number primary key -- �������� �ʴ� ���� (�����̸� �ڵ����� ... ���� ���� ... )
id number constraint pk_temp7_id primary key, --������ ���� �̸� : pk_temp7_id
name varchar2(20) not null,
addr varchar2(50)
);

desc temp7;
select * from user_constraints where lower(table_name)='temp7';

insert into temp7 (name, addr) values('ȫ�浿','����� ������');
--ORA-01400: cannot insert NULL into ("KOSA"."TEMP7"."ID") : pk�� null�� �� �� �����ϴ�.

insert into temp7 (id,name, addr) values(10, 'ȫ�浿','����� ������');
select * from temp7;
commit;


insert into temp7 (id,name, addr) values(10,'ȫ�浿','����� ������');
-- ORA-00001: unique constraint (KOSA.PK_TEMP7_ID) violated

-- Unique (UK) ���̺��� ��� ���� �����ϰ� �ϴ� ���� ���� �� (NULL�� ���)
-- �÷��� ��ŭ ���� ����
-- null ���
-- Unique ������ �ɰ� �߰������� not null >> ������

create table temp8(
id number constraint pk_temp8_id primary key,
name varchar2(20) not null,
jumin nvarchar2(6) constraint uk_temp8_jumin unique,
addr varchar2(50)
);
select * from user_constraints where lower (table_name) ='temp8';

insert into temp8(id, name, jumin, addr)
values(10,'ȫ�浿', '123456', '��⵵');

insert into temp8(id, name, jumin, addr)
values(20,'�浿', '123456', '����');--unique���� �ɸ� : ORA-00001: unique constraint (KOSA.UK_TEMP8_JUMIN) violated

insert into temp8(id, name, addr)
values(20,'�浿', '����'); -- unique null ���

select * from temp8;
-- �׷� null�� �ߺ�üũ (�ƴϿ�)

insert into temp8(id, name, addr)
values(30,'����', '����');

select * from temp8;
commit;

-- not null  �������� ������
-- jumin nvarchar2(6) not null constraint uk_temp8_jumin unique,

-- ���̺� ���� �Ŀ� ���� �ɱ� (��õ) 
create table temp9(id number);
--���� ���̺� ���� �߰��ϱ�  (��κ��� ���� �� ���)
alter table temp9
add constraint pk_temp9_id primary key (id);

select * from user_constraints where lower(table_name) ='temp9';

-- create table temp9(id number, num number);
-- alter table temp9
-- add constraint pk_temp9_id primary key (id, num); -- ����Ű
-- ������ �Ѱ��� row >> where id = 100 and num=1

-- �÷� �߰�
alter table temp9 
add ename varchar2(50);

desc temp9;

-- ename �÷��� not null �߰�
alter table temp9
modify(ename not null);

desc temp9; --ENAME NOT NULL VARCHAR2(50) 

--------------------------------------------
--check ���� (���� ��Ģ - where ������ ���� �� ó��)
--where gender in ('��','��')
create table temp10(
    id number constraint pk_temp10_id primary key,
    name varchar(20) not null,
    jumin char(6) not null constraint uk_temp10_jumin unique,
    addr varchar2(30),
    age number constraint ck_temp10_age check(age >= 19) -- where age >= 19
    -- ck�� check���� temp10�� ���̺�  age �÷���
);

select * from user_constraints where table_name = 'TEMP10';

insert into temp10(id, name, jumin, addr , age)
values(100, 'ȫ�浿', '123456', '����� ������', 20);

select * from temp10;

insert into temp10(id, name, jumin, addr , age)
values(200, '�ƹ���', '235678', '����� ������', 18);
-- check���� ���� ���� : ORA-02290: check constraint (KOSA.CK_TEMP10_AGE) violated
commit;

-- Foreign Key (FK) :   ���� ������ �� ������ �ܷ�Ű ���踦 �����ϰ� �����մϤ���.
-- �������� (���̺�ΰ� ���̺���� ���輳��)
drop table c_emp;
drop table c_dept;

create table c_emp
as 
    select empno, ename, deptno from emp where 1=2;
    
select * from c_emp;

create table c_dept
as
    select deptno, dname from dept where 1=2;
    
select * from c_dept;
desc c_emp;
desc c_dept;
-- c_emp ���̺� �ִ� deptno �÷��� �����ʹ� c_dept ���̺� �ִ� deptno �÷��� �ִ� �����͸� ���ڴ�
-- ���� (FK)

-- �������� : c_dept�� deptno �÷��� �ſ��� ����� (PK, UNIQUE) ... �� �־�� ��������
alter table c_emp
add constraint fk_c_emp_deptno foreign key (deptno) references c_dept(deptno);
--there is no matching unique or primary key constraint in the referenced table.

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

-- �׸��� ���� �������� -- fk ���ϰ� ���� alter ~ add �ص� �ǹ��ȴµ�??
alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno) references c_dept(deptno);

select * from user_constraints where table_name = 'C_DEPT';
select * from user_constraints where table_name = 'C_EMP';

--  �μ�
insert into c_dept(deptno, dname) values(100, '�λ���');
insert into c_dept(deptno, dname) values(200, '������');
insert into c_dept(deptno, dname) values(300, 'ȸ����');
commit;

select * from c_dept;
--���Ի�� �Ի�
insert into  c_emp(empno, ename, deptno)
values(1, '������', 100);
-- into  c_emp(empno, ename, deptno) -- �����غ���
--values(1, '������', 100);

select * from c_emp;

insert into  c_emp(empno, ename, deptno)
values(2, '�ƹ���', 101);
--ORA-02291: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - parent key not found


commit;
--------------------------------------------------------------------------------
--���� END-----------------------------------------------------------------------
-- ������ ��������  FK ���캸�� --
-- master - detail ����
-- �θ� - �ڽ� ����

-- c_emp�� c_dept (���� FK) >> c_emp(deptno) Į���� c_dept(deptno) �÷��� ����
--  FK ���� : master (c_dept) - detail (c_emp) >> ȭ�� (�μ� ���) >> �μ���ȣ Ŭ�� >> ������� ���
-- deptno ���� ���� �θ� (c_dept) - �ڽ� (c_emp) 

--���� PK ������ �ִ� �� (master) , FK (detail)
select * from c_dept;

select * from c_emp;

--1. �� ��Ȳ���� c_emp ���̺� �ִ� ������ ������ �� �������?
delete from c_dept where deptno=100;
-- ORA-02292: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - child record found
delete from c_dept where deptno=200; -- �������� ����) c_emp �� �������� ���� �ʴ�.

delete from c_dept where deptno = 100;
delete from c_emp where empno=1; -- �������� �ʰ� .... ����
-- �ڽĻ���
-- �θ����

/*
column datatype [CONSTRAINT constraint_name]
 REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE])
column datatype,
. . . . . . . ,
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])
 REFERENCES table_name (column1[,column2,..] [ON DELETE CASCADE])
 
 ON DELETE CASACADE �θ� ���̺�� ������ ���� �ϰڴ�.
 
 alter table c_emp
 add constraint fk_c_emp_deptno foreign key(deptno) references c_dept(deptno) ON DELETE CASCADE;
 
 delete from c_emp where empno=1 >> deptno >> 100 ��
 
 delete from c_dept where deptno=100; �����ȵǿ� (�����ϰ� �����ϱ�)
 ON DELETE CASCADE �ɸ� �����ǿ�
 
 �θ���� >> �����ϰ� �ִ� �ڽĵ� ����
 
 MS-SQL
 ON DELETE CASCADE
 ON UPDATE CASCADE

*/

--------------------------------------------------------------------------------QUIZ
/*
--�������̺� , ���� �÷���
--[�л� ���� ���̺�]
--�й��� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�
--�̸� NULL ���� ������� �ʴ´�
--����
--����
--���� ���� �÷��� ���� Ÿ���̰� NULL ���� ���
--���� �Է����� ������ default�� 0���� ���´�
--���� ,��� �÷��� �����÷�����(�����÷�) �����Ѵ�
--�а��ڵ�� �а� ���̺� �а��ڵ带 �����Ѵ�
--�й� , �̸� , ���� , ���� , ���� , ���� , ��� , �а��ڵ�

--�а� ���̺�
--�а��ڵ� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�,
--�а��� �� null���� ������� �ʴ´�

--�а��ڵ� , �а���

--���� ������ insert ..
--�׸��� select �����
--�й� , �̸� , ����, ��� , �а��ڵ� , �а��� �� ����ϼ���
*/

--drop table class;
drop table studentScore;

create table class(
    classCode number constraint pk_class_classCode primary key,
    className varchar2(20) not null
);
desc class;

create table studentScore(
    id number constraint pk_studentScore_id primary key,
    name varchar2(20) not null,
    Korean number default 0,
    English number default 0,
    Math number default 0,
    totalscore number GENERATED ALWAYS as (Korean + English + Math) VIRTUAL,
    avgscore number GENERATED ALWAYS as ((Korean + English + Math)/3) VIRTUAL,
    classCode number
);
desc studentScore;

alter table studentScore
add constraint fk_studentScore_classCode foreign key(classCode) references class(classCode);

insert into class(classCode, className) values(100, '1��');
insert into class(classCode, className) values(200, '2��');

insert into studentScore(id, name, Korean, English, Math, classCode) values(100, '���̾�',70,80,95,100);
insert into studentScore(id, name, Korean, English, Math, classCode) values(200, '��', 50,80,80,200);
insert into studentScore(id, name, Korean, English, classCode) values(300, '����', 50,80,200);

select * 
from class;

select * 
from studentScore;

select s.id, s.name, s.totalscore, trunc(s.avgscore,0), s.classCode, c.className
from studentScore s left join class c on s.classCode = c.classCode;

--========================================================================================================
-- ����
/*
CREATE TABLE DEPARTMENT
(   
    DEPARTMENTCODE VARCHAR2(10),
    DEPARTMENT_NAME VARCHAR2(10) NOT NULL,
    CONSTRAINT PK_DEPARTMENT_DEPARTMENTCODE PRIMARY KEY(DEPARTMENTCODE)
);

CREATE TABLE SCORE
(
    STUDENT_ID  NUMBER(10) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(10) NOT NULL,
    KOREAN NUMBER(3) DEFAULT 0,
    MATH NUMBER(3) DEFAULT 0,
    ENGLISH NUMBER(3) DEFAULT 0,
    TOTALSCORE NUMBER(3) GENERATED ALWAYS AS (KOREAN+MATH+ENGLISH) VIRTUAL,
    AVGSCORE NUMBER(3) GENERATED ALWAYS AS ((KOREAN+MATH+ENGLISH)/3) VIRTUAL,
    DEPARTMENTCODE VARCHAR2(10),
    CONSTRAINT FK_SCORE_DEPARTMENTCODE FOREIGN KEY(DEPARTMENTCODE)
    REFERENCES DEPARTMENT(DEPARTMENTCODE)
);
*/
-- ����
/*
create table hakgwa (
hakgwacode number constraint pk_hakgwa_hakgwacode primary key,
hakgwaname varchar2(20)  not null
);

create table stugrade (
studentnumber number constraint pk_stugrade_studentnumber primary key,
name varchar2(20) not null,
korean number default 0,
english number default 0,
math number default 0,
totalscore number GENERATED ALWAYS as ( korean + english + math)  VIRTUAL,
scoreavg number GENERATED ALWAYS as ( (korean + english + math) / 3) VIRTUAL,
hakgwacode number, constraint FK_stugrade_hakgwacode FOREIGN KEY ( hakgwacode ) references hakgwa( hakgwacode )
);
-- �а� ���̺��� PK�� hakgwa
desc stugrade;
*/
----------------------------------------------------------------------------------------------------------------
-- ������ �ʱ� ���� END ----------------------------------------------------------------------------------------

--�� 12�� VIEW (���߱�)
-- ���� ���̺� (subquery >> in line view >> from ()  )
-- �ʿ��� ���� ���̺� 
/*
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
AS Subquery 
[WITH CHECK OPTION [CONSTRAINT constraint ]]
[WITH READ ONLY]
OR REPLACE �̹� �����Ѵٸ� �ٽ� �����Ѵ�.
FORCE Base Table ������ ������� VIEW �� �����.
NOFORCE �⺻ ���̺��� ������ ��쿡�� VIEW �� �����Ѵ�.
view_name VIEW �� �̸�
Alias Subquery �� ���� ���õ� ���� ���� Column ���� �ȴ�.
Subquery SELECT ������ ����Ѵ�.
WITH CHECK OPTION VIEW �� ���� �׼��� �� �� �ִ� �ุ�� �Է�,���ŵ� �� �ִ�. 
Constraint CHECK OPTON ���� ���ǿ� ���� ������ �̸��̴�.
WITH READ ONLY �� VIEW ���� DML �� ����� �� ���� �Ѵ�
*/
----SYSTEM PRVILEGES
----GRANT CREATE ANY VIEW TO "KOSA" WITH ADMIN OPTION;

create view view001   -- �������̺�, ���̺�� �Ȱ��� ��� ��� ����
as 
    select * from emp;
-- ���� ����01031. 00000 -  "insufficient privileges" >> ���� �����ϰ� ��
-- view001 �̶�� ��ü�� ���� �Ǿ���� (���� ���̺� >> ���� ������ ������ �ִ� ��ü)
-- �� ��ü�� ���̺�ó�� ����� �� �ִ� ��ü
select * from view001;  -- view 001�̶�� ��ü �ȿ��ִ� ������ ����ϴ°���. view001�� ���̺��� �ƴ�
select * from view001 where deptno=20;

-- VIEW (���� ���̺�) 
-- ���� : �Ϲ� ���̺�� ���� (select , insert, update, delete)
-- �� , VIEW �� �� �ִ� �����Ϳ� ���ؼ�
-- View ���ؼ� ���� ���̺� insert, update, delete (DML)���� ... ���� ������...

-- VIEW ����
--1. �������� ���� : join , subquery ������ ���� �̸� �����ξ��ٰ� ���
--2. ���� �ܼ�ȭ : view �����ؼ� JOIN ����
--3. DBA ���� : �������̺��� �������� �ʰ� view ���� ���� (Ư�� �÷��� �������� �ʴ´�)

create or replace view v_001
as 
    select empno, ename from emp;
--�� �����ѵ� �������� ������ �������ִ� ��ü�� ��������

select * from v_001;

create or replace view v_emp
as
    select empno, ename, job, hiredate from emp;
    
-- ������ .... v_emp
select * from v_emp;
select * from v_emp where job='CLERK';

--����
create or replace view v_002
as 
    select e.empno, e.ename, e.deptno, d.dname
    from emp e join dept d
    on e.deptno = d.deptno;
    
-- ���־��� ���� view�� ����صΰ� ���� ����
select * from v_002;

-- ������ ��� �޿��� �� �� �ִ� view �ۼ� 9��ü) -- ��ü�� drop���� �ʴ� �� ������...

create view v_003
as
    select deptno, trunc(avg(sal),0) as avgsal from emp group by deptno;
    
select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join v_003 s
on e.deptno =  s.deptno
where e.sal > s.avgsal;


/*
 view ���� ���̺� (����) view �� [���ؼ�] view�� [�����ִ�]�����Ϳ� ���ؼ�
 DML (insert, update, delete) ���� .....
*/


/*
create or replace view v_emp
as
    select empno, ename, job, hiredate from emp;
*/
select * from v_emp;

update v_emp
set sal = 0; --  �Ұ��� ����) view�� �� �� ���� data�̱� ����. ������ ������ v_emp ���� sal �÷��� ����.

update v_emp
set job = 'IT';

select * from v_emp;
select * from emp; -- ���� ��  job�� ��� IT�� �ٲ������
rollback;
-- ���� �ʵ��� ����!!!
-- �ֳ��ϸ� ���� ���̺��� data�� ���������� �ʱ� ������ ������ ������ ������!!


-------------------------------
--  30�� �μ� ������� ����, �̸� , ������ ��� view�� ����µ�, 
-- ������ �÷����� ����, ����̸�, �������� alias�� �ְ� ������
-- 300 ���� ���� ����鸸 �����ϵ��� �϶�. view101

create or replace  view v101
as
    select job as "����" , ename as "����̸�" , sal as "����" from emp
    where deptno = 30 and sal > 300;
    
select * from v101;

-- �μ��� ��� ������ ��� view�� �����, ��տ����� 2000 �̻��� 
-- �μ��� ����ϵ��� �϶�. view102

create or replace view view102
as 
    select deptno, avg(sal) as avgsal
    from emp 
-- xƲ��    where (select avg(sal) from emp group by deptno) >= 2000
    group by deptno
    having avg(sal) >= 2000;
    
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ������ ���� �����
show user;
select * from employees;
select * from departments;
select * from locations;
desc locations;

-- Seattle�� ��ġ�� �μ��� �����ϰ� �μ��� ���� ����� ������������ �����ϼ���.
-- �μ���� ��տ��� �÷��� �̸����� �ϼ���.

select department_name as  �μ���, trunc(avg(salary), 0) as ��տ���
from employees a join (select * from departments
                        where location_id != (select location_id from locations where city = 'Seattle')
                        ) b on a.department_id = b.department_id
group by department_name
order by ��տ��� desc;


-----------------------------------------------------------------------------------------
/*
���� - ����
Seattle���� �ٹ��ϴ� 2005�� ���Ŀ� �Ի��� ������� �μ��� ��� �޿��� ���ϰ�, ���� ���� ��� �޿��� ���� �μ��� ã�� 
�� �μ��� ��� ��� ����� ����ϼ���.
*/

select * from employees;
select * from departments;
select * from locations;

select * from employees
where department_id = (
    select department_id from (
        select avg(a.salary) as avgsal, a.department_id
        from employees a join (
            select *from departments
            where location_id = (select location_id from locations where city = 'Seattle')
            ) b on a.department_id = b.department_id
        where to_char(a.hire_date, 'YYYY') >= '2005'
        group by a.department_id
    )where avgsal = (
        select min(avg(a.salary))
        from employees a join (
            select *from departments
            where location_id = (select location_id from locations where city = 'Seattle')
            ) b on a.department_id = b.department_id
        where to_char(a.hire_date, 'YYYY') >= '2005'
        group by a.department_id)
) ;
--and to_char(hire_date, 'YYYY') >= '2005';
-------------------------------------------------------------------------------------------


