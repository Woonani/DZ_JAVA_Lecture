/*
1���� ����

1. ����Ʈ���� �ٿ�ε� (11g)
https://www.oracle.com/database/technologies/xe-prior-release-downloads.html

2. Oracle ��ġ ( SYS, SYSTEM ������ ���� ��ȣ ���� : 1004)

3. sqlplus ���α׷� ( oracle ��ġ�� �����Ǵ� ���α׷� , CMD ) 
    : ���� GUI ȯ�� �������� �ʾƿ�.
    
4. ������ ���α׷� ���� Tool
4.1 SqlDeveloper ����, dbeaver ����
4.2 ���, ������, SqlGate ȸ�� .....

5. SqlDeveloper ���� >> Oracle ���� ���� >> GUI
5.1 HR ���� (unlock) 
-- USER SQL
ALTER USER "HR" IDENTIFIED BY "1004" 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ; >>>>>>> �̰� ��
-- QUOTAS
ALTER USER "HR" QUOTA UNLIMITED ON "USERS";
-- ROLES
ALTER USER "HR" DEFAULT ROLE "CONNECT","RESOURCE";
-- SYSTEM PRIVILEGES


5.2 KOSA ���� ���� (�ǽ�����)
������ >> �ٸ������>> ��Ŭ�� ����� ���� >> �����, ����(��) �� ����
-- USER SQL
CREATE USER "KOSA" IDENTIFIED BY "1004"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS

-- ROLES
GRANT "CONNECT" TO "KOSA" WITH ADMIN OPTION;
GRANT "RESOURCE" TO "KOSA" WITH ADMIN OPTION;
ALTER USER "KOSA" DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES


*/


/*
CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );


select * from emp;

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;


select * from emp;
--DROP table emp;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;


CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;


DB�о�
������ (CRUD) (insert, select, update, delete) >> DML(DATA MANIPULATION LANGUAGE) + DDL (create, alter, drop)

������ (DBA) ����ϰ� ���� , ��Ʈ��ũ ����, �ڿ�����, �ϵ���� ����

Ʃ�� : SQL Ʃ�� (����) >> �ӵ�  >> index >> �ڷᱸ��
      �ϵ����(��Ʈ��ũ) Ʃ��
      
�𵨷� : ���� (PM) - ERD - �䱸���� �м� ERD

�м��� (������ �м�) ����� �̻� ..... �� read .....

*/
show user;

select * from emp;
select * from dept;
select * from salgrade;

------------------------------------------------------------------
-- 1. ������̺��� ��� �����͸� ����ϼ���
select * from emp;
SELECT * FROM emp;
SELECT * FROM EMP;
-- ������ ��ҹ��� ���� X : ȸ�縶�� ��Ģ�� �ٸ� ��

-- 2. Ư�� �÷� ������ ����ϱ�
select empno, ename, sal
from emp;

select ename from emp;

-- 3. ����Ī ����ϱ� (��Ī : alias) >> ���� �ҰŸ� "" ���ֱ�
select empno ��� , ename �̸�
from emp;
select empno "�� ��" , ename "�� ��"
from emp;

-- ���� ���� (ANSI) >>  ǥ�� >> ������ �ۼ��ϸ� (Oracle, Ms-sql, Mysql) >> ��Ī�� as�� ���ش�.
select empno as "�� ��", ename as "�� ��"
from emp;

-- Oracle ���ڿ� ������ �����ϰ� ��ҹ��� ����
/*
JAVA : ���� > 'A', ���ڿ� > "AAAA"
ORACLE : ���ڿ� 'A'  ,  'AAAA'  ,  'ABBWEDWED'
>> ����Ŭ�� ���ڿ� ���ڿ� ���о��� ���� ���� ����ǥ�� ���� ��.
ORACLE : �����ͷ� 'a'  'A' �ٸ� ���ڿ�
*/
SELECT *
FROM EMP
WHERE ENAME = 'KING';  -- ��ҹ��� ����. 'king' �̶�� �ϸ� �ȳ���

/*
SELECT ��  3
FROM ��    1
WHERE ��   2
*/

-- Oracle Query (���Ǿ�) : ���
/*
������
JAVA : + ����(�������) , + ���ڿ� (���տ���)
-----------------------------------------
ORACLE : 
���� ������ || 
��� ������ + (�������)

MS-SQL : + (���, ����)

*/

SELECT '����� �̸���' || ENAME || '�Դϴ�' AS �������
FROM EMP;

-- ���̺��� �⺻���� (�÷�, Ÿ��)
DESC EMP;
-- ENAME     VARCHAR2(10) ���ڿ� Ÿ�� ���հ��� ...����

/*
VARCHAR2(10) 
��ȣ �� ���ڰ� BYTE ��. �ѱ��� 2BYTE�ϱ� 10�̸� 5�� �� �� ����

JAVA: class Emp (private int empno, private String ename)
ORACLE : create Table Emp (empno number, ename varchar2(20));
*/


-----------------------------------------------------

--�ڵ�����ȯ >> ���ڸ� ���ڿ��� ��ȯ
select empno || ename from emp;

select empno + ename from emp; --invalid number

--����� ... �츮 ȸ�翡 ������ ��� �ֳ�
select job from emp;

--�ߺ��� ���� Ű���� : distinct

select distinct job from emp; 
--grouping

--��̷� (distinct)
select distinct job, deptno
from emp
order by job;

select * from emp;


--Oracle SQL ���
--JAVA�� ���� ���� : (+,-,*,/) ������ %
--ORACLE          : (+,-,*,/) ������ % (Oracle���� %�� �ٸ� ���� ��� ... �Լ� mod())
--���ڿ� ���� �˻� : ename like '%��%'

--������̺��� ����� �޿��� 100�޶� �λ��� ����� ����ϼ���
select empno, ename, sal, sal+100 as �λ�޿� from emp;

--dual �ӽ� ���̺�
select 100 + 100 from dual; --200
select 100 || 100 from dual; -- 100100
select '100' + 100 from dual; --200  '100' ������ ���� ex)'123456'
select 'A100' + 100 from dual; -- error

--�� ������
--<     >   <=
--����
--JAVA : ���� (==) �Ҵ�(=) , JavaScript : (==. ===)
--Oracle : ���� (=) ���� �ʴ� !=

--�������� (AND, OR, NOT)

select empno, ename, sal
from emp
where sal >= 2000;

--����� 7788���� ����� ��� �̸� ����, �Ի����� ����ϼ���
SELECT EMPNO, ENAME, JOB, HIREDATE
FROM EMP
WHERE EMPNO = 7788;
----------------------------------------------------------
--����� �̸��� king ����� ��� , �̸� , �޿� ������ ����ϼ���
select empno , ename, sal
from emp
where ename ='KING';

/*    AND  , OR
 0 0   0     0
 1 0   0     1
 0 1   0     1
 1 1   1     1

*/
--�ʰ� , �̸�
--�̻� , ���� (=)

--�޿��� 2000�޷� �̻��̸鼭 ������ manager �� ����� ��� ������ ����ϼ���
select *
from emp
where sal >= 2000 and job='MANAGER';


--�޿��� 2000�޷� �̻��̰ų� (�Ǵ�) ������ manager �� ����� ��� ������ ����ϼ���
select *
from emp
where sal >= 2000 or job='MANAGER';

--�޿��� 2000�޷� �ʰ��̸鼭 ������ manager �� ����� ��� ������ ����ϼ���
select *
from emp
where sal > 2000 and job='MANAGER';

--����Ŭ ��¥ (DB ������ ��¥)
--sysdate
select sysdate from dual;
--23/04/17

----------------------------------------------------------------
select * from nls_session_parameters;
/*
NLS_LANGUAGE	        KOREAN
NLS_DATE_FORMAT	        RR/MM/DD
NLS_DATE_LANGUAGE	    KOREAN
NLS_TIME_FORMAT	        HH24:MI:SSXFF
*/
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
--���� >> ȯ�漳�� >> �����ͺ��̽� Ȯ�� >> NLS >> ��¥���� �����ϼŵ� �˴ϴ�.

SELECT * FROM EMP;

-- ��¥ ������ �˻� >> ���ڿ� �˻� ó�� >> '��¥'
SELECT * FROM EMP
WHERE HIREDATE = '1980-12-17'; 

SELECT * FROM EMP
WHERE HIREDATE = '1980/12/17'; 

SELECT * FROM EMP
WHERE HIREDATE = '1980.12.17';

SELECT * FROM EMP
WHERE HIREDATE = '80-12-17'; 
-- ���� ��¥ ���� (YYYY-MM-DD)�ε� 80-12-17�� �ϸ� �ȵ�. ��¥ ������ �� �¾Ƽ� 

-- ����� �޿��� 2000�̻��̰� 4000������ ��� ����� ������ ����ϼ���
SELECT * 
FROM EMP
WHERE SAL >= 2000 AND SAL <=4000;
-- �÷��� between A and B ������ (= ����)

SELECT * 
FROM EMP
WHERE SAL BETWEEN 2000 AND 4000; -- BETWEEN�� ���� �� �� ����..

--����� �޿��� 2000�ʰ� 4000�̸� �� ��� ����� ������ ����ϼ���
select *
from emp
where sal > 2000 and sal < 4000;

-- �μ���ȣ�� 10�� �Ǵ� 20�� �Ǵ� 30���� ����� ���, �̸�, �޿�, �μ���ȣ�� ����ϼ���.
SELECT * 
FROM EMP
WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=30;
-- IN ������
select *
from emp
where deptno in (10, 20, 30); -- where deptno=10 or deptnp=20 or deptno30;

-- �μ���ȣ��  10�� �Ǵ� 20���� �ƴ� ����� ���, �̸�, �޿�, �μ���ȣ�� ����ϼ���.
SELECT empno, ename, sal, empno 
FROM EMP
WHERE DEPTNO!=10 OR DEPTNO!=20 ;

-- IN�� ���� (NOT IN)
select * 
from emp
where deptno not in (10, 20); --where deptno != 20;
--POINT : not in >> != and

-- Today Point
-- null �� ���� �̾߱�
-- ���� ����
-- �ʿ��
create table member (
    userid varchar2 (20) not null, 
    name varchar2(20) not null,
    hobby varchar2(50) 
);
desc member;
insert into member (userid, hobby) values ('kim', '��');
-- ORA-01400: cannot insert NULL into ("KOSA"."MEMBER"."NAME")
insert into member (userid, name) values ('kim', 'ȫ�浿');
commit;
select * from member;

----------------------------------------------------------------------

/*
DB���� ����
Oracle
insert, update , delete ���
�⺻������ ������ ����� begin tran ������ �ڵ����� ����. �����ڴ� end(�Ϸ�, ���)
����Ŭ�� ������ ...... ������ ��� (commit ���� �ݿ�, rollback ���) �̷��� �ؾ� �۾��� �Ϸ��.

Ms-sql
�ڵ� auto-commit
delete from emp; �ڵ� commit;

begin tran
    delete from emp;
    
    commit or rollback���� ������ ������ ó�� �ȵ�!
    
*DB Transaction : ������ �۾� ���� (����, ����)
*OLTP (�� ȯ�� : �ǽð� ������ ó��) >> Ʈ�����
������� ��ü
begin tran
    update ... ���� -1000
    update ... �������� +1000
end

*OLAP (������ �м� : �����Ⱓ ������ ��Ƽ� �м�)

����Ŭ���� insert, update, delete �ϸ� �ݵ�� 
commit, rollback ó�� ���� �����ؾ� �Ѵ�.

--delete from emp;

select * from emp;

commit;  -- commit �� �����ʹ� ��Ģ�����δ� ������ �ȵ�. �׷��� ����ص� �����Ͱ� �ִٸ� �������� �ǵ��� �� �ִ�.


*/
----------------------------------------------------------------------
-- ���� (comm) �� ���� �ʴ� ��� ����� ������ ����ϼ���
-- �ǽ� ������ 0�� �ִµ� ������ �޴� ������ ������

-- comm �÷��� ������ null �ΰ�
select * 
from emp
where comm = null; -- ������ �����

--select * 
--from emp
--where comm is null;
--�ϱ� (null �� �񱳴� is null)

-- comm�� �޴� ����� (comm �÷��� �����Ͱ� null �� �ƴѰ�)

select * 
from emp
where comm is not null;

-- ������̺��� ���, �̸�, �޿�, ����, �ѱ޿�( �޿�+����)�� ����ϼ���
select empno, ename, sal, comm, sal + comm as �ѱ޿� --'�ѱ޿�'��� �ϸ� �ȳ���
from emp;

/*
null�̶� �༮
1. null ���� ��� ���� ����� null ex) null + 100 -> null
2. null �̶� ... �Լ� > nvl(), nvl2()

ex) nvl(�÷���, ��ü��) >>  ġȯ

Tip)
Mysql > null > IFNULL() > select ifnull (null,'')
Ms-sql > null >  Convert()
*/
select empno, ename, sal, comm, sal+nvl (comm, 0) as �ѱ޿�
from emp;
-- "nvl (comm, 0) : Ŀ�̼� �÷����� null�� ������ 0���� �ٲ㼭 ����ض�" ��� �ǹ�

select 1000 + null from dual;
select 1000+ nvl(null,0) from dual;
select comm, nvl(comm, 11111) from emp;
select nvl(null, 'hello NULL') from dual;

-- ����� �޿��� 1000�̻��̰� ������ ���� �ʴ� ����� ���, �̸�, ����, �޿�, ����
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and comm is null;

--���ڿ� �˻�
--�ּҰ˻� >> ���� >> ���� �ܾ �ִ� ��� �ּҰ� ������ ��
-- Like ���ڿ� ���� �˻� 
-- ���ϵ�ī�幮�� (%(����), _(�ѹ���))

select * 
from emp
where ename like '%A%'; -- A������ �̸�

select * 
from emp
where ename like 'A%'; -- A�� �����ϴ� ��� �̸� 

select * 
from emp
where ename like '%E'; -- E�� ������ �̸� BLAKE

select * 
from emp
where ename like '%LL%';

select * 
from emp
where ename like '%A%A%'; -- A�� �ΰ� ADAMS


select * 
from emp
where ename like '_A%'; -- �ι�° ���ڴ� A�̰� .... WARD, MARTIN, JAMES

-- ����ǥ���� regexp_like()
select * from emp where regexp_like (ename, '[A-C]'); -- ����ǥ�� �ɾ ó�� ����
-- ���� (����ǥ���� 5�� �����) ���� ī�信 �ö󰡸� �ϼ���

-- ������ �����ϱ�
--order by �÷��� : ����, ����, ��¥ ���ı��
-- �������� : asc : ������ : default
-- �������� : desc : ������
-- ���� (�˰���) >> ����� ���� ��� �۾�(cost)

select * 
from emp
order by sal; -- default order by sal asc

select * 
from emp
order by sal desc;

--�Ի����� ���� ���� ������ �����ؼ� ��� , �̸� , �޿� , �Ի��� ����ϼ���
--���� �ֱٿ� �Ի��� ������
select empno, ename, sal, hiredate
from emp
order by hiredate desc;

/*
select ��    3    
from ��      1
where ��     2    
order by ��  4   (select ����� ����)
*/

-- �ؼ� ������� .. �������
select empno, ename, sal, job, hiredate
from emp
where job = 'MANAGER'
order by hiredate desc;

/*
select job, depno
from emp
order by �÷��� asc, �÷��� asc, ...
*/

-- �߿� (�亯�� �Խ��� ... ���) >> grouping : �׷�ȿ��� ����
-- order by �÷��� asc, �÷��� asc, ...
select job, deptno
from emp
order by job asc, deptno desc;
-- emp���̺��� ������ ������������ �����ϰ� ���߿��� �μ���ȣ�� ������������ �����Ͽ� ���ް� �μ���ȣ�� ���

-- ������
-- ������(union) : ���̺�� ���̺��� �����͸� ��ġ�� �� (�ߺ��� ����)
-- ������(union all ) : ���̺�� ���̺��� �����͸� ��ġ�� �� (�ߺ��� ���)
/*
create table uta (name varchar2(20));
insert into uta(name) values ('AAA');
insert into uta(name) values ('BBB');
insert into uta(name) values ('CCC');
insert into uta(name) values ('DDD');
commit;

create table ut (name varchar2(20));
insert into ut(name) values ('AAA');
insert into ut(name) values ('BBB');
insert into ut(name) values ('CCC');
commit;
*/
select * from uta;
select * from ut;

select * from ut
union            -- �ߺ������� ���ŵ�
select * from uta;
-- ut�� ���� uta �ı����� ����� ��

select * from ut
union all        -- �ߺ������� ���� �ȵ�
select * from uta;
-- ut�� ���� uta �ı����� ����� ��

- union
-- 1) "����"�Ǵ� "�÷�"�� "Ÿ��"�� �����ؾ� �Ѵ�.

select empno, ename from emp        -- ����, ���ڿ�
union
select dname, deptno from dept;     -- ���ڿ�, ����

-- ������ ���ļ� �÷� ��� ����, ���ڿ��� ������
select empno, ename from emp        
union
select deptno, dname from dept;     
-- ���� ���߿� subquery�� ����ؼ� ���� ���̺� ....
select *
from (
    select empno, ename from emp
    union
    select deptno, dname from dept
) m
order by m.empno desc; -- in-lin view

--2. "����"�Ǵ� "�÷�"�� ������ "����"
/* 
01789. 00000 -  "query block has incorrect number of result columns"
select empno, ename, job, sal from emp
union
select deptno, dname, loc from dept;
*/
select empno, ename, job, sal from emp
union
select deptno, dname, loc, null from dept; -- �÷��� ������ ���� �� �ʿ�� null ���

----------------------------------------------------------------------------------
-- pdf �� 47������ ����
--0418
SHOW USER;
SELECT SYSDATE FROM DUAL; 
--ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY/MM/DD HH24:MI:SS';
-- ���� ������ ������ �ٶ󺸴� ��¥�� �ٲٴ°� : ����>ȯ�漳��>�����ͺ��̽�>NLS:��¥����

/*
���� �� �Լ��� ���� 
1) ������ �Լ� : ���ڸ� �Է� �ް� ���ڿ� ���� �� ��θ� RETURN �� �� �ִ�.
2) ������ �Լ� : ���ڸ� �Է� �ް� ���ڸ� RETURN �Ѵ�.
3) ��¥�� �Լ� : ��¥���� ���� �����ϰ� ���ڸ� RETURN �ϴ� MONTHS_BETWEEN �Լ���
�����ϰ� ��� ��¥ ���������� ���� RETURN �Ѵ�.
4) ��ȯ�� �Լ� : � ���������� ���� �ٸ� ������������ ��ȯ�Ѵ�.
5) �Ϲ����� �Լ� : NVL, DECODE

*/
-- ���ڿ� �Լ�

select initcap ('the super man') from dual; -- INICAP �ܾ��� ù���ڸ� �빮�ڷ�
select lower('AAA'), upper('aaa') from dual;
select ename, lower(ename)as "ename" from emp; -- "" ��� ���� x���� ''�� ������
select * from emp where lower (ename) = 'king';

select length ('abcd') from dual; --���ڿ��� ����
select length('ȫ�浿') from dual; --3��
select length ('   ȫ �� ��a') from dual; -- 9��

select concat('a', 'b') from dual; -- ab
--select concat('a','b','c') from dual; --concat�� �ΰ��ۿ�..
select 'a'|| 'b' || 'c' from dual; --abc

select concat(ename, job) from emp; -- concat�� ���� �Ұ�
select ename || '  ' || job from emp; -- �Լ����� �����ڰ� ���༺�� ������

-- JAVA : substring 
-- ORACLE : substr

-- substr(���ڿ�, a, b) �ε��� a���� b�� (�ε����� 1���� ����)
select substr('ABCDE',2,3) from dual; --BCD
select substr('ABCDE',1,1) from dual; --A
select substr('ABCDE',3,1) from dual; --C
select substr('ABCDEFGHIJK',3) from dual; --CDEFGHIJK : �ε��� 3���� ��~!

/*
dual?
DUAL�� ����Ŭ�̳� MYSQL �� DBMS���� �����ϴ� ���̺��, 
24 * 37 �̷� �ܼ��� ������, �������, �Լ���� �� 
���� ����� �ս��� Ȯ���غ� �� �ִ� �ӽ����̺� �����ſ���. 
MYSQL�� ��쿡�� FROM DUAL�� ������ �� �־��.
*/

/*
������̺��� ename�÷��� �����Ϳ� ���ؼ� ù���ڴ� �ҹ��ڷ� ������ ���ڴ� �빮�ڷ�
����ϵ� �ϳ��� �÷����� ���� ����Ͻð� �÷��� ��Ī�� fullname ���� �ϰ� 
ù���ڿ� ������ ���� ���̿��� �����ϳ��� ��������.
*/

select lower(substr(ename,1,1)) || ' ' || upper(substr(ename,2)) 
as "fullname"
from emp;

select lpad ('ABC', 10,'*') from dual; -- *******ABC : �������� * �� 10��ä����
select rpad ('ABC', 10,'*') from dual; -- ABC*******
select rpad ('ABC', 10,'#') from dual; -- ABC#######

-- ����� ��� : hong1004 or k1234
-- ȭ��տ� 2���ڸ� �����ְ� �������� Ư�� ���ڷ�
select rpad(substr('hong1004',1,2), length('hong1004'),'*') from dual;
select rpad(substr('k1234',1,2), length('k1234'),'*') from dual;

-- emp ���̺��� ename �÷��� �����͸� ����ϵ� ù���ڸ� ����ϰ� �������� * ����ϼ���
select rpad(substr(ename,1,1) , length(ename), '*') as ename from emp;

create table member2(
    id number,
    jumin varchar2(14)
);
insert into member2(id, jumin) values(100, '123456-1234567');
insert into member2(id, jumin) values(200, '234567-1234567');
commit;


select * from member2;
-- ��°��
--100 : 123456-*******
select id || ' : ' || rpad(substr(jumin,1,7), length(jumin),'*') as jumin from member2;

-- rtrim �Լ�
-- ������ ���ڸ� ������
select rtrim('MILLER', 'ER') from dual; --MILL

-- ltrim �Լ�
-- ���ʹ��ڸ� ������
select ltrim('MILLLLLLLLLLMLLMER', 'MIL') from dual; --ER
-- trim() �� �� �� ���鸸 ����
-- rtrim, ltrim�� �������� �������� ���
select '>' || 'MILLER          ' || '<' from dual;
select '>' || rtrim('MILLER          ',' ') || '<' from dual;

-- ġȯ�Լ� 
select ename, replace(ename, 'A', '�Ϳ�') from emp; -- A�� ������ �Ϳ�� �ٲ��

---------------------------------------------------------------
-- �����Լ�
-- round (�ݿø��Լ�)
-- trunc (�����Լ�)
-- mod() ������ ���ϴ� �Լ�

-- round    �ݿø� 0(����) 1 2 3 
select round(12.345, 0 ) as r from dual; --12 : �����θ� ���ܶ�
select round(12.567, 0 ) as r from dual; --13
select round(12.345, 1 ) as r from dual; --12.3 : �Ҽ� ù°�ڸ� ����
select round(12.567, 1 ) as r from dual; --12.6
select round(12.345, -1 ) as r from dual; -- 10 : ���� �ڸ�����
select round(15.345, -1 ) as r from dual; -- 20
select round(12.345, -2 ) as r from dual; -- 0

-- trunc    ����
select trunc(12.345, 0 ) as t from dual; --12 : �����θ� ���ܶ�
select trunc(12.567, 0 ) as t from dual; --12
select trunc(12.345, 1 ) as t from dual; --12.3 : �Ҽ� ù°�ڸ� ����
select trunc(12.567, 1 ) as t from dual; --12.5
select trunc(12.345, -1 ) as t from dual; -- 10 : ���� �ڸ�����
select trunc(15.345, -1 ) as t from dual; -- 10
select trunc(12.345, -2 ) as t from dual; -- 0

-- ������
select 12/10 from dual; --1.2
select mod(12,10) from dual; --2 �������Լ�
select mod(0,0) from dual; --0
--------------------------------------------------------------------------
--��¥ �Լ� (����)
select sysdate from dual;
--POINT
--1. Date + Number >> Date
--2. Date - Number >> Date
--3. Date - Date >> Number (�ϼ�) 

select sysdate + 100 from dual;
select sysdate + 1000 from dual;
select sysdate - 1000 from dual;

select hiredate from emp;
select months_between('2022-09-27', '2020-09-27') from dual; -- 24  (���� ����)
select months_between(sysdate, '2020-01-01') from dual; -- �� 39���� �ٹ�

-- ���ǻ��� �����ϼ���^^
select '2023-01-01' + 100 from dual; -- '2023-01-01' [��¥����] ������ ���ڿ�
-- �ذ� �Լ� : ���ڸ� ��¥�� �ٲٴ� �Լ� to_date();
select to_date('2023-01-01') + 100 from dual; 

-- ������̺��� ������� �Ի��Ͽ��� ���糯¥������ �ټ� �� �� �� ���ϼ���.
-- ����̸�, �Ի���, �ټӿ��� ���
-- �� �ټӿ����� �����θ� ��� (�ݿø� ���� ������)
select ename, hiredate, trunc(months_between(sysdate, hiredate),0) as �ټӿ��� 
from emp;

-- �Ѵ��� 31�� �̶�� �����ϰ�,,, ���ؿ��� �ټ� ������ ���ϼ���
-- �Լ��� ������� ������ (�ݿø� ���� ������) -- trunc�� �Լ� �ƴϳ�?;
select ename, hiredate, trunc((sysdate-hiredate)/31,0) as �ټӿ��� 
from emp;
----------------------------------------------------------------------
-- �����Լ�, �����Լ�, ��¥�Լ� END --------------------------------------

-- ��ȯ�Լ� TodayPoint
-- ����Ŭ ������ ���� : ���ڿ�, ����, ��¥

-- to_char() : ���� -> ���� ���� (100000 -> $100,000) �̷��� �ٲٸ� $100,000�� ���ڰ� �ƴ� ���ڴ�!!!
-- >> formating ��� ���� �����ϴ� ��.
-- to_char() : ��¥ -> ���� ����('2023-01-01' -> 2023��01��01��) �̰͵� ��¥�� �ƴ϶� format��������� �����ִ� ���ڿ��̴�.
-- to_char()�� ���ڸ� ���� ���ϴ� ������������ �ٲ��ִ� ��

-- to_date() : ����(��¥����) -> ��¥
-- select to_date('2023-01-01') + 100 from dual;

-- to_number() : ���� -> ���� (�ڵ�����ȯ)
select '100' + 100 from dual; --200
select to_number('100') + 100 from dual;

-- ��ȯ�� ǥ ����(page 68 ~ 71 ����) : ������ �˻��� 61��!
-- ���� format

select sysdate, to_char(sysdate, 'YYYY')  || '��' as yyyy,
to_char(sysdate, 'YEAR') as YEAR,
to_char(sysdate, 'MONTH') as MONTH,
to_char(sysdate, 'MM') as MM,
to_char(sysdate, 'DD') as DD,
to_char(sysdate, 'DAY') as DAY
from dual;

-- �Ի����� 12���� ����� ���, �̸�, �Ի���, �Ի�⵵, �Ի���� ����ϼ���
select empno, ename, hiredate, to_char(hiredate,'YYYY') as �Ի�⵵, to_char(hiredate,'MM') as �Ի��
from emp
where to_char(hiredate,'MM')='12';

select '> ' || to_char(12345, '999999999')|| '<' from dual;
select '> ' || to_char(12345, '000000000')|| '<' from dual;
select '> ' || ltrim(to_char(12345, '999999999'))|| '<' from dual;
select '> ' || to_char(12345, '$999,999,999,999,999')|| '<' from dual;
select sal, to_char(sal, '$999,999,999')as �޿� from emp;

-- HR���� �̵�
show user;
--USER��(��) "HR"�Դϴ�.
select * from employees;
/*
������̺�(employees)���� ����� �̸��� last_name , first_name ���ļ� fullname ��Ī 
�ο��ؼ� ����ϰ� �Ի�����  YYYY-MM-DD �������� ����ϰ� ����(�޿� *12)�� ���ϰ� 
������ 10%(���� * 1.1)�λ��� ����
����ϰ� �� ����� 1000���� �޸� ó���ؼ� ����ϼ���
�� 2005�� ���� �Ի��ڵ鸸 ����ϼ��� �׸��� ������ ���� ������  ����ϼ���
*/

-- ����
select (last_name || first_name) as fullname, 
    to_char(hire_date, 'YYYY-MM-DD') as �Ի���, 
    salary*12 as ����,
    to_char(salary*12*1.1, '$999,999') as �λ��
from employees
where to_char(hire_date,'YYYY') >= 2005 -- to_char(hire_date, 'YYYY-MM-DD') >= '2005-01-01' �̰� ���� ����ǥ ���ϸ� �ȵ�.
order by ���� desc;
-- �� ��
select employee_id,
    (last_name || first_name) as fullname, 
    to_char(hire_date, 'YYYY-MM-DD') as �Ի��� ,
    salary,
    salary * 12 as ����,
    to_char(salary*12*1.1, '$999,999') as �λ��
from employees
where to_char(hire_date,'YYYY') >= '2005'
order by ���� desc; -- select �� ����� �����ϱ� ������ select �÷���


------------
-- �ٽ� KOSA user�� 
show user;
-- Tip
select 'A' as a , 10 as b, null as c, empno
from emp;
----------------------------------------------------------------
-- ����, ����, ��¥, ��ȯ�Լ�(to_...)
----------------------------------------------------------------
-- �Ϲ��Լ� (���α׷��� ������ ���ϴ�)
-- SQL (����, ��� ������ ����)
-- PL-SQL (����, ���, ....) ��ޱ�� (Ʈ����, Ŀ��, ���ν��� ) 

-- nvl() null�� ó���ϴ� �Լ�
-- decode() >> java�� if��  >> ��� ������ (�м�) >> pivot, cube, rollup
-- case() >> java switch�� 

select comm, nvl(comm, 0) from emp;

create table t_emp(
    id number(6), -- ���� 6�ڸ�
    job nvarchar2(20) -- unicode ������, �ѱ� 2byte ����ϰڴ� 20�� >>  40byte
    -- nvarchar(20)�̶���ϸ� �ѱ��� 10����... ����� 20��,,, �̷��� �򰥸��Ƿ� �ѱ۱ǿ����� ���� nvarchar2�� ���� unicode ü���� ���� ���   
)

desc t_emp;

insert into t_emp(id,job) values(100,'IT');
insert into t_emp(id,job) values(200,'SALES');
insert into t_emp(id,job) values(300,'MANAGER');
insert into t_emp(id,job) values(400);
insert into t_emp(id,job) values(500,'MANAGER');
commit;

SELECT * FROM T_EMP;

select id, decode(id, 100,'����Ƽ', 
                      200,'������', 
                      300,'������',
                          '��Ÿ�μ�') as �μ��̸�  
from t_emp;

select empno, ename, deptno, decode(deptno, 10, '�λ��', 
                                            20, '������',
                                            30, 'ȸ���',
                                            40, '�Ϲݺμ�',
                                                'ETC') as �μ��̸�
 from emp;
               
create table t_emp2(
    id number(2),
    jumin char(7) -- �������� ���ڿ�
);

desc t_emp2;

insert into t_emp2(id, jumin) values(1, '1234567');
insert into t_emp2(id, jumin) values(2, '2234567');
insert into t_emp2(id, jumin) values(3, '3234567');
insert into t_emp2(id, jumin) values(4, '4234567');
insert into t_emp2(id, jumin) values(5, '5234567');
commit;

select * from t_emp2;

/*
t_emp2 ���̺��� id, jumin �����͸� ����ϵ� jumin �÷��� ���ڸ��� 1�̸�
����, 2�̸� ����, 3�̸� �߼� �׿ܴ� ��Ÿ��� ����ϼ��� (�÷����� ����)
*/
select id, decode(substr(jumin,1,1), 1, '����', 2,'����', 3,'�߼�', '��Ÿ') as ����  
from t_emp2;

-- if �ȿ� if �� �� �־��
-- decode(decode())
select * from emp;


select decode(deptno, 20, decode(
                        ename, 'SMITH', 'HELLO', 'WORLD'
                        ), 'ETC')
from emp;

-- CASE ��
/*
CASE ���ǽ� WHEN ���1 THEN ���1
           WHEN ���2 THEN ���2
           WHEN ���3 THEN ���3
           WHEN ���4 THEN ���4
           ELSE ���5
END "�÷���"
*/
create table t_zip(
    zipcode number(10)
);
desc t_zip;
insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(41);
commit;

select * from t_zip;

select '0' || to_char(zipcode), case zipcode when 2 then '����'
                                             when 31 then '���'
                                             when 41 then '����'
                                             else '��Ÿ' 
                                    end �����̸�         
from t_zip;

/*
��� ���̺��� ����޿��� 1000 �޷� ���ϸ� 4��
1001�޷� 2000�޷� ���ϸ� 3��
2001�޷� 3000�޷� ���ϸ� 2��
3001�޷� 4000�޷� ���ϸ� 1��
4001 �޷� �̻��̸� 'Ư��'�̶�� �����͸� ����ϼ���
1. 
CASE �÷��� WHEN ���1 THEN ���1

2. 
���ǽ� �ʿ��ϴٸ�
CASE WHEN ���� �񱳽� THEN ���
     WHEN ���� �񱳽� THEN ���
     ELSE 
END    
*/
SELECT * FROM EMP;
select sal, case  when sal between 0 and 1000 then '4��'
                     when sal between 1001 and 2000 then '3��'
                     when sal between 2001 and 3000 then '2��'
                     when sal between 3001 and 4000 then '1��'
                     else 'Ư��' 
                end ����޿�         
from emp;

------------------------------------------------------------------
-- 75page
/*
1. count(*) >> row�� , count (�÷���) >> ������ �Ǽ�
2. sum()
3. avg()
4. max()
5. min()
��Ÿ

1. �����Լ��� group by ���� ���� ���
2. ��� �����Լ��� null �� ����
3. select ���� ���� �Լ� �̿ܿ� �ٸ� �÷��� ���� �ݵ�� �� �÷��� group by ���� ���
*/

select count (*) from emp; -- 14���� row
select count (empno) from emp; --14��
select count (comm) from emp; --6 (null �̴� ������ count)
select count (nvl(comm, 0)) from emp; -- 14�� 

-- �޿��� ��
select sum (sal) from emp;
select trunc(avg(sal)) from emp;

-- ����� .... �� ������ �󸶳� ���޵Ǿ���
select sum (comm) from emp; -- 4330

-- null ��� (�ʿ��)
-- ������ ����� ����? (�޴� ��� ����)
select trunc(avg(comm),0) from emp; --721 
select (300+200+30+300+3500+0)/6 from dual; -- 721
select comm from emp;

-- ����� ����
select (300+200+30+300+3500+0)/14 from dual; -- 309
select trunc(avg(nvl(comm, 0))) from emp; --  309

-- �Ѵ� �´� (�ǹ�)
-- 309 1 1
-- 721 1 1

select max (sal) from emp;
select min (sal) from emp;

select sum(sal), avg(sal), max(sal), min(sal), count(*), count(sal)
from emp;

select empno, count(empno) from emp; -- 00937. 00000 - not a single-group group function" 
-- empno�� 14��, count(empno)�� 1�� ������ row���� ���� �ʴ�.

-- �μ��� ��� �޿��� ���ϼ���
select deptno, avg(sal) --select ���� ���� �Լ� �̿ܿ� �ٸ� �÷��� ���� �ݵ�� �� �÷��� group by ���� ���
from emp
group by deptno;

-- ������ ��� �޿�
select job , avg(sal)
from emp
group by job;

select  avg(sal)
from emp
group by job; -- �������� ���� �����. (�Ǵ��� �� �����)

select job, trunc(avg(sal),1), sum(sal), max(sal), min(sal), count(sal)
from emp
group by job;

/*
group
distinct �÷���1, �÷���2
order by �÷���1, �÷���2
group by �÷���1, �÷���2
*/

-- �μ��� , ������ �޿��� ���� ���ϼ���
select deptno, job, sum(sal), count(sal)
from emp
group by deptno, job
order by deptno; -- �μ���ȣ .. �׾ȿ��� ������ �׷� .. �հ�
/*
select�� 4
from�� 1
where�� 2
group by�� 3 ***********
order by�� 5
*/

-- ������ ��ձ޿��� 3000�޷� �̻��� ����� ������ ��ձ޿��� ����ϼ���
select job, avg(sal) as avgsal
from emp
-- where avg(sal) > 3000
group by job
having avg(sal) >= 3000;
--from ���� ������ >> where
--group by ���� ������ >> having (�����Լ� ������ ó��)

/*
select��     5
from��       1
where��      2
group by��   3 ***********
having ��    4
order by��   6

���� ���̺� ó���� �� �ִ� ��� ����
*/

/* 
������̺��� ������ �޿����� ����ϵ� ������ ���� �ް� �޿��� ���� 5000 �̻��� 
������� ����� ����ϼ���  (comm 0�� �� �޴� ������ ....)
�޿��� ���� ���� ������ ����ϼ��� 
*/
select job, sum(sal) as �޿���
from emp
where comm is not null 
group by job
--having (sum(nvl(comm,0))+sum(sal)) >= 5000
having sum(sal) >= 5000
order by �޿���;

/* ������̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ ,�ο��� , �޿��� ���� ����ϼ��� */
select deptno  , count(*) as �μ����ο���, sum(sal) as �μ����޿�����
from emp
group by deptno
having count(*) > 4;
-- select count(*) from emp where job is null; -- null���� Ȯ������

/* ������̺��� ������ �޿��� ���� 5000�� �ʰ��ϴ� ������ �޿��� ���� ����ϼ���
�� �Ǹ�����(salesman) �� �����ϰ� �޿������� �������� �����ϼ��� */
select job, sum(sal) as �޿���
from emp
where job != 'SALESMAN'
group by job
having sum(sal) > 5000
order by �޿��� desc;

--------------------------------------------------------------------------------------

--HR �������� �̵��ϼ���
show user;
/*
1. EMPLOYEES ���̺��� �̿��Ͽ� ���� ���ǿ� �����ϴ� ���� �˻��ϼ���. 
2005�����Ŀ� �Ի��� ��� �߿� �μ���ȣ�� �ְ�, �޿��� 5000~10000 ������ ����� �˻��մϴ�. 
��) ���̺� : employees 
��) �˻� : employee_id, last_name, hire_date, job_id, salary, department_id 
��) ����
    �� 2005�� 1�� 1�� ���� �Ի��� ���
    �� �μ���ȣ�� NULL�� �ƴ� ��� 
    �� �޿��� 5,000���� ũ�ų� ����, 10,000 ���� �۰ų� ���� ��� 
    �� ���� ������ ��� �����ϴ� ���� �˻� 
��) ����: department_id ��������, salary ��������
*/
select * from EMPLOYEES;

select employee_id, last_name, hire_date, job_id, salary, department_id
from employees
where to_char(hire_date, 'YYYYMMDD') > '20050101' -- hire_date > '2005/01/01' ���ε� ����
    and department_id is not null
    and salary between 5000 and 10000
order by department_id asc, salary desc;


/*
2. EMPLOYEES ���̺��� �̿��Ͽ� ���� ���ǿ� �����ϴ� ���� �˻��ϼ���. 
�μ���ȣ�� �ְ�, �μ��� �ٹ� �ο����� 2�� �̻��� ���� �˻��Ͽ� �μ��� �ִ� �޿��� �ּ� �޿��� �����
�� �� ���̸� �˻��մϴ�. 
��) ���̺� : employees 
��) �˻� : department_id, MAX(salary), MIN(salary), difference 
        - MAX(salary) �� MIN(salary)�� ���̸� DIFFERENCE�� �˻� 
��) ����
    �� �μ���ȣ�� NULL�� �ƴ� ��� 
    �� �μ��� �ٹ� �ο����� 2�� �̻��� ���� 
��) �׷� : �μ���ȣ�� ���� ��
��) ���� : department_id 
*/

select department_id, MAX(salary), MIN(salary), (max(salary)-min(salary)) as difference
from employees
where department_id is not null
group by department_id
having count(*) >= 2
order by department_id;

--------------------------------------------------------------------------------------------------
------------------------ ���� ���̺� ���� end-------------------------------------------------------
-- ETC
-- create table ���̺� �� (�÷��� Ÿ��, �÷��� Ÿ��)
create table member3 (age number);

-- ������ 1��
insert into member3(age) values(100);

-- ������ ������
insert into member3(age) values(200);
insert into member3(age) values(300);
insert into member3(age) values(400);

----------------------------------------------------------------------------------------------------
/*
JAVA
class Member3 { private int age;  setter , getter}

-- 1��
Member3 member = new Member3();
m.setAge(100);

-- �ټ��� ������
List < Member3> mlist = new ArrayList<>();
mlist.add(new Member3(100));
mlist.add(new Member3(200)); 

������ Ÿ��
���ڿ� ������ Ÿ��
char(10)        >> 10byte   >> �ѱ� 5��, ������, Ư������, ���� 10�� ǥ������ >> �������� ���ڿ�
varchar2(10)    >> 10byte   >> �ѱ� 5��, ������, Ư������, ���� 10�� ǥ������ >> �������� ���ڿ�

�������� (�����Ϳ� ������� ũ�⸦ ���°�)
�������� (������ ������ ũ�⸸ŭ Ȯ��)

char(10) >> 'abc' >> [a][b][c][][][][][][][] >> ������ ũ��� ��ȭ ����.
varchar2(10) >> 'abc' >> [a][b][c] >> ������ ũ�� ��ŭ ���� Ȯ��

�������� varchar2(10)

���� ..... ������ �˻� >> char() >> �������� ....�������ٴ� �� �ռ� �˻�

char(2) : �������� (��,��......��,��,��,,,,,, �ֹι�ȣ) �˻� ����
�������� ���ڿ� (����� �̸�, ���, �ּ�)

�ѱ�, ����� >> �� ���� >> unicode >> �ѱ�, ���� >> 2byte

nchar(20) >> 20�� >> ������ Ư������ ���� ������� >> 40byte
nvarchar(20) >> 20�� 
** ��/���� ���� �� ���� �����ڵ� character : nchar, nvarchar�� �������.



*/

-����Ŭ �Լ� ......�ѱ� 3Byte ���� Ȯ���ϱ�
select * from SYS.NLS_DATABASE_PARAMETERS;
--NLS_CHARACTERSET  : 	AL32UTF8  �ѱ� 3byte �ν�
--KO16KSC5601 2Byte (���� ��ȯ�ϸ� �ѱ� �ٱ���)
select * from nls_database_parameters where parameter like '%CHAR%';
------------------------------------------------------------------------------
create table test2(name varchar2(2));

insert into test2(name) values('a');
insert into test2(name) values('aa');
insert into test2(name) values('��'); --�ѱ� 1�� 3byte ����
-------------------------------------------------------------------------------
-- Join (�ϳ� �̻��� ���̺��� ������ ��������)
-- ���� �䱸�ϴ� ���
/*
2. Join �� ���� 
Join ��� ����
Cartesian Product ��� ������ ����� Join
Equijoin Join ������ ��Ȯ�� ��ġ�ϴ� ��� ���(�Ϲ������� PK �� FK ���)
Non-Equijoin Join ������ ��Ȯ�� ��ġ���� �ʴ� ��쿡 ���(���,����)
Outer Join Join ������ ��Ȯ�� ��ġ���� �ʴ� ��쿡�� ��� ����� ���
Self Join �ϳ��� ���̺��� ����� Join �ϰ��� �� ��쿡 ���
Set Operators ���� ���� SELECT ������ �����Ͽ� �ۼ��Ѵ�.

Equijoin Join
Non-Equijoin Join
Outer Join Join
Self Join

������ DB (RDBMS)

���� (���̺�� ���̺���� ����)
(Ŭ���� (�ڹ�) ��) >> �������� ����

1   :   1
1   :   N (70%)
M   :   N
*/

show user --Kosa

/*
create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;
*/

select * from M;
select * from S;
select * from X;

--1. �����(equi join)
-- �����̺�� �����Ǵ� ���̺� �ִ� �÷��� �����͸� 1:1 ����
-- SQL JOIN ����(����Ŭ) ����
-- ANSI ���� ���� >> ������ >> [inner] join  on ������

select m.m1, m.m2, s.s2
from m, s
where m.m1 = s.s1;

--ANSI (ǥ�ع���)
select * 
from m join s -- m inner join s 
on m.m1 =s.s1;


select * from emp;
select * from dept;

-- �����ȣ, ����̸�, �μ���ȣ, �μ��̸��� ����ϼ���
select emp.empno, emp.ename, emp.deptno, dept.dname 
from emp join dept
on emp.deptno = dept.deptno;

-- ���� (���̺� ����Ī(alias) �ο�)
select e.empno, e.ename, e.deptno, d.dname 
from emp e join dept d
on e.deptno = d.deptno;

-- ������ select * �ϰ� ���� �÷��� ���
select s.s1, s.s2, x.x2
from s join x
on s.s1 = x.x1;

select * 
from m join s 
on m.m1 =s.s1
join x
on m.m1 = x.x1;
