/*
    SUB Query
    Query �ȿ� Query
    
    SELECT  ���� ROW(�� �ٸ� ����), ���� COLUMN
    FROM    ���� ROW , ���� COLUMN
    WHERE   ���� ROW , ���� COLUMN
    
*/

--SEPECT 
SELECT employee_id, first_name , (SELECT first_name
                                    FROM employees 
                                    WHERE employee_id = 100)
FROM employees;

/*���� �Ұ����� ���*/
-- COLUMN 1, ROW 5 �ΰ��
SELECT employee_id, first_name , (SELECT first_name
                                    FROM employees 
                                    WHERE job_id = 'IT_PROG') 
FROM employees;
-- FROM���� ������ ���డ������
SELECT employee_id, first_name
FROM (SELECT first_name, employee_id
                                    FROM employees 
                                    WHERE job_id = 'IT_PROG') ;

-- COLUMN2 ROW1
-- ����Ұ���
SELECT employee_id, first_name , (SELECT first_name, last_name
                                    FROM employees 
                                    WHERE employee_id = 100)
FROM employees;
-- ���డ��
SELECT employee_id, first_name , (SELECT first_name
                                    FROM employees 
                                    WHERE employee_id = 100),
                                    (SELECT  last_name
                                    FROM employees
                                    WHERE employee_id = 100)
FROM employees;

-- COLUMN1 ROW1
SELECT employee_id, first_name , (SELECT COUNT(*) FROM employees)
FROM employees;

-- FROM �� �ȿ��� ��������
-- �и����� �ۼ�
SELECT empno, first_name, salary -- �� �޾Ƶ� ��, �ȹ޾Ƶ� ��
FROM (SELECT employee_id as empno, first_name, salary FROM employees
        WHERE job_id = 'IT_PROG') -- �Ѱ��� ������ �޴°� �״�ΰ� �Ѱ��ִ°� �ϳ� ���ٸ� �����߻�
WHERE salary > 5000;

--�μ���ȣ 50��, �޿��� 6000 �̻��� ���
--��������x
SELECT *
FROM employees
WHERE department_id = 50 AND salary >= 6000;

--��������o
SELECT *
FROM (SELECT *
    FROM employees
    WHERE department_id = 50)
WHERE salary >= 6000;

-- ��������, �޿��� �հ�, �ο���, �����, ����
SELECT e.first_name, e.salary, e.job_id, j.job_id,
        j.salsum as "�޿��հ�", j."�հ�" as "�հ�"
FROM employees e, (SELECT job_id, SUM(salary) AS salsum, COUNT(*) AS "�հ�"
                    FROM employees
                    GROUP BY job_id) j -- job_id�� �����, �޿��Ѿ��� alias j�� ��
WHERE e.job_id = j.job_id;

-- WHERE
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- department id = 90�� job_id ����
SELECT job_id
FROM employees
WHERE department_id = 90;

SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN (SELECT job_id
                FROM employees
                WHERE department_id = 90);
                
--�μ����� ���� ������ ���� �޴� ����� ���� ������ �޴� ���
SELECT first_name, salary, department_id
FROM employees 
WHERE salary IN(SELECT MIN(salary) 
                FROM employees
                GROUP BY department_id); -- IN(��������) �������ǰ� ���� ���޹޴�

-- �μ����� ���� ������ ���� �޴� ������ ����
/*  ����
SELECT department_id, MIN(salary), first_name
FROM employees
GROUP BY department_id;
*/
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary)IN(SELECT department_id, MIN(salary)
                                FROM employees
                                GROUP BY department_id)

