
public class Reservation {

	//public int reservationId;
	private int customerID;
	private int roomID;
	// dates
	
	Reservation(int customerId, int roomId, Date dateOfArrival, Date dateOfDeparture) {
		if(true) { // expected to make res. between 01.01.2024 - 12.12.2024
			setCustomerID(customerID);
			setRoomID(roomID);
			// setting date
		}
		// else ignored
	}
	
	public int getCustomerID() {
	    return customerID;
	}

	public void setCustomerID(int newCustomerID) {
	    this.customerID = newCustomerID;
	}
	
	public int getRoomID() {
	    return roomID;
	}

	public void setRoomID(int newRoomID) {
	    this.roomID = newRoomID;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
