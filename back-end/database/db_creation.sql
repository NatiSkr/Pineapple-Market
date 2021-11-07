-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermarket` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `supermarket` ;

-- -----------------------------------------------------
-- Table `supermarket`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`categories` (
  `id` INT NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci;


-- -----------------------------------------------------
-- Table `supermarket`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `product_description` VARCHAR(255) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_unit_price` VARCHAR(45) NOT NULL,
  `product_picture` BLOB NULL DEFAULT NULL,
  `categories_id` INT NOT NULL,
  PRIMARY KEY (`id`, `categories_id`),
  INDEX `fk_products_categories_idx` (`categories_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_categories`
    FOREIGN KEY (`categories_id`)
    REFERENCES `supermarket`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci;


-- -----------------------------------------------------
-- Table `supermarket`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_admin` TINYINT(1) NOT NULL DEFAULT '0',
  `username` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastnamep` VARCHAR(45) NOT NULL,
  `lastnamem` VARCHAR(45) NULL DEFAULT NULL,
  `creation_date` TIMESTAMP NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
CHARACTER SET utf8 
COLLATE utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
