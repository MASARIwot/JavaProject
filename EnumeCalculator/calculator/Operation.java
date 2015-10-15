package calculator;

/**
 * Implemented interface operator. Which means that all enums must override
 * interface methods
 * 
 * @see Operator.class
 * @author Otretiak
 *
 */
public enum Operation implements Operator {
	
	/**
	 * +
	 */
	ADD {

		@Override
		public double calculate(double first, double second) {
			return first + second;
		}
	},
	/**
	 * -
	 */
	SUBTRACT {

		@Override
		public double calculate(double first, double second) {
			return first - second;
		}
	},
	/**
	 * *
	 */
	MULTIPLICATION {

		@Override
		public double calculate(double first, double second) {
			return first * second;
		}
	},
	/**
	 * //
	 */
	DIVIDE {

		@Override
		public double calculate(double first, double second) {
			if (second != 0)
				return first / second;
			else
				throw new ArithmeticException();
		}
	},
	/**
	 * sqrt
	 */
	ROOT {

		@Override
		public double calculate(double first, double second) {
			if (second == 2)
				return Math.sqrt(first);
			else if (second == 3)
				return Math.cbrt(first);
			else
				throw new ArithmeticException();

		}
	},
	/**
	 * pow
	 */
	DEGREE {

		@Override
		public double calculate(double first, double second) {
			return Math.pow(first, second);
		}
	};

}
