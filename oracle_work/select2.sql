select * FROM emp;

-- ���� ��Ű���� ���̺� ��� ��ü ��ȸ
select * FROM tab; 

-- ���̺��� �÷� ���
DESC emp;

-- ���ϴ� �κи� �����ȸ
SELECT empno, ename, sal FROM emp;

--dual : �������̺�
SELECT SYSDATE FROM DUAL;
SELECT 4 * 7 FROM DUAL;
SELECT '4' * 7 FROM DUAL;
SELECT '4' * '7' FROM DUAL;
SELECT 'HELLO' || ' ' || 'ORACLE' FROM DUAL;
SELECT ROUND(10.5) FROM DUAL;

SELECT ename, sal, sal*12 FROM emp;


-- alias(�÷�����)
SELECT ename AS �̸�, sal AS ����, sal*12 AS ���� FROM emp;

-- distint : �ߺ��� ����(�ߺ��Ǵ� �����Ͱ� ������) --> group by 
SELECT DISTINCT Deptno FROM emp;

SELECT DISTINCT job FROM emp;

-- 1) 
SELECT empno, ename, sal FROM emp;
-- 2)
SELECT ename as "�� ��", sal as "�� ��" FROM emp; -- as �ڿ� �׸���� ''�ȿ� ������ �ȵǰ� ""���� �����
-- 3)
SELECT empno "�����ȣ", ename "����̸�", sal "����", sal*12 "����" FROM emp;
-- 4)
SELECT DISTINCT job from emp;
-- 5)
SELECT ename || ', ' ||job as "Employee and Job" from emp;