package Interfaces;

public interface Work  {
	
	 public void 	sort();  
	 public void 	printWorkers();
	 public void 	printFirst5();
	 public void 	printIdLast3(); 
	 public void 	fileRead(String path) throws ClassNotFoundException;
	 public void 	fileWrite(String path);
	 public void    printWorkersSurName();
	 public void	printWorkersNameSurName();
	 public void 	addWorker(String name , String surName , int salary );
	 public void 	addWorker(String name, String surName, double timeOfWork , int timeSalary );
	 public void 	writeFileFreeWorkes(String path);
	 public void    readFileFreeWorkes (String path);
	

}


