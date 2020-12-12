-- ORDER BY = SORTING
/*
    DB -> Sorting -> Java
    DB -> Java -> Sorting
    
    SELECT *
    FROM TABLE
    ORDER BY sal ASC    -- 오름
    ORDER BY sal DESC   -- 내림

*/

-- 오름차순
SELECT ename, sal
FROM emp
ORDER BY sal ASC;

-- 내림차순
SELECT ename, sal
FROM emp
ORDER BY sal DESC;

--alias
SELECT empno, ename, sal*12 AS annsal
FROM emp
ORDER BY sal DESC;

-- NULLS LAST, NULLS FIRST
SELECT ename, comm FROM emp 
ORDER BY comm NULLS FIRST; -- NULL이 가장 상위로 올라오게 함

-- 정렬 여러번 가능
SELECT ename, job, sal FROM emp
ORDER BY job ASC, sal DESC;

--두 날짜간의 월수(월간격)
SELECT MONTHS_BETWEEN('2021-04-13',SYSDATE)
FROM DUAL;

--특정 날짜 월에 정수를 더한 다음 해당 날짜를 반환
SELECT ADD_MONTHS('2020-12-01',6) -- 6달 더함
FROM DUAL;

-- 날짜 정보 연도, 월, 일, 시, 분, 초
SELECT EXTRACT(year from TO_DATE('20-12-07','YY-MM-DD')) AS 연도,
    EXTRACT(month from SYSDATE) AS 월,
    EXTRACT(day from SYSDATE) AS 일,
    EXTRACT(hour from CAST(SYSDATE AS TIMESTAMP)) AS 시,
    EXTRACT(minute from CAST(SYSDATE AS TIMESTAMP)) AS 분,
    EXTRACT(second from CAST(SYSDATE AS TIMESTAMP)) AS 초
FROM DUAL;