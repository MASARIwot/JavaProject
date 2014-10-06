/**
 * 
 */
package test;


import jdbccnnection.MyEmployeeList;
import jdbccnnection.MyEmployeeListPreparedStatement;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Саня
 *
 */
public class TestMySQLRequest {

	

	private String arges =null;
	@Before
	public void someOlolo() {
		System.out.println();
	}
	@Test
	public void testSqlConectMyEmployeeList() {
		System.out.println("Test 1");
		MyEmployeeList testMy = new MyEmployeeList();
		testMy.sqlConect();
		System.out.println("Test 1_2");
		arges = "SELECT * from Employee where EMPNO = 7499";
		MyEmployeeList testMy2 = new MyEmployeeList(arges);
		testMy2.sqlConect();
			
		
	}
	
	/**
	 * Test method for {@link jdbccnnection.MyEmployeeListPreparedStatement#sqlConect()}.
	 */
	@Test
	public void testSqlConectMyEmployeeListPreparedStatement() {
		System.out.println("Test 2");
		MyEmployeeListPreparedStatement testMy = new MyEmployeeListPreparedStatement();
		testMy.sqlConect();
		
		
	}


}
