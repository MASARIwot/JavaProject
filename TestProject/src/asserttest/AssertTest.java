package asserttest;


import java.util.ArrayList;



public class AssertTest {

	public static int factorial(int n) {
		// Факториал отрицательного числа не считается
		assert (n >= 0);

//		-ea Run configuration JVM config.
		// Если n превысит 10, то это может привести либо к целочисленному
		// переполнению результата, либо к переполнению стэка.
		assert (n <= 10); 
		

		if (n < 2) {
			return 1;
		}

		return factorial(n - 1) * n;
	}

	public static void main(String[] args) {
		  ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < 12; ++i) {
			
			a.add(factorial(i));
			}
		System.out.println(a.toString());

	}

}
