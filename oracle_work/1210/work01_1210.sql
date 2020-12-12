-- ����1) EMPLOYEES ���̺��� Kochhar�� �޿����� ���� ����� ������ �����ȣ,�̸�,������,�޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE last_name = 'Kochhar');
                
-- ����2) EMPLOYEES ���̺��� �޿��� ��պ��� ���� ����� ������ �����ȣ, �̸�,������,�޿�,�μ���ȣ�� ����Ͽ���.
SELECT employee_id, last_name, job_id, department_id, salary
FROM employees
WHERE salary < (SELECT AVG(salary) FROM employees);

-- ����3) EMPLOYEES ���̺��� (100�� �μ��� �ּ� �޿�)���� (�ּ� �޿��� ����) (�ٸ� ��� �μ�)�� ����϶� *****
SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary) FROM employees WHERE department_id = 100);

-- ����4) (�������� �ּ� �޿��� �޴�) ����� ������ �����ȣ,�̸�,����,�μ���ȣ�� ����Ͽ���. 
-- �� �������� �����Ͽ���. *****
SELECT employee_id, last_name, job_id, department_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT  job_id, MIN(salary) FROM employees GROUP BY job_id) 
-- �ߺ��Ǵ� ���� �����ϱ� ���� �տ���  job_id�� �޾���
-- ��µǴ� ������ �ߺ��Ǵ� ���� �ش� �������� �Ȱ��� �޿��� �ް� �ֱ� ����
ORDER BY job_id;

-- ����5) EMPLOYEES �� (DEPARTMENTS ���̺��� ������ ���ϵ�� ���)�� ������ �̸�,����,�μ���,�ٹ����� ����϶�.
SELECT e.last_name, e.job_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id AND e.job_id = 'SA_MAN';

--FROM�� *****
SELECT e.first_name, e.job_id, d.department_name, d.location_id
FROM (SELECT first_name, job_id, department_id
        FROM employees
        WHERE job_id = 'SA_MAN') e, departments d
WHERE e.department_id = d.department_id;

-- ����6) EMPLOYEES ���̺��� ���� ���� ����� ���� MANAGER�� �����ȣ�� ����϶�. *****
SELECT MANAGER_ID
FROM EMPLOYEES
GROUP BY MANAGER_ID
HAVING COUNT(MANAGER_ID) = (SELECT MAX(COUNT(*)) FROM EMPLOYEES GROUP BY MANAGER_ID);

-- ����7) EMPLOYEES ���̺��� ���� ���� ����� �����ִ�
-- �μ���ȣ�� ������� ����϶�. *****
SELECt department_id, COUNT(department_id)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(department_id)) FROM employees GROUP BY department_id);

-- ����8) EMPLOYEES ���̺��� �����ȣ�� 123�� ����� ������ ���� 
-- �����ȣ�� 192�� ����� �޿�(SAL)���� ���� ����� �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id FROM employees WHERE employee_id = '123') 
    AND salary > (SELECT salary FROM employees WHERE employee_id = '192');

-- ����9) ����(JOB)���� �ּ� �޿��� �޴� ����� ������ 
-- �����ȣ, �̸�, ����, �μ����� ����϶�.
-- ����1 : �������� �������� ����
SELECT e.employee_id, e.last_name, job_id, d.department_name, e.salary
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE (e.job_id, e.salary) IN (SELECT JOB_ID, MIN(salary) FROM employees GROUP BY job_id)
ORDER BY e.job_id DESC;

-- ����10) EMPLOYEES ���̺��� �������� �ּ� �޿��� �޴� ����� ������ 
-- �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�
SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE salary IN (SELECT MIN(salary) FROM employees GROUP BY job_id);

-- ����11) EMPLOYEES ���̺��� 50�� �μ��� �ּ� �޿��� �޴� 
-- ��� ���� ���� �޿��� �޴� ����� ������ 
-- �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. 
-- �� 50���� ����
SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE salary > (SELECT MIN(salary) FROM employees WHERE department_id = '50') 
    AND department_id NOT IN('50');
    
-- ����12) EMPLOYEES ���̺��� 50�� �μ��� �ְ� �޿��� �޴� ��� ���� ���� �޿��� �޴� ����� ������ 
-- �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. 
-- ��50���� ����
SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE salary > (SELECT MAX(salary) FROM employees WHERE department_id = '50')
    AND department_id NOT IN('50');