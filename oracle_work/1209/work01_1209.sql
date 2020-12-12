--38)모든 사원의 급여의 최고액, 최저액, 총액 및 평균액을 표시하시오. 열 레이블을 
--각각 maximum,minimum,sum 및 average로 지정하고 결과를 정수로 반올림하고 세자리 단위로 ,를 명시하시오.
SELECT TO_CHAR(MAX(sal), '999,999') AS maximum, TO_CHAR(MIN(sal),'999,999') AS minimum
        , TO_CHAR(SUM(sal),'999,999') AS sum, TO_CHAR(ROUND(AVG(sal)),'999,999') AS average
FROM emp;

--39) 업무가 동일한 사원 수를 표시하는 질의를 작성하시오.
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB;

--40) emp테이블에서 30번부서의 사원수를 구하시오.
SELECT COUNT(*)
FROM EMP
GROUP BY deptno
HAVING deptno = 30;

--41) emp테이블에서 업무별 최고 월급을 구하고 업무,최고 월급을 출력하시오.
SELECT JOB, MAX(sal)
FROM emp
GROUP BY JOB;

--42) emp테이블에서 20번부서의 급여 합계를 구하고 급여 합계 금액을 출력하시오.
SELECT SUM(sal)
FROM EMP
GROUP BY deptno
HAVING deptno = 20;

--43) emp테이블에서 부서별로 지급되는 총월급에서 금액이 7,000이상인 부서번호, 총월급을 출력하시오.
SELECT deptno, SUM(SAL)
FROM EMP
GROUP BY deptno
HAVING SUM(sal) >= 7000;

--44) emp테이블에서 업무별로 사번이 제일 늦은 사람을 구하고 그 결과 내에서 사번이 79로 시작하는 결과만 보여주시오.
SELECT MAX(empno)
FROM emp
WHERE empno LIKE '79%'
GROUP BY JOB;

--45) emp테이블에서 업무별 총월급을 출력하는데 업무가 'MANAGER'인 사원들은 제외하고  총월급이 5,000보다 큰 업무와 총월급만 출력하시오.
SELECT JOB, SUM(sal)
FROM emp
WHERE JOB NOT LIKE 'MANAGER'
GROUP BY JOB
HAVING SUM(sal) > 5000;

--46)emp테이블에서 업무별로 사원수가 4명 이상인 업무와 인원수를 출력하시오.
SELECT JOB, COUNT(*)
FROM emp
GROUP BY JOB
HAVING COUNT(*) >= 4;

--47)emp테이블에서 사원수가 5명이 넘는 부서의 부서번호와 사원수를 구하시오.
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
HAVING COUNT(*) >= 5;

--48)emp테이블에서 부서별 급여평균을 구할 때 소수점 3자리에서 반올림해서 2자리까지 구하고 부서번호, 급여평균을 출력하시오.
SELECT deptno, ROUND(AVG(SAL), 2)
FROM emp
GROUP BY deptno;