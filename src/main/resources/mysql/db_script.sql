-- MySQL Script generated by MySQL Workbench
-- Τρι 04 Ιούλ 2017 04:35:52 μμ EEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airbnb` DEFAULT CHARACTER SET utf8 ;
USE `airbnb` ;

-- -----------------------------------------------------
-- Table `airbnb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`User` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`User` (
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
-- Table `airbnb`.`Photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Photo` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Photo` (
  `PHOTO_ID` INT NOT NULL AUTO_INCREMENT,
  `PATH` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PHOTO_ID`),
  UNIQUE INDEX `PHOTO_ID_UNIQUE` (`PHOTO_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Residence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Residence` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Residence` (
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
  `Photo_PHOTO_ID` INT NULL,
  PRIMARY KEY (`RESIDENCE_ID`),
  UNIQUE INDEX `RESIDENCE_ID_UNIQUE` (`RESIDENCE_ID` ASC),
  INDEX `fk_Residence_Photo1_idx` (`Photo_PHOTO_ID` ASC),
  CONSTRAINT `fk_Residence_Photo1`
    FOREIGN KEY (`Photo_PHOTO_ID`)
    REFERENCES `airbnb`.`Photo` (`PHOTO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`Role` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`Role` (
  `ROLE_ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE INDEX `ROLE_ID_UNIQUE` (`ROLE_ID` ASC))
ENGINE = InnoDB;

INSERT INTO Role VALUES (1, 'HOST');
INSERT INTO Role VALUES (2, 'TENANT');

-- -----------------------------------------------------
-- Table `airbnb`.`User_has_Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`User_has_Role` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`User_has_Role` (
  `USER_ID` INT NOT NULL,
  `ROLE_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `ROLE_ID`),
  INDEX `fk_User_has_Role_Role1_idx` (`ROLE_ID` ASC),
  INDEX `fk_User_has_Role_User1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_User_has_Role_User1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `airbnb`.`User` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `airbnb`.`Role` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`User_has_Residence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`User_has_Residence` ;

CREATE TABLE IF NOT EXISTS `airbnb`.`User_has_Residence` (
  `USER_ID` INT NOT NULL,
  `RESIDENCE_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `RESIDENCE_ID`),
  INDEX `fk_User_has_Residence_Residence1_idx` (`RESIDENCE_ID` ASC),
  INDEX `fk_User_has_Residence_User1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_User_has_Residence_User1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `airbnb`.`User` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Residence_Residence1`
    FOREIGN KEY (`RESIDENCE_ID`)
    REFERENCES `airbnb`.`Residence` (`RESIDENCE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
