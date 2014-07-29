package singleton;

public class SingletonDoubleCheckedLocking {
	
	private volatile static  SingletonDoubleCheckedLocking instance ;//= new SingletonDoubleCheckedLocking();  //instance-приклад//= new Singleton();
	/*
	 * volatile:
	 * The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
		Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.
	 */
	private SingletonDoubleCheckedLocking(){
		
	}
	public static SingletonDoubleCheckedLocking getInstance(){
		if(instance == null){
			synchronized (SingletonDoubleCheckedLocking.class) {
				if(instance == null) instance = new SingletonDoubleCheckedLocking();
				
			}
		}
		return instance; // or Singleton.instance
	}

	public void getPrint (){
		System.out.println("Singleton Double Checked Locking");
		
	}
	
	

}
