drop database if exists empleadosom;

create database empleadosom;

use empleadosom; 



CREATE TABLE `empleado` (
  `empleado_id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
  `nombre` varchar(20) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`empleado_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cargo` (
    `cargo_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `empleado_id` int(11) unsigned NOT NULL,
    `nombre` VARCHAR(50) DEFAULT NULL,
    `sueldo` long DEFAULT NULL,   
    PRIMARY KEY (`cargo_id`),
    CONSTRAINT `FKEMP` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`empleado_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

