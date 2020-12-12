/*
37)DECODE �Ǵ� CASE WHEN THEN �Լ��� ����Ͽ� ���� �����Ϳ� ���� JOB���� ���� ��������
��� ����� ����� ǥ���Ͻÿ�.

����        ���
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
��Ÿ         0
*/
SELECT ENAME, JOB,
    CASE JOB
        WHEN 'PRESIDENT' THEN 'A'
        WHEN 'ANALYST' THEN 'B'
        WHEN 'MANAGER' THEN 'C'
        WHEN 'SALESMAN' THEN 'D'
        WHEN 'CLERK' THEN 'E'
        ELSE '0'
    END
FROM EMP;

SELECT ENAME, JOB,
    DECODE( JOB,
         'PRESIDENT', 'A',
         'ANALYST', 'B',
         'MANAGER', 'C',
         'SALESMAN', 'D',
         'CLERK', 'E',
         0 ) AS GRADE
FROM EMP;

-- 60) BLAKE�� ���� �μ��� �ִ� ������� �̸��� �Ի����� ���ϴµ� 
-- BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
SELECT ename, hiredate
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename = 'BLAKE')
    AND ename NOT IN('BLAKE');

-- 61) ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� 
-- ������ ���� ��������� ����Ͻÿ�.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT AVG(SAL) FROM EMP)
ORDER BY sal DESC;

-- 62) 10���μ����� �޿��� ���� ���� �޴� ����� ������ �޿��� �޴� ����� �̸��� ����Ͻÿ�.
SELECT ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp WHERE deptno LIKE '10');

-- 63) ������� 3���� �Ѵ� �μ��� �μ���� ������� ����Ͻÿ�. *��������� ȥ�� Ǯ��!
SELECT d.dname, COUNT(*)
FROM EMP e INNER JOIN dept d ON e.deptno = d.deptno
WHERE e.deptno IN (SELECT deptno FROM emp GROUP BY deptno HAVING COUNT(*) > 3)
GROUP BY d.dname;

-- 64) �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
SELECT ename, hiredate
FROM EMP
WHERE hiredate < (SELECT hiredate FROM emp WHERE empno = '7844');

-- 65) ���ӻ�簡 KING�� ��� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT ename, sal
FROM EMP
WHERE mgr IN (SELECT empno FROM EMP WHERE ename LIKE 'KING');

-- 66) 20�� �μ����� ���� �޿��� ���� �޴� ����� ������ �޿��� �޴� 
-- ����� �̸��� �μ���,�޿�, �޿������ ����Ͻÿ�.(emp, dept, salgrade) * ������ ���̺� JOIN�ϴ� ANSI SQL ���� �˾Ƶα�
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e
    INNER JOIN dept d
    ON e.deptno = d.deptno
    INNER JOIN salgrade s
    ON e.sal BETWEEN s.losal and s.hisal
WHERE sal IN (SELECT MAX(sal) FROM emp WHERE deptno = 20);

--67) �ѱ޿�sal+comm�� ��� �޿����� ���� �޿��� �޴� ����� �μ���ȣ, �̸�, �ѱ޿�, 
--    Ŀ�̼��� ����Ͻÿ�.(Ŀ�̼��� ��(O),��(X)�� ǥ���ϰ� �÷����� "comm����" ���) ***

SELECT empno, ename, sal + NVL(comm, '0') AS �ѱ޿�, NVL2(comm,'��','��') AS Ŀ�̼ǿ���
FROM emp
WHERE ename IN (SELECT ename FROM EMP WHERE sal + NVL(comm,'0') > (SELECT AVG(sal) FROM emp ));

-- 68) CHICAGO �������� �ٹ��ϴ� ����� ��� �޿����� ���� �޿��� �޴� 
-- ����� �̸��� �޿�, �������� ����Ͻÿ�.
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND sal > (SELECT AVG(e.sal) FROM EMP e, dept d WHERE e.deptno = d.deptno AND d.loc = 'CHICAGO');

-- 69) ������ SALESMAN�� ������ 2�� �̻��� �μ��� 
-- �̸�, �ٹ��ϴ� ����� �̸�, ������ ��� �Ͻÿ�.
-- (�÷����� �μ���, �����, ������ ���)

SELECT d.dname as �μ���, e.ename as �����, e.job as ����
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.deptno IN (SELECT deptno FROM emp WHERE job LIKE 'SALESMAN' GROUP BY deptno HAVING COUNT(*) >= 2 );

-- 70) Ŀ�̼��� ���� ����� �� ������ ���� ���� ����� �̸��� �޿������ ����Ͻÿ�.
SELECT e.ename, s.grade
FROM EMP e INNER JOIN salgrade s
    ON e.sal BETWEEN s.losal and s.hisal
WHERE e.sal IN (SELECT MAX(sal) FROM emp WHERE comm IS NULL OR comm = 0);

-- 71) SMITH�� �������� �̸��� �μ���, �ٹ������� ����Ͻÿ�. 
SELECT e.ename, d.dname, d.loc
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE e.empno IN (SELECT m.empno FROM emp e INNER JOIN emp m ON e.mgr = m.empno WHERE e.ename LIKE 'SMITH');

-- �ٸ� ���
SELECT e.ename, d.dname, d.loc
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE e.empno IN (SELECT mgr FROM emp  WHERE ename LIKE 'SMITH')