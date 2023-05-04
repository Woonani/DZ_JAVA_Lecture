/* 내 테이블1 */
DROP TABLE my_table1 
	CASCADE CONSTRAINTS;

/* 내 테이블2 */
DROP TABLE my_table2 
	CASCADE CONSTRAINTS;

/* 내 테이블1 */
CREATE TABLE my_table1 (
	my_pk1 INTEGER NOT NULL, /* 내 기본 키 컬럼1 */
	my_pk2 INTEGER NOT NULL, /* 내 기본 키 컬럼2 */
	my_column1 VARCHAR(20) NOT NULL, /* 내 컬럼1 */
	my_column2 VARCHAR(20) /* 내 컬럼2 */
);

COMMENT ON TABLE my_table1 IS 'DDL 생성 예제 테이블입니다.';

COMMENT ON COLUMN my_table1.my_pk1 IS '내 기본 키 컬럼1';

COMMENT ON COLUMN my_table1.my_pk2 IS '내 기본 키 컬럼2';

COMMENT ON COLUMN my_table1.my_column1 IS '내 컬럼1';

COMMENT ON COLUMN my_table1.my_column2 IS '내 컬럼2';

CREATE UNIQUE INDEX my_table1_pk
	ON my_table1 (
		my_pk1 ASC,
		my_pk2 ASC
	);

CREATE UNIQUE INDEX my_table1_uq
	ON my_table1 (
		my_column1 ASC
	);

CREATE UNIQUE INDEX my_table1_uq_sys_gen
	ON my_table1 (
		my_column2 ASC
	);

ALTER TABLE my_table1
	ADD
		CONSTRAINT my_table1_pk
		PRIMARY KEY (
			my_pk1,
			my_pk2
		);

ALTER TABLE my_table1
	ADD
		CONSTRAINT my_table1_uq
		UNIQUE (
			my_column1
		);

ALTER TABLE my_table1
	ADD
		CONSTRAINT my_table1_uq_sys_gen
		UNIQUE (
			my_column2
		);

ALTER TABLE my_table1
	ADD
		CONSTRAINT my_table1_cc
		CHECK (my_pk1 > 1900 AND my_column2='Tomato System');

/* 내 테이블2 */
CREATE TABLE my_table2 (
	my_pk1 INTEGER NOT NULL, /* 내 기본 키 컬럼1 */
	my_pk2 INTEGER NOT NULL, /* 내 기본 키 컬럼2 */
	my_column VARCHAR(20) NOT NULL /* 내 컬럼1 */
);

COMMENT ON TABLE my_table2 IS '내 테이블2';

COMMENT ON COLUMN my_table2.my_pk1 IS '내 기본 키 컬럼1';

COMMENT ON COLUMN my_table2.my_pk2 IS '내 기본 키 컬럼2';

COMMENT ON COLUMN my_table2.my_column IS '내 컬럼1';

CREATE UNIQUE INDEX my_table2_pk
	ON my_table2 (
		my_pk1 ASC,
		my_pk2 ASC
	);

CREATE INDEX my_table2_idx
	ON my_table2 (
		my_column ASC
	);

ALTER TABLE my_table2
	ADD
		CONSTRAINT my_table2_pk
		PRIMARY KEY (
			my_pk1,
			my_pk2
		);

ALTER TABLE my_table2
	ADD
		CONSTRAINT my_table2_fk
		FOREIGN KEY (
			my_pk1,
			my_pk2
		)
		REFERENCES my_table1 (
			my_pk1,
			my_pk2
		);
---------------------------------------------------------------------------------
SELECT * FROM employees;
SELECT * FROM positions;
SELECT * FROM salaries;
SELECT * FROM departments;
SELECT * FROM vacations;


-- 기본 데이터 insert
-- 1. departments 부서테이블
DESC departments;
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME) values(10,'경영지원');
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME) values(20,'영업');
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME) values(30,'IT');
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME) values(40,'인사');
SELECT * FROM departments;

-- 2. positions 직급테이블
DESC positions;
insert into positions(POSITION_ID, POSITION_NAME) values(1,'사원');
insert into positions(POSITION_ID, POSITION_NAME) values(2,'부서장');
SELECT * FROM positions;


-- 3. employees 사원테이블
DESC employees;
select * from user_constraints where table_name = 'employees';
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1001,'홍길동','서울특별시 종로구', '01044557788', '2016-06-14', 10, 2, 1001);

insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1002,'김유신','서울특별시 강남구', '01044557788', '2017-11-16', 10, 1, 1001);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1003,'김창현','서울특별시 동대문구', '01001234568', '2019-05-23', 20, 2, 1003);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1004,'우나은','서울특별시 노원구', '01002345878', '2018-09-12', 30, 2, 1004);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1005,'조병국','인천광역시 부평구', '01003457188', '2016-08-17', 40, 2, 1005);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1006,'최현동','경기도 부천시 ', '01004568498', '2017-03-24', 40, 1, 1005);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1008,'장석진','경상남도 김해시', '01005679808', '2020-06-19', 10, 1, 1001);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1009,'김연아','부산광역시 해운대구', '01006791118', '2015-11-22', 10, 1, 1001);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1010,'손흥민','대전광역시 대덕구', '01007902428', '2016-10-28', 20, 1, 1003);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1011,'김민재','울산광역시 남구', '01009013738', '2021-01-02', 20, 1, 1003);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1012,'김첨지','대구광역시 북구', '01010125048', '2015-11-25', 30, 1, 1004);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1013,'박태환','강원도 춘천시 남산면 ', '01011236358', '2016-10-15', 30, 1, 1004);
insert into employees(EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID) 
values(1007,'손오공','인천광역시 옹진군 연평면', '01012347668', '2015-11-25', 40, 1, 1005);
SELECT * FROM employees;

commit;
-- 4. salaries 급여테이블
DESC salaries;
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1001,to_date('2023-03-25'),620);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1002,to_date('2023-03-25'),680);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1003,to_date('2023-03-25'),700);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1004,to_date('2023-03-25'),850);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1005,to_date('2023-03-25'),400);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1006,to_date('2023-03-25'),280);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1007,to_date('2023-03-25'),350);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1008,to_date('2023-03-25'),950);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1009,to_date('2023-03-25'),1200);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1010,to_date('2023-03-25'),825);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1011,to_date('2023-03-25'),856);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1012,to_date('2023-03-25'),887);
INSERT INTO SALARIES (EMPLOYEE_ID, PAYMENT_DATE, SALARY) VALUES (1013,to_date('2023-03-25'),918);


SELECT * FROM salaries;


-- 5. vacations 휴가테이블
DESC vacations;


SELECT * FROM vacations;

CREATE OR REPLACE PROCEDURE pj_insert_emp
(
 VEMPLOYEE_ID IN EMPLOYEES.EMPLOYEE_ID%TYPE,
 VEMPLOYEE_NAME IN EMPLOYEES.EMPLOYEE_NAME%TYPE,
 VADDRESS   IN EMPLOYEES.ADDRESS%TYPE,
 VPHONE_NUMBER   IN EMPLOYEES.PHONE_NUMBER%TYPE,
 VHIRE_DATE   IN EMPLOYEES.HIRE_DATE%TYPE,
 VDEPARTMENT_ID   IN EMPLOYEES.DEPARTMENT_ID%TYPE,
 VPOSITION_ID   IN EMPLOYEES.POSITION_ID%TYPE,
 VMANAGER_ID   IN EMPLOYEES.MANAGER_ID%TYPE
 )
 IS
   BEGIN
      INSERT INTO EMPLOYEES(EMPLOYEE_ID , EMPLOYEE_NAME, ADDRESS, PHONE_NUMBER, HIRE_DATE, DEPARTMENT_ID, POSITION_ID, MANAGER_ID ) 
      VALUES(VEMPLOYEE_ID ,VEMPLOYEE_NAME , VADDRESS, VPHONE_NUMBER, VHIRE_DATE, VDEPARTMENT_ID, VPOSITION_ID, VMANAGER_ID);
      COMMIT;
        p_outmsg := 'success';
        EXCEPTION WHEN OTHERS THEN
        p_outmsg := SQLERRM;
        ROLLBACK;
    END;

DECLARE
  out_msg varchar2(200);
BEGIN
   usp_insert_emp(7902,'홍길동','IT',out_msg);
   DBMS_OUTPUT.put_line('출력값 : ' || out_msg);
END;