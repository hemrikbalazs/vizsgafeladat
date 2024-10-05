CREATE DATABASE  IF NOT EXISTS `storage` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `storage`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: storage
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `durable_product`
--

DROP TABLE IF EXISTS `durable_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `durable_product` (
  `article_number` varchar(10) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `brand` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `family` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `netto_price` int NOT NULL,
  `tax_id` int NOT NULL,
  `quantity` int NOT NULL,
  `amount_units` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `critical_quantity` int NOT NULL,
  `waranty_period` int NOT NULL,
  `gross_weight` decimal(4,1) NOT NULL,
  PRIMARY KEY (`article_number`),
  KEY `db_tax_id_fk_idx` (`tax_id`),
  CONSTRAINT `dp_tax_id_fk` FOREIGN KEY (`tax_id`) REFERENCES `state_sales_tax` (`tax_key`),
  CONSTRAINT `check_article_number_dp` CHECK (regexp_like(`article_number`,_utf8mb4'^[A-Z]{2}[0-9]{8}$')),
  CONSTRAINT `check_gross_weight` CHECK ((`gross_weight` >= 0)),
  CONSTRAINT `check_netto_price_dp` CHECK ((`netto_price` >= 0)),
  CONSTRAINT `check_quantity_dp` CHECK ((`quantity` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durable_product`
--

LOCK TABLES `durable_product` WRITE;
/*!40000 ALTER TABLE `durable_product` DISABLE KEYS */;
INSERT INTO `durable_product` VALUES ('AA00000000','Shocky','Sumsang','coffee machine',23500,27,5,'pieces',2,6,2.5),('AA00000001','Disgusto','Philice','coffee machine',29000,27,5,'pieces',2,6,3.0),('AA00000002','Burny','Sumsang','oven',70000,27,4,'pieces',1,24,10.0),('AA00000003','Smellsbad','Bish','oven',62000,27,4,'pieces',1,24,9.3),('AA00000004','Pixy','Sumsang','tv',219999,27,10,'pieces',2,12,4.5),('AA00000005','Lowdef','LGbt','tv',149000,27,8,'pieces',1,12,5.6),('AA00000006','Breaks2much','Dull','dishwasher',55000,27,8,'pieces',3,30,8.2),('AA00000007','Leaky','Bish','dishwasher',74500,27,8,'pieces',3,30,7.7),('AA00000008','HotPlate','Cantdy','microwave oven',40000,27,15,'pieces',5,12,5.1),('AA00000009','Short-circuit','Sumsang','microwave oven',56499,27,8,'pieces',3,12,3.9);
/*!40000 ALTER TABLE `durable_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06  0:20:37
