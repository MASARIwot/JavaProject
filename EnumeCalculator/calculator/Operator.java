package calculator;

public interface Operator {
	/**
	 * 
	 * @param first number
	 * @param second number or degree (2 or 3)
	 * @return double
	 * @throws ArithmeticException
	 */
	double calculate(double first,double second) throws ArithmeticException;

}
