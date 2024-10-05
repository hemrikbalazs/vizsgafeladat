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
-- Dumping events for database 'storage'
--

--
-- Dumping routines for database 'storage'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_durable_product` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_durable_product`(
	IN p_article_number VARCHAR(10),
	IN p_name VARCHAR(150),
    IN p_brand VARCHAR(50),
    IN p_family VARCHAR(50),
    IN p_netto_price INT,
    IN p_tax_id INT,
    IN p_quantity INT,
    IN p_amount_units VARCHAR(10),
    IN p_critical_quantity INT,
    IN p_waranty_period INT,
    IN p_gross_weight DECIMAL(4,1)
    )
BEGIN
	CALL INSERT_STATES_SALES_TAX_IF_NEEDED(p_tax_id);
    INSERT INTO DURABLE_PRODUCT(
		ARTICLE_NUMBER,
        NAME,
        BRAND,
        FAMILY,
        NETTO_PRICE,
        TAX_ID,
        QUANTITY,
        AMOUNT_UNITS,
        CRITICAL_QUANTITY,
        WARANTY_PERIOD,
        GROSS_WEIGHT)
        VALUES (
			p_article_number,
            p_name,
            p_brand,
            p_family,
            p_netto_price,
            p_tax_id,
            p_quantity,
            p_amount_units,
            p_critical_quantity,
            p_waranty_period,
            p_gross_weight
            );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_perishable_product` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_perishable_product`(
	IN p_article_number VARCHAR(10),
	IN p_name VARCHAR(150),
    IN p_brand VARCHAR(50),
    IN p_family VARCHAR(50),
    IN p_netto_price INT,
    IN p_tax_id INT,
    IN p_quantity INT,
    IN p_amount_units VARCHAR(10),
    IN p_critical_quantity INT,
    IN p_expiration_date DATE,
    IN p_production_date DATE
    )
BEGIN
	CALL INSERT_STATES_SALES_TAX_IF_NEEDED(p_tax_id);
    INSERT INTO PERISHABLE_PRODUCT(
		ARTICLE_NUMBER,
        NAME,
        BRAND,
        FAMILY,
        NETTO_PRICE,
        TAX_ID,
        QUANTITY,
        AMOUNT_UNITS,
        CRITICAL_QUANTITY,
        EXPIRATION_DATE,
        PRODUCTION_DATE)
        VALUES (
			p_article_number,
            p_name,
            p_brand,
            p_family,
            p_netto_price,
            p_tax_id,
            p_quantity,
            p_amount_units,
            p_critical_quantity,
            p_expiration_date,
            p_production_date
            );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_states_sales_tax_if_needed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_states_sales_tax_if_needed`(IN p_tax_key INT)
BEGIN
	IF NOT EXISTS(SELECT 1 FROM STATE_SALES_TAX WHERE TAX_KEY = p_tax_key) THEN
		INSERT INTO STATE_SALES_TAX(TAX_KEY)
        VALUES(p_tax_key);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06  0:20:37
