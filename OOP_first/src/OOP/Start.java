//add 29.06.2014

package OOP;
import Interfaces.Work;
public class Start {

	public static void main(String[] args)  throws ClassNotFoundException  {
		
		/*
		 *  TimeWork - have a fixed salary
		 *  workFree - a hourly salary
		 */
		Work work = new TimeWork();
		Work workFree = new TimeWorkFree();
				
				
		workFree.addWorker("Luke2",		 "Skywalker",	 5, 20);
		workFree.addWorker("Leia2",		 "Princess",	 6, 15);
		workFree.addWorker("Solo2",		 "Han",			 8, 19);
		workFree.addWorker("Obi-Wan2",	 "Kenobi",		 9, 10);
		workFree.addWorker("R2",		 "D2",			 24,26);
		workFree.addWorker("C2",			 "3PO",			 6, 28);
		workFree.addWorker("Hutt2",		 "Jabba",		 6, 28);
		workFree.addWorker("Yoda2",		 "Green",		 6,28);
		workFree.addWorker("Fett2",		 "Boba",		 30,13);
		workFree.addWorker("Tretyak2",	 "Program",		 16,14);
		
		System.out.println("**** ***********Time Work****************** ***");
		workFree.printWorkersSurName();
		workFree.printWorkers();
		
		workFree.sort();
		System.out.println("**** After sorting Salary accending ***");
		workFree.printWorkers();
		System.out.println("**** First 5 worcers ***");
		workFree.printFirst5();
		System.out.println("**** Last 3 ID ***");
		workFree.printIdLast3();
		System.out.println("**** ****************************** ***");
		workFree.printWorkersSurName();
		
		System.out.println("**** ************Write in File Data ***************** ***");
		
		workFree.fileWrite("D:\\Test2.txt");
		
		
		System.out.println("**** ************Standart Work***************** ***");
		
		
		work.addWorker( "Luke", 	 "Skywalker", 	22);
		work.addWorker( "Leia", 	 "Princess",	35);
		work.addWorker( "Solo",	 	 "Han ", 		15);
		work.addWorker( "Obi-Wan",   "Kenobi",		11);
		work.addWorker( "R2",	 	 "D2",  		35);
		work.addWorker( "C", 		 "3PO",  		55);
		work.addWorker( "Hutt", 	 "Jabba", 	 10);
		work.addWorker( "Yoda",	 	 "Green", 	 30);
		work.addWorker( "Fett", 	 "Boba", 	 41);
		work.addWorker( "Tretyak",	 "Program",  25);//*/
		
		System.out.println("**** ****************************** ***");
		work.printWorkers();
		work.sort();
		System.out.println("**** After sorting Salary accending ***");
		work.printWorkers();
		System.out.println("**** First 5 worcers ***");
		work.printFirst5(); 
		System.out.println("**** Last 3 ID ***");
		work.printIdLast3();
		work.printWorkersSurName();
		
		//********************************
		
		
		//********************************

		System.out.println("****Full Name in such way(TimeWork)****************************");
		work.printWorkersNameSurName();
		System.out.println("****Full Name in such way (TimeWorkFree)***888*************************");
		workFree.printWorkersNameSurName();
		
		
		System.out.println("*************READ*************************************");
		work.addWorker( "Yoda2",	 	 "Green2", 	 30);
		work.addWorker( "Fett2", 	 "Boba2", 	 41);
		work.addWorker( "Tretyak2",	 "Program2",  25);
		System.out.println("**** ************Write in File Data ***************** ***");
		work.fileWrite("D:\\Test1.txt");
		
		//*****-Test
		workFree.addWorker("TEST",		 "Boba",		 30,13);
		workFree.addWorker("Tretyak",	 "TEST",		 16,14);
		workFree.writeFileFreeWorkes("D:\\PersonComposition2.txt");
		//workFree.readFileFreeWorkes("D:\\PersonComposition.txt");
		//workFree.printWorkersNameSurName();*/
		
		//workFree.writeFileFreeWorkes("D:\\PersonComposition.txt");
		System.out.println("**** ************READ ***************** ***");
		System.out.println("**** ************READ ***************** ***");
		System.out.println("**** ************READ ***************** ***");
		System.out.println("**** ************READ ***************** ***");
		workFree.fileRead("D:\\Test2.txt");
		//workFree.printWorkersNameSurName();
		work.fileRead("D:\\Test1.txt");
		//work.printWorkersNameSurName();	
		work.addWorker( "TEST",	 	 "Green", 	 30);
		work.addWorker( "Fett", 	 "TEST", 	 41);
		work.addWorker( "TEST",	 "Program",  25);//*/
		work.writeFileFreeWorkes("D:\\PersonComposition.txt");
		System.out.println("**** ************TEST ***************** ***");
		System.out.println("**** **************TEST ***************** ***");
		System.out.println("**** **************TEST ***************** ***");
		System.out.println("**** ************TEST *************** ***");
		work.readFileFreeWorkes("D:\\PersonComposition.txt");
		work.printWorkersNameSurName();	
	//	workFree.printWorkersNameSurName();
		System.out.println("**** ************TEST ***************** ***");
		System.out.println("**** **************TEST ***************** ***");
		System.out.println("**** **************TEST ***************** ***");
		System.out.println("**** ************TEST *************** ***");
		workFree.readFileFreeWorkes("D:\\PersonComposition2.txt");
		workFree.printWorkersSurName();
	}

}
