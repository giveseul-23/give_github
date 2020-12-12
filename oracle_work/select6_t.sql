/*
    Join
    두개 이상의 테이블을 연결해서 데이터를 검색하는 방법.
    보통 두개이상의 행(row)들의 공통된 값 Primary Key(기본키), Foreign Key(외래키)값을
    사용해서 연결한다.

    Primary Key(기본키) : 테이블에서 중복되지 않는 키
    Foreign Key(외래키) : 다른 테이블에 있는 키
    
    Ansi SQL
    Oracle
    
    inner Join  : *****
    full outer Join
    cross Join
    outer
        left    : ***
        right   : ***
    self Join     *****
*/

-- inner Join
-- Ansi SQL
SELECT employee_id, first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- full outer Join
-- ansi
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

-- Outer Join
-- left, right
-- Ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND e.department_id IS NULL;
--                   <---                

-- self Join : 동일한 테이블 Join
SELECT A.employee_id, A.first_name,
    A.manager_id, B.employee_id,
    B.first_name
FROM employees A, employees B   -- A : 사원  B : 상사
WHERE A.manager_id = B.employee_id;

-- 계층형 구조 오름, 내림
SELECT a.employee_id, a.first_name,
    a.manager_id as "사원의 상사", b.employee_id,
    b.first_name as "상사"
FROM employees a, employees b   -- A : 사원  B : 상사
WHERE a.manager_id = b.employee_id(+)
-- CONNECT BY PRIOR a.manager_id = a.employee_id;  -- 상향식
CONNECT BY a.manager_id = PRIOR a.employee_id;  -- 하향식

























