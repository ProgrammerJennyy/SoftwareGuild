DROP DATABASE IF EXISTS  `hotel` ;
CREATE DATABASE  IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
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
-- Table structure for table `amenties`
--

DROP TABLE IF EXISTS `amenties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenties` (
  `amenityId` int NOT NULL,
  `amenityName` varchar(45) NOT NULL,
  PRIMARY KEY (`amenityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenties`
--

LOCK TABLES `amenties` WRITE;
/*!40000 ALTER TABLE `amenties` DISABLE KEYS */;
/*!40000 ALTER TABLE `amenties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guests` (
  `guestId` int NOT NULL,
  `City` varchar(100) NOT NULL,
  `stateAbbr` varchar(2) NOT NULL,
  `Zip` varchar(10) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  PRIMARY KEY (`guestId`),
  UNIQUE KEY `guestId_UNIQUE` (`guestId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guests`
--

LOCK TABLES `guests` WRITE;
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `Reservation` int NOT NULL,
  `roomNumber` int NOT NULL,
  `guestId` int NOT NULL,
  `Adults` int NOT NULL,
  `Children` int NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `totalRoomCost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Reservation`),
  KEY `good_guestId_idx` (`guestId`),
  KEY `good_roomId_idx` (`roomNumber`),
  CONSTRAINT `good_guestId` FOREIGN KEY (`guestId`) REFERENCES `guests` (`guestId`) ON UPDATE RESTRICT,
  CONSTRAINT `good_roomId` FOREIGN KEY (`roomNumber`) REFERENCES `roomdata` (`roomNumber`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomamenties`
--

DROP TABLE IF EXISTS `roomamenties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomamenties` (
  `amenityId` int NOT NULL,
  `roomNumber` int NOT NULL,
  KEY `good_roomnumberay_idx` (`roomNumber`),
  KEY `good_amenity_hurray_idx` (`amenityId`),
  CONSTRAINT `good_amenity_hurray` FOREIGN KEY (`amenityId`) REFERENCES `amenties` (`amenityId`),
  CONSTRAINT `good_roomnumber_hurray` FOREIGN KEY (`roomNumber`) REFERENCES `roomdata` (`roomNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomamenties`
--

LOCK TABLES `roomamenties` WRITE;
/*!40000 ALTER TABLE `roomamenties` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomamenties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomdata`
--

DROP TABLE IF EXISTS `roomdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomdata` (
  `roomNumber` int NOT NULL,
  `roomType` varchar(45) NOT NULL,
  `standardOccupancy` int unsigned NOT NULL,
  `maximumOccupancy` int unsigned NOT NULL,
  `basePrice` decimal(10,2) unsigned NOT NULL,
  `extraPersonPrice` decimal(10,2) unsigned NOT NULL,
  `adaAccessable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`roomNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomdata`
--

LOCK TABLES `roomdata` WRITE;
/*!40000 ALTER TABLE `roomdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-26 20:27:50
