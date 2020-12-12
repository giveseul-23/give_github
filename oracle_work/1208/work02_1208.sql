-- ����1) EMPLOYEES ���̺��� King�� ������ �ҹ��ڷ� �˻��ϰ� �����ȣ,
-- ����, ������(�ҹ��ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_id, first_name, lower(job_id), department_id
FROM employees
WHERE LOWER(last_name) LIKE LOWER('king');

-- ����2) EMPLOYEES ���̺��� King�� ������ �빮�ڷ� �˻��ϰ� �����ȣ,
-- ����, ������(�빮�ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_id, first_name, UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) LIKE UPPER('king');

-- ����3) DEPARTMENTS ���̺��� �μ���ȣ�� �μ��̸�, �μ��̸��� ��ġ��ȣ�� ���Ͽ� ����ϵ��� �϶�.
SELECT department_id || ' ' ||department_name, department_name || ' ' || location_id
-- ������ ���� : CONCAT(department_id, department_name), AT(department_name, location_id)
FROM departments;

--����4) EMPLOYEES ���̺��� �̸��� ù ���ڰ� ��K�� ���� ũ�� ��Y������ ����
-- ����� ������ �����ȣ, �̸�, ����, �޿�, �μ���ȣ�� ����϶�.
-- �� �̸������� �����Ͽ���. **
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(last_name, 1, 1) > 'K' AND SUBSTR(last_name, 1, 1) < 'Y'
ORDER BY last_name;


--����5) EMPLOYEES ���̺��� 20�� �μ� �� �̸��� ���� �� �޿��� �ڸ����� 
--�����ȣ, �̸�, �̸��� �ڸ���, �޿�, �޿��� �ڸ����� ����϶�.
SELECT employee_id, last_name, LENGTH(LAST_NAME), salary, LENGTH(salary)
FROM employees
WHERE department_id = 20;

-- ����6) EMPLOYEES ���̺��� �̸� �� ��e������ ��ġ�� ����϶�.
SELECT INSTRB(last_name,'e') as "e location"
FROM employees;

-- ����7) ������ ������ �����ϰ� ����� �м��϶�. ****
SELECT ROUND(4567.678),ROUND(4567.678,0), -- 4568, 4568
ROUND(4567.678,2),ROUND(4567.678,-2) -- 4567.68, 4600
FROM dual;

-- ����8) EMPLOYEES ���̺��� �μ���ȣ�� 80�� ����� �޿��� 30���� ����
--�������� ���Ͽ� ����϶�.
SELECT MOD(salary, 30)
FROM employees
WHERE department_id = 80; 

-- ����9) EMPLOYEES ���̺��� 30�� �μ� �� �̸��� ��� ������ �����Ͽ�����Ͽ���. �� ��� ������ �� �� �Ʒ��� ����϶�.
-- ���̱⿣ ����ó�� �������� �׸��带 ���� Ŭ���ϸ� ���� �Ǿ��ٴ� ���� Ȯ���� �� �ֽ��ϴ�.
SELECT last_name || CHR(10) || job_id
FROM employees
WHERE department_id = 30;

-- ����10) EMPLOYEES ���̺��� ������� �ٹ��� ���� ���� ���� �ΰ��� ����Ͽ���. �� �ٹ� �ϼ��� ���� ��� ������ ����Ͽ���.
SELECT last_name, TRUNC((SYSDATE - hire_date)/7,0) ��, ROUND(MOD((SYSDATE - hire_date),7),0) ��
FROM employees
ORDER BY SYSDATE - hire_date DESC;


-- ����11) EMPLOYEES ���̺��� �μ� 50���� �޿� �տ� $�� �����ϰ� 3�ڸ����� ,�� ����϶�
SELECT to_char(salary,'$999,999,999')
FROM employees
WHERE department_id = 50;
