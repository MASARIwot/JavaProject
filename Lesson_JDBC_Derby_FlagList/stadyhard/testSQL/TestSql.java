package testSQL;

import interfaces.InterfaceOfListOfFlag;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import flagbox.FlagBox;
import sqlconnect.MyFlatList;

public class TestSql {

	InterfaceOfListOfFlag testMyFo2_3 = new MyFlatList();
	@Test
	public void testMySqlConect() {
		InterfaceOfListOfFlag testMy = new MyFlatList();
		ArrayList<FlagBox> listFlagBox = new ArrayList<FlagBox>();
		System.out.println("Test 1");
		try {
			listFlagBox = testMy.getAllFlag();
												
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}/*try*/
		System.out.println(listFlagBox.toString());
		/*int ddd = listFlagBox.size();*/ 
			for(FlagBox tests: listFlagBox ){
				System.out.println(tests.equals(listFlagBox.get(1/*--ddd*/)));
				
			}/*for*/
		System.out.println("Test 2");
		try {
			listFlagBox = testMy.sqlReqvestForRoomsOnSqvereMoreThan("5", "100");
											
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}/*try*/
		System.out.println(listFlagBox.toString());
		System.out.println("Test 3");
		try {
			listFlagBox = testMy.sqlReqvestForSqvereMoreThan("113");
											
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				testMy.closeSQL();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}/*try*/
		System.out.println(listFlagBox.toString());	
		
	}/*testMySqlConect*/

}/*TestSql*/
