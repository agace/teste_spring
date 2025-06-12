-- MySQL dump 10.13  Distrib 9.3.0, for Linux (aarch64)
--
-- Host: localhost    Database: esoft_db
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ninja_jutsus`
--

DROP TABLE IF EXISTS `ninja_jutsus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ninja_jutsus` (
  `ninja_id` bigint NOT NULL,
  `jutsu_id` bigint NOT NULL,
  KEY `FK2mydjam0hoeqjpkk93xwh5nk2` (`jutsu_id`),
  KEY `FKqfxba9f433lketvqhw4huvlgb` (`ninja_id`),
  CONSTRAINT `FK2mydjam0hoeqjpkk93xwh5nk2` FOREIGN KEY (`jutsu_id`) REFERENCES `tb_jutsu` (`id`),
  CONSTRAINT `FKqfxba9f433lketvqhw4huvlgb` FOREIGN KEY (`ninja_id`) REFERENCES `tb_ninja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ninja_jutsus`
--

LOCK TABLES `ninja_jutsus` WRITE;
/*!40000 ALTER TABLE `ninja_jutsus` DISABLE KEYS */;
INSERT INTO `ninja_jutsus` VALUES (1,1);
/*!40000 ALTER TABLE `ninja_jutsus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jutsu`
--

DROP TABLE IF EXISTS `tb_jutsu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_jutsu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `dificuldade` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jutsu`
--

LOCK TABLES `tb_jutsu` WRITE;
/*!40000 ALTER TABLE `tb_jutsu` DISABLE KEYS */;
INSERT INTO `tb_jutsu` VALUES (1,'Tecnica de chakra concentrado em forma de esfera',5,'Rasengan');
/*!40000 ALTER TABLE `tb_jutsu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_missoes`
--

DROP TABLE IF EXISTS `tb_missoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_missoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `dificuldade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_missoes`
--

LOCK TABLES `tb_missoes` WRITE;
/*!40000 ALTER TABLE `tb_missoes` DISABLE KEYS */;
INSERT INTO `tb_missoes` VALUES (2,'Buscar a esfera no monte sagrado','Alta','Missão da Esfera');
/*!40000 ALTER TABLE `tb_missoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ninja`
--

DROP TABLE IF EXISTS `tb_ninja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ninja` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cla` varchar(255) DEFAULT NULL,
  `idade` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `missao_id` bigint DEFAULT NULL,
  `vila_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7eht8wm4n5ctjhm5uxdmqvxah` (`missao_id`),
  KEY `FKryuxylh402gdkiikbrtlgtaf8` (`vila_id`),
  CONSTRAINT `FK7eht8wm4n5ctjhm5uxdmqvxah` FOREIGN KEY (`missao_id`) REFERENCES `tb_missoes` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FKryuxylh402gdkiikbrtlgtaf8` FOREIGN KEY (`vila_id`) REFERENCES `tb_vila` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ninja`
--

LOCK TABLES `tb_ninja` WRITE;
/*!40000 ALTER TABLE `tb_ninja` DISABLE KEYS */;
INSERT INTO `tb_ninja` VALUES (1,'Uzumaki',20,'Naruto Uzumaki',NULL,1),(3,'Seilazaki',18,'Zakila',2,1),(4,'Lameahh',19,'Foshan',NULL,2);
/*!40000 ALTER TABLE `tb_ninja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vila`
--

DROP TABLE IF EXISTS `tb_vila`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_vila` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `numero_habitantes` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vila`
--

LOCK TABLES `tb_vila` WRITE;
/*!40000 ALTER TABLE `tb_vila` DISABLE KEYS */;
INSERT INTO `tb_vila` VALUES (1,'Naruto',0),(2,'Konoha',1000);
/*!40000 ALTER TABLE `tb_vila` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-10 23:17:40
