-- ����1) EMPLOYEES ���̺��� �μ����� 
-- �ο���,��� �޿�,�޿��� ��,�ּ� �޿�, �ִ� �޿��� �����ϴ� EMP_DEPTNO ���̺��� �����϶�.
CREATE TABLE EMP_DEPTNO(cou, asal, ssal, misal, masal)
AS
SELECT COUNT(*), ROUND(AVG(salary)), SUM(salary), MIN(salary), MAX(salary)
FROM employees;


SELECT
    *
FROM EMP_DEPTNO;

-- ����2) EMP_DEPTNO ���̺� ETC COLUMN�� �߰��϶�.
-- �� �ڷ����� VARCHAR2(50) ����϶�.
ALTER TABLE EMP_DEPTNO
ADD
ETC_COLUMN VARCHAR2(50);

-- ����3) EMP_DEPTNO ���̺� ETC COLUMN�� �����϶�.
-- �ڷ� ���� VARCHAR2(15)�� �϶�.
ALTER TABLE EMP_DEPTNO
MODIFY
ETC_COLUMN VARCHAR2(15);

-- ����4) EMP_DEPTNO ���̺� �ִ� ETC �� �����ϰ� Ȯ���϶�.
ALTER TABLE EMP_DEPTNO
DROP
COLUMN ETC_COLUMN;

-- ����5) ������ ������ EMP_DEPTNO ���̺��� �̸��� EMP_DEPT�� �����϶�.
ALTER TABLE EMP_DEPTNO
RENAME TO EMP_DEPT;

-- ����6) EMP_DEPT ���̺��� �����϶�.
DROP TABLE EMP_DEPT;

-- ����7) EMPLOYEES ���̺��� EMP ���̺��� �����ϰ� �����ϵ��� �϶�.(������ ����)
CREATE TABLE EMP
AS
SELECT * FROM EMPLOYEES;

-- ����8) EMP ���̺� row�� �߰��� ���ϴ�.
-- �ٸ�, �ݵ�� �����͸� ������ ���ص� �Ǹ�, NULL�� �����ϵ��� �Ѵ�.

INSERT INTO EMP
VALUES(207, 'JU', 'DASUL','WGIETZ', '515.123.456','02/06/08','AC_ACCOUNT',8300, NULL, 205, NULL);

-- ����9) EMPLOYEES ���̺��� EMPNO,ENAME,SAL,HIREDATE�� COLUMN�� �����Ͽ� 
-- EMP_10 ���̺��� ����(������ ������)�� �� 10�� �μ��� �����Ͽ�
-- �̿� �����ϴ� ���� EMP_10���̺� �Է��϶�.
CREATE TABLE EMP_10
AS
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE department_id = 10;

-- ����10) ������ ���Ἲ ���� ������ ����� �����̴�.
-- ������ �����ߴ��� �˾ƺ����� �սô�.

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