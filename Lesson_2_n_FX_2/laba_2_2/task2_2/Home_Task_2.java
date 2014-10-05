package task2_2;

import java.util.ArrayList;

import interface_home2_2.HomeTaskInterface;
import interface_home2_2.HomeTaskVisitorInterface;
/**
 * 
 * @author Саня
 *
 */
public class Home_Task_2 implements HomeTaskInterface {

	@Override
	public ArrayList<String> accept(HomeTaskVisitorInterface nomeVisitor ,ArrayList<String> str) {
		return nomeVisitor.sortIntTask_2(str);

	}

}
