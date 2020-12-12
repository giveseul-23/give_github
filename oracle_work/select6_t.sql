/*
    Join
    �ΰ� �̻��� ���̺��� �����ؼ� �����͸� �˻��ϴ� ���.
    ���� �ΰ��̻��� ��(row)���� ����� �� Primary Key(�⺻Ű), Foreign Key(�ܷ�Ű)����
    ����ؼ� �����Ѵ�.

    Primary Key(�⺻Ű) : ���̺��� �ߺ����� �ʴ� Ű
    Foreign Key(�ܷ�Ű) : �ٸ� ���̺� �ִ� Ű
    
    Ansi SQL
    Oracle
    
    inner Join  : *****
    full outer Join
    cross Join
    outer
        left    : ***
        right   : ***
    self Join     *****
*/

-- inner Join
-- Ansi SQL
SELECT employee_id, first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- full outer Join
-- ansi
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

-- Outer Join
-- left, right
-- Ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND e.department_id IS NULL;
--                   <---                

-- self Join : ������ ���̺� Join
SELECT A.employee_id, A.first_name,
    A.manager_id, B.employee_id,
    B.first_name
FROM employees A, employees B   -- A : ���  B : ���
WHERE A.manager_id = B.employee_id;

-- ������ ���� ����, ����
SELECT a.employee_id, a.first_name,
    a.manager_id as "����� ���", b.employee_id,
    b.first_name as "���"
FROM employees a, employees b   -- A : ���  B : ���
WHERE a.manager_id = b.employee_id(+)
-- CONNECT BY PRIOR a.manager_id = a.employee_id;  -- �����
CONNECT BY a.manager_id = PRIOR a.employee_id;  -- �����

























