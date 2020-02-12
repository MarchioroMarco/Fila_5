use Employees_Management;
create table utenti (id int not null AUTO_INCREMENT PRIMARY KEY, username varchar(50),passw varchar(50), config JSON);
insert into utenti values (null,'adrian_manuc','Utente1',null);
insert into utenti values (null,'armin_saliu','Utente2',null);
insert into utenti values (null,'ferro_cristina','Utente3',null);
insert into utenti values (null,'marchioro_marco','Utente4',null);
insert into utenti values (null,'michael_brotto','Utente5',null);