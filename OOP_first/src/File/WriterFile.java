package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import OOP.Person;;


public class WriterFile {

	
	public void writePersonComposition(ArrayList<Person> PersonComposition, String path){
		BufferedWriter buff = null;
		
		ArrayList<Person> PersonCompositionTemp = PersonComposition;
		Person PersonTemp = null;
		
		try {
			if(path.equalsIgnoreCase(null)){
				path = "D:\\PersonComposition.txt";
			}
			buff = new BufferedWriter(new FileWriter(path));
			
			for(int i = 0; i < PersonCompositionTemp .size()-1; i++  ){
				PersonTemp = PersonCompositionTemp .get(i);
				
				buff.write(PersonTemp.getName()+" - ");
				buff.write(PersonTemp.getSurName()+" - ");
				buff.write(PersonTemp.getSalary()+" - "); //(int)
				
				buff.newLine();
			}
			buff.close(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try{
				buff.close();   
			} catch (IOException e1){
				e1.printStackTrace();
				return;
			}
		}
	}

	
	
}
