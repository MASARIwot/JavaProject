package server;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author Саня
 *
 */
	public class BusinessLogic {
		private final static Lock lock = new ReentrantLock();
/** 
 * Return those lines which are longer than the average, and their length.
 * @param ArrayList<String> listStart
 * @return  ArrayList<String> sortedString
 */
		public static  ArrayList<String> search(ArrayList<String> listStart){
				lock.lock();
			try{
				ArrayList<String> sortedString = new ArrayList<String>(); 
				int mean = 0;
				
				for (int i = 0 ; i < listStart.size() ; i ++){
					mean = mean + listStart.get(i).length();
				}
					mean = mean / listStart.size();
				
				for (int i = 0 ; i < listStart.size() ; i ++){
					if(listStart.get(i).length() >= mean){
						sortedString.add(listStart.get(i));
				}
			}
				return sortedString;
			}finally{
				lock.unlock();
			}
		}

}