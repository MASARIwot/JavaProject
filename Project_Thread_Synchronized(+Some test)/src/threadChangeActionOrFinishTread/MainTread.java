package threadChangeActionOrFinishTread;

public class MainTread {
	public  static int valueToPrint = 0;
	private static SomeActionIncrementOrDecrement foFirst1;
	
	public static void main(String[] args){
		foFirst1 = new SomeActionIncrementOrDecrement();
		Thread foFirst = new Thread(new SomeActionIncrementOrDecrement()); 
		//Thread first = new Thread(foFirst); 
		 
		foFirst.start();
		
		for(int i  = 0; i < 5; i++){
			System.out.println("");				
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}//*/
			
			foFirst1.changeAction();
		}
		    foFirst1.finish();
		//foFirst.stop(); //in that way can be done without foFirst.finish();
		
	}

}
