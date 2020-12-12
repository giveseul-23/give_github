/*
    무결성 : column에 적용
            column에 지정하는 성질
    <무결성의 종류>
    Primary Key : 기본키. NULL을 허용하지 않음. 중복을 허용하지 않음
    Unique key : 고유키. NULL을 허용함. 중복을 허용하지 않음
    Foreign Key : 외래키. 목적 : JOIN -> 테이블과 테이블 연결
                    외래키로 연결된 컬럼은 연결된 테이블에서 기본키(PK), 유니크키(UK)로 설정되어 있어야 함
    CHECK : 범위를 설정. NULL을 허용
    NOT NULL : NULL을 허용하지 않는다
*/

-- NOT NULL
CREATE TABLE TB_TEST(
    COL1 VARCHAR2(10) NOT NULL,
    COL2 VARCHAR2(20)
);

INSERT INTO TB_TEST(COL1, COL2)
VALUES('AAA','111');

SELECT * FROM tb_test;

INSERT INTO TB_TEST(COL1)
VALUES('BBB');

INSERT INTO TB_TEST(COL2)
VALUES('222');

INSERT INTO TB_TEST(COL1, COL2)
VALUES('','111'); -- 빈문자X

-- Primary Key = NOT NULL + Unique
DROP TABLE TB_TEST
CASCADE CONSTRAINTS; -- 무결성까지 함께 지워지는 코드

CREATE TABLE TB_TEST(
                        --무결성의 ID값
    COL_P VARCHAR2(10) CONSTRAINT PK_TEST PRIMARY KEY,
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30)
);

INSERT INTO TB_TEST(COL_P, COL1, COL2)
VALUES('AAA', '111', 'aaa');
/*
 위 구문을 한 번 더 추가하게 되면
 ORA-00001: unique constraint (HR.PK_TEST) violated
 이 뜨는데 unique constraint : 고유한 값(중복허용X)을 넣으려했다는 오류
*/
INSERT INTO TB_TEST(COL_P, COL1, COL2)
VALUES('BBB', '111', 'aaa'); -- PK에 해당하는 부분의 내용을 중복되지 않게 바꿔주면 행 추가 가능

INSERT INTO TB_TEST(COL1, COL2)
VALUES('111', 'aaa'); -- NULL을 허용하지 않기 때문에 오류가 발생함

-- UNIQUE : 해당 컬럼에서 중복된 값은 사용할 수 없음, 한 개의 값만을 입력할 수 있음 대신 NULL을 허용할 수 있음
--          EX) E-MAIL부분 같은 경우
DROP TABLE TB_TEST; -- 그냥 삭제하고 다시 똑같은 이름으로 만들기위해서 삭제함

CREATE TABLE TB_TEST(
    COL_U VARCHAR(20) CONSTRAINT UK_TEST UNIQUE,  -- COL_U VARCHAR(20) CONSTRAINT UNIQUE 이런 방식으로 해도 가능, PK도 동일하게 구문작성 가능
    --유니크 키는 PK와 동일하게 중복값을 허용하지 않음
    COL1 VARCHAR(20),
    COL2 VARCHAR(20)
);

INSERT INTO TB_TEST(COL_U, COL1, COL2)
VALUES('AAA','aaa','111');

-- 대신 PK와 다르게 NULL 값은 허용함
INSERT INTO TB_TEST(COL1, COL2)
VALUES('aaa','111');

SELECT * FROM tb_test;

--하지만 유니크 키에 중복된 값을 넣고 싶다면?
ALTER TABLE TB_TEST
DROP CONSTRAINT UK_TEST;
/*
이 구문을 넣게된다면 CREATE 부분에서 
COL_U VARCHAR(20) CONSTRAINT UK_TEST UNIQUE 중 
CONSTRAINT UK_TEST UNIQUE 이 부분이 사라짐
-> 즉, 그 뜻이 COL_U는 더이상 Unique가 아니게 됨
*/

--FOREIGN KEY : 외래키
-- DEPATMENTS TABLE = TB_PARENT
CREATE TABLE TB_PARENT(
    COL_PK VARCHAR2(10) CONSTRAINT PK_PARENT PRIMARY KEY,
    COL1 VARCHAR(20),
    COL2 VARCHAR(20)
);

-- EMPLOYEES
CREATE TABLE TB_CHILD(
    KEY1 VARCHAR(10),
    KEY2 VARCHAR(20),
    COL_PK VARCHAR2(10),--여기서는 PK 아님
                            --현재 테이블의 COL_PK    참조 PK를 가진 테이블(그 테이블에서 PK)
    CONSTRAINT FK_CHILD FOREIGN KEY(COL_PK) REFERENCES TB_PARENT(COL_PK)
);

INSERT INTO TB_PARENT(COL_PK, COL1, COL2)
VALUES('AAA','aaa','111');

INSERT INTO TB_PARENT(COL_PK, COL1, COL2)
VALUES('BBB','bbb','222');

INSERT INTO TB_PARENT(COL_PK, COL1, COL2)
VALUES('CCC','ccc','333');

SELECT * FROM tb_parent;

INSERT INTO TB_CHILD(KEY1, KEY2, COL_PK)
VALUES('111','222', 'AAA'); --외래키에 넣을 수 있는 것은 NULL이거나 참조(REFERENCES)된 PK의 값에 해당되는 것만 사용할 수 있다

INSERT INTO TB_CHILD(KEY1, KEY2, COL_PK)
VALUES('111','222', 'DDD'); -- 'DDD'는 해당되는 내용이 없으니 사용할 수 없음

INSERT INTO TB_CHILD(KEY1, KEY2)
VALUES('111','222');

SELECT
    *
FROM tb_child;

-- CHECK : 지정된 값 외 입력할 수 없고 NULL을 허용함
CREATE TABLE TB_CHECK(
    COL1 VARCHAR2(10),
    KEY1 VARCHAR2(10),
    --아래 구문은 지정된 값의 조건들
    CONSTRAINT TB_CHK1 CHECK(COL1 IN ('사과', '배', '바나나')),
    CONSTRAINT TB_CHK2 CHECK(KEY1 > 0 AND KEY1 <= 100) -- 이 범위 값 외에 NULL만 허용함
);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('사과', 12);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('사과', 0); --X

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('', 25);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('', '');

SELECT
    *
FROM TB_CHECK;