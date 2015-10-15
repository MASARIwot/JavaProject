package calculator;
/**
 * Example of calculator with enum based operation 
 * @author Otretiak
 *
 */
public class Calculator{
	/**
	 * 
	 * @param operation
	 * @param first number
	 * @param second number or degree (2 or 3)
	 * @return double
	 * @throws ArithmeticException
	 */
	public static double calculate(Operation operation, double first, double second)
			throws ArithmeticException {
		
		return operation.calculate(first, second);
	}
	

	
}
