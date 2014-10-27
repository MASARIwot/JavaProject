package jdbccnnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class MyEmployeeListPreparedStatement {
	/*
	 * For a connection with sql
	 * */
	private Connection connection = null;
	/*
	 * For parameterized SQL query class is used PreparedStatement.
	 */
	private PreparedStatement  preparedStatment = null;
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
	
	public MyEmployeeListPreparedStatement(){
		url = "jdbc:derby://localhost:1527/Lesson22";
		// Build an SQL String 
		sqlQuery = "SELECT * from Employee where ENAME = ?";
		
	}
	
	public void sqlConect(){
		try {
			// Load the JDBC driver 
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			connection = DriverManager.getConnection(url);
			 // Create a PreparedStatement object
			preparedStatment = connection.prepareStatement(sqlQuery);
			/*Setting parameter values(Looking for name "John Smith"). 
			 *  Does not start with 0, it star from 1!!!
			 */
			preparedStatment.setString(1, "John Smith");
			 // Execute SQL and get obtain the ResultSet object. 
			result = preparedStatment.executeQuery();
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
				connection.close();
				preparedStatment.close();
				result.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
