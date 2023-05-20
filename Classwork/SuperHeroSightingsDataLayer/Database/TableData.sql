

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'FrantasticFive','101 Main Street','St. Paul','MN','55125','Headquarters','651-555-1212'),(2,'JokersGang','900 Crime Lane','Minneapolis','MN','55421','HangOut','612-555-1212');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sightingevent`
--

LOCK TABLES `sightingevent` WRITE;
/*!40000 ALTER TABLE `sightingevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `sightingevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sightinglocation`
--

LOCK TABLES `sightinglocation` WRITE;
/*!40000 ALTER TABLE `sightinglocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `sightinglocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `superhero`
--

LOCK TABLES `superhero` WRITE;
/*!40000 ALTER TABLE `superhero` DISABLE KEYS */;
INSERT INTO `superhero` VALUES (1,'Johnny Storm','Fire','The Human Torch'),(2,'Ben Grimm','Strength','The Thing'),(3,'Lyja Storm','ShapeShift','Ms. Fantastic '),(4,'Joker','None','Chemical Engineering to make lethal poisions.'),(5,'Harley Quinn','Strength','Combat Expert');
/*!40000 ALTER TABLE `superhero` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `org_to_superhero` WRITE;
/*!40000 ALTER TABLE `org_to_superhero` DISABLE KEYS */;
INSERT INTO `org_to_superhero` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,2),(5,5,2);
/*!40000 ALTER TABLE `org_to_superhero` ENABLE KEYS */;
UNLOCK TABLES;

