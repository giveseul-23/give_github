-- ORDER BY = SORTING
/*
    DB -> Sorting -> Java
    DB -> Java -> Sorting
    
    SELECT *
    FROM TABLE
    ORDER BY sal ASC    -- ����
    ORDER BY sal DESC   -- ����

*/

-- ��������
SELECT ename, sal
FROM emp
ORDER BY sal ASC;

-- ��������
SELECT ename, sal
FROM emp
ORDER BY sal DESC;

--alias
SELECT empno, ename, sal*12 AS annsal
FROM emp
ORDER BY sal DESC;

-- NULLS LAST, NULLS FIRST
SELECT ename, comm FROM emp 
ORDER BY comm NULLS FIRST; -- NULL�� ���� ������ �ö���� ��

-- ���� ������ ����
SELECT ename, job, sal FROM emp
ORDER BY job ASC, sal DESC;

--�� ��¥���� ����(������)
SELECT MONTHS_BETWEEN('2021-04-13',SYSDATE)
FROM DUAL;

--Ư�� ��¥ ���� ������ ���� ���� �ش� ��¥�� ��ȯ
SELECT ADD_MONTHS('2020-12-01',6) -- 6�� ����
FROM DUAL;

-- ��¥ ���� ����, ��, ��, ��, ��, ��
SELECT EXTRACT(year from TO_DATE('20-12-07','YY-MM-DD')) AS ����,
    EXTRACT(month from SYSDATE) AS ��,
    EXTRACT(day from SYSDATE) AS ��,
    EXTRACT(hour from CAST(SYSDATE AS TIMESTAMP)) AS ��,
    EXTRACT(minute from CAST(SYSDATE AS TIMESTAMP)) AS ��,
    EXTRACT(second from CAST(SYSDATE AS TIMESTAMP)) AS ��
FROM DUAL;