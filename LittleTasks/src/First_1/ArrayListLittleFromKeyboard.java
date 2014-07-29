package First_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayListLittleFromKeyboard {
	
	
	public static void main (String []args){
		
		
	
		
		BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));  
		//Standart in//*******************************************************************************
		System.out.print("Enter a line:");
			    try {
					System.out.println(stdin.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
		//Standart in: in arr//*******************************************************************************
		int number[]  = new int[5];
	    BufferedReader forArr = new BufferedReader(new InputStreamReader(System.in));	
	    System.out.println("Writeln 5 elements in arr");
		for(int i = 0; i < number.length; i++ ){
			System.out.print("i["+i+"]=");
			try {
				number[i] = Integer.parseInt(forArr.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		someStandartMethod.printMasivInt(number); // STATIC Example !!!!!
		
		/*for(int i = 0; i < number.length; i++ ){
			System.out.println("i["+i+"]="+number[i]);
		}*/	 
		
		//add from keyboard to ArrayList //*******************************************************************************
		System.out.println("5 line nter PROShOO");
		ArrayList<String> arrString = new ArrayList<String>();
		for(int i = 0; i < 5; i++ ){
			try {
				arrString.add(stdin.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		someStandartMethod.printArrr(arrString);
		
	}
}
