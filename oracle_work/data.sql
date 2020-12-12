SELECT * FROM employees;    --소문자 대문자 둘 다 가능

select * from employees;

-- 한 줄 주석문
 /*범위 주석문*/


--table : column(항목), row(사용자에대한 모든 정보(한 줄, 하나의 데이터))
--tablespace memory공간 --> 파일

--table 생성
/* 테이블 생성형식
CREATE TABLE 테이블명(
    컬럼명1 자료형,
    컬럼명2 자료형,
    컬럼명3 자료형
    --자료형은 한글 x
)

테이블 지우는 형식
DROP TABLE 테이블명;
*/

-- 자료형
/*
    Java            Oracle
    int             Integer, NUMBER
    double          NUMBER(정수의 자리수, 소수의 자리수)
    String          VARCHAR2, CHAR, LONG(DB에서는 문자형)
    Date            DATE
*/

-- 문자열
-- CHAR
CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3)
    VALUES(값, 값, 값)
    
    INTEGER -> 123
    STRING -> 'HELLO'
    
    영어 1문자 -> 1BYTE
    한글 1문자 -> 3BYTE
    
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가', '가', '가');

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가나', '가나', '가나');

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가나다', '가나다', '가나다');

SELECT COL1, COL2, COL3, LENGTHB(COL1), COL3, LENGTHB(COL2), COL3, LENGTHB(COL3)
FROM TB_CHAR;

/*
    CHAR : 10BYTE 00000 00000
    ABC ->        ABC00 00000
    가(3BYTE) + 9(1자리 먹힘) = 12BYTE
    가나(6BYTE) + 8(2자리 먹힘) = 14BYTE
    가나다(9BYTE) + 7(3자리 먹힘) = 16BYTE

*/

-- VARCHAR2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
);

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES('ABC','ABC','ABC');

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES('가나다','가나다','가나다');

SELECT * FROM TB_VARCHAR;

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM TB_VARCHAR;
--낭비되는 공간 없이 정확하게 들어감

/*
    LONG
    최대 2GB까지 저장
    TABLE당 1개만 사용가능
*/

CREATE TABLE TB_LONG(
    /*
    COL1 LONG,
    COL2 VARCHAR2 -- 다른 자료형과 함께 사용 가능
    */
);

CREATE TABLE BOOK(
    TITLE VARCHAR2(20),
    BOOKCONTENT LONG,
    NO NUMBER,
    PRICE NUMBER
)

INSERT INTO TB_LONG(COL1)
VALUES('DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD');

INSERT INTO TB_LONG(COL1)
VALUES('DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD');

SELECT * FROM TB_LONG;

SELECT COL1, LENGTHB(COL1) -- LONG은 LENGTHB 사용불가
FROM TB_LONB;

--숫자(정수, 소수)
-- INTEGER 정수
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123,456.1); --소수를 입력하면 삽입은 되지만 소수점은 짤림

SELECT * FROM TB_INTEGER

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES('123',456.1);  --문자열로 넣어도 자동적으로 숫자로 저장됨

-- NUMBER 정수, 소수
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- 날짜 DATE
-- 연도, 월, 일, 시, 분, 초

CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE-1);

SELECT * FROM TB_DATE;

-- TO_DATE(날짜문자열, 형식문자열)
INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('2020-12-25 12:30:25','YYYY-MM-DD HH:MI:SS') ); --문자열을 형식에 맞춰 적음

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '2020-12-31'); --문자열로만 작성함

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '20/12/30'); --토큰을 -, /으로 작성 가능

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('20201225123025','YYYYMMDDHHMISS') );   -- 토큰을 지우고 다 붙여도 가능

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_NUMBER;
DROP TABLE TB_INTEGER;
DROP TABLE TB_DATE;


