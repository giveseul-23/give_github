/*
    SELECT COLUMN, ALIAS, FUNTION, SUBQUERY
    FROM TABLE, SUBQUERY
    
    WHERE
    
    표현식
    비교연산자(=, >, <, !=, >=, <=, <>)
    NULL, = NULL(틀린 문법), IS NULL(맞는문법), IS NOT NULL
    (), NOT, AND(&&), OR(||)
*/

-- FIRST_NAME == Julia
SELECT first_name, last_name, salary FROM employees
WHERE first_name = 'Julia'; 

--월급이 $9000이상인 사원
SELECT first_name, salary FROM employees
WHERE salary >= 9000;

--이름이 Shanta 보다 큰 이름
SELECT first_name FROM employees
WHERE first_name > 'Shanta'; -- s 이전의 이름은 나오지 않음

SELECT first_name FROM employees 
WHERE first_name >= 'a'; -- 검색되지 않음 현재 데이터는 이름이 전부 대문자로 시작됨

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NOT NULL; -- null x  |  String str = new String() != String str = null
-- NULL값을 제외한 모든 사람들이 출력됨

-- AND '산타'이고 '존'일때
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    AND first_name = 'John'; 

-- OR '산타'거나 '존'일때
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta'
    OR first_name = 'John'; 
    
-- 이름 John, 월급이 5000 이상일때
SELECT first_name,  salary
FROM employees
WHERE first_name = 'John' 
    AND salary >= 5000;
    
-- 2007년 12월 31일 이후에 입사한 사원의 정보
SELECT first_name, hire_date
FROM employees
-- 방법1 WHERE hire_date > '07/12/31'
WHERE hire_date > TO_DATE('071231','YYMMDD'); --방법2

-- ALL(AND), ANY(OR)
/*
동일구문
WHERE first_name = 'Shanta'
    AND first_name = 'John'; 
*/
SELECT first_name FROM employees
WHERE first_name = ALL('Julia', 'John'); 

SELECT first_name FROM employees
WHERE first_name = ANY('Julia', 'John'); 

-- IN, NOT IN
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200, 6000);

SELECT first_name, salary
FROM employees
-- 이 급여를 받는 사람 제외한 나머지 사람 출력됨
WHERE salary NOT IN(8000, 3200, 6000); 

SELECT first_name, salary
FROM employees
WHERE first_name IN('Julia', 'John');

--BETWEEN 범위 연산자
/*
    동일한 구문
    SALARY >= 3200 AND SALARY <= 9000
    SALARY BETWEEN AND 9000
*/

-- 3200>= SALARY <= 9000
SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 3200 AND 9000;

-- 3200< SALARY > 9000
SELECT first_name, salary
FROM employees
WHERE salary NOT BETWEEN 3200 AND 9000;

-- LIKE *****(매우중요)
SELECT first_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _ : 한 문자

SELECT first_name
FROM employees
WHERE first_name LIKE 'Al%'; --앞에서부터 시작해서 Al을 포함하는 모든 이름

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%'; -- Al을 포함하는 모든 이름(자리상관 x)

SELECT first_name
FROM employees
WHERE first_name LIKE 'K%y'; --첫글자 K, 마지막 글자 y 

--2006년도에 입사한 사원
SELECT first_name, hire_date
FROM employees
WHERE hire_date >= '06/01/01' AND hire_date < '07/01/01' ;

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%'; 