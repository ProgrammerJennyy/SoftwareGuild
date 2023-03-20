--
-- Table structure for table `bullandcow`
--
USE tododb; 
DROP TABLE IF EXISTS `bullandcow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bullandcow` (
  `gameId` int NOT NULL,
  `roundTime` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secret` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `guess` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `finished` tinyint(1) DEFAULT '0',
  `primarykeyId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`primarykeyId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bullandcow`
--

LOCK TABLES `bullandcow` WRITE;
/*!40000 ALTER TABLE `bullandcow` DISABLE KEYS */;
INSERT INTO `bullandcow` VALUES (1,'2023-03-13_22:59:33','3546','begin',0,21),(1,'2023-03-13_23:00:10','3546','1234',0,22),(1,'2023-03-13_23:00:40','3546','3456',0,23),(1,'2023-03-13_23:00:50','3546','3546',1,24),(2,'2023-03-13_23:01:05','2034','begin',0,25),(2,'2023-03-13_23:03:11','2034','1234',0,26),(2,'2023-03-13_23:03:20','2034','5678',0,27);
/*!40000 ALTER TABLE `bullandcow` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2023-03-13 23:04:50
