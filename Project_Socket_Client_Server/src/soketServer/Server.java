package soketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Server {
	public static void main(java.lang.String[] args) {
	ServerSocket soketServer = null; 
	Socket client = null;
	StockQoutesNet stokQotes = new StockQoutesNet();
	/*
	 * buffering input
	 */
	BufferedReader inbound = null; //inbound - вхідний
	/*
	 * Class OutputStream - is an abstract class that defines the byte stream output
	 */
	OutputStream outbound = null;
	
	try{
		// Create a server socket on port 3000
		soketServer = new ServerSocket(3000 , 0 , InetAddress.getByName("0.0.0.0"));
		System.out.println("Waiting for a quote request...");
		
	while(true){
		/* Wait for a  request
		 * when request will be sent, the program will start to perform the code below
		 */
		client = soketServer.accept();
		/*
		 * After request, we will know where the client
		 * Get a reference(ссылку) to the stream of client
		 */
		inbound = new BufferedReader(new InputStreamReader(client.getInputStream()));	
		/*
		 * Request for client : answer 
		 */
		outbound = client.getOutputStream();	
		/*
		 * Read from InputStream :We will send String
		 */
		String symbol = inbound.readLine();
		/*
		 * Create/Make answer
		 */
		HashMap<String, String> hashmap = stokQotes.qoutes(symbol);
		Iterator<Map.Entry<String, String>> itr = hashmap.entrySet().iterator();
		while (itr.hasNext()){
			outbound.write(((itr.next().toString() + "\n ").getBytes()));
		}
		outbound.write("End\n".getBytes());
		System.out.println(symbol + " - Send Iformation ,Done");
	}
		
	}catch(IOException e){
		System.out.println("Error in Server: " + e);
	}finally{
		try {
			outbound.flush();
			inbound.close();
			outbound.close();
			} catch (IOException e) {
			 System.out.println("StockQuoteServer: can't close streams" + e.getMessage());
		}
       
	}
	
	}	
	
}
