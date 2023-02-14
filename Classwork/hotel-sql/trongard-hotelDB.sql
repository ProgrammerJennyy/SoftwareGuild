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
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guests` (
  `Name` varchar(75) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(100) NOT NULL,
  `stateAbbr` varchar(2) NOT NULL,
  `Zip` varchar(10) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `guestId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`guestId`),
  UNIQUE KEY `guestId_UNIQUE` (`guestId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `roomNumber` int NOT NULL,
  `guestId` int NOT NULL,
  `Adults` int NOT NULL,
  `Children` int NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `totalRoomCost` decimal(10,2) NOT NULL,
  `Reservation` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Reservation`),
  KEY `good_roomId_idx` (`roomNumber`),
  KEY `good_guestid_idx` (`guestId`),
  CONSTRAINT `good_guestid` FOREIGN KEY (`guestId`) REFERENCES `guests` (`guestId`),
  CONSTRAINT `good_roomnumber` FOREIGN KEY (`roomNumber`) REFERENCES `roomdata` (`roomNumber`) ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roomamenties`
--

DROP TABLE IF EXISTS `roomamenties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomamenties` (
  `roomNumber` int NOT NULL,
  `amenityId` int NOT NULL,
  `index` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`index`),
  KEY `good_roomnumberay_idx` (`roomNumber`),
  KEY `good_amenity_hurray_idx` (`amenityId`),
  CONSTRAINT `good_amenity_hurray` FOREIGN KEY (`amenityId`) REFERENCES `amenties` (`amenityId`),
  CONSTRAINT `good_roomnumber_hurray` FOREIGN KEY (`roomNumber`) REFERENCES `roomdata` (`roomNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roomdata`
--

DROP TABLE IF EXISTS `roomdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomdata` (
  `roomNumber` int NOT NULL,
  `roomType` varchar(45) NOT NULL,
  `standardOccupancy` int NOT NULL,
  `maximumOccupancy` int NOT NULL,
  `basePrice` decimal(10,2) NOT NULL,
  `extraPersonPrice` decimal(10,2) NOT NULL,
  `adaAccessable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`roomNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-13 19:52:18
