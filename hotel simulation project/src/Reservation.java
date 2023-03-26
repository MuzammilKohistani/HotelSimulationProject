/**
 * 
 * The Reservation class represents a booking made by a customer for a specific
 * room during a specific time period.
 */
public class Reservation {
	private int customerId;
	private int roomId;
	private Date arrivalDate;
	private Date departureDate;

	/**
	 * 
	 * Creates a new Reservation object with the given customer ID, room ID, arrival
	 * date, and departure date.
	 * 
	 * @param customerId    the ID of the customer making the reservation
	 * @param roomId        the ID of the room being reserved
	 * @param arrivalDate   the date the customer is scheduled to arrive
	 * @param departureDate the date the customer is scheduled to depart
	 */
	public Reservation(int customerId, int roomId, Date arrivalDate, Date departureDate) {
		this.customerId = customerId;
		this.roomId = roomId;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	/**
	 * 
	 * Returns a formatted string representing the reservation information,
	 * including the room ID, customer name,
	 * 
	 * arrival date, and departure date.
	 * 
	 * @param fullname the full name of the customer making the reservation
	 * 
	 * @return a formatted string representing the reservation information
	 */
	public String getReservationInformation(String fullname) {
		String roomId = String.format("%-9s", "Room #" + this.roomId);
		String name = String.format("%-22s", fullname);
		String arrDate = String.format("%-13s", this.arrivalDate.getDateAsString());
		String depDate = String.format("%-19s", this.departureDate.getDateAsString());

		return String.format("\t%s\t%s\t%s\t%s", roomId, name, arrDate, depDate);
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getRoomId() {
		return roomId;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
}