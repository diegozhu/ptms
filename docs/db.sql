SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `ptms` ;
CREATE SCHEMA IF NOT EXISTS `ptms` DEFAULT CHARACTER SET utf8 ;
USE `ptms` ;

-- -----------------------------------------------------
-- Table `ptms`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`role` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`user` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `workid` VARCHAR(45) NULL DEFAULT NULL ,
  `personalid` VARCHAR(45) NULL DEFAULT NULL ,
  `address` VARCHAR(45) NULL DEFAULT NULL ,
  `cellphone` VARCHAR(45) NULL DEFAULT NULL ,
  `gender` VARCHAR(45) NULL DEFAULT NULL ,
  `jointime` VARCHAR(45) NULL DEFAULT NULL ,
  `resigntime` VARCHAR(45) NULL DEFAULT NULL ,
  `roleid` INT(11) NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `ur_roleid` (`roleid` ASC) ,
  CONSTRAINT `ur_roleid`
    FOREIGN KEY (`roleid` )
    REFERENCES `ptms`.`role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`bus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`bus` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`bus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `userid` INT(11) NULL DEFAULT NULL ,
  `maxpassager` INT(11) NULL DEFAULT NULL ,
  `type` VARCHAR(45) NULL DEFAULT NULL ,
  `purchasetime` VARCHAR(45) NULL DEFAULT NULL ,
  `lefttime` VARCHAR(45) NULL DEFAULT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `bususer` (`userid` ASC) ,
  CONSTRAINT `bususer`
    FOREIGN KEY (`userid` )
    REFERENCES `ptms`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`line` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`line` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `timespace` VARCHAR(45) NULL DEFAULT NULL ,
  `starttime` VARCHAR(45) NULL DEFAULT NULL ,
  `endtime` VARCHAR(45) NULL DEFAULT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`bus_line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`bus_line` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`bus_line` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `busid` INT(11) NOT NULL ,
  `lineid` INT(11) NOT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `bus_id` (`busid` ASC) ,
  INDEX `line_id` (`lineid` ASC) ,
  CONSTRAINT `bus_id`
    FOREIGN KEY (`busid` )
    REFERENCES `ptms`.`bus` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `line_id`
    FOREIGN KEY (`lineid` )
    REFERENCES `ptms`.`line` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`bus_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`bus_status` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`bus_status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `wheelpressure` INT(11) NULL DEFAULT NULL ,
  `temperature` INT(11) NULL DEFAULT NULL ,
  `gasleft` INT(11) NULL DEFAULT NULL ,
  `locationx` DOUBLE NULL DEFAULT NULL ,
  `locationy` DOUBLE NULL DEFAULT NULL ,
  `busid` INT(11) NOT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `busid` (`busid` ASC) ,
  CONSTRAINT `busid`
    FOREIGN KEY (`busid` )
    REFERENCES `ptms`.`bus` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`eventtype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`eventtype` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`eventtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`station` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`station` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `periority` INT(11) NULL DEFAULT NULL ,
  `locationX` DOUBLE NULL DEFAULT NULL ,
  `locationY` DOUBLE NULL DEFAULT NULL ,
  `availble` TINYINT(1) NULL DEFAULT '1' ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`events` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`events` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `userid` INT(11) NULL DEFAULT NULL ,
  `busid` INT(11) NULL DEFAULT NULL ,
  `stationid` INT(11) NULL DEFAULT NULL ,
  `lineid` INT(11) NULL DEFAULT NULL ,
  `eventtypeid` INT(11) NOT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `e_userid` (`userid` ASC) ,
  INDEX `e_busid` (`busid` ASC) ,
  INDEX `e_stationid` (`stationid` ASC) ,
  INDEX `e_lineid` (`lineid` ASC) ,
  INDEX `e_eventtypeid` (`eventtypeid` ASC) ,
  CONSTRAINT `e_busid`
    FOREIGN KEY (`busid` )
    REFERENCES `ptms`.`bus` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `e_eventtypeid`
    FOREIGN KEY (`eventtypeid` )
    REFERENCES `ptms`.`eventtype` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `e_lineid`
    FOREIGN KEY (`lineid` )
    REFERENCES `ptms`.`line` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `e_stationid`
    FOREIGN KEY (`stationid` )
    REFERENCES `ptms`.`station` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `e_userid`
    FOREIGN KEY (`userid` )
    REFERENCES `ptms`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`line_station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`line_station` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`line_station` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `lineid` INT(11) NOT NULL ,
  `stationid` INT(11) NOT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `ls_lineid` (`lineid` ASC) ,
  INDEX `ls_stationid` (`stationid` ASC) ,
  CONSTRAINT `ls_lineid`
    FOREIGN KEY (`lineid` )
    REFERENCES `ptms`.`line` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ls_stationid`
    FOREIGN KEY (`stationid` )
    REFERENCES `ptms`.`station` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`line_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`line_status` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`line_status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `lindeid` INT(11) NULL DEFAULT NULL ,
  `status` INT(11) NULL DEFAULT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `lineid` (`lindeid` ASC) ,
  CONSTRAINT `lineid`
    FOREIGN KEY (`lindeid` )
    REFERENCES `ptms`.`line` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ptms`.`station_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ptms`.`station_status` ;

CREATE  TABLE IF NOT EXISTS `ptms`.`station_status` (
  `id` INT(11) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `createtime` VARCHAR(45) NULL DEFAULT NULL ,
  `description` VARCHAR(45) NULL DEFAULT NULL ,
  `trafficstatus` INT(11) NULL DEFAULT NULL ,
  `passagerstatus` INT(11) NULL DEFAULT NULL ,
  `stationid` INT(11) NOT NULL ,
  `status` INT(11) NOT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `ss_stationid` (`stationid` ASC) ,
  CONSTRAINT `ss_stationid`
    FOREIGN KEY (`stationid` )
    REFERENCES `ptms`.`station` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
