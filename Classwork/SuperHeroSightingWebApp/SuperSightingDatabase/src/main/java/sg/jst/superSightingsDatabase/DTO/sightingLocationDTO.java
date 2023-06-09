package sg.jst.superSightingsDatabase.DTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class sightingLocationDTO {
    private int SL_ID;

    @NotBlank(message = "Name cannot be blank.")
    @Size(max = 45, message = "Name  must be 45 characters or less.")
    private String Name;

    @NotBlank(message = "Description cannot be blank.")
    @Size(max = 200, message = "Description  must be 200 characters or less.")
    private String Description;

    @NotBlank(message = "Address cannot be blank.")
    @Size(max = 200, message = "Address  must be 200 characters or less.")
    private String Address;

    @NotBlank(message = "City cannot be blank.")
    @Size(max = 45, message = "City  must be 45 characters or less.")
    private String City;

    @NotBlank(message = "State cannot be blank.")
    @Size(max = 45, message = "State  must be 45 characters or less.")
    private String State;

    @NotBlank(message = "Zip cannot be blank.")
    @Size(max = 45, message = "Zip  must be 45 characters or less.")
    private String Zip;

    @NotNull(message = "Latitude cannot be blank.")
    @Digits(integer = 10, fraction = 8, message = "Latitude has to be a valid coordinate.")
    private double Latitude;

    @NotNull(message = "Longitude cannot be blank.")
    @Digits(integer = 10, fraction = 8, message = "Longitude has to be a valid coordinate.")
    private double Longitude;

    public int getSL_ID() {
        return SL_ID;
    }

    public void setSL_ID(int SL_ID) {
        this.SL_ID = SL_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
