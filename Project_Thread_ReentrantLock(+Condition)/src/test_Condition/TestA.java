package test_Condition;

public class TestA  extends Thread{
	InfoClassForTestAandB test = InfoClassForTestAandB.getInstance();	
	/*
	 *@see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		
		try {
			for(int i = 0 ; i < 10; i++)
			test.getTestV();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
}
