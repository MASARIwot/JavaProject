package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author Саня
 *
 */
public class ServerSocetMy implements Runnable{
	/**
	 * Port 
	 */
	private int port;
	/**
	 * Mark of Server Stop status
	 */
	protected  boolean isStopped  = false;
	private ServerSocket serverSocket;
	private Socket fromClientSocket;
    	
	public ServerSocetMy(){
		/*
		 * standart port
		 */
		this.port = 3005;
	}
	
	public ServerSocetMy(int port){
		this.port = port;
	}

	@Override
	public void run() {
	System.out.println("Opening server socket...");	
	try {
		/*
		 * Conect to the port
		 */
		this.serverSocket = new ServerSocket(this.port);
	} catch (IOException e) {
		 throw new RuntimeException("Cannot open port " + this.port, e);
	}
		while(!serverStatus()){
			System.out.println("Runing Server...");
			try{
				System.out.println("Wait for request...");
				/*
				 * when request will be sent, the program will start to perform the code below
				 * it*s create aure connection and than we will send it to aure thread
				 */
				fromClientSocket = this.serverSocket.accept();
				
				}catch(IOException e){
					if(serverStatus()) {
	                    System.out.println("Server IS Stopped.") ;
	                    return;
	                }
	                throw new RuntimeException("Error accepting client connection", e);
				}
			/*
			 * Create Thread whot will work with client 
			 */
			new Thread(
	                new ServerWorker(fromClientSocket)
	            ).start();
		}
		System.out.println("Server Is Stoped");
	}
	/**
	 * Stop Server
	 */
	 public synchronized void makeStop(){
	        this.isStopped = true;
	        try {
	            this.serverSocket.close();
	        } catch (IOException e) {
	            throw new RuntimeException("Error closing server", e);
	        }
	    }
	
	/**
	 * @return the port
	 * return port number
	 */
	public int getPort() {
		return this.port;
	}
	/**
	 * @return  Boolean 
	 * return Server Status
	 */
	public boolean serverStatus(){
		return this.isStopped;
	}
	
}