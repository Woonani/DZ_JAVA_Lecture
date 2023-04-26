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
-- 담주 JDBC (JAVA) -MariaDB세팅 (기본작업)
----------------------------------------------------------------------------
--분석함수 학습하기
-- 통계 쿼리 만들기
--집계 행 데이터 >> 열 데이터 바꾸기
--집계 열 데이터 >> 행 데이터 바꾸기
-- 기본(decode, case)사용 (장접 표준화)
-- 11g 버전 부터 (pivot 을 이용 행을 열으로 전환)

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
from (피벗대상 쿼리문에)
pivot (그룹함수(집계컬럼) for 피벗컬럼 in (피벗컬럼값 as 별칭 ...)

오라클 11g부터 PIVOT 기능을 제공합니다
기존 이하 버전에서는 DECODE 함수를 이용하여 row를 column으로 변경하는 작업을 하였습니다
PIVOT 기능을 이용하면 DECODE의 복잡하고 비직관적인 코드를 조금 더 직관적으로 작성할 수 있습니다.
아쉬운 점은 PIVOT 기능을 사용하더라도 PIVOT을 할 컬럼을 미리 정의를 해놓아야한다는 점이다.
*/
--통계, 차트 데이터 구현
-- 직종별, 월별 입사 건수
select * from emp;

select job, to_char(giredate,'FMMM') || '월' as hire_month from emp;
--     1월, 2월, 3월, 4월 ...... 12월 컬럼으로
-- CLERK 0   0   1    2  .....
-- 더존은 통계데이터가 많다. 
decode 12개 >> 1월 ~ 12월

select * 
from (
        select job, to_char(hiredate,'FMMM') || '월' as hire_month from emp
     )
pivot(
        count(*) for hire_month IN('1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월')
     );
    
/*
-- decode로 구현한다면
select job
    , sum(decode(to_char(hiredate, 'FMMM'), '1', 1, 0) "1월"
    /*....*/
    , sum(decode(to_char(hiredate, 'FMMM'), '1', 1, 0) "12월"
from emp
group by job;
*/
----------------------------------------------------------------------------------------------     
-- 직종별
-- 직종별, 부서별 급여 합계
-- select job, deptno, sum(sal) from emp group by job, deptno order by job
select *
from (
         select job, deptno, sal from emp 
    )
pivot (
         sum(sal) for deptno in ('10' as d1, '20' as d2, '30' as d3)
    );
---------------------------------------------------------------------------------------------- 

