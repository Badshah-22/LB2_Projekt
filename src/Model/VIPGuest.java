package Model;

public class VIPGuest {


    private int VIPGuestId;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String Telephone;
    private String MobileTelephone;
    private String Email;
    private int postcode;
    private String StreetAndNumber;
    private String Place;

    public VIPGuest() {
    }

    public VIPGuest(int VIPGuestId, String firstName, String lastName, String birthDate, String telephone, String mobileTelephone, String email, int postcode, String streetAndNumber, String place) {
        this.VIPGuestId = VIPGuestId;
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        Telephone = telephone;
        MobileTelephone = mobileTelephone;
        Email = email;
        this.postcode = postcode;
        StreetAndNumber = streetAndNumber;
        Place = place;
    }

    public int getVIPGuestId() {
        return VIPGuestId;
    }

    public void setVIPGuestId(int VIPGuestId) {
        this.VIPGuestId = VIPGuestId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getMobileTelephone() {
        return MobileTelephone;
    }

    public void setMobileTelephone(String mobileTelephone) {
        MobileTelephone = mobileTelephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getStreetAndNumber() {
        return StreetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        StreetAndNumber = streetAndNumber;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }
}



