package businesslogic;

import myexeption.MyExeption;

public class Calculation {

	/**
	 * 
	 * @param a0
	 * @param an
	 * @param r
	 * @return double result of operation
	 * @throws MyExeption
	 * @throws ArithmeticException
	 */
	public static double calculationTask7(double a0 ,double an, double r) throws MyExeption ,ArithmeticException{
		if(r == 1)throw new MyExeption().myExeptioDivByZero();
		double result = (a0 - an*r)/(1- r);
		if(result == 0)throw new MyExeption("Result Of Operation is null!! -> 0");
		return result;
	}

}
