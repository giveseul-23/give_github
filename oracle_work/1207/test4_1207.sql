-- 19) emp ���̺��� �����ȣ, ����̸�, �Ի����� ����ϴµ� 
-- �Ի����� ���� ��������� �����Ͻÿ�.
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate;

-- 20) emp ���̺��� ����̸�, �޿�, ������ ���ϰ� ������ ���� ������ �����Ͻÿ�.
SELECT ename, sal, sal*12
FROM EMP
ORDER BY sal *12 DESC;

SELECT ename, sal, sal*12 as ����
FROM EMP
ORDER BY ���� DESC; -- alias�� �̿��ؼ� ��뵵 �����ϴ�

--21)10�� �μ��� 20���μ����� �ٹ��ϰ� �ִ� ����� �̸��� �μ���ȣ�� ����ϴµ� 
-- �̸��� �����ڼ����� ǥ���Ͻÿ�.
SELECT ename, deptno
FROM emp
WHERE deptno= 10 OR deptno = 20
ORDER BY ename ASC;

--22) Ŀ�̼��� �޴� ��� ����� �̸�,�޿� �� 
-- Ŀ�̼��� Ŀ�̼��� �������� ������������ �����Ͽ� ǥ���Ͻʽÿ�.
SELECT ename, sal, comm
FROM EMP
WHERE comm IS NOT NULL
    AND comm != 0
ORDER BY comm DESC;