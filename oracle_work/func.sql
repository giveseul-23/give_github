-- Standard Function

-- dual table : ���� ���̺� -> ��� Ȯ�ο� �ӽ� ���̺�
SELECT 1 FROM DUAL;
SELECT 'A' FROM DUAL;
SELECT '��' FROM DUAL;
SELECT 23 * 34 FROM DUAL;

-- ���� �Լ�
-- CHR( N ) : ASCII ���� ���ڷ� ��ȯ
SELECT CHR(65) FROM DUAL; --A
SELECT CHR(49) FROM DUAL; --���� 1
SELECT CHR(97) FROM DUAL; --a

--"�ȳ��ϼ���" + "�ǰ��ϼ���" = "�ȳ��ϼ���ǰ��ϼ���"
-- || �ڹ��� +�� ������ ����, ���ڿ��� �����ϴ� ���
SELECT '�ȳ��ϼ���' || '�ǰ��ϼ���' FROM DUAL; --�ȳ��ϼ���ǰ��ϼ���
SELECT '�� ������ ' || CHR(65) || ' �Դϴ�'FROM DUAL;

-- LPAD(RPAD) : ��ĭ�� �������ڷ� ä���
SELECT LPAD('BBB', 10) FROM DUAL; --���� ��ĭ
SELECT RPAD('BBB', 10) FROM DUAL; --������ ��ĭ
SELECT LPAD('BBB', 10, '-') FROM DUAL; --���ʿ� ������ ��ū('-')���� ä����

-- INSTR == indexOf('c')        abcd -> ���� 2�� ����
SELECT INSTR('123ABC456ABC','A') FROM DUAL; -- DB�� ù ������ 0�� �ƴ϶� 1���� ���۵� 
SELECT INSTR('123ABC456ABC','A', 6) FROM DUAL;
SELECT INSTR('123ABC456ABC','A', 6, 1) FROM DUAL; -- 6��° �ε��� ���� ù��° A
SELECT INSTR('123ABC456ABCABC','A', 6, 2) FROM DUAL; --6��° �ε��� ���� �ι�° A
SELECT INSTR('123ABC456ABC','D') FROM DUAL; -- ã�� �� ���� �ܾ�� 0�� ����(�ڹٴ� -1)

--REPLACE : ���ڿ� ġȯ, TRANSLATE���� ���÷��̽��� �� ���� �����
SELECT REPLACE('AAAAABC', 'A')FROM DUAL; --�ٲ� ���ڸ� ������ ���� ���� ��� BC�� ����
SELECT REPLACE('AAAAABC', 'A', 'a')FROM DUAL; -- aaaaaBC
SELECT REPLACE('AAAAABC', 'AA', 'a')FROM DUAL; -- aaABC

--TRANSLATE : ���� ġȯ
SELECT TRANSLATE('AAAAABC', 'A', 'a')FROM DUAL;
SELECT TRANSLATE('AAAAABC', 'AA', 'a')FROM DUAL; -- aaaaaBC //���ڿ��� �ƴ϶� ���ڷ� ġȯ��

--����
--�ø�
SELECT CEIL(13.1) FROM DUAL; --14
--����
SELECT FLOOR(13.9) FROM DUAL; --13
--�¼�
SELECT POWER(3, 2) FROM DUAL; --3�� 2�� --9
--�ݿø�
SELECT ROUND(13.5) FROM DUAL; --14

--��ȣ, ���� ����
--SIGN
SELECT SIGN(12) FROM DUAL; -- 1, +�϶�
SELECT SIGN(0) FROM DUAL; -- 0, 0�϶�
SELECT SIGN(-6) FROM DUAL; -- -1, -�϶�

--����
--TRUNC
SELECT TRUNC(12.34567) FROM DUAL; -- �Ҽ��� �ڸ� ����
SELECT TRUNC(12.34567 ,2) FROM DUAL; -- �Ҽ��� �ι�° ¥�������� �츲
SELECT TRUNC(12.34567 ,-1) FROM DUAL; 

--ASCII ���� �˻��̳� ���ڰ� ����� �ȵ�������� Ȯ�ο����� ���� �����
SELECT ASCII('A') FROM DUAL; 

--��ȯ
--TO_CHAR
--DATE -> VARCHAR2
SELECT TO_CHAR(SYSDATE) FROM DUAL; --���ڷ� �������� ���ڿ��� �� 20/12/04
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD-HH-MI-SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS') FROM DUAL;

SELECT TO_CHAR(TO_DATE(SYSDATE, 'YYYY/MM/DD HH:MI:SS'), 'YYYY/MM/DD HH:MI:SS') FROM DUAL;

SELECT SYSDATE FROM DUAL;

SELECT TO_CHAR(1000000000,'$999,999,999,999') FROM DUAL; --ǥ����� ����

-- TO DATE
-- VARCHAR2 -> DATE
SELECT TO_DATE('20201205') FROM DUAL;

SELECT TO_DATE('20201205','YYYYMMDD') FROM DUAL;
SELECT TO_DATE('12052020','MMDDYYYY') FROM DUAL;

--TO_NUMBER VARCHAR2 -> NUMBER  (JAVA : Integer.parseInt())
SELECT '123' + 1 FROM DUAL;
SELECT TO_NUMBER('123') + 1 FROM DUAL; -- �ش� �κ��� �������� ���

--LAST_DAY : ���� ������ ���� �� �� ����
SELECT LAST_DAY('20/12/01') FROM DUAL; 

-- SUBSTR            AbcDef substring(1,3) -> bc
--                          substring(4) -> ef
SELECT SUBSTR('ABCDEFG', 3) FROM DUAL; --CDEFG
SELECT SUBSTR('ABCDEFG', 3, 3) FROM DUAL; --CDE  (���ڿ�, ������ġ, ������ ����)
