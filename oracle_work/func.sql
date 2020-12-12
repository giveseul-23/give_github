-- Standard Function

-- dual table : 가상 테이블 -> 결과 확인용 임시 테이블
SELECT 1 FROM DUAL;
SELECT 'A' FROM DUAL;
SELECT '가' FROM DUAL;
SELECT 23 * 34 FROM DUAL;

-- 문자 함수
-- CHR( N ) : ASCII 값을 문자로 변환
SELECT CHR(65) FROM DUAL; --A
SELECT CHR(49) FROM DUAL; --문자 1
SELECT CHR(97) FROM DUAL; --a

--"안녕하세요" + "건강하세요" = "안녕하세요건강하세요"
-- || 자바의 +와 동일한 느낌, 문자열을 연결하는 경우
SELECT '안녕하세요' || '건강하세요' FROM DUAL; --안녕하세요건강하세요
SELECT '내 점수는 ' || CHR(65) || ' 입니다'FROM DUAL;

-- LPAD(RPAD) : 빈칸을 지정문자로 채운다
SELECT LPAD('BBB', 10) FROM DUAL; --왼쪽 빈칸
SELECT RPAD('BBB', 10) FROM DUAL; --오른쪽 빈칸
SELECT LPAD('BBB', 10, '-') FROM DUAL; --왼쪽에 정해진 토큰('-')으로 채워짐

-- INSTR == indexOf('c')        abcd -> 값이 2가 나옴
SELECT INSTR('123ABC456ABC','A') FROM DUAL; -- DB는 첫 시작이 0이 아니라 1부터 시작됨 
SELECT INSTR('123ABC456ABC','A', 6) FROM DUAL;
SELECT INSTR('123ABC456ABC','A', 6, 1) FROM DUAL; -- 6번째 인덱스 이후 첫번째 A
SELECT INSTR('123ABC456ABCABC','A', 6, 2) FROM DUAL; --6번째 인덱스 이후 두번째 A
SELECT INSTR('123ABC456ABC','D') FROM DUAL; -- 찾을 수 없는 단어는 0이 나옴(자바는 -1)

--REPLACE : 문자열 치환, TRANSLATE보다 리플레이스를 더 많이 사용함
SELECT REPLACE('AAAAABC', 'A')FROM DUAL; --바꿀 문자를 지정해 주지 않을 경우 BC만 나옴
SELECT REPLACE('AAAAABC', 'A', 'a')FROM DUAL; -- aaaaaBC
SELECT REPLACE('AAAAABC', 'AA', 'a')FROM DUAL; -- aaABC

--TRANSLATE : 문자 치환
SELECT TRANSLATE('AAAAABC', 'A', 'a')FROM DUAL;
SELECT TRANSLATE('AAAAABC', 'AA', 'a')FROM DUAL; -- aaaaaBC //문자열이 아니라 문자로 치환됨

--숫자
--올림
SELECT CEIL(13.1) FROM DUAL; --14
--내림
SELECT FLOOR(13.9) FROM DUAL; --13
--승수
SELECT POWER(3, 2) FROM DUAL; --3의 2승 --9
--반올림
SELECT ROUND(13.5) FROM DUAL; --14

--부호, 사용빈도 높음
--SIGN
SELECT SIGN(12) FROM DUAL; -- 1, +일때
SELECT SIGN(0) FROM DUAL; -- 0, 0일때
SELECT SIGN(-6) FROM DUAL; -- -1, -일때

--버림
--TRUNC
SELECT TRUNC(12.34567) FROM DUAL; -- 소수점 자리 날림
SELECT TRUNC(12.34567 ,2) FROM DUAL; -- 소수점 두번째 짜리까지만 살림
SELECT TRUNC(12.34567 ,-1) FROM DUAL; 

--ASCII 문자 검색이나 문자가 제대로 안들어가있을경우 확인용으로 많이 사용함
SELECT ASCII('A') FROM DUAL; 

--변환
--TO_CHAR
--DATE -> VARCHAR2
SELECT TO_CHAR(SYSDATE) FROM DUAL; --숫자로 보이지만 문자열로 들어감 20/12/04
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD-HH-MI-SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS') FROM DUAL;

SELECT TO_CHAR(TO_DATE(SYSDATE, 'YYYY/MM/DD HH:MI:SS'), 'YYYY/MM/DD HH:MI:SS') FROM DUAL;

SELECT SYSDATE FROM DUAL;

SELECT TO_CHAR(1000000000,'$999,999,999,999') FROM DUAL; --표기법도 가능

-- TO DATE
-- VARCHAR2 -> DATE
SELECT TO_DATE('20201205') FROM DUAL;

SELECT TO_DATE('20201205','YYYYMMDD') FROM DUAL;
SELECT TO_DATE('12052020','MMDDYYYY') FROM DUAL;

--TO_NUMBER VARCHAR2 -> NUMBER  (JAVA : Integer.parseInt())
SELECT '123' + 1 FROM DUAL;
SELECT TO_NUMBER('123') + 1 FROM DUAL; -- 해당 부분이 정석적인 방법

--LAST_DAY : 달의 마지막 날을 알 수 있음
SELECT LAST_DAY('20/12/01') FROM DUAL; 

-- SUBSTR            AbcDef substring(1,3) -> bc
--                          substring(4) -> ef
SELECT SUBSTR('ABCDEFG', 3) FROM DUAL; --CDEFG
SELECT SUBSTR('ABCDEFG', 3, 3) FROM DUAL; --CDE  (문자열, 시작위치, 문자의 갯수)
