package threadTest;

public class threadTest2 extends Thread{

	 private  int i = 0; //it can be volatile 
	    
		public int getI (){
			return i++;
		}
		
		public  void run() { // without  synchronized it will be random realization. And! What about yield !?).
			 //or synchronized
			for (int i = 0; i <= 10; i++) {
				
		         System.out.println("i::"+ getI() );
		        // Thread.sleep(100);
		     }
			 System.out.print("\n" );
			 //Thread.yield();
			
		}
	
	
}
