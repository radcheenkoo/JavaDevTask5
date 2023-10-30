INSERT INTO worker(id,name,birthday,level,salary) VALUES(1, 'John Doe', '1990-05-15', 'Trainee', 800),(2, 'Jane Smith', '1985-03-20', 'Junior', 1200),(3, 'Robert Johnson', '1992-08-10', 'Middle', 2500),(4, 'Emily Davis', '1988-02-28', 'Middle', 2800),(5, 'Michael Wilson', '1983-11-15', 'Senior', 6000),(6, 'Sarah Brown', '1995-07-03', 'Trainee', 900),(7, 'David Lee', '1991-09-25', 'Junior', 1300),
    (8, 'Lisa Anderson', '1987-04-12', 'Middle', 2700),
    (9, 'William Clark', '1984-06-19', 'Senior', 6200),
    (10, 'Olivia Hall', '1994-12-05', 'Middle', 2600);

INSERT INTO client (id,name) VALUES(1,'Alice'),(2,'Bob'),(3,'Eve'),(4,'Charlie'),(5,'Daniel');

INSERT INTO project(id,client_id, start_date, finish_date) VALUES(1, 1, '2023-01-15', '2024-03-20'),(2,1, '2023-05-10', '2024-02-28'),(3, 2, '2023-07-20', '2024-01-10'),(4, 2, '2023-03-01', '2023-08-15'),(5, 3, '2023-06-05', '2024-06-04'),(6, 3, '2023-02-10', '2023-12-31'),(7, 4, '2023-09-01', '2024-09-30'),(8, 4, '2023-04-15', '2023-11-30'),(9, 5, '2023-08-20', '2024-07-15'),(10, 5, '2023-11-01', '2024-03-31');
INSERT INTO project_worker(project_id, worker_id) VALUES(1, 1), (1, 2), (1, 3),(2, 4), (2, 5),(3, 6), (3, 7),(4, 8), (4, 9),(5, 10);
