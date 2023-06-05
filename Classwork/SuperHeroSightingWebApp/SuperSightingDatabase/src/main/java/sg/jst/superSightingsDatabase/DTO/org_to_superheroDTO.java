package sg.jst.superSightingsDatabase.DTO;

public class org_to_superheroDTO {
    private int orgToShID;
    private int SuperHeroId;

    public String getSuperHeroName() {
        return SuperHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        SuperHeroName = superHeroName;
    }

    private String SuperHeroName;
    private int OrganizationId;

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    private String OrganizationName;

    public int getOrgToShID() {
        return orgToShID;
    }

    public void setOrgToShID(int orgToShID) {
        this.orgToShID = orgToShID;
    }

    public int getSuperHeroId() {
        return SuperHeroId;
    }

    public void setSuperHeroId(int superHeroId) {
        SuperHeroId = superHeroId;
    }

    public int getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(int organizationId) {
        OrganizationId = organizationId;
    }
}
