package test;


import interface_home2_2.HomeTaskInterface;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import task2_2.HomeTaskVisitor;
import task2_2.Home_Task_1;
import task2_2.Home_Task_2;

public class tesLogic {

	@Test
	public void test() {
		HomeTaskVisitor test = new HomeTaskVisitor();
		
		System.out.println(test.sortIntTask_2(new ArrayList<String>(Arrays.asList("-1","-2","3","4","-5","6","20","7","8","9","-10"))).toString());
		
		//fail("Not yet implemented");
	}
	
	public void test2() {
	HomeTaskInterface nomeTAsk = new Home_Task_1();
	HomeTaskInterface nomeTAsk2 = new Home_Task_2();
	System.out.println(nomeTAsk.accept(new HomeTaskVisitor() ,(new ArrayList<String>(Arrays.asList("First","Second","Thert" ,"s")))).toString()  );
	System.out.println(nomeTAsk2.accept(new HomeTaskVisitor() ,new ArrayList<String>(Arrays.asList("-1","-2","3","4","5","6","7","8","9","-10"))).toString());
	}
}
