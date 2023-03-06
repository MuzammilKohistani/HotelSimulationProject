public class Customer {


	private String customerName;
	private String customerSurname;
	private String customerGender;
	private Date customerBirthDate;
	private Address customerAddress ;
	private Phone phoneNumber;

	public Customer(String name, String surname, String gender, Date birthDate, String addressText, String district,
			String city, String phoneNumber) {

		customerName = name;
		customerSurname = surname;
		customerGender = gender;
		customerBirthDate = birthDate;
		customerAddress = new Address(city,district,addressText);
		this.phoneNumber = new Phone(phoneNumber);
	}

	private int customerId;
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}


}

