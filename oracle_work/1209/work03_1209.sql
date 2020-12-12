--문제1) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian Product
--(모든 가능한 행들의 Join == CROSS JOIN)하여 사원번호,이름,업무,부서번호,부서명, 근무지를 출력하여라.
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;

-- 문제2) EMPLOYEES 테이블에서 사원번호,이름,업무, EMPLOYEES 테이블의
-- 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라.
SELECT e.employee_id, e.last_name, e.job_id, 
    d.department_id, d.department_name, d.location_id
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
    
-- 문제3) Alexander Hunold 의 부서명을 출력하라.
SELECT d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.first_name = 'Alexander' AND e.last_name = 'Hunold';

-- 문제4) 세일즈 부서에서 근무하고 있는 사람들을 출력하라.
SELECT e.first_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE d.department_name = 'Sales';

--문제5) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고
--SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라.
--(Alias를 사용)
SELECT e.employee_id AS 사원번호, e.last_name AS 이름, e.salary AS 급여, d.department_name AS 부서명, d.location_id AS 근무지
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.job_id = 'SA_MAN';

--문제6) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서 DEPARTMENTS 테이블에 있는 모든 자료를 
--사원번호,이름,업무, EMPLOYEES 테이블의 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라(Outer Join)
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

--문제7) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라.
SELECT a.first_name|| '의 상사는 '|| b.first_name
FROM employees A, employees B
WHERE a.manager_id = B.employee_id;

--CONCAT, MySQL
SELECT CONCAT(CONCAT(a.first_name, '의 상사는 '), CONCAT(b.first_name, '입니다.'))
FROM employees A, employees B
WHERE a.manager_id = B.employee_id;

-- 문제8) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고
-- 매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 급여는 역순으로
-- 출력하라.
SELECT a.employee_id, a.first_name, a.salary,  a.manager_id, b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id = b.employee_id(+)
    AND a.manager_id IS NOT NULL
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

-- 문제9) EMPLOYEES 테이블에서 right join하여 관리자(매니저)가 108번 상향식으로 급여는 역순으로 출력하라.
SELECT a.employee_id, a.first_name, a.salary,  a.manager_id, b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = '108'
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;


