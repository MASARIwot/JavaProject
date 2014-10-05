package fileDownload;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {
	
	 public static void main(String args[]){
		
		URLConnection urlConnect = null;
        URL url = null;
		try{
			   url = new URL("http://myflex.org/yf/podru/budam385.mp3");
			   urlConnect = url.openConnection();
			   
		  }catch(IOException e){
			  e.printStackTrace();
		  }
		
		try(BufferedOutputStream writeStream = new BufferedOutputStream(new FileOutputStream("XXX.mp3"));
		InputStream inStream = urlConnect.getInputStream();){
			int data =0;
			int data2 =0;
			while((data=inStream.read())!=-1){
				writeStream.write(data);
				data2++;
				if(data2 == 1024*1024){
					System.out.print("|");
					data2 =0;
				}
			}
		System.out.println("\n Finish");				
		}catch(Exception e){
			
		}
	 }
	
}
