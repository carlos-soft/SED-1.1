CREATE DATABASE  IF NOT EXISTS `sed` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `sed`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: sed
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `idEvaluacion` int(11) NOT NULL,
  `idGrupo` int(11) NOT NULL,
  `control` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `evaluado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,2,1,'14201150','CAMARENA CAMARENA ESTRELLA MADAI',1),(2,2,1,'14201156','CAMARENA GUZMAN ARACELI',0),(3,2,1,'14201173','CAMARENA MARTINEZ MARIANA',0),(4,2,1,'14201096','GARCIA LEMUS JOSE EDUARDO',0),(5,2,1,'14201177','GAYTAN ORTIZ ADRIANA',0),(6,2,1,'14201182','GORDILLO VIEYRA ELIUD DANIELA',0),(7,2,1,'14201164','GUZMAN DIAZ NANCY',0),(8,2,1,'14201165','HERNANDEZ ZAMUDIO JUAN LUIS',0),(9,2,1,'13201056','PEREZ TOLEDO SALMA',0),(10,2,1,'14201170','ROCHA JURADO LUIS RAFAEL',0),(11,2,1,'14201160','TOLEDO HERNANDEZ MA PALOMA',0),(12,2,1,'14201183','VEGA GUZMAN ROSALIA GUADALUPE',0),(13,2,2,'13201118','ALCANTAR RODRIGUEZ ALEJANDRA',0),(14,2,2,'13201231','ALVAREZ SANCHEZ AGUSTIN',0),(15,2,2,'14201029','AVALOS GARCIA JUAN FELIPE',0),(16,2,2,'13201211','CERRITEÑO FERNANDEZ DANIELA ADAMARY',0),(17,2,2,'14201078','CHAVEZ DIAZ LUIS ALBERTO',0),(18,2,2,'13201219','GONZALEZ ARELLANO ANA KAREN',0),(19,2,2,'12201284','LOPEZ ORTEGA ANA JULIETA',0),(20,2,2,'13201255','ORTIZ RUIZ KAREN PAULINA',0),(21,2,2,'13201261','PIZANO ROSILES MELISSA GALILEA',0),(22,2,2,'13201245','ROCHA JUAREZ MARIA ALICIA',0),(23,2,2,'13201204','ROCHA SANDOVAL JOSEPH ANGEL',0),(24,2,2,'14201057','ZAMUDIO HERNANDEZ ERICK',0);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentes` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes`
--

LOCK TABLES `docentes` WRITE;
/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
INSERT INTO `docentes` VALUES (1,'LAURA DEL PILAR VEGA VEGA'),(2,'YAZMIN VAZQUEZ GUTIERREZ');
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciones`
--

DROP TABLE IF EXISTS `evaluaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluaciones` (
  `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` varchar(20) NOT NULL,
  `fechaFin` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `lenguaje` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idEvaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciones`
--

LOCK TABLES `evaluaciones` WRITE;
/*!40000 ALTER TABLE `evaluaciones` DISABLE KEYS */;
INSERT INTO `evaluaciones` VALUES (2,'Enero','Marzo',2014,'Ingles','desactivada'),(3,'Abril','Agosto',2014,'Ingles','desactivada'),(4,'Julio','Octubre',2014,'Frances','desactivada'),(5,'Noviembre','Diciembre',2014,'Ingles','desactivada');
/*!40000 ALTER TABLE `evaluaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `idDocente` int(11) NOT NULL,
  `nivel` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  PRIMARY KEY (`idGrupo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'1SJA14',1,1,2),(2,'5KJA14',2,5,2);
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntas` (
  `idPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `respuestas` varchar(10) DEFAULT NULL,
  `banco` varchar(1) NOT NULL,
  `answer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (2,'El profesor es puntual ??','orden','s','null'),(3,'El profesor falta el respeto a los alumnos ??','orden','s','null'),(4,'El profesor viste de manera presentable ??','desorden','s','null'),(5,'Hola Mundo ??','orden','s','null'),(8,'soy marco ??','desorden','n','null'),(10,'malo malo ??','orden','n','null'),(11,'bueno bueno ??','orden','s','null'),(12,'exito ??','desorden','n','null'),(13,'por favor ??','orden','n','null'),(14,'ya ??','orden','n','null'),(18,'que onda ??','desorden','n','null'),(28,'Que cosas ??','orden','s','null'),(29,'Save Sabe ??','orden','s','null'),(30,'lalolin ??','orden','s',NULL),(31,'Carlos ???','desorden','s',NULL),(32,'cuantos años ??','orden','n',NULL),(33,'méxico ??','orden','n',NULL);
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntasjoinevaluacion`
--

DROP TABLE IF EXISTS `preguntasjoinevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntasjoinevaluacion` (
  `idPregunta` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntasjoinevaluacion`
--

LOCK TABLES `preguntasjoinevaluacion` WRITE;
/*!40000 ALTER TABLE `preguntasjoinevaluacion` DISABLE KEYS */;
INSERT INTO `preguntasjoinevaluacion` VALUES (3,2),(4,2),(5,2),(10,3),(28,2),(29,2),(30,2),(31,2),(32,5),(33,5);
/*!40000 ALTER TABLE `preguntasjoinevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sed'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-05 14:31:54
