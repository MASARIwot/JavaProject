package test_Condition;

public class TestB implements Runnable {
	InfoClassForTestAandB test = InfoClassForTestAandB.getInstance();
	@Override
	public void run() {
		try {
			for(int i = 0 ; i < 10; i++)
			test.setTestV(12);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
