package singleton;
/*
 * Accessing in class did not allocate memory every time.  
 * We can create only one object of this class in main 
 */
public class Singleton {
	/*
	 * create object of this class
	 */
	private static final Singleton instance = new Singleton();  //instance-приклад//= new Singleton();
	/*
	 * private > Forbidden create objects of this class in another class
	 * final:
	 * 	+ Simple and transparent implementation 
		+ Thread 
		- Not lazy initialization
	 */
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		//if(instance == null) instance =  new Singleton(); or = new Singleton(); up up up
		return instance; // or Singleton.instance
	}

	public void getPrint (){
		System.out.println("The Singleton's purpose is to control object creation, \n"
				+ "limiting the number of obejcts to one only. Since there is only one \n"
				+ "Singleton instance, any instance fields of a Singleton will occur \n"
				+ "only once per class, just like static fields. Singletons often \n"
				+ "control access to resources such as database connections or sockets. \n");
		System.out.println("\n For example, if you have a license for only one connection \n"
				+ "for your database or your JDBC driver has trouble with multithreading, \n"
				+ "the Singleton makes sure that only one connection is made or that only\n "
				+ "one thread can access the connection at a time.\n");
	}
}
