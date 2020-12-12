--문제1) EMPLOYEES 테이블에서 업무로 모든 SA에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
GROUP BY job_id
HAVING job_id LIKE 'SA%';

--문제2) EMPLOYEES
--테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT department_id, COUNT(*), AVG(salary), MIN(salary), MAX(salary), SUM(salary)
FROM employees
GROUP BY department_id;

--문제3) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라.
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

--문제4) EMPLOYEES 테이블에서 급여가 "최대 10000이상인 부서"에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT department_id, AVG(salary), SUM(salary)
FROM employees
GROUP BY department_id 
HAVING MAX(salary) >= 10000;

--문제5) EMPLOYEES 테이블에서 "전체 월급이 10000을 초과하는 각 업무"에 대해서 업무와 월급여 합계를 출력하라. 
--단 판매원(SA)은 제외하고 월 급여 합계로 정렬(내림차순)하라.
SELECT DISTINCT job_id, SUM(salary)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING SUM(salary) > 10000
ORDER BY SUM(salary) DESC;