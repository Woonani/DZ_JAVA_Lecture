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
---------------------------------------------------------------------------------------------- 

