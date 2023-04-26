--오라클.pdf
-- sequence ( 시퀀스)

/*
--sequence (시퀀스)

SEQUENCE 특징 
1) 자동적으로 유일 번호를 생성합니다.
2) 공유 가능한 객체
3) 주로 기본 키 값을 생성하기 위해 사용됩니다.
4) 어플리케이션 코드를 대체합니다.
5) 메모리에 CACHE 되면 SEQUENCE 값을 액세스 하는 효율성을 향상시킵니다.

CREATE SEQUENCE sequence_name
[INCREMENT BY n]
[START WITH n]
[{MAXVALUE n | NOMAXVALUE}]
[{MINVALUE n | NOMINVALUE}]
[{CYCLE | NOCYCLE}]
[{CACHE | NOCACHE}];

sequence_name SEQUENCE 의 이름입니다.
INCREMENT BY n 정수 값인 n 으로 SEQUENCE 번호 사이의 간격을 지정.
이 절이 생략되면 SEQUENCE 는 1 씩 증가.
START WITH n 생성하기 위해 첫번째 SEQUENCE 를 지정.
이 절이 생략되면 SEQUENCE 는 1 로 시작.
MAXVALUE n SEQUENCE 를 생성할 수 있는 최대 값을 지정.
NOMAXVALUE 오름차순용 10^27 최대값과 내림차순용-1 의 최소값을 지정.
MINVALUE n 최소 SEQUENCE 값을 지정.
NOMINVALUE 오름차순용 1 과 내림차순용-(10^26)의 최소값을 지정.
CYCLE | NOCYCLE 최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를
지정. NOCYCLE 이 디폴트.
CACHE | NOCACHE 얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지
하는가를 지정. 디폴트로 오라클 서버는 20 을 CACHE.

*/
show user;
drop table board;

create table board (
    boardid number constraint pk_board_boardid primary key,
    title nvarchar2(50)
);

select * from user_constraints where table_name = 'BOARD'; -- 테이블 명 대문자로 검색해야함!!!!!
-- not null , unique, index (검색속도)

-- 게시판 글쓰기 작업
insert into board(boardid, title) values(1,'처음글');
insert into board(boardid, title) values(2,'두번째');
rollback;
select * from board;

-- 처음 글을 쓰면 글번호가 1번 ... 그 다음 글 순차적인 증가값... 2번, 3번
-- 어떤 논리
select count(boardid)+1 from board;
insert into board(boardid, title)
values((select count(boardid)+1 from board), '내용1');

insert into board(boardid, title)
values((select count(boardid)+1 from board), '내용2');

insert into board(boardid, title)
values((select count(boardid)+1 from board), '내용3');

select * from board;
commit;
-- 게시글 삭제, 수정
-- 게시글 삭제

delete from board where boardid=1;

select * from board;
commit;

insert into board(boardid, title)
values((select count(boardid) + 1 from board), '새글'); --중복값(로직 x) ORA-00001: unique constraint (KOSA.PK_BOARD_BOARDID) violated

-- 데이터가 삭제되어도 문제없는 순번을 가지고 싶어요
insert into board(boardid, title)
values((select nvl(max(boardid),0)+1 from board),'새글');

select * from board;
---------------------------------------------------------
-- 시퀀스 생성하기 (순번 만들기) : 객체 (create ....) : 순차적인 번호를 생성하는 객체
create sequence board_num; -- 순번을 만든다

select board_num.nextval from dual; --채번 (번호표 뽑기)
select board_num.currval from dual; -- 현재까지 채번한 번호 확인 (마지막)
-- 공유(객체) >> 하나의 테이블이 아니라 여러개의 테이블 사용

-- A 테이블,              B 테이블
-- ( insert >> 1           (insert >> 2,  insert >> 3
-- ( insert >> 4
-- 헐 번호표를 테이블이 공유를 하네 ;;
--------------------------------------------------------
create table kboard(
    num number constraint pk_kboard_num primary key,
    title nvarchar2(20)
);

create sequence kboard_num;

insert into kboard(num, title) values (kboard_num.nextval, '처음');
insert into kboard(num, title) values (kboard_num.nextval, '두번째');
insert into kboard(num, title) values (kboard_num.nextval, '세번째');

select * from kboard;
------------------------------------------------------------------------------
/*
-- 게시판
-- 공지사항, 자유게시판, 답변형게시판 .....
공지사항 1,2,3 (시퀀스객체1)
자유게시판 1,2,3 (시퀀스객체2)
답변형 게시판 1,2,3 (시퀀스객체3)

>> 시퀀스 객체 최소 3개
----------------------------------------------------

공지사항 1 , 6
자유게시판 2 , 3
답변형게시판 4 , 5

>> 시퀀스 객체 한개 가지고 3개 테이블에서 사용 (공유객체)
-- ex) 네이버 카페 글번호
----------------------------------------------------

TIP)
sequence(시퀀스) 모든 DB에 있을까?
오라클 (O)
MS-SQL (O - 2012버전 부터 )
MY-SQL (X)
MariaDB (O - MY-SQL 과 똑같은 엔진) : https://mariadb.com/kb/ko/sequence-overview/
PostgreSQL (o) 헐

-- 순번을 생성 (테이블 종속적으로)
MS-SQL
create table board(boardnum int identity(1,1) ... title)
insert into board(title) values('제목'); >> boardnum >> 1이 자동

MY-SQL
create table board(boardnum int auto_increment, ...title
insert into board(title) values('제목'); >> boardnum >> 1이 자동 증가
*/

--옵션을 걸면 글번호 원하는 것 부터 시작할 수 있음
create sequence seq_num 
start with 10    -- 10부터 시작해서
increment by 2;  -- 2씩 증가

select seq_num.nextval from dual; -- 채번

select seq_num.currval from dual; -- 현재 번호 확인

-- 순번
-- 게시판 처음 ..... 데이터 가져올때
-- 쿼리문
-- num > 1 ,2 ,3 ,,,,,, 1000 ,,,,,,,,,10000
-- select * from board order by num desc

-- rownum : 의사컬럼 : 실제 물리적으로 존재하는 컬럼이 아니고 논리적 존재 (create table (x) 사용안되요)
-->>>>>>>>>>>>>>>>>>>>>>>이후 내용 손실 : 석진 필기>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
--rownum : 의사컬럼 : 실제 물리적으로 존재하는 컬럼이 아니고 논리적 존재 (create table (x) 사용안되요)
--rownum  : 실제로 테이블에 컬럼으로 존재하지 않지만 내부적으로 행 번호를 부여하는 컬럼

select * from emp;

select rownum , empno , ename ,sal
from emp;

select rownum , empno , ename ,sal
from emp
order by sal; 
--실행순서   >> from >> select >> order by

select rownum , e.*
from  (
        select  empno , ename ,sal
        from emp
        order by sal  --정렬의 기준
      ) e;

--Top-n 쿼리 (기준이 되는 데이터 순으로 정렬 시키고 상위 n 개 가지고 오기)
--MS-SQL : select top 10 , * from emp order by sal desc;

--Oracle Top n(x)
--rownum (순번부여 ..... 상위 n)
--1. 정렬의 기준 설정하기 (선행)
--2. 정렬된 기준에 rownum 붙이고 .... 데이터 추출

--급여를 많이 받는 순으로 정렬된 데이터 (rownum) >> 순번
select rownum , e.*
from  (
        select  empno , ename ,sal
        from emp
        order by sal desc  --정렬의 기준
      ) e;

--급여를 많이 받는 사원 5명

select *
from (
        select rownum as num , e.*
        from  (
                select  empno , ename ,sal
                from emp
                order by sal desc  --정렬의 기준
         ) e
      ) n where num <= 5; -- 대용량 데이터  페이징 원리 (TODAY POINT)
      
-- between A and B --페이징 처리
--------------------------------------------------------------------------------
--기업( 10만건 ~ 1억건)
--게시판 ( 게시글 10만건)
--select * from board >> 10 만건 조회 ....
--10만건 나우어서 (10건씩, 20건씩)
/*
totaldata=100건
pagesize = 10 한 화면에 보여지는 데이터 row 수 : 10건씩 할꺼야
totaldata / pagesize >> page 개수  >> 10개

[1][2][3][4][5][6][7][8][9][10]
<a href='page.jsp?page=1'>1</a>
1page 클릭 >> 1~10까지 글 : DB 쿼리 : select  num between 1 and 10
2page 클릭 >> 11~20까지 글 : DB 쿼리 : select  num between 11 and 20

1. rownum
2. between 

HR계정 이동
USER이(가) "HR"입니다.
*/
show user;
select * from employees;  --107건

--사원번호가 낮은 순으로 정렬한 기준을 통해서 .... 41 부터 50번째 데이터 추출
--rownum 사용
/*
107건
pagesize=10
--[][][][][][][][][][][11]
--[1] >> 1~10
--[2] >> 11~20
...
--[5] >> 41 ~50 클릭가정....


*/
--1 단계 (기준 데이터 만들기(정렬))
--사번이 낮은 순으로 정렬
select * from employees order by employee_id asc;

--2단계 (기준 데이터에 순번 부여하기)
select rownum as num , e.*
from (
        select * from employees order by employee_id asc
     ) e
where rownum <=50; --정렬된 데이터에 내부적으로 생성된 rownum 

--3단계 
select *
from (
        select rownum as num , e.*
        from (
                select * from employees order by employee_id asc
             ) e
        where rownum <=50
      ) n where num >=41; 

--게시판 만들기 할때 사용합니다
--servlet/jsp 

select *
from (
        select rownum as num , e.*
        from (
                select * from employees order by employee_id asc
             ) e
      ) n where num between 40 and 51;
-----------정리하자면 위 세 단계에 걸친 방법1 과 between을 사용한 방법2가 있음

-------------------------------------------
-- 사원번호가 낮은 순으로정렬하고 정렬한 기준을 통해서 ...41 부터 50번째 데이터 추출
-- 방법 1
select * 
from (
 select rownum as num, e.*
 from (
    select * from employees order by employee_id asc
 ) e
 where rownum <= 50
)n where num >= 41;


-- 방법 3
select * 
from (
    select rownum as num, e.*
    from employees e
    order by employee_id
)n
where n.num between 41 and 50;

--------------------------------------------------------------------------------
--분석함수 (조금씩) --개념(index)  --PL-SQL 진도 조금씩 할게요
--------------------------------------------------------------------------------
--담주 JDBC (JAVA) - MariaDB세팅 (기본작업)