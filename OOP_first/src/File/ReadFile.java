package File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



import javax.sound.sampled.Line;

import OOP.Person;
import OOP.TimeWork;

@SuppressWarnings("unused")
public class ReadFile {
	
	//@SuppressWarnings("null")
	public ArrayList<Person> readPersonComposition(String path){
		BufferedReader buffRead = null;
		ArrayList<Person> readFile = new ArrayList<Person>();
		
		try {
			if(path.equalsIgnoreCase(null)){
				path = "D:\\PersonComposition.txt";
			}
			buffRead   = new BufferedReader( new FileReader(path));
			while(true){
				if(buffRead.readLine() == null){
					break;
				} else{
					
										String a =  buffRead.readLine().split(" - ")[0] ;
										String b =  buffRead.readLine().split(" - ")[1] ;
										int c = Integer.parseInt( buffRead.readLine().split(" -")[2]);
										
										readFile.add(new Person(a,b,c)); //.trim()) 
																	
									
									//(int) Double.parseDouble(buffRead.readLine().split(" - ")[3])));
					
				} 
				
			}// buffRead.close();
		} catch (IOException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
			}finally {
				try{
					buffRead.close();
				} catch (IOException e1){
					e1.printStackTrace();
				}
			}
		return readFile;
	}


	
	
	
	
	
	
}
