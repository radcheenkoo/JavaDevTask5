SELECT c.name AS client_name, COUNT(p.id) AS num_projects FROM client c LEFT JOIN project p ON c.id = p.client_id GROUP BY c.name ORDER BY COUNT(p.id) DESC LIMIT 1;
