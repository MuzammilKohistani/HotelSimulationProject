
public class Address {
	
    private String text; 
    private String district;  
    private String city;
    
    public Address(String city, String district, String text) {
        setCity(city);
        setDistrict(district);
        setText(text);
    }
    
    public Address() {
    }
    
	public String getText() {
	    return text;
	}

	public void setText(String newText) {
	    this.text = newText;
	}
	
	public String getDistrict() {
	    return district;
	}

	public void setDistrict(String newDistrict) {
	    this.district = newDistrict;
	}
	
	public String getCity() {
	    return city;
	}

	public void setCity(String newCity) {
	    this.city = newCity;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
