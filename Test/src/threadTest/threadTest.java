package threadTest;

public class threadTest extends Thread {
   private  int i = 0; //it can be volatile 
    
	public int getI (){
		return i++;
	}
	
	public synchronized  void run() { // without  synchronized it will be random realization. And! What about yield !?).
		// synchronized
		for (int i = 0; i <= 10; i++) {
	         System.out.println("i::"+ getI() );
	     }
		
	}
		//Многопоточность 
	

}
