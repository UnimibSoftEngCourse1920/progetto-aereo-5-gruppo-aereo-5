CREATE TABLE `Volo` (
  `codice_volo` VARCHAR(8) NOT NULL,
  `aereo` VARCHAR(45) NOT NULL,
  `città_partenza` VARCHAR(45) NOT NULL,
  `città_arrivo` VARCHAR(45) NOT NULL,
  `data_partenza` DATE NOT NULL,
  `data_arrivo` DATE NOT NULL,
  `ora_partenza` TIME NOT NULL,
  `ora_arrivo` TIME NOT NULL,
  `KmTratta` FLOAT NOT NULL,
  `prezzo` FLOAT NOT NULL,
  `puntiOttenuti` INT NOT NULL,
  PRIMARY KEY (`codice_volo`));
  
  -- -----------------------------------------------------
-- Table `Utente`
-- -----------------------------------------------------
CREATE TABLE `Utente` (
  `id` INT auto_increment NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `dataNascita` DATE(45) NULL,
  `ultimoAcquisto` DATE NULL,
  `indirizzoCasa` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `infedele` BOOLEAN NULL DEFAULT FALSE,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `Prenotazione`
-- -----------------------------------------------------
CREATE TABLE `Prenotazione` (
  `codicePrenotazione` INT NOT NULL,
  `dataScadenza` DATE NOT NULL,
  `dataPrenotazione` DATE NOT NULL,
  `penaleModifica` FLOAT NULL,
  `utente` INT NOT NULL,
  PRIMARY KEY (`codicePrenotazione`),
  CONSTRAINT `utentePrenotazione` FOREIGN KEY (`utente`) REFERENCES `Utente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `Posto`
-- -----------------------------------------------------
CREATE TABLE `Posto` (
  `idPosto` INT NOT NULL,
  `fila` INT NOT NULL,
  `lettera` CHAR NOT NULL,
  `prenotazione` INT NULL,
  `volo` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idPosto`),
  CONSTRAINT `voloPosto` FOREIGN KEY (`volo`) REFERENCES `Volo` (`codice_volo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `prenotazionePosto` FOREIGN KEY (`prenotazione`) REFERENCES `Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Biglietto`
-- -----------------------------------------------------
CREATE TABLE `Biglietto` (
  `idBiglietto` INT NOT NULL,
  `NomePasseggero` VARCHAR(45) NOT NULL,
  `CognomePasseggero` VARCHAR(45) NOT NULL,
  `DataNascita` DATE NOT NULL,
  `prenotazione` INT NOT NULL,
  `utente` INT NOT NULL,
  PRIMARY KEY (`idBiglietto`),
  CONSTRAINT `prenotazioneBiglietto` FOREIGN KEY (`prenotazione`) REFERENCES `Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `utenteBiglietto` FOREIGN KEY (`utente`) REFERENCES `Utente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `CartaFedeltà`
-- -----------------------------------------------------
CREATE TABLE `CartaFedeltà` (
  `idCartaFedeltà` INT NOT NULL,
  `puntiTessera` INT NOT NULL DEFAULT 0,
  `utente` INT NOT NULL,
  PRIMARY KEY (`idCartaFedeltà`),
  CONSTRAINT `utenteCartaFedeltà` FOREIGN KEY (`utente`) REFERENCES `Utente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Promozione`
-- -----------------------------------------------------
CREATE TABLE `Promozione` (
  `idPromozione` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `scontoPerFedeli` FLOAT NULL,
  `scontoPerTutti` FLOAT NULL,
  `perTutti` TINYINT NULL DEFAULT 0,
  `dataInizio` DATE NULL,
  `dataFine` DATE NULL,
  PRIMARY KEY (`idPromozione`));


-- -----------------------------------------------------
-- Table `Pagamento`
-- -----------------------------------------------------
CREATE TABLE `Pagamento` (
  `idPagamento` INT NOT NULL,
  `importo` FLOAT NOT NULL,
  `cartaFedeltà` INT NULL,
  `prenotazione` INT NOT NULL,
  PRIMARY KEY (`idPagamento`),
  CONSTRAINT `cartaFedeltàPagamento` FOREIGN KEY (`cartaFedeltà`) REFERENCES `CartaFedeltà` (`idCartaFedeltà`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prenotazionePagamento` FOREIGN KEY (`prenotazione`) REFERENCES `Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
-- -----------------------------------------------------
-- Insert 'volo'
-- -----------------------------------------------------
    
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a100','Boing 737','Milano Malpensa','Roma','2020-04-01','2020-04-01','10:00:00','11:00:00',600.00,50.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a101','Boing 737','Milano Malpensa','Roma','2020-04-02','2020-04-02','10:00:00','11:00:00',600.00,40.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a102','Boing 737','Milano Malpensa','Roma','2020-04-03','2020-04-03','10:00:00','11:00:00',600.00,67.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a103','Boing 737','Milano Malpensa','Roma','2020-04-04','2020-04-04','10:00:00','11:00:00',600.00,80.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a104','Boing 737','Milano Malpensa','Roma','2020-04-05','2020-04-05','10:00:00','11:00:00',600.00,95.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a105','Boing 737','Milano Malpensa','Roma','2020-04-06','2020-04-06','10:00:00','11:00:00',600.00,76.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a106','Boing 737','Milano Malpensa','Roma','2020-04-07','2020-04-07','10:00:00','11:00:00',600.00,43.00,6);

INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a107','A319-100','Milano Malpensa','Brindisi','2020-04-01','2020-04-01','16:00:00','17:15:00',800.00,56.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a108','A319-100','Milano Malpensa','Brindisi','2020-04-02','2020-04-02','16:00:00','17:15:00',800.00,76.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a109','A319-100','Milano Malpensa','Brindisi','2020-04-03','2020-04-03','16:00:00','17:15:00',800.00,80.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a110','A319-100','Milano Malpensa','Brindisi','2020-04-04','2020-04-04','16:00:00','17:15:00',800.00,96.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a111','A319-100','Milano Malpensa','Brindisi','2020-04-05','2020-04-05','16:00:00','17:15:00',800.00,43.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a112','A319-100','Milano Malpensa','Brindisi','2020-04-06','2020-04-06','16:00:00','17:15:00',800.00,33.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a113','A319-100','Milano Malpensa','Brindisi','2020-04-07','2020-04-07','16:00:00','17:15:00',800.00,22.00,8);

INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a114','A320-200','Roma','Milano Malpensa','2020-04-01','2020-04-01','08:20:00','09:20:00',600.00,45.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a115','A320-200','Roma','Milano Malpensa','2020-04-02','2020-04-02','08:20:00','09:20:00',600.00,53.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a116','A320-200','Roma','Milano Malpensa','2020-04-03','2020-04-03','08:20:00','09:20:00',600.00,89.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a117','A320-200','Roma','Milano Malpensa','2020-04-04','2020-04-04','08:20:00','09:20:00',600.00,90.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a118','A320-200','Roma','Milano Malpensa','2020-04-05','2020-04-05','08:20:00','09:20:00',600.00,75.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a119','A320-200','Roma','Milano Malpensa','2020-04-06','2020-04-06','08:20:00','09:20:00',600.00,34.00,6);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a120','A320-200','Roma','Milano Malpensa','2020-04-07','2020-04-07','08:20:00','09:20:00',600.00,26.00,6);

INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a121','A320neo','Roma','Brindisi','2020-04-01','2020-04-01','17:20:00','18:00:00',500.00,25.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a122','A320neo','Roma','Brindisi','2020-04-02','2020-04-02','17:20:00','18:00:00',500.00,29.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a123','A320neo','Roma','Brindisi','2020-04-03','2020-04-03','17:20:00','18:00:00',500.00,35.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a124','A320neo','Roma','Brindisi','2020-04-04','2020-04-04','17:20:00','18:00:00',500.00,43.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a125','A320neo','Roma','Brindisi','2020-04-05','2020-04-05','17:20:00','18:00:00',500.00,34.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a126','A320neo','Roma','Brindisi','2020-04-06','2020-04-06','17:20:00','18:00:00',500.00,22.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a127','A320neo','Roma','Brindisi','2020-04-07','2020-04-07','17:20:00','18:00:00',500.00,19.00,5);

INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a128','A320neo','Brindisi','Roma','2020-04-01','2020-04-01','15:00:00','15:40:00',500.00,32.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a129','A320neo','Brindisi','Roma','2020-04-02','2020-04-02','15:00:00','15:40:00',500.00,38.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a130','A320neo','Brindisi','Roma','2020-04-03','2020-04-03','15:00:00','15:40:00',500.00,42.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a131','A320neo','Brindisi','Roma','2020-04-04','2020-04-04','15:00:00','15:40:00',500.00,53.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a132','A320neo','Brindisi','Roma','2020-04-05','2020-04-05','15:00:00','15:40:00',500.00,24.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a133','A320neo','Brindisi','Roma','2020-04-06','2020-04-06','15:00:00','15:40:00',500.00,29.00,5);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a134','A320neo','Brindisi','Roma','2020-04-07','2020-04-07','15:00:00','15:40:00',500.00,32.00,5);

INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a136','A320neo','Brindisi','Milano','2020-04-01','2020-04-01','9:00:00','10:15:00',800.00,43.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a137','A320neo','Brindisi','Milano','2020-04-02','2020-04-02','9:00:00','10:15:00',800.00,39.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a138','A320neo','Brindisi','Milano','2020-04-03','2020-04-03','9:00:00','10:15:00',800.00,56.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a139','A320neo','Brindisi','Milano','2020-04-04','2020-04-04','9:00:00','10:15:00',800.00,71.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a140','A320neo','Brindisi','Milano','2020-04-05','2020-04-05','9:00:00','10:15:00',800.00,39.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a141','A320neo','Brindisi','Milano','2020-04-06','2020-04-06','9:00:00','10:15:00',800.00,27.00,8);
INSERT INTO `Volo` (`codice_volo`,`aereo`,`città_partenza`,`città_arrivo`,`data_partenza`,`data_arrivo`,`ora_partenza`,`ora_arrivo`,`KmTratta`,`prezzo`,`puntiOttenuti`) VALUES ('a142','A320neo','Brindisi','Milano','2020-04-07','2020-04-07','9:00:00','10:15:00',800.00,18.00,8);

-- -----------------------------------------------------
-- Insert 'posto'
-- -----------------------------------------------------

INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (1,7,'A',NULL,'a100');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (2,7,'B',NULL,'a100');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (3,7,'C',NULL,'a100');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (4,7,'D',NULL,'a100');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (10,14,'A',NULL,'a101');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (11,14,'B',NULL,'a101');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (12,14,'C',NULL,'a101');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (13,14,'D',NULL,'a101');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (20,34,'A',NULL,'a102');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (21,34,'B',NULL,'a102');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (22,34,'C',NULL,'a102');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (23,34,'D',NULL,'a102');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (30,23,'A',NULL,'a103');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (31,23,'B',NULL,'a103');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (32,23,'C',NULL,'a103');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (33,23,'D',NULL,'a103');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (40,35,'A',NULL,'a104');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (41,35,'B',NULL,'a104');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (42,35,'C',NULL,'a104');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (43,35,'D',NULL,'a104');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (50,23,'A',NULL,'a105');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (51,23,'B',NULL,'a105');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (52,23,'C',NULL,'a105');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (53,23,'D',NULL,'a105');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (60,34,'A',NULL,'a106');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (61,34,'B',NULL,'a106');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (62,34,'C',NULL,'a106');
INSERT INTO `Posto` (`idPosto`,`fila`,`lettera`,`prenotazione`,`volo`) VALUES (63,34,'D',NULL,'a106');