package reflection;

import java.lang.reflect.Method;
//import annotation.SqlAnnotation;


public class ReflectMyFlatList {
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		
		try {
			/*
			 * Take Class for looking*/
			Class testClass = Class.forName("sqlconnect.MyFlatList");
			/*
			 * look for method in class*/		
			Method method[] = testClass.getDeclaredMethods();
			/*
			 * Print method*/
			for (int i = 0; i < method.length; i++){
	            System.out.println("--- Method Signature:" +  method[i].toString());
	            System.out.println(" Return type::" +  method[i].getReturnType().toString());
	       }/*for*/
			/*
			 * Look for Anotations
			 * Check every method of the class.If the annotation is present,
			 * print the values of its parameters
			 * */
			System.out.println("\n\n\n Annotonation");
			for (Method m: method){
				if (m.isAnnotationPresent(annotation.SqlAnnotation.class)){
					annotation.SqlAnnotation jdbcAnnotation = m.getAnnotation(annotation.SqlAnnotation.class);
					
					System.out.println("Method: " + m.getName() +
						" sqlQvery: "+jdbcAnnotation.sqlQvery()); 
									
				}
			}/*for*/
			
			/*
			 * look for superClass*/
			testClass.getSuperclass();
			System.out.println("\nSuper Class Name: " + testClass.getName());
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}/*main*/

}
