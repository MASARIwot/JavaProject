package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



import box.BoxStringArrayList;
/**
 * @author Саня
 *This class take information from client , processing this information and sent back
 */
public class ServerWorker implements Runnable  {
	private  Socket clientSocket =null;
	/**
	 * @param  Socket clientSocket 
	 * Take Socket address(connection) of client 
	 */
	public ServerWorker(Socket clientSocket){
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		 BoxStringArrayList boxList = new BoxStringArrayList();
		/*
		 * create auto Closing ObjectOutputStream & ObjectInputStream
		 */ 
		try(ObjectOutputStream outToClient = new ObjectOutputStream(this.clientSocket.getOutputStream());
			ObjectInputStream inFromClient = new ObjectInputStream(this.clientSocket.getInputStream());
	        ){
				boxList = (BoxStringArrayList) inFromClient.readObject();
				
				outToClient.writeObject(sort(boxList));
					
		} catch (IOException | ClassNotFoundException | NullPointerException e) {
			throw new RuntimeException(e);	
		}finally{
			try {
				this.clientSocket.close();
				
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	/**
	 * @param box
	 * param Class BoxStringArrayList box
	 * @return  sortList
	 * return Class BoxStringArrayList sortList
	 */
	public BoxStringArrayList sort(BoxStringArrayList box){
		box.setStrBox(BusinessLogic.search(box.getStrBox())); 
		return box;
		
	}

}
