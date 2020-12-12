/*
    Table 
        ����(row), ����(column)
        create  ���� 
        drop    ����
        alter   ����
        
        * �˻��ϴ� ���� ���̺� �ҷ����� �˻��� �� ����
        
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
); -- ����


DROP TABLE TB_TEST01; --����

CREATE TABLE TB_TEST02(
    COL1 VARCHAR2(10),
    COL2 NUMBER(5, 1),
    COL3 DATE
); 

-- TABLE COPY : ������ ����
CREATE TABLE TB_TEST03
AS --���̺��� ������ �� ���� ��ɾ�
SELECT * FROM employees;

SELECT
    *
FROM tb_test03;

DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03(empno, ename, sal) -- (���� ������ ���ϴ� ��Ī���� ���� �� ����)
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

-- TABLE COPY : ������ ������
CREATE TABLE TB_TEST04
AS
SELECT
    *
FROM departments
WHERE 1 = 2; -- �翬�� �����Ǵ� ������ �θ� ���븸 �������� �����ʹ� �������� �ʴ´�.

SELECT
    *
FROM TB_TEST04;

CREATE TABLE DEPT_EMP(empno, sal, dname, loc)
AS
SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ���̺� ����

-- ���̺�� ����
ALTER TABLE TB_TEST04
RENAME TO TB_TEST99;

-- �÷� �߰�
--���� �÷��߰�
ALTER TABLE TB_TEST99
ADD
NEWCOL VARCHAR2 (20); -- �ڷ����� ���ϴ´�� ���氡�� 
--���� �÷��߰�
ALTER TABLE TB_TEST99
ADD
(COLNEW1 NUMBER, COLNEW2 DATE); -- �ش�ó�� NUMBER, DATE �ڷ����� ��밡���ϴ�

--�����÷� ����
ALTER TABLE TB_TEST99
MODIFY
NEWCOL VARCHAR2(30);

-- ���� �÷� ����
ALTER TABLE TB_TEST99
MODIFY
(COLNEW1 VARCHAR2(20), COLNEW2 VARCHAR2(30));

--�÷�����
--�����÷�����
ALTER TABLE TB_TEST99
DROP
COLUMN NEWCOL;
--�����÷�����
ALTER TABLE TB_TEST99
DROP
(COLNEW1, COLNEW2);

--�÷��� ����
ALTER TABLE TB_TEST99
RENAME
COLUMN
-- �����̸� TO �ٲ��̸�
DEPARTMENT_ID TO DEPTNO;

DROP TABLE TB_TEST99;

-- ���������
PURGE RECYCLEBIN;

--INSERT
INSERT INTO TB_TEST04(department_id, department_name, manager_id, location_id)
VALUES(100, '��ȹ��', 20, 200);

SELECT
    *
FROM TB_TEST04;

INSERT INTO TB_TEST04(department_id, department_name)
VALUES(100, '��ȹ��');

INSERT INTO TB_TEST04
VALUES(100, '������', 30, 400);

INSERT INTO TB_TEST04( manager_id, location_id, department_id, department_name)
VALUES(50, 500, 102, '������');

--DELETE
DELETE FROM tb_test04
WHERE manager_id = 20;

DELETE FROM tb_test04
WHERE manager_id IS NULL;

--UPDATE
UPDATE tb_test04
SET manager_id = 40
WHERE department_name = '������';

UPDATE tb_test04
SET manager_id = 10, location_id = 100, department_id = 1000 -- �������� ��������
WHERE department_name = '������';

UPDATE tb_test04
SET manager_id = 10, location_id = 100 -- �ϳ��� �������� �����൵ ���氡��
WHERE department_id > 100;