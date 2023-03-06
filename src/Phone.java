public class Phone {

    private int countryCode;
    private int cityCode;
    private int number;

    
    public Phone(int number, int cityCode, int countryCode) {
        setNumber(number);
        setCityCode(cityCode);
        setCountryCode(countryCode);
    }
    
    public Phone(String PhoneNumberAsString) {
    	
    	if(PhoneNumberAsString.trim().replace(" ","").length() >= 13 ) {
    		
    		PhoneNumberAsString = PhoneNumberAsString.replace("+", "").trim();
    		
    		if(isNumberic(PhoneNumberAsString) && PhoneNumberAsString.length()==12 ) {
    			
    			setCountryCode(Integer.parseInt(PhoneNumberAsString.substring(0, 2)));
    			setCityCode(Integer.parseInt(PhoneNumberAsString.substring(2, 5)));
    			setNumber(Integer.parseInt(PhoneNumberAsString.substring(5)));
    		}
    		
    	}
    	
    	
    	
    }
    

    public String getDateAsString() {

        return "+" + getCountryCode() + " (" + getCityCode() + ") " + getNumber();
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public static boolean isNumberic(String stringNumber) {
    	
    	try {
    		
    		Integer.parseInt(stringNumber);
    		return true;
    	}
    	catch(Exception e) {
    		return false; 
    	}
    }
    
    
    

}
