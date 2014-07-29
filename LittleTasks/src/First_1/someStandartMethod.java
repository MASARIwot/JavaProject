package First_1;

import java.util.ArrayList;

public class someStandartMethod {

	
	public someStandartMethod() {
		//konstructor
	}
	
	public static void printArrr(ArrayList<?> arrToPrint) {
		System.out.print(arrToPrint.toString());
		
	}
	public static void printMasivInt(int number[]){ //Static Example
		for(int i = 0; i < number.length; i++ ){
			System.out.println("i["+i+"]="+number[i]);
		}	 
		
	}
	
	
	
}
