
public class Customer {

	//public int customerId;
	private String customerName;
	// contact adress - phone
	
	
	Customer(String name, Address contactAdress, Phone phone) {
		
		setCustomerName(name);
		// setting adress - phone
	}
	
	public String getCustomerName() {
	    return customerName;
	}

	public void setCustomerName(String newCustomerName) {
	    this.customerName = newCustomerName;
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
