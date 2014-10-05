package llckynumbers;


import java.util.ArrayList;



import file.File;
import interfaceForTask.LuckyNumber;

public class MainClass {
	
	public static void main(String[] args){
		String path= "D:\\HappyNumbers2.txt";
		LuckyNumber number = new CreateNumber();
		 
		
		System.out.println(number.getLuckyNumbers().toString());
		System.out.println("Save");
		File.writerFile(number.getLuckyNumbers(), path);
		System.out.println("Read from file");
		System.out.println(File.readfromFile(path));
	
		
		/*java.awt.Point p = new java.awt.Point();
		System.out.println(p);
		File f = new File();
		System.out.println(f);
		LuckyNumber number2 = new CreateNumber();
		System.out.println(number.equals(f) + " ," + number.equals(p) + " , " + number.equals(number2));//*/
		
		ArrayList<Integer> arr = number.getLuckyNumbers();
		for(Integer arr2 : arr){
			System.out.println(arr2);
			
		}
		System.out.println(" Iterator ");
		java.util.Iterator<Integer> iArr = arr.iterator();
		while(iArr.hasNext()){
			System.out.println(iArr.next());			
		}
		
	}

}
