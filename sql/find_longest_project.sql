SELECT id, EXTRACT(MONTH FROM finish_date) - EXTRACT(MONTH FROM start_date) AS months_difference FROM project ORDER BY months_difference DESC LIMIT 1;
