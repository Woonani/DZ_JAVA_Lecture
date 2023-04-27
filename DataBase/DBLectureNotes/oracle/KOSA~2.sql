-- �׽�Ʈ 
select sysdate from dual;
-------------------------------------------------
--SQL JOIN���� (�ܼ�)
select * 
from m, s, x
where m.m1 = s.s1 and s.s1 = x.x1;

-- ANSI ���� (����)
select * 
from m join s on m.m1 = s.s1
       join x on s.s1 = x.x1;
--     join y on x.x1 = y.y1; ��� �ٿ����� ���� ���̺� ���� ����!

-- HR���� �̵�
show user;

-- USER��(��) "HR"�Դϴ�.
select * from employees;
select * from departments;
select * from locations;

select count(*) from employees;
-- ���, �̸�(last_name), �μ���ȣ, �μ��̸��� ����ϼ���
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d 
on e.department_id = d.department_id; 
-- ������� 107�� ������ join���� ���� �����ʹ� 106�� >> �����ڰ� ����
select * from employees;
select * from employees where department_id is null; -- �����ִٰ� >> outer join


-- ���, �̸�(last_name), �μ���ȣ, �μ��̸�, �����ڵ�, ���ø��� ����ϼ���
select * --e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d on e.department_id = d.department_id
                 join locations l on d.location_id = l.location_id;


-- KOSA ���� �̵�
show user;
-- USER��(��) "KOSA"�Դϴ�.
select * from emp;
select * from salgrade;

--  ����� ��� (�ϳ��� �÷����� ���� �ȵǿ�) >> �÷� 2��
-- �� ����(non-equi) 1:1
-- ���� ��� ���� (�ǹ�)

select * -- e.empno, e.ename, d.grade, e.sal
from emp e join salgrade d 
on e.sal between d.losal and d.hisal;



--outer join (equi  ���� ����ǰ� ���� >> �����ִ� �����͸� �������� ���)
-- 1. ���� ���� (������ �Ǵ� �ʿ� �����ִ� �����͸� �������� ���)
-- 2.  left outer join 
-- 2.1 right outer join
-- 2.2 full outer join ( left, right >> union)

select * 
from m left outer join s
on m.m1 = s.s1;

select * 
from m right outer join s
on m.m1 = s.s1;

select * 
from m full outer join s
on m.m1 = s.s1;

-- show user; -- HR ����
-- �Ʊ� ���� ����
-- ���, �̸�(last_name), �μ���ȣ, �μ��̸��� ����ϼ���
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e left join departments d 
on e.department_id = d.department_id; 
-- ������� 107�� >> ������ �ذ�

-- self join (�ڱ�����) -> ���� ���� ���� -> �ǹ̸� ���� ->  � join ����
-- �ϳ��� ���̺� �ִ� �÷��� �ڽ��� ���̺� �ִ� Ư�� �÷��� �����ϴ� ���
select * from emp;
-- smith  ����� ��� �̸�
-- ��� ���̺�, ������ ���̺� ����� ����..... >> �ߺ�������..
-- ���̺� ����Ī >> 2��, 3�� �ִ� ��ó��
select e.empno, e.ename, m.empno, m.ename
from emp e join emp m
on e.mgr = m.empno;
-- 13�� ...
-- 14�� ... >> 
select e.empno, e.ename, m.empno, m.ename
from emp e left join emp m
on e.mgr = m.empno;
-----------------------------------------------------------------------------------------------------------
-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�.
select  ename, empno, dname 
from emp e left join dept d on e.deptno = d.deptno;
?

-- 2. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸���
-- ����϶�.

select e.ename, e.job, e.deptno, m.dname
from emp e join dept m
on e.deptno = m.deptno
where loc = 'DALLAS';

-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�.

select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where ename like '%A%';


-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�.

select ename, dname, sal
from emp e left join dept d
on e.deptno = d.deptno
where sal >= 3000;


-- 5. ����(����)�� 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�.

select job, ename, dname
from emp e left join dept d
on e.deptno = d.deptno
where e.job = 'SALESMAN';

?
-- 6. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�.
--(�� ) 1 : 1 ���� ��� �÷��� ����

select empno as "�����ȣ", ename as "����̸�", sal as "����", (sal+comm) as "�Ǳ޿�", grade as "�޿����"
from emp e join salgrade s on e.sal between s.losal and s.hisal 
where e.comm is not null;

/*
SELECT         E.EMPNO AS "�����ȣ",
               E.ENAME AS "����̸�",
               E.SAL*12 AS "����",
               --E.SAL*12+NVL(COMM,0) AS "�Ǳ޿�",
               E.SAL*12+COMM AS "�Ǳ޿�",
               S.GRADE AS "�޿����"
FROM EMP E  join SALGRADE S on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.Comm is not null;
*/


-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�.
-- inner �� ���� ����

select d.deptno, d.dname, e.ename, e.sal, s.grade
from emp e left join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where d.deptno = 10;

-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�.
-- inner �� ���� ����
select * from emp ;
select * from dept;
select * from salgrade;

select * 
from emp e left join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where d.deptno in(10,20)
order by d.deptno asc, e.sal desc;

--
--select d.deptno, d.dname, e.ename, e.sal
--from emp e left join dept d
--on e.deptno = d.deptno
--where d.deptno = 10 or 20 -- in (10, 20)
--order by depno asc, sal desc;
/*
SELECT E.DEPTNO, D.DNAME, E.ENAME, E.SAL, S.GRADE
FROM EMP E  join DEPT D        on E.DEPTNO=D.DEPTNO
            join SALGRADE S    on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE  E.DEPTNO<=20 --WHERE E.DEPTNO IN (10,20)  -- e.deptno = 10 or 
ORDER BY E.DEPTNO ASC,  E.SAL DESC;
*/

-- ?????????????????????????????????????????????????????????????????????????????????????????????????????????????�޸��忡�� ���� �߸���

-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�.
--SELF JOIN (�ڱ� �ڽ����̺��� �÷��� 
select * from emp;

select e1.empno as "�����ȣ", e1.ename as "����̸�", e2.empno as "�����ڹ�ȣ", e2.ename as "�������̸�"
from emp e1 join emp e2 on e1.mgr = e2.empno;

-----------------------------------------------------------
-- ��� ���̺��� ������� ��� ���޺��� �� ���� ������ �޴� ����� ���, �̸�, �޿��� ����ϼ���.
--1. ��ձ޿�
select avg(sal) from emp; --  ��ձ޿� 2073

select empno, ename, sal
from emp
where sal > 2073;

-- 2���� ���� ���� (�ϳ��� ����)
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
-- ????????????????????????????????????????????????????????????????????????????????????????????????????????????

--------------------------------------------------------------------------------
--JOIN END----------------------------------------------------------------------

--subquery(��������) 100page
--sql �� .....���� �ذ�� 

--1. �Լ� > ���� ���̺� > ���� ���̺� (join , union) > �ذ� �ȵǿ� >> subquery �ذ�

--������̺��� ������� ��� ���޺��� �� ���� ������ �޴� ����� ���, �̸�, �޿��� ����ϼ���

--1. ��ձ޿�
select avg(sal) from emp; --��ձ޿� 2073

select empno , ename , sal 
from emp
where sal > 2073;

--2���� ���� ���� (�ϳ��� ����)

select empno , ename , sal 
from emp
where sal > (select avg(sal) from emp);


-- subquery
/*
1. single row subquery : �������� ���� �÷��� ���Ϸο� ���� ��� (�Ѱ��� ��)
ex) select sum(sal) from emp, select max (sal) from emp
������ : = , != , < , >

2. multi row subquery : ���� ����� ���� �÷��� �������� �ο찪�� ���
ex) select deptno from emp, select sal from emp
������ : IN, NOT IN, ANY, ALL
ALL : sal > 1000 and sal > 40000 and .....
ANY : sal > 1000 or sal > 40000 or .....

����) 
1. ��ȣ�ȿ� �־�� �Ѵ�. (select max(sal) from emp)
2. ���� �÷����� �����Ǿ�� �Ѵ�. (select max(sal), min(sal) from emp) �������� �ȵǿ�. (x)
3. ���������� �ܵ����� ���� ���� 

���������� ���� ����
1. �������� ����ǰ� �� ����� ������
2. ���� ������ ����ȴ�.

TIP)
select (subquery) >> scala subquery
from (subquery) >> in line view (���� ���̺�)
where (subquery) >> ����
https://gent.tistory.com/464 ���� -- 512 ���� ?

*/

-- ��� ���̺��� jones�� �޿����� �� ���� �޿��� �޴»���� ���, �̸�, �޿��� ����ϼ���
select empno, ename, sal
from emp
where sal > (select sal from emp where ename = 'JONES');

-- �μ���ȣ�� 30���� ����� ���� �޿��� �޴� ��� ����� ������ ����ϼ���
(select sal from emp where deptno = 30); -- multi row

select *
from emp
where sal in (select sal from emp where deptno = 30);
--where sal = (select sal from emp where deptno = 30); -- =  ����  multi  query �� �ȵ�
-- sal = 1600 or sal=1250 or ...

-- �μ���ȣ�� 30���� ����� �ٸ� �޿��� �޴� ��� ����� ������ ����ϼ���
select *
from emp
where sal not in (select sal from emp where deptno = 30);
-- sal != 1600 or sal != 1250 or ...

-- ���������� �ִ� ����� ����� �̸��� ����ϼ���
-- �� ����� mgr �÷��� �ִٸ� ���� ..^^
select empno, ename
from emp
where empno in (select mgr from emp); --  ����� ���

-- ���������� ���� ����� ����� �̸��� ����ϼ���
select empno, ename
from emp
where empno not in (select nvl(mgr,0) from emp); --  ���Ե� ���
-- null �� ������ �ȳ��� : not in�� and �����̱� ������ --
-- �ܿ��� : not in�� ������ and


-- king ���� �����ϴ� �� ���ӻ���� king�� ����� ���, �̸�, ����, ������ ����� ����ϼ���
select empno, ename, job, mgr
from emp
where mgr in (select empno from emp where ename = 'KING');


-- 20�� �μ��� ����߿��� ���� ���� �޿��� �޴� ������� �� ���� �޿��� �޴� �����
-- ���, �̸�, �޿�, �μ���ȣ�� ����ϼ���
select empno, ename, sal, deptno
from emp
where sal > ( select max(sal) from emp where deptno = 20);

-- ��Į�� ��������
select e.empno, e.ename, e.deptno, (select d.dname from dept d where d.deptno = e.deptno)
from emp e
where e.sal >= 3000;

--#############################
--�ǹ����� ���� ��� (���߱�)
--hint) ���࿡ �μ���ȣ�� �μ��� ��� ������ ����ִ� ���̺��� �����ϴٸ� (�޸𸮿�)
--in line view 
-- �ڱ� �μ��� ��� ���޺��� �� ���� ������ �޴� ����� ���, �̸�, �μ���ȣ, �μ��� ��� ���� ����ϼ���

-- ������ Ǯ��
select a.empno, a.ename, a.deptno, a.sal, b.avgsal 
from emp a join (select deptno, trunc(avg(sal), 0) as avgsal from emp group by deptno) b 
on a.deptno = b.deptno
where a.sal > b.avgsal;

-- �� Ǯ��
select a.empno, a.ename, a.deptno, a.sal, b.avgsal
from emp a
    ,(select  d.deptno, trunc(avg(sal)) as avgsal
    from emp e left join dept d on e.deptno = d.deptno
    group by d.deptno) b
where a.deptno = b.deptno and a.sal > b.avgsal;

------------------------------------------------------------------------------------------------------------
--subquery END----------------------------------------------------------------------------------------------
--�������� (25�б���)
/*
--1. 'SMITH'���� ������ ���� �޴� ������� �̸��� ������ ����϶�.

--2. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����,
-- �μ���ȣ�� ����϶�.

--3. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ�
-- 'BLAKE'�� ���� ����϶�.

--4. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����϶�.

--5. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
-- �ִ� ����� �����ȣ�� �̸��� ����϶�.

--6. 30�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
-- ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����϶�.
--(��, ALL(and) �Ǵ� ANY(or) �����ڸ� ����� ��)

--7. 'DALLAS'���� �ٹ��ϰ� �ִ� ����� ���� �μ����� ���ϴ� �����
-- �̸�, �μ���ȣ, ������ ����϶�.

--8. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����϶�.

--9. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�
--king �� ����� ��� (mgr �����Ͱ� king ���)

--10. �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�� ����
-- ����� ������ �μ����� �ٹ��ϴ� ��� ����� �����ȣ, �̸�,
-- �޿��� ����϶�.

--11. Ŀ�̼��� �޴� ����� �μ���ȣ, ������ ���� �����
-- �̸�, ����, �μ���ȣ�� ����϶�.

--12. 30�� �μ� ������ ���ް� Ŀ�̼��� ���� ����
-- ������� �̸�, ����, Ŀ�̼��� ����϶�.
*/

-- 1��
select ename, sal
from emp
where sal > (select sal from emp where ename ='SMITH'); 

-- 2��
select ename, sal, deptno
from emp
where sal IN (select sal 
from emp 
where deptno = 10);

--select sal from emp where deptno = 10;

--3 ��

select ename, hiredate
from emp
where deptno = (select deptno 
from emp
where ename = 'BLAKE') and ename != 'BLAKE';

-- 4��
--select trunc(avg(sal), 0) 
--from emp;
select empno, ename, sal
from emp
where sal > (select trunc(avg(sal), 0) from emp)
order by sal desc;

-- 5��
--select distinct deptno 
--from emp
--where ename like '%T%';

select empno, ename
from emp
where deptno IN (select distinct deptno 
from emp
where ename like '%T%');

/* �ٽ� ���� ****
SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                FROM EMP
                WHERE ENAME LIKE '%T%');
*/

-- 6�� **
--select max(sal)
--from emp
--where deptno = 30;
select ename, deptno, sal
from emp
where sal > (select max(sal)
from emp
where deptno = 30);

/* �߿�************************
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > ALL(SELECT SAL
                FROM EMP
                WHERE DEPTNO=30)
 
--where sal > 1600 and sal > 1250 and sal > 2850 and sal > 1500 and sal > 950
 
*/


-- 7��
select deptno, ename, job
from emp
where deptno = (select deptno  -- IN ����
from dept
where loc = 'DALLAS');

-- 8��
select deptno, ename, job
from emp
where deptno = (select deptno 
from dept
where dname = 'SALES');

-- 9 ��
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING');

--10��
select empno, ename, sal
from emp
where deptno = (
select distinct deptno 
from emp
where sal >(select trunc(avg(sal), 0) 
from emp) and ename like '%S%');

/*
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP)
AND DEPTNO IN(SELECT DEPTNO
              FROM EMP
              WHERE ENAME LIKE '%S%');
              
  �Ǵ�            
--select * from emp
--where  deptno in  (
--                      select deptno from emp where sal > (select avg(sal) from emp)
--                      and ename like '%S%'
--                   )
*/

-- 11��

select *
from emp
where deptno IN (select distinct deptno
from emp
where comm is not null) 
and sal IN (select distinct deptno
from emp
where comm is not null);

-- 12��


/*
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                FROM EMP
                WHERE COMM IS NOT NULL)
AND SAL IN( SELECT SAL
            FROM EMP
            WHERE COMM IS NOT NULL);
            
            
SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL NOT IN(SELECT SAL
                 FROM EMP
                 WHERE DEPTNO=30)
AND COMM NOT IN(SELECT NVL(COMM, 0)
                FROM EMP
                WHERE DEPTNO=30 and comm is not null);       
            
*/

--------------------------------------------------------------------------------
--subquery END------------------------------------------------------------------
-- �� 8��    SQL*Plus ����� ���� �����ϼ���
-- �� 9�� ���̺� ����
-- �� 10�� ������ ����
-- ������ 10�� ���� �ϰ� ... 9�� �ϵ��� �ϰڽ��ϴ�.
--------------------------------------------------------------------------------
--TIP)
select * from emp order by 1,2,3; --1,2,3��° �÷� ������ �������� ����
                                  -- order by empno , ename , job ����
                                  
select deptno ,sal , empno from emp order by 1 desc,2; 
                                  -- order by deptno desc , sal asc ����
                                  
/*                                  
���ݱ��� �ʱ� ������ �ʼ� ����
select
from 
where 
group by
having
order by
+
�⺻ �Լ� (����,����,��¥,��ȯ,�Ϲ�,����)
+ 
�������̺� (JOIN , UNION)
+
subquery ���� 
+ 
�⺻���� DML ���� (�ʼ� �ϱ�) �Դϴ�
                                 
*/                        
--------------------------------------------------------------------------------
--������ ����(DML) �Դϴ�
-- 168 page
-- insert, update, delete ( �ݵ�� �ϱ�)

/*
DDL (������ ���Ǿ�) :  create, alter, drop, truncate, rename, modify 
--      (truncate : )
DML (������ ���۾�) : Ʈ������� ����Ű�� �۾� : insert, update, delete
ex) ������ ... ȸ�� ���ڱ� ...DB select �� �Ǵµ� insert, update, delete  �ȵǿ�
    >> ���ڱ� log write �� �����ϴ� �۾� (���� ���� � ���̺� �����۾��� �ߴ��� ���)
    >> DISK ��� (log file full) >>  log write �ȵǸ� >> DML �۾� ����
    >> log backup >> log  ���� .....
    
    >> commit ���� ���� ��� .....   �ǽ�..... �ϻ� �ٹݻ�ϱ� �����ϱ�! 
DQL (������ ���Ǿ�) :  select    -- QUERY �� q
DCL (������ �����) :  ������ : grant, revoke     -- control �� c
TCL (Ʈ�����)     :  commit, rollback, savepoint

*/
-- ����Ŭ  insert, update, delete  �۾� �ݵ�� commit , rollback  ó��
-- Tip) tab, col ���̺� ����ϱ�
select * from tab; -- �����(KOSA) ������ ������ �ִ� ���̺� ���

-- ���� ���̺��� ���� .. �� �̸��� �ִ��� ������
select * from tab where tname = 'BOARD';
select * from tab where tname = 'EMP';
select * from col where tname = 'EMP';
---------------------------------------------------------------------------------
-- insert, update, delete ������ �ϱ�

-- 1. INSERT
create table temp(
    id number primary key, -- not null, unique �ްڴ� (ȸ�� ID, �ֹι�ȣ)
    name varchar2(20)
);
desc temp; -- temp ������ �� �� ����.

--1. �Ϲ�����  insert
insert into temp(id, name)
values(100, 'ȫ�浿');
--commit, rolback �ϱ� ������ �ǹݿ����� �ʾƿ�
select * from temp;
commit;

--2. �÷� ����� ����( insert ) ���� ������
insert into temp
 values(200, '������');

 select * from temp;
 rollback; -- Ŀ�� �� �ѹ��ϸ� insert �� �ǵ��� �� �ִ�.
 
 -- 3. ����  ... insert
 insert into temp(name)
 values('�ƹ���');
 -- �ڵ� id �÷� >> null >> PK >> ORA-01400: cannot insert NULL into ("KOSA"."TEMP"."ID")
 -- null �� ���� �� ������ �־ ����
 
 insert into temp(id, name)
 values(100, '������');
 -- PK >> id >> �ߺ� ������(x) >> ORA-00001: unique constraint (KOSA.SYS_C007003) violated
 
 insert into temp (id, name)
 values(200, '������');
 
 select * from temp;
 commit;
 
 ------------------------------------------------------------------------------------------
 --Tip
 --SQL �� ���α׷��� ��� (x) 
 --PL-SQL ����, ���
 
 create table temp2(id varchar2(50));
 desc temp2;
 
 --PL-SQL
 -- for(int i =1; i <= 100; i++) { }
 /*
 BEGIN
    FOR i IN 1..100 LOOP
        insert into temp2(id) values('A' || to_char(i));
    END LOOP;
 END;
 -- ��� ��� ����, ���� �� �ּ� �ʼ� : PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
 */
 select * from temp2;
 
 create table temp3(
    memberid number(3) not null, -- 3�ڸ� ����
    name varchar2(10), -- null  ���
    regdate date default sysdate --���̺� �⺻�� ���� (insert ���� ������ �ڵ� (��¥) ���� �ϰڴ�)
 );
 desc temp3;
 
 select sysdate from dual;
 
 --1. ����
 insert into temp3 (memberid, name, regdate)
 values(100, 'ȫ�浿', '2023-04-19');
 
 select * from temp3;
 commit;
 
 --2. ��¥
 insert into temp3 (memberid, name)
 values(200, '������');
 
 select * from temp3;
 commit;
 
 --3. �÷� �ϳ�
 insert into temp3(memberid)
 values(300);
 
 select * from temp3;
 commit;
 
 -- 4. ����
 insert into temp3 (name) -- id null �� >> not null
 values('�ϴ���');
 -- ORA-01400: cannot insert NULL into ("KOSA"."TEMP3"."MEMBERID")
 
 --------------------------------------------------------------------------------
--TIP)
create table temp4(id number);
create table temp5(num number);

desc temp4;
desc temp5;
 
insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
insert into temp4(id) values(10);
commit;
         
select * from temp4;
--�뷮 ������ �����ϱ�
select * from temp5;
--temp4 ���̺� ��� �����͸� temp5  �ְ� �;��
--insert into ���̺��(�÷�����Ʈ) values ...
--insert into ���̺��(�÷�����Ʈ) select �� *****************^^
-------------------------------------------------?????????????????????????????????????????????????????????????
insert into temp5(num)
select id from temp4; --�뷮 ������ ����

select * from temp5;
commit;

-- 2. �뷮 ������ �����ϱ�
-- ���渦 ���� ���̺� ���� >> ���̺� ����(����) : ��Ű�� + ������ ����
-- �� ���������� ���� �ȵǿ� (PK, FK)
-- ������ ������ ���� + ������

create table copyemp
as 
    select * from emp;
select * from copyemp;
create table copyemp2
as 
    select empno, ename, sal
    from emp
    where deptno = 30;
    
select * from copyemp2;

-- �丷 ����
-- Ʋ�� (��Ű��) ���� �����ʹ� �����ϰ� ���� �ʾƿ�

create table copyemp3
as 
    select * from emp where 1=2; -- �Ϻη� ���� ���� �־ Ʋ�� ����
select * from copyemp3;
/*
create table copyemp4
as 
    select * from emp where 1=1; -- �̷��� �ϸ� �׳� ����
*/

----------------------------------------------------------------------------------------
--INSERT END----------------------------------------------------------------------------

--UPDATE
/*
update  ���̺��
set �÷��� = ��, �÷��� = ��, �÷��� = ��.......
where  ������

update ���̺� ��
set �÷��� = (subquery)
where �÷��� = (subquery)

*/

select * from copyemp;

update copyemp
set sal = 0;

select * from copyemp;

rollback;

update copyemp
set sal = 1111
where deptno = 20;

select * from copyemp;

rollback;

update copyemp
set sal = (select sum(sal) from emp);

select * from copyemp;
rollback;

update copyemp
set ename = 'AAA', job = 'BBB', hiredate = sysdate, sal = (select sum(sal) from emp)
where empno = 7788;

select * from copyemp
where empno = 7788;

commit;
-------------------------------------------------------------------------------------
--UPDATE END-------------------------------------------------------------------------

-- DELETE
delete from copyemp;
select * from copyemp;
rollback;

delete from copyemp
where deptno = 20;

select * from copyemp where deptno = 20;
commit;

-------------------------------------------------------------------------------------
--DELETE END-------------------------------------------------------------------------
drop table test;
select * from test;
create table test(num number, 
                  email varchar(100), 
                  name varchar(50),
                  jumin varchar(14),
                  phonenum varchar(13),
                  postnum varchar(5)
                  );
insert into test(num, email, name, jumin, phonenum, postnum)
values(1, 'dnskdms@naver.com', '�쳪��', '123215-1236485' , '010-1235-1254', '16-14');
insert into test(num, email, name, jumin, phonenum, postnum)
values(2, 'chlgusehd123@naver.com', '������', '123215-1235364', '010-1234-4567', '01614');
insert into test(num, email, name, jumin, phonenum, postnum)
values(3, 'changhyun@gmail.com', '��â��', '123215-1452364', '010-1236-4569', '456');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', '������', '123215-2212364', '010-5486-8456', 'asd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(5, 'asfda@asdf', '�弮��', '123215-12364as', '010-845*466-5', 'asdasd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', '����ȯ', '123215-12364a', '010-  54-5555', '12345');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', 'jackson', '123215-12364a', '010-1--4-----', '125 6');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', 'harry', '123215-2212364', '010-2154-585a', '00202');

-- ����ǥ���� �����
select * from test;
-- ����ǥ���� ����� : �̸���
select * from test
where regexp_like(email, '^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$');



-- ����ǥ���� �����
select * from test;
-- ����ǥ���� ����� : �̸�
select * from test
where regexp_like(name, '^[��-�R]{2,4}$');


-- ����ǥ���� �����
select * from test;
-- ����ǥ���� ����� : �ֹι�ȣ
select * from test 
where regexp_like(jumin ,'^[0-9]{6}+[-]+[0-9]{7}$');

-- ����ǥ���� �����
select * from test;
-- ����ǥ���� ����� : �޴���ȭ��ȣ
select * from test 
where regexp_like(phonenum ,'^[0][1]\d{1}-\d{4}-\d{4}$');

-- ����ǥ���� �����
select * from test;
-- ����ǥ���� ����� : �����ȣ
select * from test 
where regexp_like(postnum ,'^\d{5}$');
