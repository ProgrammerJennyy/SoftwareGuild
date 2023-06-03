
DROP DATABASE IF EXISTS superherosightings;
CREATE DATABASE superherosightings;

USE superherosightings;

DROP TABLE IF EXISTS `superpower`;
CREATE TABLE `superpower` (
  `SuperPowerId` int NOT NULL AUTO_INCREMENT,
  `SuperPowerName` varchar(45) NOT NULL,
  PRIMARY KEY (`SuperPowerId`)
) ;



DROP TABLE IF EXISTS `superhero`;

CREATE TABLE `superhero` (
  `SuperHeroId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `SuperPowerId` int NOT NULL DEFAULT '1',
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SuperHeroId`),
  KEY `sp_id_idx` (`SuperPowerId`),
  CONSTRAINT `sp_id` FOREIGN KEY (`SuperPowerId`) REFERENCES `superpower` (`SuperPowerId`)
) COMMENT='Requirement: Heroes have names, descriptions, and a superpower.';


DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `OrganizationId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(2) DEFAULT NULL,
  `Zip` varchar(45) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OrganizationId`)
)  COMMENT='Requirement: It must keep track of all superhero/supervillain organization information: Organizations have names, descriptions, and address/contact information.\\rOrganizations have members.';




DROP TABLE IF EXISTS `sightinglocation`;
CREATE TABLE `sightinglocation` (
  `SL_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(2) DEFAULT NULL,
  `Zip` varchar(45) DEFAULT NULL,
  `Latitude` decimal(12,8) DEFAULT NULL,
  `Longitude` decimal(12,8) DEFAULT NULL,
  PRIMARY KEY (`SL_ID`)
) COMMENT='Requirement:\nIt must keep track of all location information:\nLocations have names, descriptions, address information, and latitude/longitude coordinates.';




DROP TABLE IF EXISTS `sightingevent`;

CREATE TABLE `sightingevent` (
  `SightingEventId` int NOT NULL AUTO_INCREMENT,
  `SuperHeroId` int DEFAULT NULL,
  `SL_ID` int DEFAULT NULL,
  `EventDate` datetime NOT NULL,
  PRIMARY KEY (`SightingEventId`),
  KEY `SHID_idx` (`SuperHeroId`),
  KEY `LOCID_idx` (`SL_ID`),
  CONSTRAINT `LOCID` FOREIGN KEY (`SL_ID`) REFERENCES `sightinglocation` (`SL_ID`),
  CONSTRAINT `SHID` FOREIGN KEY (`SuperHeroId`) REFERENCES `superhero` (`SuperHeroId`)
) COMMENT='Requirement:\nA user must be able to record a superhero/supervillain sighting for a particular location and date';




DROP TABLE IF EXISTS `org_to_superhero`;
CREATE TABLE `org_to_superhero` (
  `orgToShID` int NOT NULL AUTO_INCREMENT,
  `SuperHeroId` int DEFAULT NULL,
  `OrganizationId` int DEFAULT NULL,
  PRIMARY KEY (`orgToShID`),
  KEY `OrgExists_idx` (`OrganizationId`),
  KEY `SHExists_idx` (`SuperHeroId`),
  CONSTRAINT `OrgExists` FOREIGN KEY (`OrganizationId`) REFERENCES `organization` (`OrganizationId`),
  CONSTRAINT `SHExists` FOREIGN KEY (`SuperHeroId`) REFERENCES `superhero` (`SuperHeroId`)
)  COMMENT='Requirements:\nThe system must be able to report all of the members of a particular organization.\nThe system must be able to report all of the organizations a particular superhero/villain belongs to.\nHeroes are affiliated with one or more superhero/supervillain organizations.';
