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
-- Table `market`.`categoriest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`categoriest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`userst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`userst` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_admin` TINYINT NOT NULL DEFAULT 0,
  `email` VARCHAR(100) NOT NULL,
  `pass_word` VARCHAR(200) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name_p` VARCHAR(45) NOT NULL,
  `last_name_m` VARCHAR(45) NULL DEFAULT 'no maternal last name',
  `creation_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`productst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`productst` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `product_description` VARCHAR(200) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_unit_price` DOUBLE NOT NULL,
  `product_picture` BLOB NULL,
  `Categories_id` INT NOT NULL,
  `Users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Products_Categories_idx` (`Categories_id` ASC) VISIBLE,
  INDEX `fk_Products_Users1_idx` (`Users_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Categories`
    FOREIGN KEY (`Categories_id`)
    REFERENCES `market`.`categoriest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `market`.`userst` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
