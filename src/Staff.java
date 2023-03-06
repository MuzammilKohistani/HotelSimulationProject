
public class Staff {

	private static int staffId = 1;

	private String staffType, staffName, staffSurname, staffGender;
	private Date staffBirthDate;
	private Address staffAddress;
	private Phone staffPhoneNumber;
	private int staffSalary;
	private int adminCount = 0, receptionistCount = 0, housekeeperCount = 0;
	private int EmployeeId = staffId;

	
	public Staff(String staffName, String staffSurname, String staffGender, Date staffBirthDate, Address staffAddress,
			Phone staffPhoneNumber, String staffType, int staffSalary) {

		this.staffName=staffName;
		setStaffSurname(staffSurname);
		setStaffGender(staffGender);
		setStaffBirthDate(staffBirthDate);
		setStaffAddress(staffAddress);
		setStaffPhoneNumber(staffPhoneNumber);
		setStaffType(staffType);
		setStaffSalary(staffSalary);

	}
	
	
	public String getEmployeeInformation() {
		
		return "Employee\t#"+getEmployeeId()+"\t"+getStaffName()+"\t"+getStaffSurname()+"\t"+getStaffGender()+"\t"+getStaffBirthDate()+"\t"+getStaffType(); 
	}

	public static void setStaffId() {
		Staff.staffId++;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSurname() {
		return staffSurname;
	}

	public void setStaffSurname(String staffSurname) {
		this.staffSurname = staffSurname;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public Date getStaffBirthDate() {
		return staffBirthDate;
	}

	public void setStaffBirthDate(Date staffBirthDate) {
		this.staffBirthDate = staffBirthDate;
	}

	public Phone getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(Phone staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public int getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(int staffSalary) {
		this.staffSalary = staffSalary;
	}

	public Address getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(Address staffAddress) {
		this.staffAddress = staffAddress;
	}

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

	public int getEmployeeId() {
		return EmployeeId;
	}
	
}
