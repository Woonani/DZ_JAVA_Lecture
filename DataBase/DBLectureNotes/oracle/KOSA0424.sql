show user;
create table dmlemp
as
    select * from emp;
select * from dmlemp;  
select * from user_constraints where table_name= 'DMLEMP';
alter table dmlemp
add constraint pk_dmlemp_empno primary key(empno);
select * from dmlemp;

select * from emp;
-- 0425
show user;
create table trans_A (
    num number,
    name varchar2(20)
);

create table trans_B (
    num number constraint pk_trans_B_num primary key,
    name varchar2(20)
);

select * from trans_A;
select * from trans_B;

select * from dept;
----------------------------------------------------------------------------
-- ���� JDBC (JAVA) -MariaDB���� (�⺻�۾�)
----------------------------------------------------------------------------
--�м��Լ� �н��ϱ�
-- ��� ���� �����
--���� �� ������ >> �� ������ �ٲٱ�
--���� �� ������ >> �� ������ �ٲٱ�
-- �⺻(decode, case)��� (���� ǥ��ȭ)
-- 11g ���� ���� (pivot �� �̿� ���� ������ ��ȯ)

/*
deptno , cnt 
10          3
20          5
30          6

deptno_10   deptno_20   deptno_30
    3           5           6

*/

select deptno, count(*) as cnt from emp group by deptno asc;

select deptno, case when deptno=10 then 1 else 0 end as dept_10,
                case when deptno=20 then 1 else 0 end as dept_20,
                case when deptno=30 then 1 else 0 end as dept_30
from emp
order by 1; -- = order by deptno asc;
----------------------------------------------------------------------------
select sum( case when deptno=10 then 1 else 0 end )as dept_10,
       sum( case when deptno=20 then 1 else 0 end ) as dept_20,
       sum( case when deptno=30 then 1 else 0 end ) as dept_30
from emp;

----------------------------------------------------------------------------
select max(case when deptno=10 then ecount else null end) as dept_10, 
       max(case when deptno=20 then ecount else null end) as dept_20,
       max(case when deptno=30 then ecount else null end) as dept_30
from (
    select deptno, count(*) as ecount
    from emp
    group by deptno
) x;
----------------------------------------------------------------------------
/*
select *
from (�ǹ���� ��������)
pivot (�׷��Լ�(�����÷�) for �ǹ��÷� in (�ǹ��÷��� as ��Ī ...)

����Ŭ 11g���� PIVOT ����� �����մϴ�
���� ���� ���������� DECODE �Լ��� �̿��Ͽ� row�� column���� �����ϴ� �۾��� �Ͽ����ϴ�
PIVOT ����� �̿��ϸ� DECODE�� �����ϰ� ���������� �ڵ带 ���� �� ���������� �ۼ��� �� �ֽ��ϴ�.
�ƽ��� ���� PIVOT ����� ����ϴ��� PIVOT�� �� �÷��� �̸� ���Ǹ� �س��ƾ��Ѵٴ� ���̴�.
*/
--���, ��Ʈ ������ ����
-- ������, ���� �Ի� �Ǽ�
select * from emp;

select job, to_char(giredate,'FMMM') || '��' as hire_month from emp;
--     1��, 2��, 3��, 4�� ...... 12�� �÷�����
-- CLERK 0   0   1    2  .....
-- ������ ��赥���Ͱ� ����. 
decode 12�� >> 1�� ~ 12��

select * 
from (
        select job, to_char(hiredate,'FMMM') || '��' as hire_month from emp
     )
pivot(
        count(*) for hire_month IN('1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��')
     );
    
/*
-- decode�� �����Ѵٸ�
select job
    , sum(decode(to_char(hiredate, 'FMMM'), '1', 1, 0) "1��"
    /*....*/
    , sum(decode(to_char(hiredate, 'FMMM'), '1', 1, 0) "12��"
from emp
group by job;
*/
----------------------------------------------------------------------------------------------     
-- ������
-- ������, �μ��� �޿� �հ�
-- select job, deptno, sum(sal) from emp group by job, deptno order by job
select *
from (
         select job, deptno, sal from emp 
    )
pivot (
         sum(sal) for deptno in ('10' as d1, '20' as d2, '30' as d3)
    );
------- 0427 --------------------------------------------------------------------------------------- 
select deptno , job , sal from emp;

select *
from (
        select deptno , job , sal from emp
     )
pivot(sum(sal) for job in('PRESIDENT' as p ,'ANALYST' as  a, 'MANAGER' as m , 'SALESMAN' as  s ,'CLERK' as c));     

--Quiz
--������ ��� decode �����ϼ���
SELECT DEPTNO, SUM(DECODE(JOB,'PRESIDENT',SAL)) AS E_PRESIDENT
             , SUM(DECODE(JOB,'ANALYST',SAL)) AS E_ANALYST
             , SUM(DECODE(JOB,'MANAGER',SAL)) AS E_MANAGER
             , SUM(DECODE(JOB,'SALESMAN',SAL)) AS E_SALESMAN
             , SUM(DECODE(JOB,'CLERK',SAL)) AS E_CLERK
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO DESC;
--������ ��� case �����ϼ���
SELECT DEPTNO, SUM(CASE WHEN JOB='PRESIDENT' THEN SAL END) AS E_PRESIDENT
             , SUM(CASE WHEN JOB='ANALYST' THEN SAL END) AS E_ANALYST
             , SUM(CASE WHEN JOB='MANAGER' THEN SAL END) AS E_MANAGER
             , SUM(CASE WHEN JOB='SALESMAN' THEN SAL END) AS E_SALESMAN
             , SUM(CASE WHEN JOB='CLERK' THEN SAL END) AS E_CLERK
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO IS NOT NULL
ORDER BY DEPTNO DESC;
--------------------------------------------------------------------------------
--������̺��� �μ��� �޿��հ�� ��ü �޿����� ����ϼ���
select deptno , sum(sal) from emp group by deptno order by deptno;
select sum(sal) from emp;

select deptno , sum(sal) from emp group by deptno 
union all
select null  ,  sum(sal) from emp;
--------------------------------------------------------------------------------
--Rollup , Cube �Ұ�
--������ �м� ������ ��� (�Ұ踦 ����� ���)

select job , deptno , sum(sal) , count(sal)
from emp
group by job ,deptno
order by job ,deptno;

SELECT job, sum(sal)
FROM emp
GROUP BY ROLLUP(job); --���� ������ �޿��� �յ� ���ϰ�,, ��� ������ �޿��� �յ� ���ϰڴ�.

--delete from emp where job = '������'; -- ���� ������ ������ ����

select job, deptno, sum(sal) -- job�� �Ұ�
from emp
group by rollup (job, deptno); -- ���� �� �÷����� ���꿡�� �����ϹǷ� �÷��� ������ �߿�

select deptno, job,  sum(sal) -- �μ���ȣ �� �Ұ�
from emp
group by rollup (deptno, job);

-- ���� �Ұ� : deptno �� �Ұ�,job�� �Ұ�, ��ü��

select deptno, job, sum(sal)
from emp
group by deptno, job
union all
select deptno, null, sum(sal)
from emp
group by deptno
union all
select null, job, sum(sal)
from emp
group by job
union all
select null, null, sum(sal)
from emp
group by deptno, job;

-- ������ ���� (union) , rollup (��� �÷��� ����� �ȵǿ�) >> cube >> ��� �÷��� �Ұ�
select deptno, job, sum(sal)
from emp
group by cube(deptno , job) -- cube�� �÷����� ��� ���踦 ������
order by deptno, job;

-----------------------------------------------------------------------------------------
-- ���� �Լ�
-- rownum (select�� ����� ����ó��)
--RANK
-- DENSE_RANK
-- ������ ������ ��� (���� ������ ������) (100, 90, 80 (1,2,3 ��), 100, 80, 80, 60(1��))
select * from emp;
select ename, sal,
rank() over(order by sal desc) as rank����,
dense_rank() over(order by sal desc) as dense_rank����2
from emp
order by sal desc;

-- ���� ������ ���� �� �ִ� ��� ������ �� ���� ����
--ȸ��) ����Ʈ ���� �� ����� ������ �ְڴ�
--6�� ���� : ������ �� ����� ,,,, ���Լ�, ���̼�, ... �ߺ����� ������ ���ƶ�

select ename, sal, comm, 
rank() over(order by sal desc, comm desc) as rank���� -- ������ �߰� .... ~~ �� ���� ����
from emp
order by sal desc;

-- ���� (�׷�ȿ��� ���� ���ϱ�)
-- A�� (1,2,3) B group(1,2,3��)

select job, ename, sal, comm,
    rank() over(partition by job order by sal desc, comm desc) as �׷����
from emp
order by job asc, sal desc, comm desc;

-- �����Լ� (���� : select �� �����Լ� �̿ܿ� ������ �÷��� group by ��)
-- in line view (��������) JOIN
-- create view �������̺� JOIN

select job, sum(sal), count(sal)
from emp
where job in ('MANAGER','SALESMAN')
group by job
order by job;

-- �̸�, ��� ����;�� (�ȵǿ�)
select empno, job, sum(sal), count(sal) (x);

-- ���� �ذ�
select empno, ename, job, sum(sal) over (partition by job)
from emp
where job in ('MANAGER','SALESMAN')
order by job;

-- with��
-- PARTITION BY https://cafe.naver.com/erpzone/501
--------------------------------------------------------------------
-- JDBC Ȱ�� ���ν��� �����
/* ��Ÿ �ֳ�  ��.. ��������
create or replace procedure usp_EmpList
(
    p_sal IN number,
    p_cursor OUT SYS_REFCURSOR -- APP ����ϱ� Ÿ��
)
is
    begin
        open p_cursor
        for select empno, ename, sal from emp where sal > p_sal;
    end;
*/
create or replace procedure usp_EmpList
(
  p_sal IN number,
  p_cursor OUT SYS_REFCURSOR -- APP ����ϱ� Ÿ��
)
is
    begin
        open p_cursor 
        for select empno, ename ,sal from emp where sal > p_sal;
    end;

    var out_cursor REFCURSOR
    exec usp_EmpList(2000,:out_cursor)
    print out_cursor;

-- �̹����� insert �ϴ°�!
create or replace procedure usp_Insert_Emp
( -- input parameter 2��
    vempno IN emp.empno%TYPE,
    vename IN emp.ename%TYPE,
    vjob IN emp.job%TYPE,
    p_outmsg OUT varchar2 -- ����� ���� �޼����� ��� ���ڿ��� ������� �ƿ�ǲ (�̰��ϸ� resultSet �ʿ����)
)
is
    begin
        insert into emp(empno, ename, job) values(vempno, vename, vjob);
        commit;
        p_outmsg := 'success'; -- �Ҵ��� �̸�Ƽ�� :=
        EXCEPTION WHEN OTHERS THEN 
        p_outmsg := SQLERRM; -- ����Ŭ�� ���� �޼��� 
        rollback;
    end;
    
alter table emp
add constraint pk_emp_empno primary key (empno);

select * from user_constraints where table_name ='EMP';