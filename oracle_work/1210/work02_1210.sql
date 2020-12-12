/*
37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
모든 사원의 등급을 표시하시오.

업무        등급
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
기타         0
*/
SELECT ENAME, JOB,
    CASE JOB
        WHEN 'PRESIDENT' THEN 'A'
        WHEN 'ANALYST' THEN 'B'
        WHEN 'MANAGER' THEN 'C'
        WHEN 'SALESMAN' THEN 'D'
        WHEN 'CLERK' THEN 'E'
        ELSE '0'
    END
FROM EMP;

SELECT ENAME, JOB,
    DECODE( JOB,
         'PRESIDENT', 'A',
         'ANALYST', 'B',
         'MANAGER', 'C',
         'SALESMAN', 'D',
         'CLERK', 'E',
         0 ) AS GRADE
FROM EMP;

-- 60) BLAKE와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데 
-- BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ename, hiredate
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename = 'BLAKE')
    AND ename NOT IN('BLAKE');

-- 61) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 
-- 월급이 높은 사람순으로 출력하시오.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT AVG(SAL) FROM EMP)
ORDER BY sal DESC;

-- 62) 10번부서에서 급여를 가장 적게 받는 사원과 동일한 급여를 받는 사원의 이름을 출력하시오.
SELECT ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp WHERE deptno LIKE '10');

-- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오. *어려웠지만 혼자 풀음!
SELECT d.dname, COUNT(*)
FROM EMP e INNER JOIN dept d ON e.deptno = d.deptno
WHERE e.deptno IN (SELECT deptno FROM emp GROUP BY deptno HAVING COUNT(*) > 3)
GROUP BY d.dname;

-- 64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ename, hiredate
FROM EMP
WHERE hiredate < (SELECT hiredate FROM emp WHERE empno = '7844');

-- 65) 직속상사가 KING인 모든 사원의 이름과 급여를 출력하시오.
SELECT ename, sal
FROM EMP
WHERE mgr IN (SELECT empno FROM EMP WHERE ename LIKE 'KING');

-- 66) 20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는 
-- 사원의 이름과 부서명,급여, 급여등급을 출력하시오.(emp, dept, salgrade) * 세개의 테이블 JOIN하는 ANSI SQL 문법 알아두기
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e
    INNER JOIN dept d
    ON e.deptno = d.deptno
    INNER JOIN salgrade s
    ON e.sal BETWEEN s.losal and s.hisal
WHERE sal IN (SELECT MAX(sal) FROM emp WHERE deptno = 20);

--67) 총급여sal+comm가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 
--    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력) ***

SELECT empno, ename, sal + NVL(comm, '0') AS 총급여, NVL2(comm,'유','무') AS 커미션여부
FROM emp
WHERE ename IN (SELECT ename FROM EMP WHERE sal + NVL(comm,'0') > (SELECT AVG(sal) FROM emp ));

-- 68) CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는 
-- 사원의 이름과 급여, 지역명을 출력하시오.
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND sal > (SELECT AVG(e.sal) FROM EMP e, dept d WHERE e.deptno = d.deptno AND d.loc = 'CHICAGO');

-- 69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 
-- 이름, 근무하는 사원의 이름, 업무를 출력 하시오.
-- (컬럼명은 부서명, 사원명, 업무로 출력)

SELECT d.dname as 부서명, e.ename as 사원명, e.job as 업무
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.deptno IN (SELECT deptno FROM emp WHERE job LIKE 'SALESMAN' GROUP BY deptno HAVING COUNT(*) >= 2 );

-- 70) 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.
SELECT e.ename, s.grade
FROM EMP e INNER JOIN salgrade s
    ON e.sal BETWEEN s.losal and s.hisal
WHERE e.sal IN (SELECT MAX(sal) FROM emp WHERE comm IS NULL OR comm = 0);

-- 71) SMITH의 관리자의 이름과 부서명, 근무지역을 출력하시오. 
SELECT e.ename, d.dname, d.loc
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE e.empno IN (SELECT m.empno FROM emp e INNER JOIN emp m ON e.mgr = m.empno WHERE e.ename LIKE 'SMITH');

-- 다른 방법
SELECT e.ename, d.dname, d.loc
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE e.empno IN (SELECT mgr FROM emp  WHERE ename LIKE 'SMITH')