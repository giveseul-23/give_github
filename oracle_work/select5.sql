/*
    SUM, AVG, COUNT, MAX, MIN
*/

SELECT COUNT(salary), SUM(salary), AVG(salary)
FROM employees
WHERE job_id = 'IT_PROG'; -- 5명

/*
--일반컬럼과 그룹FUNCTION은 함께 사용할 수 없다.(오류발생)
SELECT employee_id, COUNT(salary), SUM(salary) 
FROM employees;
*/


/*
    GROUP BY, HAVING(else느낌, 그룹으로 묶인 다음에 조건)
*/

SELECT DISTINCT department_id
FROM employees;
--ORDER BY department_id ASC;

SELECT department_id
FROM employees -- WHERE절(필요없으면 생략가능)이 먼저 그다음 그룹바이절
GROUP BY department_id;
--ORDER BY department_id ASC;

SELECT job_id, employee_id -- 밑에서 그룹으로 묶었기때문에 일반컬럼과 사용할 수 없음
FROM employees
GROUP BY job_id;

--중복이 안되게끔 job_id로 묶임
SELECT job_id
FROM employees
GROUP BY job_id;


SELECT job_id, sum(salary), avg(salary) --그룹으로 묶었을때 일반컬럼과 맞게 나오면 사용가능
FROM employees
GROUP BY job_id
HAVING SUM(salary) >= 10000; -- 해빙은 조건절에서 사용함


/*
    NVL( 대상이 되는 컬럼, 값 ) NUMBER
    대상이 되는 컬럼 != NULL       --> 대상이 되는 컬럼
    대상이 되는 컬럼 == NULL       --> 지정값
*/

SELECT first_name, NVL(commission_pct, 0) -- NVL(NULL이 아니면 여기자리꺼 출력, NULL이면 여기자리꺼 출력)
FROM employees;

/*
    NVL2(대상이 되는 컬럼, 값1, 값2)
    대상이되는 컬럼 != NULL    ---> 값1
    대상이되는 컬럼 == NULL    ---> 값2
*/

SELECT first_name, NVL2(commission_pct, 1, 0)
FROM employees;

--문제
SELECT job_id, SUM(salary)
FROM employees
WHERE salary >= 5000
GROUP BY job_id
HAVING SUM(salary) >20000;



