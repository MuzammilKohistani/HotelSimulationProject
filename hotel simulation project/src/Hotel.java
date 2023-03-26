import java.util.Arrays;

public class Hotel {
	public String name;
	private final Date foundationDate;
	private Address address;
	private Phone phoneNumber;
	private int stars;
	private Room[] rooms;
	private Staff[] employees;
	private Customer[] customers;
	private Reservation[] reservations;
	private int income, salary;
	int roomCount;
	private int staffId = 1;
	private int adminCount, receptionistCount, housekeeperCount;
	private int customerCount;
	int reservationCount;

	public Hotel(String name, Date foundationDate, Address address, Phone phoneNumber, int stars) {
		this.roomCount = 0;
		this.customerCount = 0;
		this.reservationCount = 0;
		this.income = 0;
		this.salary = 0;
		this.adminCount = 0;
		this.receptionistCount = 0;
		this.housekeeperCount = 0;
		this.name = name;
		this.foundationDate = foundationDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.stars = stars;

		this.rooms = new Room[30];
		this.employees = new Staff[50];
		this.customers = new Customer[365]; // Because we can't probably use ArrayList
		this.reservations = new Reservation[365]; // Because we can't use ArrayList

	}

	// Date class methods
	public int[] parseDate(String DateAsString) {

		DateAsString = DateAsString.replaceAll("[^0-9.]", "");
		int[] date = { 0, 0, 0 };

		if (DateAsString.contains(".")) {

			try {

				String[] YMD = DateAsString.split("\\.");

				date[0] = Integer.parseInt(YMD[0]);
				date[1] = Integer.parseInt(YMD[1]);
				date[2] = Integer.parseInt(YMD[2]);

			} catch (Exception e) {

			}
		}
		return date;
	}

	// Phone class methods
	public String[] parsePhone(String phoneStr) {

		phoneStr = phoneStr.replaceAll("[^0-9+]", "");
		String[] phone = { "+0", "(000)", "0000000" };

		phone[0] = phoneStr.substring(0, phoneStr.length() - 10);
		phone[1] = "(" + phoneStr.substring(phoneStr.length() - 10, phoneStr.length() - 7) + ")";
		phone[2] = phoneStr.substring(phoneStr.length() - 7);

		return phone;
	}

	// Room methods
	public void addRooms(Room.RoomType roomType, boolean air, boolean balcony, double price) {
		this.rooms[this.roomCount] = new Room(++this.roomCount, roomType, air, balcony, price);
	}

	public void listRooms() {
		for (int i = 0; i < this.roomCount; i++) {
			System.out.println(rooms[i].getRoomInformation());
		}
	}

	public void searchRoom(Date startDate, Date endDate) {
		if (reservationCount == 0) {
			listRooms();
			return;
		}
		for (int i = 0; i < this.roomCount; i++)
			for (int j = 0; j < this.reservationCount; j++)
				if (this.rooms[i].getID() == this.reservations[j].getRoomId()
						&& !((startDate.compare(this.reservations[j].getDepartureDate()) <= 0
								&& (this.reservations[j].getArrivalDate()).compare(endDate) <= 0)))
					System.out.println(rooms[i].toString());
	}

	// Staff Methods
	public int getReceptionistCount() {
		return receptionistCount;
	}

	public void setReceptionistCount(int receptionistCount) {
		this.receptionistCount = receptionistCount;
	}

	public int getAdminCount() {
		return adminCount;
	}

	public void setAdminCount(int adminCount) {
		this.adminCount = adminCount;
	}

	public int getHousekeeperCount() {
		return housekeeperCount;
	}

	public void setHousekeeperCount(int housekeeperCount) {
		this.housekeeperCount = housekeeperCount;
	}

	public void addEmployee(String name, String surname, String gender, Date birthDate, Address address,
			Phone phoneNumber, Staff.JobTypes JobType, int salary) {

		int indexNumber = firstNull(employees);

		if (indexNumber != -1) {

			employees[indexNumber] = new Staff(getStaffId(), name, surname, gender, birthDate, address, phoneNumber,
					JobType, salary);

			this.salary += employees[indexNumber].getStaffSalary();

			setStaffId();

		} else {
			System.out.println("we will call you");
		}
	}

	public void deleteEmployee(int employeeId) {

		for (int i = 0; i < employees.length; i++) {

			if (employees[i] != null && employees[i].getEmployeeId() == employeeId && employees[i].getJobType()!=null) {

				switch (employees[i].getJobType()) {
				case ADMINISTRATOR:
					adminCount--;
					break;
				case RECEPTIONIST:
					receptionistCount--;
					break;
				case HOUSEKEEPER:
					housekeeperCount--;
					break;
				}

				employees[i] = null;
				break;
			}
		}
	}

	public void listEmployee() {

		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				System.out.println(employees[i].getEmployeeInformation());
			}
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

	public void setStaffId() {
		staffId++;
	}

	public int getStaffId() {
		return staffId;
	}

	// Customer Methods

	public void addCustomer(String customerName, String customerSurname, String CusGen, Date bdate, Address cusAddress,
			Phone cusPhone) {
		customers[customerCount] = new Customer(++customerCount, customerName, customerSurname, CusGen, bdate,
				cusAddress, cusPhone);
	}

	public void listCustomers() {
		for (int i = 0; i < customerCount; i++) {
			System.out.println(customers[i].getCustomerInformation());
		}
	}

	public void searchCustomer(String pattern) {
		String newPattern;
		if (pattern.charAt(pattern.length() - 1) == '*') {
			newPattern = pattern.substring(0, pattern.indexOf('*'));
			for (int i = 0; i < customerCount; i++) {
				if (customers[i].getCustomerName().startsWith(newPattern)) {

					System.out.println(customers[i].getCustomerInformation());
				}
			}
		} else if (pattern.charAt(pattern.length() - 1) == '?') {
			int length = pattern.length();
			newPattern = pattern.substring(0, pattern.indexOf('?'));
			for (int i = 0; i < customerCount; i++) {
				if (customers[i].getCustomerName().startsWith(newPattern)
						&& customers[i].getCustomerName().length() == length) {

					System.out.println(customers[i].getCustomerInformation());
				}
			}
		}
	}

	// Reservation Methods

	public void addReservation(int customerId, int roomId, Date startDate, Date endDate) {

		for (int i = 0; i < this.reservationCount; i++)
			if (roomId == this.reservations[i].getRoomId()
					&& ((startDate.compare(this.reservations[i].getDepartureDate()) <= 0
							&& (this.reservations[i].getArrivalDate()).compare(endDate) <= 0)))
				return;

		for (int i = 0; i < roomCount; i++) {

			if (rooms[i].getID() == roomId) {
				income += startDate.DaysBetweenTwoDate(endDate) * rooms[i].getPrice();
			}
		}

		this.reservations[reservationCount] = new Reservation(customerId, roomId, startDate, endDate);
		++reservationCount;
	}

	public void listReservations() {

		for (int i = 0; i < reservationCount; i++) {

			String fullname = null;

			for (int j = 0; j < customerCount; j++) {

				if (customers[j].getCustomerID() == reservations[i].getCustomerId()) {
					fullname = customers[j].getCustomerName() + "  " + customers[j].getCustomerSurname();
					break;
				}
			}

			System.out.println(reservations[i].getReservationInformation(fullname));
		}
	}

	// Statistics

	public void statistics() {
		printMostBooked();
		printBestCustomer();
		statisticsIncome();
		monthlyOccupationRate();
		System.out.println();
	}

	// Statistic sub-methods

	public void statisticsIncome() {
		int ConstantExpenses = 120000;
		int profit = this.income - this.salary - ConstantExpenses;
		System.out.println("\n\t3. Income = " + this.income);
		System.out.println("\t   Salary = " + this.salary);
		System.out.println("\t   Constant expenses = " + ConstantExpenses);
		System.out.println("\t   Profit = " + profit);

	}

	public void printMostBooked() {
		int max = 0;
		int roomID = 0;
		int noOfRes = 0;
		int noOfDays = 0;
		int maxDays = 0;
		for (int i = 0; i < this.roomCount; i++) {
			for (int j = 0; j < this.reservationCount; j++) {
				if (this.rooms[i].getID() == this.reservations[j].getRoomId()) {
					noOfRes++;
					noOfDays += this.reservations[j].getArrivalDate()
							.daysBetween(this.reservations[j].getDepartureDate());
				}
			}
			if (noOfRes > max) {
				roomID = this.rooms[i].getID();
				max = noOfRes;
			}
			if (noOfDays > maxDays) {
				roomID = this.rooms[i].getID();
				maxDays = noOfDays;
			}
			noOfRes = 0;
			noOfDays = 0;
		}
		System.out.println("\n   1. The most reserved room = Room #" + roomID + "\n");
	}

	public void printBestCustomer() {
		int[] customerdays = new int[this.customers.length];

		Arrays.fill(customerdays, 0);

		for (int i = 0; reservations[i]!=null; i++) {
			customerdays[this.reservations[i].getCustomerId() - 1] += daysBetween(this.reservations[i].getArrivalDate(),
					this.reservations[i].getDepartureDate());
			if (this.reservations[i + 1] == null)
				break;
		}
		int maxday = 0;
		int id = 0;
		for (int i = 1; i < customerdays.length; i++) {

			if (customerdays[i] > maxday && customers[i] != null) {
				maxday = customerdays[i + 1];
				id = this.customers[i].getCustomerID() - 1;
			}
		}

		System.out.println("\t2. The best customer = " + customers[id].getCustomerName() + " "
				+ customers[id].getCustomerSurname() + " " + customerdays[id] + " days");
	}

	public int numberOfCustomersOnDate(Date date) {
		int customerCountOnDate = 0;
		for (int i = 0; reservations[i] != null; i++) {
			if (date.compare(reservations[i].getArrivalDate()) * date.compare(reservations[i].getDepartureDate()) != 1)
				++customerCountOnDate;
		}
		System.out.println(customerCountOnDate + "}}}");
		return customerCountOnDate;
	}

	public void monthlyOccupationRate() {
		int[] occupations = new int[12];
		for (int i = 0; i < Date.calendar2024.length; i++)
			for (int j = 0; reservations[j] != null; j++)
				if (reservations[j].getArrivalDate().getMonth() == i + 1
						&& reservations[j].getDepartureDate().getMonth() == i + 1)
					occupations[i] += reservations[j].getArrivalDate()
							.betweenDaysIn2024(reservations[j].getDepartureDate());
				else if (reservations[j].getArrivalDate().getMonth() == i + 1
						&& reservations[j].getDepartureDate().getMonth() > i + 1)
					occupations[i] += reservations[j].getArrivalDate()
							.betweenDaysIn2024(new Date(Date.calendar2024[i], i + 1, 2024));
				else if (reservations[j].getArrivalDate().getMonth() < i + 1
						&& reservations[j].getDepartureDate().getMonth() == i + 1)
					occupations[i] += new Date(1, i + 1, 2024).betweenDaysIn2024(reservations[j].getDepartureDate());
				else if (reservations[j].getArrivalDate().getMonth() < i + 1
						&& reservations[j].getDepartureDate().getMonth() > i + 1)
					occupations[i] += Date.calendar2024[i];

		int[] occupationRates = new int[occupations.length];
		for (int i = 0; i < occupationRates.length; i++)
			occupationRates[i] = occupations[i] * 100 / (roomCount * Date.calendar2024[i]);

		System.out.println("\n\t4. Monthly occupancy rate");
		System.out.println("\t   1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12");
		System.out.print("\t   ");
		for (int i = 0; i < occupationRates.length; i++) {
			System.out.print(occupationRates[i] + "%\t");
		}

	}

	// Simulation
	public void simulation(Date startDate, Date endDate) {

		int k = 1;
		int month = startDate.getMonth();
		int[] days = startDate.recursionBetweenTwoDates(endDate);

		System.out.print(String.format("%-15s", "Day  :"));
		printDays(startDate, endDate);

		System.out.print("\nCustomer     :");
		int[] customerPerDay = customerPerDay(startDate, endDate);
		for (int i = 0; i < customerPerDay.length; i++) {
			System.out.print(String.format("%8d", customerPerDay[i]));
		}

		int[] dailySatisfaction = new int[customerPerDay.length];
		double sumOfSatisfactions = 0;
		for (int i = 0; i < dailySatisfaction.length; i++) {
			if (customerPerDay[i] == 0) {
				dailySatisfaction[i] = 0;
			} else {
				dailySatisfaction[i] = 3 * 100 / customerPerDay[i];
			}
		}

		System.out.print("\nSatisfaction :");
		for (int i = 0; i < dailySatisfaction.length; i++) {
			if (dailySatisfaction[i] >= 100) {
				sumOfSatisfactions += 100 ;
				System.out.print(String.format("%8s", "100%"));
			} else {
				sumOfSatisfactions += dailySatisfaction[i];
				System.out.print(String.format("%8d%%", dailySatisfaction[i]));
			}
		}
		System.out.println("\nAverage Satisfaction = " +(sumOfSatisfactions / dailySatisfaction.length)+"%\n\n");
	}

	// Simulation sub-methods

	public double dailySatisfaction(Date date) {
		if (numberOfCustomersOnDate(date) == 0)
			return 100;
		return 3.0 / numberOfCustomersOnDate(date) >= 1 ? 100 : 3.0 / numberOfCustomersOnDate(date) * 100;
	}

	public static int daysBetween(Date date1, Date date2) {

		int[] daysInAMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 29 in February because it's 2024

		int days1 = 0;
		int days2 = 0;

		for (int i = 0; i < date1.getMonth() - 1; i++)
			days1 += daysInAMonth[i];

		for (int i = date1.getMonth() - 1; i < date2.getMonth() - 1; i++)
			days2 += daysInAMonth[i];

		days2 += days1 + date2.getDay();
		days1 += date1.getDay();

		return days2 - days1;
	}

	public static void printDays(Date date1, Date date2) {

		int[] daysInAMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int day = date1.getDay();
		int month = date1.getMonth() - 1;
		int daysInCurrentMonth = daysInAMonth[month];

		for (int i = 0; i <= daysBetween(date1, date2); i++) {
			if (day > daysInCurrentMonth) {
				day = 1;
				month++;
				daysInCurrentMonth = daysInAMonth[month];
			}
			System.out.format("\t%4d", day);
			day++;
		}
	}

	public int[] customerPerDay(Date d1, Date d2) {
		int[] customerperday = new int[d1.daysBetween(d2) + 1];

		for (int i = 0; reservations[i] != null; i++) {
			if (reservations[i].getArrivalDate().compare(d1) >= 0) {
				int a = Math.min(reservations[i].getArrivalDate().daysBetween(d2),
						reservations[i].getArrivalDate().daysBetween(reservations[i].getDepartureDate()));
				for (int j = 0; j <= a; j++) {
					customerperday[d1.daysBetween(reservations[i].getArrivalDate()) + j] += 1;
				}
			} else if (reservations[i].getArrivalDate().compare(d1) < 0
					&& reservations[i].getDepartureDate().compare(d1) >= 0) {
				int a = Math.min(d1.daysBetween(d2), d1.daysBetween(reservations[i].getDepartureDate()));
				for (int j = 0; j <= a; j++) {
					customerperday[j] += 1;
				}
			}
		}

		return customerperday;
	}

}
