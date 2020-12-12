/*
    순위함수
    RANK()
    DENSE_RANK()
    ROW_NUMBER()
    ROWNUM
    
*/

SELECT employee_id, first_name
FROM employees
WHERE employee_id >= 100 AND employee_id <= 109 ;

--* OVER는 그룹함수와 항상 같이 사용함

/*
사용불가능
SELECT department_id, COUNT(*)
FROM employees
사용가능
SELECT department_id, COUNT(*)OVER()
FROM employees
*/

SELECT department_name, COUNT(*)OVER(PARTITION BY department_id)
FROM departments;

SELECT department_name, COUNT(*)
FROM departments
GROUP BY department_name;

-- OVER() 
-- SELECT 절에서만 사용함
-- GROUP BY를 보강하기 위해서 나온 함수
SELECT first_name,
                --조건 : 월급 순대로 RANK시킴
    RANK()OVER( ORDER BY salary DESC ) AS RANK,
    DENSE_RANK()OVER( ORDER BY salary DESC ) AS D_RANK,
    ROW_NUMBER()OVER( ORDER BY salary DESC ) AS R_RANK
FROM employees;

-- ROWNUM
SELECT ROWNUM, employee_id, first_name--2
FROM employees
WHERE ROWNUM BETWEEN 1 AND 5; -- WHERE 절이 가장 먼저 실행됨 1

--************매우중요
--1. 순위 설정
--2. 번호 할당
--3. 범위 설정
SELECT RNUM, employee_id, first_name, salary
FROM (SELECT ROWNUM AS RNUM, employee_id, first_name, salary -- 2. 번호할당
        FROM (SELECT employee_id, first_name, salary -- 1. 순위설정
                FROM employees
                ORDER BY salary DESC)
        )
WHERE RNUM BETWEEN 11 AND 20; -- 여기서 만약 ALIAS 별칭이 아니라 그냥 ROWNUM을 사용하게 되면 FROM에서의 ROWNUM이 아니라 밖의 ROWNUM을 사용하게 됨