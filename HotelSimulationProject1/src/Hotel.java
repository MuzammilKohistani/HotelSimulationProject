
public class Hotel {
	
	private String name;
	private int stars;
	Date date = new Date();
	Address adress = new Address();
	Phone phone = new Phone();
	
	public String getName() {
	    return name;
	}

	public void setName(String newName) {
	    this.name = newName;
	}
	
	public int getStars() {
	    return stars;
	}

	public void setStars(int newStars) {
	    this.stars = newStars;
	}
	
	 
	Hotel() {
		this.setName("DeuCeng");
		this.setStars(4);
	}
	
	Hotel(String name, int stars) {
		this.setName(name);
		this.setStars(stars);
	}

	public static void main(String[] args) {
			
		Hotel hotel = new Hotel("deuceng",5);
		
		System.out.println(hotel.name + " " + hotel.stars);
		
		hotel.adress.setText("adress123");
		System.out.println("adress: "+ hotel.adress.getText());
		
		hotel.phone.setNumber(123456789);
		System.out.println("hotel no: " + hotel.phone.getNumber());
		
	}

}
