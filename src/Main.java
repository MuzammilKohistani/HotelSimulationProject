import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	static Room[] rooms = new Room[30];
	static Staff[] staff = new Staff[50];
	Date date;
	Address address;
	Phone phone;
	static String[] CommandsArray;

	public static void main(String[] args) {

		try {

			BufferedReader reader = new BufferedReader(new FileReader("commands.txt"));

			String line = reader.readLine();

			while (line != null) {

				System.out.println(line);
				
				if (!line.isBlank()) {
					
					String[] command = line.trim().split(";");
					String firstPart = command[0].trim().toLowerCase();
					
					if (firstPart.equals("addemployee") && command.length == 11) {

						int indexNumber = firstNull(staff);

						if (indexNumber != -1) {

							staff[indexNumber] = new Staff(command[1], command[2], command[3], new Date(command[4]),
									new Address(command[5], command[6], command[7]), new Phone(command[8]), command[9],
									Integer.parseInt(command[10]));
							Staff.setStaffId();

						} else {
							System.out.println("we will call you");
						}

					} 
					else if (firstPart.equals("listemployees") && command.length == 1) {

						for (int i = 0; i < staff.length; i++) {

							if (staff[i] != null) {

								System.out.println("\t"+staff[i].getEmployeeInformation());
							}
						}

					}
					else if (firstPart.equals("deleteemployee")) {
						
						for (int i = 0; i < staff.length; i++) {
							
							if(staff[i]!=null   &&   staff[i].getEmployeeId() == Integer.parseInt(command[1].trim())) {
								
								staff[i] = null;
							}
							
						}
						
					}
					else if (firstPart.equals("addroom")) {
	        			Room.addRooms(rooms, Integer.parseInt(command[1]),command[2],Boolean.parseBoolean(command[3]),Boolean.parseBoolean(command[4]),Integer.parseInt(command[5]));
	        		}
					else if(firstPart.equals("listrooms")) {
						Room.listRooms(rooms);
					}

				}

				line = reader.readLine();
			}
			reader.close();
						
		} catch (FileNotFoundException efd) {

			CommandsArray = null;
			System.out.println(
					"Sorry, we were unable to access the text file.\nPlease check the name and location of your file and try again");

		} catch (Exception e) {

			System.out.println(e.getLocalizedMessage());
		}

	}

	public static int firstNull(Staff[] staff) {

		int firstNullIndex = -1;
		for (int i = 0; i < staff.length; i++) {

			if (staff[i] == null) {
				firstNullIndex = i;
				break;
			}
		}
		return firstNullIndex;
	}

}