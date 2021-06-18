-- MySQL Script generated by MySQL Workbench
-- Sa 19 Jun 2021 01:12:29
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema plain_emrs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `plain_emrs` ;

-- -----------------------------------------------------
-- Schema plain_emrs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `plain_emrs` ;
USE `plain_emrs` ;

-- -----------------------------------------------------
-- Table `plain_emrs`.`people`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`people` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`people` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `given_name` VARCHAR(50) NOT NULL,
  `middle_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `street_address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `country` VARCHAR(55) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`users` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`users` (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `person_id` INT NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` CHAR(68) NOT NULL,
  `email_address` VARCHAR(254) NOT NULL,
  `created_on` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`user_id`, `person_id`, `username`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  INDEX `fk_user_person1_idx` (`person_id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_user_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `plain_emrs`.`people` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`patients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patients` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patients` (
  `person_patient_id` INT NOT NULL,
  `provider` VARCHAR(100) NOT NULL,
  `provider_id` INT NOT NULL,
  `room` VARCHAR(10) NULL,
  `gender` VARCHAR(10) NOT NULL,
  `type` VARCHAR(20) NOT NULL DEFAULT 'outpatient',
  `race` VARCHAR(25) NULL,
  `ethnicity` VARCHAR(45) NULL,
  `language_preference` VARCHAR(45) NULL,
  PRIMARY KEY (`person_patient_id`),
  CONSTRAINT `fk_patient_person1`
    FOREIGN KEY (`person_patient_id`)
    REFERENCES `plain_emrs`.`people` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`medical_records`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`medical_records` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`medical_records` (
  `record_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `person_patient_id` INT NOT NULL,
  `condition` VARCHAR(40) NULL,
  `created_on` DATETIME NULL,
  PRIMARY KEY (`record_id`, `person_patient_id`),
  UNIQUE INDEX `record_id_UNIQUE` (`record_id` ASC) VISIBLE,
  INDEX `fk_medical_record_patient1_idx` (`person_patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_medical_record_patient1`
    FOREIGN KEY (`person_patient_id`)
    REFERENCES `plain_emrs`.`patients` (`person_patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`diagnoses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`diagnoses` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`diagnoses` (
  `record_id` INT UNSIGNED NOT NULL,
  `date` DATETIME NULL,
  `diagnosis` BLOB NULL,
  INDEX `fk_diagnosis_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_diagnosis_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`appointments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`appointments` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`appointments` (
  `record_id` INT UNSIGNED NOT NULL,
  `date` DATETIME NULL,
  `person_staff_id` INT NULL,
  INDEX `fk_appointment_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_appointment_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`medication` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`medication` (
  `record_id` INT UNSIGNED NOT NULL,
  `medication` VARCHAR(150) NULL,
  `is_current` TINYINT NULL,
  INDEX `fk_medication_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_medication_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`allergies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`allergies` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`allergies` (
  `record_id` INT UNSIGNED NOT NULL,
  `allergy` VARCHAR(75) NULL,
  INDEX `fk_allergy_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_allergy_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`visits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`visits` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`visits` (
  `record_id` INT UNSIGNED NOT NULL,
  `visit_date` DATETIME NULL,
  INDEX `fk_visit_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_visit_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`vitals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`vitals` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`vitals` (
  `record_id` INT UNSIGNED NOT NULL,
  `date_taken` DATETIME NULL,
  `height` INT NULL,
  `weight` INT NULL,
  `calculated_bmi` INT NULL,
  `temperature` FLOAT NULL,
  `pulse` INT NULL,
  `respiratory_rate` INT NULL,
  `blood_pressure_systolic` INT NULL,
  `blood_pressure_diastolic` INT NULL,
  `arterial_blood_oxygen_saturation` INT NULL,
  INDEX `fk_vitals_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_vitals_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_access_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_access_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_access_logs` (
  `user_id` INT UNSIGNED NOT NULL,
  `date_time_of_visit` DATETIME NULL,
  INDEX `fk_user_access_log_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_access_log_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`family_relations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`family_relations` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`family_relations` (
  `record_id` INT UNSIGNED NOT NULL,
  `related_patient_id` INT NULL,
  `relation` VARCHAR(25) NULL,
  INDEX `fk_family_relation_medical_record1_idx` (`record_id` ASC) VISIBLE,
  CONSTRAINT `fk_family_relation_medical_record1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`authorities` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`authorities` (
  `authority` VARCHAR(50) NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `person_id` INT NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  INDEX `fk_authorities_user1_idx` (`user_id` ASC, `person_id` ASC, `username` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_user1`
    FOREIGN KEY (`user_id` , `person_id` , `username`)
    REFERENCES `plain_emrs`.`users` (`user_id` , `person_id` , `username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`emergency_contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`emergency_contacts` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`emergency_contacts` (
  `emergency_contact_id` VARCHAR(45) NOT NULL,
  `given_name` VARCHAR(50) NOT NULL,
  `middle_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `email_address` VARCHAR(254) NULL,
  PRIMARY KEY (`emergency_contact_id`),
  UNIQUE INDEX `emergency_contact_id_UNIQUE` (`emergency_contact_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`patient_emergency_contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patient_emergency_contacts` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patient_emergency_contacts` (
  `emergency_contact_id` VARCHAR(45) NOT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`emergency_contact_id`, `person_id`),
  INDEX `fk_table1_emergency_contact1_idx` (`emergency_contact_id` ASC) VISIBLE,
  INDEX `fk_patient_emergency_contact_patient1_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_emergency_contact1`
    FOREIGN KEY (`emergency_contact_id`)
    REFERENCES `plain_emrs`.`emergency_contacts` (`emergency_contact_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_emergency_contact_patient1`
    FOREIGN KEY (`person_id`)
    REFERENCES `plain_emrs`.`patients` (`person_patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`person_staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`person_staff` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`person_staff` (
  `person_staff_id` INT NOT NULL,
  `employed_from` DATETIME NOT NULL,
  `employed_to` DATETIME NULL,
  PRIMARY KEY (`person_staff_id`),
  CONSTRAINT `fk_staff_person1`
    FOREIGN KEY (`person_staff_id`)
    REFERENCES `plain_emrs`.`people` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`person_staff_doctors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`person_staff_doctors` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`person_staff_doctors` (
  `person_staff_id` INT NOT NULL,
  `type_of_practitioner` VARCHAR(45) NOT NULL,
  `specialty` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`person_staff_id`),
  CONSTRAINT `fk_person_staff_doctor_person_staff1`
    FOREIGN KEY (`person_staff_id`)
    REFERENCES `plain_emrs`.`person_staff` (`person_staff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`wards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`wards` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`wards` (
  `ward_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`ward_id`),
  UNIQUE INDEX `ward_id_UNIQUE` (`ward_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`staff_positions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`staff_positions` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`staff_positions` (
  `staff_position_id` INT NOT NULL,
  `description` VARCHAR(65) NULL,
  PRIMARY KEY (`staff_position_id`),
  UNIQUE INDEX `staff_position_id_UNIQUE` (`staff_position_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`staff_wards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`staff_wards` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`staff_wards` (
  `person_staff_id` INT NOT NULL,
  `ward_id` INT NOT NULL,
  PRIMARY KEY (`person_staff_id`, `ward_id`),
  INDEX `fk_staff_ward_ward1_idx` (`ward_id` ASC) VISIBLE,
  CONSTRAINT `fk_staff_ward_staff1`
    FOREIGN KEY (`person_staff_id`)
    REFERENCES `plain_emrs`.`person_staff` (`person_staff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_ward_ward1`
    FOREIGN KEY (`ward_id`)
    REFERENCES `plain_emrs`.`wards` (`ward_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`person_staff_positions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`person_staff_positions` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`person_staff_positions` (
  `staff_position_id` INT NOT NULL,
  `person_staff_id` INT NOT NULL,
  INDEX `fk_person_staff_position_staff_position1_idx` (`staff_position_id` ASC) VISIBLE,
  INDEX `fk_person_staff_position_person_staff1_idx` (`person_staff_id` ASC) VISIBLE,
  CONSTRAINT `fk_person_staff_position_staff_position1`
    FOREIGN KEY (`staff_position_id`)
    REFERENCES `plain_emrs`.`staff_positions` (`staff_position_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_staff_position_person_staff1`
    FOREIGN KEY (`person_staff_id`)
    REFERENCES `plain_emrs`.`person_staff` (`person_staff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
