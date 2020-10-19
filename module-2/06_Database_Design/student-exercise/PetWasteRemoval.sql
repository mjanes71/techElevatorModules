--Assumptions:
--Each employee can be on multiple projects
--Projects can be cross-departmental
--Each project can have multiple employees
--Most often, there is more than one employee per department
--Therefore, projects are tied to employees, not departments
--Job titles are constantly changing, so there is not constraint on what a job title can be
--The company feels that gender is an unimportant and dated field. New hires are allowed to decline to disclose their gender so it is often null.

BEGIN TRANSACTION;

DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;

CREATE TABLE project(
    project_id serial,
    project_name varchar NOT NULL,
    start_date date,
    CONSTRAINT pk_project_id PRIMARY KEY (project_id)
);

CREATE TABLE employee(
    employee_id serial,
    job_title varchar,
    last_name varchar NOT NULL,
    first_name varchar NOT NULL,
    gender varchar,
    date_of_birth date NOT NULL,
    date_of_hire date NOT NULL,
    CONSTRAINT pk_employee_id PRIMARY KEY (employee_id)  
);

CREATE TABLE employee_project(
    project_id int NOT NULL,
    employee_id int NOT NULL,
    CONSTRAINT pk_project_id_employee_id PRIMARY KEY (project_id, employee_id)
);

CREATE TABLE department(
    department_id serial,
    department_name varchar NOT NULL,
    CONSTRAINT pk_department_id PRIMARY KEY (department_id)  
);

CREATE TABLE employee_department(
    department_id int NOT NULL,
    employee_id int NOT NULL,
    CONSTRAINT pk_department_id_employee_id PRIMARY KEY (department_id, employee_id),
    CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department (department_id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);

INSERT INTO project (project_id, project_name, start_date) VALUES (1, 'Middletown Business Building', '2020-01-01');
INSERT INTO project (project_id, project_name, start_date) VALUES (2, 'Middletown Service', '2020-02-01');
INSERT INTO project (project_id, project_name, start_date) VALUES (3, 'Customer Complaints', '2020-03-01');
INSERT INTO project (project_id, project_name, start_date) VALUES (4, 'Fairfield Business Building', '2020-04-01');

INSERT INTO department (department_id, department_name) VALUES (1, 'Sales');
INSERT INTO department (department_id, department_name) VALUES (2, 'Marketing');
INSERT INTO department (department_id, department_name) VALUES (3, 'Service');

INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (1, 'Pooper Scooper', 'Janes', 'Megan', '1989-01-12', '2019-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (2, 'Lead Pooper Scooper', 'Graff', 'Jessica', '1987-03-12', '2018-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (3, 'Director of Sales', 'Lebreck', 'Jessica', '1985-01-12', '2018-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (4, 'Customer Service Liason', 'Deganges', 'Chris', '1985-04-12', '2019-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (5, 'Director of Marketing', 'Janes', 'Kaylee', '1990-01-12', '2018-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (6, 'Social Media Marketer', 'Love', 'Carly', '1990-01-12', '2019-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (7, 'Pooper Scooper', 'Davies', 'Drew', '1991-01-12', '2020-01-01');
INSERT INTO employee (employee_id, job_title, last_name, first_name, date_of_birth, date_of_hire) VALUES (8, 'Pooper Scooper', 'Davies', 'Chris', '1991-01-12', '2020-01-01');

INSERT INTO employee_project (project_id, employee_id) VALUES (1, 5);
INSERT INTO employee_project (project_id, employee_id) VALUES (1, 6);
INSERT INTO employee_project (project_id, employee_id) VALUES (1, 1);
INSERT INTO employee_project (project_id, employee_id) VALUES (2, 1);
INSERT INTO employee_project (project_id, employee_id) VALUES (2, 2);
INSERT INTO employee_project (project_id, employee_id) VALUES (2, 7);
INSERT INTO employee_project (project_id, employee_id) VALUES (2, 8);
INSERT INTO employee_project (project_id, employee_id) VALUES (3, 3);
INSERT INTO employee_project (project_id, employee_id) VALUES (3, 4);
INSERT INTO employee_project (project_id, employee_id) VALUES (3, 2);
INSERT INTO employee_project (project_id, employee_id) VALUES (4, 5);
INSERT INTO employee_project (project_id, employee_id) VALUES (4, 6);
INSERT INTO employee_project (project_id, employee_id) VALUES (4, 7);
INSERT INTO employee_project (project_id, employee_id) VALUES (4, 8);

INSERT INTO employee_department (department_id, employee_id) VALUES (1, 3);
INSERT INTO employee_department (department_id, employee_id) VALUES (1, 4);
INSERT INTO employee_department (department_id, employee_id) VALUES (2, 5);
INSERT INTO employee_department (department_id, employee_id) VALUES (2, 6);
INSERT INTO employee_department (department_id, employee_id) VALUES (3, 1);
INSERT INTO employee_department (department_id, employee_id) VALUES (3, 2);
INSERT INTO employee_department (department_id, employee_id) VALUES (3, 7);
INSERT INTO employee_department (department_id, employee_id) VALUES (3, 8);

ALTER TABLE employee_project ADD FOREIGN KEY (project_id) REFERENCES project (project_id);
ALTER TABLE employee_project ADD FOREIGN KEY (employee_id) REFERENCES employee (employee_id);


COMMIT;