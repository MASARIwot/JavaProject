package testdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestConn {

	  //DataBase vars.
    final String username="oleksendr"; //Enter in your db username
    final String password="1q2w3e4r"; //Enter your password for the db
    final String url = "jdbc:mysql://db4free.net:3306/tretiakbd"; //Enter URL w/db name

	/*
	 * For sending request. It will contein(save) sql request *SELECT FROM...*
	 */
	private Statement statment = null;
	/*
	 * For parameterized SQL query class is used PreparedStatement.
	 */
	private PreparedStatement  preparedStatment = null;
	/*
	 * Sql Request/
	 */
	private String sqlQuery = null;
	/*
	 * It wall save result of request from sql
	 */
	private ResultSet result = null;

    //Connection vars
    static Connection connection; //This is the variable we will use to connect to database
	
	public Connection getDataSource() {
		try { //We use a try catch to avoid errors, hopefully we don't get any.
            Class.forName("com.mysql.jdbc.Driver"); //this accesses Driver in jdbc.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try { //Another try catch to get any SQL errors (for example connections errors)
            connection = DriverManager.getConnection(url,username,password);
            //with the method getConnection() from DriverManager, we're trying to set
            //the connection's url, username, password to the variables we made earlier and
            //trying to get a connection at the same time. JDBC allows us to do this.
        } catch (SQLException e) { //catching errors)
            e.printStackTrace(); //prints out SQLException errors to the console (if any)
        }

        return connection;
    }
	
	public String getAllUser() throws SQLException ,ClassNotFoundException{
	    connection = getDataSource();
	    //String df =;
	    this.sqlQuery = "SELECT * from UserTaskR"; /*Same standart Qvery*/
		statment = connection.createStatement();
		result = statment.executeQuery(sqlQuery);
		return getResult(result);
		}	


private String getResult(ResultSet res) throws SQLException{
	String result = "";
	while(res.next()){
		 int id = res.getInt("ID");
		 String userName = res.getString("UserName");
		 String password = res.getString("password");
		 Date date = res.getDate("DateRegistration");
       	 
		 result += id +":"+userName+":" +password +":"+date +"\n";
	
	}//while
	return result;
	}
	
	
	public void closeSQL() throws SQLException {
		try {
			connection.close();
			statment.close();
			if(preparedStatment != null) preparedStatment.close();
			result.close();
		} catch (SQLException e) {
		  throw new SQLException(e.getMessage());
		}
	}/*closeSQL*/
	
	public static class TestClass {

		public static void main(String[] args) throws  ClassNotFoundException, SQLException {
			 TestConn test = 	new TestConn();
			System.out.println(test.getAllUser());
			test.closeSQL();
			
		}
	}
	
}
