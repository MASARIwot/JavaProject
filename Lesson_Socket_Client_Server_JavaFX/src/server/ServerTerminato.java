package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author Саня
 * this a daemon Thread who's listening Client . 
 * When will came request from client it  terminate ServerSocketMy( mein server) in class Main. 
 * Port can be set in a constructor. Standard port 3006
 */
public class ServerTerminato extends Thread {
	private ServerSocket soketServer;
	/**
	 * @param port
	 * port of ServerSocket
	 */
	public ServerTerminato(int port){
		setDaemon(true);
		setName("Server Trminator");
		
		try {
			soketServer = new ServerSocket(port);
		} catch (IOException e) {
			 throw new RuntimeException(e);
		}
		
	}
	
	public ServerTerminato(){
		this(3006);
		
	}
	
	@Override
	public void run() {
		System.out.println("Server Terminato listen: " + soketServer.getLocalPort() + ","+ soketServer.getInetAddress());
		Socket soketClient = null;
		try {
			/*
			 * wait for client request
			 */
			soketClient = soketServer.accept();
		} catch (IOException e) {
			throw new RuntimeException(e);
		 	}
		/*
		 * create auto Closing BufferedReader & InputStreamReader
		 */
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(soketClient.getInputStream()))){
		String str = reader.readLine();
		System.out.println("Server will be Stop:" + str);
		/*
		 * close server
		 */
		soketClient.close();
			
		}catch(IOException e){ 
			e.printStackTrace();
			}finally{
				try {
					soketClient.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		
		
		
	}

}
