-- 문제1) EMPLOYEES 테이블에서 부서별로 
-- 인원수,평균 급여,급여의 합,최소 급여, 최대 급여를 포함하는 EMP_DEPTNO 테이블을 생성하라.
CREATE TABLE EMP_DEPTNO(cou, asal, ssal, misal, masal)
AS
SELECT COUNT(*), ROUND(AVG(salary)), SUM(salary), MIN(salary), MAX(salary)
FROM employees;


SELECT
    *
FROM EMP_DEPTNO;

-- 문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라.
-- 단 자료형은 VARCHAR2(50) 사용하라.
ALTER TABLE EMP_DEPTNO
ADD
ETC_COLUMN VARCHAR2(50);

-- 문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라.
-- 자료 형은 VARCHAR2(15)로 하라.
ALTER TABLE EMP_DEPTNO
MODIFY
ETC_COLUMN VARCHAR2(15);

-- 문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.
ALTER TABLE EMP_DEPTNO
DROP
COLUMN ETC_COLUMN;

-- 문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.
ALTER TABLE EMP_DEPTNO
RENAME TO EMP_DEPT;

-- 문제6) EMP_DEPT 테이블을 삭제하라.
DROP TABLE EMP_DEPT;

-- 문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라.(데이터 포함)
CREATE TABLE EMP
AS
SELECT * FROM EMPLOYEES;

-- 문제8) EMP 테이블에 row를 추가해 봅니다.
-- 다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다.

INSERT INTO EMP
VALUES(207, 'JU', 'DASUL','WGIETZ', '515.123.456','02/06/08','AC_ACCOUNT',8300, NULL, 205, NULL);

-- 문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여 
-- EMP_10 테이블을 생성(데이터 미포함)한 후 10번 부서만 선택하여
-- 이에 대응하는 값을 EMP_10테이블에 입력하라.
CREATE TABLE EMP_10
AS
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE department_id = 10;

-- 문제10) 다음은 무결성 제약 조건이 위배된 쿼리이다.
-- 무엇을 위배했는지 알아보도록 합시다.

/*
INSERT INTO EMPLOYEES
VALUES (100, NULL, 'YOON', 'dbs', NULL, SYSDATE, 'ST_MAN', NULL, NULL,
NULL, NULL);

INSERT INTO EMPLOYEES
VALUES (98, NULL, 'YOON', 'dbs', NULL, SYSDATE, 'ST_MAN', NULL, NULL,
NULL, 100);

INSERT INTO EMPLOYEES
VALUES (98, NULL, 'YOON', 'dbs2', NULL, SYSDATE, 'ST_MAN', NULL, NULL,
NULL, 101);
*/