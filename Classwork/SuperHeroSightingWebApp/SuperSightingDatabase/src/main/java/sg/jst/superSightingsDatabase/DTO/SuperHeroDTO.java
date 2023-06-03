package sg.jst.superSightingsDatabase.DTO;

public class SuperHeroDTO {

    private int SuperHeroId;
    private String Name;
    private String SuperPower;
    private String Description;

    public int getSuperHeroId() {
        return SuperHeroId;
    }

    public void setSuperHeroId(int superHeroId) {
        SuperHeroId = superHeroId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSuperPower() {
        return SuperPower;
    }

    public void setSuperPower(String superPower) {
        SuperPower = superPower;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
