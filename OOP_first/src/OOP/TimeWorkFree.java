package OOP;

import Interfaces.Work;
import File.*;

  /*
   * the hourly salary
   */
 public class TimeWorkFree extends TimeWork implements Work{
	
	public TimeWorkFree (){ 
			
	}
	@Override
	public void addWorker(String name, String surName, double timeOfWork , int timeSalary ){
		list.add(new Person( name,surName ,timeOfWork ,timeSalary));
	}
			
	public void setTimeOfWork(int index,double timeOfWork){
		list.get(index).setTimeOfWork(timeOfWork);
	}
	public void setTimeSalary(int index,int timeSalary){
		list.get(index).setTimeSalary(timeSalary);
	}
	
	public double getTimeOfWork(int index){
		return list.get(index).getTimeOfWork();
	}
	public int getTimeSalary(int index){
		return (int) list.get(index).getTimeSalary();
	}
	public String getTotoStringTimeWorkersFull(int index){
		return  list.get(index).toStringTimeWorkersFull();
	}
		
	@Override
	public void printWorkersSurName() {
		System.out.println("the hourly salary Workers ");
		for(int i = 0; i < list.size(); i++){
			System.out.println(i +" = " + "Salary = " +super.getSalary(i) +" SurName = "+ super.getSurName(i));
		}
	}
	@Override
	public void writeFileFreeWorkes (String path){
		WriterFile write = new WriterFile();
		write.writePersonComposition(list, path);
	}
	
		
	

}
