--����Ŭ.pdf
-- sequence ( ������)

/*
--sequence (������)

SEQUENCE Ư¡ 
1) �ڵ������� ���� ��ȣ�� �����մϴ�.
2) ���� ������ ��ü
3) �ַ� �⺻ Ű ���� �����ϱ� ���� ���˴ϴ�.
4) ���ø����̼� �ڵ带 ��ü�մϴ�.
5) �޸𸮿� CACHE �Ǹ� SEQUENCE ���� �׼��� �ϴ� ȿ������ ����ŵ�ϴ�.

CREATE SEQUENCE sequence_name
[INCREMENT BY n]
[START WITH n]
[{MAXVALUE n | NOMAXVALUE}]
[{MINVALUE n | NOMINVALUE}]
[{CYCLE | NOCYCLE}]
[{CACHE | NOCACHE}];

sequence_name SEQUENCE �� �̸��Դϴ�.
INCREMENT BY n ���� ���� n ���� SEQUENCE ��ȣ ������ ������ ����.
�� ���� �����Ǹ� SEQUENCE �� 1 �� ����.
START WITH n �����ϱ� ���� ù��° SEQUENCE �� ����.
�� ���� �����Ǹ� SEQUENCE �� 1 �� ����.
MAXVALUE n SEQUENCE �� ������ �� �ִ� �ִ� ���� ����.
NOMAXVALUE ���������� 10^27 �ִ밪�� ����������-1 �� �ּҰ��� ����.
MINVALUE n �ּ� SEQUENCE ���� ����.
NOMINVALUE ���������� 1 �� ����������-(10^26)�� �ּҰ��� ����.
CYCLE | NOCYCLE �ִ� �Ǵ� �ּҰ��� ������ �Ŀ� ��� ���� ������ ���� ���θ�
����. NOCYCLE �� ����Ʈ.
CACHE | NOCACHE �󸶳� ���� ���� �޸𸮿� ����Ŭ ������ �̸� �Ҵ��ϰ� ����
�ϴ°��� ����. ����Ʈ�� ����Ŭ ������ 20 �� CACHE.

*/
show user;
drop table board;

create table board (
    boardid number constraint pk_board_boardid primary key,
    title nvarchar2(50)
);

select * from user_constraints where table_name = 'BOARD'; -- ���̺� �� �빮�ڷ� �˻��ؾ���!!!!!
-- not null , unique, index (�˻��ӵ�)

-- �Խ��� �۾��� �۾�
insert into board(boardid, title) values(1,'ó����');
insert into board(boardid, title) values(2,'�ι�°');
rollback;
select * from board;

-- ó�� ���� ���� �۹�ȣ�� 1�� ... �� ���� �� �������� ������... 2��, 3��
-- � ��
select count(boardid)+1 from board;
insert into board(boardid, title)
values((select count(boardid)+1 from board), '����1');

insert into board(boardid, title)
values((select count(boardid)+1 from board), '����2');

insert into board(boardid, title)
values((select count(boardid)+1 from board), '����3');

select * from board;
commit;
-- �Խñ� ����, ����
-- �Խñ� ����

delete from board where boardid=1;

select * from board;
commit;

insert into board(boardid, title)
values((select count(boardid) + 1 from board), '����'); --�ߺ���(���� x) ORA-00001: unique constraint (KOSA.PK_BOARD_BOARDID) violated

-- �����Ͱ� �����Ǿ �������� ������ ������ �;��
insert into board(boardid, title)
values((select nvl(max(boardid),0)+1 from board),'����');

select * from board;
---------------------------------------------------------
-- ������ �����ϱ� (���� �����) : ��ü (create ....) : �������� ��ȣ�� �����ϴ� ��ü
create sequence board_num; -- ������ �����

select board_num.nextval from dual; --ä�� (��ȣǥ �̱�)
select board_num.currval from dual; -- ������� ä���� ��ȣ Ȯ�� (������)
-- ����(��ü) >> �ϳ��� ���̺��� �ƴ϶� �������� ���̺� ���

-- A ���̺�,              B ���̺�
-- ( insert >> 1           (insert >> 2,  insert >> 3
-- ( insert >> 4
-- �� ��ȣǥ�� ���̺��� ������ �ϳ� ;;
--------------------------------------------------------
create table kboard(
    num number constraint pk_kboard_num primary key,
    title nvarchar2(20)
);

create sequence kboard_num;

insert into kboard(num, title) values (kboard_num.nextval, 'ó��');
insert into kboard(num, title) values (kboard_num.nextval, '�ι�°');
insert into kboard(num, title) values (kboard_num.nextval, '����°');

select * from kboard;
------------------------------------------------------------------------------
/*
-- �Խ���
-- ��������, �����Խ���, �亯���Խ��� .....
�������� 1,2,3 (��������ü1)
�����Խ��� 1,2,3 (��������ü2)
�亯�� �Խ��� 1,2,3 (��������ü3)

>> ������ ��ü �ּ� 3��
----------------------------------------------------

�������� 1 , 6
�����Խ��� 2 , 3
�亯���Խ��� 4 , 5

>> ������ ��ü �Ѱ� ������ 3�� ���̺��� ��� (������ü)
-- ex) ���̹� ī�� �۹�ȣ
----------------------------------------------------

TIP)
sequence(������) ��� DB�� ������?
����Ŭ (O)
MS-SQL (O - 2012���� ���� )
MY-SQL (X)
MariaDB (O - MY-SQL �� �Ȱ��� ����) : https://mariadb.com/kb/ko/sequence-overview/
PostgreSQL (o) ��

-- ������ ���� (���̺� ����������)
MS-SQL
create table board(boardnum int identity(1,1) ... title)
insert into board(title) values('����'); >> boardnum >> 1�� �ڵ�

MY-SQL
create table board(boardnum int auto_increment, ...title
insert into board(title) values('����'); >> boardnum >> 1�� �ڵ� ����
*/

--�ɼ��� �ɸ� �۹�ȣ ���ϴ� �� ���� ������ �� ����
create sequence seq_num 
start with 10    -- 10���� �����ؼ�
increment by 2;  -- 2�� ����

select seq_num.nextval from dual; -- ä��

select seq_num.currval from dual; -- ���� ��ȣ Ȯ��

-- ����
-- �Խ��� ó�� ..... ������ �����ö�
-- ������
-- num > 1 ,2 ,3 ,,,,,, 1000 ,,,,,,,,,10000
-- select * from board order by num desc

-- rownum : �ǻ��÷� : ���� ���������� �����ϴ� �÷��� �ƴϰ� ���� ���� (create table (x) ���ȵǿ�)
-->>>>>>>>>>>>>>>>>>>>>>>���� ���� �ս� : ���� �ʱ�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
--rownum : �ǻ��÷� : ���� ���������� �����ϴ� �÷��� �ƴϰ� ���� ���� (create table (x) ���ȵǿ�)
--rownum  : ������ ���̺� �÷����� �������� ������ ���������� �� ��ȣ�� �ο��ϴ� �÷�

select * from emp;

select rownum , empno , ename ,sal
from emp;

select rownum , empno , ename ,sal
from emp
order by sal; 
--�������   >> from >> select >> order by

select rownum , e.*
from  (
        select  empno , ename ,sal
        from emp
        order by sal  --������ ����
      ) e;

--Top-n ���� (������ �Ǵ� ������ ������ ���� ��Ű�� ���� n �� ������ ����)
--MS-SQL : select top 10 , * from emp order by sal desc;

--Oracle Top n(x)
--rownum (�����ο� ..... ���� n)
--1. ������ ���� �����ϱ� (����)
--2. ���ĵ� ���ؿ� rownum ���̰� .... ������ ����

--�޿��� ���� �޴� ������ ���ĵ� ������ (rownum) >> ����
select rownum , e.*
from  (
        select  empno , ename ,sal
        from emp
        order by sal desc  --������ ����
      ) e;

--�޿��� ���� �޴� ��� 5��

select *
from (
        select rownum as num , e.*
        from  (
                select  empno , ename ,sal
                from emp
                order by sal desc  --������ ����
         ) e
      ) n where num <= 5; -- ��뷮 ������  ����¡ ���� (TODAY POINT)
      
-- between A and B --����¡ ó��
--------------------------------------------------------------------------------
--���( 10���� ~ 1���)
--�Խ��� ( �Խñ� 10����)
--select * from board >> 10 ���� ��ȸ ....
--10���� ���� (10�Ǿ�, 20�Ǿ�)
/*
totaldata=100��
pagesize = 10 �� ȭ�鿡 �������� ������ row �� : 10�Ǿ� �Ҳ���
totaldata / pagesize >> page ����  >> 10��

[1][2][3][4][5][6][7][8][9][10]
<a href='page.jsp?page=1'>1</a>
1page Ŭ�� >> 1~10���� �� : DB ���� : select  num between 1 and 10
2page Ŭ�� >> 11~20���� �� : DB ���� : select  num between 11 and 20

1. rownum
2. between 

HR���� �̵�
USER��(��) "HR"�Դϴ�.
*/
show user;
select * from employees;  --107��

--�����ȣ�� ���� ������ ������ ������ ���ؼ� .... 41 ���� 50��° ������ ����
--rownum ���
/*
107��
pagesize=10
--[][][][][][][][][][][11]
--[1] >> 1~10
--[2] >> 11~20
...
--[5] >> 41 ~50 Ŭ������....


*/
--1 �ܰ� (���� ������ �����(����))
--����� ���� ������ ����
select * from employees order by employee_id asc;

--2�ܰ� (���� �����Ϳ� ���� �ο��ϱ�)
select rownum as num , e.*
from (
        select * from employees order by employee_id asc
     ) e
where rownum <=50; --���ĵ� �����Ϳ� ���������� ������ rownum 

--3�ܰ� 
select *
from (
        select rownum as num , e.*
        from (
                select * from employees order by employee_id asc
             ) e
        where rownum <=50
      ) n where num >=41; 

--�Խ��� ����� �Ҷ� ����մϴ�
--servlet/jsp 

select *
from (
        select rownum as num , e.*
        from (
                select * from employees order by employee_id asc
             ) e
      ) n where num between 40 and 51;
-----------�������ڸ� �� �� �ܰ迡 ��ģ ���1 �� between�� ����� ���2�� ����

-------------------------------------------
-- �����ȣ�� ���� �����������ϰ� ������ ������ ���ؼ� ...41 ���� 50��° ������ ����
-- ��� 1
select * 
from (
 select rownum as num, e.*
 from (
    select * from employees order by employee_id asc
 ) e
 where rownum <= 50
)n where num >= 41;


-- ��� 3
select * 
from (
    select rownum as num, e.*
    from employees e
    order by employee_id
)n
where n.num between 41 and 50;

--------------------------------------------------------------------------------
--�м��Լ� (���ݾ�) --����(index)  --PL-SQL ���� ���ݾ� �ҰԿ�
--------------------------------------------------------------------------------
--���� JDBC (JAVA) - MariaDB���� (�⺻�۾�)