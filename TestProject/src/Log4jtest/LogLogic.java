package fortest;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;

import org.apache.log4j.Level;

public class LogLogic {
	
	private static final Logger logger = Logger.getLogger(LogLogic.class);
//	private static final Ext logdger = ExtLogger.create(LogLogic.class);
	
	public LogLogic(){
		init();
	}
	private void init(){
		
		logger.log(Level.DEBUG, "init");
		}
	
	public void someAction(){
		logger.log(Level.ERROR , "Fuckihg sheet");
		System.out.println("same tr");
	}
	
	public void someMoreAction(){
		logger.log(Level.INFO , " it is not Fuckihg sheet");
		System.out.println("same imb");
	}

}
