/*
1일차 수업

1. 소프트웨어 다운로드 (11g)
https://www.oracle.com/database/technologies/xe-prior-release-downloads.html

2. Oracle 설치 ( SYS, SYSTEM 계정에 대한 암호 설정 : 1004)

3. sqlplus 프로그램 ( oracle 설치시 제공되는 프로그램 , CMD ) 
    : 단점 GUI 환경 제공하지 않아요.
    
4. 별도의 프로그램 접속 Tool
4.1 SqlDeveloper 무료, dbeaver 무료
4.2 토드, 오렌지, SqlGate 회사 .....

5. SqlDeveloper 실행 >> Oracle 서버 접속 >> GUI
5.1 HR 계정 (unlock) 
-- USER SQL
ALTER USER "HR" IDENTIFIED BY "1004" 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ; >>>>>>> 이거 함
-- QUOTAS
ALTER USER "HR" QUOTA UNLIMITED ON "USERS";
-- ROLES
ALTER USER "HR" DEFAULT ROLE "CONNECT","RESOURCE";
-- SYSTEM PRIVILEGES


5.2 KOSA 계정 생성 (실습계정)
관리자 >> 다른사용자>> 우클릭 사용자 생성 >> 사용자, 권한(롤) 등 설정
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


DB분야
개발자 (CRUD) (insert, select, update, delete) >> DML(DATA MANIPULATION LANGUAGE) + DDL (create, alter, drop)

관리자 (DBA) 백업하고 복원 , 네트워크 관리, 자원관리, 하드웨어 관리

튜너 : SQL 튜너 (문장) >> 속도  >> index >> 자료구조
      하드웨어(네트워크) 튜너
      
모델러 : 설계 (PM) - ERD - 요구사항 분석 ERD

분석가 (데이터 분석) 석사급 이상 ..... 논문 read .....

*/
show user;

select * from emp;
select * from dept;
select * from salgrade;

------------------------------------------------------------------
-- 1. 사원테이블에서 모든 데이터를 출력하세요
select * from emp;
SELECT * FROM emp;
SELECT * FROM EMP;
-- 쿼리는 대소문자 구분 X : 회사마다 규칙이 다를 뿐

-- 2. 특정 컬럼 데이터 출력하기
select empno, ename, sal
from emp;

select ename from emp;

-- 3. 가명칭 사용하기 (별칭 : alias) >> 띄어쓰기 할거면 "" 해주기
select empno 사번 , ename 이름
from emp;
select empno "사 번" , ename "이 름"
from emp;

-- 권장 문법 (ANSI) >>  표준 >> 구문을 작성하면 (Oracle, Ms-sql, Mysql) >> 별칭에 as를 써준다.
select empno as "사 번", ename as "이 름"
from emp;

-- Oracle 문자열 데이터 엄격하게 대소문자 구별
/*
JAVA : 문자 > 'A', 문자열 > "AAAA"
ORACLE : 문자열 'A'  ,  'AAAA'  ,  'ABBWEDWED'
>> 오라클은 문자와 문자열 구분없음 전부 작은 따옴표로 쓰면 됨.
ORACLE : 데이터로 'a'  'A' 다른 문자열
*/
SELECT *
FROM EMP
WHERE ENAME = 'KING';  -- 대소문자 구분. 'king' 이라고 하면 안나옴

/*
SELECT 절  3
FROM 절    1
WHERE 절   2
*/

-- Oracle Query (질의어) : 언어
/*
연산자
JAVA : + 숫자(산술연산) , + 문자열 (결합연산)
-----------------------------------------
ORACLE : 
결합 연산자 || 
산술 연산자 + (산술연산)

MS-SQL : + (산술, 결합)

*/

SELECT '사원의 이름은' || ENAME || '입니다' AS 사원정보
FROM EMP;

-- 테이블의 기본정보 (컬럼, 타입)
DESC EMP;
-- ENAME     VARCHAR2(10) 문자열 타입 결합가능 ...인지

/*
VARCHAR2(10) 
괄호 안 숫자가 BYTE 임. 한글자 2BYTE니까 10이면 5자 들어갈 수 있음

JAVA: class Emp (private int empno, private String ename)
ORACLE : create Table Emp (empno number, ename varchar2(20));
*/


-----------------------------------------------------

--자동형변환 >> 숫자를 문자열로 변환
select empno || ename from emp;

select empno + ename from emp; --invalid number

--사장님 ... 우리 회사에 직종이 몇개나 있나
select job from emp;

--중복행 제거 키워드 : distinct

select distinct job from emp; 
--grouping

--재미로 (distinct)
select distinct job, deptno
from emp
order by job;

select * from emp;


--Oracle SQL 언어
--JAVA와 거의 동일 : (+,-,*,/) 나머지 %
--ORACLE          : (+,-,*,/) 나머지 % (Oracle에서 %는 다른 곳에 사용 ... 함수 mod())
--문자열 패턴 검색 : ename like '%신%'

--사원테이블에서 사원의 급여를 100달라 인상한 결과를 출력하세요
select empno, ename, sal, sal+100 as 인상급여 from emp;

--dual 임시 테이블
select 100 + 100 from dual; --200
select 100 || 100 from dual; -- 100100
select '100' + 100 from dual; --200  '100' 숫자형 문자 ex)'123456'
select 'A100' + 100 from dual; -- error

--비교 연산자
--<     >   <=
--주의
--JAVA : 같다 (==) 할당(=) , JavaScript : (==. ===)
--Oracle : 같다 (=) 같지 않다 !=

--논리연산자 (AND, OR, NOT)

select empno, ename, sal
from emp
where sal >= 2000;

--사번이 7788번인 사원의 사번 이름 직종, 입사일을 출력하세요
SELECT EMPNO, ENAME, JOB, HIREDATE
FROM EMP
WHERE EMPNO = 7788;
----------------------------------------------------------
--사원의 이름이 king 사원의 사번 , 이름 , 급여 정보를 출력하세요
select empno , ename, sal
from emp
where ename ='KING';

/*    AND  , OR
 0 0   0     0
 1 0   0     1
 0 1   0     1
 1 1   1     1

*/
--초과 , 미만
--이상 , 이하 (=)

--급여가 2000달러 이상이면서 직종이 manager 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal >= 2000 and job='MANAGER';


--급여가 2000달러 이상이거나 (또는) 직종이 manager 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal >= 2000 or job='MANAGER';

--급여가 2000달러 초과이면서 직종이 manager 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal > 2000 and job='MANAGER';

--오라클 날짜 (DB 서버의 날짜)
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
--도구 >> 환경설정 >> 데이터베이스 확장 >> NLS >> 날짜형식 수정하셔도 됩니다.

SELECT * FROM EMP;

-- 날짜 데이터 검색 >> 문자열 검색 처럼 >> '날짜'
SELECT * FROM EMP
WHERE HIREDATE = '1980-12-17'; 

SELECT * FROM EMP
WHERE HIREDATE = '1980/12/17'; 

SELECT * FROM EMP
WHERE HIREDATE = '1980.12.17';

SELECT * FROM EMP
WHERE HIREDATE = '80-12-17'; 
-- 현재 날짜 포맷 (YYYY-MM-DD)인데 80-12-17로 하면 안됨. 날짜 포맷이 안 맞아서 

-- 사원의 급여가 2000이상이고 4000이하인 모든 사원의 정보를 출력하세요
SELECT * 
FROM EMP
WHERE SAL >= 2000 AND SAL <=4000;
-- 컬럼명 between A and B 연산자 (= 포함)

SELECT * 
FROM EMP
WHERE SAL BETWEEN 2000 AND 4000; -- BETWEEN은 양쪽 값 다 포함..

--사원의 급여가 2000초과 4000미만 인 모든 사원의 정보를 출력하세요
select *
from emp
where sal > 2000 and sal < 4000;

-- 부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호를 출력하세요.
SELECT * 
FROM EMP
WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=30;
-- IN 연산자
select *
from emp
where deptno in (10, 20, 30); -- where deptno=10 or deptnp=20 or deptno30;

-- 부서번호가  10번 또는 20번이 아닌 사원의 사번, 이름, 급여, 부서번호를 출력하세요.
SELECT empno, ename, sal, empno 
FROM EMP
WHERE DEPTNO!=10 OR DEPTNO!=20 ;

-- IN의 부정 (NOT IN)
select * 
from emp
where deptno not in (10, 20); --where deptno != 20;
--POINT : not in >> != and

-- Today Point
-- null 에 대한 이야기
-- 값이 없다
-- 필요악
create table member (
    userid varchar2 (20) not null, 
    name varchar2(20) not null,
    hobby varchar2(50) 
);
desc member;
insert into member (userid, hobby) values ('kim', '농구');
-- ORA-01400: cannot insert NULL into ("KOSA"."MEMBER"."NAME")
insert into member (userid, name) values ('kim', '홍길동');
commit;
select * from member;

----------------------------------------------------------------------

/*
DB마다 설정
Oracle
insert, update , delete 명령
기본적으로 쿼리문 실행시 begin tran 구문이 자동으로 붙음. 개발자는 end(완료, 취소)
오라클은 대기상태 ...... 마지막 명령 (commit 실제 반영, rollback 취소) 이렇게 해야 작업이 완료됨.

Ms-sql
자동 auto-commit
delete from emp; 자동 commit;

begin tran
    delete from emp;
    
    commit or rollback하지 않으면 데이터 처리 안됨!
    
*DB Transaction : 논리적인 작업 단위 (성공, 실패)
*OLTP (웹 환경 : 실시간 데이터 처리) >> 트랜잭션
은행업무 이체
begin tran
    update ... 계좌 -1000
    update ... 동생계좌 +1000
end

*OLAP (데이터 분석 : 일정기간 데이터 모아서 분석)

오라클에서 insert, update, delete 하면 반드시 
commit, rollback 처리 여부 결정해야 한다.

--delete from emp;

select * from emp;

commit;  -- commit 한 데이터는 원칙적으로는 복원이 안됨. 그러나 백업해둔 데이터가 있다면 시점으로 되돌릴 수 있다.


*/
----------------------------------------------------------------------
-- 수당 (comm) 을 받지 않는 모든 사원의 정보를 출력하세요
-- 실습 데이터 0이 있는데 데이터 받는 것으로 보세요

-- comm 컬럼의 데이터 null 인것
select * 
from emp
where comm = null; -- 문법은 없어요

--select * 
--from emp
--where comm is null;
--암기 (null 의 비교는 is null)

-- comm을 받는 사원들 (comm 컬럼의 데이터가 null 이 아닌것)

select * 
from emp
where comm is not null;

-- 사원테이블에서 사번, 이름, 급여, 수당, 총급여( 급여+수당)을 출력하세요
select empno, ename, sal, comm, sal + comm as 총급여 --'총급여'라고 하면 안나옴
from emp;

/*
null이란 녀석
1. null 과의 모든 연산 결과는 null ex) null + 100 -> null
2. null 이란 ... 함수 > nvl(), nvl2()

ex) nvl(컬럼명, 대체값) >>  치환

Tip)
Mysql > null > IFNULL() > select ifnull (null,'')
Ms-sql > null >  Convert()
*/
select empno, ename, sal, comm, sal+nvl (comm, 0) as 총급여
from emp;
-- "nvl (comm, 0) : 커미션 컬럼에서 null을 만나면 0으로 바꿔서 계산해라" 라는 의미

select 1000 + null from dual;
select 1000+ nvl(null,0) from dual;
select comm, nvl(comm, 11111) from emp;
select nvl(null, 'hello NULL') from dual;

-- 사원의 급여가 1000이상이고 수당을 받지 않는 사원의 사번, 이름, 직종, 급여, 수당
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and comm is null;

--문자열 검색
--주소검색 >> 역삼 >> 역삼 단어가 있는 모든 주소가 나오는 것
-- Like 문자열 패턴 검색 
-- 와일드카드문자 (%(모든것), _(한문자))

select * 
from emp
where ename like '%A%'; -- A포함한 이름

select * 
from emp
where ename like 'A%'; -- A로 시작하는 모든 이름 

select * 
from emp
where ename like '%E'; -- E로 끝나는 이름 BLAKE

select * 
from emp
where ename like '%LL%';

select * 
from emp
where ename like '%A%A%'; -- A가 두개 ADAMS


select * 
from emp
where ename like '_A%'; -- 두번째 글자는 A이고 .... WARD, MARTIN, JAMES

-- 정규표현식 regexp_like()
select * from emp where regexp_like (ename, '[A-C]'); -- 정규표현 걸어서 처리 가능
-- 과제 (정규표현식 5개 만들기) 추후 카페에 올라가면 하세요

-- 데이터 정렬하기
--order by 컬럼명 : 문자, 숫자, 날짜 정렬기능
-- 오름차순 : asc : 낮은순 : default
-- 내림차순 : desc : 높은순
-- 정렬 (알고리즘) >> 비용이 많이 드는 작업(cost)

select * 
from emp
order by sal; -- default order by sal asc

select * 
from emp
order by sal desc;

--입사일이 가장 늦은 순으로 정렬해서 사번 , 이름 , 급여 , 입사일 출력하세요
--가장 최근에 입사한 순으로
select empno, ename, sal, hiredate
from emp
order by hiredate desc;

/*
select 절    3    
from 절      1
where 절     2    
order by 절  4   (select 결과를 정렬)
*/

-- 해석 순서대로 .. 실행순서
select empno, ename, sal, job, hiredate
from emp
where job = 'MANAGER'
order by hiredate desc;

/*
select job, depno
from emp
order by 컬럼명 asc, 컬럼명 asc, ...
*/

-- 중요 (답변형 게시판 ... 사용) >> grouping : 그룹안에서 정렬
-- order by 컬럼명 asc, 컬럼명 asc, ...
select job, deptno
from emp
order by job asc, deptno desc;
-- emp테이블에서 직급은 오름차순으로 정렬하고 그중에서 부서번호는 내림차순으로 정렬하여 직급과 부서번호를 출력

-- 연산자
-- 합집합(union) : 테이블과 테이블의 데이터를 합치는 것 (중복값 배제)
-- 합집합(union all ) : 테이블과 테이블의 데이터를 합치는 것 (중복값 허용)
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
union            -- 중복데이터 제거됨
select * from uta;
-- ut네 집에 uta 식구들이 놀러가는 것

select * from ut
union all        -- 중복데이터 제거 안됨
select * from uta;
-- ut네 집에 uta 식구들이 놀러가는 것

- union
-- 1) "대응"되는 "컬럼"의 "타입"이 동일해야 한다.

select empno, ename from emp        -- 숫자, 문자열
union
select dname, deptno from dept;     -- 문자열, 숫자

-- 순서를 고쳐서 컬럼 모두 숫자, 문자열로 맞춰줌
select empno, ename from emp        
union
select deptno, dname from dept;     
-- 순서 나중에 subquery를 사용해서 가상 테이블 ....
select *
from (
    select empno, ename from emp
    union
    select deptno, dname from dept
) m
order by m.empno desc; -- in-lin view

--2. "대응"되는 "컬럼"의 개수가 "동일"
/* 
01789. 00000 -  "query block has incorrect number of result columns"
select empno, ename, job, sal from emp
union
select deptno, dname, loc from dept;
*/
select empno, ename, job, sal from emp
union
select deptno, dname, loc, null from dept; -- 컬럼의 갯수를 맞출 때 필요악 null 사용

----------------------------------------------------------------------------------
-- pdf 의 47페이지 까지
--0418
SHOW USER;
SELECT SYSDATE FROM DUAL; 
--ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY/MM/DD HH24:MI:SS';
-- 현재 접속한 계정이 바라보는 날짜를 바꾸는것 : 도구>환경설정>데이터베이스>NLS:날짜형식

/*
단일 행 함수의 종류 
1) 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2) 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3) 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를
제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4) 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
5) 일반적인 함수 : NVL, DECODE

*/
-- 문자열 함수

select initcap ('the super man') from dual; -- INICAP 단어의 첫글자를 대문자로
select lower('AAA'), upper('aaa') from dual;
select ename, lower(ename)as "ename" from emp; -- "" 없어도 오류 x지만 ''는 오류남
select * from emp where lower (ename) = 'king';

select length ('abcd') from dual; --문자열의 개수
select length('홍길동') from dual; --3개
select length ('   홍 길 동a') from dual; -- 9개

select concat('a', 'b') from dual; -- ab
--select concat('a','b','c') from dual; --concat은 두개밖에..
select 'a'|| 'b' || 'c' from dual; --abc

select concat(ename, job) from emp; -- concat은 띄어쓰기 불가
select ename || '  ' || job from emp; -- 함수보다 연산자가 제약성이 떨어짐

-- JAVA : substring 
-- ORACLE : substr

-- substr(문자열, a, b) 인덱스 a부터 b개 (인덱스는 1부터 시작)
select substr('ABCDE',2,3) from dual; --BCD
select substr('ABCDE',1,1) from dual; --A
select substr('ABCDE',3,1) from dual; --C
select substr('ABCDEFGHIJK',3) from dual; --CDEFGHIJK : 인덱스 3부터 쭉~!

/*
dual?
DUAL은 오라클이나 MYSQL 등 DBMS에서 제공하는 테이블로, 
24 * 37 이런 단순한 계산부터, 산술연산, 함수결과 등 
쿼리 결과를 손쉽게 확인해볼 수 있는 임시테이블 같은거예요. 
MYSQL의 경우에는 FROM DUAL을 생략할 수 있어요.
*/

/*
사원테이블에서 ename컬럼의 데이터에 대해서 첫글자는 소문자로 나머지 글자는 대문자로
출력하되 하나의 컬럼으로 만들어서 출력하시고 컬럼의 별칭은 fullname 으로 하고 
첫글자와 나머지 문자 사이에는 공백하나를 넣으세요.
*/

select lower(substr(ename,1,1)) || ' ' || upper(substr(ename,2)) 
as "fullname"
from emp;

select lpad ('ABC', 10,'*') from dual; -- *******ABC : 왼쪽으로 * 을 10개채워라
select rpad ('ABC', 10,'*') from dual; -- ABC*******
select rpad ('ABC', 10,'#') from dual; -- ABC#######

-- 사용자 비번 : hong1004 or k1234
-- 화면앞에 2글자만 보여주고 나머지는 특수 문자로
select rpad(substr('hong1004',1,2), length('hong1004'),'*') from dual;
select rpad(substr('k1234',1,2), length('k1234'),'*') from dual;

-- emp 테이블에서 ename 컬럼의 데이터를 출력하되 첫글자만 출력하고 나머지는 * 출력하세요
select rpad(substr(ename,1,1) , length(ename), '*') as ename from emp;

create table member2(
    id number,
    jumin varchar2(14)
);
insert into member2(id, jumin) values(100, '123456-1234567');
insert into member2(id, jumin) values(200, '234567-1234567');
commit;


select * from member2;
-- 출력결과
--100 : 123456-*******
select id || ' : ' || rpad(substr(jumin,1,7), length(jumin),'*') as jumin from member2;

-- rtrim 함수
-- 오른쪽 문자를 지워라
select rtrim('MILLER', 'ER') from dual; --MILL

-- ltrim 함수
-- 왼쪽문자를 지워라
select ltrim('MILLLLLLLLLLMLLMER', 'MIL') from dual; --ER
-- trim() 은 양 끝 공백만 지움
-- rtrim, ltrim은 공백제거 목적으로 사용
select '>' || 'MILLER          ' || '<' from dual;
select '>' || rtrim('MILLER          ',' ') || '<' from dual;

-- 치환함수 
select ename, replace(ename, 'A', '와우') from emp; -- A를 만나면 와우로 바꿔라

---------------------------------------------------------------
-- 숫자함수
-- round (반올림함수)
-- trunc (절삭함수)
-- mod() 나머지 구하는 함수

-- round    반올림 0(정수) 1 2 3 
select round(12.345, 0 ) as r from dual; --12 : 정수부만 남겨라
select round(12.567, 0 ) as r from dual; --13
select round(12.345, 1 ) as r from dual; --12.3 : 소수 첫째자리 까지
select round(12.567, 1 ) as r from dual; --12.6
select round(12.345, -1 ) as r from dual; -- 10 : 십의 자리까지
select round(15.345, -1 ) as r from dual; -- 20
select round(12.345, -2 ) as r from dual; -- 0

-- trunc    버림
select trunc(12.345, 0 ) as t from dual; --12 : 정수부만 남겨라
select trunc(12.567, 0 ) as t from dual; --12
select trunc(12.345, 1 ) as t from dual; --12.3 : 소수 첫째자리 까지
select trunc(12.567, 1 ) as t from dual; --12.5
select trunc(12.345, -1 ) as t from dual; -- 10 : 십의 자리까지
select trunc(15.345, -1 ) as t from dual; -- 10
select trunc(12.345, -2 ) as t from dual; -- 0

-- 나머지
select 12/10 from dual; --1.2
select mod(12,10) from dual; --2 나머지함수
select mod(0,0) from dual; --0
--------------------------------------------------------------------------
--날짜 함수 (연산)
select sysdate from dual;
--POINT
--1. Date + Number >> Date
--2. Date - Number >> Date
--3. Date - Date >> Number (일수) 

select sysdate + 100 from dual;
select sysdate + 1000 from dual;
select sysdate - 1000 from dual;

select hiredate from emp;
select months_between('2022-09-27', '2020-09-27') from dual; -- 24  (개월 차이)
select months_between(sysdate, '2020-01-01') from dual; -- 약 39개월 근무

-- 주의사항 조심하세요^^
select '2023-01-01' + 100 from dual; -- '2023-01-01' [날짜형식] 이지만 문자열
-- 해결 함수 : 문자를 날짜로 바꾸는 함수 to_date();
select to_date('2023-01-01') + 100 from dual; 

-- 사원테이블에서 사원들의 입사일에서 현재날짜까지의 근속 월 수 를 구하세요.
-- 사원이름, 입사일, 근속월수 출력
-- 단 근속월수는 정수부만 출력 (반올림 하지 마세요)
select ename, hiredate, trunc(months_between(sysdate, hiredate),0) as 근속월수 
from emp;

-- 한달이 31일 이라고 가정하고,,, 기준에서 근속 월수를 구하세요
-- 함수는 사용하지 마세요 (반올림 하지 마세요) -- trunc는 함수 아니냐?;
select ename, hiredate, trunc((sysdate-hiredate)/31,0) as 근속월수 
from emp;
----------------------------------------------------------------------
-- 문자함수, 숫자함수, 날짜함수 END --------------------------------------

-- 변환함수 TodayPoint
-- 오라클 데이터 유형 : 문자열, 숫자, 날짜

-- to_char() : 숫자 -> 형식 문자 (100000 -> $100,000) 이렇게 바꾸면 $100,000는 숫자가 아닌 문자다!!!
-- >> formating 출력 형식 정의하는 것.
-- to_char() : 날짜 -> 형식 문자('2023-01-01' -> 2023년01월01일) 이것도 날짜가 아니라 format출력형식을 갖고있는 문자열이다.
-- to_char()는 숫자를 내가 원하는 문자형식으로 바꿔주는 것

-- to_date() : 문자(날짜형식) -> 날짜
-- select to_date('2023-01-01') + 100 from dual;

-- to_number() : 문자 -> 숫자 (자동형변환)
select '100' + 100 from dual; --200
select to_number('100') + 100 from dual;

-- 변환시 표 참조(page 68 ~ 71 참조) : 페이지 검색은 61로!
-- 형식 format

select sysdate, to_char(sysdate, 'YYYY')  || '년' as yyyy,
to_char(sysdate, 'YEAR') as YEAR,
to_char(sysdate, 'MONTH') as MONTH,
to_char(sysdate, 'MM') as MM,
to_char(sysdate, 'DD') as DD,
to_char(sysdate, 'DAY') as DAY
from dual;

-- 입사일이 12월인 사원의 사번, 이름, 입사일, 입사년도, 입사월을 출력하세요
select empno, ename, hiredate, to_char(hiredate,'YYYY') as 입사년도, to_char(hiredate,'MM') as 입사월
from emp
where to_char(hiredate,'MM')='12';

select '> ' || to_char(12345, '999999999')|| '<' from dual;
select '> ' || to_char(12345, '000000000')|| '<' from dual;
select '> ' || ltrim(to_char(12345, '999999999'))|| '<' from dual;
select '> ' || to_char(12345, '$999,999,999,999,999')|| '<' from dual;
select sal, to_char(sal, '$999,999,999')as 급여 from emp;

-- HR계정 이동
show user;
--USER이(가) "HR"입니다.
select * from employees;
/*
사원테이블(employees)에서 사원의 이름은 last_name , first_name 합쳐서 fullname 별칭 
부여해서 출력하고 입사일은  YYYY-MM-DD 형식으로 출력하고 연봉(급여 *12)을 구하고 
연봉의 10%(연봉 * 1.1)인상한 값을
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요
단 2005년 이후 입사자들만 출력하세요 그리고 연봉이 높은 순으로  출력하세요
*/

-- 내답
select (last_name || first_name) as fullname, 
    to_char(hire_date, 'YYYY-MM-DD') as 입사일, 
    salary*12 as 연봉,
    to_char(salary*12*1.1, '$999,999') as 인상분
from employees
where to_char(hire_date,'YYYY') >= 2005 -- to_char(hire_date, 'YYYY-MM-DD') >= '2005-01-01' 이거 작은 따옴표 안하면 안됨.
order by 연봉 desc;
-- 쌤 답
select employee_id,
    (last_name || first_name) as fullname, 
    to_char(hire_date, 'YYYY-MM-DD') as 입사일 ,
    salary,
    salary * 12 as 연봉,
    to_char(salary*12*1.1, '$999,999') as 인상분
from employees
where to_char(hire_date,'YYYY') >= '2005'
order by 연봉 desc; -- select 한 결과를 정렬하기 때문에 select 컬럼명


------------
-- 다시 KOSA user로 
show user;
-- Tip
select 'A' as a , 10 as b, null as c, empno
from emp;
----------------------------------------------------------------
-- 문자, 숫자, 날짜, 변환함수(to_...)
----------------------------------------------------------------
-- 일반함수 (프로그래밍 성격이 강하다)
-- SQL (변수, 제어문 개념이 없다)
-- PL-SQL (변수, 제어문, ....) 고급기능 (트리거, 커서, 프로시져 ) 

-- nvl() null을 처리하는 함수
-- decode() >> java의 if문  >> 통계 데이터 (분석) >> pivot, cube, rollup
-- case() >> java switch문 

select comm, nvl(comm, 0) from emp;

create table t_emp(
    id number(6), -- 정수 6자리
    job nvarchar2(20) -- unicode 영문자, 한글 2byte 취급하겠다 20자 >>  40byte
    -- nvarchar(20)이라고만하면 한글은 10글자... 영어는 20자,,, 이렇게 헷갈리므로 한글권에서는 위의 nvarchar2와 같은 unicode 체제를 많이 사용   
)

desc t_emp;

insert into t_emp(id,job) values(100,'IT');
insert into t_emp(id,job) values(200,'SALES');
insert into t_emp(id,job) values(300,'MANAGER');
insert into t_emp(id,job) values(400);
insert into t_emp(id,job) values(500,'MANAGER');
commit;

SELECT * FROM T_EMP;

select id, decode(id, 100,'아이티', 
                      200,'영업팀', 
                      300,'관리팀',
                          '기타부서') as 부서이름  
from t_emp;

select empno, ename, deptno, decode(deptno, 10, '인사부', 
                                            20, '관리부',
                                            30, '회계부',
                                            40, '일반부서',
                                                'ETC') as 부서이름
 from emp;
               
create table t_emp2(
    id number(2),
    jumin char(7) -- 고정길이 문자열
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
t_emp2 테이블에서 id, jumin 데이터를 출력하되 jumin 컬럼의 앞자리가 1이면
남성, 2이면 여성, 3이면 중성 그외는 기타라고 출력하세요 (컬럼명은 성별)
*/
select id, decode(substr(jumin,1,1), 1, '남성', 2,'여성', 3,'중성', '기타') as 성별  
from t_emp2;

-- if 안에 if 올 수 있어요
-- decode(decode())
select * from emp;


select decode(deptno, 20, decode(
                        ename, 'SMITH', 'HELLO', 'WORLD'
                        ), 'ETC')
from emp;

-- CASE 문
/*
CASE 조건식 WHEN 결과1 THEN 출력1
           WHEN 결과2 THEN 출력2
           WHEN 결과3 THEN 출력3
           WHEN 결과4 THEN 출력4
           ELSE 출력5
END "컬럼명"
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

select '0' || to_char(zipcode), case zipcode when 2 then '서울'
                                             when 31 then '경기'
                                             when 41 then '제주'
                                             else '기타' 
                                    end 지역이름         
from t_zip;

/*
사원 테이블에서 사원급여가 1000 달러 이하면 4급
1001달러 2000달러 이하면 3급
2001달러 3000달러 이하면 2급
3001달러 4000달러 이하면 1급
4001 달러 이상이면 '특급'이라는 데이터를 출력하세요
1. 
CASE 컬럼명 WHEN 결과1 THEN 출력1

2. 
조건식 필요하다면
CASE WHEN 조건 비교식 THEN 결과
     WHEN 조건 비교식 THEN 결과
     ELSE 
END    
*/
SELECT * FROM EMP;
select sal, case  when sal between 0 and 1000 then '4급'
                     when sal between 1001 and 2000 then '3급'
                     when sal between 2001 and 3000 then '2급'
                     when sal between 3001 and 4000 then '1급'
                     else '특급' 
                end 사원급여         
from emp;

------------------------------------------------------------------
-- 75page
/*
1. count(*) >> row수 , count (컬럼명) >> 데이터 건수
2. sum()
3. avg()
4. max()
5. min()
기타

1. 집계함수는 group by 절과 같이 사용
2. 모든 집계함수는 null 값 무시
3. select 절에 집계 함수 이외에 다른 컬럼이 오면 반드시 그 컬럼은 group by 절에 명시
*/

select count (*) from emp; -- 14개의 row
select count (empno) from emp; --14건
select count (comm) from emp; --6 (null 이니 데이터 count)
select count (nvl(comm, 0)) from emp; -- 14건 

-- 급여의 합
select sum (sal) from emp;
select trunc(avg(sal)) from emp;

-- 사장님 .... 총 수당이 얼마나 지급되었나
select sum (comm) from emp; -- 4330

-- null 고민 (필요악)
-- 수당의 평균은 얼마지? (받는 사람 기준)
select trunc(avg(comm),0) from emp; --721 
select (300+200+30+300+3500+0)/6 from dual; -- 721
select comm from emp;

-- 사원수 기준
select (300+200+30+300+3500+0)/14 from dual; -- 309
select trunc(avg(nvl(comm, 0))) from emp; --  309

-- 둘다 맞다 (의미)
-- 309 1 1
-- 721 1 1

select max (sal) from emp;
select min (sal) from emp;

select sum(sal), avg(sal), max(sal), min(sal), count(*), count(sal)
from emp;

select empno, count(empno) from emp; -- 00937. 00000 - not a single-group group function" 
-- empno는 14건, count(empno)는 1건 데이터 row수가 맞지 않다.

-- 부서별 평균 급여를 구하세요
select deptno, avg(sal) --select 절에 집계 함수 이외에 다른 컬럼이 오면 반드시 그 컬럼은 group by 절에 명시
from emp
group by deptno;

-- 직종별 평균 급여
select job , avg(sal)
from emp
group by job;

select  avg(sal)
from emp
group by job; -- 문법적인 오류 없어요. (판단할 수 없어요)

select job, trunc(avg(sal),1), sum(sal), max(sal), min(sal), count(sal)
from emp
group by job;

/*
group
distinct 컬럼명1, 컬럼명2
order by 컬럼명1, 컬럼명2
group by 컬럼명1, 컬럼명2
*/

-- 부서별 , 직종별 급여의 합을 구하세요
select deptno, job, sum(sal), count(sal)
from emp
group by deptno, job
order by deptno; -- 부서번호 .. 그안에서 직종별 그룹 .. 합계
/*
select절 4
from절 1
where절 2
group by절 3 ***********
order by절 5
*/

-- 직종별 평균급여가 3000달러 이사인 사원의 직종과 평균급여를 출력하세요
select job, avg(sal) as avgsal
from emp
-- where avg(sal) > 3000
group by job
having avg(sal) >= 3000;
--from 절의 조건절 >> where
--group by 절의 조건절 >> having (집계함수 조건을 처리)

/*
select절     5
from절       1
where절      2
group by절   3 ***********
having 절    4
order by절   6

단일 테이블에 처리할 수 있는 모든 구문
*/

/* 
사원테이블에서 직종별 급여합을 출력하되 수당은 지급 받고 급여의 합이 5000 이상인 
사원들의 목록을 출력하세요  (comm 0인 놈도 받는 것으로 ....)
급여의 합이 낮은 순으로 출력하세요 
*/
select job, sum(sal) as 급여합
from emp
where comm is not null 
group by job
--having (sum(nvl(comm,0))+sum(sal)) >= 5000
having sum(sal) >= 5000
order by 급여합;

/* 사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호 ,인원수 , 급여의 합을 출력하세요 */
select deptno  , count(*) as 부서별인원수, sum(sal) as 부서별급여의합
from emp
group by deptno
having count(*) > 4;
-- select count(*) from emp where job is null; -- null여부 확인하자

/* 사원테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
단 판매직종(salesman) 은 제외하고 급여합으로 내림차순 정렬하세요 */
select job, sum(sal) as 급여합
from emp
where job != 'SALESMAN'
group by job
having sum(sal) > 5000
order by 급여합 desc;

--------------------------------------------------------------------------------------

--HR 계정으로 이동하세요
show user;
/*
1. EMPLOYEES 테이블을 이용하여 다음 조건에 만족하는 행을 검색하세요. 
2005년이후에 입사한 사원 중에 부서번호가 있고, 급여가 5000~10000 사이인 사원을 검색합니다. 
가) 테이블 : employees 
나) 검색 : employee_id, last_name, hire_date, job_id, salary, department_id 
다) 조건
    ① 2005년 1월 1일 이후 입사한 사원
    ② 부서번호가 NULL이 아닌 사원 
    ③ 급여가 5,000보다 크거나 같고, 10,000 보다 작거나 같은 사원 
    ④ 위의 조건을 모두 만족하는 행을 검색 
라) 정렬: department_id 오름차순, salary 내림차순
*/
select * from EMPLOYEES;

select employee_id, last_name, hire_date, job_id, salary, department_id
from employees
where to_char(hire_date, 'YYYYMMDD') > '20050101' -- hire_date > '2005/01/01' 으로도 가능
    and department_id is not null
    and salary between 5000 and 10000
order by department_id asc, salary desc;


/*
2. EMPLOYEES 테이블을 이용하여 다음 조건에 만족하는 행을 검색하세요. 
부서번호가 있고, 부서별 근무 인원수가 2명 이상인 행을 검색하여 부서별 최대 급여와 최소 급여를 계산하
고 그 차이를 검색합니다. 
가) 테이블 : employees 
나) 검색 : department_id, MAX(salary), MIN(salary), difference 
        - MAX(salary) 와 MIN(salary)의 차이를 DIFFERENCE로 검색 
다) 조건
    ① 부서번호가 NULL이 아닌 사원 
    ② 부서별 근무 인원수가 2명 이상인 집합 
라) 그룹 : 부서번호가 같은 행
마) 정렬 : department_id 
*/

select department_id, MAX(salary), MIN(salary), (max(salary)-min(salary)) as difference
from employees
where department_id is not null
group by department_id
having count(*) >= 2
order by department_id;

--------------------------------------------------------------------------------------------------
------------------------ 단일 테이블 쿼리 end-------------------------------------------------------
-- ETC
-- create table 테이블 명 (컬럼명 타입, 컬럼명 타입)
create table member3 (age number);

-- 데이터 1건
insert into member3(age) values(100);

-- 데이터 여러건
insert into member3(age) values(200);
insert into member3(age) values(300);
insert into member3(age) values(400);

----------------------------------------------------------------------------------------------------
/*
JAVA
class Member3 { private int age;  setter , getter}

-- 1건
Member3 member = new Member3();
m.setAge(100);

-- 다수의 데이터
List < Member3> mlist = new ArrayList<>();
mlist.add(new Member3(100));
mlist.add(new Member3(200)); 

데이터 타입
문자열 데이터 타입
char(10)        >> 10byte   >> 한글 5자, 영문자, 특수문자, 공백 10자 표현가능 >> 고정길이 문자열
varchar2(10)    >> 10byte   >> 한글 5자, 영문자, 특수문자, 공백 10자 표현가능 >> 가변길이 문자열

고정길이 (데이터와 상관없이 크기를 갖는것)
가변길이 (들어오는 데이터 크기만큼 확보)

char(10) >> 'abc' >> [a][b][c][][][][][][][] >> 공간의 크기는 변화 없다.
varchar2(10) >> 'abc' >> [a][b][c] >> 데이터 크기 만큼 공간 확보

누가봐도 varchar2(10)

성능 ..... 데이터 검색 >> char() >> 고정길이 ....가변보다는 좀 앞서 검색

char(2) : 고정길이 (남,여......대,중,소,,,,,, 주민번호) 검색 성능
가변길이 문자열 (사람의 이름, 취미, 주소)

한글, 영어권 >> 한 문자 >> unicode >> 한글, 영문 >> 2byte

nchar(20) >> 20자 >> 영문자 특수문자 공백 상관없이 >> 40byte
nvarchar(20) >> 20자 
** 영/국문 섞어 쓸 때는 유니코드 character : nchar, nvarchar를 사용하자.



*/

-오라클 함수 ......한글 3Byte 설정 확인하기
select * from SYS.NLS_DATABASE_PARAMETERS;
--NLS_CHARACTERSET  : 	AL32UTF8  한글 3byte 인식
--KO16KSC5601 2Byte (현재 변환하면 한글 다깨짐)
select * from nls_database_parameters where parameter like '%CHAR%';
------------------------------------------------------------------------------
create table test2(name varchar2(2));

insert into test2(name) values('a');
insert into test2(name) values('aa');
insert into test2(name) values('가'); --한글 1자 3byte 인지
-------------------------------------------------------------------------------
-- Join (하나 이상의 테이블에서 데이터 가져오기)
-- 신입 요구하는 기술
/*
2. Join 의 종류 
Join 방법 설명
Cartesian Product 모든 가능한 행들의 Join
Equijoin Join 조건이 정확히 일치하는 경우 사용(일반적으로 PK 와 FK 사용)
Non-Equijoin Join 조건이 정확히 일치하지 않는 경우에 사용(등급,학점)
Outer Join Join 조건이 정확히 일치하지 않는 경우에도 모든 행들을 출력
Self Join 하나의 테이블에서 행들을 Join 하고자 할 경우에 사용
Set Operators 여러 개의 SELECT 문장을 연결하여 작성한다.

Equijoin Join
Non-Equijoin Join
Outer Join Join
Self Join

관계형 DB (RDBMS)

관계 (테이블과 테이블과의 관계)
(클래스 (자바) 비교) >> 연관관계 존재

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

--1. 등가조인(equi join)
-- 원테이블과 대응되는 테이블에 있는 컬럼의 데이터를 1:1 매핑
-- SQL JOIN 문법(오라클) 간단
-- ANSI 문법 권장 >> 무조건 >> [inner] join  on 조건절

select m.m1, m.m2, s.s2
from m, s
where m.m1 = s.s1;

--ANSI (표준문법)
select * 
from m join s -- m inner join s 
on m.m1 =s.s1;


select * from emp;
select * from dept;

-- 사원번호, 사원이름, 부서번호, 부서이름을 출력하세요
select emp.empno, emp.ename, emp.deptno, dept.dname 
from emp join dept
on emp.deptno = dept.deptno;

-- 현업 (테이블에 가명칭(alias) 부여)
select e.empno, e.ename, e.deptno, d.dname 
from emp e join dept d
on e.deptno = d.deptno;

-- 조인은 select * 하고 나서 컬럼을 명시
select s.s1, s.s2, x.x2
from s join x
on s.s1 = x.x1;

select * 
from m join s 
on m.m1 =s.s1
join x
on m.m1 = x.x1;
