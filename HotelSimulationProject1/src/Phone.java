
public class Phone {

    public String countryCode; 
    public String cityCode;  
    public int number; 
    
    public Phone(String countryCode, String cityCode, int number) {
        setCountryCode(countryCode);
        setCityCode(cityCode);
        setNumber(number);
    }
    
    public Phone() {
    }
    
	public int getNumber() {
	    return number;
	}

	public void setNumber(int newNo) {
	    this.number = newNo;
	}
	
	public int getCountryCode() {
	    return number;
	}

	public void setCountryCode(String newCountryCode) {
	    this.countryCode = newCountryCode;
	}
	
	public String getCityCode() {
	    return cityCode;
	}

	public void setCityCode(String newCityCode) {
	    this.cityCode = newCityCode;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
