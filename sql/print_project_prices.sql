SELECT p.id,
    SUM(w.salary * EXTRACT(MONTH FROM AGE(p.finish_date, p.start_date))) AS price
FROM project p
JOIN project_worker pw ON p.id = pw.project_id
JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id
ORDER BY price DESC;