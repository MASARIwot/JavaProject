package serializable_My;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final  class WorkWithFile {
	Persone person;
	String path;
	public WorkWithFile(String path){
		this.path = path;
	}
	public WorkWithFile(Persone e , String path){
		this.path = path;
		this.person = e;
	}

	public void saveClass(){
		try(ObjectOutputStream objSave = new ObjectOutputStream(new FileOutputStream(path))){
			objSave.writeObject(person);
		}catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public Persone  loadeClass() throws ClassNotFoundException{
		try(ObjectInputStream objLoad = new ObjectInputStream(new FileInputStream(path))){
			person = (Persone) objLoad.readObject();
		}catch (ClassNotFoundException | IOException e) {
			//e.printStackTrace();
		}
		
	return person;
		
	}
		
	public static void main(String... arg){
		
		String path = "D:\\PersoneSearilization.ser";
		String path1 = "D:\\PersoneSearilization2.ser";
		String path2 = "D:\\PersoneSearilization3.ser";
		new WorkWithFile(new Persone("Tretyak", "Alexandr", 3400 ),path).saveClass();
		new WorkWithFile(new Persone("Tretyak2", "Alexandr2", 34002 ),path1).saveClass();
		new WorkWithFile(new Persone("Tretyak3", "Alexandr3", 34003 ),path2).saveClass();
		
		try {
			System.out.println(new WorkWithFile(path).loadeClass().toString() + "\n ***");
			System.out.println(new WorkWithFile(path1).loadeClass().toString() + "\n ***");
			System.out.println(new WorkWithFile(path2).loadeClass().toString() + "\n ***");//*/
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
