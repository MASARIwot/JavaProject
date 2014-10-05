package serializable_My;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;


public class Persone implements java.io.Externalizable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5099989343768405947L;
	
	private transient String lastName;
	private String surName;
	private double salary = 0;
	private double ID;
	private long data;
	
	public Persone(){
		this.lastName = null;
		this.surName = null;
		this.salary = -1;
		this.data = new Date().getTime();
		this.ID = 0;
		
	}
	
	public Persone(String lastName, String surName,double salary , double ID){
		 this.lastName = lastName ;
		 this.surName = surName;
		 this.salary = salary;
		 this.data = new Date().getTime();
		 this.ID = ID;
		
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeDouble(this.ID);
		out.writeUTF(this.lastName);
		out.writeDouble(this.salary);
		out.writeLong(data);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		//read as save
		this.ID = in.readDouble();
		this.lastName = in.readUTF();
		this.salary = in.readDouble();
		this.data = in.readLong();
		
		
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getID() {
		return (double) ID;
	}
	
	
	
	
	@Override
	public String toString() {
		return  getClass().getName() + "[ Persone: lastName = " + lastName + ", surName = " + surName
				+ ", salary = " + salary +"\n ID:"+ ID +" Data:" + data+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Persone other = (Persone) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	

	

	

	

}
