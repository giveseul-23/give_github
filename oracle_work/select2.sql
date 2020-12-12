select * FROM emp;

-- 현재 스키마의 테이블 목록 전체 조회
select * FROM tab; 

-- 테이블의 컬럼 출력
DESC emp;

-- 원하는 부분만 목록조회
SELECT empno, ename, sal FROM emp;

--dual : 가상테이블
SELECT SYSDATE FROM DUAL;
SELECT 4 * 7 FROM DUAL;
SELECT '4' * 7 FROM DUAL;
SELECT '4' * '7' FROM DUAL;
SELECT 'HELLO' || ' ' || 'ORACLE' FROM DUAL;
SELECT ROUND(10.5) FROM DUAL;

SELECT ename, sal, sal*12 FROM emp;


-- alias(컬럼정보)
SELECT ename AS 이름, sal AS 월급, sal*12 AS 연봉 FROM emp;

-- distint : 중복행 삭제(중복되는 데이터가 삭제됨) --> group by 
SELECT DISTINCT Deptno FROM emp;

SELECT DISTINCT job FROM emp;

-- 1) 
SELECT empno, ename, sal FROM emp;
-- 2)
SELECT ename as "월 급", sal as "이 름" FROM emp; -- as 뒤에 항목명을 ''안에 넣으면 안되고 ""으로 써야함
-- 3)
SELECT empno "사원번호", ename "사원이름", sal "월급", sal*12 "연봉" FROM emp;
-- 4)
SELECT DISTINCT job from emp;
-- 5)
SELECT ename || ', ' ||job as "Employee and Job" from emp;