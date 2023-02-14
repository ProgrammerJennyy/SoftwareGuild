




use hotel;

/*
1. Write a query that returns a list of reservations that end in July 2023, including the name of the guest, the room number(s),
and the reservation dates.
*/
select gu.Name, re.roomNumber,re.startDate,re.endDate
from reservations re
inner join guests gu  on gu.guestId = re.guestId
where month(re.endDate)=7 and year(re.endDate)=2023
;



/*
2. Write a query that returns a list of all reservations for rooms with a jacuzzi, displaying the guest's name, the room number,
and the dates of the reservation.
*/
select gu.Name, re.roomNumber,re.startDate,re.endDate,am.amenityName
from reservations re
inner join guests gu  on gu.guestId = re.guestId
inner join `roomamenties` ra on ra.roomNumber = re.roomNumber
inner join `amenties` am on am.amenityId = ra.amenityId
where am.amenityName="Jacuzzi"
;


/*
3. Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the
starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the
existing data.)
*/


SELECT
gu.Name,
re.roomNumber,
re.startDate,
re.Adults + re.Children AS numberPeople
FROM reservations re
INNER JOIN guests gu
ON gu.guestId = re.guestId
WHERE gu.Name = 'Jennifer Trongard' ;






/*
4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include
all rooms, whether or not there is a reservation associated with the room.
*/

use hotel;


SELECT
rd.roomNumber,
re.Reservation,
re.startDate,
re.endDate,
CASE WHEN (re.Adults - rd.standardOccupancy)>0 -- when there are extra adults
THEN rd.basePrice*DATEDIFF(re.endDate, re.startDate) + (re.Adults - rd.standardOccupancy)*rd.extraPersonPrice*DATEDIFF(re.endDate, re.startDate) -- add the extra charge per person
 ELSE rd.basePrice*DATEDIFF(re.endDate, re.startDate) END AS totalCost
FROM reservations re
RIGHT JOIN roomdata rd
ON rd.roomNumber = re.roomNumber
;

/*
5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April
2023.

*/

use hotel;

SELECT
rd.roomNumber,
re.Reservation,
rd.maximumOccupancy,
re.startDate,
re.endDate
 FROM reservations re
INNER JOIN roomdata rd
ON rd.roomNumber = re.roomNumber
WHERE rd.maximumOccupancy>=3 AND MONTH(re.startDate)=4
;

/*
6. Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest
with the most reservations and then by the guest's last name.
*/

SELECT
SUBSTRING_INDEX(gu.Name,' ',-1) AS lastname,
SUBSTRING_INDEX(gu.Name,' ',1) AS firstname,
 count(re.guestId) AS guest_number_times
 FROM reservations re
 inner join guests gu on gu.guestId = re.guestId
group by re.guestId
ORDER BY guest_number_times DESC, lastname desc;

/*
7. Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phon
number from the existing data.)
*/
use hotel;

SELECT
gu.Name,
gu.Address,
gu.City,
gu.stateAbbr,
gu.Zip,
gu.Phone
 FROM reservations re
 inner join guests gu on gu.guestId = re.guestId
where gu.phone ="(763) 555-1212";
