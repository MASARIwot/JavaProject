package Exception;

public class aExep {
	public double pow (double a) throws MyException{ // can be many Exp..
		if (a <= 0) throw new MyException(); //Exception();
		return a*a;
	}

	public void f() throws MyException {
		pow(-3);
		
	} 
	
}
