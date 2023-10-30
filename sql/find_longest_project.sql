SELECT id,EXTRACT(MONTH FROM finish_date) - EXTRACT(MONTH FROM start_date) AS months_difference
From project p
WHERE (EXTRACT(MONTH FROM finish_date) - EXTRACT(MONTH FROM start_date)) = (
    SELECT MAX(EXTRACT(MONTH FROM finish_date) - EXTRACT(MONTH FROM start_date))
    FROM project
);