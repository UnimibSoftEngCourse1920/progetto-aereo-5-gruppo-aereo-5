CREATE TABLE `Volo` (
  `codice_volo` VARCHAR(8) NOT NULL,
  `aereo` VARCHAR(45) NOT NULL,
  `città_partenza` VARCHAR(45) NOT NULL,
  `città_arrivo` VARCHAR(45) NOT NULL,
  `data_partenza` DATE NOT NULL,
  `data_arrivo` DATE NOT NULL,
  `ora_partenza` TIME NOT NULL,
  `ora_arrivo` TIME NOT NULL,
  `KmTratta` DECIMAL(2) NOT NULL,
  `prezzo` DECIMAL(2) NOT NULL,
  `puntiOttenuti` INT NOT NULL,
  PRIMARY KEY (`codice_volo`))
  
  -- -----------------------------------------------------
-- Table `mydb`.`Utente`
-- -----------------------------------------------------
CREATE TABLE `Utente` (
  `email` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `dataNascita` VARCHAR(45) NULL,
  `ultimoAcquisto` DATE NULL,
  `indirizzoCasa` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `infedele` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`email`))


-- -----------------------------------------------------
-- Table `mydb`.`Prenotazione`
-- -----------------------------------------------------
CREATE TABLE `Prenotazione` (
  `codicePrenotazione` INT NOT NULL,
  `dataScadenza` DATE NOT NULL,
  `dataPrenotazione` DATE NOT NULL,
  `penaleModifica` DECIMAL(2) NULL,
  `utente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codicePrenotazione`),
  INDEX `utente_idx` (`utente` ASC) VISIBLE,
  CONSTRAINT `utentePrenotazione`
    FOREIGN KEY (`utente`)
    REFERENCES `mydb`.`Utente` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`Posto`
-- -----------------------------------------------------
CREATE TABLE `Posto` (
  `idPosto` INT NOT NULL,
  `fila` INT NOT NULL,
  `lettera` INT NOT NULL,
  `prenotazione` INT NULL,
  `volo` VARCHAR(8) NOT NULL,
  INDEX `prenotazione_idx` (`prenotazione` ASC) VISIBLE,
  PRIMARY KEY (`idPosto`),
  INDEX `codice_volo_idx` (`volo` ASC) VISIBLE,
  CONSTRAINT `voloPosto`
    FOREIGN KEY (`volo`)
    REFERENCES `mydb`.`Volo` (`codice_volo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `prenotazionePosto`
    FOREIGN KEY (`prenotazione`)
    REFERENCES `mydb`.`Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `mydb`.`Biglietto`
-- -----------------------------------------------------
CREATE TABLE `Biglietto` (
  `idBiglietto` INT NOT NULL,
  `NomePasseggero` VARCHAR(45) NOT NULL,
  `CognomePasseggero` VARCHAR(45) NOT NULL,
  `DataNascita` DATE NOT NULL,
  `prenotazione` INT NOT NULL,
  `utente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBiglietto`),
  INDEX `prenotazione_idx` (`prenotazione` ASC) VISIBLE,
  INDEX `utente_idx` (`utente` ASC) VISIBLE,
  CONSTRAINT `prenotazioneBiglietto`
    FOREIGN KEY (`prenotazione`)
    REFERENCES `mydb`.`Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `utenteBiglietto`
    FOREIGN KEY (`utente`)
    REFERENCES `mydb`.`Utente` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `mydb`.`CartaFedeltà`
-- -----------------------------------------------------
CREATE TABLE `CartaFedeltà` (
  `idCartaFedeltà` INT NOT NULL,
  `puntiTessera` INT NOT NULL DEFAULT 0,
  `utente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCartaFedeltà`),
  INDEX `utente_idx` (`utente` ASC) VISIBLE,
  CONSTRAINT `utenteCartaFedeltà`
    FOREIGN KEY (`utente`)
    REFERENCES `mydb`.`Utente` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `mydb`.`Promozione`
-- -----------------------------------------------------
CREATE TABLE `Promozione` (
  `idPromozione` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `scontoPerFedeli` DECIMAL(2) NULL,
  `scontoPerTutti` DECIMAL(2) NULL,
  `perTutti` TINYINT NULL DEFAULT 0,
  `dataInizio` DATE NULL,
  `dataFine` DATE NULL,
  PRIMARY KEY (`idPromozione`))


-- -----------------------------------------------------
-- Table `mydb`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE `Pagamento` (
  `idPagamento` INT NOT NULL,
  `importo` DECIMAL(2) NOT NULL,
  `cartaFedeltà` INT NULL,
  `prenotazione` INT NOT NULL,
  PRIMARY KEY (`idPagamento`),
  INDEX `cartaFedeltà_idx` (`cartaFedeltà` ASC) VISIBLE,
  INDEX `prenotazione_idx` (`prenotazione` ASC) VISIBLE,
  CONSTRAINT `cartaFedeltàPagamento`
    FOREIGN KEY (`cartaFedeltà`)
    REFERENCES `mydb`.`CartaFedeltà` (`idCartaFedeltà`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prenotazionePagamento`
    FOREIGN KEY (`prenotazione`)
    REFERENCES `mydb`.`Prenotazione` (`codicePrenotazione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)