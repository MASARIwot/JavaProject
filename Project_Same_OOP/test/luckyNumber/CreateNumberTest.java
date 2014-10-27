package luckyNumber;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import llckynumbers.CreateNumber;
import interfaceForTask.LuckyNumber;

import org.junit.Before;
import org.junit.Test;

public class CreateNumberTest {
	LuckyNumber n1; 
	LuckyNumber n2;	

	@Before
	public void setUp() throws Exception {
		 n1 = new CreateNumber();
		 n2 = new CreateNumber(100);
	}
	@Test
	public void testOfEquals(){
		assertFalse(n1.equals(n2));
		assertTrue(n1.equals(new CreateNumber()));
		assertNotSame(n1.getLuckyNumbers() , n2.getLuckyNumbers());
		assertSame(n1 , n1);
	}
	@Test
	public void numbers(){
		LuckyNumber n3 = new CreateNumber(20);
		ArrayList<Integer> num = new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19));
		for(int i =0; i < n3.getLuckyNumbers().size(); i++ ){
			if(!n3.getLuckyNumbers().contains(num.get(i))) fail("Test Fail");
		}
				
	}
	@Test
	public void nullExep(){
		assertNotNull(n1.getLuckyNumbers());
		assertNotNull(n2.getLuckyNumbers());
		assertNull((new CreateNumber(0)).getLuckyNumbers());
		assertNull((new CreateNumber(1)).getLuckyNumbers());
	}
	

	

}
