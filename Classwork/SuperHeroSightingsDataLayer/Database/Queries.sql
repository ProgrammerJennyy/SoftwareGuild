use superherosightings;

-- The system must be able to report all of the superheroes 
-- sighted at a particular location
-- -----------------------------------------------------

SELECT 
sh.Name
,sh.SuperPower
,sh.Description
,se.EventDate
FROM superhero sh
INNER JOIN sightingevent se
ON sh.SuperHeroId = se.SuperHeroId
INNER JOIN sightinglocation sl
ON sl.SL_ID = se.SL_ID
WHERE sl.Name = "Xcel Center" ;


-- The system must be able to report all of the locations
--  where a particular superhero has been seen.
-- -----------------------------------------------------
SELECT 
sh.Name
,sl.Name
,se.EventDate
FROM superhero sh
INNER JOIN sightingevent se
ON sh.SuperHeroId = se.SuperHeroId
INNER JOIN sightinglocation sl
ON sl.SL_ID = se.SL_ID
WHERE sh.Name = "Johnny Storm" ;

-- The system must be able to report all sightings
--  (hero and location) for a particular date.
-- -----------------------------------------------------
SELECT 
sh.Name
,sl.Name
,se.EventDate
FROM superhero sh
INNER JOIN sightingevent se
ON sh.SuperHeroId = se.SuperHeroId
INNER JOIN sightinglocation sl
ON sl.SL_ID = se.SL_ID
WHERE se.EventDate = "2023-05-20" ;

-- The system must be able to report all of the members
--  of a particular organization.
-- -----------------------------------------------------
SELECT 
sh.Name
,org.Name
FROM superhero sh
INNER JOIN `org_to_superhero` os
ON os.SuperHeroId = sh.SuperHeroId
INNER JOIN organization org
ON org.OrganizationId = os.OrganizationId
WHERE org.Name = "FrantasticFive" ;

-- The system must be able to report all of the
--  organizations a particular superhero/villain belongs to.
-- -----------------------------------------------------
SELECT 
sh.Name
,org.Name
FROM superhero sh
INNER JOIN `org_to_superhero` os
ON os.SuperHeroId = sh.SuperHeroId
INNER JOIN organization org
ON org.OrganizationId = os.OrganizationId
WHERE sh.Name = "Joker";