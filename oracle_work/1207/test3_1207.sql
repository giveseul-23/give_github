-- ����1) EMPLOYEES ���̺��� �Ի����� ������ �����Ͽ� �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����϶�.
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
ORDER BY hire_date ASC; --�ƹ��͵� �������� �ڵ������� asc�� ��

--����2) EMPLOYEES ���̺��� ���� �ֱٿ� �Ի��� ������ �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����϶�.
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
ORDER BY hire_date DESC;

--����3) EMPLOYEES ���̺��� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ��� �޿��� ���� ������ �����Ͽ� �����ȣ, ����, ����, �μ���ȣ, �޿��� ����Ͽ���.

SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
ORDER BY department_id ASC, salary DESC;


-- ����4) EMPLOYEES ���̺��� ù��° ������ �μ���ȣ�� �ι�° ������ ������ ����° ������ �޿��� ���� ������ �����Ͽ� �����ȣ, ����, �Ի�����, �μ���ȣ, ����, �޿��� ����Ͽ���.
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
ORDER BY department_id ASC, job_id ASC, salary DESC;

    