CREATE TABLE Biblioteka (
  idBiblioteke NUMBER PRIMARY KEY,
  naziv VARCHAR2(100),
  adresa VARCHAR2(255),
  vrsta VARCHAR2(50)
);

CREATE TABLE Clan (
  idClana NUMBER PRIMARY KEY,
  ime VARCHAR2(50),
  prezime VARCHAR2(50)
);

CREATE TABLE Komisija (
  idKomisije NUMBER PRIMARY KEY,
  naziv VARCHAR2(100),
  opis VARCHAR2(255)
);

CREATE TABLE Sastav (
  idClana NUMBER,
  idKomisije NUMBER,
  pozicija VARCHAR2(50),
  PRIMARY KEY (idClana, idKomisije),
  FOREIGN KEY (idClana) REFERENCES Clan(idClana),
  FOREIGN KEY (idKomisije) REFERENCES Komisija(idKomisije)
);

CREATE TABLE Revizija (
  idRevizije NUMBER PRIMARY KEY,
  datumPocetka DATE,
  datumZavrsetka DATE,
  zakon VARCHAR2(255),
  gradja VARCHAR2(255),
  idKomisije NUMBER,
  idBiblioteke NUMBER,
  FOREIGN KEY (idKomisije) REFERENCES Komisija(idKomisije),
  FOREIGN KEY (idBiblioteke) REFERENCES Biblioteka(idBiblioteke)
);

CREATE TABLE UpravniOdbor (
  idUpravnogOdbora NUMBER PRIMARY KEY,
  brojClanova NUMBER,
  idBiblioteke NUMBER,
  FOREIGN KEY (idBiblioteke) REFERENCES Biblioteka(idBiblioteke)
);

CREATE TABLE OdlukaUsvajanja (
  idOdluke NUMBER PRIMARY KEY,
  datum DATE,
  brojZaZalbe NUMBER,
  idOsobe NUMBER,
  idRevizije NUMBER,
  idBiblioteke NUMBER,
  FOREIGN KEY (idOsobe) REFERENCES Osoba(idOsobe),
  FOREIGN KEY (idRevizije) REFERENCES Revizija(idRevizije),
  FOREIGN KEY (idBiblioteke) REFERENCES Biblioteka(idBiblioteke)
);

CREATE TABLE Osoba (
  idOsobe NUMBER PRIMARY KEY,
  ime VARCHAR2(50),
  prezime VARCHAR2(50)
);

CREATE TABLE Publikacija (
  idP NUMBER PRIMARY KEY,
  naziv VARCHAR2(100),
  cena NUMBER,
  brojStrana NUMBER,
  idTipa NUMBER,
  FOREIGN KEY (idTipa) REFERENCES Tip(idTipa)
);

CREATE TABLE MonografskaPublikacija (
  idP NUMBER PRIMARY KEY,
  idMono NUMBER,
  vrstaPoveza VARCHAR2(50),
  stanje VARCHAR2(50),
  idFonda NUMBER,
  FOREIGN KEY (idP) REFERENCES Publikacija(idP),
  FOREIGN KEY (idFonda) REFERENCES Fond(idFonda)
);

CREATE TABLE SerijskaPublikacija (
  idP NUMBER PRIMARY KEY,
  idS NUMBER,
  vrsta VARCHAR2(50),
  idFonda NUMBER,
  FOREIGN KEY (idP) REFERENCES Publikacija(idP),
  FOREIGN KEY (idFonda) REFERENCES Fond(idFonda)
);

CREATE TABLE Inventar (
  idInventara NUMBER PRIMARY KEY,
  opis VARCHAR2(255)
);

CREATE TABLE StavkaInventara (
  idInventara NUMBER,
  rbStavke NUMBER,
  kolicina NUMBER,
  idP NUMBER,
  PRIMARY KEY (idInventara, rbStavke),
  FOREIGN KEY (idInventara) REFERENCES Inventar(idInventara),
  FOREIGN KEY (idP) REFERENCES Publikacija(idP)
);

CREATE TABLE Izvestaj (
  idIzvestaja NUMBER PRIMARY KEY,
  brojJedinicaUElKatalogu NUMBER,
  idRevizije NUMBER,
  FOREIGN KEY (idRevizije) REFERENCES Revizija(idRevizije)
);

CREATE TABLE MonografskiIzvestaj (
  idIzvestaja NUMBER PRIMARY KEY,
  sifraM VARCHAR2(50),
  FOREIGN KEY (idIzvestaja) REFERENCES Izvestaj(idIzvestaja)
);

CREATE TABLE SerijskiIzvestaj (
  idIzvestaja NUMBER PRIMARY KEY,
  sifraS VARCHAR2(50),
  FOREIGN KEY (idIzvestaja) REFERENCES Izvestaj(idIzvestaja)
);

CREATE TABLE Jedinica (
  idIzvestaja NUMBER,
  status VARCHAR2(50),
  broj NUMBER,
  PRIMARY KEY (idIzvestaja),
  FOREIGN KEY (idIzvestaja) REFERENCES Izvestaj(idIzvestaja)
);

CREATE TABLE OtpisMonografskihPublikacija (
  idIzvestaja NUMBER,
  idOtpisaM NUMBER PRIMARY KEY,
  manjak NUMBER,
  skart NUMBER,
  FOREIGN KEY (idIzvestaja) REFERENCES Izvestaj(idIzvestaja)
);

CREATE TABLE OtpisSerijskihPublikacija (
  idIzvestaja NUMBER,
  idOtpisaS NUMBER PRIMARY KEY,
  manjak NUMBER,
  FOREIGN KEY (idIzvestaja) REFERENCES Izvestaj(idIzvestaja)
);

CREATE TABLE Tip (
  idTipa NUMBER PRIMARY KEY,
  status VARCHAR2(50)
);

CREATE TABLE IzdanjeKnjige (
  idIzdanja NUMBER PRIMARY KEY,
  idP NUMBER,
  opis VARCHAR2(255),
  vrednost VARCHAR2(50),
  FOREIGN KEY (idP) REFERENCES Publikacija(idP)
);

CREATE TABLE Fond (
  idFonda NUMBER PRIMARY KEY,
  naziv VARCHAR2(100)
);

ALTER TABLE Revizija ADD nazivBiblioteke VARCHAR2(255);

-------------------------
--DISTINCT TIP PODATAKA--
-------------------------

CREATE OR REPLACE TYPE kod_Clana AS OBJECT(
    kodClana varchar2(13),
    CONSTRUCTOR FUNCTION kod_Clana(kodClana varchar2) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_kodClana RETURN varchar2
)FINAL;

CREATE OR REPLACE TYPE BODY kod_Clana AS
    CONSTRUCTOR FUNCTION kod_Clana(kodClana varchar2) RETURN SELF AS RESULT IS
    BEGIN
    IF NOT length(kodClana) = 13
        THEN raise_application_error(-20000, 'Kod clana mora da sadrzi 13 karaktera');
    ELSE
        SELF.kodClana := kodClana;
        END IF;
        RETURN;
    END kod_Clana;    
    
    MEMBER FUNCTION get_kodClana RETURN VARCHAR2 AS 
        BEGIN
            RETURN substr(self.kodClana, 1, 6) || '-' || substr(self.kodClana, 7);
        END get_kodClana; 
    END;
    
    ALTER TABLE CLAN
    ADD kodClana kod_Clana;
    
    INSERT INTO CLAN VALUES(1, 'Mika', 'Mikic', kod_Clana('QWED3EW5AW12A'));
    
    SELECT c.ime,c.prezime, c.kodClana.get_kodClana()
    FROM CLAN c;
    
-----------------------------
--STRUKTUIRANI TIP PODATAKA--
-----------------------------  
    
CREATE OR REPLACE TYPE kontakt_osobe AS OBJECT (
    telefon VARCHAR2(20),
    email VARCHAR2 (50),
    CONSTRUCTOR FUNCTION kontakt_osobe(telefon VARCHAR2, email VARCHAR2) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_telefon RETURN VARCHAR2,
    MEMBER FUNCTION get_email RETURN VARCHAR2
) INSTANTIABLE NOT FINAL;

CREATE OR REPLACE TYPE BODY kontakt_osobe AS
    CONSTRUCTOR FUNCTION kontakt_osobe (
    telefon VARCHAR2,
    email VARCHAR2
    ) RETURN SELF AS RESULT IS
    BEGIN
        IF NOT length(telefon) = 10 
        THEN raise_application_error(-20000, 'Broj telefona mora imati 10 cifara');
    ELSE
    IF REGEXP_LIKE (email, '\.') AND REGEXP_LIKE (email, '@') 
    THEN
        self.telefon := telefon;
        self.email:= email;
    ELSE
    raise_application_error(-20000, 'Email adresa nije validna'); 
    END IF;
    END IF;
    RETURN;
    END kontakt_osobe;
    
    MEMBER FUNCTION get_telefon RETURN VARCHAR2 IS
    BEGIN
        RETURN substr(self.telefon, 1, 3) || '/' || substr(self.telefon, 4, 3) || '-' || substr(self.telefon, 7);
    END;

    MEMBER FUNCTION get_email RETURN VARCHAR2 IS
    BEGIN
        RETURN self.email;
    END;
END;
    
ALTER TABLE OSOBA ADD kontakt KONTAKT_OSOBE;
    
INSERT INTO OSOBA VALUES(2, 'Milica', 'Pavlovic', kontakt_osobe('0632543399', 'milicap@gmail.com'));    
    
SELECT o.ime, o.prezime, o.kontakt.get_telefon(), o.kontakt.get_email()
FROM Osoba o;
    
-----------------------------------------    
-----------------------------------------
-----------------------------------------

-----------------------------------------    
-----------PROVERA TRIGGERA--------------
-----------------------------------------

CREATE GLOBAL TEMPORARY TABLE temp_trigger_state (
  pomocna_promenljiva NUMBER(1)
) ON COMMIT PRESERVE ROWS;

------------------
------2NF---------
------------------

INSERT INTO Komisija (idKomisije, naziv, opis) VALUES (1, 'Odbor za reviziju', 'Odbor za reviziju u biblioteci');
INSERT INTO Biblioteka (idBiblioteke, naziv, adresa, vrsta) VALUES (1, 'Gradska biblioteka', 'Adresa 1', 'Javna');

ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';

INSERT INTO Revizija VALUES (1, '2023-01-01', '2023-01-10', 'Zakon1', 'Gradja1', 1, 1, 'Gradska biblioteka');

--ALTER TRIGGER UPDATE_FROM_REVIZIJA ENABLE;
--ALTER TRIGGER UPDATE_FROM_REVIZIJA DISABLE;

UPDATE Biblioteka
SET naziv = 'Skolska biblioteka'
WHERE idBiblioteke = 1;

UPDATE Revizija
SET nazivBiblioteke = 'Gradska biblioteka'
WHERE idRevizije = 1;

INSERT INTO Revizija(idRevizije, datumPocetka, datumZavrsetka, zakon, gradja, idKomisije, idBiblioteke) VALUES (2, '2023-01-01', '2023-01-10', 'Zakon1', 'Gradja1', 1, 1);

------------------
------3NF---------
------------------

CREATE GLOBAL TEMPORARY TABLE temp_trigger_state_3NF (
  pomocna_promenljiva_3NF NUMBER(1)
) ON COMMIT PRESERVE ROWS;

--ALTER TRIGGER UPDATE_IDREVIZIJE_OTPIS ENABLE;
--ALTER TRIGGER UPDATE_IDREVIZIJE_OTPIS DISABLE;

INSERT INTO Izvestaj (idIzvestaja, brojJedinicaUElKatalogu, idRevizije) VALUES (1, 100, 1);
INSERT INTO Izvestaj (idIzvestaja, brojJedinicaUElKatalogu, idRevizije) VALUES (2, 345, 1);
INSERT INTO Izvestaj (idIzvestaja, brojJedinicaUElKatalogu, idRevizije) VALUES (3, 34513, 2);
INSERT INTO Izvestaj (idIzvestaja, brojJedinicaUElKatalogu, idRevizije) VALUES (4, 1, 1);

UPDATE Izvestaj
SET idRevizije = 2
WHERE idIZvestaja = 1;

INSERT INTO MonografskiIzvestaj (idIzvestaja, sifraM) VALUES (1, 'SIFRA1');
INSERT INTO OtpisMonografskihPublikacija (idIzvestaja, idOtpisaM, manjak, skart) VALUES (1, 1, 25, 13);
INSERT INTO OtpisMonografskihPublikacija (idIzvestaja, idOtpisaM, manjak, skart) VALUES (2, 2, 25123, 132);
INSERT INTO OtpisMonografskihPublikacija (idIzvestaja, idOtpisaM, manjak, skart) VALUES (3, 3, 123, 11);
INSERT INTO OtpisMonografskihPublikacija (idIzvestaja, idOtpisaM, manjak, skart) VALUES (4, 3, 1232, 112);



UPDATE Izvestaj
SET idRevizije = 1
WHERE idRevizije = 2;

UPDATE OtpisMonografskihPublikacija
SET idRevizije = 2
WHERE idRevizije = 1;

UPDATE OtpisMonografskihPublikacija
SET idIzvestaja = 4
WHERE idIzvestaja = 1;

Select *
from pomocna_tabela_2NF;

INSERT INTO temp_trigger_state_3NF VALUES (0);
INSERT INTO temp_trigger_state VALUES (0);

 Select *
from izvestaj;

-- Kreirajte trajnu tabelu na osnovu privremene
CREATE TABLE pomocna_tabela_2NF AS SELECT * FROM temp_trigger_state;
CREATE TABLE pomocna_tabela_3NF AS SELECT * FROM temp_trigger_state_3NF;

-- Sada možete koristiti temp_trigger_state kao trajnu tabelu

-- Obrišite privremenu tabelu
DROP TABLE temp_trigger_state;
DROP TABLE temp_trigger_state_3NF;


