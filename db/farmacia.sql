-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `ID_CLIENTE` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `APELLIDO` varchar(45) NOT NULL,
  `DNI` int NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `COBERTURA_MEDICA` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `ID_PRODUCTO` int NOT NULL AUTO_INCREMENT,
  `PRODUCTO` varchar(45) NOT NULL,
  `LABORATORIO` varchar(45) NOT NULL,
  `PRECIO` decimal(10,0) NOT NULL,
  `STOCK` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `ID_RESERVA` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int NOT NULL,
  `ID_SUCURSAL` int NOT NULL,
  `FECHA_RESERVA` date NOT NULL,
  `FECHA_VENCIMIENTO` date NOT NULL,
  `FORMA_PAGO` varchar(45) NOT NULL,
  `ESTADO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_RESERVA`,`ID_CLIENTE`),
  KEY `ID_RESERVA` (`ID_RESERVA`),
  KEY `RESERVA_ID_SUCURSAL_idx` (`ID_SUCURSAL`),
  CONSTRAINT `RESERVA_ID_CLIENTE` FOREIGN KEY (`ID_RESERVA`) REFERENCES `clientes` (`ID_CLIENTE`),
  CONSTRAINT `RESERVA_ID_SUCURSAL` FOREIGN KEY (`ID_SUCURSAL`) REFERENCES `sucursales` (`ID_SUCURSAL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservas_productos`
--

DROP TABLE IF EXISTS `reservas_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas_productos` (
  `ID_RESERVAS` int NOT NULL,
  `ID_PRODUCTO` int NOT NULL,
  `UNIDADES` int NOT NULL,
  PRIMARY KEY (`ID_RESERVAS`,`ID_PRODUCTO`),
  KEY `ID_PRODUCTO_idx` (`ID_PRODUCTO`),
  CONSTRAINT `ID_PRODUCTO` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `productos` (`ID_PRODUCTO`),
  CONSTRAINT `ID_RESERVA` FOREIGN KEY (`ID_RESERVAS`) REFERENCES `reservas` (`ID_RESERVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursales` (
  `ID_SUCURSAL` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_SUCURSAL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 19:51:41
