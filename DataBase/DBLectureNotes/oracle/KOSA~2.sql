-- 테스트 
select sysdate from dual;
-------------------------------------------------
--SQL JOIN문법 (단순)
select * 
from m, s, x
where m.m1 = s.s1 and s.s1 = x.x1;

-- ANSI 문법 (권장)
select * 
from m join s on m.m1 = s.s1
       join x on s.s1 = x.x1;
--     join y on x.x1 = y.y1; 계속 붙여쓰면 여러 테이블 조인 가능!

-- HR계정 이동
show user;

-- USER이(가) "HR"입니다.
select * from employees;
select * from departments;
select * from locations;

select count(*) from employees;
-- 사번, 이름(last_name), 부서번호, 부서이름을 출력하세요
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d 
on e.department_id = d.department_id; 
-- 사원수는 107명 하지만 join으로 나온 데이터는 106명 >> 누락자가 있음
select * from employees;
select * from employees where department_id is null; -- 조금있다가 >> outer join


-- 사번, 이름(last_name), 부서번호, 부서이름, 지역코드, 도시명을 출력하세요
select * --e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d on e.department_id = d.department_id
                 join locations l on d.location_id = l.location_id;


-- KOSA 계정 이동
show user;
-- USER이(가) "KOSA"입니다.
select * from emp;
select * from salgrade;

--  사원의 등급 (하나의 컬럼으로 매핑 안되요) >> 컬럼 2개
-- 비등가 조인(non-equi) 1:1
-- 문법 등가와 동일 (의미)

select * -- e.empno, e.ename, d.grade, e.sal
from emp e join salgrade d 
on e.sal between d.losal and d.hisal;



--outer join (equi  조인 선행되고 나서 >> 남아있는 데이터를 가져오는 방법)
-- 1. 주종 관계 (주인이 되는 쪽에 남아있는 데이터를 가져오는 방법)
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

-- show user; -- HR 계정
-- 아까 문제 수정
-- 사번, 이름(last_name), 부서번호, 부서이름을 출력하세요
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e left join departments d 
on e.department_id = d.department_id; 
-- 사원수는 107명 >> 누락자 해결

-- self join (자기참조) -> 문법 따로 없음 -> 의미만 존재 ->  등가 join 쓰기
-- 하나의 테이블에 있는 컬럼이 자신의 테이블에 있는 특정 컬럼을 참조하는 경우
select * from emp;
-- smith  사원의 사수 이름
-- 사원 테이블, 관리자 테이블 만드는 것이..... >> 중복데이터..
-- 테이블 가명칭 >> 2개, 3개 있는 것처럼
select e.empno, e.ename, m.empno, m.ename
from emp e join emp m
on e.mgr = m.empno;
-- 13명 ...
-- 14명 ... >> 
select e.empno, e.ename, m.empno, m.ename
from emp e left join emp m
on e.mgr = m.empno;
-----------------------------------------------------------------------------------------------------------
-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.
select  ename, empno, dname 
from emp e left join dept d on e.deptno = d.deptno;
?

-- 2. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라.

select e.ename, e.job, e.deptno, m.dname
from emp e join dept m
on e.deptno = m.deptno
where loc = 'DALLAS';

-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.

select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where ename like '%A%';


-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라.

select ename, dname, sal
from emp e left join dept d
on e.deptno = d.deptno
where sal >= 3000;


-- 5. 직위(직종)가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.

select job, ename, dname
from emp e left join dept d
on e.deptno = d.deptno
where e.job = 'SALESMAN';

?
-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.
--(비등가 ) 1 : 1 매핑 대는 컬럼이 없다

select empno as "사원번호", ename as "사원이름", sal as "연봉", (sal+comm) as "실급여", grade as "급여등급"
from emp e join salgrade s on e.sal between s.losal and s.hisal 
where e.comm is not null;

/*
SELECT         E.EMPNO AS "사원번호",
               E.ENAME AS "사원이름",
               E.SAL*12 AS "연봉",
               --E.SAL*12+NVL(COMM,0) AS "실급여",
               E.SAL*12+COMM AS "실급여",
               S.GRADE AS "급여등급"
FROM EMP E  join SALGRADE S on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.Comm is not null;
*/


-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라.
-- inner 는 생략 가능

select d.deptno, d.dname, e.ename, e.sal, s.grade
from emp e left join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where d.deptno = 10;

-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.
-- inner 는 생략 가능
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

-- ?????????????????????????????????????????????????????????????????????????????????????????????????????????????메모장에서 뭔가 잘린듯

-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.
--SELF JOIN (자기 자신테이블의 컬럼을 
select * from emp;

select e1.empno as "사원번호", e1.ename as "사원이름", e2.empno as "관리자번호", e2.ename as "관리자이름"
from emp e1 join emp e2 on e1.mgr = e2.empno;

-----------------------------------------------------------
-- 사원 테이블에서 사원들의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 급여를 출력하세요.
--1. 평균급여
select avg(sal) from emp; --  평균급여 2073

select empno, ename, sal
from emp
where sal > 2073;

-- 2개의 쿼리 통합 (하나의 쿼리)
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
-- ????????????????????????????????????????????????????????????????????????????????????????????????????????????

--------------------------------------------------------------------------------
--JOIN END----------------------------------------------------------------------

--subquery(서브쿼리) 100page
--sql 꽃 .....만능 해결사 

--1. 함수 > 단일 테이블 > 다중 테이블 (join , union) > 해결 안되요 >> subquery 해결

--사원테이블에서 사원들의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 급여를 출력하세요

--1. 평균급여
select avg(sal) from emp; --평균급여 2073

select empno , ename , sal 
from emp
where sal > 2073;

--2개의 쿼리 통합 (하나의 쿼리)

select empno , ename , sal 
from emp
where sal > (select avg(sal) from emp);


-- subquery
/*
1. single row subquery : 실행결과가 단일 컬럼에 단일로우 값인 경우 (한개의 값)
ex) select sum(sal) from emp, select max (sal) from emp
연산자 : = , != , < , >

2. multi row subquery : 실행 결과가 단일 컬럼에 여러개의 로우값인 경우
ex) select deptno from emp, select sal from emp
연산자 : IN, NOT IN, ANY, ALL
ALL : sal > 1000 and sal > 40000 and .....
ANY : sal > 1000 or sal > 40000 or .....

문법) 
1. 괄호안에 있어야 한다. (select max(sal) from emp)
2. 단일 컬럼으로 구성되어야 한다. (select max(sal), min(sal) from emp) 서브쿼리 안되요. (x)
3. 서브쿼리가 단독으로 실행 가능 

서브쿼리와 메인 쿼리
1. 서브쿼리 실행되고 그 결과를 가지고
2. 메인 쿼리가 실행된다.

TIP)
select (subquery) >> scala subquery
from (subquery) >> in line view (가상 테이블)
where (subquery) >> 조건
https://gent.tistory.com/464 참고 -- 512 참고 ?

*/

-- 사원 테이블에서 jones의 급여보다 더 많은 급여를 받는사원의 사번, 이름, 급여를 출력하세요
select empno, ename, sal
from emp
where sal > (select sal from emp where ename = 'JONES');

-- 부서번호가 30번인 사원과 같은 급여를 받는 모든 사원으 정보를 출력하세요
(select sal from emp where deptno = 30); -- multi row

select *
from emp
where sal in (select sal from emp where deptno = 30);
--where sal = (select sal from emp where deptno = 30); -- =  쓰면  multi  query 라 안됨
-- sal = 1600 or sal=1250 or ...

-- 부서번호가 30번인 사원과 다른 급여를 받는 모든 사원으 정보를 출력하세요
select *
from emp
where sal not in (select sal from emp where deptno = 30);
-- sal != 1600 or sal != 1250 or ...

-- 부하직원이 있는 사원의 사번과 이름을 출력하세요
-- 내 사번이 mgr 컬럼에 있다면 나는 ..^^
select empno, ename
from emp
where empno in (select mgr from emp); --  사수들 목록

-- 부하직원이 없는 사원의 사번과 이름을 출력하세요
select empno, ename
from emp
where empno not in (select nvl(mgr,0) from emp); --  신입들 목록
-- null 값 때문에 안나옴 : not in은 and 연산이기 때문에 --
-- 외우라고 : not in은 부정의 and


-- king 에게 보고하는 즉 직속상관이 king인 사원의 사번, 이름, 직종, 관리자 사번을 출력하세요
select empno, ename, job, mgr
from emp
where mgr in (select empno from emp where ename = 'KING');


-- 20번 부서의 사원중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의
-- 사번, 이름, 급여, 부서번호를 출력하세요
select empno, ename, sal, deptno
from emp
where sal > ( select max(sal) from emp where deptno = 20);

-- 스칼라 서브쿼리
select e.empno, e.ename, e.deptno, (select d.dname from dept d where d.deptno = e.deptno)
from emp e
where e.sal >= 3000;

--#############################
--실무에서 많이 사용 (초중급)
--hint) 만약에 부서번호와 부서의 평균 월급을 담고있는 테이블이 존재하다면 (메모리에)
--in line view 
-- 자기 부서의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 부서번호, 부서별 평균 월급 출력하세요

-- 교수님 풀이
select a.empno, a.ename, a.deptno, a.sal, b.avgsal 
from emp a join (select deptno, trunc(avg(sal), 0) as avgsal from emp group by deptno) b 
on a.deptno = b.deptno
where a.sal > b.avgsal;

-- 내 풀이
select a.empno, a.ename, a.deptno, a.sal, b.avgsal
from emp a
    ,(select  d.deptno, trunc(avg(sal)) as avgsal
    from emp e left join dept d on e.deptno = d.deptno
    group by d.deptno) b
where a.deptno = b.deptno and a.sal > b.avgsal;

------------------------------------------------------------------------------------------------------------
--subquery END----------------------------------------------------------------------------------------------
--연습문제 (25분까지)
/*
--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.

--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.

--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.

--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.

--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)

--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.

--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.

--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)

--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.

--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.

--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
*/

-- 1번
select ename, sal
from emp
where sal > (select sal from emp where ename ='SMITH'); 

-- 2번
select ename, sal, deptno
from emp
where sal IN (select sal 
from emp 
where deptno = 10);

--select sal from emp where deptno = 10;

--3 번

select ename, hiredate
from emp
where deptno = (select deptno 
from emp
where ename = 'BLAKE') and ename != 'BLAKE';

-- 4번
--select trunc(avg(sal), 0) 
--from emp;
select empno, ename, sal
from emp
where sal > (select trunc(avg(sal), 0) from emp)
order by sal desc;

-- 5번
--select distinct deptno 
--from emp
--where ename like '%T%';

select empno, ename
from emp
where deptno IN (select distinct deptno 
from emp
where ename like '%T%');

/* 다시 보기 ****
SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                FROM EMP
                WHERE ENAME LIKE '%T%');
*/

-- 6번 **
--select max(sal)
--from emp
--where deptno = 30;
select ename, deptno, sal
from emp
where sal > (select max(sal)
from emp
where deptno = 30);

/* 중요************************
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > ALL(SELECT SAL
                FROM EMP
                WHERE DEPTNO=30)
 
--where sal > 1600 and sal > 1250 and sal > 2850 and sal > 1500 and sal > 950
 
*/


-- 7번
select deptno, ename, job
from emp
where deptno = (select deptno  -- IN 쓰기
from dept
where loc = 'DALLAS');

-- 8번
select deptno, ename, job
from emp
where deptno = (select deptno 
from dept
where dname = 'SALES');

-- 9 번
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING');

--10번
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
              
  또는            
--select * from emp
--where  deptno in  (
--                      select deptno from emp where sal > (select avg(sal) from emp)
--                      and ename like '%S%'
--                   )
*/

-- 11번

select *
from emp
where deptno IN (select distinct deptno
from emp
where comm is not null) 
and sal IN (select distinct deptno
from emp
where comm is not null);

-- 12번


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
-- 제 8장    SQL*Plus 명려어 사용법 생략하세요
-- 제 9장 테이블 생성
-- 제 10장 데이터 조작
-- 수업은 10장 먼저 하고 ... 9장 하도록 하겠습니다.
--------------------------------------------------------------------------------
--TIP)
select * from emp order by 1,2,3; --1,2,3번째 컬럼 순으로 오름차순 정렬
                                  -- order by empno , ename , job 동일
                                  
select deptno ,sal , empno from emp order by 1 desc,2; 
                                  -- order by deptno desc , sal asc 동일
                                  
/*                                  
지금까지 초급 개발자 필수 사항
select
from 
where 
group by
having
order by
+
기본 함수 (문자,숫자,날짜,변환,일반,집계)
+ 
다중테이블 (JOIN , UNION)
+
subquery 까지 
+ 
기본적인 DML 구문 (필수 암기) 입니다
                                 
*/                        
--------------------------------------------------------------------------------
--데이터 조작(DML) 입니다
-- 168 page
-- insert, update, delete ( 반드시 암기)

/*
DDL (데이터 정의어) :  create, alter, drop, truncate, rename, modify 
--      (truncate : )
DML (데이터 조작어) : 트랜잭션을 일으키는 작업 : insert, update, delete
ex) 개발자 ... 회사 갑자기 ...DB select 잘 되는데 insert, update, delete  안되요
    >> 갑자기 log write 를 수행하는 작업 (누가 언제 어떤 테이블에 무슨작업을 했는지 기록)
    >> DISK 기록 (log file full) >>  log write 안되면 >> DML 작업 못함
    >> log backup >> log  삭제 .....
    
    >> commit 하지 않은 경우 .....   실습..... 일상 다반사니까 주의하기! 
DQL (데이터 질의어) :  select    -- QUERY 의 q
DCL (데이터 제어어) :  관리자 : grant, revoke     -- control 의 c
TCL (트랜잭션)     :  commit, rollback, savepoint

*/
-- 오라클  insert, update, delete  작업 반드시 commit , rollback  처리
-- Tip) tab, col 테이블 사용하기
select * from tab; -- 사용자(KOSA) 계정이 가지고 있는 테이블 목록

-- 내가 테이블을 생성 .. 그 이름이 있는지 없는지
select * from tab where tname = 'BOARD';
select * from tab where tname = 'EMP';
select * from col where tname = 'EMP';
---------------------------------------------------------------------------------
-- insert, update, delete 무조건 암기

-- 1. INSERT
create table temp(
    id number primary key, -- not null, unique 받겠다 (회원 ID, 주민번호)
    name varchar2(20)
);
desc temp; -- temp 정보를 볼 수 있음.

--1. 일반적인  insert
insert into temp(id, name)
values(100, '홍길동');
--commit, rolback 하기 전까지 실반영하지 않아요
select * from temp;
commit;

--2. 컬럼 목록을 생략( insert ) 쓰지 마세요
insert into temp
 values(200, '김유신');

 select * from temp;
 rollback; -- 커밋 전 롤백하면 insert 를 되돌릴 수 있다.
 
 -- 3. 문제  ... insert
 insert into temp(name)
 values('아무개');
 -- 자동 id 컬럼 >> null >> PK >> ORA-01400: cannot insert NULL into ("KOSA"."TEMP"."ID")
 -- null 값 넣을 수 없느넫 넣어서 에러
 
 insert into temp(id, name)
 values(100, '개똥이');
 -- PK >> id >> 중복 데이터(x) >> ORA-00001: unique constraint (KOSA.SYS_C007003) violated
 
 insert into temp (id, name)
 values(200, '정상이');
 
 select * from temp;
 commit;
 
 ------------------------------------------------------------------------------------------
 --Tip
 --SQL 은 프로그램적 요소 (x) 
 --PL-SQL 변수, 제어문
 
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
 -- 블록 잡고 실행, 실행 후 주석 필수 : PL/SQL 프로시저가 성공적으로 완료되었습니다.
 */
 select * from temp2;
 
 create table temp3(
    memberid number(3) not null, -- 3자리 정수
    name varchar2(10), -- null  허용
    regdate date default sysdate --테이블 기본값 설정 (insert 하지 않으면 자동 (날짜) 들어가게 하겠다)
 );
 desc temp3;
 
 select sysdate from dual;
 
 --1. 정상
 insert into temp3 (memberid, name, regdate)
 values(100, '홍길동', '2023-04-19');
 
 select * from temp3;
 commit;
 
 --2. 날짜
 insert into temp3 (memberid, name)
 values(200, '김유신');
 
 select * from temp3;
 commit;
 
 --3. 컬럼 하나
 insert into temp3(memberid)
 values(300);
 
 select * from temp3;
 commit;
 
 -- 4. 오류
 insert into temp3 (name) -- id null 값 >> not null
 values('니누구');
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
--대량 데이터 삽입하기
select * from temp5;
--temp4 테이블에 모든 데이터를 temp5  넣고 싶어요
--insert into 테이블명(컬럼리스트) values ...
--insert into 테이블명(컬럼리스트) select 절 *****************^^
-------------------------------------------------?????????????????????????????????????????????????????????????
insert into temp5(num)
select id from temp4; --대량 데이터 삽입

select * from temp5;
commit;

-- 2. 대량 데이터 삽입하기
-- 데잍를 담을 테이블도 없고 >> 테이블 구조(복제) : 스키마 + 데이터 삽입
-- 단 제약정보는 복제 안되요 (PK, FK)
-- 순수한 데이터 구조 + 데이터

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

-- 토막 퀴즈
-- 틀만 (스키마) 복제 데이터는 복사하고 싶지 않아요

create table copyemp3
as 
    select * from emp where 1=2; -- 일부러 거짓 조건 넣어서 틀만 복사
select * from copyemp3;
/*
create table copyemp4
as 
    select * from emp where 1=1; -- 이렇게 하면 그냥 복사
*/

----------------------------------------------------------------------------------------
--INSERT END----------------------------------------------------------------------------

--UPDATE
/*
update  테이블명
set 컬럼명 = 값, 컬럼명 = 값, 컬럼명 = 값.......
where  조건절

update 테이블 명
set 컬럼명 = (subquery)
where 컬럼명 = (subquery)

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
values(1, 'dnskdms@naver.com', '우나은', '123215-1236485' , '010-1235-1254', '16-14');
insert into test(num, email, name, jumin, phonenum, postnum)
values(2, 'chlgusehd123@naver.com', '최현동', '123215-1235364', '010-1234-4567', '01614');
insert into test(num, email, name, jumin, phonenum, postnum)
values(3, 'changhyun@gmail.com', '김창현', '123215-1452364', '010-1236-4569', '456');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', '조병국', '123215-2212364', '010-5486-8456', 'asd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(5, 'asfda@asdf', '장석진', '123215-12364as', '010-845*466-5', 'asdasd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', '오승환', '123215-12364a', '010-  54-5555', '12345');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', 'jackson', '123215-12364a', '010-1--4-----', '125 6');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', 'harry', '123215-2212364', '010-2154-585a', '00202');

-- 정규표현식 사용전
select * from test;
-- 정규표현식 사용후 : 이메일
select * from test
where regexp_like(email, '^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$');



-- 정규표현식 사용전
select * from test;
-- 정규표현식 사용후 : 이름
select * from test
where regexp_like(name, '^[가-힣]{2,4}$');


-- 정규표현식 사용전
select * from test;
-- 정규표현식 사용후 : 주민번호
select * from test 
where regexp_like(jumin ,'^[0-9]{6}+[-]+[0-9]{7}$');

-- 정규표현식 사용전
select * from test;
-- 정규표현식 사용후 : 휴대전화번호
select * from test 
where regexp_like(phonenum ,'^[0][1]\d{1}-\d{4}-\d{4}$');

-- 정규표현식 사용전
select * from test;
-- 정규표현식 사용후 : 우편번호
select * from test 
where regexp_like(postnum ,'^\d{5}$');
