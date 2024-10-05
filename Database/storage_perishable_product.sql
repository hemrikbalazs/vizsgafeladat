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
-- Table structure for table `perishable_product`
--

DROP TABLE IF EXISTS `perishable_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perishable_product` (
  `article_number` varchar(10) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `brand` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `family` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `netto_price` int NOT NULL,
  `tax_id` int NOT NULL,
  `quantity` int NOT NULL,
  `amount_units` varchar(10) NOT NULL,
  `critical_quantity` int NOT NULL,
  `expiration_date` date NOT NULL,
  `production_date` date NOT NULL,
  PRIMARY KEY (`article_number`),
  KEY `tax_id_fk_idx` (`tax_id`),
  CONSTRAINT `tax_id_fk` FOREIGN KEY (`tax_id`) REFERENCES `state_sales_tax` (`tax_key`),
  CONSTRAINT `check_article_number_pp` CHECK (regexp_like(`article_number`,_utf8mb4'^[A-Z]{2}[0-9]{8}$')),
  CONSTRAINT `check_netto_price_pp` CHECK ((`netto_price` >= 0)),
  CONSTRAINT `check_quantity_pp` CHECK ((`quantity` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perishable_product`
--

LOCK TABLES `perishable_product` WRITE;
/*!40000 ALTER TABLE `perishable_product` DISABLE KEYS */;
INSERT INTO `perishable_product` VALUES ('AA00000000','BitterBarfy','BarfyBrew','beer',550,27,48,'cans',12,'2024-12-31','2024-10-06'),('AA00000001','DarkBarfy','BarfyBrew','beer',550,27,24,'cans',6,'2024-12-31','2024-10-06'),('AA00000002','RottenTomato','Guliver','ketchup',1200,5,10,'bottle',3,'2025-12-31','2024-10-06'),('AA00000003','Way2sweet','Chinatown','ketchup',699,5,15,'bottle',5,'2025-12-31','2024-10-06'),('AA00000004','GoSour','Cowtits','milk',700,18,48,'tetrapak',12,'2024-10-31','2024-10-06'),('AA00000005','99%water','Moosolini','milk',499,18,48,'tetrapak',12,'2024-10-31','2024-10-06'),('AA00000006','JustMouse','OrbanHunting','meat',2200,0,2,'kg',0,'2024-10-12','2024-10-06'),('AA00000007','JustPigeon','OrbanHunting','meat',4000,0,3,'kg',0,'2024-10-12','2024-10-06'),('AA00000008','Shinysprouts','ShinyBelgium','brussels sprout',600,99,5,'kg',1,'2024-10-20','2024-10-06'),('AA00000009','Kingsprouts','BrusselOriginal','brussels sprout',800,99,5,'kg',1,'2024-10-20','2024-10-06');
/*!40000 ALTER TABLE `perishable_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06  0:20:36
