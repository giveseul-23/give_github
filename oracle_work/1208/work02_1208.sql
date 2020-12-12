-- 문제1) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고 사원번호,
-- 성명, 담당업무(소문자로),부서번호를 출력하라.
SELECT employee_id, first_name, lower(job_id), department_id
FROM employees
WHERE LOWER(last_name) LIKE LOWER('king');

-- 문제2) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호,
-- 성명, 담당업무(대문자로),부서번호를 출력하라.
SELECT employee_id, first_name, UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) LIKE UPPER('king');

-- 문제3) DEPARTMENTS 테이블에서 부서번호와 부서이름, 부서이름과 위치번호를 합하여 출력하도록 하라.
SELECT department_id || ' ' ||department_name, department_name || ' ' || location_id
-- 동일한 구문 : CONCAT(department_id, department_name), AT(department_name, location_id)
FROM departments;

--문제4) EMPLOYEES 테이블에서 이름의 첫 글자가 ‘K’ 보다 크고 ‘Y’보다 적은
-- 사원의 정보를 사원번호, 이름, 업무, 급여, 부서번호를 출력하라.
-- 단 이름순으로 정렬하여라. **
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(last_name, 1, 1) > 'K' AND SUBSTR(last_name, 1, 1) < 'Y'
ORDER BY last_name;


--문제5) EMPLOYEES 테이블에서 20번 부서 중 이름의 길이 및 급여의 자릿수를 
--사원번호, 이름, 이름의 자릿수, 급여, 급여의 자릿수를 출력하라.
SELECT employee_id, last_name, LENGTH(LAST_NAME), salary, LENGTH(salary)
FROM employees
WHERE department_id = 20;

-- 문제6) EMPLOYEES 테이블에서 이름 중 ‘e’자의 위치를 출력하라.
SELECT INSTRB(last_name,'e') as "e location"
FROM employees;

-- 문제7) 다음의 쿼리를 실행하고 결과를 분석하라. ****
SELECT ROUND(4567.678),ROUND(4567.678,0), -- 4568, 4568
ROUND(4567.678,2),ROUND(4567.678,-2) -- 4567.68, 4600
FROM dual;

-- 문제8) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 30으로 나눈
--나머지를 구하여 출력하라.
SELECT MOD(salary, 30)
FROM employees
WHERE department_id = 80; 

-- 문제9) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당 업무를 연결하여출력하여라. 단 담당 업무를 한 줄 아래로 출력하라.
-- 보이기엔 한줄처럼 보이지만 그리드를 더블 클릭하면 개행 되었다는 것을 확인할 수 있습니다.
SELECT last_name || CHR(10) || job_id
FROM employees
WHERE department_id = 30;

-- 문제10) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출력하여라. 단 근무 일수가 많은 사람 순으로 출력하여라.
SELECT last_name, TRUNC((SYSDATE - hire_date)/7,0) 주, ROUND(MOD((SYSDATE - hire_date),7),0) 일
FROM employees
ORDER BY SYSDATE - hire_date DESC;


-- 문제11) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리마다 ,를 출력하라
SELECT to_char(salary,'$999,999,999')
FROM employees
WHERE department_id = 50;
