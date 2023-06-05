package sg.jst.superSightingsDatabase.DTO;

public class sightingEventDTO{
    private int SightingEventId;
    private int SuperHeroId;
    private int SL_ID;
    private String EventDate;
    private String SuperHeroName;
    private String LocationName;

    public String getSuperHeroName() {
        return SuperHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        SuperHeroName = superHeroName;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public int getSightingEventId() {
        return SightingEventId;
    }

    public void setSightingEventId(int sightingEventId) {
        SightingEventId = sightingEventId;
    }

    public int getSuperHeroId() {
        return SuperHeroId;
    }

    public void setSuperHeroId(int superHeroId) {
        SuperHeroId = superHeroId;
    }

    public int getSL_ID() {
        return SL_ID;
    }

    public void setSL_ID(int SL_ID) {
        this.SL_ID = SL_ID;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }
}
