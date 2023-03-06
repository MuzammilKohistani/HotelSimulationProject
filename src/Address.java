public class Address {

    private String addressText;
    private String district;
    private String city;

    public Address(String city, String district, String text) {
        this.city=city;
        this.district=district;
        this.addressText = text; 
    }


    public String getText() {

        return addressText;
    }

    public void setText(String text) {

        this.addressText = text;
    }

    public String getDistrict() {

        return district;
    }

    public void setDistrict(String district) {

        this.district = district;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }


}
