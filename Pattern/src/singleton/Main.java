package singleton;

public class Main {
	//Singelton одиночка
	public static void main (String []args){
		
		Singleton singleton = Singleton.getInstance(); //because it static
		SingletonDoubleCheckedLocking singletonDCL = SingletonDoubleCheckedLocking.getInstance();
		
		singleton.getPrint();
		singletonDCL.getPrint();
	}

}
