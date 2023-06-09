package sg.jst.superSightingsDatabase.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SuperHeroDTO {

    private int SuperHeroId;
    @NotBlank(message = "Name cannot be blank.")
    @Size(max = 45, message = "Name  must be 45 characters or less.")
    private String Name; // Used for easier transfer between controller and html.

    private String SuperPower; // Used for easier transfer between controller and html.
    private int SuperPowerId;

    @NotBlank(message = "Description cannot be blank.")
    @Size(max = 45, message = "Description  must be 45 characters or less.")
    private String Description;

    public int getSuperPowerId() {
        return SuperPowerId;
    }

    public void setSuperPowerId(int superPowerId) {
        SuperPowerId = superPowerId;
    }



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
