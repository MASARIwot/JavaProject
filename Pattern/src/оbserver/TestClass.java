package îbserver;

import java.util.Observable;

public class TestClass extends Observable{
	/*
	 * Observable this class
	 */
	private int test = 0;
	
	public void testPlus(){
		test++;
		super.setChanged(); 
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
		super.setChanged(); 
/*  super.setChanged(); 
 *  says that the data has been changed to Observer
 *  called in place(method) where state of class has changed
 */
	}

}
