/* 개발자 (SQL) 
1. CRUD (create > insert, read > select, update, delete)
2. APP(JAVA) - 표준(JDBC API) - Oracle
3. insert, update, delete, select (70%)

하나의 테이블에 대해서 작업가능
JAVA에서 EMP 테이블 접근(CRUD)
APP(JAVA)
MVC(패턴) >> Model(DTO,DAO,SERVICE) - View(html, jsp) - Controller(Servlet) 니가 잘하는 것만 해 
                        dao : data access object                                    -- Servlet : 웹용 자바코드
DB 작업 (DAO) >>  EmpDao.java >> DB연결 (CRUD)
기본적으로 5개의 함수 생성 .....
1. 전체조회 (함수) : select * from emp 처리 함수
>> 데이터 여러건
>> public List<Emp> getEmpList() { select * from emp return null; }

2. 조건조회 (함수) : select * from emp where empno = ?
>> 데이터 한건
>> public Emp getEmpListByEmpno (int empno) { select * from emp where empno =? return null; }

3. 삽입 (함수)    : insert into emp(...)  values (...)
>> public int insertEmp (Emp emp) { insert ... return row; }

4. 수정 (함수)    : update emp(...) set .... where ...
5. 삭제 (함수)    : delete emp where ....

*/

--9장 테이블 생성하기 
--page 138

-- DDL (create, alter, drop, rename) 테이블(객체) 생성, 수정, 삭제
-- 코드 몰라도 .. TOOL 마우스 ... 코드 폼

select * from tab; --현재 접속한 사용자가 볼 수 있는 모든 테이블 이름

select * from tab where tname = lower ('board'); -- board라는 이름의 테이블이 있는지 확인

create table board(
    boardid number,
    title nvarchar2(50), -- 영문자 특수 공백 상관없이 50자
    CONTENT NVARCHAR2(2000), -- 2000자 (4000byte)
    regdate date
);

desc board; --가장 기본적인 정보
-- TIP)
select * from user_tables where lower (table_name) = 'board';
select * from col where lower(tname) = 'board';
-- 제약정보 확인하기 (반드시)
select * from user_constraints where lower (table_name) = 'board';
select * from user_constraints where lower (table_name) = 'emp';
 
--oracle llg >> 실무 >> 가상컬럼(조합컬럼)
-- 학생 성적 테이블 (국어, 영어, 수학)
-- 합계, 평균 ....
-- 학생 성적 테이블 (국어, 영어, 수학, 평균) -- 좋지않다 but 반정규화 입장..
-- 각각의 점수 변화 >> 평균값도 변화 보장 >> 무결성 integrity

create table vtable(
    no1 number,
    no2 number,
    no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL
);

select * from col where lower (tname) = 'vtable';

insert into vtable(no1, no2) values(100, 50);
select * from vtable;

-- insert into vtable(no1, no2, no3) values(100, 50,30); (x)
-- 실무에서 활용되는 코드
-- 제품정보 (입고) : 분기별 데이터 추출(4분기)
create table vtable2(
    no number, --순번
    p_code char(4), -- 제품코드 (A001, B003)
    p_date char(8), -- 입고일 (20230101)
    p_qty number, -- 수량
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
--테이블 만들고 수정 삭제
-- 1. 테이블 생성하기
create table temp6 (id number);

desc temp6;

--2. 테이블 생성 후에 컬럼 추가하기
alter table temp6
add ename varchar2(20); -- 기존 테이블에 새로운 컬럼 추가

desc temp6;

--3. 기존 테이블에 있는 컬럼이름 잘못 표기 (ename -> username)
-- 기존 테이블있는 기존 컬럼 이름 바꾸기 (rename)
alter table temp6
rename column ename to username;

desc temp6;

-- 4. 기존 테이블에 있는 기존 컬럼의 타입의 크기 수정 (기억) modify
alter table temp6
modify (username varchar2(2000));

desc temp6;

-- 5. 기존 테이블에 기존 컬럼 삭제
alter table temp6
drop column username;

desc temp6;
--모든 작업은 TOOL에서 가능 ...!

--6. 테이블 전체가 필요 없어요
-- 6.1 delete 데이터만 삭제
-- 테이블 처음 만들면 처음 크기 설정 >> 데이터 넣으면 >> 데이터 크기만큼 테이블 크기 증가
-- 처음 1M >> 데이터 10만건 (insert) >> 100M >> delete 10만건 삭제 >> 테이블 크기100M

-- 테이블 (데이터) 삭제 (공간의 크기도 줄일 수 없을까)
-- truncate ( 단점 : where절 사용 못함)
-- 처음 1M >> 데이터 10만건 (insert) >> 100M >> truncate 10만건 삭제 >> 테이블 크기100M
-- truncate table emp --DBA (관리자)

-- 테이블 삭제
drop table temp6;
desc temp6; --오류:ORA-04043: temp6 객체가 존재하지 않습니다.

-------------------------------------------------------------------------------------------------
-- 테이블에 제약 설정하기
-- page 144
/*
데이터 무결성 제약 조건의 종류 
제 약 조 건 설 명
PRIMARY KEY(PK)    : 유일하게 테이블의 각행을 식별(NOT NULL 과 UNIQUE 조건을 만족)
FOREIGN KEY(FK)    : 열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다.
UNIQUE key(UK)     : 테이블의 모든 행을 유일하게 하는 값을 가진 열(NULL 을 허용)
NOT NULL(NN)       : 열은 NULL 값을 포함할 수 없습니다.
CHECK(CK)          : 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정


제약은 아니지만 default sysdate ....
*/
-- PRIMARY KEY(PK) : NOT NULL 과  UNIQUE 조건 >> null 데이터와 중복값 안되요
-- 보장 (유일값)
-- empno primary key >> where empno=7788 >> 데이터 1건 보장
-- PK (주민번호, 회원 ID, 상품ID )
-- 성능 (PK자동으로 index ....) >> 조회 empno >> 성능 >> index >> 자동생성

--테이블당 1개만 설정 ( 1개의 의미는 (묶어서))  >> 복합키 
-- 언제
--1. create table  생성시 제약 생성
--2. create table 생성후에 필요에 따라서 추가 (alter table emp add constraint ... )

-- 제약확인
select * from user_constraints where table_name = 'EMP';

create table temp7(
--    id number primary key -- 권장하지 않는 문법 (제약이름 자동설정 ... 제약 편집 ... )
id number constraint pk_temp7_id primary key, --개발자 제약 이름 : pk_temp7_id
name varchar2(20) not null,
addr varchar2(50)
);

desc temp7;
select * from user_constraints where lower(table_name)='temp7';

insert into temp7 (name, addr) values('홍길동','서울시 강남구');
--ORA-01400: cannot insert NULL into ("KOSA"."TEMP7"."ID") : pk를 null로 할 수 없습니다.

insert into temp7 (id,name, addr) values(10, '홍길동','서울시 강남구');
select * from temp7;
commit;


insert into temp7 (id,name, addr) values(10,'홍길동','서울시 강남구');
-- ORA-00001: unique constraint (KOSA.PK_TEMP7_ID) violated

-- Unique (UK) 테이블의 모든 행을 유일하게 하는 값을 가진 열 (NULL을 허용)
-- 컬럼수 만큼 생성 가능
-- null 허용
-- Unique 제약을 걸고 추가적으로 not null >> 여러개

create table temp8(
id number constraint pk_temp8_id primary key,
name varchar2(20) not null,
jumin nvarchar2(6) constraint uk_temp8_jumin unique,
addr varchar2(50)
);
select * from user_constraints where lower (table_name) ='temp8';

insert into temp8(id, name, jumin, addr)
values(10,'홍길동', '123456', '경기도');

insert into temp8(id, name, jumin, addr)
values(20,'길동', '123456', '서울');--unique제약 걸림 : ORA-00001: unique constraint (KOSA.UK_TEMP8_JUMIN) violated

insert into temp8(id, name, addr)
values(20,'길동', '서울'); -- unique null 허락

select * from temp8;
-- 그럼 null도 중복체크 (아니요)

insert into temp8(id, name, addr)
values(30,'순신', '서울');

select * from temp8;
commit;

-- not null  가져가고 싶으면
-- jumin nvarchar2(6) not null constraint uk_temp8_jumin unique,

-- 테이블 생성 후에 제약 걸기 (추천) 
create table temp9(id number);
--기존 테이블에 제약 추가하기  (대부분의 툴이 이 방법)
alter table temp9
add constraint pk_temp9_id primary key (id);

select * from user_constraints where lower(table_name) ='temp9';

-- create table temp9(id number, num number);
-- alter table temp9
-- add constraint pk_temp9_id primary key (id, num); -- 복합키
-- 유일한 한개의 row >> where id = 100 and num=1

-- 컬럼 추가
alter table temp9 
add ename varchar2(50);

desc temp9;

-- ename 컬럼에 not null 추가
alter table temp9
modify(ename not null);

desc temp9; --ENAME NOT NULL VARCHAR2(50) 

--------------------------------------------
--check 제약 (업무 규칙 - where 조건을 쓰는 것 처럼)
--where gender in ('남','여')
create table temp10(
    id number constraint pk_temp10_id primary key,
    name varchar(20) not null,
    jumin char(6) not null constraint uk_temp10_jumin unique,
    addr varchar2(30),
    age number constraint ck_temp10_age check(age >= 19) -- where age >= 19
    -- ck는 check제약 temp10인 테이블에  age 컬럼이
);

select * from user_constraints where table_name = 'TEMP10';

insert into temp10(id, name, jumin, addr , age)
values(100, '홍길동', '123456', '서울시 강남구', 20);

select * from temp10;

insert into temp10(id, name, jumin, addr , age)
values(200, '아무개', '235678', '서울시 강남구', 18);
-- check제약 조건 위반 : ORA-02290: check constraint (KOSA.CK_TEMP10_AGE) violated
commit;

-- Foreign Key (FK) :   열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니ㅏㄷ.
-- 참조제약 (테이브로가 테이블과의 관계설정)
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
-- c_emp 테이블에 있는 deptno 컬럼의 데이터는 c_dept 테이블에 있는 deptno 컬럼에 있는 데이터만 쓰겠다
-- 강제 (FK)

-- 에러이유 : c_dept에 deptno 컬럼이 신용이 없어요 (PK, UNIQUE) ... 가 있어야 참조가능
alter table c_emp
add constraint fk_c_emp_deptno foreign key (deptno) references c_dept(deptno);
--there is no matching unique or primary key constraint in the referenced table.

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

-- 그리고 나서 참조제약 -- fk 안하고 위에 alter ~ add 해도 되버렸는디??
alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno) references c_dept(deptno);

select * from user_constraints where table_name = 'C_DEPT';
select * from user_constraints where table_name = 'C_EMP';

--  부서
insert into c_dept(deptno, dname) values(100, '인사팀');
insert into c_dept(deptno, dname) values(200, '관리팀');
insert into c_dept(deptno, dname) values(300, '회계팀');
commit;

select * from c_dept;
--신입사원 입사
insert into  c_emp(empno, ename, deptno)
values(1, '신입이', 100);
-- into  c_emp(empno, ename, deptno) -- 수정해보기
--values(1, '신입이', 100);

select * from c_emp;

insert into  c_emp(empno, ename, deptno)
values(2, '아무개', 101);
--ORA-02291: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - parent key not found


commit;
--------------------------------------------------------------------------------
--제약 END-----------------------------------------------------------------------
-- 개발자 관점에서  FK 살펴보기 --
-- master - detail 관계
-- 부모 - 자식 관계

-- c_emp와 c_dept (관계 FK) >> c_emp(deptno) 칼럼이 c_dept(deptno) 컬럼을 참조
--  FK 관계 : master (c_dept) - detail (c_emp) >> 화면 (부서 출력) >> 부서번호 클릭 >> 사원정보 출력
-- deptno 참조 관게 부모 (c_dept) - 자식 (c_emp) 

--관계 PK 가지고 있는 쪽 (master) , FK (detail)
select * from c_dept;

select * from c_emp;

--1. 위 상황에서 c_emp 테이블에 있는 신입이 삭제할 수 있을까요?
delete from c_dept where deptno=100;
-- ORA-02292: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - child record found
delete from c_dept where deptno=200; -- 삭제가능 이유) c_emp 가 빌려쓰고 있지 않다.

delete from c_dept where deptno = 100;
delete from c_emp where empno=1; -- 참조하지 않게 .... 만들어서
-- 자식삭제
-- 부모삭제

/*
column datatype [CONSTRAINT constraint_name]
 REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE])
column datatype,
. . . . . . . ,
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])
 REFERENCES table_name (column1[,column2,..] [ON DELETE CASCADE])
 
 ON DELETE CASACADE 부모 테이블과 생명을 같이 하겠다.
 
 alter table c_emp
 add constraint fk_c_emp_deptno foreign key(deptno) references c_dept(deptno) ON DELETE CASCADE;
 
 delete from c_emp where empno=1 >> deptno >> 100 번
 
 delete from c_dept where deptno=100; 삭제안되요 (참조하고 있으니까)
 ON DELETE CASCADE 걸면 삭제되요
 
 부모삭제 >> 참조하고 있는 자식도 삭제
 
 MS-SQL
 ON DELETE CASCADE
 ON UPDATE CASCADE

*/

--------------------------------------------------------------------------------QUIZ
/*
--영문테이블 , 영문 컬럼명
--[학생 성적 테이블]
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다
--이름 NULL 값을 허용하지 않는다
--국어
--영어
--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용
--값을 입력하지 않으면 default로 0값을 갖는다
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다
--학과코드는 학과 테이블에 학과코드를 참조한다
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드

--학과 테이블
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,
--학과명 은 null값을 허락하지 않는다

--학과코드 , 학과명

--샘플 데이터 insert ..
--그리고 select 결과는
--학번 , 이름 , 총점, 평균 , 학과코드 , 학과명 을 출력하세요
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

insert into class(classCode, className) values(100, '1반');
insert into class(classCode, className) values(200, '2반');

insert into studentScore(id, name, Korean, English, Math, classCode) values(100, '제이쓴',70,80,95,100);
insert into studentScore(id, name, Korean, English, Math, classCode) values(200, '밥', 50,80,80,200);
insert into studentScore(id, name, Korean, English, classCode) values(300, '조지', 50,80,200);

select * 
from class;

select * 
from studentScore;

select s.id, s.name, s.totalscore, trunc(s.avgscore,0), s.classCode, c.className
from studentScore s left join class c on s.classCode = c.classCode;

--========================================================================================================
-- 현동
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
-- 병국
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
-- 학과 테이블에서 PK는 hakgwa
desc stugrade;
*/
----------------------------------------------------------------------------------------------------------------
-- 요기까지 초금 과정 END ----------------------------------------------------------------------------------------

--제 12장 VIEW (초중급)
-- 가상 테이블 (subquery >> in line view >> from ()  )
-- 필요한 가상 테이블 
/*
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
AS Subquery 
[WITH CHECK OPTION [CONSTRAINT constraint ]]
[WITH READ ONLY]
OR REPLACE 이미 존재한다면 다시 생성한다.
FORCE Base Table 유무에 관계없이 VIEW 을 만든다.
NOFORCE 기본 테이블이 존재할 경우에만 VIEW 를 생성한다.
view_name VIEW 의 이름
Alias Subquery 를 통해 선택된 값에 대한 Column 명이 된다.
Subquery SELECT 문장을 기술한다.
WITH CHECK OPTION VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다. 
Constraint CHECK OPTON 제약 조건에 대해 지정된 이름이다.
WITH READ ONLY 이 VIEW 에서 DML 이 수행될 수 없게 한다
*/
----SYSTEM PRVILEGES
----GRANT CREATE ANY VIEW TO "KOSA" WITH ADMIN OPTION;

create view view001   -- 가상테이블, 테이블과 똑같는 기능 사용 가능
as 
    select * from emp;
-- 권한 없음01031. 00000 -  "insufficient privileges" >> 권한 설정하고 옴
-- view001 이라는 객체가 생성 되었어요 (가상 테이블 >> 쿼리 문장을 가지고 있는 객체)
-- 이 객체는 테이블처럼 사용할 수 있는 객체
select * from view001;  -- view 001이라는 객체 안에있는 쿼리를 사용하는것임. view001은 테이블이 아님
select * from view001 where deptno=20;

-- VIEW (가상 테이블) 
-- 사용법 : 일반 테이블과 동일 (select , insert, update, delete)
-- 단 , VIEW 볼 수 있는 데이터에 한해서
-- View 통해서 원본 테이블에 insert, update, delete (DML)가능 ... 가능 정도만...

-- VIEW 목적
--1. 개발자의 편리성 : join , subquery 복잡한 쿼리 미리 생성두었다가 사용
--2. 쿼리 단순화 : view 생성해서 JOIN 편리성
--3. DBA 보안 : 원본테이블은 노출하지 않고 view 만들어서 제공 (특정 컬럼을 노출하지 않는다)

create or replace view v_001
as 
    select empno, ename from emp;
--컴 껐다켜도 남아있은 계정이 가지고있는 객체로 남아있음

select * from v_001;

create or replace view v_emp
as
    select empno, ename, job, hiredate from emp;
    
-- 신입이 .... v_emp
select * from v_emp;
select * from v_emp where job='CLERK';

--편리성
create or replace view v_002
as 
    select e.empno, e.ename, e.deptno, d.dname
    from emp e join dept d
    on e.deptno = d.deptno;
    
-- 자주쓰는 쿼리 view에 등록해두고 쓰면 좋음
select * from v_002;

-- 직종별 평균 급여를 볼 수 있는 view 작성 9객체) -- 객체를 drop하지 않는 한 영속적...

create view v_003
as
    select deptno, trunc(avg(sal),0) as avgsal from emp group by deptno;
    
select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join v_003 s
on e.deptno =  s.deptno
where e.sal > s.avgsal;


/*
 view 나름 테이블 (가상) view 를 [통해서] view가 [볼수있는]데이터에 대해서
 DML (insert, update, delete) 가능 .....
*/


/*
create or replace view v_emp
as
    select empno, ename, job, hiredate from emp;
*/
select * from v_emp;

update v_emp
set sal = 0; --  불가능 이유) view가 볼 수 없는 data이기 때문. 위에서 정의한 v_emp 에는 sal 컬럼이 없다.

update v_emp
set job = 'IT';

select * from v_emp;
select * from emp; -- 원본 도  job이 모두 IT로 바뀌어있음
rollback;
-- 속지 않도록 주의!!!
-- 왜냐하면 가상 테이블은 data를 가지고있지 않기 때문에 수정시 원본이 수정됨!!


-------------------------------
--  30번 부서 사원들의 직종, 이름 , 월급을 담는 view를 만드는데, 
-- 각각의 컬럼명을 직종, 사원이름, 월급으로 alias를 주고 월급이
-- 300 보다 많은 사원들만 추출하도록 하라. view101

create or replace  view v101
as
    select job as "직종" , ename as "사원이름" , sal as "월급" from emp
    where deptno = 30 and sal > 300;
    
select * from v101;

-- 부서별 평균 월급을 담는 view를 만들되, 평균월급이 2000 이상인 
-- 부서만 출력하도록 하라. view102

create or replace view view102
as 
    select deptno, avg(sal) as avgsal
    from emp 
-- x틀림    where (select avg(sal) from emp group by deptno) >= 2000
    group by deptno
    having avg(sal) >= 2000;
    
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 조과제 문제 만들기
show user;
select * from employees;
select * from departments;
select * from locations;
desc locations;

-- Seattle에 위치한 부서를 제외하고 부서별 월급 평균을 내림차순으로 정리하세요.
-- 부서명과 평균월급 컬럼을 이름으로 하세요.

select department_name as  부서명, trunc(avg(salary), 0) as 평균월급
from employees a join (select * from departments
                        where location_id != (select location_id from locations where city = 'Seattle')
                        ) b on a.department_id = b.department_id
group by department_name
order by 평균월급 desc;


-----------------------------------------------------------------------------------------
/*
문제 - 현동
Seattle에서 근무하는 2005년 이후에 입사한 사원들의 부서별 평균 급여를 비교하고, 가장 낮은 평균 급여를 가진 부서를 찾아 
그 부서의 모든 사원 목록을 출력하세요.
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


