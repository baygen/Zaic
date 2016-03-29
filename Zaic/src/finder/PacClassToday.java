package finder;

import java.io.Serializable;

public class PacClassToday implements Serializable, Comparable<PacClassToday> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5876652115328314246L;
	private String Familia,Komentar, Name;
	private int age;
	private double time;
	
	PacClassToday(String Familia, String komentsr, String Name, int age, double d) {
		this.Familia = Familia;
		this.Name=Name;
		this.age = age;
		this.time = d;
		
	}
	@Override
	public String toString() {
		if(time<10){
		return " 0" + time + "0 --- " + Familia +" "+ Name+ " ,віку "+ age ;
		}else{
			return " " + time + "0 --- " + Familia +" "+ Name+ " ,віку "+ age ;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Familia == null) ? 0 : Familia.hashCode());
		result = prime * result + ((Komentar == null) ? 0 : Komentar.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + age;
		result = (int) (prime * result + time);
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
		PacClassToday other = (PacClassToday) obj;
		if (Familia == null) {
			if (other.Familia != null)
				return false;
		} else if (!Familia.equals(other.Familia))
			return false;
		if (Komentar == null) {
			if (other.Komentar != null)
				return false;
		} else if (!Komentar.equals(other.Komentar))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (age != other.age)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	public String getFamilia() {
		return Familia;
	}
	public void setFamilia(String familia) {
		Familia = familia;
	}
	public String getKomentar() {
		return Komentar;
	}
	public void setKomentar(String komentar) {
		Komentar = komentar;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(PacClassToday o) {
		PacClassToday pac = (PacClassToday) o;
		if(this.time<pac.time){
			return -1;
		}else if(this.time>pac.time){
			return 1;
		}
		return 0;
	}
	

}
