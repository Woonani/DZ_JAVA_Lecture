-- 프로시저 작성
-- 같은 이름의 프로시저 있으면 삭제


-select프로시져----------------------------------------------------------------------
DROP PROCEDURE IF EXISTS usp_EmpList;


USE kosadb; -- 사용할 DB
DROP PROCEDURE IF EXISTS usp_EmpList; -- usp_EmpList이 존재하면 삭제
-- 전체조회
DELIMITER $$
CREATE PROCEDURE usp_EmpList()
BEGIN
  SELECT * FROM EMP;
END $$
DELIMITER ;


select * from USER;
SHOW PROCEDURE STATUS;
---------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS selec_by_EmpList;
DELIMITER //
CREATE PROCEDURE selec_by_EmpList(
	IN p_sal INT
)
BEGIN
	SELECT * FROM emp WHERE sal > p_sal; -- 여기 ;이거 안붙여서 계속 안되는 거였음
END //
DELIMITER;


-- 프로시저실행

CALL update_point();
select * from user;
-- 스케쥴러 생성
SHOW VARIABLES LIKE 'EVENT%';

CREATE EVENT IF NOT EXISTS POINT_SCHEDULER
	ON SCHEDULE
		EVERY 10 SECOND
	ON COMPLETION NOT PRESERVE ENABLE -- 이벤트 수행 후 삭제 여부
    COMMENT '출석포인트 갱신 작업'
    DO
     CALL update_point();
     
 -- 스케쥴러 수정
alter event point_scheduler
    ON SCHEDULE
		EVERY 15 SECOND
	ON COMPLETION NOT PRESERVE ENABLE -- 이벤트 수행 후 삭제 여부
    COMMENT '출석포인트 갱신 작업'
    DO
     CALL update_point();
	
 -- 스케쥴러 삭제
 drop event point_scheduler;
```
