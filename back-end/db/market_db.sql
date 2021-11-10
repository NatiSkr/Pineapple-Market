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
<<<<<<< HEAD
-- Table `market`.`categoriest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`categoriest` (
=======
-- Table `market`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`categories` (
>>>>>>> d9904d713e1922c80b8aec4391c79ef64626c262
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
<<<<<<< HEAD
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
=======
-- Table `market`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `product_description` VARCHAR(200) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_unit_price` DOUBLE NOT NULL,
  `product_picture` BLOB NULL,
  `Categories_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Products_Categories_idx` (`Categories_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Categories`
    FOREIGN KEY (`Categories_id`)
    REFERENCES `market`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_admin` TINYINT NOT NULL DEFAULT 0,
  `user_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `last_name_p` VARCHAR(45) NOT NULL,
  `last_name_m` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NOT NULL,
>>>>>>> d9904d713e1922c80b8aec4391c79ef64626c262
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
<<<<<<< HEAD
-- Table `market`.`productst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`productst` (
=======
-- Table `market`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`orders` (
>>>>>>> d9904d713e1922c80b8aec4391c79ef64626c262
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `product_description` VARCHAR(200) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_unit_price` DOUBLE NOT NULL,
  `product_picture` BLOB NULL,
  PRIMARY KEY (`id`),
<<<<<<< HEAD
  CONSTRAINT `fk_Products_categories`
    FOREIGN KEY (`id`)
=======
<<<<<<< HEAD
  INDEX `fk_Products_Categories_idx` (`Categories_id` ASC) VISIBLE,
  INDEX `fk_Products_Users1_idx` (`Users_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Categories`
    FOREIGN KEY (`Categories_id`)
>>>>>>> main
    REFERENCES `market`.`categoriest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_users`
    FOREIGN KEY (`id`)
    REFERENCES `market`.`userst` (`id`)
=======
  INDEX `fk_Orders_Users1_idx` (`Users_id` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `market`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`products_has_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`products_has_orders` (
  `Products_id` INT NOT NULL,
  `Orders_id` INT NOT NULL,
  PRIMARY KEY (`Products_id`, `Orders_id`),
  INDEX `fk_Products_has_Orders_Orders1_idx` (`Orders_id` ASC) VISIBLE,
  INDEX `fk_Products_has_Orders_Products1_idx` (`Products_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_has_Orders_Products1`
    FOREIGN KEY (`Products_id`)
    REFERENCES `market`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_has_Orders_Orders1`
    FOREIGN KEY (`Orders_id`)
    REFERENCES `market`.`orders` (`id`)
>>>>>>> d9904d713e1922c80b8aec4391c79ef64626c262
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
