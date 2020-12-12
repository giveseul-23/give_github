--6) emp ���̺��� �����ȣ�� 7698 �� ����� �̸�, ����, �޿��� ����Ͻÿ�.
SELECT ename, JOB, sal
FROM emp
WHERE empno = 7698;

-- 7) emp ���̺��� ����̸��� SMITH�� ����� �̸��� ����, �μ���ȣ�� ���Ͻÿ�.
SELECT ename, sal, deptno
FROM emp
WHERE ename = 'SMITH';

-- 8) ������ 2500�̻� 3500�̸��� ����� �̸�, �Ի���, ������ ���Ͻÿ�.
SELECT ename, hiredate, sal FROM emp
WHERE sal>=2500 AND SAL<3500;

-- 9) �޿��� 2000���� 3000���̿� ���Ե��� �ʴ� ����� �̸�, ����, �޿��� ����Ͻÿ�.
SELECT ename, JOB, sal
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 3000;

-- 10) 81��05��01�ϰ� 81��12��03�� ���̿� �Ի��� ����� �̸�, �޿�, �Ի����� ����Ͻÿ�.
SELECT ename, sal, hiredate
FROM EMP
WHERE hiredate >= '81/05/01' AND hiredate <= '81/12/03';
-- WHERE hiredate BETWEEN '81/05/01' AND '81/12/03'

-- 11) emp���̺��� �����ȣ�� 7566,7782,7934�� ����� ������ ������� �����ȣ,�̸�,
--    ������ ����Ͻÿ�.
SELECT empno, ename, sal
FROM EMP
WHERE empno NOT IN(7566,7782,7934);

-- 12) �μ���ȣ 30(deptno)���� �ٹ��ϸ� �� 2,000�޷� ���ϸ� �޴� 81��05��01�� ������ �Ի��� ����� �̸�, �޿�, �μ���ȣ, �Ի����� ����Ͻÿ�.
SELECT ename, sal, empno, hiredate
FROM EMP
WHERE deptno = 30 
    AND sal <= 2000 
        AND hiredate < '81/05/01';

-- 13) emp���̺��� �޿��� 2,000�� 5,000 ���̰� �μ���ȣ�� 10 �Ǵ� 30�� ����� �̸��� �޿�,�μ���ȣ�� �����Ͻÿ�.
SELECT ename, sal, deptno
FROM EMP
WHERE (sal BETWEEN 2000 AND 5000)
        AND (deptno = 10 OR deptno = 30);

-- 14) ������ SALESMAN �Ǵ� MANAGER�̸鼭 �޿��� 1,600, 2,975 �Ǵ� 2,850�� (�ƴ�) ��� ����� �̸�, ���� �� �޿��� ǥ���Ͻÿ�.
SELECT ename, job, sal
FROM EMP
WHERE (job = 'SALESMAN' OR job = 'MANAGER')
        AND sal NOT IN(1600, 2975, 2850);
    
-- 15) emp���̺��� ����̸� �� S�� ���Ե��� ���� ����� �� �μ���ȣ�� 20�� ������� �̸��� �μ���ȣ�� ����Ͻÿ�.
SELECT ename, deptno
FROM EMP
WHERE ename NOT LIKE '%S%' AND deptno = 20;

-- 16) emp���̺��� �̸��� A�� E�� �ִ� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ename
FROM EMP
WHERE ename LIKE '%A%' AND ename LIKE '%E%';

-- 17) emp���̺��� �����ڰ� ���� ��� ����� �̸��� ������ ǥ���Ͻÿ�.
SELECT ename, JOB
FROM EMP
WHERE MGR IS NULL;

-- 18) emp���̺��� Ŀ�̼� �׸��� �Էµ� ������� �̸��� �޿�, Ŀ�̼��� ���Ͻÿ�.
SELECT ename, sal, comm
FROM EMP
WHERE comm IS NOT NULL and comm <> 0;