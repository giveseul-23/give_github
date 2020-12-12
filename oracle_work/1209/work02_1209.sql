
-- 50) ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp,dept)
SELECT e.ename, e.deptno, d.deptno, d.dname
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno;
    
--51) ������ MANAGER�� ����� ������ �̸�,����,�μ���,�ٹ��� ������ ����Ͻÿ�.(emp,dept)
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';

-- 52) Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�,�μ���,�ٹ����� ����Ͻÿ�
SELECT e.ename, d.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.sal >= 1600  
    AND e.comm <> 0
    AND e.comm IS NOT NULL;

-- 53) �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�.
SELECT e.ename, e.job, e.deptno, d.deptno, d.dname, d.loc
FROM emp e  INNER JOIN dept d
    ON e.deptno = d.deptno
WHERE d.loc = 'CHICAGO';

-- 54) �ٹ������� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���ü����� �����Ͻÿ�.
-- (�ٹ� �ο��� 0���� ���� ǥ��)
SELECT d.loc, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
    HAVING COUNT(e.empno) <= 5
ORDER BY COUNT(e.empno);

-- 55) ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����Ͻÿ�.
SELECT  a.ename as employee, a.mgr as emp#, b.ename as manager, b.empno as mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- 56) �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� 
-- �������� �̸� �� �Ի��ϰ� �Բ� ǥ���ϰ� �����ں��� �Ի����� ���� ����� �����϶�.
-- �� ���̺��� ���� employee, emp hired, manager, mgr hired�� ����
SELECT a.ename as employee, a.hiredate as "emp hired", b.ename as manager, b.hiredate as "mgr hired"
FROM emp a, emp b
WHERE a.hiredate < b.hiredate 
    AND a.mgr = b.empno;

-- 57) ����� �̸� �� �����ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����ϴµ� 
-- King�� �����Ͽ� �����ڰ� ���� ��� ����� ǥ���ϵ��� �ϰ� 
-- ����� �����ȣ�� �������� ����
SELECT a.ename AS employee, a.empno AS emp#, b.ename AS manager, b.empno AS mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno;

-- 58) ������ �μ���ȣ, ����̸� �� ������ ����� ������ �μ����� �ٹ��ϴ� ��� ����� ǥ���ϵ��� ���Ǹ� �ۼ��ϰ� 
-- �μ���ȣ�� department, ����̸��� employee, ������ �μ����� �ٹ��ϴ� ����� colleague�� ǥ���Ͻÿ�.
-- (�μ���ȣ, ����̸�,���� ������ �������� ����) 
SELECT a.deptno as department, a.ename as employee, b.ename as colleague
FROM emp a, emp b
WHERE a.deptno = b.deptno AND a.empno != b.empno
ORDER BY department, employee, colleague;

-- 59)10�� �μ����� �ٹ��ϴ� ������� �μ���ȣ, �μ��̸�, ����̸�, ����, �޿������ ����Ͻÿ�.
SELECT e.empno, d.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.sal BETWEEN s.losal and s.hisal
    AND e.deptno = 10;
    
SELECT e.empno, d.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e INNER JOIN dept d
    ON  e.deptno = d.deptno, salgrade s
WHERE e.sal BETWEEN s.losal and s.hisal
    AND e.deptno = 10