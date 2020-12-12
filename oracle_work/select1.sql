-- DML
-- insert delete select(90%) update
/*
    Query
            Dao                 <- Database(Container)
                list  <-  file
                save  ->  file
            Dto
            
            SELECT 
                (값, COLUMN, 함수, SUB QUERY)
            FROM 
                (TABLE명, SUB QYERY)
            
*/

SELECT 1 FROM DUAL;

SELECT *
FROM employees;

SELECT employee_id, first_name, salary --원하는 항목을 적으면 원하는 것의 데이터만 나옴
FROM employees;

-- ALIAS
SELECT employee_id AS 사원번호, first_name as "이름", salary "월급"-- 항목명을 변경시킴, AS 사원 번호< 빈칸을 두면 안됨, 빈칸을 두고싶으면 ""안에 무조건 넣어야 됨
FROM employees;

-- ||
SELECT employee_id || first_name ||  salary
FROM employees;

SELECT first_name, last_name, salary, salary *12 as "연봉"
FROM employees;















