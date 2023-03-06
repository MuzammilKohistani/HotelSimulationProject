public class Room {

	public static int roomCount = 0;
	
	public static int ID = 1;
	
	private int roomID;
	private String roomType;
	private boolean air;
	private boolean balcony;
	private int price;
	
	Room(int roomID, String roomType, boolean air, boolean balcony, int price) {
		
		if(roomType.equals("regular") || roomType.equals("deluxe") || roomType.equals("suite")) {
			
			this.roomType=roomType;
		
		}
		else this.roomType="regular";
		
		this.air=air;
		this.balcony=balcony;
		this.price=price;
		this.roomID=roomID;
		roomCount++;
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
	
	public int getID() {
	    return roomID;
	}

	public void setID(int newID) {
	    this.roomID = newID;
	}
	
	public static void addRooms(Room[] rooms, int noOfRooms, String roomType, boolean air, boolean balcony, int price) {
		int roomsToAdd = 0;
		if(Room.roomCount + noOfRooms > 50) // if rooms to be added exceeds 50
			roomsToAdd = 50 - Room.roomCount; // add 50th and stop
		else roomsToAdd = noOfRooms;
		for(int i=0; i<roomsToAdd; i++)
		{
			rooms[ID-1] = new Room(ID, roomType, air, balcony, price);      				
			ID++;
		}
	}
	
	public static void listRooms(Room[] rooms) {
		for(int i=0; i<Room.roomCount; i++) {
			String air = rooms[i].getAir() ? "aircondition" : "no-aircondition";
			String balcony = rooms[i].getBalcony() ? "balcony" : "no-balcony";
			System.out.format("   Room #%d %-8s %-16s %-11s %dTL", rooms[i].getID(), rooms[i].getType(), air, balcony, rooms[i].getPrice());
			System.out.println();
		}		
	}
	
}