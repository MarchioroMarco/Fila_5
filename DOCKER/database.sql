CREATE DATABASE IF NOT EXISTS Employees_Management;
USE Employees_Management;

DROP TABLE IF EXISTS nazioni;
CREATE TABLE nazioni (
  iso char(2) primary key,
  descrizione varchar(30) not null
);


DROP TABLE IF EXISTS regioni;
CREATE TABLE regioni (
  id integer primary key auto_increment,
  descrizione varchar(30),
  iso_nazione char(2),
  FOREIGN KEY (iso_nazione) REFERENCES nazioni(iso)
);


DROP TABLE IF EXISTS province;
CREATE TABLE province (
  id char(2) primary key,
  descrizione varchar(30),
  id_regione integer,
  FOREIGN KEY (id_regione) REFERENCES regioni(id)
);


DROP TABLE IF EXISTS citta;
CREATE TABLE citta (
  id integer primary key auto_increment,
  descrizione varchar(40),
  id_provincia char(2),
  FOREIGN KEY (id_provincia) REFERENCES province(id)
);



DROP TABLE IF EXISTS dipendenti;
CREATE TABLE dipendenti(
  nome varchar(20) not null,
  cognome varchar(20) not null,
  tax_code char(16) not null,
  indirizzo varchar(40),
  sesso char(1),
  email varchar(50),
  telefono varchar(20),
  id integer primary key auto_increment,
  iso_nazione char(2),
  id_regione integer,
  id_provincia char(2),
  id_citta integer,
  FOREIGN KEY (iso_nazione) REFERENCES nazioni(iso),
  FOREIGN KEY (id_regione) REFERENCES regioni(id),
  FOREIGN KEY (id_provincia) REFERENCES province(id),
  FOREIGN KEY (id_citta) REFERENCES citta(id)
);

DROP TABLE IF EXISTS utenti;
create table utenti (
id int not null AUTO_INCREMENT PRIMARY KEY, 
username varchar(50),
passw varchar(200), 
ruolo varchar(100)
);

insert into utenti values (null,'adrian_manuc','Utente1','admin');
insert into utenti values (null,'armin_saliu','Utente2','ADMIN');
insert into utenti values (null,'ferro_cristina','Utente3','ADMIN');
insert into utenti values (null,'marchioro_marco','Utente4','ADMIN');
insert into utenti values (null,'michael_brotto','Utente5','ADMIN');
INSERT INTO nazioni VALUES ('IT', 'Italia');
INSERT INTO nazioni VALUES ('FR', 'Francia');
INSERT INTO nazioni VALUES ('SP', 'Spagna');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Lombardia', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Veneto', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Sardegna', 'IT');
INSERT INTO province VALUES ('PD', 'Padova', '2');
INSERT INTO province VALUES ('VI', 'Vicenza', '2');
INSERT INTO province VALUES ('VR', 'Verona', '2');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Fontaniva', 'PD');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Camposampiero', 'PD');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Cittadella', 'PD');
INSERT INTO dipendenti (nome, cognome, tax_code, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Gigi','Rossi', 'GRSCFKDJEI293ODJ', 'via delle rose, 80', 'M', 'gigi.rossi@gmail.com', '+39 3304859286', 'IT', '2', 'PD', '1');
INSERT INTO dipendenti (nome, cognome, tax_code, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Mario','Verdi', 'GRSCFKDJEI293OBF', 'via delle fontane, 50', 'M', 'mario.verdi@gmail.com', '+39 3659874521', 'IT', '2', 'PD', '3');
INSERT INTO dipendenti (nome, cognome, tax_code, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Maria','Bianchi', 'GRSCFKDJEI293OLM', 'via roma, 5', 'F', 'maria.bianchi@gmail.com', '+39 9631548654', 'IT', '2', 'PD', '2');
