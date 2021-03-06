-- MySQL Script generated by MySQL Workbench
-- Σαβ 22 Ιούλ 2017 04:03:11 μμ EEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `airbnb` ;

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airbnb` DEFAULT CHARACTER SET utf8 ;
USE `airbnb` ;

-- -----------------------------------------------------
-- Table `airbnb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Users` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Users` (
  `USER_ID` INT NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PHONE_NUMBER` VARCHAR(45) NOT NULL,
  `SALT` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USER_ID_UNIQUE` (`USER_ID` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Residences`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Residences` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Residences` (
  `RESIDENCE_ID` INT NOT NULL AUTO_INCREMENT,
  `ADDRESS` VARCHAR(45) NOT NULL,
  `GEO_X` DOUBLE NULL,
  `GEO_Y` DOUBLE NULL,
  `DATE_AVAILABLE` VARCHAR(500) NOT NULL DEFAULT ';',
  `CAPACITY` INT NOT NULL,
  `PRIZE` INT NOT NULL,
  `TYPE` VARCHAR(45) NOT NULL,
  `RULES` VARCHAR(200) NOT NULL,
  `DESCRIPTION` VARCHAR(200) NOT NULL,
  `BATHROOMS` INT NOT NULL,
  `SIZE` DOUBLE NOT NULL,
  `BEDROOMS` INT NOT NULL,
  `LIVING_ROOM` TINYINT(1) NOT NULL,
  `LOCATION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RESIDENCE_ID`),
  UNIQUE INDEX `RESIDENCE_ID_UNIQUE` (`RESIDENCE_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Roles` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Roles` (
  `ROLE_ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE INDEX `ROLE_ID_UNIQUE` (`ROLE_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Photos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Photos` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Photos` (
  `PHOTO_ID` INT NOT NULL AUTO_INCREMENT,
  `PATH` VARCHAR(45) NOT NULL,
  `Residences_RESIDENCE_ID` INT NOT NULL,
  PRIMARY KEY (`PHOTO_ID`),
  UNIQUE INDEX `PHOTO_ID_UNIQUE` (`PHOTO_ID` ASC),
  INDEX `fk_Photos_Residences1_idx` (`Residences_RESIDENCE_ID` ASC),
  CONSTRAINT `fk_Photos_Residences1`
    FOREIGN KEY (`Residences_RESIDENCE_ID`)
    REFERENCES `airbnb`.`Residences` (`RESIDENCE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Users_have_Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Users_have_Roles` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Users_have_Roles` (
  `USER_ID` INT NOT NULL,
  `ROLE_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `ROLE_ID`),
  INDEX `fk_User_has_Role_Role1_idx` (`ROLE_ID` ASC),
  INDEX `fk_User_has_Role_User1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_User_has_Role_User1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `airbnb`.`Users` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `airbnb`.`Roles` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Users_have_Residences`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Users_have_Residences` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Users_have_Residences` (
  `USER_ID` INT NOT NULL,
  `RESIDENCE_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `RESIDENCE_ID`),
  INDEX `fk_User_has_Residence_Residence1_idx` (`RESIDENCE_ID` ASC),
  INDEX `fk_User_has_Residence_User1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_User_has_Residence_User1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `airbnb`.`Users` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Residence_Residence1`
    FOREIGN KEY (`RESIDENCE_ID`)
    REFERENCES `airbnb`.`Residences` (`RESIDENCE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `airbnb`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `airbnb`;
INSERT INTO `airbnb`.`Roles` (`ROLE_ID`, `DESCRIPTION`) VALUES (1, 'HOST');
INSERT INTO `airbnb`.`Roles` (`ROLE_ID`, `DESCRIPTION`) VALUES (2, 'TENANT');

COMMIT;

