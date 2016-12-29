drop database if exists empleadosomi;

create database empleadosomi;

use empleadosomi; 



CREATE TABLE `Empleado` (
  `empleado_id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
  `nombre` varchar(20) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`empleado_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cargo` (
    `cargo_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `cargos_index` int(11) unsigned NOT NULL,
    `empleado_id` int(11) unsigned NOT NULL,
    `nombre` VARCHAR(50) DEFAULT NULL,
    `sueldo` long DEFAULT NULL,   
    PRIMARY KEY (`cargo_id`),
    CONSTRAINT `FKEMP` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`empleado_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

