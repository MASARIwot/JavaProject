package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import flagbox.FlagBox;

public interface InterfaceOfListOfFlag {

	/**
	 * This method is update SQL seting
	 * @param url String - URl for SQl Server - Like it: "jdbc:derby://localhost:1527/Lesson4";
	 * @param sqlDriver - Like this: "org.apache.derby.jdbc.ClientDriver"
	 */
	void updateSql(String url, String sqlDriver);/*updateSql*/

	/**
	 * @return ArrayList<FlagBox>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 ArrayList<FlagBox> getAllFlag() throws SQLException,
			ClassNotFoundException;/*getAllFlag*/

	/**
	 * @param sqvereMoreThet  sqlReqvestForSqvere("123");
	 * @return ArrayList<FlagBox>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 ArrayList<FlagBox> sqlReqvestForSqvereMoreThan(
			String sqvereMoreThet) throws SQLException, ClassNotFoundException;/*sqlReqvestForSqvere*/

	/**
	 * @param rooms
	 * @param sqvereMoreThet
	 * @return ArrayList<FlagBox>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	ArrayList<FlagBox> sqlReqvestForRoomsOnSqvereMoreThan(
			String rooms, String sqvereMoreThet) throws SQLException,
			ClassNotFoundException;/*sqlReqvestForRoomsOnSqvereMoreThan*/

	/**
	 * @param sqlReqvest
	 * @return ArrayList<FlagBox>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 ArrayList<FlagBox> sqlReqvestForAnyReqvest(String sqlReqvest)
			throws SQLException, ClassNotFoundException;/*sqlReqvestForAnyReqvest*/

	/**
	 * This method is close SQL conection
	 * @throws SQLException
	 */
	void closeSQL() throws SQLException;/*closeSQL*/

}