/**
 * Represents an employee in the company.
 */
public class Staff {

	// Instance variables
	private String staffName, staffSurname, staffGender;
	private JobTypes JobType;
	private Date staffBirthDate;
	private Address staffAddress;
	private Phone staffPhoneNumber;
	private int staffSalary;
	private int EmployeeId;

	/**
	 * Creates a new Staff instance with the given information.
	 *
	 * @param EmployeeId the employee ID
	 * @param staffName the employee's first name
	 * @param staffSurname the employee's last name
	 * @param staffGender the employee's gender
	 * @param staffBirthDate the employee's birth date
	 * @param staffAddress the employee's address
	 * @param staffPhoneNumber the employee's phone number
	 * @param JobType the employee's job type
	 * @param staffSalary the employee's salary
	 */
	public Staff(int EmployeeId, String staffName, String staffSurname, String staffGender, Date staffBirthDate,
			Address staffAddress, Phone staffPhoneNumber, JobTypes JobType, int staffSalary) {
		// Initialize instance variables
		this.EmployeeId = EmployeeId;
		this.staffName = staffName;
		this.staffSurname = staffSurname;
		this.staffGender = staffGender;
		this.staffBirthDate = staffBirthDate;
		this.staffAddress = staffAddress;
		this.staffPhoneNumber = staffPhoneNumber;
		this.JobType = JobType;
		this.staffSalary = staffSalary;
	}

	/**
	 * Returns a formatted string containing the employee's information.
	 *
	 * @return a string representation of the employee's information
	 */
	public String getEmployeeInformation() {
		// Format employee information
		String id = String.format("%-9s", "Employee  #" + this.EmployeeId);
		String name = String.format("%-22s", this.staffName + " " + this.staffSurname);
		String gender = String.format("%-13s", this.staffGender);
		String birthdate = String.format("%-19s", this.staffBirthDate.getDateAsString());
		String jobtype = String.format("%-19s", this.JobType);

		// Return formatted string
		return String.format("\t%s\t%s\t%s\t%s\t%s", id, name, gender, birthdate, jobtype);
	}

	// Getter and setter methods for instance variables
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

	public int getEmployeeId() {
		return EmployeeId;
	}

	public JobTypes getJobType() {
		return JobType;
	}

	public void setJobType(JobTypes jobType) {
		JobType = jobType;
	}

	/**
	 * Enumerates the possible job types for an employee.
	 */
	public static enum JobTypes {
		ADMINISTRATOR, RECEPTIONIST, HOUSEKEEPER
	}
}
