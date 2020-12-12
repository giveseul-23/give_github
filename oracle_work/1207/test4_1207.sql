-- 19) emp 테이블에서 사원번호, 사원이름, 입사일을 출력하는데 
-- 입사일이 빠른 사람순으로 정렬하시오.
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate;

-- 20) emp 테이블에서 사원이름, 급여, 연봉을 구하고 연봉이 많은 순으로 정렬하시오.
SELECT ename, sal, sal*12
FROM EMP
ORDER BY sal *12 DESC;

SELECT ename, sal, sal*12 as 연봉
FROM EMP
ORDER BY 연봉 DESC; -- alias를 이용해서 사용도 가능하다

--21)10번 부서와 20번부서에서 근무하고 있는 사원의 이름과 부서번호를 출력하는데 
-- 이름을 영문자순으로 표시하시오.
SELECT ename, deptno
FROM emp
WHERE deptno= 10 OR deptno = 20
ORDER BY ename ASC;

--22) 커미션을 받는 모든 사원의 이름,급여 및 
-- 커미션을 커미션을 기준으로 내림차순으로 정렬하여 표시하십시오.
SELECT ename, sal, comm
FROM EMP
WHERE comm IS NOT NULL
    AND comm != 0
ORDER BY comm DESC;