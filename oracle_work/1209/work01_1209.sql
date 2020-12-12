--38)��� ����� �޿��� �ְ��, ������, �Ѿ� �� ��վ��� ǥ���Ͻÿ�. �� ���̺��� 
--���� maximum,minimum,sum �� average�� �����ϰ� ����� ������ �ݿø��ϰ� ���ڸ� ������ ,�� ����Ͻÿ�.
SELECT TO_CHAR(MAX(sal), '999,999') AS maximum, TO_CHAR(MIN(sal),'999,999') AS minimum
        , TO_CHAR(SUM(sal),'999,999') AS sum, TO_CHAR(ROUND(AVG(sal)),'999,999') AS average
FROM emp;

--39) ������ ������ ��� ���� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�.
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB;

--40) emp���̺��� 30���μ��� ������� ���Ͻÿ�.
SELECT COUNT(*)
FROM EMP
GROUP BY deptno
HAVING deptno = 30;

--41) emp���̺��� ������ �ְ� ������ ���ϰ� ����,�ְ� ������ ����Ͻÿ�.
SELECT JOB, MAX(sal)
FROM emp
GROUP BY JOB;

--42) emp���̺��� 20���μ��� �޿� �հ踦 ���ϰ� �޿� �հ� �ݾ��� ����Ͻÿ�.
SELECT SUM(sal)
FROM EMP
GROUP BY deptno
HAVING deptno = 20;

--43) emp���̺��� �μ����� ���޵Ǵ� �ѿ��޿��� �ݾ��� 7,000�̻��� �μ���ȣ, �ѿ����� ����Ͻÿ�.
SELECT deptno, SUM(SAL)
FROM EMP
GROUP BY deptno
HAVING SUM(sal) >= 7000;

--44) emp���̺��� �������� ����� ���� ���� ����� ���ϰ� �� ��� ������ ����� 79�� �����ϴ� ����� �����ֽÿ�.
SELECT MAX(empno)
FROM emp
WHERE empno LIKE '79%'
GROUP BY JOB;

--45) emp���̺��� ������ �ѿ����� ����ϴµ� ������ 'MANAGER'�� ������� �����ϰ�  �ѿ����� 5,000���� ū ������ �ѿ��޸� ����Ͻÿ�.
SELECT JOB, SUM(sal)
FROM emp
WHERE JOB NOT LIKE 'MANAGER'
GROUP BY JOB
HAVING SUM(sal) > 5000;

--46)emp���̺��� �������� ������� 4�� �̻��� ������ �ο����� ����Ͻÿ�.
SELECT JOB, COUNT(*)
FROM emp
GROUP BY JOB
HAVING COUNT(*) >= 4;

--47)emp���̺��� ������� 5���� �Ѵ� �μ��� �μ���ȣ�� ������� ���Ͻÿ�.
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
HAVING COUNT(*) >= 5;

--48)emp���̺��� �μ��� �޿������ ���� �� �Ҽ��� 3�ڸ����� �ݿø��ؼ� 2�ڸ����� ���ϰ� �μ���ȣ, �޿������ ����Ͻÿ�.
SELECT deptno, ROUND(AVG(SAL), 2)
FROM emp
GROUP BY deptno;