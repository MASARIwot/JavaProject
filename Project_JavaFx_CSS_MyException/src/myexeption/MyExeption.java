package myexeption;
/**
 * My Exeption Class
 * @author Саня
 *
 */
public class MyExeption extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1097664895129394017L;

	public MyExeption(String str){
		super(str);
	}
	public MyExeption(){
		
	}
	
	public MyExeption  myExeptioDivByZero(){
		return new MyExeption("divide by zero error");
	}

}
