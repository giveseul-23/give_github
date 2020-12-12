-- ����1) EMPLOYEES ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ, �̸�, ������, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary 
FROM employees
WHERE salary >= 3000;

--����2) EMPLOYEES ���̺��� ��� ������ Manager�� ����� ������ �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶�. (Manager == ST_MAN)
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE job_id IN('ST_MAN');

-- ����3) EMPLOYEES ���̺��� �Ի����ڰ� 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
-- WHERE hire_date > '06/01/01';
WHERE hire_date > TO_DATE('060101','YYMMDD');

-- ����4) EMPLOYEES ���̺��� �޿��� 3000���� 5000������ ������ ����, ������, �޿�, �μ���ȣ�� ����϶�.(AND�� ���, BETWEEN�� �Բ� ���)
SELECT first_name, job_id, salary, department_id
FROM employees
WHERE salary BETWEEN 3000 AND 5000;

-- ����5) EMPLOYEES ���̺��� �����ȣ�� 145,152,203�� ����� ������ �����ȣ, ����, ������, �޿�, �Ի����ڸ� ����϶�(IN�� ���, OR�� ���)
SELECT employee_id, first_name, job_id, salary, hire_date
FROM employees
WHERE employee_id IN(145,152,203);

-- ����6) EMPLOYEES ���̺��� �Ի����ڰ� 05�⵵�� �Ի��� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�.(LIKE ���)
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date LIKE ('05%');

-- ����7) EMPLOYEES ���̺��� ���ʽ��� NULL�� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, ���ʽ�, �μ���ȣ�� ����϶�.(IS ���)
SELECT employee_id, first_name, job_id, salary, hire_date, commission_pct, department_id
FROM employees
WHERE commission_pct IS NULL;

-- ����8) EMPLOYEES ���̺��� �޿��� 1100�̻��̰� JOB�� Manager�� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶� (AND���, ST_MAN)
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 1100 AND job_id = 'ST_MAN';

-- ����9) EMPLOYEES ���̺��� �޿��� 10000�̻��̰ų� JOB�� Manager�� ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶� (OR���, ST_MAN)
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 10000 
        OR job_id = 'ST_MAN';
        
-- ����10) EMPLOYEES ���̺��� �޿��� JOB�� ST_MAN, SA_MAN, SA_REP�� �ƴ� ����� ������ �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶�(NOT IN ���)
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE job_id NOT IN('ST_MAN', 'SA_MAN', 'SA_REP');

-- ����11) ������ PRESIDENT�̰� �޿��� 12000�̻��̰ų� ������ SALESMAN�� ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' AND salary >= 12000 
        OR job_id = 'SA_MAN';
        
-- ����12) ������ PRESIDENT�Ǵ� SALESMAN�̰� �޿��� 12000�̻��̰ų� ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' OR job_id = 'SA_MAN'
    AND salary >= 12000;
    
    