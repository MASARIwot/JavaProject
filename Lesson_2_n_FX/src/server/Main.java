package server;
/*
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//*/
public class Main {
	public static void main(java.lang.String[] args) {
		ServerSocetMy serv = new ServerSocetMy();
		new Thread(serv).start(); //*/
		/*ServerSocetMy serv = new ServerSocetMy();
		ExecutorService exServ = Executors.newCachedThreadPool();
		exServ.submit(serv);//*/
		
		ServerTerminato serverMonitor = null;
		try{ 
		serverMonitor = new ServerTerminato();
		serverMonitor.start();
		serverMonitor.join();
		
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			
		}
		System.out.println("Server Stoped");
		serv.makeStop();
		//exServ.shutdown();
		//System.exit(-1);
		//serv.stopServ();
	}
  
}
