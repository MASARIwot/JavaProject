package îbserver;

import java.util.Observable;
import java.util.Observer;

public class TestA implements Observer {
	/*
	 * implements the interface(for he observes) in a class Observer that has 1N method 
	 */
	@Override
	public void update(Observable obsorve, Object arg) {
	/*
	 * notice of the change data in class TestClass	
	 */
		int testClass = ((TestClass) obsorve).getTest();
		System.out.println( "Class A see changes in TestClass -> test =  " + testClass);
		
		
	}

	
}
