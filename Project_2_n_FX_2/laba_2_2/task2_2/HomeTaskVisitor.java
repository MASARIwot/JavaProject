package task2_2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;






import interface_home2_2.HomeTaskVisitorInterface;
/**
 * 
 * @author Саня
 *
 */
public class HomeTaskVisitor implements HomeTaskVisitorInterface {
	/**
	 * @param listString
	 * ArrayList<String> listString
	 * @return sortedString
	 * ArrayList<String> sortedString
	 * 
	 */
	@Override
	public ArrayList<String> sortStringTask_1(ArrayList<String> listString) {
				
			ArrayList<String> sortedString = new ArrayList<String>(); 
			int mean = 0;
			
			for (int i = 0 ; i < listString.size() ; i ++){
				mean = mean + listString.get(i).length();
			}
				mean = mean / listString.size();
			
			for (int i = 0 ; i < listString.size() ; i ++){
				if(listString.get(i).length() >= mean){
					sortedString.add(listString.get(i));
				}
			}
			
	return sortedString;
	}
	/**
	 * @param listInteger
	 * ArrayList<String> listInteger
	 * @return listInteger
	 * ArrayList<String> listInteger: minElement + summ
	 */
	@Override
	public ArrayList<String> sortIntTask_2(ArrayList<String> listInteger) {
		List<Integer> arrayOfInts = new ArrayList<Integer>();
		for (Object str: listInteger){
			arrayOfInts.add(Integer.parseInt((String)str));
			
		}
			
		//java.util.Iterator<Integer> iteratorOfArr = arrayOfInts.iterator();
		int first = 0;
		int second =0;
		int iterato =0;
		for(int i = 0; i < arrayOfInts.size(); i++ ){
			if( arrayOfInts.get(i) > 0){
				second = i;
			}
			if( arrayOfInts.get(i) > 0){
				if(iterato == 1) continue;
					first = i;	
					iterato = 1;
			}
		}
		int result = arrayOfInts.get(second);
		while(first < second){
			result += arrayOfInts.get(first++);
			
		}	
		
		Collections.sort(arrayOfInts,new Comparator<Integer>(){
           
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}});
		
		int minEleme = arrayOfInts.get(arrayOfInts.size() - 1);
		listInteger = new ArrayList<String>(Arrays.asList("Min Element:" + String.valueOf(minEleme) + "\n" , "Suma:" + String.valueOf(result) +"\n Sorted Arr:"+ arrayOfInts.toString()));
		
		return listInteger;
	}

	



}
