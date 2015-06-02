package strings;

import java.io.IOException;


public class RepalaseElement {

//2
	public static String replase(String str){
		
		char[] validData = str.toCharArray();
		for(int i = 0; i < validData.length/2; i++){
			
			char temp = validData[i];
		    validData[i] = validData[validData.length - i - 1];
		    validData[validData.length - i - 1] =  temp;
			
		}
		
		return String.copyValueOf(validData);
	}
	
//1
	public static String replaceRecurs(String  str){
		
		if(str.length() == 0) return "";
	
		return str.substring(str.length()-1) +
				replaceRecurs(str.substring(0, str.length()-1));
	}
	
	
	public static String betterTask (String str){
		if(str.equals(null)) throw new NullPointerException("Enter the String NOT Null");
		if(str.length() == 0) return "<Non symb>";
		if(!str.substring(1,str.length()).contains(String.valueOf(str.charAt(0)))
				&& !String.valueOf(str.charAt(0)).equals(" ") ){
			return String.valueOf(str.charAt(0));
		}else
			return betterTask(str.replace(String.valueOf(str.charAt(0)),""));
		}
	
	
	
	public static class TestClass {

		public static void main(String[] args) throws IOException {

			String str = " qqwweerrttyy 0 uyiuooi55666ellggw3dd";
	System.out.println(betterTask(str));
	System.out.println(replaceRecurs(str));
//			System.out.println(RepalaseElement.replaceRecurs(str));
//			System.out.println(RepalaseElement.replase(str));
//			//or that way
////3
//			 String b = new StringBuffer(str).reverse().toString();
//			 System.out.println(b);
			
		}
	}// TestClass
}
