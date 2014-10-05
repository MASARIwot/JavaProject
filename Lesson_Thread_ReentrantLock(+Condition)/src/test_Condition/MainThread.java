package test_Condition;

public class MainThread {
	
	
	
	@SuppressWarnings("unused")
	public static void main (String []args){
	InfoClassForTestAandB test = InfoClassForTestAandB.getInstance();
	
	TestA a = new TestA();
	Thread b = new Thread(new TestB());
	
	TestA a2 = new TestA();
	Thread b2 = new Thread(new TestB());
	
	a.start();
	b.start();
	a2.start();
	b2.start();
	
	try {
		b2.join();
		a2.join();
		b.join();
		a.join();
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println("Finish ");
	
	}
}
