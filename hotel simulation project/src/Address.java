/**
 * 
 * The Address class represents an address.
 */
public class Address {

// Fields
	private String text;
	private String district;
	private String city;

	/**
	 * 
	 * Constructor for Address class.
	 * 
	 * @param city     The name of the city.
	 * @param district The name of the district.
	 * @param text     The text part of the address.
	 */
	public Address(String city, String district, String text) {
		this.city = city;
		this.district = district;
		this.text = text;
	}

	// Getters and Setters
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
