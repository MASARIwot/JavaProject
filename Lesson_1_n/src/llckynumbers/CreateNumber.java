package llckynumbers;
import java.util.ArrayList;

import interfaceForTask.LuckyNumber;

public class CreateNumber implements LuckyNumber {
		
	private int numbeOfElement;
		
	public CreateNumber(){
		this.numbeOfElement = 9999;
	} 
	public CreateNumber(int numbeOfElement){
		
		this.numbeOfElement = numbeOfElement;
	} 
	
	@Override
	public ArrayList<Integer> getLuckyNumbers() {
		if(this.numbeOfElement == 0) return null;
		if(this.numbeOfElement == 1) return null; 
		return createArr();
	}	
	
	private  ArrayList<Integer> createArr(){
		int counter = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arrBuf = new ArrayList<Integer>();
		
		for(int i = 2; i < numbeOfElement; i++){
			arrBuf.add(i);
		}
		while(counter*counter < numbeOfElement){
			counter = arrBuf.get(0);
			for(int i = 0 ; i < arrBuf.size(); i++){
			
				if( arrBuf.get(i) % counter  == 0){
					arrBuf.remove(i);
				}
			}
			arr.add(counter);	
		}
		return arr;
	}
	
	
	public String toString() {
		return  getClass().getName() + " - [ Standart numbeOfElement = " + numbeOfElement + " ]";
		
	}
	 public boolean equals(Object obj) {
	        if (!(obj instanceof CreateNumber)) {
	        	return false;
	        }
	        CreateNumber other = (CreateNumber)obj;
	        return this.numbeOfElement == other.numbeOfElement;
	    }

}
