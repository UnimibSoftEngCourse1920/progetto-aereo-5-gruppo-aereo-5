CREATE TABLE IF NOT EXISTS `mydb`.`Volo` (
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