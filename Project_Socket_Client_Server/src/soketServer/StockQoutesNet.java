package soketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StockQoutesNet {
	
	public StockQoutesNet(){
		
	}
	
	public HashMap<String, String> qoutes(String symbol){
		return tokenizer(getStokQoute(symbol));
	}
	
	private String  getStokQoute(String corp){
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
	
	private HashMap<String, String> tokenizer(String str){
		HashMap<String, String> hashmap = new HashMap<String, String>();
		 StringTokenizer token = new StringTokenizer(str, ",");
			hashmap.put("Tiker", token.nextToken());
			hashmap.put("Price",token.nextToken());
			hashmap.put("tredeData",token.nextToken());
			hashmap.put("tradeTime",token.nextToken());
	return hashmap;
	}
	
	
}
