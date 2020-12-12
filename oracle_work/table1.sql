/*
    Table 
        가로(row), 세로(column)
        create  생성 
        drop    삭제
        alter   수정
        
        * 검색하는 것은 테이블만 불러오면 검색할 수 있음
        
        Date
            insert
            delete
            select
            update
            
*/

CREATE TABLE TB_TEST01(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(10)
); -- 생성


DROP TABLE TB_TEST01; --삭제

CREATE TABLE TB_TEST02(
    COL1 VARCHAR2(10),
    COL2 NUMBER(5, 1),
    COL3 DATE
); 

-- TABLE COPY : 데이터 포함
CREATE TABLE TB_TEST03
AS --테이블을 복사할 때 쓰는 명령어
SELECT * FROM employees;

SELECT
    *
FROM tb_test03;

DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03(empno, ename, sal) -- (내가 지정한 원하는 명칭으로 만들 수 있음)
AS 
SELECT employee_id, first_name, salary FROM employees;

SELECT
    *
FROM tb_test03;

CREATE TABLE TB_DEPTGROUP(dnum, dcount)
AS
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;


SELECT
    *
FROM TB_DEPTGROUP;

-- TABLE COPY : 데이터 미포함
CREATE TABLE TB_TEST04
AS
SELECT
    *
FROM departments
WHERE 1 = 2; -- 당연히 거짓되는 조건을 두면 뼈대만 가져오고 데이터는 가져오지 않는다.

SELECT
    *
FROM TB_TEST04;

CREATE TABLE DEPT_EMP(empno, sal, dname, loc)
AS
SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- 테이블 수정

-- 테이블명 수정
ALTER TABLE TB_TEST04
RENAME TO TB_TEST99;

-- 컬럼 추가
--단일 컬럼추가
ALTER TABLE TB_TEST99
ADD
NEWCOL VARCHAR2 (20); -- 자료형은 원하는대로 변경가능 
--다중 컬럼추가
ALTER TABLE TB_TEST99
ADD
(COLNEW1 NUMBER, COLNEW2 DATE); -- 해당처럼 NUMBER, DATE 자료형도 사용가능하다

--단일컬럼 수정
ALTER TABLE TB_TEST99
MODIFY
NEWCOL VARCHAR2(30);

-- 다중 컬럼 수정
ALTER TABLE TB_TEST99
MODIFY
(COLNEW1 VARCHAR2(20), COLNEW2 VARCHAR2(30));

--컬럼삭제
--단일컬럼삭제
ALTER TABLE TB_TEST99
DROP
COLUMN NEWCOL;
--다중컬럼삭제
ALTER TABLE TB_TEST99
DROP
(COLNEW1, COLNEW2);

--컬럼명 수정
ALTER TABLE TB_TEST99
RENAME
COLUMN
-- 현재이름 TO 바뀔이름
DEPARTMENT_ID TO DEPTNO;

DROP TABLE TB_TEST99;

-- 휴지통비우기
PURGE RECYCLEBIN;

--INSERT
INSERT INTO TB_TEST04(department_id, department_name, manager_id, location_id)
VALUES(100, '기획부', 20, 200);

SELECT
    *
FROM TB_TEST04;

INSERT INTO TB_TEST04(department_id, department_name)
VALUES(100, '기획부');

INSERT INTO TB_TEST04
VALUES(100, '관리부', 30, 400);

INSERT INTO TB_TEST04( manager_id, location_id, department_id, department_name)
VALUES(50, 500, 102, '영업부');

--DELETE
DELETE FROM tb_test04
WHERE manager_id = 20;

DELETE FROM tb_test04
WHERE manager_id IS NULL;

--UPDATE
UPDATE tb_test04
SET manager_id = 40
WHERE department_name = '영업부';

UPDATE tb_test04
SET manager_id = 10, location_id = 100, department_id = 1000 -- 여러개도 수정가능
WHERE department_name = '관리부';

UPDATE tb_test04
SET manager_id = 10, location_id = 100 -- 하나의 조건으로 여러행도 변경가능
WHERE department_id > 100;