--����1) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� Cartesian Product
--(��� ������ ����� Join == CROSS JOIN)�Ͽ� �����ȣ,�̸�,����,�μ���ȣ,�μ���, �ٹ����� ����Ͽ���.
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;

-- ����2) EMPLOYEES ���̺��� �����ȣ,�̸�,����, EMPLOYEES ���̺���
-- �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT e.employee_id, e.last_name, e.job_id, 
    d.department_id, d.department_name, d.location_id
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
    
-- ����3) Alexander Hunold �� �μ����� ����϶�.
SELECT d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.first_name = 'Alexander' AND e.last_name = 'Hunold';

-- ����4) ������ �μ����� �ٹ��ϰ� �ִ� ������� ����϶�.
SELECT e.first_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE d.department_name = 'Sales';

--����5) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� �μ���ȣ�� �����ϰ�
--SA_MAN ������� �����ȣ,�̸�,�޿�,�μ���,�ٹ����� ����϶�.
--(Alias�� ���)
SELECT e.employee_id AS �����ȣ, e.last_name AS �̸�, e.salary AS �޿�, d.department_name AS �μ���, d.location_id AS �ٹ���
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.job_id = 'SA_MAN';

--����6) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� DEPARTMENTS ���̺� �ִ� ��� �ڷḦ 
--�����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���(Outer Join)
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

--����7) EMPLOYEES ���̺��� Self join�Ͽ� ������(�Ŵ���)�� ����Ͽ���.
SELECT a.first_name|| '�� ���� '|| b.first_name
FROM employees A, employees B
WHERE a.manager_id = B.employee_id;

--CONCAT, MySQL
SELECT CONCAT(CONCAT(a.first_name, '�� ���� '), CONCAT(b.first_name, '�Դϴ�.'))
FROM employees A, employees B
WHERE a.manager_id = B.employee_id;

-- ����8) EMPLOYEES ���̺��� left join�Ͽ� ������(�Ŵ���)�� ����ϰ�
-- �Ŵ��� ���̵� ���� ����� �����ϰ� ��������� �ϸ�, �޿��� ��������
-- ����϶�.
SELECT a.employee_id, a.first_name, a.salary,  a.manager_id, b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id = b.employee_id(+)
    AND a.manager_id IS NOT NULL
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

-- ����9) EMPLOYEES ���̺��� right join�Ͽ� ������(�Ŵ���)�� 108�� ��������� �޿��� �������� ����϶�.
SELECT a.employee_id, a.first_name, a.salary,  a.manager_id, b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = '108'
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;


