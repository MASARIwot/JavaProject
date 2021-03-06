package com;

import java.io.IOException;

public class Fibonacci {

	public Fibonacci() {
	}

	protected int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	public int fiboByRemember(int n) {
		if (n < 2) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			ans = first + second;
			first = second;
			second = ans;

		}

		return ans;
	}

	public int sumEvenNumber(int max) {

		int sum = 0;
		int next = 1;
		while (sum <= max) {
			if (fib(next) < max) {
				if (fib(next) % 2 == 0) {
					sum += fib(next);
				}
			}

			next++;
		}

		return sum;
	}

	public static class TestClass {

		public static void main(String[] args) throws IOException {

			Fibonacci fibo = new Fibonacci();
			System.out.println(fibo.sumEvenNumber(4000000));
			
			
			// 4613732
		}
	}// TestClass

}
