drop database if exists empleadosfk;

create database empleadosfk;

use empleadosfk; 

CREATE TABLE `cargo` (
    `cargo_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) DEFAULT NULL,
    `sueldo` long DEFAULT NULL,   
    PRIMARY KEY (`cargo_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `Empleado` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cargo_id` int(11) unsigned NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKCARGO` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`cargo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


