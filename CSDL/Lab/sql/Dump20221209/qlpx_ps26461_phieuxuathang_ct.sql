-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: qlpx_ps26461
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `phieuxuathang_ct`
--

DROP TABLE IF EXISTS `phieuxuathang_ct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieuxuathang_ct` (
  `MaMH` varchar(10) NOT NULL,
  `SoPX` varchar(10) NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` int NOT NULL,
  PRIMARY KEY (`SoPX`,`MaMH`),
  KEY `fk_pxct_mh` (`MaMH`),
  CONSTRAINT `fk_pxct_mh` FOREIGN KEY (`MaMH`) REFERENCES `mathang` (`MaMH`),
  CONSTRAINT `fk_pxct_px` FOREIGN KEY (`SoPX`) REFERENCES `phieuxuathang` (`SoPX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieuxuathang_ct`
--

LOCK TABLES `phieuxuathang_ct` WRITE;
/*!40000 ALTER TABLE `phieuxuathang_ct` DISABLE KEYS */;
INSERT INTO `phieuxuathang_ct` VALUES ('MH001','001',5,70000),('MH002','002',10,80000),('MH003','003',15,10000),('MH004','004',17,200000),('MH005','005',19,80000);
/*!40000 ALTER TABLE `phieuxuathang_ct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09 10:18:40
