package OOP;
import java.io.*;
import java.util.*;

import File.ReadFile;
import File.WriterFile;
import Interfaces.Work;

/*
 * Standard salary
 * 
 * */

public class TimeWork implements Work  {
	
	ArrayList<Person> list;
	
	public TimeWork(){
		list = new ArrayList<Person>();
	}
	@Override
	public void addWorker(String name , String surName , int salary ){
		list.add(new Person(name , surName ,salary));
	}
	
	public void setName(String newName, int index){
		list.get(index).setName(newName);
	}
	public void setSurName(String newSurName, int index){
		list.get(index).setSurName(newSurName);
	}
	public void setSalary(int newSalary , int index){
		list.get(index).setSalary(newSalary);
	}
	public String getName(int index){
		return list.get(index).getName();
	} 
	public String getSurName(int index){
		return list.get(index).getSurName();
	}
	public int getSalary(int index){
		return (int) list.get(index).getSalary();
	}
	public int getIdPerson( int index){
		return list.get(index).getIdPerson();
	}
	public String toStringID( int index){
		return list.get(index).toStringID();
	}
	
	//Method
	private static Comparator<Person> lary = new Comparator<Person>() {
        @Override
         public int compare(Person o1, Person o2) {
     	   if (o1.getSalary() != o2.getSalary()){
             return  (int) (o2.getSalary() - o1.getSalary());
             }
     	   else return o1.getName().compareTo(o2.getName());
                          
         }
     };
	
	@Override
	public void sort() {
		Collections.sort(list, lary);
	}

	@Override
	public void printWorkers() {
		 System.out.println(list.toString());
		 
	}

	@Override
	public void printFirst5() {
		for(int i = 0; i < 5; i++){
            System.out.println(getSurName(i));
        }
		
	}
	@Override
	public void printIdLast3() {
		int listSize = list.size();
				for(int i = 0; i < 3; i++){
			System.out.println(toStringID(listSize-1));
            listSize--;
            
        }
		
	}
	@Override
	public void printWorkersSurName() {
		System.out.println("Standart Workers ");
		for(int i = 0; i < list.size(); i++){
			System.out.println("["+i +"] Name = \t"+ getName(i) + "\t Salary  = " + getSalary(i));
                      
        }
		
	}
	@Override
	public void printWorkersNameSurName() {
		for(int i = 0; i < list.size(); i++){
		System.out.println( i +" = "+ getName(i)+ " "+getSurName(i)); 
		
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fileRead(String path) throws ClassNotFoundException {
		 ObjectInputStream in = null;
		 FileInputStream fileIn = null;
		 try { 
	             fileIn = new FileInputStream(path);
	             in = new ObjectInputStream(fileIn);
	             list = (ArrayList<Person>) in.readObject();
	                      
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("File Not Found");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	@Override
	public  void fileWrite(String path) {
		 FileOutputStream fileOut = null;
         ObjectOutputStream out = null;
		try {
             fileOut = new FileOutputStream(path);
             out = new ObjectOutputStream(fileOut);
            out.writeObject(list); 
           
            
            System.out.println("\n Write in File Successful.Checkout your output file..\n");
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
			
	}
	@Override
	public void addWorker(String name, String surName, double timeOfWork,
			int timeSalary) {
		// TODO Auto-generated method stub 
		 System.out.println("this method `<Object>.addWorker()` used for  hourly salary - you may be used wrong objects");
	}
	@Override
	public void writeFileFreeWorkes(String path) {
		WriterFile write = new WriterFile();
		write.writePersonComposition(list, path);
		// System.out.println("this method `<Object>.writeFileFreeWorkes()` used for  hourly salary -  you may be used wrong objects");
		
	}
	@Override
	public void readFileFreeWorkes(String path) {
		ReadFile read = new ReadFile();
		System.out.println("**** ************EGFEGEG *************** ***");
		 read.readPersonComposition(path);
		
	}
	
		
}
