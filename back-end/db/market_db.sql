-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema market
-- -----------------------------------------------------
-- Definitive schema

-- -----------------------------------------------------
-- Schema market
--
-- Definitive schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `market` DEFAULT CHARACTER SET utf8 ;
USE `market` ;

-- -----------------------------------------------------
-- Table `market`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`Categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `isAdmin` TINYINT NOT NULL DEFAULT 0,
  `userName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastNameP` VARCHAR(45) NOT NULL,
  `lastNameM` VARCHAR(45) NOT NULL,
  `creationDate` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(100) NOT NULL,
  `productDescription` VARCHAR(200) NOT NULL,
  `productQuantity` INT NOT NULL,
  `productUnitPrice` DOUBLE NOT NULL,
  `productPicture` BLOB NULL,
  `Categories_id` INT NOT NULL,
  `Users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Products_Categories_idx` (`Categories_id` ASC) VISIBLE,
  INDEX `fk_Products_Users1_idx` (`Users_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Categories`
    FOREIGN KEY (`Categories_id`)
    REFERENCES `market`.`Categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `market`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
