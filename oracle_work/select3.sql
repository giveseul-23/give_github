/*
    SELECT COLUMN, ALIAS, FUNTION, SUBQUERY
    FROM TABLE, SUBQUERY
    
    WHERE
    
    ǥ����
    �񱳿�����(=, >, <, !=, >=, <=, <>)
    NULL, = NULL(Ʋ�� ����), IS NULL(�´¹���), IS NOT NULL
    (), NOT, AND(&&), OR(||)
*/

-- FIRST_NAME == Julia
SELECT first_name, last_name, salary FROM employees
WHERE first_name = 'Julia'; 

--������ $9000�̻��� ���
SELECT first_name, salary FROM employees
WHERE salary >= 9000;

--�̸��� Shanta ���� ū �̸�
SELECT first_name FROM employees
WHERE first_name > 'Shanta'; -- s ������ �̸��� ������ ����

SELECT first_name FROM employees 
WHERE first_name >= 'a'; -- �˻����� ���� ���� �����ʹ� �̸��� ���� �빮�ڷ� ���۵�

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NOT NULL; -- null x  |  String str = new String() != String str = null
-- NULL���� ������ ��� ������� ��µ�

-- AND '��Ÿ'�̰� '��'�϶�
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    AND first_name = 'John'; 

-- OR '��Ÿ'�ų� '��'�϶�
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta'
    OR first_name = 'John'; 
    
-- �̸� John, ������ 5000 �̻��϶�
SELECT first_name,  salary
FROM employees
WHERE first_name = 'John' 
    AND salary >= 5000;
    
-- 2007�� 12�� 31�� ���Ŀ� �Ի��� ����� ����
SELECT first_name, hire_date
FROM employees
-- ���1 WHERE hire_date > '07/12/31'
WHERE hire_date > TO_DATE('071231','YYMMDD'); --���2

-- ALL(AND), ANY(OR)
/*
���ϱ���
WHERE first_name = 'Shanta'
    AND first_name = 'John'; 
*/
SELECT first_name FROM employees
WHERE first_name = ALL('Julia', 'John'); 

SELECT first_name FROM employees
WHERE first_name = ANY('Julia', 'John'); 

-- IN, NOT IN
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200, 6000);

SELECT first_name, salary
FROM employees
-- �� �޿��� �޴� ��� ������ ������ ��� ��µ�
WHERE salary NOT IN(8000, 3200, 6000); 

SELECT first_name, salary
FROM employees
WHERE first_name IN('Julia', 'John');

--BETWEEN ���� ������
/*
    ������ ����
    SALARY >= 3200 AND SALARY <= 9000
    SALARY BETWEEN AND 9000
*/

-- 3200>= SALARY <= 9000
SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 3200 AND 9000;

-- 3200< SALARY > 9000
SELECT first_name, salary
FROM employees
WHERE salary NOT BETWEEN 3200 AND 9000;

-- LIKE *****(�ſ��߿�)
SELECT first_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _ : �� ����

SELECT first_name
FROM employees
WHERE first_name LIKE 'Al%'; --�տ������� �����ؼ� Al�� �����ϴ� ��� �̸�

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%'; -- Al�� �����ϴ� ��� �̸�(�ڸ���� x)

SELECT first_name
FROM employees
WHERE first_name LIKE 'K%y'; --ù���� K, ������ ���� y 

--2006�⵵�� �Ի��� ���
SELECT first_name, hire_date
FROM employees
WHERE hire_date >= '06/01/01' AND hire_date < '07/01/01' ;

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%'; 