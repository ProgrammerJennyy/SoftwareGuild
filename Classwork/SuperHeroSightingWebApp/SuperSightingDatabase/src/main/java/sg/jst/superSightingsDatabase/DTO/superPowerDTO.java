package sg.jst.superSightingsDatabase.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class superPowerDTO {


    private int superPowerId;

    public String getSuperPowerName() {
        return superPowerName;
    }

    public void setSuperPowerName(String superPowerName) {
        this.superPowerName = superPowerName;
    }
    @NotBlank(message = "Power name cannot be blank.")
    @Size(max = 45, message = "The name of the power must be 45 characters or less.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Powers cannot contain a number.")
    private String superPowerName;

    public int getSuperPowerId() {
        return superPowerId;
    }

    public void setSuperPowerId(int superPowerId) {
        this.superPowerId = superPowerId;
    }
}
