public class Customer {

	// Instance variables
	private int customerID;
	private String name;
	private String surname;
	private String gender;
	private Date bDate;
	private Address address;
	private Phone phone;

	// Constructor
	public Customer(int id, String name, String surname, String gender, Date bDate, Address address, Phone phone) {
		// Assign values to instance variables
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.bDate = bDate;
		this.address = address;
		this.phone = phone;
		this.customerID = id;
	}

	// Returns formatted string of customer information
	public String getCustomerInformation() {
		// Format customer information
		String id = String.format("%-9s", "Customer  #" + this.customerID);
		String name = String.format("%-22s", this.name + " " + this.surname);
		String gender = String.format("%-13s", this.gender);
		String birthdate = String.format("%-19s", this.bDate.getDateAsString());
		String city = String.format("%-19s", this.address.getCity());
		String phone = String.format("%-19s", this.phone.getPhoneAsString());

		// Combine formatted customer information and return
		return String.format("\t%s\t%s\t%s\t%s\t%s\t%s", id, name, gender, birthdate, city, phone);
	}

	// Getters and setters for instance variables
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return name;
	}

	public void setCustomerName(String newCustomerName) {
		this.name = newCustomerName;
	}

	public String getCustomerSurname() {
		return surname;
	}

	public void setCustomerSurname(String surname) {
		this.surname = surname;
	}

	public void setCusGender(String gen) {
		this.gender = gen;
	}

	public String getCusGen() {
		return gender;
	}

	public void setCusbdate(Date bdate) {
		this.bDate = bdate;
	}

	public Date getCusbDate() {
		return bDate;
	}

	public void setCusAddress(Address address) {
		this.address = address;
	}

	public Address getCusAddress() {
		return address;
	}

	public void setCusPhone(Phone phone) {
		this.phone = phone;
	}

	public Phone getCusPhone() {
		return phone;
	}

}
