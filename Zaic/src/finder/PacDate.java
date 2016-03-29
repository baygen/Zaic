package finder;

import java.io.Serializable;

public class PacDate implements Serializable, Comparable<PacDate>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int year, month,day;
	
	public PacDate(int year, int month, int day) {
		this.year=year;
		this.month = month;
		this.day=day;
	
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacDate other = (PacDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return " "+ day + "." + month +"."+year+" року.";
	}
	
	
	public int getPacYear() {
		return year;
	}

	public void setPacYear(int year) {
		this.year = year;
	}

	public int getPacMonth() {
		return month;
	}

	public void setPacMonth(int month) {
		this.month = month;
	}

	public int getPacDay() {
		return day;
	}

	public void setPacDay(int day) {
		this.day = day;
	}


	@Override
	public int compareTo(PacDate o) {
		PacDate pac = (PacDate) o;
		if(this.day<pac.day){
			return -1;
		}else if(this.day>pac.day){
			return 1;
		}
		return 0;
	}

	
	
	
	
	

}
