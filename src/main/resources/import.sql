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
insert into employee (birth_date, email, home_phone, mobile_phone, name, pesel, surname, id_department) values ('1988-11-03','gigi@aa.pl', '778173336','234567890','Heniek','88120199874','Kowalski', 2);