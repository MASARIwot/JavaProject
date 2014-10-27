package sqlconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import flagbox.FlagBox;


public class CopyOfMyFlatList {
	/*
	 * For a connection with sql
	 * */
	private Connection connection = null;
	/*
	 * For sending request. It will contein(save) sql request *SELECT FROM...*
	 */
	private Statement statment = null;
	/*
	 * It wall save result of request from sql
	 */
	private ResultSet result = null;
	/*
	 * URl for SQl Server
	 */
	private String url = null;
	/*
	 * Sql Request/
	 */
	private String sqlQuery = null;
	/*
	 * ArraList of FlagBox
	 */
	 
	public CopyOfMyFlatList(){
		url = "jdbc:derby://localhost:1527/Lesson4";
		// Build an SQL String 
		sqlQuery = "SELECT * from Flat";
		
	}
	public CopyOfMyFlatList(String args){
		if (args == null){
		     System.out.println("Usage: java ShowAnyData SQLSelectStatement");
		     System.out.println("For example: java ShowAnyData \"Select * from Employee...\"");
		     //System.exit(1);
		   }
		url = "jdbc:derby://localhost:1527/Lesson4";
		sqlQuery = args;
		
	}
		
	public void sqlConect(){
		try {
			// Load the JDBC driver 
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			connection = DriverManager.getConnection(url);
			 // Create a Statement object
			statment = connection.createStatement();
			 // Execute SQL and get obtain the ResultSet object. 
			result = statment.executeQuery(sqlQuery);
			//Will print aure result
			ArrayList<FlagBox> listFlagBox = new ArrayList<FlagBox>();
			while(result.next()){
				 int ID = result.getInt("ID");
				 int flstN = result.getInt("FLATN");
				 int sqvere = result.getInt("SQVERE");
				 int room = result.getInt("ROOMS");
		       	 String streat = result.getString("STREAT");
		         String type = result.getString("TYPE");
				 int time = result.getInt("TIME");
				 //add Flag to List
				 listFlagBox.add(new FlagBox(ID, flstN, sqvere, room, streat, type, time));
				 System.out.println(" " + ID +" " + flstN + " " + sqvere + " " + room + " " + streat +" " + type +" " + time);
				 							
			}//while			
			System.out.println(listFlagBox.toString());
					
		} catch (SQLException e) {
			System.out.println ("SQLError: " + e.getMessage ()  + " code: " + e.getErrorCode ());

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() +":"); 
			
		}finally{
			try {
				//if(result != null)
				connection.close();
				statment.close();
				result.close();
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}//catch
		}//finally
		
		
	}//sqlConect
	
	
	/*@Override
	protected void finalize() throws Throwable {
		try {
			//if(result != null)
			connection.close();
			statment.close();
			result.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		super.finalize();
	}*/

}//MyFlatList