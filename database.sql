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
-- Table structure for table `assignedmar`
--

DROP TABLE IF EXISTS `assignedmar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignedmar` (
  `assignedmar` varchar(16) NOT NULL,
  `reporteddate` date NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `facilityname` varchar(45) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `urgency` varchar(45) DEFAULT NULL,
  `reportedby` varchar(45) DEFAULT NULL,
  `assignedto` varchar(16) NOT NULL,
  `assignedDate` date NOT NULL,
  `estimateofrepair` varchar(45) NOT NULL,
  PRIMARY KEY (`assignedmar`),
  KEY `fk_amar_facilitytype_idx` (`facilitytype`),
  KEY `fk_amar_facilityname_idx` (`facilityname`),
  KEY `fk_amar_urgency_idx` (`urgency`),
  KEY `fk_amar_assignedto_idx` (`assignedto`),
  KEY `fk_amar_estimateofrepair_idx` (`estimateofrepair`),
  KEY `fk_amar_reportedby_idx` (`reportedby`),
  CONSTRAINT `fk_amar_assignedto` FOREIGN KEY (`assignedto`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_amar_estimateofrepair` FOREIGN KEY (`estimateofrepair`) REFERENCES `estimateofrepair` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_amar_facilityname` FOREIGN KEY (`facilityname`) REFERENCES `facilities` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_amar_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_amar_reportedby` FOREIGN KEY (`reportedby`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_amar_urgency` FOREIGN KEY (`urgency`) REFERENCES `urgency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignedmar`
--

LOCK TABLES `assignedmar` WRITE;
/*!40000 ALTER TABLE `assignedmar` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignedmar` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `estimateofrepair`
--

DROP TABLE IF EXISTS `estimateofrepair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estimateofrepair` (
  `id` varchar(16) NOT NULL,
  `repairtime` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimateofrepair`
--

LOCK TABLES `estimateofrepair` WRITE;
/*!40000 ALTER TABLE `estimateofrepair` DISABLE KEYS */;
INSERT INTO `estimateofrepair` VALUES ('1D','One day'),('1H','One hour'),('30M','30 minutes'),('MD','Multiple days');
/*!40000 ALTER TABLE `estimateofrepair` ENABLE KEYS */;
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
  `time_interval` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  KEY `fk_facilitytype_idx` (`facilitytype`),
  KEY `fk_time_interval` (`time_interval`),
  KEY `fk_duration_idx` (`duration`),
  KEY `fk_venue_idx` (`venue`),
  CONSTRAINT `fk_duration` FOREIGN KEY (`duration`) REFERENCES `durations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_time_interval` FOREIGN KEY (`time_interval`) REFERENCES `intervals` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
-- Table structure for table `facilityreservation`
--

DROP TABLE IF EXISTS `facilityreservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilityreservation` (
  `reservationid` varchar(16) NOT NULL,
  `facilityname` varchar(45) NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `venue` varchar(45) NOT NULL,
  `reservedUser` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `to` datetime NOT NULL,
  `from` datetime NOT NULL,
  PRIMARY KEY (`reservationid`),
  KEY `fk_fr_facilityname_idx` (`facilityname`),
  KEY `fk_fr_facilitytype_idx` (`facilitytype`),
  KEY `fk_fr_venue_idx` (`venue`),
  KEY `fk_fr_reservedUser_idx` (`reservedUser`),
  CONSTRAINT `fk_fr_facilityname` FOREIGN KEY (`facilityname`) REFERENCES `facilities` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_reservedUser` FOREIGN KEY (`reservedUser`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fr_venue` FOREIGN KEY (`venue`) REFERENCES `venues` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilityreservation`
--

LOCK TABLES `facilityreservation` WRITE;
/*!40000 ALTER TABLE `facilityreservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `facilityreservation` ENABLE KEYS */;
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
-- Table structure for table `mar`
--

DROP TABLE IF EXISTS `mar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mar` (
  `marnumber` varchar(16) NOT NULL,
  `assigneddate` date NOT NULL,
  `facilitytype` varchar(45) NOT NULL,
  `facilityname` varchar(45) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `urgency` varchar(45) DEFAULT NULL,
  `reportedby` varchar(120) NOT NULL,
  PRIMARY KEY (`marnumber`),
  KEY `fk_mar_facilitytype_idx` (`facilitytype`),
  KEY `fk_mar_facilityname_idx` (`facilityname`),
  KEY `fk_mar_urgency_idx` (`urgency`),
  CONSTRAINT `fk_mar_facilityname` FOREIGN KEY (`facilityname`) REFERENCES `facilities` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mar_facilitytype` FOREIGN KEY (`facilitytype`) REFERENCES `facilitytypes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mar_urgency` FOREIGN KEY (`urgency`) REFERENCES `urgency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mar`
--

LOCK TABLES `mar` WRITE;
/*!40000 ALTER TABLE `mar` DISABLE KEYS */;
/*!40000 ALTER TABLE `mar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marnumber`
--

DROP TABLE IF EXISTS `marnumber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marnumber` (
  `id` int(11) NOT NULL,
  `current` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marnumber`
--

LOCK TABLES `marnumber` WRITE;
/*!40000 ALTER TABLE `marnumber` DISABLE KEYS */;
INSERT INTO `marnumber` VALUES (0,1);
/*!40000 ALTER TABLE `marnumber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairschedule`
--

DROP TABLE IF EXISTS `repairschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairschedule` (
  `username` varchar(16) NOT NULL,
  `mar` varchar(16) NOT NULL,
  `scheduleDate` date NOT NULL,
  KEY `fk_rs_username_idx` (`username`),
  KEY `fk_rs_mar_idx` (`mar`),
  CONSTRAINT `fk_rs_mar` FOREIGN KEY (`mar`) REFERENCES `assignedmar` (`assignedmar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rs_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairschedule`
--

LOCK TABLES `repairschedule` WRITE;
/*!40000 ALTER TABLE `repairschedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `repairschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestedmar`
--

DROP TABLE IF EXISTS `requestedmar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requestedmar` (
  `requestedmar` varchar(16) NOT NULL,
  `date` date NOT NULL,
  `assignedto` varchar(16) NOT NULL,
  `assignedDate` varchar(45) NOT NULL,
  `estimateofrepair` varchar(45) NOT NULL,
  `from` datetime NOT NULL,
  `to` datetime NOT NULL,
  PRIMARY KEY (`requestedmar`),
  KEY `fk_rmar_requestedmar_idx` (`requestedmar`),
  KEY `fk_rmar_assignedto_idx` (`assignedto`),
  KEY `fk_rmar_estimateofrepair_idx` (`estimateofrepair`),
  CONSTRAINT `fk_rmar_assignedto` FOREIGN KEY (`assignedto`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rmar_estimateofrepair` FOREIGN KEY (`estimateofrepair`) REFERENCES `estimateofrepair` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rmar_requestedmar` FOREIGN KEY (`requestedmar`) REFERENCES `mar` (`marnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestedmar`
--

LOCK TABLES `requestedmar` WRITE;
/*!40000 ALTER TABLE `requestedmar` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestedmar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('A','Admin'),('FM','Facility Manager'),('R','Repairer'),('U','User');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES ('AK','Alaska'),('AL','Alabama'),('AR','Arkansas'),('AZ','Arizona'),('CA','California'),('CO','Colorado'),('CT','Connecticut'),('DE','Delaware'),('FL','Florida'),('GA','Georgia'),('HI','Hawaii'),('IA','Iowa'),('ID','Idaho'),('IL','Illinois'),('IN','Indiana'),('KS','Kansas'),('KY','Kentucky'),('LA','Louisiana'),('MA','Massachusetts'),('MD','Maryland'),('ME','Maine'),('MI','Michigan'),('MN','Minnesota'),('MO','Missouri'),('MS','Mississippi'),('MT','Montana'),('NC','North Carolina'),('ND','North Dakota'),('NE','Nebraska'),('NH','New Hampshire'),('NJ','New Jersey'),('NM','New Mexico'),('NV','Nevada'),('NY','New York'),('OH','Ohio'),('OK','Oklahoma'),('OR','Oregon'),('PA','Pennsylvania'),('RI','Rhode Island'),('SC','South Carolina'),('SD','South Dakota'),('TN','Tennessee'),('TX','Texas'),('UT','Utah'),('VA','Virginia'),('VT','Vermont'),('WA','Washington'),('WI','Wisconsin'),('WV','West Virginia'),('WY','Wyoming');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urgency`
--

DROP TABLE IF EXISTS `urgency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urgency` (
  `id` varchar(45) NOT NULL,
  `urgency` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urgency`
--

LOCK TABLES `urgency` WRITE;
/*!40000 ALTER TABLE `urgency` DISABLE KEYS */;
INSERT INTO `urgency` VALUES ('Ma','Major'),('Me','Medium'),('Mi','Minor'),('Un','Unusable');
/*!40000 ALTER TABLE `urgency` ENABLE KEYS */;
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
  `role` varchar(45) NOT NULL,
  `address` varchar(120) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip` varchar(5) NOT NULL,
  `phone` varchar(10) NOT NULL,
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

-- Dump completed on 2019-09-28 20:12:43
