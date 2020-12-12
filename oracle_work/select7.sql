/*
    SUB Query
    Query 안에 Query
    
    SELECT  단일 ROW(한 줄만 가능), 단일 COLUMN
    FROM    다중 ROW , 다중 COLUMN
    WHERE   다중 ROW , 다중 COLUMN
    
*/

--SEPECT 
SELECT employee_id, first_name , (SELECT first_name
                                    FROM employees 
                                    WHERE employee_id = 100)
FROM employees;

/*실행 불가능한 경우*/
-- COLUMN 1, ROW 5 인경우
SELECT employee_id, first_name , (SELECT first_name
                                    FROM employees 
                                    WHERE job_id = 'IT_PROG') 
FROM employees;
-- FROM절에 넣으면 실행가능해짐
SELECT employee_id, first_name
FROM (SELECT first_name, employee_id
                                    FROM employees 
                                    WHERE job_id = 'IT_PROG') ;

-- COLUMN2 ROW1
-- 실행불가능
SELECT employee_id, first_name , (SELECT first_name, last_name
                                    FROM employees 
                                    WHERE employee_id = 100)
FROM employees;
-- 실행가능
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

-- FROM 절 안에서 서브쿼리
-- 분리시켜 작성
SELECT empno, first_name, salary -- 다 받아도 됨, 안받아도 됨
FROM (SELECT employee_id as empno, first_name, salary FROM employees
        WHERE job_id = 'IT_PROG') -- 넘겨줌 하지만 받는건 그대로고 넘겨주는게 하나 없다면 오류발생
WHERE salary > 5000;

--부서번호 50번, 급여가 6000 이상인 사원
--서브쿼리x
SELECT *
FROM employees
WHERE department_id = 50 AND salary >= 6000;

--서브쿼리o
SELECT *
FROM (SELECT *
    FROM employees
    WHERE department_id = 50)
WHERE salary >= 6000;

-- 좋은예제, 급여의 합계, 인원수, 사원명, 월급
SELECT e.first_name, e.salary, e.job_id, j.job_id,
        j.salsum as "급여합계", j."합계" as "합계"
FROM employees e, (SELECT job_id, SUM(salary) AS salsum, COUNT(*) AS "합계"
                    FROM employees
                    GROUP BY job_id) j -- job_id별 사원수, 급여총액을 alias j로 함
WHERE e.job_id = j.job_id;

-- WHERE
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- department id = 90의 job_id 산출
SELECT job_id
FROM employees
WHERE department_id = 90;

SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN (SELECT job_id
                FROM employees
                WHERE department_id = 90);
                
--부서별로 가장 월급을 적게 받는 사원과 같은 월급을 받는 사원
SELECT first_name, salary, department_id
FROM employees 
WHERE salary IN(SELECT MIN(salary) 
                FROM employees
                GROUP BY department_id); -- IN(월급조건) 월급조건과 같은 월급받는

-- 부서별로 가장 월급을 적게 받는 사원명과 월급
/*  오류
SELECT department_id, MIN(salary), first_name
FROM employees
GROUP BY department_id;
*/
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary)IN(SELECT department_id, MIN(salary)
                                FROM employees
                                GROUP BY department_id)

