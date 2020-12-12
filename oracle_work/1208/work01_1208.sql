-- 23) emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ����Ͻÿ�.
SELECT INITCAP(job) FROM EMP;

-- 24) emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
SELECT SUBSTR(ENAME,1,3) FROM EMP
WHERE ENAME LIKE ('%A%');


-- 25) �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ���Ͻÿ�. *****
SELECT ename
FROM EMP
WHERE ename LIKE '__A%';
--WHERE SUBSTR(ename, 3, 1) = 'A'

-- 26) �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ�
-- ǥ��) �� �̸��� ���̸� ǥ���Ͻÿ�.(�� ���̺��� name�� length�� ǥ��)
SELECT INITCAP(ename) AS "name", LENGTH(ename) AS "length" 
FROM EMP
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR ename LIKE 'M%';

-- 27) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT LOWER(ENAME)
FROM EMP
WHERE LENGTH(ENAME) >= 6 ;

-- 28) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT LOWER(SUBSTR(ename,1,3)) FROM EMP
WHERE LENGTH(ENAME) >= 6;

-- 29) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�. �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� �������� 
-- ǥ���ϰ� �����̺��� SALARY�� �����Ͻÿ�. *****
SELECT ename, LPAD(sal, 15, '$') AS "SALARY"
FROM EMP;

-- 30) ���ú��� �̹����� �������������� ���� �� ���� ���Ͻÿ�. *****
SELECT LAST_DAY(SYSDATE) - SYSDATE
FROM DUAL;

-- 31) emp���̺��� �� ����� ���� �����ȣ, �̸�, �޿� �� 15% �λ�� �޿��� ����(�ݿø�)�� ǥ���Ͻÿ�.
-- �λ�� �޿����� ���̺��� New Salary�� �����Ͻÿ�.
SELECT empno, ename, sal, ROUND(sal * 1.15) AS "New Salary"
FROM  EMP;

-- 32) emp���̺��� ������ 4�� ���(mod(sal,4)=0)�� ����� �̸��� ������ ����Ͻÿ�.(���ڸ� ���� ��ǥ ǥ��)
SELECT ename, TO_CHAR(sal,'999,999,999,999')
FROM EMP
WHERE mod(sal,4)=0;

-- 33) �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �޼�)�� ����Ͽ�
-- �� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. ����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ��� ����
-- �������� ������������ �����Ͻÿ�.
SELECT ename, ROUND(MONTHS_BETWEEN(SYSDATE,hiredate)) AS "MONTHS_WORKED" 
FROM EMP
ORDER BY MONTHS_WORKED;

-- SYSDATE - hiredate : �ٹ� �ϼ�
-- (SYSDATE - hiredate) / 7 : �ٹ� �ּ�
-- MONTH_BETWEEN(SYSDATE - hiredate) : �ٹ� �޼�

-- 34)emp���̺��� �̸�, ����, �ٹ������� ����Ͻÿ�.
SELECT ename, job, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)/12) AS �ٹ�����
FROM EMP;

-- 35)emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ���.
-- ��, NULL���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�. ***��ġ ����
SELECT ename, sal, sal + NVL(comm , 0) AS "�Ǳ޿�"
FROM EMP;

-- 36)���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�,����,����,Ŀ�̼�,��볯¥�� ����Ͻÿ�. 
-- ��, ��볯¥�� 1980-12-17 ���·� ����Ͻÿ�.
SELECT ename, job, sal, comm, TO_CHAR(hiredate,'YYYY-MM-DD')
FROM EMP
WHERE (sal + NVL(comm, 0)) >= 2000
