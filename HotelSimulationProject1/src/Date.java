
public class Date {
	
    public int day; 
    public int month;  
    public int year; 
    
    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public Date() {
    }
    
	public int getDay() {
	    return day;
	}

	public void setDay(int newDay) {
	    this.day = newDay;
	}
	
	public int getMonth() {
	    return month;
	}

	public void setMonth(int newMonth) {
	    this.month = newMonth;
	}
	
	public int getYear() {
	    return year;
	}

	public void setYear(int newYear) {
	    this.year = newYear;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
