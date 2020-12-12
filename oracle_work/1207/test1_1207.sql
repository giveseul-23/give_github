--6) emp 테이블에서 사원번호가 7698 인 사원의 이름, 업무, 급여를 출력하시오.
SELECT ename, JOB, sal
FROM emp
WHERE empno = 7698;

-- 7) emp 테이블에서 사원이름이 SMITH인 사람의 이름과 월급, 부서번호를 구하시오.
SELECT ename, sal, deptno
FROM emp
WHERE ename = 'SMITH';

-- 8) 월급이 2500이상 3500미만인 사원의 이름, 입사일, 월급을 구하시오.
SELECT ename, hiredate, sal FROM emp
WHERE sal>=2500 AND SAL<3500;

-- 9) 급여가 2000에서 3000사이에 포함되지 않는 사원의 이름, 업무, 급여를 출력하시오.
SELECT ename, JOB, sal
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 3000;

-- 10) 81년05월01일과 81년12월03일 사이에 입사한 사원의 이름, 급여, 입사일을 출력하시오.
SELECT ename, sal, hiredate
FROM EMP
WHERE hiredate >= '81/05/01' AND hiredate <= '81/12/03';
-- WHERE hiredate BETWEEN '81/05/01' AND '81/12/03'

-- 11) emp테이블에서 사원번호가 7566,7782,7934인 사원을 제외한 사람들의 사원번호,이름,
--    월급을 출력하시오.
SELECT empno, ename, sal
FROM EMP
WHERE empno NOT IN(7566,7782,7934);

-- 12) 부서번호 30(deptno)에서 근무하며 월 2,000달러 이하를 받는 81년05월01일 이전에 입사한 사원의 이름, 급여, 부서번호, 입사일을 출력하시오.
SELECT ename, sal, empno, hiredate
FROM EMP
WHERE deptno = 30 
    AND sal <= 2000 
        AND hiredate < '81/05/01';

-- 13) emp테이블에서 급여가 2,000와 5,000 사이고 부서번호가 10 또는 30인 사원의 이름과 급여,부서번호를 나열하시오.
SELECT ename, sal, deptno
FROM EMP
WHERE (sal BETWEEN 2000 AND 5000)
        AND (deptno = 10 OR deptno = 30);

-- 14) 업무가 SALESMAN 또는 MANAGER이면서 급여가 1,600, 2,975 또는 2,850이 (아닌) 모든 사원의 이름, 업무 및 급여를 표시하시오.
SELECT ename, job, sal
FROM EMP
WHERE (job = 'SALESMAN' OR job = 'MANAGER')
        AND sal NOT IN(1600, 2975, 2850);
    
-- 15) emp테이블에서 사원이름 중 S가 포함되지 않은 사람들 중 부서번호가 20인 사원들의 이름과 부서번호를 출력하시오.
SELECT ename, deptno
FROM EMP
WHERE ename NOT LIKE '%S%' AND deptno = 20;

-- 16) emp테이블에서 이름에 A와 E가 있는 모든 사원의 이름을 표시하시오.
SELECT ename
FROM EMP
WHERE ename LIKE '%A%' AND ename LIKE '%E%';

-- 17) emp테이블에서 관리자가 없는 모든 사원의 이름과 업무를 표시하시오.
SELECT ename, JOB
FROM EMP
WHERE MGR IS NULL;

-- 18) emp테이블에서 커미션 항목이 입력된 사원들의 이름과 급여, 커미션을 구하시오.
SELECT ename, sal, comm
FROM EMP
WHERE comm IS NOT NULL and comm <> 0;