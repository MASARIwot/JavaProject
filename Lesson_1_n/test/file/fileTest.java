package file;

import static org.junit.Assert.fail;
import llckynumbers.CreateNumber;

import org.junit.Test;

public class fileTest {

	
	@Test(expected = Exception.class)
	public void testWriteFile(){
		String path = "rogko" ;
		File.writerFile(null, path);	
	}
	
	@Test(expected = NullPointerException.class)
	public void testWriteFileNullPointExep(){
		String path = null;
		File.writerFile(null, path);		
	}
	
	@Test(expected = Exception.class)
	public void testReadFile(){
		String path = "sdwdf.txt";
		File.readfromFile(path);		
	}
	@Test(expected = NullPointerException.class)
	public void testReadFileNullPointExep(){
		String path = null;
		File.readfromFile(path);		
	}
		
	@Test
	public void fileExists(){
		String path = "D:\\HappyNumbers2.txt";
		File.writerFile(((new CreateNumber()).getLuckyNumbers()), path);
		java.io.File file = new java.io.File(path);
			if(!file.exists()){ 
				fail("file did not exists");
			}
			
	}
	@Test
	public void fileReadAndWrite(){
		java.io.File file = new java.io.File("D:\\HappyNumbers2.txt");
			if(!file.canRead()){ 
				fail("File can not be read");
			}
			if(!file.canWrite()){ 
				fail("file can nit be write");
			}
	}
	
		
	

}
