package îbserver;

import java.util.Observable;
import java.util.Observer;

public class TestB implements Observer{
//public class TestB extends TestA{ //it will work)

	@Override
	public void update(Observable obsorve2, Object arg) {
		
		int testClass = ((TestClass) obsorve2).getTest();
	
		if (testClass > 10){
			System.out.println( " \n Class B see changes in TestClass -> test > 10 \n  " );
			((TestClass) obsorve2).setTest((int)testClass - 10);
		}
		
	}
	

}
