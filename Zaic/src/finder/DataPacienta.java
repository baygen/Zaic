package finder;

import java.io.Serializable;

public class DataPacienta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1654317503001505206L;
	private PacDate dates;
	private String diagnoz;
	private double hour;
	
	DataPacienta(PacDate dates, String diagnoz,double d){
		this.dates = dates;
		this.diagnoz = diagnoz;
		this.hour = d;
	}

	@Override
	public String toString() {
		return diagnoz + "," + dates +" "+ hour+"0.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((diagnoz == null) ? 0 : diagnoz.hashCode());
		result = (int) (prime * result + hour);
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
		DataPacienta other = (DataPacienta) obj;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!dates.equals(other.dates))
			return false;
		if (diagnoz == null) {
			if (other.diagnoz != null)
				return false;
		} else if (!diagnoz.equals(other.diagnoz))
			return false;
		if (hour != other.hour)
			return false;
		return true;
	}

	public PacDate getPacDate() {
		return dates;
	}

	public void setDate(PacDate date) {
		this.dates = date;
	}

	public String getDiagnoz() {
		return diagnoz;
	}

	public void setDiagnoz(String diagnoz) {
		this.diagnoz = diagnoz;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
}
