package OOP;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Person implements Serializable{
	
	private 	String name;
	private 	String surName;
	private 	int idPerson;
	private  	int salary;
	private 	double timeOfWork;
	private 	int timeSalary;
	
	public Person(){
		this.name = null;
		this.surName = null;
		this.idPerson = (int) new Date().getTime();
		this.salary = 0;
		this.timeOfWork = 0;
		this.timeSalary = 0;
	}
	
	//for the Standard salary
	public Person (String name, String surName, int salary){
		
		this.name = name;
		this.surName = surName;
		this.salary = salary;
		this.idPerson = (int) new Date().getTime();
			
	}
	//for the hourly salary
	public Person (String name, String surName, double timeOfWork , int timeSalary){
		this.name = name;
		this.surName = surName;
		this.idPerson = (int) new Date().getTime();	
		this.timeOfWork = timeOfWork;
		this.timeSalary = timeSalary;
		this.salary = (int) ((int) 20*timeOfWork*timeSalary);
		
	}
		
		public String getName() {
			return this.name;
		}
		public String getSurName() {
			return this.surName;
			
		}
		public int getSalary(){
			return salary;
		}
		
		public int getIdPerson(){
			return idPerson;
		} 
		
		public void setName(String name){
			this.name = name;
			
		}
		public void setSurName(String surName){
			this.surName = surName;
		}
		public void setSalary(int salary){
			this.salary = salary;
		}
		
		//******************
	
		public double getTimeOfWork() {
			return timeOfWork;
		}
	
		public void setTimeOfWork(double timeOfWork) {
			this.timeOfWork = timeOfWork;
		}
	
		public int getTimeSalary() {
			return timeSalary;
		}
	
		public void setTimeSalary(int timeSalary) {
			this.timeSalary = timeSalary;
		}
		
	@Override
	public String toString() {
        return " id= " + this.idPerson + " name= " 
        		+ this.name		 +" SurName = "
        		+ this.surName	 +" \r salary= "
        		+ this.salary	 +" \n" ;
    }
	
	public String toStringID() {
        return " id= " + this.idPerson + " SurName = "+this.surName +"\n" ;
    }
	
	public String toStringTimeWorkersFull() {
        return " id= " + this.idPerson +  " name= " 
        		+ this.name		 	 +" SurName = "
        		+ this.surName		 +" \r salary= " 
        		+ this.salary		 + " Time Of Work = "
        		+ this.timeOfWork	 +" Time Selary = "
        		+ this.timeSalary	 + " \n" ;
    }

}
