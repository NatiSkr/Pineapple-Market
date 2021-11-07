-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermarket` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employeeId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE `supermarket` ;

-- -----------------------------------------------------
-- Table `supermarket`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`categories` (
  `id` INT NOT NULL,
  `categoryName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(100) NOT NULL,
  `productDescription` VARCHAR(255) NOT NULL,
  `productQuantity` INT NOT NULL,
  `productUnitPrice` VARCHAR(45) NOT NULL,
  `productPicture` BLOB NULL DEFAULT NULL,
  `categoriesId` INT NOT NULL,
  PRIMARY KEY (`id`, `categoriesId`),
  INDEX `fk_products_categories_idx` (`categoriesId` ASC) VISIBLE,
  CONSTRAINT `fk_products_categories`
    FOREIGN KEY (`categoriesId`)
    REFERENCES `supermarket`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `isAdmin` TINYINT(1) NOT NULL DEFAULT '0',
  `userName` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastNameP` VARCHAR(45) NOT NULL,
  `lastNameM` VARCHAR(45) NULL DEFAULT NULL,
  `creationDate` DATE NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
