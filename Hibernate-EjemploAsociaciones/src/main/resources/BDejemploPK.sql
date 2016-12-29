drop database if exists empleados;

create database empleados;

use empleados; 

CREATE TABLE `Empleado` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `cargo` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) DEFAULT NULL,
    `sueldo` long DEFAULT NULL,   
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;