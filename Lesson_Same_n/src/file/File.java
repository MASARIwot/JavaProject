package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
		
	public static  void writerFile(ArrayList<Integer> arrForSave ,String path){
		
		try (BufferedWriter buff = new BufferedWriter(new FileWriter(path));) { //Auto Closing
			for(int i = 0; i < arrForSave.size(); i++){
				buff.write(arrForSave.get(i) + " ");
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static  String readfromFile(String path) {
		StringBuilder strigFromFile = null;
		String readString = null;
			try(BufferedReader readInFile = new BufferedReader(new FileReader(path));){//Auto Closing
				strigFromFile =new StringBuilder();
				 
				while((readString = readInFile.readLine()) != null){
					strigFromFile.append(readString);
					strigFromFile.append("\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}/*finally{
			try{
				readInFile.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}//*/
		return strigFromFile.toString();
	}
	
	public String toString() {
		return "[ " + getClass().getName() + " , readfromFile(String path), \n" +  "writerFile(ArrayList<Integer> arrForSave ,String path)  ]";
		
	}//*/

}
