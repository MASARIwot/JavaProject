package test_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InfoClassForTestAandB {
	private int testV;
	final Lock lock = new ReentrantLock();
	
	final Condition NullValue  = lock.newCondition();
	final Condition NotNullValue = lock.newCondition();
	
	InfoClassForTestAandB(){
		testV = 0;
	}
	/*
	 * Singleton
	 */
	private static InfoClassForTestAandB instance = new InfoClassForTestAandB();
	/*
	 * Singleton
	 */
	public static InfoClassForTestAandB getInstance(){
		if(instance == null){
			synchronized (InfoClassForTestAandB.class) {
				if(instance == null) instance = new InfoClassForTestAandB();
				
			}
		}
		return instance; // or Singleton.instance
	}
	/*
	 * Program
	 */
	public int getTestV() throws InterruptedException {
		lock.lock();
		try{
			while(this.testV == 0 ) NullValue.await(); //while 0
		
		
		System.out.println(Thread.currentThread().getName() + " gets Count:  " + --this.testV);
		NotNullValue.signal();	
		return this.testV;
		
		}finally{
		lock.unlock();
		}
		
		
	}

	public void setTestV(int testV2) throws InterruptedException {
		
		lock.lock();
		try{
			while(this.testV != 0)	NotNullValue.await();	//while not 0
			
			
		System.out.println(Thread.currentThread().getName() + " Set  Count:  " + ++this.testV);
		NullValue.signal();
		
		}finally{
		lock.unlock();	
		}
		
	}

}
