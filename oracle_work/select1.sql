-- DML
-- insert delete select(90%) update
/*
    Query
            Dao                 <- Database(Container)
                list  <-  file
                save  ->  file
            Dto
            
            SELECT 
                (��, COLUMN, �Լ�, SUB QUERY)
            FROM 
                (TABLE��, SUB QYERY)
            
*/

SELECT 1 FROM DUAL;

SELECT *
FROM employees;

SELECT employee_id, first_name, salary --���ϴ� �׸��� ������ ���ϴ� ���� �����͸� ����
FROM employees;

-- ALIAS
SELECT employee_id AS �����ȣ, first_name as "�̸�", salary "����"-- �׸���� �����Ŵ, AS ��� ��ȣ< ��ĭ�� �θ� �ȵ�, ��ĭ�� �ΰ������ ""�ȿ� ������ �־�� ��
FROM employees;

-- ||
SELECT employee_id || first_name ||  salary
FROM employees;

SELECT first_name, last_name, salary, salary *12 as "����"
FROM employees;















