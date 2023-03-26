
import java.io.*;

public class Main {
	public static void main(String[] args) {
		run("commands.txt");
	}

	public static void run(String commandFile) {
		Hotel deuceng = new Hotel("DEUCENG", new Date(1, 3, 1800), new Address("Izmir", "Buca", "Tinaptepe"),
				new Phone("90", "111", "1111111"), 4);

		int[] ArrDate1, ArrDate2;
		String[] ArrPhone;
		try (BufferedReader reader = new BufferedReader(new FileReader(commandFile))) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] command = line.split(";");

				if (!line.isBlank())
					System.out.println(line);

				switch (command[0].toLowerCase().trim()) {

				case "addroom":
					int roomsToAdd = 0;
					if (deuceng.roomCount + Integer.parseInt(command[1]) > 30) // if rooms to be added exceeds 30
						roomsToAdd = 30 - deuceng.roomCount; // add until 30th
					else
						roomsToAdd = Integer.parseInt(command[1]);

					for (int i = 0; i < roomsToAdd; i++) {
						Room.RoomType type = null;
						switch (command[2]) {
						case "regular":
							type = Room.RoomType.REGULAR;
							break;
						case "deluxe":
							type = Room.RoomType.DELUXE;
							break;
						case "suite":
							type = Room.RoomType.SUITE;
							break;
						default:
							type = Room.RoomType.REGULAR;
							break;
						}
						deuceng.addRooms(type, Boolean.parseBoolean(command[3]), Boolean.parseBoolean(command[4]),
								Double.parseDouble(command[5]));
					}
					break;
				case "listrooms":
					deuceng.listRooms();
					break;
				case "searchroom":
					ArrDate1 = deuceng.parseDate(command[1]);
					ArrDate2 = deuceng.parseDate(command[2]);
					deuceng.searchRoom(new Date(ArrDate1[0], ArrDate1[1], ArrDate1[2]),
							new Date(ArrDate2[0], ArrDate2[1], ArrDate2[2]));
					ArrDate1 = null;
					ArrDate2 = null;
					break;
				case "addemployee":
					Staff.JobTypes job = null;
					switch (command[9].toLowerCase().replaceAll(" ", "")) {
					case "administrator":
					case "admin":
						job = Staff.JobTypes.ADMINISTRATOR;
						deuceng.setAdminCount(deuceng.getAdminCount() + 1);
						break;
					case "receptionist":
						job = Staff.JobTypes.RECEPTIONIST;
						deuceng.setReceptionistCount(deuceng.getReceptionistCount() + 1);
						break;
					case "housekeeper":
						job = Staff.JobTypes.HOUSEKEEPER;
						deuceng.setHousekeeperCount(deuceng.getHousekeeperCount() + 1);
						break;
					}

					ArrDate1 = deuceng.parseDate(command[4]);
					ArrPhone = deuceng.parsePhone(command[8]);
					deuceng.addEmployee(command[1], command[2], command[3],
							new Date(ArrDate1[0], ArrDate1[1], ArrDate1[2]),
							new Address(command[5], command[6], command[7]),
							new Phone(ArrPhone[0], ArrPhone[1], ArrPhone[2]), job,
							Integer.parseInt(command[10].replaceAll("[^0-9]", "")));
					ArrDate1 = null;
					ArrPhone = null;
					break;
				case "listemployees":
					deuceng.listEmployee();
					break;

				case "deleteemployee":
					try {
						deuceng.deleteEmployee(Integer.parseInt(command[1].replaceAll("[^0-9]", "")));
					} catch (NumberFormatException e) {
						System.err.print("Invalid employee ID type. Please use an integer type for the employee ID.");
					}
					break;

				case "addcustomer":
					ArrDate1 = deuceng.parseDate(command[4]);
					ArrPhone = deuceng.parsePhone(command[8]);

					deuceng.addCustomer(command[1], command[2], command[3],
							new Date(ArrDate1[0], ArrDate1[1], ArrDate1[2]),
							new Address(command[7], command[6], command[5]),
							new Phone(ArrPhone[0], ArrPhone[1], ArrPhone[2]));

					ArrDate1 = null;
					ArrPhone = null;
					break;

				case "listcustomers":

					deuceng.listCustomers();
					break;

				case "searchcustomer":

					deuceng.searchCustomer(command[1]);
					break;

				case "addreservation":
					if (deuceng.getAdminCount() >= 1 && deuceng.getReceptionistCount() >= 1
							&& deuceng.getReceptionistCount() >= 1) {
						try {
							ArrDate1 = deuceng.parseDate(command[3]);
							ArrDate2 = deuceng.parseDate(command[4]);

							deuceng.addReservation(Integer.parseInt(command[1]), Integer.parseInt(command[2]),
									new Date(ArrDate1[0], ArrDate1[1], ArrDate1[2]),
									new Date(ArrDate2[0], ArrDate2[1], ArrDate2[2]));
							ArrDate1 = null;
							ArrDate2 = null;
						} catch (NumberFormatException e) {
							System.err.print("Invalid input");
						}
					} else {
						System.err.println(
								"Sorry, we can't accept new reservations due to a staff shortage. We're working to resolve this soon. Thank you for your patience.");
					}
					break;

				case "listreservations":

					deuceng.listReservations();

					break;

				case "statistics":

					deuceng.statistics();
					break;

				case "simulation":

					ArrDate1 = deuceng.parseDate(command[1]);
					ArrDate2 = deuceng.parseDate(command[2]);
					deuceng.simulation(new Date(ArrDate1[0], ArrDate1[1], ArrDate1[2]),
							new Date(ArrDate2[0], ArrDate2[1], ArrDate2[2]));
					ArrDate1 = null;
					ArrDate2 = null;
					break;
				case "":
					System.out.println();
					break;
				default:
					System.err.println("Invalid command: " + command[0]);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Command file not found: " + commandFile);
		} catch (IOException e) {
			System.err.println("Error reading command file: " + commandFile);
		}

	}

}