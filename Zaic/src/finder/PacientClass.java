package finder;

import java.io.Serializable;

public class PacientClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Familia, Name, Komentar;
	private int age, time;
	
	PacientClass(String Familia, String komentsr, String Name,  int age){
		this.Familia = Familia;
		this.Komentar = komentsr;
		this.Name = Name;
		this.age = age;
	}	
	
	@Override
	public String toString() {
		return " "+Familia +" " + Name +", віку: " + age +". "+ Komentar  ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Familia == null) ? 0 : Familia.hashCode());
		result = prime * result + ((Komentar == null) ? 0 : Komentar.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + age;
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
		PacientClass other = (PacientClass) obj;
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
		return true;
	}

	public String getFamilia() {
		return Familia;
	}

	public void setFamilia(String familia) {
		Familia = familia;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getKomentar() {
		return Komentar;
	}

	public void setKomentar(String komentar) {
		Komentar = komentar;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
