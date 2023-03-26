/**
 * The Room class represents a room in a hotel. It contains information such as
 * the room ID, type, whether it has air conditioning or a balcony, and the
 * price of the room.
 */
public class Room {

	// Private member variables
	private int roomID;
	private RoomType roomType;
	private boolean air;
	private boolean balcony;
	private double price;

	// Constructor
	Room(int roomID, RoomType roomType, boolean air, boolean balcony, double price) {
		this.roomType = roomType;
		this.air = air;
		this.balcony = balcony;
		this.price = price;
		this.roomID = roomID;
	}

	// Getters and setters for member variables
	public RoomType getType() {
		return roomType;
	}

	public void setType(RoomType newType) {
		this.roomType = newType;
	}

	public boolean getAir() {
		return air;
	}

	public void setAir(boolean newAir) {
		this.air = newAir;
	}

	public boolean getBalcony() {
		return balcony;
	}

	public void setBalcony(boolean newBalcony) {
		this.balcony = newBalcony;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public int getID() {
		return roomID;
	}

	public void setID(int newID) {
		this.roomID = newID;
	}

	/**
	 * Returns a formatted string containing information about the room, including
	 * its ID, type, whether it has air conditioning or a balcony, and the price.
	 */
	public String getRoomInformation() {
		String roomId = String.format("%-9s", "Room  #" + this.roomID);
		String roomTyp = String.format("%-19s", this.roomType);
		String hasAirConditioning = air ? "aircondition" : "no-aircondition";
		hasAirConditioning = String.format("%-16s", hasAirConditioning);
		String hasBalcony = balcony ? "balcony" : "no-balcony";
		hasBalcony = String.format("%-19s", hasBalcony);

		return String.format("\t%s\t%s\t%s\t%s\t%s", roomId, roomTyp, hasAirConditioning, hasBalcony,
				this.price + " TL");
	}

	// RoomType enumeration
	public static enum RoomType {
		REGULAR, DELUXE, SUITE
	}
}
