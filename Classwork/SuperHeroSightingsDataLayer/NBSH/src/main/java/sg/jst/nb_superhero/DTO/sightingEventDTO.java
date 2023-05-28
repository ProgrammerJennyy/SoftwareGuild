package sg.jst.nb_superhero.DTO;

public class sightingEventDTO{
    private int SightingEventId;
    private int SuperHeroId;
    private int SL_ID;
    private String EventDate;

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
