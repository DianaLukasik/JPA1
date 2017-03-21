insert into book (id, title) values (1, 'Pierwsza książka');
insert into book (id, title) values (2, 'Druga książka');
insert into book (id, title) values (3, 'Trzecia książka');

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');

insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (1, 8);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);


-- DEPARTMENT
insert into department (name, email, home_phone, mobile_phone) values ('Finanse','finanse@comp.com','111111', '33333333');
insert into department (name, email, home_phone, mobile_phone) values ('Auto', 'auto@comp.com', '2222222', '99999999');
insert into department (name, email, home_phone, mobile_phone) values ('HR','hr@comp.com', '44444444', '88888888');
insert into department (name, email, home_phone, mobile_phone) values ('Logistyka','logistyka@comp.com', '55555555', '66666666');

-- EMPLOYEE
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1990-01-03','abc@aa.pl', '757173456','888888888','Andrzej','90123155678','Nowak', 1);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1988-11-03','gigi@aa.pl', '668173336','234567890','Heniek','88120199874','Kowalski', 2);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1978-10-03','bbb@xa.pl', '538873391','237887890','Charissa','89920199874','Skórski',3);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1975-08-05','hjk@xa.pl', '534233396','218887890','Jacklyn','87129879874','Fiedorowicz',4);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1943-10-12','dsa@xa.pl', '538192446','298887890','Avery','87120197544','Idczak',4);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1987-10-03','jhg@mk.pl', '538173396','488887890','Marco','87120199874','Wołowiec',3);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1969-09-23','klx@xa.pl', '658173311','244887890','Emory','87120193245','Gronowski',4);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1990-11-15','wew@jh.pl', '538173396','238887890','Sherri','87120199094','Pomorski',3);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1959-08-03','ryf@xa.pl', '538173388','276887890','Margarite','87120199874','Abmalewski',2);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1967-12-31','nnn@xa.pl', '598154396','238887890','Hollis','87120199874','Felczak',3);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1985-04-03','rhg@xa.pl', '538176596','238800000','Nu','87120199874','GFzeszczuk',1);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1980-02-03','hgg@xa.pl', '538173396','237787890','Jodie','88887699874','Wosik',1);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1991-11-09','jka@xa.pl', '567173386','238866640','Viva','87120865474','Rybak',3);
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1978-10-03','qzl@xa.pl', '599177876','238887890','Leandra','89920199874','Wandzel',2);

-- PROJECT TYPE
insert into project_type (name) values ('Wewnetrzny');
insert into project_type (name) values ('Zewnetrzny');



--PROJECTS
INSERT INTO projects (project_name, id_project_type, menager_id) VALUES ('First Project', 1, 6), ('Second Project', 2, 5), ('Third Project', 1, 4), ('Fourth Project', 2, 3), ('Fifth Project', 2, 1);



-- job position
insert into job_position (job_position_name) values ('PL');
insert into job_position (job_position_name) values ('TCD');
insert into job_position (job_position_name) values ('FCD');
insert into job_position (job_position_name) values ('DEV');

--PROJECTS
INSERT INTO projects (project_name, id_project_type, menager_id) VALUES ('First Project', 1, 6), ('Second Project', 2, 5), ('Third Project', 1, 4), ('Fourth Project', 2, 3), ('Fifth Project', 2, 1);

-- EMPLOYEEandPROJECT
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2016-07-01', null, 200, 2, 3, 1);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2011-07-01', null, 500, 13, 3, 4);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2014-01-01', '2016-05-14', 100, 9, 5, 2);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2016-03-03', null, 200, 5, 2, 3);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2015-08-23', '2017-02-14', 150, 7, 3, 4);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2017-01-01', '2017-03-01', 50, 8, 2, 1);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2016-03-12', '2016-09-18', 180, 6, 4, 2);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2015-02-06', '2017-01-13', 200, 3, 2, 3);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2012-07-01', '2014-07-18', 170, 10, 2, 4);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2010-09-01', '2015-01-11', 180, 9, 3, 2);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2013-03-05', null, 100, 1, 2, 2);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2016-11-01', '2016-12-15', 190, 13, 1, 2);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2016-07-01', null, 200, 5, 1, 3);
insert into employee_and_project (date_from, date_to, salary, id_employee, id_project, id_job_position) values ('2015-03-01', '2016-10-29', 190, 4, 1, 4);
