package Exception;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -113952815267003427L; //hz:((
	
	public MyException(){
		System.out.println("It is my class Exaption . it is go in <MyException> and use method <starExp>  printStackTrace:");
		
	}
	public void startExep(){
		printStackTrace();
		System.out.println("Class startExep .");
		
		
		
	}
	
	
}
