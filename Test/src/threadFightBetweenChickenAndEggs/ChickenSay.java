package threadFightBetweenChickenAndEggs;

public class ChickenSay implements Runnable {
		
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
		Counter.currentSleep();	
		System.out.println("Курка! :: " + Counter.getI());
		}
		
	}

}
