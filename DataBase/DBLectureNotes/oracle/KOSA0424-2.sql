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
------- 0427 --------------------------------------------------------------------------------------- 
select deptno , job , sal from emp;

select *
from (
        select deptno , job , sal from emp
     )
pivot(sum(sal) for job in('PRESIDENT' as p ,'ANALYST' as  a, 'MANAGER' as m , 'SALESMAN' as  s ,'CLERK' as c));     

--Quiz
--동일한 결과 decode 생성하세요
SELECT DEPTNO, SUM(DECODE(JOB,'PRESIDENT',SAL)) AS E_PRESIDENT
             , SUM(DECODE(JOB,'ANALYST',SAL)) AS E_ANALYST
             , SUM(DECODE(JOB,'MANAGER',SAL)) AS E_MANAGER
             , SUM(DECODE(JOB,'SALESMAN',SAL)) AS E_SALESMAN
             , SUM(DECODE(JOB,'CLERK',SAL)) AS E_CLERK
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO DESC;
--동일한 결과 case 생성하세요
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
--사원테이블에서 부서별 급여합계와 전체 급여합을 출력하세요
select deptno , sum(sal) from emp group by deptno order by deptno;
select sum(sal) from emp;

select deptno , sum(sal) from emp group by deptno 
union all
select null  ,  sum(sal) from emp;
--------------------------------------------------------------------------------
--Rollup , Cube 소개
--다차원 분석 쿼리에 사용 (소계를 만드는 방법)

select job , deptno , sum(sal) , count(sal)
from emp
group by job ,deptno
order by job ,deptno;

SELECT job, sum(sal)
FROM emp
GROUP BY ROLLUP(job); --나는 직종별 급여의 합도 구하고,, 모든 직종의 급여의 합도 구하겠다.

--delete from emp where job = '예술가'; -- 내가 삽입한 데이터 삭제

select job, deptno, sum(sal) -- job별 소계
from emp
group by rollup (job, deptno); -- 우측 끝 컬럼부터 연산에서 제외하므로 컬럼의 순서가 중요

select deptno, job,  sum(sal) -- 부서번호 별 소계
from emp
group by rollup (deptno, job);

-- 기준 소계 : deptno 별 소계,job별 소계, 전체합

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

-- 복잡한 쿼리 (union) , rollup (모든 컬럼의 집계는 안되요) >> cube >> 모든 컬럼의 소계
select deptno, job, sum(sal)
from emp
group by cube(deptno , job) -- cube안 컬럼으로 묶어서 집계를 도와줌
order by deptno, job;

-----------------------------------------------------------------------------------------
-- 순위 함수
-- rownum (select한 결과에 순번처리)
--RANK
-- DENSE_RANK
-- 순위가 동일한 결과 (같은 점수가 여려명) (100, 90, 80 (1,2,3 등), 100, 80, 80, 60(1등))
select * from emp;
select ename, sal,
rank() over(order by sal desc) as rank순위,
dense_rank() over(order by sal desc) as dense_rank순위2
from emp
order by sal desc;

-- 만약 동률을 줄일 수 있는 방법 기준을 더 만들어서 적용
--회사) 포인트 많은 세 사람을 선물을 주겠다
--6명 동률 : 기준을 더 만들어 ,,,, 가입순, 나이순, ... 중복값을 만들지 말아라

select ename, sal, comm, 
rank() over(order by sal desc, comm desc) as rank순위 -- 기준을 추가 .... ~~ 더 많은 기준
from emp
order by sal desc;

-- 조건 (그룹안에서 순위 정하기)
-- A조 (1,2,3) B group(1,2,3등)

select job, ename, sal, comm,
    rank() over(partition by job order by sal desc, comm desc) as 그룹순위
from emp
order by job asc, sal desc, comm desc;

-- 집계함수 (단점 : select 절 집계함수 이외에 나머지 컬럼은 group by 절)
-- in line view (서브쿼리) JOIN
-- create view 가상테이블 JOIN

select job, sum(sal), count(sal)
from emp
where job in ('MANAGER','SALESMAN')
group by job
order by job;

-- 이름, 사번 보고싶어요 (안되요)
select empno, job, sum(sal), count(sal) (x);

-- 단점 해결
select empno, ename, job, sum(sal) over (partition by job)
from emp
where job in ('MANAGER','SALESMAN')
order by job;

-- with절
-- PARTITION BY https://cafe.naver.com/erpzone/501
--------------------------------------------------------------------
-- JDBC 활용 프로시져 만들기
/* 오타 있나  봄.. 뭐였을까
create or replace procedure usp_EmpList
(
    p_sal IN number,
    p_cursor OUT SYS_REFCURSOR -- APP 사용하기 타입
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
  p_cursor OUT SYS_REFCURSOR -- APP 사용하기 타입
)
is
    begin
        open p_cursor 
        for select empno, ename ,sal from emp where sal > p_sal;
    end;

    var out_cursor REFCURSOR
    exec usp_EmpList(2000,:out_cursor)
    print out_cursor;

-- 이번에는 insert 하는거!
create or replace procedure usp_Insert_Emp
( -- input parameter 2개
    vempno IN emp.empno%TYPE,
    vename IN emp.ename%TYPE,
    vjob IN emp.job%TYPE,
    p_outmsg OUT varchar2 -- 결과에 대한 메세지를 담는 문자열로 만들어진 아웃풋 (이거하면 resultSet 필요없음)
)
is
    begin
        insert into emp(empno, ename, job) values(vempno, vename, vjob);
        commit;
        p_outmsg := 'success'; -- 할당은 이모티콘 :=
        EXCEPTION WHEN OTHERS THEN 
        p_outmsg := SQLERRM; -- 오라클이 가진 메세지 
        rollback;
    end;
    
alter table emp
add constraint pk_emp_empno primary key (empno);

select * from user_constraints where table_name ='EMP';