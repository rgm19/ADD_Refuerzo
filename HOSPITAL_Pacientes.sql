
DROP TABLE IF EXISTS `Pacientes`;

CREATE TABLE `Pacientes` (
  `id` int(8) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fecha_alta` varchar(45),
  `dni` varchar(10) NOT NULL,
  `fecha_ingreso` varchar(45),
  PRIMARY KEY (`id`)
);


INSERT INTO `Pacientes` VALUES (1,'Juan','LaFuente','2017-05-05','45A','2017-04-15'),(2,'Miguel','Pico','2017-05-05','12Z','2017-04-15'),(3,'Maribel','Bravo','2017-05-05','62T','2017-04-15'),(4,'Teresa','Reyes','2017-05-05','98P','2017-04-15'),(5,'Ana Maria','Reyes','2017-05-05','20L','2017-04-01'),(6,'Julio','Brito','2017-05-05','12A','2017-04-01'),(7,'Julio','Brito','2016-05-05','12A','2016-04-01'),(8,'Julio','Brito','2015-05-05','12A','2015-04-01'),(9,'Julio','Brito','2014-05-05','12A','2014-04-01'),(10,'Jesus','Rodriguez','2017-05-05','55U','2017-04-20'),(11,'Jesus','Rodriguez','2016-04-09','55U','2016-03-28');

