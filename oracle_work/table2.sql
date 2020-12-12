/*
    ���Ἲ : column�� ����
            column�� �����ϴ� ����
    <���Ἲ�� ����>
    Primary Key : �⺻Ű. NULL�� ������� ����. �ߺ��� ������� ����
    Unique key : ����Ű. NULL�� �����. �ߺ��� ������� ����
    Foreign Key : �ܷ�Ű. ���� : JOIN -> ���̺�� ���̺� ����
                    �ܷ�Ű�� ����� �÷��� ����� ���̺��� �⺻Ű(PK), ����ũŰ(UK)�� �����Ǿ� �־�� ��
    CHECK : ������ ����. NULL�� ���
    NOT NULL : NULL�� ������� �ʴ´�
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
VALUES('','111'); -- ����X

-- Primary Key = NOT NULL + Unique
DROP TABLE TB_TEST
CASCADE CONSTRAINTS; -- ���Ἲ���� �Բ� �������� �ڵ�

CREATE TABLE TB_TEST(
                        --���Ἲ�� ID��
    COL_P VARCHAR2(10) CONSTRAINT PK_TEST PRIMARY KEY,
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30)
);

INSERT INTO TB_TEST(COL_P, COL1, COL2)
VALUES('AAA', '111', 'aaa');
/*
 �� ������ �� �� �� �߰��ϰ� �Ǹ�
 ORA-00001: unique constraint (HR.PK_TEST) violated
 �� �ߴµ� unique constraint : ������ ��(�ߺ����X)�� �������ߴٴ� ����
*/
INSERT INTO TB_TEST(COL_P, COL1, COL2)
VALUES('BBB', '111', 'aaa'); -- PK�� �ش��ϴ� �κ��� ������ �ߺ����� �ʰ� �ٲ��ָ� �� �߰� ����

INSERT INTO TB_TEST(COL1, COL2)
VALUES('111', 'aaa'); -- NULL�� ������� �ʱ� ������ ������ �߻���

-- UNIQUE : �ش� �÷����� �ߺ��� ���� ����� �� ����, �� ���� ������ �Է��� �� ���� ��� NULL�� ����� �� ����
--          EX) E-MAIL�κ� ���� ���
DROP TABLE TB_TEST; -- �׳� �����ϰ� �ٽ� �Ȱ��� �̸����� ��������ؼ� ������

CREATE TABLE TB_TEST(
    COL_U VARCHAR(20) CONSTRAINT UK_TEST UNIQUE,  -- COL_U VARCHAR(20) CONSTRAINT UNIQUE �̷� ������� �ص� ����, PK�� �����ϰ� �����ۼ� ����
    --����ũ Ű�� PK�� �����ϰ� �ߺ����� ������� ����
    COL1 VARCHAR(20),
    COL2 VARCHAR(20)
);

INSERT INTO TB_TEST(COL_U, COL1, COL2)
VALUES('AAA','aaa','111');

-- ��� PK�� �ٸ��� NULL ���� �����
INSERT INTO TB_TEST(COL1, COL2)
VALUES('aaa','111');

SELECT * FROM tb_test;

--������ ����ũ Ű�� �ߺ��� ���� �ְ� �ʹٸ�?
ALTER TABLE TB_TEST
DROP CONSTRAINT UK_TEST;
/*
�� ������ �ְԵȴٸ� CREATE �κп��� 
COL_U VARCHAR(20) CONSTRAINT UK_TEST UNIQUE �� 
CONSTRAINT UK_TEST UNIQUE �� �κ��� �����
-> ��, �� ���� COL_U�� ���̻� Unique�� �ƴϰ� ��
*/

--FOREIGN KEY : �ܷ�Ű
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
    COL_PK VARCHAR2(10),--���⼭�� PK �ƴ�
                            --���� ���̺��� COL_PK    ���� PK�� ���� ���̺�(�� ���̺��� PK)
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
VALUES('111','222', 'AAA'); --�ܷ�Ű�� ���� �� �ִ� ���� NULL�̰ų� ����(REFERENCES)�� PK�� ���� �ش�Ǵ� �͸� ����� �� �ִ�

INSERT INTO TB_CHILD(KEY1, KEY2, COL_PK)
VALUES('111','222', 'DDD'); -- 'DDD'�� �ش�Ǵ� ������ ������ ����� �� ����

INSERT INTO TB_CHILD(KEY1, KEY2)
VALUES('111','222');

SELECT
    *
FROM tb_child;

-- CHECK : ������ �� �� �Է��� �� ���� NULL�� �����
CREATE TABLE TB_CHECK(
    COL1 VARCHAR2(10),
    KEY1 VARCHAR2(10),
    --�Ʒ� ������ ������ ���� ���ǵ�
    CONSTRAINT TB_CHK1 CHECK(COL1 IN ('���', '��', '�ٳ���')),
    CONSTRAINT TB_CHK2 CHECK(KEY1 > 0 AND KEY1 <= 100) -- �� ���� �� �ܿ� NULL�� �����
);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('���', 12);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('���', 0); --X

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('', 25);

INSERT INTO TB_CHECK(COL1, KEY1)
VALUES('', '');

SELECT
    *
FROM TB_CHECK;