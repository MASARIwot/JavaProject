package getStokQoutes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StockQoutesNet {
	
	public String  getStokQoute(String corp){
		URL url = null;
		URLConnection urlConn = null;
		String readFromUrl = null;
		
		try {
			url = new URL("http://quote.yahoo.com/d/quotes.csv?s="
							+ corp + "&f=sl1d1t1c1ohgv&e=.csv" );
			urlConn = url.openConnection();
		} catch (IOException e){e.printStackTrace();}
		
		try(BufferedReader buff = new BufferedReader(
				new InputStreamReader(urlConn.getInputStream()));
				){
			readFromUrl = buff.readLine();
			
		}catch(IOException e2){e2.toString();}
	
		return readFromUrl;	
	}
	
	public ArrayList<String> tokenizer(String str){
		ArrayList<String> arr = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(str, ",");
		arr.add(token.nextToken());
		arr.add(token.nextToken());
		arr.add(token.nextToken());
		arr.add(token.nextToken());
		
		return arr;
	}
	
	public static void main(String args[]){
	//IBM
		  if (args.length==0){
	          System.out.println("Sample Usage: java StockQuote IBM");
	          System.exit(0);
	       } 
		  
		 StockQoutesNet start = new StockQoutesNet();
		 System.out.println(start.tokenizer(start.getStokQoute(args[0])).toString());
		
	}

}
