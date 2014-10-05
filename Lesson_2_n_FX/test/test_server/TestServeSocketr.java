package test_server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import box.BoxStringArrayList;

public class TestServeSocketr {
	private BoxStringArrayList boxClass;
	private ArrayList<String> strFoBox;
	
	@Before
	public void init(){
		strFoBox = new ArrayList<String>(Arrays.asList("First","Second","Thert","Tryo","iuy","Facks"));
		boxClass = new BoxStringArrayList(strFoBox);
		
	}
	
	@Test
	public void test() throws UnknownHostException, IOException, ClassNotFoundException {
		java.net.Socket soket;
		int port = 3005;
		 		
		soket = new Socket("localhost",port);
		
		ObjectOutputStream outFromClient = 
				new ObjectOutputStream(soket.getOutputStream());
		ObjectInputStream inToClient = 
				new ObjectInputStream(soket.getInputStream());  
		
		outFromClient.writeObject(boxClass);
		boxClass = (BoxStringArrayList) (inToClient.readObject());
		
			
		System.out.println(boxClass.toString());
		outFromClient.close();
		inToClient.close();
		soket.close();
		
		testStop();
		
	}
	
	
	private void testStop(){
		java.net.Socket clientSocket  = null;
		java.io.OutputStream outbound = null;
		try{
		clientSocket = new Socket("localhost",3006);		
		outbound = clientSocket.getOutputStream();
		outbound.write("Stop Server".getBytes());
		}catch(IOException e){
			
		}finally{
			try {
			outbound.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}//*/

	
	
	
	
	
}
