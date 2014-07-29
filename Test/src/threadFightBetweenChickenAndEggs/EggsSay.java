package threadFightBetweenChickenAndEggs;

public class EggsSay extends Thread {
	
	
	public void run() {
		for(int i = 0; i < 10; i++){
		Counter.currentSleep();	
		System.out.println("ßיצו! :: " + Counter.getI());
		}
		
	}

}
