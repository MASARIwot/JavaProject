package jdbccnnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MyEmployeeList {
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
	
	public MyEmployeeList(){
		url = "jdbc:derby://localhost:1527/Lesson22";
		// Build an SQL String 
		sqlQuery = "SELECT * from Employee";
		
	}
	public MyEmployeeList(String args){
		if (args == null){
		     System.out.println("Usage: java ShowAnyData SQLSelectStatement");
		     System.out.println("For example: java ShowAnyData \"Select * from Employee...\"");
		     //System.exit(1);
		   }
		url = "jdbc:derby://localhost:1527/Lesson22";
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
			while(result.next()){
				int empNo = result.getInt("EMPNO");
		       	 String eName = result.getString("ENAME");
		         String job = result.getString("JOB_TITLE");
			     System.out.println(""+ empNo + ", " + eName + ", " + job ); 
							
			}			
			
					
		} catch (SQLException e) {
			System.out.println ("SQLError: " + e.getMessage ()  + " code: " + e.getErrorCode ());

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() +":"); 
			
		}finally{
			try {
				if(result != null)
				result.close();
				connection.close();
				statment.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
