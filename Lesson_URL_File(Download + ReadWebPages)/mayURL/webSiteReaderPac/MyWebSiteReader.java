package webSiteReaderPac;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class MyWebSiteReader{ 
	private StringBuilder strigFromURL = null;
	private String readString = null;
 	
	public String connect(){
		try(BufferedReader  buff  = 
				new BufferedReader(
						new InputStreamReader(
								new URL("http://finance.yahoo.com/q?s=MOT" )
								.openConnection().getInputStream(), "UTF8"));){ 
			
			strigFromURL = new StringBuilder();
			while((readString = buff.readLine()) != null){
				strigFromURL.append(readString);
				strigFromURL.append("\n");
			}
        
		}catch(MalformedURLException e){
		
		}catch(IOException e){}
	return strigFromURL.toString();
	}
	
    public static void main(String args[]){
		System.out.println(new MyWebSiteReader().connect());
		
	}    
	
	
}	
	
/*
 * 		  url  = new URL("http://finance.yahoo.com/q?s=MOT" );
          urlConn = url.openConnection();
          inStream = new InputStreamReader(urlConn.getInputStream());
          buff  = new BufferedReader(inStream);
 * 
 * */
 