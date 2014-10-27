package socketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(java.lang.String[] args) {
		/*
		 * Take arguments from command line
		 * And ceacking it    
		 */
		if (args.length==0){
			   System.out.println("Usage: java Client Symbol");
			          System.exit(-1);
		 } 
		//IBM or AAPL or TX
	 Socket clientSocket  = null;
	try{
		/*
		 * Open a client socket connection to the server
		 * host + port
		 */
		clientSocket = new Socket("169.254.82.46",3000);
		System.out.println("Client: " + clientSocket);
		
	}catch(IOException e){
		System.err.println("IOException: " + e);
	}	
	try(
		/*
		 * Take from server OutputStream
		 * Place where we will send Request
		 * inbound - âõ³äíèé
		 */
		OutputStream outbound = clientSocket.getOutputStream();		
		BufferedReader 	inbound =new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));	
				){
				/*
				 * Send request on serwer
				 */
			outbound.write((args[0] + "\n").getBytes());
			outbound.flush(); //*******************
			String qoutes;
		 
				while(true){
					/*
					 * Take String from server while true :Answer from server 
					 */
					qoutes = inbound.readLine();
					if (qoutes.length() == 0) continue;
					   /*
					    * If ansver of server = AND -> Terminate the program 
					    */
				       if ("End".equals(qoutes)){
			            break;
			         }
				   System.out.println(qoutes);    
				}
				
			}catch (IOException e) {
				e.printStackTrace();
		}
		
			
	}
		
}
