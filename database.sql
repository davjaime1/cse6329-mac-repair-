CREATE DATABASE  IF NOT EXISTS `database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `database`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: database
-- ------------------------------------------------------
-- Server version	5.7.27-log

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
-- Table structure for table `durations`
--

DROP TABLE IF EXISTS `durations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `durations` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durations`
--

LOCK TABLES `durations` WRITE;
/*!40000 ALTER TABLE `durations` DISABLE KEYS */;
INSERT INTO `durations` VALUES ('7D','7-day'),('SD','Same day');
/*!40000 ALTER TABLE `durations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `name` varchar(45) NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `interval` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  KEY `fk_facilitytype_idx` (`facilitytype`),
  KEY `fk_idx` (`interval`),
  KEY `fk_duration_idx` (`duration`),
  KEY `fk_venue_idx` (`venue`),
  CONSTRAINT `fk_duration` FOREIGN KEY (`duration`) REFERENCES `durations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_interval` FOREIGN KEY (`interval`) REFERENCES `intervals` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venue` FOREIGN KEY (`venue`) REFERENCES `venues` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES ('BMC1','BMC','30M','SD','I'),('BMC10','BMC','30M','SD','I'),('BMC2','BMC','30M','SD','I'),('BMC3','BMC','30M','SD','I'),('BMC4','BMC','30M','SD','I'),('BMC5','BMC','30M','SD','I'),('BMC6','BMC','30M','SD','I'),('BMC7','BMC','30M','SD','I'),('BMC8','BMC','30M','SD','I'),('BMC9','BMC','30M','SD','I'),('CR1','CR','1H','SD','I'),('CR2','CR','1H','SD','I'),('CR3','CR','1H','SD','I'),('CR4','CR','1H','SD','I'),('CR5','CR','1H','SD','I'),('IBBC1','IBBC','1H','SD','I'),('IBBC2','IBBC','1H','SD','I'),('IBBC3','IBBC','1H','SD','I'),('IBBC4','IBBC','1H','SD','I'),('IBBC5','IBBC','1H','SD','I'),('IVBC1','IVBC','1H','SD','I'),('IVBC2','IVBC','1H','SD','I'),('IVBC3','IVBC','1H','SD','I'),('IVBC4','IVBC','1H','SD','I'),('IVBC5','IVBC','1H','SD','I'),('IVBC6','IVBC','1H','SD','I'),('IVBC7','IVBC','1H','SD','I'),('IVBC8','IVBC','1H','SD','I'),('IVBC9','IVBC','1H','SD','I'),('MR1','MR','1H','SD','I'),('MR2','MR','1H','SD','I'),('MR3','MR','1H','SD','I'),('MR4','MR','1H','SD','I'),('OBBC1','OBBC','2H','7D','O'),('OBBC2','OBBC','2H','7D','O'),('OVBC1','OVBC','2H','7D','O'),('OVBC2','OVBC','2H','7D','O'),('RBC1','RBC','30M','SD','I'),('RBC2','RBC','30M','SD','I'),('RBC3','RBC','30M','SD','I'),('RBC4','RBC','30M','SD','I'),('RBC5','RBC','30M','SD','I'),('SCG','SCG','2H','SD','I'),('TT1','TT','30M','SD','I');
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitytypes`
--

DROP TABLE IF EXISTS `facilitytypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilitytypes` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitytypes`
--

LOCK TABLES `facilitytypes` WRITE;
/*!40000 ALTER TABLE `facilitytypes` DISABLE KEYS */;
INSERT INTO `facilitytypes` VALUES ('BMC','Badminton Court'),('CR','Conference Room'),('IBBC','Indoor Basketball Court'),('IVBC','Volleyball Court'),('MR','Multipurpose Room'),('OBBC','Outdoor Basketball Court'),('OVBC','Outdoor Volleyball Court'),('RBC','Racquetball Court'),('SCG','Indoor Soccer Gymnasium'),('TT','Table Tennis');
/*!40000 ALTER TABLE `facilitytypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervals`
--

DROP TABLE IF EXISTS `intervals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intervals` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervals`
--

LOCK TABLES `intervals` WRITE;
/*!40000 ALTER TABLE `intervals` DISABLE KEYS */;
INSERT INTO `intervals` VALUES ('1H','1 hour'),('2H','2 hours'),('30M','30 min');
/*!40000 ALTER TABLE `intervals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (0,'Admin'),(1,'User'),(2,'Facility Manager'),(3,'Repairer');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (0,'Alabama'),(1,'Alaska'),(2,'Arizona'),(3,'Arkansas'),(4,'California'),(5,'Colorado'),(6,'Connecticut'),(7,'Delaware'),(8,'Florida'),(9,'Georgia'),(10,'Hawaii'),(11,'Idaho'),(12,'Illinois'),(13,'Indiana'),(14,'Iowa'),(15,'Kansas'),(16,'Kentucky'),(17,'Louisiana'),(18,'Maine'),(19,'Maryland'),(20,'Massachusetts'),(21,'Michigan'),(22,'Minnesota'),(23,'Mississippi'),(24,'Missouri'),(25,'Montana'),(26,'Nebraska'),(27,'Nevada'),(28,'New Hampshire'),(29,'New Jersey'),(30,'New Mexico'),(31,'New York'),(32,'North Carolina'),(33,'North Dakota'),(34,'Ohio'),(35,'Oklahoma'),(36,'Oregon'),(37,'Pennsylvania'),(38,'Rhode Island'),(39,'South Carolina'),(40,'South Dakota'),(41,'Tennessee'),(42,'Texas'),(43,'Utah'),(44,'Vermont'),(45,'Virginia'),(46,'Washington'),(47,'West Virginia'),(48,'Wisconsin'),(49,'Wyoming');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(16) NOT NULL,
  `id` int(10) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(120) NOT NULL,
  `role` int(11) NOT NULL,
  `address` varchar(120) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` int(10) NOT NULL,
  `zip` int(5) NOT NULL,
  `phone` int(10) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_role_idx` (`role`),
  KEY `fk_state_idx` (`state`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_state` FOREIGN KEY (`state`) REFERENCES `states` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venues`
--

DROP TABLE IF EXISTS `venues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venues` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venues`
--

LOCK TABLES `venues` WRITE;
/*!40000 ALTER TABLE `venues` DISABLE KEYS */;
INSERT INTO `venues` VALUES ('I','Indoor'),('O','Outdoor');
/*!40000 ALTER TABLE `venues` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-07 20:33:03
