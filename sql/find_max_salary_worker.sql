SELECT name,salary
FROM worker
where salary = (select max(salary) from worker w);