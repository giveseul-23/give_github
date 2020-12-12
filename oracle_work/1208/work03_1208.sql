--����1) EMPLOYEES ���̺��� ������ ��� SA�� ���Ͽ� �޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
GROUP BY job_id
HAVING job_id LIKE 'SA%';

--����2) EMPLOYEES
--���̺��� �μ����� �ο���, ��� �޿�, �����޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT department_id, COUNT(*), AVG(salary), MIN(salary), MAX(salary), SUM(salary)
FROM employees
GROUP BY department_id;

--����3) EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

--����4) EMPLOYEES ���̺��� �޿��� "�ִ� 10000�̻��� �μ�"�� ���ؼ� �μ���ȣ, ��� �޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, AVG(salary), SUM(salary)
FROM employees
GROUP BY department_id 
HAVING MAX(salary) >= 10000;

--����5) EMPLOYEES ���̺��� "��ü ������ 10000�� �ʰ��ϴ� �� ����"�� ���ؼ� ������ ���޿� �հ踦 ����϶�. 
--�� �Ǹſ�(SA)�� �����ϰ� �� �޿� �հ�� ����(��������)�϶�.
SELECT DISTINCT job_id, SUM(salary)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING SUM(salary) > 10000
ORDER BY SUM(salary) DESC;