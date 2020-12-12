-- 23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
SELECT INITCAP(job) FROM EMP;

-- 24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
SELECT SUBSTR(ENAME,1,3) FROM EMP
WHERE ENAME LIKE ('%A%');


-- 25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오. *****
SELECT ename
FROM EMP
WHERE ename LIKE '__A%';
--WHERE SUBSTR(ename, 3, 1) = 'A'

-- 26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자로, 나머지 글자는 소문자로
-- 표시) 및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)
SELECT INITCAP(ename) AS "name", LENGTH(ename) AS "length" 
FROM EMP
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR ename LIKE 'M%';

-- 27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT LOWER(ENAME)
FROM EMP
WHERE LENGTH(ENAME) >= 6 ;

-- 28) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT LOWER(SUBSTR(ename,1,3)) FROM EMP
WHERE LENGTH(ENAME) >= 6;

-- 29) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로 
-- 표기하고 열레이블을 SALARY로 지정하시오. *****
SELECT ename, LPAD(sal, 15, '$') AS "SALARY"
FROM EMP;

-- 30) 오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오. *****
SELECT LAST_DAY(SYSDATE) - SYSDATE
FROM DUAL;

-- 31) emp테이블에서 각 사원에 대해 사원번호, 이름, 급여 및 15% 인상된 급여를 정수(반올림)로 표시하시오.
-- 인상된 급여열의 레이블을 New Salary로 지정하시오.
SELECT empno, ename, sal, ROUND(sal * 1.15) AS "New Salary"
FROM  EMP;

-- 32) emp테이블에서 월급의 4의 배수(mod(sal,4)=0)인 사원의 이름과 월급을 출력하시오.(세자리 단위 쉼표 표시)
SELECT ename, TO_CHAR(sal,'999,999,999,999')
FROM EMP
WHERE mod(sal,4)=0;

-- 33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
-- 열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
-- 기준으로 오름차순으로 정렬하시오.
SELECT ename, ROUND(MONTHS_BETWEEN(SYSDATE,hiredate)) AS "MONTHS_WORKED" 
FROM EMP
ORDER BY MONTHS_WORKED;

-- SYSDATE - hiredate : 근무 일수
-- (SYSDATE - hiredate) / 7 : 근무 주수
-- MONTH_BETWEEN(SYSDATE - hiredate) : 근무 달수

-- 34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
SELECT ename, job, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)/12) AS 근무연차
FROM EMP;

-- 35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
-- 단, NULL값은 나타나지 않게 작성하시오. ***위치 착각
SELECT ename, sal, sal + NVL(comm , 0) AS "실급여"
FROM EMP;

-- 36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜를 출력하시오. 
-- 단, 고용날짜는 1980-12-17 형태로 출력하시오.
SELECT ename, job, sal, comm, TO_CHAR(hiredate,'YYYY-MM-DD')
FROM EMP
WHERE (sal + NVL(comm, 0)) >= 2000
