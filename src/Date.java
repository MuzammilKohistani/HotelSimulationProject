public class Date {
	private int year;
	private int month;
	private int day;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(String DateAsString) {

		if (DateAsString.contains(".")) {

			try {

				String[] YMD = DateAsString.trim().split(".");

				this.day=Integer.parseInt(YMD[0]);
				this.month=Integer.parseInt(YMD[1]);
				this.year=Integer.parseInt(YMD[2]);
				
			} catch (Exception e) {

				this.day=0;
				this.month=0;
				this.year=0;
			}
		} else {
			this.day=0;
			this.month=0;
			this.year=0;
		}

	}

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

	public int compare(Date date2) { // date1.compare(date2) / >0 - date1 is later / <0 - date2 is later / =0 - same
        if (this.year != date2.year) 
            return Integer.compare(this.year, date2.year);
        if (this.month != date2.month) 
            return Integer.compare(this.month, date2.month);
        return Integer.compare(this.day, date2.day);
    }

	public String getDateAsString() {
		return String.format("%02d.%02d.%04d", this.day, this.month, this.year);
	}

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
}
