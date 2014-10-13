package test_businessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import box.BoxStringArrayList;

public class TestStringBox {
	private BoxStringArrayList boxClass;
	private ArrayList<String> strFoBox;

	@Before
	public void init(){
		strFoBox = new ArrayList<String>(Arrays.asList("First","Second","Thert"));
		boxClass = new BoxStringArrayList(strFoBox);
	}
	@Test
	public void test() {
		System.out.println(boxClass.toString());
		assertTrue(boxClass.equals(new BoxStringArrayList(new ArrayList<String>(Arrays.asList("First","Second","Thert")))));
		assertFalse(boxClass.equals(new BoxStringArrayList(new ArrayList<String>(Arrays.asList("First","Second","Thert","Forthe")))));
		
	}

}
