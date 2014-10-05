package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import box.BoxStringArrayList;
/**
 * 
 * @author Саня
 *  StringTokenizer sume String and write in Object:BoxStringArrayList
 *  Send Object:BoxStringArrayList on Server
 *  Get(return) from server Object:BoxStringArrayList whis sorted ArrayList<String>()
 *  StopServer
 *
 */
public class Client {
	/**
	 * Server PORT
	 */
	private  int PORT = 3005;
	/**
	 * Port for Stoping Server
	 */
	private  int STOP_PORT = 3006;
	/**
	 * LocalHost of Server
	 */
	private String HOST ="localhost";
		
	public Client(){
		
	}
	
	/**
	 * StringTokenizer sume String and write in Object:BoxStringArrayList
	 * @param  strIn
	 * param String strIn
	 * @return box.BoxStringArrayList
	 * return Object :BoxStringArrayList
	 */
	public BoxStringArrayList createArrString(String strIn){
		ArrayList<String> arrString = new ArrayList<String>();
		BoxStringArrayList boxClass = new BoxStringArrayList();
		// пробел,\t\n\r,. -разделители
		StringTokenizer strArrv = new StringTokenizer(strIn, " \t\n\r,."); 

		while(strArrv.hasMoreTokens()){ 
			arrString.add(strArrv.nextToken());
				
		}
		boxClass.setStrBox(arrString);
		return boxClass;
	}	
	/**
	 * Send Object:BoxStringArrayList on Server
	 * Get(return) from server Object:BoxStringArrayList whis sorted ArrayList<String>()
	 * @param  boxClass
	 * param BoxStringArrayList boxClass
	 * @return boxClass.getStrBox();
	 * return ArrayList<String>
	 * 
	 */
	public ArrayList<String> sendToServer(BoxStringArrayList boxClass) throws NullPointerException{
		java.net.Socket soket = null;
		try {
			soket = new Socket(HOST,PORT);
		} catch (IOException e1) {
		}
		
		try(ObjectOutputStream outFromClient = 	new ObjectOutputStream(soket.getOutputStream());
			ObjectInputStream inToClient = 	new ObjectInputStream(soket.getInputStream());	
			){ 		
		/*
		 * Send Object		
		 */
		outFromClient.writeObject(boxClass);
		/*
		 * Accept Object
		 */
		boxClass = (BoxStringArrayList) (inToClient.readObject());
		/*
		 * return  ArryList from  BoxStringArrayList.class
		 */
		return boxClass.getStrBox();
		}catch(IOException | ClassNotFoundException e){
			throw new RuntimeException(e);
			
		}finally{
		try {
			soket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		}
		
		
	}
	
	/**
	 * @throws NullPointerException
	 * Close Server(Stopr)
	 */
	public void closeServer() throws NullPointerException{
		java.net.Socket clientSocket  = null;
		java.io.OutputStream outbound = null;
		try{
		clientSocket = new Socket(HOST,STOP_PORT);		
		outbound = clientSocket.getOutputStream();
		outbound.write("Stop Server".getBytes());
		}catch(IOException e){
			
		}finally{
			try {
			outbound.close();
			clientSocket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		}
		
	}
}

