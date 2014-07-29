package First_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* ”двой слова
1. ¬веди с клавиатуры 10 слов в список строк.
2. ћетод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. »спользу€ цикл for выведи результат на экран, каждое значение с новой строки.
*/
public class DoubleValues {
	
	public static void main(String[] args) throws Exception {
       
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<String> list = new ArrayList<String>();
        
        System.out.println("Arraylist- 10 line : ");
        	for (int i = 0; i < 10; i++){
           		System.out.print("["+  i +"] = ");
        		list.add(reader.readLine());
           	}
        
        System.out.println("Arraylist in : ");
        someStandartMethod.printArrr(list);
        System.out.println("\n");
        ArrayList<String> result = doubleValues(list);
        //******1********
        System.out.print("\nAfter 1 : ");
        someStandartMethod.printArrr(result);
        //******3********
        System.out.println("\n");
        result =  doubleValues3(list);
        System.out.print("\nAfter 3 : ");
        someStandartMethod.printArrr(result);
        //*****2*******
        System.out.println("\n");
        System.out.print("\nAfter 2 : ");
        doubleValuesListSet(list); 
        
    }
////-----------------------Standart-----1-----------------------------------------------------------
	private static  ArrayList<String> doubleValues(ArrayList<String> list) {
		ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++){
				list2.add(list.get(i)+ list.get(i));
			}
		return list2;
	}
	////---------------------------2------------------------------------------------------------
	/*
	 * ћетод set() - замена элемента
	 */
	private static void doubleValuesListSet(ArrayList<String> list) {
			for (int i = 0; i < list.size(); i++){
				list.set(i,list.get(i)  +","+ list.get(i));
			}
	 someStandartMethod.printArrr(list);	
		//return list;
	}
////---------------------------3------------------------------------------------------------
	private static  ArrayList<String> doubleValues3(ArrayList<String> list) {
		ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++){
				list2.add(list.get(i));
				list2.add(list.get(i));
		}
	return list2;
	}
	
}
