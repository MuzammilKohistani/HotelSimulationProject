
public class Room {

	public int roomCount;
	
	//public int roomId;
	private String roomType;
	private boolean air;
	private boolean balcony;
	private int price;
	
	Room(int noOfRooms, String roomType, boolean air, boolean balcony, int price) {
		if(roomType.equals("regular") || roomType.equals("deluxe") || roomType.equals("suite")) {
			setType(roomType);
		}
		else setType("regular");
		setAir(air);
		setBalcony(balcony);
		setPrice(price);
		roomCount+=noOfRooms;
	}
	
	public String getType() {
	    return roomType;
	}

	public void setType(String newType) {
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
	
	public int getPrice() {
	    return price;
	}

	public void setPrice(int newPrice) {
	    this.price = newPrice;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
