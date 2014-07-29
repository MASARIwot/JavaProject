package strategy;

public class Main {
	
	public static void main (String []args) throws ArithmeticException{
		/*
		 * we have one abstract class and different realizations
		 */
		Abstract abs1 = new SpecificOne();
		Abstract abs2 = new SpecificTwo();
		
		abs1.print();
		abs2.print();
		
		
		
		
		  
		 
		  
		  
	}

}
