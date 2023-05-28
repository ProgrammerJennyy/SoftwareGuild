package sg.jst.nb_superhero.DTO;

public class sightingLocationDTO {
    private int SL_ID;
    private String Name;
    private String Description;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    private double Latitude;
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
