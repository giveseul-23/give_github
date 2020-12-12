/*
    SUM, AVG, COUNT, MAX, MIN
*/

SELECT COUNT(salary), SUM(salary), AVG(salary)
FROM employees
WHERE job_id = 'IT_PROG'; -- 5��

/*
--�Ϲ��÷��� �׷�FUNCTION�� �Բ� ����� �� ����.(�����߻�)
SELECT employee_id, COUNT(salary), SUM(salary) 
FROM employees;
*/


/*
    GROUP BY, HAVING(else����, �׷����� ���� ������ ����)
*/

SELECT DISTINCT department_id
FROM employees;
--ORDER BY department_id ASC;

SELECT department_id
FROM employees -- WHERE��(�ʿ������ ��������)�� ���� �״��� �׷������
GROUP BY department_id;
--ORDER BY department_id ASC;

SELECT job_id, employee_id -- �ؿ��� �׷����� �����⶧���� �Ϲ��÷��� ����� �� ����
FROM employees
GROUP BY job_id;

--�ߺ��� �ȵǰԲ� job_id�� ����
SELECT job_id
FROM employees
GROUP BY job_id;


SELECT job_id, sum(salary), avg(salary) --�׷����� �������� �Ϲ��÷��� �°� ������ ��밡��
FROM employees
GROUP BY job_id
HAVING SUM(salary) >= 10000; -- �غ��� ���������� �����


/*
    NVL( ����� �Ǵ� �÷�, �� ) NUMBER
    ����� �Ǵ� �÷� != NULL       --> ����� �Ǵ� �÷�
    ����� �Ǵ� �÷� == NULL       --> ������
*/

SELECT first_name, NVL(commission_pct, 0) -- NVL(NULL�� �ƴϸ� �����ڸ��� ���, NULL�̸� �����ڸ��� ���)
FROM employees;

/*
    NVL2(����� �Ǵ� �÷�, ��1, ��2)
    ����̵Ǵ� �÷� != NULL    ---> ��1
    ����̵Ǵ� �÷� == NULL    ---> ��2
*/

SELECT first_name, NVL2(commission_pct, 1, 0)
FROM employees;

--����
SELECT job_id, SUM(salary)
FROM employees
WHERE salary >= 5000
GROUP BY job_id
HAVING SUM(salary) >20000;



