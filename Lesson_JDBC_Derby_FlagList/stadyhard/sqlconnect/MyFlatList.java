package sqlconnect;
import interfaces.InterfaceOfListOfFlag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import flagbox.FlagBox;

/**
 * This a My littelPool connection to the JDBC
 * Program is connect to derby To the table Flag and save(throw) result in ArrayList<FlagBox>
 * FlagBox it*s a class what save Flag data
 * @see  flagbox.FlagBox
 * @author Саня
 *
 */
public class MyFlatList implements InterfaceOfListOfFlag {
	/*
	 * For a connection with sql
	 */
	private Connection connection = null;
	/*
	 * For sending request. It will contein(save) sql request *SELECT FROM...*
	 */
	private Statement statment = null;
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
	/*
	 * Drayver
	 */
	private String sqlDriver = null;
	
	public MyFlatList(){
		this.url = "jdbc:derby://localhost:1527/Lesson4";
		this.sqlDriver = "org.apache.derby.jdbc.ClientDriver";
	}/*MyFlatList*/
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#updateSql(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateSql(String url,String sqlDriver){
		this.sqlDriver = sqlDriver;
		this.url = url;
	}/*updateSql*/
	/**
	 * @return Connection initSQl()
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection initSQl() throws ClassNotFoundException, SQLException{
		if(connection == null){
		Class.forName(sqlDriver);
		connection = DriverManager.getConnection(url);
		return connection;
		}else return connection;
		
	}/*initSQl*/	
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#getAllFlag()
	 */
	@Override
	public ArrayList<FlagBox> getAllFlag() throws SQLException ,ClassNotFoundException{
		    connection = initSQl();
		    this.sqlQuery = "SELECT * from Flat"; /*Same standart Qvery*/
			statment = connection.createStatement();
			result = statment.executeQuery(sqlQuery);
	return getResult(result);		
	}/*getAllFlag*/
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#sqlReqvestForSqvereMoreThan(java.lang.String)
	 */
	@Override
	public ArrayList<FlagBox> sqlReqvestForSqvereMoreThan(String sqvereMoreThet)throws SQLException ,ClassNotFoundException{
		    String sqlQ = "SELECT * from Flat WHERE SQVERE > ?";
		    connection = initSQl();
		    preparedStatment = connection.prepareStatement(sqlQ);
		    preparedStatment.setString(1, sqvereMoreThet);
			result = preparedStatment.executeQuery();
			return getResult(result);
	}/*sqlReqvestForSqvere*/
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#sqlReqvestForRoomsOnSqvereMoreThan(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<FlagBox> sqlReqvestForRoomsOnSqvereMoreThan(String rooms,String sqvereMoreThet)throws SQLException ,ClassNotFoundException{
		 String sqlQ = "SELECT * FROM Flat WHERE ROOMS >= ? AND SQVERE > ?";
		    connection = initSQl();
		    preparedStatment = connection.prepareStatement(sqlQ);
		    preparedStatment.setString(1, rooms);
		    preparedStatment.setString(2, sqvereMoreThet);
			result = preparedStatment.executeQuery();
			return getResult(result);
   }/*sqlReqvestForRoomsOnSqvereMoreThan*/
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#sqlReqvestForAnyReqvest(java.lang.String)
	 */
	@Override
	public ArrayList<FlagBox> sqlReqvestForAnyReqvest(String sqlReqvest)throws SQLException ,ClassNotFoundException{
		    connection = initSQl();
			statment = connection.createStatement();
			result = statment.executeQuery(sqlReqvest);
			return getResult(result);
	}/*sqlReqvestForAnyReqvest*/
	/**
	 * @param res (ResultSet)
	 * @return ArrayList<FlagBox> listFlagBox
	 * @throws SQLException
	 */
	private ArrayList<FlagBox> getResult(ResultSet res) throws SQLException{
		ArrayList<FlagBox> listFlagBox = new ArrayList<FlagBox>();
		while(res.next()){
			 int id = res.getInt("ID");
			 int adres = res.getInt("FLATN");
			 int sqvere = res.getInt("SQVERE");
			 int room = res.getInt("ROOMS");
	       	 String streat = res.getString("STREAT");
	         String type = res.getString("TYPE");
			 int timeOfUse = res.getInt("TIME");
		 listFlagBox.add(new FlagBox(id, adres, sqvere, room, streat, type, timeOfUse));
		}//while
		return listFlagBox;
	}/*getResult*/
	/* (non-Javadoc)
	 * @see sqlconnect.InterfaceOfListOfFlag#closeSQL()
	 */
	@Override
	public void closeSQL() throws SQLException {
		try {
			connection.close();
			statment.close();
			result.close();
		} catch (SQLException e) {
		  throw new SQLException();
		}
	}/*closeSQL*/
	

}//MyFlatList
