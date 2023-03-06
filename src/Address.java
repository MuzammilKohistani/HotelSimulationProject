public class Address {

    private String text;
    private String district;
    private String city;

    public Address(String city, String district, String text) {
        this.city=city;
        this.district=district;
        this.text = text; 
    }


    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
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
