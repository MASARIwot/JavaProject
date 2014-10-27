package threadChangeActionOrFinishTread;

public class MainTreadForInterruption {
	
	private static SomeActionForInterruption goGo;
	
	public static void main(String[] args){
		 goGo = new SomeActionForInterruption();
		 System.out.print("Значення :");
		 goGo.start();
		 for(int i  = 0; i < 5; i++){
				System.out.println("");				
				try{
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				goGo.changeAction();
			}
		 goGo.interrupt();
				
	}

}
