SELECT * FROM employees;    --�ҹ��� �빮�� �� �� ����

select * from employees;

-- �� �� �ּ���
 /*���� �ּ���*/


--table : column(�׸�), row(����ڿ����� ��� ����(�� ��, �ϳ��� ������))
--tablespace memory���� --> ����

--table ����
/* ���̺� ��������
CREATE TABLE ���̺��(
    �÷���1 �ڷ���,
    �÷���2 �ڷ���,
    �÷���3 �ڷ���
    --�ڷ����� �ѱ� x
)

���̺� ����� ����
DROP TABLE ���̺��;
*/

-- �ڷ���
/*
    Java            Oracle
    int             Integer, NUMBER
    double          NUMBER(������ �ڸ���, �Ҽ��� �ڸ���)
    String          VARCHAR2, CHAR, LONG(DB������ ������)
    Date            DATE
*/

-- ���ڿ�
-- CHAR
CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO ���̺��(�÷���1, �÷���2, �÷���3)
    VALUES(��, ��, ��)
    
    INTEGER -> 123
    STRING -> 'HELLO'
    
    ���� 1���� -> 1BYTE
    �ѱ� 1���� -> 3BYTE
    
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('��', '��', '��');

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('����', '����', '����');

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('������', '������', '������');

SELECT COL1, COL2, COL3, LENGTHB(COL1), COL3, LENGTHB(COL2), COL3, LENGTHB(COL3)
FROM TB_CHAR;

/*
    CHAR : 10BYTE 00000 00000
    ABC ->        ABC00 00000
    ��(3BYTE) + 9(1�ڸ� ����) = 12BYTE
    ����(6BYTE) + 8(2�ڸ� ����) = 14BYTE
    ������(9BYTE) + 7(3�ڸ� ����) = 16BYTE

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
VALUES('������','������','������');

SELECT * FROM TB_VARCHAR;

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM TB_VARCHAR;
--����Ǵ� ���� ���� ��Ȯ�ϰ� ��

/*
    LONG
    �ִ� 2GB���� ����
    TABLE�� 1���� ��밡��
*/

CREATE TABLE TB_LONG(
    /*
    COL1 LONG,
    COL2 VARCHAR2 -- �ٸ� �ڷ����� �Բ� ��� ����
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

SELECT COL1, LENGTHB(COL1) -- LONG�� LENGTHB ���Ұ�
FROM TB_LONB;

--����(����, �Ҽ�)
-- INTEGER ����
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123,456.1); --�Ҽ��� �Է��ϸ� ������ ������ �Ҽ����� ©��

SELECT * FROM TB_INTEGER

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES('123',456.1);  --���ڿ��� �־ �ڵ������� ���ڷ� �����

-- NUMBER ����, �Ҽ�
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- ��¥ DATE
-- ����, ��, ��, ��, ��, ��

CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE-1);

SELECT * FROM TB_DATE;

-- TO_DATE(��¥���ڿ�, ���Ĺ��ڿ�)
INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('2020-12-25 12:30:25','YYYY-MM-DD HH:MI:SS') ); --���ڿ��� ���Ŀ� ���� ����

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '2020-12-31'); --���ڿ��θ� �ۼ���

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '20/12/30'); --��ū�� -, /���� �ۼ� ����

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('20201225123025','YYYYMMDDHHMISS') );   -- ��ū�� ����� �� �ٿ��� ����

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_NUMBER;
DROP TABLE TB_INTEGER;
DROP TABLE TB_DATE;


