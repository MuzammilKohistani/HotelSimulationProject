/**
 * The Phone class represents a phone number with its country code, city code
 * and number.
 */
public class Phone {

	// Fields
	private String countryCode; // The country code of the phone number
	private String cityCode; // The city code of the phone number
	private String number; // The actual number of the phone number

	/**
	 * Constructs a new Phone object with the given country code, city code and
	 * number.
	 * 
	 * @param countryCode The country code of the phone number.
	 * @param cityCode    The city code of the phone number.
	 * @param number      The actual number of the phone number.
	 */
	public Phone(String countryCode, String cityCode, String number) {
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.number = number;
	}

	/**
	 * Returns the phone number as a concatenated string of country code, city code
	 * and number.
	 * 
	 * @return The phone number as a concatenated string of country code, city code
	 *         and number.
	 */
	public String getPhoneAsString() {

		return countryCode + cityCode + number;
	}

	// Getters and Setters
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
