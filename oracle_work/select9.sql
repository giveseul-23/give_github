/*
    �����Լ�
    RANK()
    DENSE_RANK()
    ROW_NUMBER()
    ROWNUM
    
*/

SELECT employee_id, first_name
FROM employees
WHERE employee_id >= 100 AND employee_id <= 109 ;

--* OVER�� �׷��Լ��� �׻� ���� �����

/*
���Ұ���
SELECT department_id, COUNT(*)
FROM employees
��밡��
SELECT department_id, COUNT(*)OVER()
FROM employees
*/

SELECT department_name, COUNT(*)OVER(PARTITION BY department_id)
FROM departments;

SELECT department_name, COUNT(*)
FROM departments
GROUP BY department_name;

-- OVER() 
-- SELECT �������� �����
-- GROUP BY�� �����ϱ� ���ؼ� ���� �Լ�
SELECT first_name,
                --���� : ���� ����� RANK��Ŵ
    RANK()OVER( ORDER BY salary DESC ) AS RANK,
    DENSE_RANK()OVER( ORDER BY salary DESC ) AS D_RANK,
    ROW_NUMBER()OVER( ORDER BY salary DESC ) AS R_RANK
FROM employees;

-- ROWNUM
SELECT ROWNUM, employee_id, first_name--2
FROM employees
WHERE ROWNUM BETWEEN 1 AND 5; -- WHERE ���� ���� ���� ����� 1

--************�ſ��߿�
--1. ���� ����
--2. ��ȣ �Ҵ�
--3. ���� ����
SELECT RNUM, employee_id, first_name, salary
FROM (SELECT ROWNUM AS RNUM, employee_id, first_name, salary -- 2. ��ȣ�Ҵ�
        FROM (SELECT employee_id, first_name, salary -- 1. ��������
                FROM employees
                ORDER BY salary DESC)
        )
WHERE RNUM BETWEEN 11 AND 20; -- ���⼭ ���� ALIAS ��Ī�� �ƴ϶� �׳� ROWNUM�� ����ϰ� �Ǹ� FROM������ ROWNUM�� �ƴ϶� ���� ROWNUM�� ����ϰ� ��