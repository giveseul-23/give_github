/*
    Join
    두개 이상의 테이블을 연결해서 데이터를 검색하는 방법
    보통 두개이상의 행(row)들의 공통된 값 Primary key(기본키), Foreign Key(외래키) 값을
    사용해서 연결한다.
    
    Primary key(기본키) : 테이블에서 중복되지 않은 키
    Foreign Key(외래키) : 다른 테이블에 있는 키 
    
    문법
    Ansi  SQL
    Oracle 
    
    inner Join(기본조인)  : ***** 
    full outer Join     
    cross Join
    outer Join
        left            : ***
        right           : ***
    self Join           : *****     : 같은 테이블 정보 취득
    
    
*/

--현재 우리 테이블에 없는 내용을 상대방 테이블에서 가지고 오기 위해서 join을 사용함
-- inner Join
-- Ansi  SQL
SELECT employee_id, first_name, 
    e.department_id, d.department_id, d.department_name --두개다 소속일경우 어디소속인지 밝혀야 함
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id; -- 같은 department_id 값을 가진 

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, 
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;


-- 참고
-- full outer Join ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- oracle cross Join
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

-- OUTER Join
-- left, right 
--Ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d -- left에 있는 employees e
    ON e.department_id = d.department_id;
--Oracle
--left
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+) --(+)있는 쪽에서 없는 쪽으로 감
    AND e.department_id IS NULL; -- 해당 구문을 붙여주면 차집합(눌값인 kimberely만 나온다)
--right
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

-- self Join : 동일한 테이블 join 
SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    B.first_name
FROM employees A, employees B -- A : 사원, B : 상사 
WHERE a.manager_id = b.employee_id;

--계층형 구조 오름, 내림
SELECT a.employee_id, a.first_name,
    a.manager_id AS "사원의 상사", b.employee_id,
    b.first_name AS "상사"
FROM employees a, employees b -- A : 사원, B : 상사
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; --상향식
CONNECT BY a.manager_id = PRIOR a.employee_id; --하향식

-- 
SELECT e.first_name, d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
    AND e.job_id = j.job_id
    AND e.first_name = 'Lex';
    
SELECT emp.first_name as "직원명", manager.first_name as "상사명"
FROM employees emp, employees manager
WHERE emp.manager_id = manager.employee_id

