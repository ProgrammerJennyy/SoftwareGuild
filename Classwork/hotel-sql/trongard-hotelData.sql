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
-- Dumping data for table `amenties`
--

LOCK TABLES `amenties` WRITE;
/*!40000 ALTER TABLE `amenties` DISABLE KEYS */;
INSERT INTO `amenties` VALUES (1,'microwave'),(2,'jacuzzi '),(3,'oven'),(4,'refrigerator ');
/*!40000 ALTER TABLE `amenties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `guests`
--

LOCK TABLES `guests` WRITE;
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
INSERT INTO `guests` VALUES ('Jennifer Trongard ','123 Main Street','Anoka ','MN','55303','(763) 555-1212',1),('Mack Simmer','379 Old Shore Street','Council Bluffs','IA','51501','(291) 553-0508',2),('Bettyann Seery','750 Wintergreen Dr.','Wasilla','AK','99654','(478) 277-9632',3),('Duane Cullison','9662 Foxrun Lane','Harlingen','TX','78552','(308) 494-0198',4),('Karie Yang','9378 W. Augusta Ave.','West Deptford','NJ','8096','(214) 730-0298',5),('Aurore Lipton','762 Wild Rose Street','Saginaw','MI','48601','(377) 507-0974',6),('Zachery Luechtefeld','7 Poplar Dr.','Arvada','CO','80003','(814) 485-2615',7),('Jeremiah Pendergrass','70 Oakwood St.','Zion','IL','60099','(279) 491-0960',8),('Walter Holaway','7556 Arrowhead St.','Cumberland','RI','2864','(446) 396-6785',9),('Wilfred Vise','77 West Surrey Street','Oswego','NY','13126','(834) 727-1001',10),('Maritza Tilton','939 Linda Rd.','Burke','VA','22015','(446) 351-6860',11),('Joleen Tison','87 Queen St.','Drexel Hill','PA','19026','(231) 893-2755',12);
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (203,3,2,1,'2002-05-23','2002-10-23',999.95,1),(201,5,2,2,'2003-06-23','2003-07-23',199.99,2),(308,2,1,0,'2002-02-23','2002-04-23',299.98,3),(302,6,3,0,'2023-03-18','2023-03-23',924.95,4),(304,6,3,0,'2023-06-17','2023-06-18',184.99,5),(203,3,2,1,'2023-02-05','2023-02-10',999.95,6),(303,3,2,1,'2023-07-28','2023-07-29',199.99,7),(305,3,1,0,'2023-08-30','2023-09-01',349.98,8),(305,4,2,0,'2023-02-22','2023-02-24',349.98,9),(401,4,2,2,'2023-11-22','2023-11-25',1199.97,10),(304,8,2,0,'2023-03-31','2023-04-05',874.95,11),(206,12,2,0,'2023-06-10','2023-06-14',599.96,12),(208,12,1,0,'2023-06-10','2023-06-14',599.96,13),(201,5,2,2,'2023-03-06','2023-03-07',199.99,14),(203,5,2,2,'2023-09-13','2023-09-15',399.98,15),(308,2,1,0,'2023-02-02','2023-02-04',299.98,16),(208,2,2,0,'2023-09-16','2023-09-17',149.99,17),(206,2,2,0,'2023-11-22','2023-11-25',449.97,18),(301,2,2,2,'2023-11-22','2023-11-25',599.97,19),(401,11,2,4,'2023-05-30','2023-06-02',1199.97,20),(302,11,2,0,'2023-12-24','2023-12-28',699.96,21),(301,9,1,0,'2023-04-09','2023-04-13',799.96,22),(204,9,3,1,'2023-07-13','2023-07-14',184.99,23),(207,10,1,1,'2023-04-23','2023-04-24',174.99,24),(401,10,4,2,'2023-07-18','2023-07-21',1259.97,25),(307,1,1,1,'2023-03-17','2023-03-20',524.97,26),(205,1,2,0,'2023-06-28','2023-07-02',699.96,27),(202,7,2,2,'2023-03-29','2023-03-31',349.98,28);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roomamenties`
--

LOCK TABLES `roomamenties` WRITE;
/*!40000 ALTER TABLE `roomamenties` DISABLE KEYS */;
INSERT INTO `roomamenties` VALUES (201,1,1),(201,2,2),(202,4,3),(203,1,4),(203,2,5),(204,4,6),(205,1,7),(205,2,8),(205,4,9),(206,1,10),(206,4,11),(207,1,12),(207,2,13),(207,4,14),(208,1,15),(208,4,16),(301,2,17),(301,1,18),(302,4,19),(303,1,20),(303,2,21),(304,4,22),(305,1,23),(305,4,24),(305,2,25),(306,1,26),(306,4,27),(307,1,28),(307,4,29),(307,2,30),(308,1,31),(308,4,32),(401,1,33),(401,4,34),(401,3,35),(402,1,36),(402,4,37),(402,3,38);
/*!40000 ALTER TABLE `roomamenties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roomdata`
--

LOCK TABLES `roomdata` WRITE;
/*!40000 ALTER TABLE `roomdata` DISABLE KEYS */;
INSERT INTO `roomdata` VALUES (201,'Double',2,4,199.99,10.00,0),(202,'Double',2,4,174.99,10.00,1),(203,'Double',2,4,199.99,10.00,0),(204,'Double',2,4,174.99,10.00,1),(205,'Single',2,2,174.99,0.00,0),(206,'Single',2,2,149.99,0.00,1),(207,'Single',2,2,174.99,0.00,0),(208,'Single',2,2,149.99,0.00,1),(301,'Double',2,4,199.99,10.00,0),(302,'Double',2,4,174.99,10.00,1),(303,'Double',2,4,199.99,10.00,0),(304,'Double',2,4,174.99,10.00,1),(305,'Single',2,2,174.99,0.00,0),(306,'Single',2,2,149.99,0.00,1),(307,'Single',2,2,174.99,0.00,0),(308,'Single',2,2,149.99,0.00,1),(401,'Suite',3,8,399.99,20.00,1),(402,'Suite',3,8,399.99,20.00,1);
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

-- Dump completed on 2023-01-26 22:05:53
