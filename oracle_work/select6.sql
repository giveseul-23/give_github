/*
    Join
    �ΰ� �̻��� ���̺��� �����ؼ� �����͸� �˻��ϴ� ���
    ���� �ΰ��̻��� ��(row)���� ����� �� Primary key(�⺻Ű), Foreign Key(�ܷ�Ű) ����
    ����ؼ� �����Ѵ�.
    
    Primary key(�⺻Ű) : ���̺��� �ߺ����� ���� Ű
    Foreign Key(�ܷ�Ű) : �ٸ� ���̺� �ִ� Ű 
    
    ����
    Ansi  SQL
    Oracle 
    
    inner Join(�⺻����)  : ***** 
    full outer Join     
    cross Join
    outer Join
        left            : ***
        right           : ***
    self Join           : *****     : ���� ���̺� ���� ���
    
    
*/

--���� �츮 ���̺� ���� ������ ���� ���̺��� ������ ���� ���ؼ� join�� �����
-- inner Join
-- Ansi  SQL
SELECT employee_id, first_name, 
    e.department_id, d.department_id, d.department_name --�ΰ��� �Ҽ��ϰ�� ���Ҽ����� ������ ��
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id; -- ���� department_id ���� ���� 

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, 
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;


-- ����
-- full outer Join ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- oracle cross Join
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

-- OUTER Join
-- left, right 
--Ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d -- left�� �ִ� employees e
    ON e.department_id = d.department_id;
--Oracle
--left
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+) --(+)�ִ� �ʿ��� ���� ������ ��
    AND e.department_id IS NULL; -- �ش� ������ �ٿ��ָ� ������(������ kimberely�� ���´�)
--right
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

-- self Join : ������ ���̺� join 
SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    B.first_name
FROM employees A, employees B -- A : ���, B : ��� 
WHERE a.manager_id = b.employee_id;

--������ ���� ����, ����
SELECT a.employee_id, a.first_name,
    a.manager_id AS "����� ���", b.employee_id,
    b.first_name AS "���"
FROM employees a, employees b -- A : ���, B : ���
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; --�����
CONNECT BY a.manager_id = PRIOR a.employee_id; --�����

-- 
SELECT e.first_name, d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
    AND e.job_id = j.job_id
    AND e.first_name = 'Lex';
    
SELECT emp.first_name as "������", manager.first_name as "����"
FROM employees emp, employees manager
WHERE emp.manager_id = manager.employee_id

