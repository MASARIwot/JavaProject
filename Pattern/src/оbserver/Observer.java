package îbserver;

public class Observer {
	
	public static void main (String []args){
		// Observer Íàáëşäàòåëü
		TestA testA = new TestA();
		TestB testB = new TestB();
		/*
		 * if changed  (TestClass) then it need
		 * to notify the classes (TestA <testA>) (TestB <testB>)
		 */
		TestClass test = new TestClass();
		
		// add classes that observed class TestClass 
		test.addObserver(testA);
		test.addObserver(testB);
		
		for(int i = 0; i < 15; i++){
			test.testPlus();
			test.notifyObservers(); //method that notifies about changs 
		}
				
	}

}
