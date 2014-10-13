package test_businessLogic;


import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;



import server.BusinessLogic;

public class SearchTest {
	
	
	@Test
	public void testSearch() {
		ArrayList<String> testArr = new ArrayList<String>(Arrays.asList("qwert6","qwer5","qwe3","qwerty7","1234t","qwert6","asdfgh7","qazws56"));
		System.out.println(BusinessLogic.search(testArr));
		assertNotSame(testArr , BusinessLogic.search(testArr));
		
		int mean = 0;
		for (int i = 0 ; i < testArr.size() ; i ++){
			mean = mean + testArr.get(i).length();
		}
			mean = mean / testArr.size();
		for(String testarr: BusinessLogic.search(testArr)){
			if(mean > testarr.length()){
				System.out.println(testarr.length() + ":" + testarr);
				fail("Test Fail");
				
			}
						
		}
		
	}
	

}
