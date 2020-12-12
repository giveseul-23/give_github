-- TABLE을 작성하라.
-- TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지

-- TEAM 두개만 등록하라.
CREATE TABLE TEAM(
    TEAM_ID VARCHAR2(20) CONSTRAINT PK_TI PRIMARY KEY,
    LOC VARCHAR2(20),
    TEAM_NAME VARCHAR2(20),
    OPEN_DATE DATE,
    PHONE_NUMBER VARCHAR2(20),
    HOMP VARCHAR(20)
);

/*
DROP TABLE TEAM
CASCADE CONSTRAINTS;
*/

-- TEAM ONE
INSERT INTO TEAM(TEAM_ID, LOC, TEAM_NAME, OPEN_DATE, PHONE_NUMBER, HOMP)
VALUES('LIONS', 'DAEGU', 'SAMSUNG', '82/10/19', '053.780.3300','samsunglions.com');
-- TEAM TWO
INSERT INTO TEAM(TEAM_ID, LOC, TEAM_NAME, OPEN_DATE, PHONE_NUMBER, HOMP)
VALUES('DINOS', 'CHANGWON', 'NC', '11/03/31', '1644.9112','ncdinos.com');

SELECT
    *
FROM team;

-- 두개의 TEAM에 선수를 각각 3명씩 등록하라.
-- PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디 외래키로 연결한다.
CREATE TABLE PLAYER(
    P_NUM NUMBER,
    P_NAME VARCHAR2(20),
    HIRE_DATE DATE,
    PO_SITION VARCHAR2(20),
    HIGHT NUMBER,
    TEAM_ID VARCHAR2(20),
    CONSTRAINT PLAYER FOREIGN KEY(TEAM_ID) REFERENCES TEAM(TEAM_ID);
)

/*
DROP TABLE PLAYER
CASCADE CONSTRAINTS;
*/

-- PK : LIONS
INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('21', 'OHSUNGHWAN', '05/02/01', 'PITCHER', 178, 'LIONS');

INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('5', 'GUJAWOOK', '12/12/25', 'BATTER', 189, 'LIONS');

INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('16', 'LEEWONSUCK', '17/05/05', 'BATTER', 182, 'LIONS');

-- PK : DINOS
INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('93', 'LEEJONGWOOK', '14/03/18', 'BATTER', 176, 'DINOS');

INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('59', 'KOOCHANGMO', '15/02/17', 'PITCHER', 183, 'DINOS');

INSERT INTO PLAYER(P_NUM, P_NAME, HIRE_DATE, PO_SITION, HIGHT, TEAM_ID)
VALUES('78', 'BAEMINSEO', '19/11/18', 'PITCHER', 184, 'DINOS');

-- TABLE을 작성하라.
-- PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
CREATE TABLE PRODUCT(
    PRO_NUM NUMBER CONSTRAINT PRODUCT_NUM PRIMARY KEY,
    PRO_NAME VARCHAR2(20),
    PRICE NUMBER,
    PRO_DETAIL VARCHAR2(20)
);
-- 상품을 3개만 등록 하라.
INSERT INTO PRODUCT(PRO_NUM, PRO_NAME, PRICE, PRO_DETAIL)
VALUES(1, 'SNACK', 1000, 'CHIPS')

INSERT INTO PRODUCT(PRO_NUM, PRO_NAME, PRICE, PRO_DETAIL)
VALUES(2, 'DRINK', 1800, 'COKE')

INSERT INTO PRODUCT(PRO_NUM, PRO_NAME, PRICE, PRO_DETAIL)
VALUES(3, 'JELLY', 500, 'HARIBO')

-- CONSUMER(소비자) : 소비자 ID, 이름, 나이
CREATE TABLE CONSUMER(
    CONSU_ID VARCHAR2(20) CONSTRAINT CONSUMER_ID PRIMARY KEY,
    CONSU_NAME VARCHAR2(20),
    CONSU_AGE NUMBER
);
-- 두명의 소비자를 등록하라.
INSERT INTO CONSUMER(CONSU_ID, CONSU_NAME, CONSU_AGE)
VALUES(101, 'HONGGILDONG', 18)

INSERT INTO CONSUMER(CONSU_ID, CONSU_NAME, CONSU_AGE)
VALUES(102, 'ILJIMAE', 25)

-- CART(장바구니) : 장바구니 번호, 소비자 ID, 상품번호, 수량 외래키로 연결한다.
CREATE TABLE CART(
    CART_NUM NUMBER,
    CONSU_ID VARCHAR2(20),
    PRO_NUM NUMBER,
    CART_COUNT NUMBER,
   CONSTRAINT CART FOREIGN KEY(CONSU_ID) REFERENCES CONSUMER(CONSU_ID),
   FOREIGN KEY(PRO_NUM) REFERENCES PRODUCT(PRO_NUM)
);
-- 소비자의 장바구니에 상품 추가하라.
INSERT INTO CART(CART_NUM, CONSU_ID, PRO_NUM, CART_COUNT)
VALUES(21, '101', 3, 5);

INSERT INTO CART(CART_NUM, CONSU_ID, PRO_NUM, CART_COUNT)
VALUES(22, '102', 1, 2);

SELECT p.pro_name, c.cart_count
FROM CART c
    INNER JOIN CONSUMER con
    ON c.consu_id = con.consu_id
    INNER JOIN PRODUCT p
    ON c.pro_num = p.pro_num
WHERE c.consu_id = '101'
