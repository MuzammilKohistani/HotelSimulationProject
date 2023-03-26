public class Date {

	// Date properties
	private int year;
	private int month;
	private int day;

	// The number of days in each month for 2024 (leap year)
	public final static int[] calendar2024 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// Constructor for Date class
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Getters and setters for Date properties
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	// Returns a string representation of the Date object
	public String getDateAsString() {
		return String.format("%02d.%02d.%04d", this.day, this.month, this.year);
	}

	// Checks if the Date object is valid in 2024
	public boolean isValidIn2024() {
		if (this.year == 2024 && this.month >= 1 && this.month <= 12)
			if (this.month == 2)
				return this.day >= 1 && this.day <= 29;
			else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
				return this.day >= 1 && this.day <= 30;
			else
				return this.day >= 1 && this.day <= 31;

		return false;
	}

	// Checks if the Date object is before the given Date object
	public boolean before(Date otherDate) {
		return this.month < otherDate.month || (this.month == otherDate.month && this.day < otherDate.day);
	}

	// Checks if the Date object is after the given Date object
	public boolean after(Date otherDate) {
		return this.month > otherDate.month || (this.month == otherDate.month && this.day > otherDate.day);

	}

	// Checks if the Date object is equal to the given Date object
	public boolean equals(Date otherDate) {
		return this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day;
	}

	// Compares two Date objects and returns an integer indicating the result
	// >0 - date1 is later, <0 - date2 is later, =0 - same
	public int compare(Date date2) { // date1.compare(date2) / >0 - date1 is later / <0 - date2 is later / =0 - same
		if (this.year != date2.year)
			return Integer.compare(this.year, date2.year);
		if (this.month != date2.month)
			return Integer.compare(this.month, date2.month);
		return Integer.compare(this.day, date2.day);
	}

	// calculates the number of days between this date and otherDate
	// returns the number of days between this date and otherDate
	public int betweenDaysIn2024(Date otherDate) { // to find the numbers of days between 2 dates
		if (this.month == otherDate.month)
			return Math.abs(this.day - otherDate.day) + 1;
		if (this.month < otherDate.month)
			return this.betweenNight(otherDate) + 1;
		if (this.month > otherDate.month)
			return otherDate.betweenNight(this) + 1;
		return -100; // this is a dummy data.
	}

	// helper method for betweenDaysIn2024
	// calculates the number of days between the last day of this month and
	// otherDate
	// returns the number of days between the last day of this month and otherDate
	private int betweenNight(Date otherDate) // this is only for betweenDaysIn2024 method, never use other methods
	{
		int between = calendar2024[this.month - 1] - this.day;
		for (int i = this.month + 1; i < otherDate.month; i++) {
			between += calendar2024[i] - 1;
		}
		return between += otherDate.day;
	}

	// calculates the days between this date and otherDate recursively
	// returns an array containing the days between this date and otherDate
	public int[] recursionBetweenTwoDates(Date otherDate) // when to write and use day in simulation part.
	{
		int[] days = new int[betweenDaysIn2024(otherDate)];

		int k = -1;
		int day = this.day;
		for (int i = 0; i < betweenDaysIn2024(otherDate); i++) {
			if (day > calendar2024[this.month + k]) {
				++k;
				day = 1;
			}
			days[i] = day;
		}

		return days;
	}
	// calculates the number of days between this date and SecondDate
	// returns the number of days between this date and SecondDate
	public int DaysBetweenTwoDate(Date SecondDate) {

		int dayCounter = 0;

		for (int i = this.month; i < SecondDate.getMonth(); i++) {

			dayCounter += calendar2024[i - 1];
		}
		dayCounter -= this.day;
		dayCounter += SecondDate.getDay();

		return dayCounter;
	}

	// calculates the number of days between this date and date2
	// returns the number of days between this date and date2
	public int daysBetween(Date date2) {

		int days1 = 0;
		int days2 = 0;

		for (int i = 0; i < this.month - 1; i++)
			days1 += calendar2024[i];

		for (int i = this.month - 1; i < date2.getMonth() - 1; i++)
			days2 += calendar2024[i];

		days2 += days1 + date2.getDay(); // add all the days in first date + days in last month
		days1 += this.day; // add days in the last month

		return days2 - days1;
	}

	// calculates the days between this date and date2
	// returns an array containing the days between this date and date2
	public int[] daysToArr(Date date2) {

		int day = this.day;
		int month = this.month - 1;
		int daysInCurrentMonth = calendar2024[month];

		int daysBetween = this.daysBetween(date2);
		int[] days = new int[daysBetween + 1];

		for (int i = 0; i <= daysBetween; i++) {
			if (day > daysInCurrentMonth) {
				day = 1;
				month++;
				daysInCurrentMonth = calendar2024[month];
			}
			days[i] = day;
			day++;
		}
		return days;
	}

}

