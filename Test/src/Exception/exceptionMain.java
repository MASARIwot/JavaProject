package Exception;

//import javax.swing.JApplet;

public class exceptionMain  {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 3162225948819192534L;

	public static void main (String []args) {
	
		aExep a = new aExep();
		int ab = 9;
		int b = 0;
		int c = 0;
		//**********************
		
		try{
			double r = a.pow(-9);
			a.f();
			System.out.println(r);
		}catch(Exception e1){
			System.out.println("-1- example");
			e1.printStackTrace();
		}
		
		//**********Some another************
		try{
		Thread.sleep(6);
		 c = ab/b;
		 System.out.println(" c = "+ c);
		}catch (InterruptedException e){
			System.out.println(" -2- example");
			e.printStackTrace();
		}catch(ArithmeticException e){
			System.out.println(" -3- example");
			e.printStackTrace();
		}finally{
			System.out.println(" All Done");
		}
		
		System.out.println(" ************MyException************/");
		
		try {
			a.pow(-7);
		} catch (MyException e) {
			System.out.println(" -4- example");
			e.startExep();
		}finally{
		 System.out.println(" All Done/as a rule It used to free memory");
		}
		
		//**********************
		
		
	}

}
