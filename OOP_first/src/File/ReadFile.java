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
	
	public ArrayList<Person> readPersonComposition(String path){
		BufferedReader buffRead = null;
		ArrayList<Person> readFile = new ArrayList<Person>();
		
		try {
			if(path.equalsIgnoreCase(null)){
				path = "D:\\PersonComposition.txt";
			}
			buffRead   = new BufferedReader( new FileReader(path));
			while(!(buffRead.readLine() == null)){
				readFile.add(new Person( buffRead.readLine().split(" - ")[0]+
								 buffRead.readLine().split(" - ")[1] + 
								 Integer.parseInt(buffRead.readLine().split(" - ")[2]), null, 0));
				} 
				
		} catch (IOException e1) {
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
